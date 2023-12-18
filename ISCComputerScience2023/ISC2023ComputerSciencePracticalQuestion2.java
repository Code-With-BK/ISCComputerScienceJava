
/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © CodeWithBK 2023. All rights reserved.
 * 
 * Java code solution for Question 2 of 
 * ISC 2023 Computer Science Practical Boards Paper
 */

import java.util.Scanner;

public class ISC2023ComputerSciencePracticalQuestion2 {

    static void printMatrix(int A[][], int M, int N) {
        for( int i=0; i<M; i++) {
            for( int j=0; j<N; j++ ) {
                System.out.printf("%6d", A[i][j]);
            }
            System.out.println();
        }
    }

    static int sumCornerElements(int A[][], int M, int N) {
        int sum = 0;

        // add top left corner element
        sum += A[0][0];

        // add top right corner element
        sum += A[0][N-1];

        // add bottom left corner element
        sum += A[M-1][0];

        // add bottom right corner element
        sum += A[M-1][N-1];

        return sum;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // read the value of m 
        System.out.print("M=");
        int M = scanner.nextInt();

        // read the value of n
        System.out.print("N=");
        int N = scanner.nextInt();

        // validate teh values of m and n
        if( M<=2 || M>=10 || N<=2 || N>=10 ) {
            System.out.println("INVALID SIZE");
            return;
        }

        int[][] A=new int[M][N];

        // read the values into the matrix
        for( int i=0; i<M; i++) {
            for( int j=0; j<N; j++ ) {
                A[i][j] = scanner.nextInt();
            }
        }

        System.out.println("ORIGINAL MATRIX: ");
        printMatrix(A,M,N);
        System.out.println();

        // create mirror matrix
        int[][] MA=new int[M][N];
        for( int i=0; i<M; i++) {
            for( int j=0; j<N; j++ ) {
                MA[i][j] = A[i][N-j-1];
            }
        }   

        // print mirror matrix
        System.out.println("MIRROR MATRIX: ");
        printMatrix(MA,M,N);
        System.out.println();

        // print sum of corner elements
        System.out.println("SUM OF THE CORNER ELEMENTS = " + sumCornerElements(A,M,N));

        scanner.close();
    }
}