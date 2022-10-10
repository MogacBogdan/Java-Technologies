package com.example.laboratory1.filters;

import com.example.laboratory1.wrappers.ResponseWrapper;

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
        String response = "<img src=\"https://media.evo.co.uk/image/upload/v1579014015/evo/2020/01/010-prelude-mk3.jpg\"" +
                " width=\"700\" height=\"500\" alt=\"Honda Prelude\">";

        content += "<h1>Created by Panzariu Ionut-Adrian</h1>";
        content += "<img src=\"https://m.media-amazon.com/images/M/MV5BNGQwMWNlYjItYmFmZi00YzZmLTlkMjEtMzFjMzBjMDZiYzY4XkEyXkFqcGdeQXVyNDQ3MjUyMTk@._V1_.jpg\"" +
                " width=\"700\" height=\"500\" alt=\"CODA\">";


        response += content;
        PrintWriter out = servletResponse.getWriter();
        out.write(response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
