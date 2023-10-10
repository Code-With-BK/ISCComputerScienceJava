
/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © 2023 Balkrishna Srivastava. All rights reserved.
 * 
 * Solution to Question 2 of ISC 2020 Computer Science Practical Paper
 */
import java.util.Scanner;

public class ISC2020ComputerSciencePracticalQuestion2 
{
	static int decimalEquivalent(int row[]) {
		int sum = 0;
		int power = 0;
		for( int i=row.length-1; i>=0; i--,power++ ) {
			sum += row[i] * Math.pow(8, power);
		}
		return sum;
	}
	
	static void printMatrix(int A[][], int M, int N) {
		System.out.println("FILLED MATRIX        DECIMAL EQUIVALENT");
		for( int i=0; i<M; i++ ) {
			for( int j=0; j<N; j++ ) {
				System.out.printf("%-3d",A[i][j]);
			}
			System.out.println("            " + decimalEquivalent(A[i]));
		}
	}
	
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);

		System.out.print("M = ");
		int M = scanner.nextInt();
		System.out.print("N = ");
		int N = scanner.nextInt();
		
		if( !(M>0 && M<10)) {
			System.out.println("OUT OF RANGE");
			scanner.close();
			return;
		}
		if( !(N>2 && N<6)) {
			// print size out of range
			System.out.println("OUT OF RANGE");
			scanner.close();
			return;
		}
		
		int[][] A = new int[M][N];
		boolean validInput = true;
		for( int i=0; i<M; i++ ) {
			System.out.print("ENTER ELEMENTS FOR ROW " + (i+1) + ": ");
			for(int j=0; j<N; j++ ) {
				A[i][j] = scanner.nextInt();
				if( A[i][j] < 0 || A[i][j] > 7 ) {
					validInput = false;
				}
			}
			if( !validInput ) {
				break;
			}
		}
		scanner.close();
		
		if( !validInput ) {
			System.out.println("INVALID INPUT");
		}
		else {
			printMatrix(A, M, N);
		}
		
	}
}
