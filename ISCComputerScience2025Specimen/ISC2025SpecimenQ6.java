import java.util.Scanner;

/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © CodeWithBK 2024. All rights reserved.
 * 
 * Java code solution for Question 6
 * ISC 2025 Computer Science Boards Specimen Paper
 */

class StringOp {
	
	// to store the original string
	private String str;
	
	// to store the mask string
	private String msk;
	
	// to store the new string
	private String nstr;
	
	public StringOp() {
		str = "";
		msk = "";
		nstr = "";
	}
	
	public void accept() {
		Scanner scanner = new Scanner(System.in);
		
		// ask the user to enter a string
		System.out.print("Enter a string: ");
		str = scanner.nextLine();
		
		// ask the user to enter the mask string
		System.out.print("Enter the mask string: ");
		msk = scanner.nextLine();
		
		str = str.toLowerCase();
		msk = msk.toLowerCase();
	}
	
	public void form() {
		// temp value to store the original string
		String temp = str;
		
		// for each ch in mask
		for( int i=0; i<msk.length(); i++ ) {
			char ch = msk.charAt(i);
			
			// set nstr to blank
			nstr = "";
			
			// remove ch from temp, and store the updated string in nstr
			for( int j=0; j<temp.length(); j++ ) {
				if( ch!=temp.charAt(j) ) {
					nstr += temp.charAt(j);
				}
			}
			
			// set temp to nstr
			temp = nstr;
		}
	}
	
	public void display() {
		System.out.println("Original string: " + str);
		System.out.println("Mask string    : " + msk);
		System.out.println("New string     : " + nstr);
	}
}



public class ISC2025SpecimenQ6 {
	public static void main(String args[]) {
		StringOp stringOp = new StringOp();
		stringOp.accept();
		stringOp.form();
		stringOp.display();
	}
}
