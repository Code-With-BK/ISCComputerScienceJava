/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © 2023 Balkrishna Srivastava. All rights reserved.
 * 
 * Solution to Question 3 of ISC 2020 Computer Science Practical Paper
 */
import java.util.Scanner;

public class ISC2020ComputerSciencePracticalQuestion3 
{
	static String[] getWords(String sentence) {
		int numSpaces = 0;
		for( int i=0; i<sentence.length(); i++ ){
			if( sentence.charAt(i) == ' ')
				numSpaces++;
		}
		
		String words[] = new String[numSpaces + 1];
		int i = 0;
		int index = 0;
		String word = "";
		while( i<sentence.length() ){
			if( sentence.charAt(i) == ' '){
				words[index++] = word;
				word = "";
			}
			else{
				word += sentence.charAt(i);
			}
			i++;
		}
		words[index++] = word;
		return words;
	}
	
	static boolean compare(String a, String b) {
		if( a.length()<b.length() ) {
			return true;
		}
		else if( a.length()>b.length() ) {
			return false;
		}
		else {
			if( a.compareTo(b)<=0 ) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	static void sort(String words[]){
		for( int i=0; i<words.length; i++ ){
			for( int j=0; j<words.length-1; j++ ){
				if( !compare(words[j], words[j+1]) ){
					String temp = words[j];
					words[j] = words[j+1];
					words[j+1] = temp;
				}  
			}
		}
	}
	
	static void print(String words[]){
		for( String word : words )
			System.out.print(word + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String sentence = scanner.nextLine();
		scanner.close();

		char lastChar = sentence.charAt(sentence.length() - 1);
		if( !(lastChar == '.' || lastChar == '?' || lastChar == '!')){
			System.out.println("INVALID INPUT");
			return;
		}

		System.out.println(sentence);

		sentence = sentence.substring(0, sentence.length() - 1);
		// use the split method 
		// String words[] = sentence.split(" ");
		// or write your own method to extract words from the string 
		String words[] = getWords(sentence);
		sort(words);
		print(words);
	}
}
