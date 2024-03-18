import java.util.Scanner;

/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © CodeWithBK 2024. All rights reserved.
 * 
 * Java code solution for Question 8 of 
 * ISC 2024 Computer Science Boards Paper
 */

class Coding {
	private String wrd;
	private int len;
	
	public Coding() {
		wrd = "";
		len = 0;
	}
	
	public void accept() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a string: ");
		wrd = scanner.nextLine();
		len = wrd.length();
	}
	
	public void find() {
		char lowestASCII = wrd.charAt(0);
		char highestASCII = wrd.charAt(0);
		
		for( int i=0; i<len; i++ ) {
			char ch = wrd.charAt(i);
			int ascii = ch;
			System.out.println(ch + " = " + ascii);
			if( lowestASCII>ch ) {
				lowestASCII = ch;
			}
			if( ch>highestASCII ) {
				highestASCII = ch;
			}
		}
		System.out.println();
		System.out.println("Lowest ASCII Code: " + (int)lowestASCII);
		System.out.println("Highest ASCII Code: " + (int)highestASCII);
	}
	
	public void show() {
		System.out.println("Original Word: " + wrd);
		find();
	}
}

public class ISC2024ComputerScienceBoardsQ8 {

	public static void main(String[] args) {
		Coding coding = new Coding();
		coding.accept();
		coding.show();
	}

}
