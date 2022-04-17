package com.database;

import com.Model.Product;
import com.servlet.ProductServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;


public class ConnectionDb {

   public static Statement statement= null ;
    public static Connection connection = null;
    private static Logger logger = LoggerFactory.getLogger(ProductServlet.class);

     public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/JdbcConn","root","admin");
            statement = connection.createStatement();
            if(statement != null){
                System.out.println("Connection success");
            } else  {
                System.out.println("Connection failed ");
            }
            return  connection;

        } catch (Exception exception) {
            System.out.println(exception);
        }

         return connection;
     }


   public static ResultSet getProductList() throws SQLException {
         connection =  getConnection();
        ResultSet resultSet=connection.createStatement().executeQuery("select * from Product");
      //  connection.close();
        return resultSet;
    }

    public static ResultSet crateProductList(Product product) {

    try {
        connection = getConnection();
        statement = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into product values(?,?,?,?,?)");
        preparedStatement.setInt(1,product.getId());
        preparedStatement.setString(2,product.getName());
        preparedStatement.setDouble(3,product.getPrice());
        preparedStatement.setInt(4,product.getQuantity());
        preparedStatement.setString(5,product.getDescription());
       int x =  preparedStatement.executeUpdate();
       if(x > 0){
           logger.info("Successfully created new Product");
       }
            statement.close();
            connection.close();

        } catch (Exception e) {
        logger.info(String.valueOf(e));
        }
      return null;
    }
    public static ResultSet updateProductList(Product product) {

        try {
            connection = getConnection();
            statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE product SET name=?,price=?,quantity=?,descripton=?  WHERE id=" +product.getId());
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getDescription());
           preparedStatement.executeUpdate();

           connection.close();


        } catch (Exception e) {
            logger.info(e.toString());
        }


    return  null;
    }

    public static ResultSet deleteProductList(int id) throws SQLException {
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM product WHERE id=" +id);
        preparedStatement.executeUpdate();
        return null;
    }

    public static ResultSet getProductsSorted() throws SQLException{
        connection = getConnection();
        ResultSet resultSet=connection.createStatement().executeQuery("select * from Product order by name");
       // connection.close();
        return resultSet;


    }


}
