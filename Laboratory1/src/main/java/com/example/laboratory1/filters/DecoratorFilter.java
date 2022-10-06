package com.example.laboratory1.filters;

import com.example.laboratory1.utils.ResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "ResponseDecorator", urlPatterns = {"/permutations"})
public class DecoratorFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ResponseWrapper wrapper = new ResponseWrapper((HttpServletResponse) servletResponse);
        filterChain.doFilter(servletRequest, wrapper);

        String content = wrapper.toString();
        String response = "<h1>HEADER</h1>";
        content += "<h1>FOOTER</h1>";
        response += content;
        PrintWriter out = servletResponse.getWriter();
        out.write(response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
