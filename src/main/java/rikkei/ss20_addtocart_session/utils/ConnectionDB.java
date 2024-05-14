package rikkei.ss20_addtocart_session.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String DRIVER ="com.mysql.cj.jdbc.Driver";
    private static final String URL ="jdbc:mysql://localhost:3306/session_addToCart";
    private static final String user ="root";
    private static final String password ="root";


    public Connection getConnection(){

        try {
            Class.forName(DRIVER);
            Connection  connection = DriverManager.getConnection(URL,user,password);
            return connection;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeConnection(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
