/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © 2023 Balkrishna Srivastava. All rights reserved.
 * 
 * Solution to Question 1 of ISC 2020 Computer Science Practical Paper
 */

import java.util.Scanner;

public class ISC2020ComputerSciencePracticalQuestion1 
{	
	static boolean isPrime(int n) {
		for( int i=2; i<n; i++ ) {
			if( n%i == 0 ) {
				return false;
			}
		}
		return true;
	}
	
	static int reverse(int n) {
		String nString = "" + n; 
		String reverseNString = "";
		for( int i=nString.length() - 1; i>=0; i-- ) {
			reverseNString += nString.charAt(i);
		}
		return Integer.parseInt(reverseNString);
	}
	
	static boolean isAdam(int n) {
		int nSquare = n*n;
		int nReverse = reverse(n);
		int nReverseSquare = nReverse * nReverse;
		return nReverseSquare == reverse(nSquare);
	}
	
	static boolean isPrimeAdam(int n) {
		return isPrime(n) && isAdam(n);
	}
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("m = ");
		int m = scanner.nextInt();
		System.out.print("n = ");
		int n = scanner.nextInt();

		scanner.close();
		
		if( m<=0 || n<=0 ) {
			System.out.println("INVALID INPUT");
			return;
		}
		if( !(m<n) ) {
			System.out.println("INVALID INPUT");
			return;
		}
		
		System.out.println("THE PRIME-ADAM INTEGERS ARE:");
		int frequency = 0;
		for( int i=m; i<=n; i++ ) {
			if( isPrimeAdam(i)) {
				System.out.print(i + " ");
				frequency++;
			}
		}
		if( frequency == 0 ) {
			System.out.println("NIL");
		} else {
			System.out.println();
		}
		
		System.out.println("FREQUENCY OF PRIME-ADAM INTEGERS IS: " + frequency);
	}
}
