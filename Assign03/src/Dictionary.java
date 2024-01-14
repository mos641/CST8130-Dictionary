/**
 * * 
 * This class contains the definition of the dictionary 
 * Student Name: Mostapha A
 * Course: CST8130 - Data Structures CET-CS-Level 3
 * 
 * @author/Mostapha A
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Class for taking in dictionary of words and analyzing them.
 */
public class Dictionary {
	/** The tree map that will be used to store the dictionary of words */
	private static TreeMap<String, Integer> dictionary;
	
	/**
	 * Default constructor for the class, initializes the tree map as needed
	 */
	Dictionary(){
		// Initialize tree map
		dictionary = new TreeMap<String, Integer>();
	}

	/**
	 * Adds words of a hard coded text file to the tree map, removing all special characters
	 */
	public void addWords() {
		String formattedWord;
		Integer wordCount;

		// open the file and store
		try {
			File file = new File("Raven.txt");
			Scanner fileScanner = new Scanner(file);

			// loop to store each word
			while (fileScanner.hasNext()) {
				String word = fileScanner.next();

				// reset formatted word
				formattedWord = "";

				// loop through scanned in word to remove special characters
				for (int i = 0; i < word.length(); i++) {
					// add alphabetic characters based on ASCII value
					if (word.charAt(i) > 64 && word.charAt(i) <= 122) {
						// add verified characters to formatted word
						formattedWord = formattedWord + word.charAt(i);
					}
				}
				// add word without characters to tree map if it is not empty
				formattedWord = formattedWord.toUpperCase();
				if (formattedWord != "") {
					// check if it exists
					if (dictionary.containsKey(formattedWord)) {
						// get the count of value, increment in map
						wordCount = dictionary.get(formattedWord);
						wordCount++;

						dictionary.put(formattedWord, wordCount);
					} else {
						// otherwise put the word with a count of one
						dictionary.put(formattedWord, 1);
					}
				}
			}
			
			System.out.println("Program has read the file");

			// close scanner
			fileScanner.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not found.");
		}
	}

	/**
	 * Searches for a specific word within our dictionary tree map
	 * @param word The word to be searched for
	 * @return The numbe of times the word occurs in the text
	 */
	public int searchWord(String word) {
		int wordCount;

		// check if empty first
		if (dictionary.isEmpty()) {
			wordCount = 0;
		} else {
			// check if dictionary contains it
			if (dictionary.containsKey(word)) {
				// get the count
				wordCount = dictionary.get(word);
			} else {
				wordCount = 0;
			}
		}
		
		// return count
		return wordCount;
	}

	/**
	 * Counts how many unique words occur in our dictionary tree map
	 * @param ignore Whether we are ignoring definite and indefinite articles
	 * @return The count of unique words
	 */
	public int uniqueWords(boolean ignore) {
		int wordCount = 0;

		// check if empty first
		if (dictionary.isEmpty()) {
			wordCount = 0;
		} else {
			// iterate through tree map
			for (Entry<String, Integer> word : dictionary.entrySet()) {
				// check if it is an ignored article and ignore if ignore is true
				if (ignore == true && (word.getKey().equals("A") || word.getKey().equals("AN") || word.getKey().equals("THE"))) {
					// do nothing
				} else {
					// otherwise add to count
					wordCount++;
				}
			}
		}

		return wordCount;
	}

	/**
	 * Counts how many total words occur are in our dictionary tree map
	 * @param ignore Whether we are ignoring definite and indefinite articles
	 * @return The count of all words
	 */
	public int allWords(boolean ignore) {
		int allWordsCount = 0;

		// check if empty first
		if (dictionary.isEmpty()) {
			allWordsCount = 0;
		} else {
			// iterate through tree map
			for (Entry<String, Integer> word : dictionary.entrySet()) {
				// check if it is an ignored article and ignore if ignore is true
				if (ignore == true && (word.getKey().equals("A") || word.getKey().equals("AN") || word.getKey().equals("THE"))) {
					// do nothing
				} else {
					// otherwise add each words count to total count
					allWordsCount = allWordsCount + word.getValue();
				}
			}
		}
		return allWordsCount;
	}

	/**
	 * Resets or clears out dictionary tree map
	 */
	public void reset() {
		// clear tree map
		dictionary.clear();
	}

}