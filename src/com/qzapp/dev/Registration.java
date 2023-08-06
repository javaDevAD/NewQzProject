package com.qzapp.dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Registration {

	static Connection con;
	static PreparedStatement ps;
	public static void newUserRegistration() throws ClassNotFoundException
	{
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Please enter 1st name :");
		String firstName=sc.next();
		
		System.out.println("Please enter last name :");
		String lastName=sc.next();
		
		System.out.println("Please enter user name :");
		String userName=sc.next();

		System.out.println("Please enter password :");
		String password=sc.next();
		
		System.out.println("Please enter city :");
		String city=sc.next();
		
		System.out.println("Please enter email id :");
		String mailId=sc.next();
		
		boolean e=GmailValidator.isValidEmail(mailId);
		if(e==false)
		{
			String m=CustomExceptions.emailExceptions();
			System.out.println(m);
			 mailId=sc.next();
		}
		
		System.out.println("Please enter Mobile Number :");
		long mob=sc.nextLong();
		
		userDataInsert(firstName,lastName,userName,password,city,mailId,mob);

	}
	
	public static void userDataInsert(String firstName,String lastName,String userName,String password,String city,String mailId,long mob) throws ClassNotFoundException
	{
		try {
		
		String addNewUserDetails="insert into student(First_Name,Last_Name,Username,U_Password,City,Mail_ID,Mob)"
									+"values(?,?,?,?,?,?,?)";
		
		con=DBConnection.getDBConnection();
		
		ps = con.prepareStatement(addNewUserDetails);
		ps.setString(1,firstName);
		ps.setString(2,lastName);
		ps.setString(3,userName);
		ps.setString(4,password);
		ps.setString(5,city);
		ps.setString(6,mailId);
		ps.setLong(7,mob);
		
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
