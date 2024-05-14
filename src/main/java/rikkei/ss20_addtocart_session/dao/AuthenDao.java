package rikkei.ss20_addtocart_session.dao;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import rikkei.ss20_addtocart_session.dto.request.AuthenRequest;
import rikkei.ss20_addtocart_session.dto.response.UserResponse;
import rikkei.ss20_addtocart_session.models.Users;
import rikkei.ss20_addtocart_session.utils.ConnectionDB;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@Slf4j
public class AuthenDao {

    ConnectionDB connectionDB = new ConnectionDB();

    public boolean register(AuthenRequest request) {
        Connection connection = connectionDB.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into users (email, password) values (?,?)");
            preparedStatement.setString(1, request.getEmail());
            preparedStatement.setString(2, request.getPassword());
            boolean success = preparedStatement.executeUpdate() > 0;
            if (success) {

                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionDB.closeConnection(connection);

        }
        return false;
    }

    public UserResponse login(AuthenRequest request) {
        Connection connection = connectionDB.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where email = ? and password = ?");
            preparedStatement.setString(1, request.getEmail());
            preparedStatement.setString(2, request.getPassword());

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                return new UserResponse(rs.getInt("id"),

                        rs.getString("email"), rs.getString("password"), rs.getString("phone"), rs.getString("address"), rs.getString("avatar"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionDB.closeConnection(connection);
        }
        return null;
    }
}
