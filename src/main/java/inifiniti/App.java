package inifiniti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import inifiniti.model.User;

public class App {
	
	public static Connection getConnection() throws SQLException{

		Connection connect = null ;
        String url = "jdbc:mysql://localhost/inifiniti";
        String userName = "root";
        String passWord = "123456";
        try {
            connect = DriverManager.getConnection(url, userName, passWord);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to connect to the database");
        }
        return  connect ;
	}
	
}


