package com.fssa.inifiniti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class App {
	
	public static Connection getConnection() throws SQLException{

		Connection connect = null ;	
        
        String url = "jdbc:mysql://localhost:3306/inifiniti"; 
        String user = "root";
        String password = "123456"; 

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             connect = DriverManager.getConnection(url, user, password);
        }  catch (SQLException | ClassNotFoundException e) {
        	 e.printStackTrace();
          throw new SQLException("Unable to connect to the database");
        }
        return  connect ;     
	}
	
}


	