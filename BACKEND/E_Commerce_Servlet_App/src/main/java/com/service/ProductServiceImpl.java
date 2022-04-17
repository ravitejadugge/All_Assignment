package com.service;

import com.Model.Product;
import com.database.ConnectionDb;
import com.servlet.ProductServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService{
    private static Logger logger = LoggerFactory.getLogger(ProductServlet.class);

    @Override
    public List<Product> getProducts() {
        try {
            ResultSet resultSet = ConnectionDb.getProductList();

            List<Product> productList= new ArrayList<>();
            while (resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getInt(1));
                product.setName(resultSet.getString(2));
                product.setPrice(resultSet.getDouble(3));
                product.setQuantity(resultSet.getInt(4));
                product.setDescription(resultSet.getString(5));

                productList.add(product);
            }
            return productList;

        } catch (Exception e) {

        }

        return null;
    }

    @Override
    public Product createProduct(Product product) {

        try {
            ResultSet resultSet = ConnectionDb.crateProductList(product);

        } catch (Exception e) {

        }

        return null;
    }

    @Override
    public Product updateProduct(Product product) {
      try{
          ResultSet resultSet = ConnectionDb.updateProductList(product);

      } catch (Exception e ) {
          logger.info(e.toString());
      }
      return null;
    }
    @Override
    public Product deleteProduct(int id) {
        try{
            ResultSet resultSet = ConnectionDb.deleteProductList(id);
        } catch (Exception e ) {
            logger.info(e.toString());
        }
        return null;
    }
}
