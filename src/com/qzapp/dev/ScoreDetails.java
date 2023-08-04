package com.qzapp.dev;

public class ScoreDetails {
	
	
	@Override
	public String toString() {
		return "ScoreDetails [fName=" + fName + ", lName=" + lName + ", sc=" + sc + "]";
	}


	private String fName;
	private String lName;
	private int sc;
	
	
	public ScoreDetails(String fName, String lName, int sc) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.sc = sc;
	}
	
	

}
