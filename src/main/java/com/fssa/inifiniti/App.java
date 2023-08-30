package com.fssa.inifiniti;

import java.sql.*;



public class App {
	
	public static Connection getConnection() throws SQLException{

		Connection connect = null ;		
        try {
        	String passWord = "123456";
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/inifiniti","root", passWord);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Unable to connect to the database");
        }
        return  connect ;                          
	}
	
}


	