package com.fssa.inifiniti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * The App class provides a method to establish a connection to the MySQL database.
 */
public class App { 
	
	/**
	 * Establishes a connection to the MySQL database.
	 *
	 * @return A Connection object representing the database connection.
	 * @throws SQLException If an SQL error occurs during the connection attempt.
	 */ 
	
	public static Connection getConnection() throws SQLException{

		Connection connect = null ;	
      
//     
//     		final String DB_URL = System.getenv("DB_URL_1");
//     		final String DB_USER = System.getenv("DB_USER_1");
//     		final String DB_PASSWORD = System.getenv("DB_PASSWORD_1");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/inifiniti", "root", "123456");
        }  catch (SQLException | ClassNotFoundException e) {
        	e.printStackTrace();
          throw new SQLException("Unable to connect to the database");
        }
        return  connect ;     
	}
	
	
}


	