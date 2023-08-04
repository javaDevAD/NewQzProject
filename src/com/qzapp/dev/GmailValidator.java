package com.qzapp.dev;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GmailValidator {
	
	
	    public static boolean isValidEmail(String email) {
	        String regex = "^[a-z0-9._%+-]+@[gmail]+\\.[com]";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(email);
	        return matcher.matches();
	    }

	    
	}


