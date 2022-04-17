package com.servlet;

import com.Model.Product;
import com.database.ConnectionDb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class ProductServletSorted  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ResultSet resultSet =  ConnectionDb.getProductsSorted();
            resp.setStatus(201);
            resp.setHeader("Content-Type","text/html");
            PrintWriter out = resp.getWriter();
            out.write("<h1>Sorted Order </h1>");
            out.write( "<table>");

            out.write("<tr> <th> ID </th> <th> Name </th>  <th> Price </th> <th> Quantity </th> <th> Description </th> </tr>");

            while (resultSet.next()){
                out.write("<tr style='padding:15px;margin:15px'>");

                out.write("<td>"+resultSet.getInt(1)+"</td>");
                out.write("<td>"+resultSet.getString(2)+"</td>");
                out.write("<td>"+resultSet.getDouble(3)+"</td>");
                out.write("<td>"+resultSet.getInt(4)+"</td>");
                out.write("<td>"+resultSet.getString(5)+"</td>");
                out.write("</tr>");
            }

            out.write( "</table>");


        } catch (Exception e) {

        }
    }

}
