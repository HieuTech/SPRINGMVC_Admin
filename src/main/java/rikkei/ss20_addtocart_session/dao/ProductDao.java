package rikkei.ss20_addtocart_session.dao;

import org.springframework.stereotype.Repository;
import rikkei.ss20_addtocart_session.dto.request.AuthenRequest;
import rikkei.ss20_addtocart_session.dto.request.ProductRequest;
import rikkei.ss20_addtocart_session.dto.response.ProductResponse;
import rikkei.ss20_addtocart_session.models.Products;
import rikkei.ss20_addtocart_session.utils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDao {
    ConnectionDB connectionDB = new ConnectionDB();

    public void saveProduct(Products products) {
        Connection connection = connectionDB.getConnection();
        try {
            if(products.getId() == null){
                PreparedStatement preparedStatement = connection.prepareStatement("insert into products (name, price, stock, status, image, category_id) " +
                        "values (?,?,?,?,?,?)");
                preparedStatement.setString(1, products.getName());
                preparedStatement.setDouble(2, products.getPrice());
                preparedStatement.setInt(3, products.getStock());
                preparedStatement.setBoolean(4, products.getStatus());
                preparedStatement.setString(5, products.getImage());
                preparedStatement.setInt(6, products.getCategoryId());
                preparedStatement.executeUpdate() ;
            }else{
                PreparedStatement preparedStatement = connection.prepareStatement("update products set name = ?, price = ?, stock = ?, status = ?, image = ?, category_id = ? where id = ?" +
                        "values (?,?,?,?,?,?,?)");
                preparedStatement.setString(1, products.getName());
                preparedStatement.setDouble(2, products.getPrice());
                preparedStatement.setInt(3, products.getStock());
                preparedStatement.setBoolean(4, products.getStatus());
                preparedStatement.setString(5, products.getImage());
                preparedStatement.setInt(6, products.getCategoryId());
                preparedStatement.setInt(7, products.getId());
                preparedStatement.executeUpdate() ;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionDB.closeConnection(connection);
        }
    }

    public List<ProductResponse> findAllProduct() {
        Connection connection = connectionDB.getConnection();
        List<ProductResponse> productResponseList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from products");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                ProductResponse productResponse = new ProductResponse(resultSet.getInt("id"),resultSet.getInt("category_id"), resultSet.getString("name"),resultSet.getDouble("price"),resultSet.getInt("stock"),resultSet.getBoolean("status"),resultSet.getString("image"));
                productResponseList.add(productResponse);
                return productResponseList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionDB.closeConnection(connection);
        }
        return null;
    }
    public ProductResponse findById(Integer id) {
        Connection connection = connectionDB.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from products where id = ?" );
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return new ProductResponse(resultSet.getInt("id"),resultSet.getInt("category_id"), resultSet.getString("name"),resultSet.getDouble("price"),resultSet.getInt("stock"),resultSet.getBoolean("status"),resultSet.getString("image"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionDB.closeConnection(connection);
        }
        return null;
    }

    public void deleteById(Integer id) {
        Connection connection = connectionDB.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from products where id = ?" );
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionDB.closeConnection(connection);
        }

    }
}
