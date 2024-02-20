/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © CodeWithBK 2024. All rights reserved.
 * 
 * Java code solution for Question 2 of 
 * ISC 2023 Computer Science Practical Boards Paper
 */
import java.util.Scanner;
public class ISC2023ComputerScienceBoardsPracticalQ2 {

    static void printMatrix(int A[][], int M, int N){
        for( int i=0; i<M; i++ ) {
            for( int j=0; j<N; j++ ) {
                // System.out.print(A[i][j] + " ");
                System.out.printf("%5d", A[i][j]);
            }
            System.out.println();
        }
    }

    static int[][] findMirrorMatrix(int A[][], int M, int N) {
        int[][] MA = new int[M][N];
        for( int i=0; i<M; i++ ) {
            for( int j=0; j<N; j++ ) {
                MA[i][j] = A[i][N-j-1];
            }
        }
        return MA;
    }

    static int sumCornerElements(int A[][], int M, int N) {
        int sum = 0;
        
        // top left element
        sum += A[0][0];

        // top right element
        sum += A[0][N-1];

        // bottom left element
        sum += A[M-1][0];

        // bottom right element
        sum += A[M-1][N-1];

        return sum;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("M=");
        int M = scanner.nextInt();

        System.out.print("N=");
        int N = scanner.nextInt();

        // validate the values of M and N
        if( M<=2 || M>=10 || N<=2 || N>=10 ) {
            System.out.println("INVALID SIZE");
            return;
        }

        int[][] A=new int[M][N];
        for( int i=0; i<M; i++ ) {
            for( int j=0; j<N; j++ ) {
                A[i][j] = scanner.nextInt();
            }
        }

        System.out.println();
        System.out.println("ORIGINAL MATRIX");
        printMatrix(A,M,N);

        System.out.println();
        System.out.println("MIRROR MATRIX");
        int[][] MA = findMirrorMatrix(A,M,N);
        printMatrix(MA,M,N);

        System.out.println();
        System.out.println("SUM OF THE CORNER ELEMENTS = " + sumCornerElements(A,M,N));

    }
}