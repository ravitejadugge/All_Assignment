package com.mavendemo.pac;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorld extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter pw=resp.getWriter();
        pw.print("Authenticated.. Page ");

        logger.info("logger is working....");



    }
}
