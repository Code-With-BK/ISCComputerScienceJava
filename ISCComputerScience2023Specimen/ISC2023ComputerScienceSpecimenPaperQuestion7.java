
/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © 2023 Balkrishna Srivastava. All rights reserved.
 * 
 * Solution to Question 7 of 2023 ISC Computer Science Specimen Paper 
 * Create a class OddEven
 */
import java.util.Scanner;

class OddEven {
    private int[] a;
    private int m;

    public OddEven(int mm) {
        m = mm;
        a = new int[m];
    }

    public void fillarray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter " + m + " integers: ");
        for( int i=0; i<m; i++ ) {
            int v = scanner.nextInt();
            a[i] = v;
        }
    }

    public OddEven arrange(OddEven P, OddEven Q) {
        OddEven arranged = new OddEven(P.m + Q.m);
        int index = 0;
        // copy all odd integers from P
        for( int i=0; i<P.m; i++ ) {
            if( P.a[i]%2!=0 ) {
                arranged.a[index++] = P.a[i];
            }
        }
        // copy all odd integers from Q
        for( int i=0; i<Q.m; i++ ) {
            if( Q.a[i]%2!=0 ) {
                arranged.a[index++] = Q.a[i];
            }
        }
        // copy all even integers from P
        for( int i=0; i<P.m; i++ ) {
            if( P.a[i]%2==0 ) {
                arranged.a[index++] = P.a[i];
            }
        }
        for( int i=0; i<Q.m; i++ ) {
            if( Q.a[i]%2==0 ) {
                arranged.a[index++] = Q.a[i];
            }
        }
        return arranged;
    }

    public void display() {
        System.out.print("[ ");
        for( int i=0; i<m; i++ ) {
            System.out.print(a[i] + " ");
        }
        System.out.println("]");
    }

}

public class ISC2023ComputerScienceSpecimenPaperQuestion7 {
    public static void main(String args[]) {
        OddEven P = new OddEven(3);
        P.fillarray();
        OddEven Q = new OddEven(3);
        Q.fillarray();
        // use either object P or Q to call function arrange 
        OddEven arranged = P.arrange(P,Q);

        // print elements
        arranged.display();
    }
}