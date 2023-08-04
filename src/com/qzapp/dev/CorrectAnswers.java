package com.qzapp.dev;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CorrectAnswers {
	
	
	static Connection con=null ;
	static PreparedStatement ps=null ;
	static ResultSet rs =null;
	
	public static int getCorrectAnswer(int counter)
	{
		String ansQry="select * from questions";
		
			int z=0;
		try {
			con=DBConnection.getDBConnection();
			
			ps= con.prepareStatement(ansQry);
			
			rs=ps.executeQuery();
			
			int a= rs.getInt("correctOption");
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return z;
	}
	
	

}
