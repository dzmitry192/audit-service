package com.innowise.sivachenko.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Component
public class ApiGatewayHeaderFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if(Objects.equals(request.getHeader("Is-Proxy-Request"), "true")) {
            filterChain.doFilter(request, servletResponse);
        } else {
            ((HttpServletResponse) servletResponse).setStatus(407);
        }
    }
}
