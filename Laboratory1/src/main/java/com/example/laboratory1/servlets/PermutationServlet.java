package com.example.laboratory1.servlets;
import com.example.laboratory1.models.Dictionary;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "permutationServlet", value = "/permutations")
public class PermutationServlet extends HttpServlet {
    private static final String WORD_PARAMETER = "word";
    private static final String SIZE_PARAMETER = "size";
    private static final String CATEGORY_PARAMETER = "category";
    private static final String RESULT_PAGE = "result.jsp";
    private static final String PERMUTATIONS_ATTRIBUTE = "permutations";
    private static final String CATEGORY_ATTRIBUTE = "category";
    private static final String CATEGORY_COOKIE_NAME = "PermutationServlet.categoryCookie";

    Dictionary dictionary;
    public void init() {
        dictionary = new Dictionary();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        Map<String, String> validParameters = getValidParameters(request);

        String word = validParameters.get("word");
        String category = validParameters.get("category");
        int size = Integer.parseInt(validParameters.get("size"));

        Cookie categoryCookie = new Cookie(CATEGORY_COOKIE_NAME, category);
        categoryCookie.setMaxAge(60 * 30);
        response.addCookie(categoryCookie);

        List<String> validWords = dictionary.getValidWords(word, size);
        sendPermutationToJSP(request, response, validWords, category);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        Map<String, String> validParameters = getValidParameters(request);

        String word = validParameters.get("word");
        String category = validParameters.get("category");
        int size = Integer.parseInt(validParameters.get("size"));

        List<String> validWords = dictionary.getValidWords(word, size);
        sendPermutationText(response, validWords, category);
    }

    private Map<String, String> getValidParameters(HttpServletRequest request) {
        String word = "";
        String category = "";
        String size = "";

        if (validParameter(request, WORD_PARAMETER)){
            word = request.getParameter(WORD_PARAMETER);
        }
        if (validParameter(request, SIZE_PARAMETER)) {
            size = request.getParameter(SIZE_PARAMETER);
        }
        if (validParameter(request, CATEGORY_PARAMETER)) {
            category = request.getParameter(CATEGORY_PARAMETER);
        } else {
            category = (String) getServletContext().getAttribute(CATEGORY_ATTRIBUTE);
        }
        Map<String, String> parameterMap = new HashMap<>();
        parameterMap.put("word", word);
        parameterMap.put("size", size);
        parameterMap.put("category", category);
        return parameterMap;
    }

    private boolean validParameter(HttpServletRequest request, String name) {
        return request.getParameterMap().containsKey(name) && !request.getParameter(name).equals("");
    }
    private void sendPermutationToJSP(HttpServletRequest request,
                                      HttpServletResponse response,
                                      List<String> permutations,
                                      String category)  {
        try {
            request.setAttribute(PERMUTATIONS_ATTRIBUTE, permutations);
            request.setAttribute(CATEGORY_ATTRIBUTE, category);
            request.getRequestDispatcher(RESULT_PAGE).forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendPermutationText(HttpServletResponse response,
                                     List<String> permutations,
                                     String category) {
        try {
            PrintWriter out = response.getWriter();
            permutations.forEach(out::println);
            out.println("Category is : " + category);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
        super.destroy();
    }
}