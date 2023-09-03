package com.fssa.inifiniti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class App {
	
	public static Connection getConnection() throws SQLException{

		Connection connect = null ;		
//        try {
//        	String passWord = "123456";
//            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/inifiniti","root", passWord);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new SQLException("Unable to connect to the database");
//        }
//        return  connect ;       
        
        
        String url = "jdbc:mysql://localhost:3306/inifiniti"; // Replace with your database URL
        String user = "root"; // Replace with your database username
        String password = "123456"; // Replace with your database password

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
             connect = DriverManager.getConnection(url, user, password);
        }  catch (SQLException | ClassNotFoundException e) {
        	 e.printStackTrace();
          throw new SQLException("Unable to connect to the database");
        }
        return  connect ;     
	}
	
}


	