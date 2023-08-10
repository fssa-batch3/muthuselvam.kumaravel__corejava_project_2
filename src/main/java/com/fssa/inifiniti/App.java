package com.fssa.inifiniti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class App {
	
	public static Connection getConnection() throws SQLException{

		Connection connect = null ;
		String db_Url;
		String db_User;
		String db_Password;

		if (System.getenv("CI") != null) {
			db_Url = System.getenv("db_Url");
			db_User = System.getenv("db_User");
			db_Password = System.getenv("db_Password");
		} else {
			Dotenv env = Dotenv.load();
			db_Url = env.get("db_Url");
			db_User = env.get("db_User");
			db_Password = env.get("db_Password");
		}
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/inifiniti","root", "123456");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to connect to the database");
        }
        return  connect ;                          
	}
	
}


	