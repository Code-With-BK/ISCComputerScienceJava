/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © CodeWithBK 2023. All rights reserved.
 * 
 * Java code solution for Question 1 of 
 * ISC 2023 Computer Science Practical Boards Paper
 */

import java.util.Scanner;
public class ISC2023ComputerScienceBoardsPracticalQ1 {

    static boolean isComposite(int n) {
        for( int i=2; i<n; i++ ) {
            if( n%i==0 ) {
                return true;
            }
        }
        return false;
    }

    static boolean isMagic(int n) {
        while( n>=10 ) {
            // n = 28
            int digitsSum = 0;
            String nStr = "" + n;       // nStr = "28"
            for( int i=0; i<nStr.length(); i++ ) {
                char c = nStr.charAt(i);        // c='2', '8'
                int digit = c - '0';        // '0'-48, '1'-49, '2'-50, 
                digitsSum += digit;
            }
            n = digitsSum;
        }
        return n==1;
    }

    static boolean isMagicComposite(int n) {
        return isMagic(n) && isComposite(n);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // enter the value of m
        System.out.print("m=");
        int m = scanner.nextInt();

        // enter the value of n
        System.out.print("n=");
        int n = scanner.nextInt();

        if( m>n ) {
            System.out.println("INVALID INPUT");
            return;
        } 

        System.out.print("THE COMPOSITE MAGIC INTEGERS ARE: ");
        int frequency = 0;
        String outputString = "";
        for( int i=m; i<=n; i++ ) {
            if( isMagicComposite(i) ) {
                // System.out.print(i + ", ");
                outputString += i + ", ";
                frequency++;
            }
        }
        // remove the last extra ", "
        outputString = outputString.substring(0, outputString.length()-2);
        System.out.println(outputString);
        System.out.println("FREQUENCY OF COMPOSITE MAGIC INTEGERS IS: " + frequency);
    }
}