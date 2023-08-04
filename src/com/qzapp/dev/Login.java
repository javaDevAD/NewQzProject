package com.qzapp.dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
	
	static Connection con=null ;
	static PreparedStatement ps=null ;
	static ResultSet rs =null;
	static String usrnm;

	public static boolean verifyUserCreds()
	{
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter username");
		usrnm=sc.next();
		
		System.out.println("Enter password");
		String pwd=sc.next();
		
		String pwdDB=Login.validateCreds(usrnm,pwd);
		
		if(pwd.equals(pwdDB))
		{
			System.out.println(" Login Successful ");
			
			return true;
			
		}
		else
		{
			System.out.println(" Incorrect Username or Passsword");
			
				return false;
		}

	}
	
	public static String validateCreds(String un, String pass)
	{
		String passDB="";
		try {
			
			String fetchUserPassword="select * from Student";
			
			con= DBConnection.getDBConnection();
			
			ps= con.prepareStatement(fetchUserPassword);
			
		
			rs= ps.executeQuery();
			
			while(rs.next())
			{
				
			passDB = rs.getString("U_Password");
			}
		} 
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				rs.close();
				ps.close();
				con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return passDB;

		}
	
	
	public static String sendUsername(String usrnm)
	{
		return usrnm;
	}
	
	
	
}
