
/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © 2023 Balkrishna Srivastava. All rights reserved.
 * 
 * Solution to Question 6 of 2023 ISC Computer Science Specimen Paper 
 * Create a class Pronic to check for pronic number
 */
import java.util.Scanner;

class Pronic {
    private int num;

    public Pronic() {
        num = 0;
    }

    public void acceptnum() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer number: ");
        num = scanner.nextInt();
    }

    public boolean ispronic(int v) {
        // base case - because we have to consider 0 a pronic number
        if( v==0 ) {
            return false;
        }
        if( v*(v-1) == num ) {
            return true;
        }
        // recursive case
        return ispronic(v-1);
    }

    public void check() {
        if( ispronic(num) ) {
            System.out.println(num + " is a Pronic number.");
        }
        else {
            System.out.println(num + " is not a Pronic number.");
        }
    }
}

public class ISC2023ComputerScienceSpecimenPaperQuestion6 {
    public static void main(String args[]) {
        Pronic pronic = new Pronic();
        pronic.acceptnum();
        pronic.check();
    }
}
