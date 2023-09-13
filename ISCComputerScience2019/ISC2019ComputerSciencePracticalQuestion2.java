/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © 2023 Balkrishna Srivastava. All rights reserved.
 * 
 * Solution to Question 2 of 2019 ISC Computer Science Practical Paper  
 */
import java.util.Scanner;

public class ISC2019ComputerSciencePracticalQuestion2 {
    static void display(int matrix[][], int N){
        for( int i=0; i<N; i++ ) {
            for( int j=0; j<N; j++ ){
                System.out.printf("%-3d",matrix[i][j]);
            }
            System.out.println();
        }
    }
    static void sort(int array[], int N){
        for( int i=0; i<N; i++ ) {
            for( int j=0; j<N-1; j++ ){
                if( array[j] > array[j+1] ) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        System.out.print("N = ");
        int N = scanner.nextInt();

        if( N<=2 || N>=10 ) {
            System.out.println("MATRIX SIZE OUT OF RANGE");
            scanner.close();
            return;
        }

        int[] array = new int[N];
        System.out.print("ENTER ELEMENTS OF SINGLE DIMENSIONAL ARRAY : ");
        for( int i=0; i<N; i++ ) {
            array[i] = scanner.nextInt();
        }
        scanner.close();

        sort(array,N);
        System.out.print("SORTED ARRAY: ");
        for( int i=0; i<N; i++ ) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        int[][] matrix = new int[N][N];
        for( int i=0; i<N; i++ ){
            int index=0;
            for( int j=0; j<N-i; j++ ){
                matrix[i][index++] = array[j];
            }
            for( int j=0; j<i; j++ ){
                matrix[i][index++] = array[j];
            }
        }

        System.out.println("FILLED MATRIX");
        display(matrix,N);
    }
}
