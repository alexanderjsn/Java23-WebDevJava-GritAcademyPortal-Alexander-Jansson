package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnector {

    // skapar en connection med null värde
    private static Connection connection = null;


    private DBconnector(){}

    public static Connection getConnection() {
        try{
            // kollar om connection finns eller om en är stängds
            if(connection == null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gritacademy", "root", "103eec29f");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }return connection;
    }
}