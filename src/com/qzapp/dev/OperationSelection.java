package com.qzapp.dev;

import java.util.Scanner;

public class OperationSelection {

	
	public static void selectOperation() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("What all you want do ?");
		char yn = 'y';
		do {
		
		System.out.println("1.Get all students scores (in ascending order)");

		System.out.println("2.Get score of a specific student using ID");

		System.out.println("3.Add a new question in data base");
		
		 sc= new Scanner(System.in);
		int choice= sc.nextInt();
		
		switch(choice)
		{
		
		case 1:
			AdminOperations.getAllStudentScore();
			break;
			
		case 2:
		
			System.out.println("Please enter student id");
			int i=sc.nextInt();
			AdminOperations.getStudentScoreByID(i);
			break;
		
		case 3:
		    System.out.println("how many questions do you want to add?");
		    int num = sc.nextInt();
			AdminOperations.addNewQuestionInDB(num);
			System.out.println("Question inserted successfully");
			break;					
		
		default :
			System.out.println("Wrong choice");
		
		}
		System.out.println("Do you want to use another operation? Enter yes or no");
		yn = sc.next().charAt(0);
		}while(yn == 'y');
		
		
	}
	
	
}
