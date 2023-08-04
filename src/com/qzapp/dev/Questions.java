package com.qzapp.dev;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Questions {

	static Connection con ;
	static PreparedStatement ps ;
	static ResultSet rs ;
	static int scoreCounter;
	
	public static void fetchQuestions()
	{
		String question="select * from questions";
		
		
		try {
			
			con =DBConnection.getDBConnection();
			 ps = con.prepareStatement(question);
			 rs= ps.executeQuery(question);
			 
			while(rs.next())
			{
				String q=rs.getString("question");
				String a=rs.getString("option_a");
				String b=rs.getString("option_b");
				String c=rs.getString("option_c");
				String d=rs.getString("option_d");
				int correctAnswer=rs.getInt("correctOption");
				int captureAns = AnswersCapt.captureAns(q, a, b, c, d);
				boolean bA=AnswersCapt.validateAns(captureAns,correctAnswer);
				
				if(bA==true)
				{
					System.out.println("--------------");
					scoreCounter++;
				}
				else
				{
					System.out.println("--------------");
				}

			}
			
			
			System.out.println("Your score is : "+scoreCounter);
			
			AnswersCapt.setScore(scoreCounter);
			
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
		
		
		
		
	}
	
	
	
}
