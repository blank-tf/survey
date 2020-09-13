/*
 * Copyright (C) 2020 Griffin Thompson
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.griffin.survey;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 *
 * @author Griffin Thompson
 */
public class Survey
{
	public static String stringQuestion(String question)
	{
		Scanner scanner = new Scanner(System.in);
		while (true)
		{
			System.out.println(question);
			String answer = scanner.nextLine();
			int exceptionInt;
			try
			{
				exceptionInt  = Integer.parseInt(answer);
				System.out.println("Please enter characters, not numbers.");
			}
			catch (NumberFormatException e)
			{
				return answer;
			}
		}
	}
	
	public static int intQuestion(String question)
	{
		Scanner scanner = new Scanner(System.in);
		while (true)
		{
			System.out.println(question);
			String answer = scanner.nextLine();
			int answerInt;
			try
			{
				answerInt = Integer.parseInt(answer);
				return answerInt;
			}
			catch (NumberFormatException e)
			{
				System.out.println("Invalid input. Please enter only numbers (No Spaces!)");
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, InterruptedException, IOException
	{
		try
		{
			if (args[0].equals("--version") || args[0].equals("-v"))
			{
				System.out.println("Survey Program\n0.0.2-rc1\nBy Griffin Thompson");
				return;
			}
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			
		}
		System.out.print("\033[H\033[2J");
		System.out.flush();
		String name = stringQuestion("What is your name?");
		int age = intQuestion("What is your age, in years?");
		String favoriteFood = stringQuestion("What is your favorite food?");
		String favoriteFoodWhy = stringQuestion("Why is " + favoriteFood + " your favorite food?");
		
		System.out.println("You've finished the survey. Here's what you answered:");
		System.out.println("You said your name was " + name);
		System.out.println("You said your age was " + age);
		System.out.println("You said your favorite food was " + favoriteFood);
		System.out.println("You said it was your favorite because \"" + favoriteFoodWhy + ".\"");
		Thread.sleep(500);
		while (true)
		{
			Scanner scanner = new Scanner(System.in);
			System.out.println("Would you like to write your results to a file?");
			String yn = scanner.nextLine();
			yn = yn.toLowerCase();
			if (yn.equals("yes") || yn.equals("y"))
			{
				PrintWriter printer = new PrintWriter(System.getProperty("user.home") + "/Documents/surveyResults.txt", "UTF-8");
				printer.println("You said your name was " + name + ". I like it.");
				printer.println("You said you were " + age + " years old.");
				printer.println("You said your favorite food was " + favoriteFood + ". When asked why it was your favorite food, you answered \"" + favoriteFoodWhy + ".\" Good choice!");
				printer.close();
				System.out.println("Operation completed, your results were saved in \"" + System.getProperty("user.home") + "/Documents\"\nGoodbye!");
				return;
			} else if (yn.equals("no") || yn.equals("n"))
			{
				System.out.println("Okay, exiting now!");
				return;
			} else
			{
				System.out.println("Please enter \"yes\" or \"no\".");
			}
			
		}
		
		
		
	}
}
 