
/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © 2023 Balkrishna Srivastava. All rights reserved.
 * 
 * Solution to Question 7 of 2023 ISC Computer Science Theory Paper  
 */

/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © 2023 Balkrishna Srivastava. All rights reserved.
 * 
 * Solution to Question 6 of 2023 ISC Computer Science Theory Paper  
 */
import java.util.Scanner;

class Trans {
    private int arr[][];
    private int m;

    public Trans(int mm) {
        m = mm;
        arr = new int[m][m];
    }
    
    public void fillarray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter " + m + " x " + m + " elements: ");
        for( int i=0; i<m; i++ ) {
            for( int j=0; j<m; j++ ) {
                int x = scanner.nextInt();
                arr[i][j] = x;
            }
        }
        scanner.close();
    }

    public void transpose() {
        // method 1: to create a transpose using an auxillary array
        // create a temp array to store the transpose
        // int[][] temp = new int[m][m];
        // for( int i=0; i<m; i++ ) {
        //     for( int j=0; j<m; j++ ) {
        //         temp[i][j] = arr[j][i];
        //     }
        // }
        // // set arr to temp
        // arr = temp;

        // method 2: to create a transpose without using an auxillary array
        int k = 0;
        for( int i=0; i<m; i++ ) {
            for( int j=k; j<m; j++ ) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
            k++;
        }
    }

    public void display() {
        System.out.println("Original Matrix: ");
        for( int i=0; i<m; i++ ) {
            for( int j=0; j<m; j++ ) {
                // System.out.print(arr[i][j] + " ");
                // or use printf() to print formatted output
                System.out.printf("%5d",arr[i][j]);
            }
            System.out.println();
        }

        transpose();

        System.out.println("Transpose Matrix: ");
        for( int i=0; i<m; i++ ) {
            for( int j=0; j<m; j++ ) {
                // System.out.print(arr[i][j] + " ");
                // or use printf() to print formatted output
                System.out.printf("%5d",arr[i][j]);
            }
            System.out.println();
        }
    }
}

public class ISC2023ComputerScienceTheoryQuestion7 {
    public static void main(String args[]) {
        Trans trans = new Trans(4);
        trans.fillarray();
        trans.display();
    }
}