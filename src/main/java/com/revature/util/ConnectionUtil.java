package com.revature.util;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	/* Make tomcat now which database driver to use */
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
//			LogUtil.logger.warn("Exception thrown adding oracle driver.",e);
		}
	}
	private ConnectionUtil() {}
	
	public static Connection getConnection() {
		InputStream in = null;
		
		try {
			Properties props = new Properties();
//			in = new FileInputStream("src/main/resources/db.properties");
			in = new FileInputStream("/Users/andrewmcgovern/Documents/workspace-sts-3.9.3.RELEASE/ers-project/src/main/resources/db.properties");
			props.load(in);
			return DriverManager.getConnection(props.getProperty("jdbc.url"), 
					props.getProperty("jdbc.username"), props.getProperty("jdbc.password"));
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getSQLState());
			System.err.println(e.getErrorCode());
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return null;
	}

}
