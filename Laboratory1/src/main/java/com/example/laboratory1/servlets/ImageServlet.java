package com.example.laboratory1.servlets;

import javax.imageio.ImageIO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "imageServlet", value = "/imageServlet")
public class ImageServlet extends HttpServlet {
    private static final String CAPTCHA_IMAGE = "C:\\Users\\IPanzariu\\OneDrive - ENDAVA\\Desktop\\java ee\\apache-tomcat-9.0.67\\bin\\captcha.jpg";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("image/jpeg");

        File f = new File(CAPTCHA_IMAGE);

        BufferedImage bi = ImageIO.read(f);
        OutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        out.close();
    }
}
