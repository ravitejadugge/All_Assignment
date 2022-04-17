package com.mavendemo.pac;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;
public class FilterForAuth implements Filter {

    private static Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("Inside Authenication..");


        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        Optional<Object> authCookie = Optional.empty();

        Cookie[] cookies = ((HttpServletRequest) servletRequest).getCookies();

        boolean isPresent = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("auth") && cookie.getValue().equals("validauth") ) {
                    isPresent = true;
                }
            }
        }

        PrintWriter pw=servletResponse.getWriter();

        if(isPresent) {
            logger.info("is Valid User...");
            filterChain.doFilter(servletRequest,servletResponse);
        } else {
            logger.info("User is Not valid....");
            HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
            httpServletResponse.setStatus(401);
            pw.print("Unauthorized page...");
        }
    }


    public void destroy() {

    }
}
