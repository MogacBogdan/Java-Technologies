package com.example.laboratory1.servlets;
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "captchaServlet", value = "/verify")
public class CaptchaServlet extends HttpServlet {
    private static final int HEIGHT = 50;
    private static final int WIDTH = 150;

    public static final String CAPTCHA_KEY =  "captcha_key_name";
    
    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setHeader("Pragma", "no-cache");

        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = image.createGraphics();
        Random r = new Random();
        String token = Long.toString(Math.abs(r.nextLong()), 36);
        String ch = token.substring(0, 6);
        Color c = new Color(0.6662f, 0.4569f, 0.3232f);
        GradientPaint gradientPaint = new GradientPaint(30, 30, c, 15, 25, Color.WHITE, true);
        graphics2D.setPaint(gradientPaint);
        Font font = new Font("Verdana", Font.BOLD, 26);
        graphics2D.setFont(font);
        graphics2D.drawString(ch, 2, 20);
        graphics2D.dispose();

        HttpSession session = request.getSession();
        session.setAttribute(CAPTCHA_KEY, ch);

        if (validParameter(request, "word")) { session.setAttribute("word", request.getParameter("word")); }
        if (validParameter(request, "size")) { session.setAttribute("size", request.getParameter("size")); }
        if (validParameter(request, "category")) { session.setAttribute("category", request.getParameter("category")); }

        File outputFile = new File("captcha.jpg");
        ImageIO.write(image, "jpg", outputFile);

        try {
            request.getRequestDispatcher("captcha.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String captcha = request.getParameter("captcha");
        System.out.println(captcha);
        System.out.println(request.getSession().getAttribute(CAPTCHA_KEY));
        if (!request.getSession().getAttribute(CAPTCHA_KEY).equals(captcha)) {
            doGet(request, response);
        }
        request.setAttribute("word", request.getSession().getAttribute("word"));
        request.setAttribute("size", request.getSession().getAttribute("size"));
        request.setAttribute("category", request.getSession().getAttribute("category"));

        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/permutations");
        requestDispatcher.forward(request, response);
    }

    private boolean validParameter(HttpServletRequest request, String name) {
        return request.getParameterMap().containsKey(name) && !request.getParameter(name).equals("");
    }
}
