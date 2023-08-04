package com.qzapp.dev;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AnswersCapt {
	
	static Connection con ;
	static PreparedStatement ps ;
	static ResultSet rs ;
	
	public static int captureAns(String q, String a,String b, String c, String d)
	{
		
		System.out.println(q);
		System.out.println("1."+a);
		System.out.println("2."+b);
		System.out.println("3."+c);
		System.out.println("4."+d);
		System.out.println("Enter option :");
		Scanner sc= new Scanner(System.in);
		int ans= sc.nextInt();
		
	return ans;
		//validateAns(ans, correctAnswer);
		
	}
	
	public static boolean validateAns(int anscaptureAns,int correctAnswer)
	{
			//int a=CorrectAnswers.getCorrectAnswer(counter);
		if(correctAnswer==anscaptureAns)
		{
			//scoreCounter++;
			//System.out.println("Correct Answer ------"+correctAnswer);
			return true;
		}
		else
		{
			
			
			//System.out.println("Wrong ANswer");
			return false;
		}
	}
	
	public static void setScore(int score)
	{
		String usn= Login.usrnm;
		try
		{
			
			String query="update Student set Score=? where Username=? ";
			
			con=DBConnection.getDBConnection();
			ps=con.prepareStatement(query);
			
			ps.setInt(1, score);
			ps.setString(2, usn);

			ps.execute();
			System.out.println("Score Updated successfully=======");
			
		}
		catch(Exception e)
		{
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
