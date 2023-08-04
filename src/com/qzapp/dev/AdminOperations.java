package com.qzapp.dev;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminOperations {

	static Connection con=null ;
	static PreparedStatement ps=null ;
	static ResultSet rs =null;
	static String f_name;
	static String l_name;
	static int score;
	
	
	
	
	
	public static void getAllStudentScore()
	{
		
		
		ArrayList<ScoreDetails> scd= new ArrayList<ScoreDetails>();
		
		try {
			
			String query="select First_Name, Last_Name, Score from Student order by Score ";
			con= DBConnection.getDBConnection();
			ps=con.prepareStatement(query);
			
			rs=ps.executeQuery();
			
			System.out.println("F_Name, L_Name, Score");
			
			while(rs.next())
			{
				f_name=rs.getString("First_Name");
				l_name=rs.getString("Last_Name");
				score=rs.getInt("Score");
				
				System.out.println(f_name+"  "+l_name+"  "+score);
				//scd.add(new ScoreDetails(f_name,l_name,score));
				
			}
			
			
			
		} catch (SQLException e) {
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
		//System.out.println("The list is here :");
		
//		for(ScoreDetails sd: scd)
//		{
//			System.out.println(sd);
//		}
	}
	
	
		
	
	public static void getStudentScoreByID(int i)
	{
		
		String query="select First_Name, Last_Name, Score from Student where id=? ";
		
		try {
			con= DBConnection.getDBConnection();
			ps=con.prepareStatement(query);
			ps.setInt(1, i);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				String fname=rs.getString("First_Name");
				String lname=rs.getString("Last_Name");
				int s=rs.getInt("Score");
				
				System.out.println(fname+"  "+lname+"  "+s);
			}
			
		} catch (SQLException e) {
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
		
	}
	
	
	public static void addNewQuestionInDB()
	{
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Please enter question");
		String que=sc.nextLine();
		
		System.out.println("Enter 1st option");
		String opt1=sc.nextLine();;
		
		System.out.println("Enter 2nd option");
		String opt2= sc.nextLine();;
		
		System.out.println("Enter 3rd option");
		String opt3= sc.nextLine();;
		
		System.out.println("Enter 4th option");
		String opt4= sc.nextLine();;
		
		System.out.println("WHich one correct? 1,2,3,4 ?");
		int c=sc.nextInt();
		String query="insert into questions(question, option_a, option_b, option_c, option_d,correctOption) values(?,?,?,?,?,?) ";
		
		try {
			con= DBConnection.getDBConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, que);
			ps.setString(2, opt1);
			ps.setString(3, opt2);
			ps.setString(4, opt3);
			ps.setString(5, opt4);
			ps.setInt(6, c);
			int executeUpdate = ps.executeUpdate();
			
			
		} catch (SQLException e) {
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
