package com.example.laboratory1.servlets;
import com.example.laboratory1.models.Dictionary;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "permutationServlet",
            value = "/permutations",
            initParams = {
                @WebInitParam(name = "dark-theme", value="false")
            })
public class PermutationServlet extends HttpServlet {
    Dictionary dictionary;
    public void init() {
        dictionary = new Dictionary();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String word = "";
        int size = 0;

        if (validParameter(request, "word")){
            word = request.getParameter("word");
        }
        if (validParameter(request, "size")) {
            size = Integer.parseInt(request.getParameter("size"));
        }

        sendPermutationToJSP(request, response, dictionary.getValidWords(word, size));
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        String word = "";
        int size = 0;

        if (validParameter(request, "word")){
            word = request.getParameter("word");
        }
        if (validParameter(request, "size")) {
            size = Integer.parseInt(request.getParameter("size"));
        }

        sendPermutationText(response, dictionary.getValidWords(word, size));
    }

    private boolean validParameter(HttpServletRequest request, String name) {
        return request.getParameterMap().containsKey(name) && !request.getParameter(name).equals("");
    }
    private void sendPermutationToJSP(HttpServletRequest request, HttpServletResponse response, List<String> permutations)  {
        try {
            request.setAttribute("permutations", permutations);
            request.getRequestDispatcher("result.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendPermutationText(HttpServletResponse response, List<String> permutations) {
        try {
            PrintWriter out = response.getWriter();
            permutations.forEach(out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void destroy() {
        super.destroy();
    }
}