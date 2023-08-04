package com.qzapp.dev;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Registration_Admin {
	
	static Connection con;
	static PreparedStatement ps;
	
	public static void newUserRegistration() throws ClassNotFoundException
	{
		Scanner sc= new Scanner(System.in);
		
		
		System.out.println("Please enter user name :");
		String userName=sc.next();

		System.out.println("Please enter password :");
		String password=sc.next();
		
		
		userDataInsert(userName,password);

	}
	
	public static void userDataInsert(String userName,String password) throws ClassNotFoundException
	{
		try {
		
		String addNewUserDetails="insert into admin(Username,A_Password)"
									+"values(?,?)";
		
		con=DBConnection.getDBConnection();
		
		ps = con.prepareStatement(addNewUserDetails);
		
		ps.setString(1,userName);
		ps.setString(2,password);
		
		
		int i = ps.executeUpdate();
		System.out.println("!!! Registration Successfull !!!");
		
	
	}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		finally
		{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
