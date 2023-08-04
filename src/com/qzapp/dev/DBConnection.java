package com.qzapp.dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	static Connection con;
	
	
	public static Connection getDBConnection()
	{
	try {
					// load driver class
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					// establish connection
					 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/QzApp","root","root");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return con;
	}
}
