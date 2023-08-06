package com.qzapp.dev;

import java.util.Scanner;

public class Main_Screen 
{
	
	public static void main(String[] args) throws ClassNotFoundException, InterruptedException {

		System.out.println();
		System.out.println();
		System.out.println("               ### WELCOME TO QuizApp ###               ");
		System.out.println();
		System.out.println();
		
		System.out.println("Who are you?");
		System.out.println("1.Student");
		System.out.println("2.Admin/Faculty");
		
		Scanner sc= new Scanner(System.in);
		int i=sc.nextInt();
		
		if(i==1) {
		Main_Screen.welcomPage_User();
		}
		else
		{
			Main_Screen.welcomPage_Admin();
		}

	}

	
	public static void welcomPage_User() throws ClassNotFoundException, InterruptedException
	{
		
		System.out.println("Enter '1' for Register");
		System.out.println("Enter '2' for Login");
	
		Scanner sc= new Scanner(System.in);
		int fisrt_choice=sc.nextInt();
		
		if(fisrt_choice==1)
		{
			Registration.newUserRegistration();
			if(Login.verifyUserCreds())
			{
				Thread.sleep(2000);
				System.out.println("Let's start today's quiz ");
				Thread.sleep(2000);
				Questions.fetchQuestions();
			}
		}
		else
		{
			Thread.sleep(2000);

			
			if(Login.verifyUserCreds())
			{
				Thread.sleep(2000);
				System.out.println("Let's start today's quiz ");
				Thread.sleep(2000);
				Questions.fetchQuestions();
			}
			
						
		}

	}

	
	public static void welcomPage_Admin() throws InterruptedException, ClassNotFoundException {
		System.out.println("Enter '1' for Register");
		System.out.println("Enter '2' for Login");

		Scanner sc = new Scanner(System.in);
		int fisrt_choice = sc.nextInt();

		if (fisrt_choice == 1) {
			Registration_Admin.newUserRegistration();

			if (AdminCreds.verifyAdminCreds()) {
				Thread.sleep(2000);
				OperationSelection.selectOperation();
			}
		} else {

			if (AdminCreds.verifyAdminCreds()) {

				Thread.sleep(2000);
				OperationSelection.selectOperation();

			}

		}

	}
	
	
}
	

	
	
	
	
	
	
	
	
	

