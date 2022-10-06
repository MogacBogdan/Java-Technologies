package com.example.laboratory1.filters;

import com.example.laboratory1.servlets.PermutationServlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@WebFilter(filterName = "LogFilter", urlPatterns = {"/permutations"})
public class LogFilter implements Filter {
    private static final Logger logger = Logger.getLogger(PermutationServlet.class.getName());
    FileHandler fileHandler;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        try {
            fileHandler = new FileHandler("app.log", true);
            logger.addHandler(fileHandler);
            fileHandler.setFormatter(new SimpleFormatter());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        logger.info("Method : " + request.getMethod());
        logger.info("Address : " + request.getLocalAddr());
        logger.info("Port : " + String.valueOf(request.getLocalPort()));
        logger.info("User-Agent : " + request.getHeader("user-agent"));
        logger.info("Accept-Language : " + request.getHeader("accept-language"));
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry: parameterMap.entrySet() ) {
            logger.info("Params : " + entry.getKey() + " : " + Arrays.toString(entry.getValue()));
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
