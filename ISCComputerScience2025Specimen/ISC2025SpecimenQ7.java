import java.util.Scanner;

/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © CodeWithBK 2024. All rights reserved.
 * 
 * Java code solution for Question 7
 * ISC 2025 Computer Science Boards Specimen Paper
 */

class Mixarray {
	private int arr[];
	private int cap;
	
	public Mixarray(int mm) {
		cap = mm;
		arr = new int[cap];
	}
	
	public void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter " + cap + " integers: ");
		for( int i=0; i<cap; i++ ) {
			arr[i] = scanner.nextInt();
		}
	}
	
	public Mixarray mix(Mixarray P, Mixarray Q) {
		// create a mixarray object
		Mixarray M = new Mixarray(6);
		int index = 0;
		
		// add first 3 integers from P
		for( int i=0; i<3; i++ ) {
			M.arr[index++] = P.arr[i];
		}
		
		// add first 3 integers from Q
		for( int i=0; i<3; i++ ) {
			M.arr[index++] = Q.arr[i];
		}
		
		return M;
	}
	
	public void display() {
		System.out.print("[ ");
		for( int i : arr ) {
			System.out.print(i + " ");
		}
		System.out.println(" ]");
	}
	
}

public class ISC2025SpecimenQ7 {
	public static void main(String args[]) {
		// create P and Q
		Mixarray P = new Mixarray(5);
		Mixarray Q = new Mixarray(4);
		
		// read input
		P.input();
		Q.input();
		
		// create the mix
		Mixarray M = P.mix(P, Q);
		
		// display
		System.out.print("P = ");
		P.display();
		System.out.print("Q = ");
		Q.display();
		
		System.out.print("Mix = ");
		M.display();
		
	}
}
