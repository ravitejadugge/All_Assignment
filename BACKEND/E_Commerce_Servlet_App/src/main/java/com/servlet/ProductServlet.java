package com.servlet;

import com.Model.Product;
import com.database.ConnectionDb;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.service.ProductService;
import com.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import static com.database.ConnectionDb.getProductList;

public class ProductServlet extends HttpServlet {
    private  static final Gson gson = new GsonBuilder().create();
    private static ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Product> list =  productService.getProducts();
            resp.setStatus(201);
            resp.setHeader("Content-Type","application/json");
            resp.getOutputStream().println(gson.toJson(list));

        } catch (Exception e) {

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = gson.fromJson(req.getReader(), Product.class);
        productService.createProduct(product);
        resp.setStatus(201);
        resp.setHeader("Content-Type","application/json");
        resp.getOutputStream().println(gson.toJson(product));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = gson.fromJson(req.getReader(), Product.class);
        productService.updateProduct(product);
        resp.setStatus(201);
        resp.setHeader("Content-Type","application/json");
        resp.getOutputStream().println(gson.toJson(product));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getPathInfo().replace("/",""));
        productService.deleteProduct(id);
        resp.setStatus(201);
        resp.getOutputStream().println(gson.toJson("Successfully Deleted"));
    }
}

