package com.example.laboratory1.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DefaultCategoryListener implements ServletContextListener {
    private final String DEFAULT_CATEGORY_PARAMETER = "category";

    public void contextInitialized(ServletContextEvent servletContextEvent) {
       ServletContext servletContext = servletContextEvent.getServletContext();
       String defaultCategory = servletContext.getInitParameter(DEFAULT_CATEGORY_PARAMETER);
       servletContext.setAttribute(DEFAULT_CATEGORY_PARAMETER, defaultCategory);
    }
}
