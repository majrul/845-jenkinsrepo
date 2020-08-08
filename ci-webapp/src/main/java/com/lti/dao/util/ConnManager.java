package com.lti.dao.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnManager {

	public static Connection connect() {
		try {
			Properties dbProps = new Properties();
			//how to remove hardcoded filename -- we need to pass the filename as an env variable
			//one option is to pass VM arguments using -D option
			dbProps.load(ConnManager.class.getClassLoader().getResourceAsStream("dev-db.properties"));
			//dbProps.load(new FileReader("dev-db.properties"));
			Class.forName(dbProps.getProperty("driverName"));
			return DriverManager.getConnection(dbProps.getProperty("url"), dbProps.getProperty("user"), dbProps.getProperty("pass"));	
		}
		catch(ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace(); //not good, should be thrown rather
			return null; //very bad, should throw some user defined exception
		}
	}
	
	/*public static Connection connect() {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			return DriverManager.getConnection("jdbc:derby://localhost:1527/trainingdb", "mj", "mj");	
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace(); //not good, should be thrown rather
			return null; //very bad, should throw some user defined exception
		}
	}*/
}
