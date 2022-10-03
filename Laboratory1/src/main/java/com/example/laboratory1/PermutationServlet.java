package com.example.laboratory1;
import com.example.laboratory1.DAO.DictionaryDAO;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "permutationServlet", value = "/permutations")
public class PermutationServlet extends HttpServlet {

    private List<String> dictionary;
    private static final Logger logger = Logger.getLogger(PermutationServlet.class.getName());
    FileHandler fileHandler;

    public void init() {
        DictionaryDAO dictionaryDAO = new DictionaryDAO();
        dictionary = dictionaryDAO.getDictionary();

        try {
            fileHandler = new FileHandler("app.log", true);
            logger.addHandler(fileHandler);
            fileHandler.setFormatter(new SimpleFormatter());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        writeToLogFile(request);

        String word = "";
        int size = 0;

        if (validParameter(request, "word")){
            word = request.getParameter("word");
        }
        if (validParameter(request, "size")) {
            size = Integer.parseInt(request.getParameter("size"));
        }

        Permutation permutation = new Permutation();
        List<String> permutations = permutation.getPermutations(word, size);
        sendPermutationsHTML(response, permutations);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        writeToLogFile(request);

        String word = "";
        int size = 0;

        if (validParameter(request, "word")){
            word = request.getParameter("word");
        }
        if (validParameter(request, "size")) {
            size = Integer.parseInt(request.getParameter("size"));
        }

        Permutation permutation = new Permutation();
        List<String> permutations = permutation.getPermutations(word, size);
        sendPermutationJSON(response, permutations);
    }

    private void writeToLogFile(HttpServletRequest request) {
        logger.info("Method : " + request.getMethod());
        logger.info("Address : " + request.getLocalAddr());
        logger.info("Port : " + String.valueOf(request.getLocalPort()));
        logger.info("User-Agent : " + request.getHeader("user-agent"));
        logger.info("Accept-Language : " + request.getHeader("accept-language"));
        Map<String, String[]> params = request.getParameterMap();
        for (Map.Entry<String, String[]> entry: params.entrySet() ) {
            logger.info("Params : " + entry.getKey() + " : " + Arrays.toString(entry.getValue()));
        }
    }

    private boolean validParameter(HttpServletRequest request, String name) {
        return request.getParameterMap().containsKey(name) && !request.getParameter(name).equals("");
    }

    private void sendPermutationsHTML(HttpServletResponse response, List<String> permutations) {
        try {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            for (String permutation: permutations) {
                if (dictionary.contains(permutation)) {
                    out.println("<h1>" + permutation + "</h1>");
                }
            }
            out.println("<a href=\"/Laboratory1_war_exploded/\">Back to the form</a>");
            out.println("</body></html>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendPermutationJSON(HttpServletResponse response, List<String> permutations) {
        try {
            PrintWriter out = response.getWriter();
            for (String permutation: permutations) {
                if (dictionary.contains(permutation)) {
                    out.println(permutation);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}