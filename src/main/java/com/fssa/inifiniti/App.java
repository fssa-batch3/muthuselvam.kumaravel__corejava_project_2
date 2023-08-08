package com.fssa.inifiniti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class App {
	
	public static Connection getConnection() throws SQLException{

		Connection connect = null ;
		String DB_URL;
		String DB_USER;
		String DB_PASSWORD;

		if (System.getenv("CI") != null) {
			DB_URL = System.getenv("DB_URL");
			DB_USER = System.getenv("DB_USER");
			DB_PASSWORD = System.getenv("DB_PASSWORD");
		} else {
			Dotenv env = Dotenv.load();
			DB_URL = env.get("DB_URL");
			DB_USER = env.get("DB_USER");
			DB_PASSWORD = env.get("DB_PASSWORD");
		}
        try {
            connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to connect to the database");
        }
        return  connect ;                          
	}
	
}


	