
/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © 2023 Balkrishna Srivastava. All rights reserved.
 * 
 * Solution to Question 6 of 2023 ISC Computer Science Theory Paper  
 */
import java.util.Scanner;

class NumDude {
    private int num;

    // constructor
    public NumDude() {
        num = 0;
    }

    // input() method
    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer:" );
        num = scanner.nextInt();
        scanner.close();
    }
    
    /**
     * recursion: 
     *  - base case: if x is 0, sum of digits is 0
     *  - recursive case: sum(digits of x) = last digit of x + sum(x - remove the last digit)
     * 
     * 123
     * sum(digits of 123) = 3 + sum(digits of 12)
     * sum(digits of 12) = 2 + sum(digits of 1)
     * sum(digits of 1) = 1 + sum(digits of 0)
     */
    public int sumDigits(int x) {
        if( x==0 ) {
            return 0;
        }
        // get the last digit
        int lastDigit = x%10;
        // remove the last digit
        x = x/10;
        // recur
        return lastDigit + sumDigits(x);
    }

    public void isDude() {
        int sumOfDigits = sumDigits(num);
        int sumOfDigitsCube = sumOfDigits * sumOfDigits * sumOfDigits;
        if( sumOfDigitsCube==num ) {
            System.out.println(num + " is a Dudeney Number!");
        }
        else {
            System.out.println(num + " is not a Dudeney Number!");
        }
    }
}

public class ISC2023ComputerScienceTheoryQuestion6 {
    public static void main(String args[]) {
        NumDude numDude = new NumDude();
        numDude.input();
        numDude.isDude();
    }
}
