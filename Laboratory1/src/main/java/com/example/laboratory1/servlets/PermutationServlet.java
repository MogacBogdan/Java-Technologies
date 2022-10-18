package com.example.laboratory1.servlets;
import com.example.laboratory1.models.Dictionary;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "permutationServlet", value = "/permutations")
public class PermutationServlet extends HttpServlet {
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

        String word = (String) request.getAttribute("word");
        String category = (String) request.getAttribute("category");
        int size = Integer.parseInt((String) request.getAttribute("size"));

        Cookie categoryCookie = new Cookie(CATEGORY_COOKIE_NAME, category);
        categoryCookie.setMaxAge(60 * 30);
        response.addCookie(categoryCookie);

        List<String> validWords = dictionary.getValidWords(word, size);
        sendPermutationToJSP(request, response, validWords, category);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");

        String word = (String) request.getSession().getAttribute("word");
        String category = (String) request.getSession().getAttribute("category");
        int size = Integer.parseInt((String) request.getSession().getAttribute("size"));

        Cookie categoryCookie = new Cookie(CATEGORY_COOKIE_NAME, category);
        categoryCookie.setMaxAge(60 * 30);
        response.addCookie(categoryCookie);

        List<String> validWords = dictionary.getValidWords(word, size);
        sendPermutationToJSP(request, response, validWords, category);
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
    public void destroy() {
        super.destroy();
    }
}