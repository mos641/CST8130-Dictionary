/**
 * * 
 * This class contains the main method and menu 
 * Student Name: Mostapha A
 * Course: CST8130 - Data Structures CET-CS-Level 3
 * 
 * @author/Mostapha A
 * 
 */

import java.util.Scanner;

/**
 * Tests the Dictionary Class.
 */
public class Assign3Test {
	/** Boolean value whether we are ignoring definite and indefinite articles */
	private static boolean ignoreArticles;
	
	/**
	 * Main method for printing menu and processing.
	 * 
	 * @param args Default needed for main method
	 */
	public static void main(String[] args) {
		// var for menu input
		int menu = -1;
		int error;
		Scanner scanner = new Scanner(System.in);
		// object
		Dictionary dictionary = new Dictionary();
		String word;
		
		// loop through menu
		do {
			// set menu to -1
			menu = -1;

			// print menu
			showMenu();

			// if input is an int, store
			if (scanner.hasNextInt()) {
				menu = scanner.nextInt();
				error = 0;
			} else {
				// clear input
				error = 1;
				scanner.next();
			}
			
			// set error code for specific error message if out of range
			if (error == 0 && (menu < 1 || menu > 7)) {
				error = 2;
			}

			// if it is out of range print error and loop again
			if (error != 0) {
				// print error and loop through again
				if (error == 2) {
				System.out.println("Invalid Entry… Option should be a number between 1 and 7\n\n");
				} else {
				System.out.println("Input Mismatch Exception while reading user's option from main menu\n\n");
				}
			} else {
				// case structure for menu options
				switch (menu) {
				case 1:
					// add words
					dictionary.addWords();
					break;
				case 2:
					// ask for word to search
					scanner.nextLine();
					System.out.print("Enter the word you want to search: ");
					word = scanner.nextLine();
					
					// search word
					System.out.println(word+" occurs " +dictionary.searchWord(word.toUpperCase())+ " times");
					
					break;
				case 3:
					// display unique count
					System.out.println("Dictionary has " +dictionary.uniqueWords(ignoreArticles)+ " unique words");
					break;
				case 4:
					// display count of all words
					System.out.println("Dictionary has " +dictionary.allWords(ignoreArticles)+ " words");
					break;
				case 5:
					// reset dictionary
					dictionary.reset();
					System.out.println("Program has removed all the words");
					break;
				case 6:
					// change definite/indefinite
					if (ignoreArticles == true) {
						ignoreArticles = false;
					} else {
						ignoreArticles = true;
					}
					System.out.println("Ignore definite and indefinite articles has been set to " +ignoreArticles);
					
					break;
				case 7:
					// exit
					System.out.println("Good bye.... hope to see you soon");
					break;
				}
				System.out.println();
			}

		} while (menu != 7);

		scanner.close();
	}

	/**
	 * Prints the menu of options for the program.
	 */
	public static void showMenu() {
		// menu to be printed
		System.out.printf("*********************************************\r\n" + 
				"DICTIONARY\r\n" + 
				"*********************************************\r\n" + 
				"1. Add words to the Dictionary from file\r\n" + 
				"2. Search a word in the Dictionary\r\n" + 
				"3. Display number of unique words in the Dictionary\r\n" + 
				"4. Display number of all words in the Dictionary\r\n" + 
				"5. Reset Dictionary\r\n" + 
				"6. Ignore definite and indefinite articles (%s)\r\n" + 
				"7. Exit\r\n\n" + 
				"Enter your option: ", ignoreArticles);
	}

}
