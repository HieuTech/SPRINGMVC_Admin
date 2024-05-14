package rikkei.ss20_addtocart_session.dao;


import org.springframework.stereotype.Repository;
import rikkei.ss20_addtocart_session.dto.request.ProductRequest;
import rikkei.ss20_addtocart_session.dto.request.ShoppingCartRequest;
import rikkei.ss20_addtocart_session.dto.response.ProductResponse;
import rikkei.ss20_addtocart_session.dto.response.ShoppingCartResponse;
import rikkei.ss20_addtocart_session.models.ShoppingCart;
import rikkei.ss20_addtocart_session.utils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ShoppingCartDao {
    ConnectionDB connectionDB = new ConnectionDB();

    public void saveProduct(ShoppingCart request) {
        Connection connection = connectionDB.getConnection();
        try {
            if(request.getId() == null){
                PreparedStatement preparedStatement = connection.prepareStatement("insert into shopping_cart (user_id,product_id,quantity) " +
                        "values (?,?,?)");
                preparedStatement.setInt(1, request.getUserId());
                preparedStatement.setInt(2, request.getProductId());
                preparedStatement.setInt(3, request.getQuantity());

                preparedStatement.executeUpdate() ;
            }else{
                PreparedStatement preparedStatement = connection.prepareStatement("update shopping_cart set user_id = ? ,product_id = ? ,quantity = ? where id = ?" );

                preparedStatement.setInt(1, request.getUserId());
                preparedStatement.setInt(2, request.getProductId());
                preparedStatement.setInt(3, request.getQuantity());
                preparedStatement.setInt(4, request.getId());
                preparedStatement.executeUpdate() ;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionDB.closeConnection(connection);
        }
    }

    public List<ShoppingCartResponse> findAllShoppingCart() {
        Connection connection = connectionDB.getConnection();
        List<ShoppingCartResponse> shoppingCartResponses = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from shopping_cart");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                ShoppingCartResponse shoppingCartResponse = new ShoppingCartResponse(resultSet.getInt("id"),resultSet.getInt("product_id"), resultSet.getInt("user_id"),resultSet.getInt("quantity"));
                shoppingCartResponses.add(shoppingCartResponse);
                return shoppingCartResponses;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionDB.closeConnection(connection);
        }
        return null;
    }
    public List<ShoppingCartResponse> findByUserId(Integer userId) {
        Connection connection = connectionDB.getConnection();
        List<ShoppingCartResponse> shoppingCartResponses = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from shopping_cart where user_id = ?" );
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                ShoppingCartResponse shoppingCartResponse = new ShoppingCartResponse(resultSet.getInt("id"),resultSet.getInt("product_id"), resultSet.getInt("user_id"),resultSet.getInt("quantity"));
                shoppingCartResponses.add(shoppingCartResponse);
                return shoppingCartResponses;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionDB.closeConnection(connection);
        }
        return null;
    }

    public void deleteByUserId(Integer userId) {
        Connection connection = connectionDB.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from shopping_cart where user_id = ?" );
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionDB.closeConnection(connection);
        }

    }

}
