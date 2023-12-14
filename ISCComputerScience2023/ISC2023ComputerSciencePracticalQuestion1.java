
/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © CodeWithBK 2023. All rights reserved.
 * 
 * Java code solution for Question 1 of 
 * ISC 2023 Computer Science Practical Boards Paper
 */
import java.util.Scanner;

public class ISC2023ComputerSciencePracticalQuestion1 {

    // static boolean isPrime(int n) {
    //     for( int i=2; i<n; i++ ) {
    //         if( n%i==0 ) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    static boolean isComposite(int n) {
        for( int i=2; i<n; i++ ) {
            if( n%i==0 ) {
                return true;
            }
        }
        return false;
        // return !isPrime(n);
    }

    static boolean isMagic(int n) {
        while( n>=10 ) {
            int digitsSum = 0;
            String nStr = "" + n;
            for( int i=0; i<nStr.length(); i++ ) {
                int digit = nStr.charAt(i) - '0';
                digitsSum += digit;
            }
            n = digitsSum;
        }
        return n==1;
    }

    static boolean isMagicComposite(int n){
        return isComposite(n) && isMagic(n);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // read the value of m
        System.out.print("m=");
        int m = scanner.nextInt();

        // read the value of n
        System.out.print("n=");
        int n = scanner.nextInt();

        // validate the values of m and n
        if( m>n ) {
            System.out.println("INVALID INPUT");
            return;
        }

        System.out.print("THE COMPOSITE MAGIC INTEGERS ARE: ");
        int numCompositeMagicNumbers = 0;
        String compositeMagicNumbers = "";
        for( int i=m; i<=n; i++ ) {
            if( isMagicComposite(i) ) {
                numCompositeMagicNumbers++;
                // System.out.print(i + " ");
                compositeMagicNumbers += i + ", ";
            }
        }
        // System.out.println();
        // remove the last ", "
        compositeMagicNumbers = compositeMagicNumbers.substring(0, compositeMagicNumbers.length() - 2);
        System.out.println(compositeMagicNumbers);

        // print the frequency
        System.out.println("FREQUENCY OF COMPOSITE MAGIC INTEGERS IS: " + numCompositeMagicNumbers);

        scanner.close();
    }
}
