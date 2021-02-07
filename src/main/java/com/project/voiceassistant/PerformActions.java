package com.project.voiceassistant;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PerformActions {
	
	public PerformActions() {}
	
	private static List<String> chromeKeywordList = Arrays.asList("OPEN CHROME", "NAVIGATE TO CHROME", "CLOSE CHROME");
	private static List<String> websiteKeywordList = Arrays.asList("OPEN AMAZON", "OPEN FLIPKART", "NAVIGATE TO AMAZON",
			"NAVIGATE TO FLIPKART", "OPEN YOUTUBE", "NAVIGATE TO YOUTUBE", "OPEN GMAIL", "NAVIGATE TO GMAIL");
	
	public void executeCommand(String command) throws IOException {
		
		if(chromeKeywordList.contains(command)) {
			chrome(command);
		}else if(websiteKeywordList.contains(command)) {
			openWebsite(command);
		}else if(command.contains("NOTEPAD")) {
			notepad(command);
		}else if(command.contains("WORD")) {
			word(command);
		}else if(command.contains("EXCEL")) {
			excel(command);
		}else {
			System.out.println("INVALID COMMAND :( .....Try again.");
		}
	}

	public static void chrome(String command) throws IOException {
		if(command.contains("OPEN") || command.contains("NAVIGATE TO")) {
			Runtime.getRuntime().exec("cmd.exe /c start \"\" \"www.google.com\"");
		}else if(command.contains("CLOSE")) {
			Runtime.getRuntime().exec("cmd.exe /c taskkill /F /IM chrome.exe");
		}
	}
	
	public static void openWebsite(String command) throws IOException {
		if(command.contains("GMAIL")) {
			Runtime.getRuntime().exec("cmd.exe /c start \"\" \"https://mail.google.com\"");
		}else if(command.contains("HACKERRANK")){
			Runtime.getRuntime().exec("cmd.exe /c start \"\" \"https://www.hackerrank.com/login?h_r=login&h_l=body_middle_left_button\"");
		}else if(command.contains("YOUTUBE") || command.contains("AMAZON") || command.contains("FLIPKART")){
			String website = "";
			if(command.contains("OPEN")) {
				int startIndex = command.indexOf('N');
				website = command.substring(startIndex+2);
			}else if(command.contains("NAVIGATE")){
				int startIndex = command.indexOf('O');
				website = command.substring(startIndex+2);
			}
			website = website.toLowerCase();
			Runtime.getRuntime().exec("cmd.exe /c start \"\" \"https://www."+website+".com\"");
		}else {
			System.out.println("INVALID COMMAND :( .....Try again.");
		}
	}
	
	public static void notepad(String command) throws IOException {
		if(command.contains("OPEN")) {
			Runtime.getRuntime().exec("cmd.exe /c start C:\\\"Program Files (x86)\"\\Notepad++\\notepad++.exe");
		}else if(command.contains("CLOSE")) {
			Runtime.getRuntime().exec("cmd.exe /c taskkill /F/IM notepad++.exe");
		}else {
			System.out.println("INVALID COMMAND :( .....Try again.");
		}
	}
	
	public static void  excel(String command) throws IOException {
		if(command.contains("OPEN")) {
			Runtime.getRuntime().exec("cmd.exe /c start C:\\\"Program Files\"\\\"Microsoft Office\"\\Office15\\EXCEL.exe");
		}else if(command.contains("CLOSE")) {
			Runtime.getRuntime().exec("cmd.exe /c taskkill /F /IM EXCEL.exe");
		}else {
			System.out.println("INVALID COMMAND :( .....Try again.");
		}
	}
	
	public static void word(String command) throws IOException {
		if(command.contains("OPEN")) {
			Runtime.getRuntime().exec("cmd.exe /c start C:\\\"Program Files\"\\\"Microsoft Office\"\\Office15\\WINWORD.exe");
		}else if(command.contains("CLOSE")) {
			Runtime.getRuntime().exec("cmd.exe /c taskkill /F /IM WINWORD.exe");
		}else {
			System.out.println("INVALID COMMAND :( .....Try again.");
		}
	}
}
