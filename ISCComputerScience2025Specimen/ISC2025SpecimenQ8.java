import java.util.Scanner;

/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © CodeWithBK 2024. All rights reserved.
 * 
 * Java code solution for Question 8
 * ISC 2025 Computer Science Boards Specimen Paper
 */

class LCM {
	
	private int n1;
	private int n2;
	private int large;
	private int sm;
	private int l;
	
	public LCM() {
		n1 = 0;
		n2 = 0;
		sm = 0;
		large = 0;
		l = 0;
	}
	
	public void accept() {
		// scanner to read from the user
		Scanner scanner = new Scanner(System.in);
		
		// ask the user to enter the integer n1
		System.out.print("Enter n1: ");
		n1 = scanner.nextInt();
		
		// ask the user to enter the integer n2
		System.out.print("Enter n2: ");
		n2 = scanner.nextInt();
		
		// update smallest and largest
		if( n1>n2  ) {
			large = n1;
			sm = n2;
		}
		else {
			large = n2;
			sm = n1;
		}
	}
	
	public int getLCM() {
		// if the smaller and the larger values are equal 
		if( sm==large ) {
			// we have found the HCF, which is equal to sm(=large)
			return (n1*n2)/sm;
		}
		else {
			if( large>sm ) {
				int diff = large - sm;
				large = diff;
			}
			// else if sm>large
			else {
				int diff = sm - large;
				sm = diff;
			}
			return getLCM();
		}
	}
	
	public void display() {
		l = getLCM();
		System.out.println("n1: " + n1);
		System.out.println("n2: " + n2);
		System.out.println("LCM: " + l);
	}
}

public class ISC2025SpecimenQ8 {
	public static void main(String args[]) {
		LCM lcm = new LCM();
		lcm.accept();
		System.out.println();
		lcm.display();
	}
}
