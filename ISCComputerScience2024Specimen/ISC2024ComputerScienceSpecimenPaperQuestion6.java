
/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © CodeWithBK 2024. All rights reserved.
 * 
 * Java code solution for Question 6 of ISC 2024 Computer Science Specimen Paper
 */
import java.util.Scanner;

class Evil {
    private int num;
    private String bin;
    
    public Evil() {
        num = 0;
        bin = "";
    }

    public void acceptNum() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer number: ");
        num = scanner.nextInt();
    }

    public void rec_bin(int x) {
        if( x==0 ) {
            bin = 0 + bin;
            // return;
        }
        else {
            int r = x%2;
            bin = r + bin;
            rec_bin(x/2);
        }
    }

    public void check() {
        rec_bin(num);
        // System.out.println(num + " in binary: " + bin);
        int num1s = 0;
        for( int i=0; i<bin.length(); i++ ) {
            if( bin.charAt(i) == '1' ) {
                num1s++;
            }
        }
        if( num1s%2==0 ) {
            System.out.println(num + " is an Evil Number");
        }
        else {
            System.out.println(num + " is not an Evil Number");
        }
    }

}

public class ISC2024ComputerScienceSpecimenPaperQuestion6 {
    public static void main(String args[]) {
        Evil evil = new Evil();
        evil.acceptNum();
        evil.check();
    }
}
