
/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © 2023 Balkrishna Srivastava. All rights reserved.
 * 
 * Solution to Question 8 of 2023 ISC Computer Science Theory Paper  
 */
import java.util.Scanner;
class SortAlpha {
    private String sent;
    private int n;

    public SortAlpha() {
        sent = "";
        n = 0;
    }

    public void acceptsent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        sent = scanner.nextLine();
        scanner.close();
    }

    public void sort(SortAlpha P) {
        String sentP = P.sent;

        // count the number of words in sentP
        int l = sentP.length();
        int numSpaces = 0;
        for( int i=0; i<l; i++ ) {
            if( sentP.charAt(i) == ' ' ) {
                numSpaces++;
            }
        }
        int numWords = numSpaces+1;

        // create an array to store the words
        String[] words = new String[numWords];
        // extract words from the sentP
        int i = 0;
        int index = 0;
        String word = "";
        while( i<l ) {
            if( sentP.charAt(i) == ' ' ) {
                words[index] = word;
                word = "";
                index++;
            }
            else {
                word += sentP.charAt(i);
            }
            i++;
        }
        // add the last word
        words[index] = word;

        // sort this array
        for( i=0; i<numWords; i++ ) {
            for( int j=0; j<numWords-1; j++ ) {
                if( words[j].compareTo(words[j+1])>0 ) {
                    String temp = words[j];
                    words[j] = words[j+1];
                    words[j+1] = temp;
                }
            } 
        }        

        // after the words of sentP are sorted, store them in the String sent
        n = numWords;
        sent = "";
        for( i=0; i<n; i++ ) {
            sent += words[i] + " ";
        }
    }

    public void display() {
        System.out.println("Original sentence: " + sent);
        // calling sort - and passing the reference to this very object
        sort(this);
        System.out.println("Sorted sentence: " + sent);
    }
}

public class ISC2023ComputerScienceTheoryQuestion8 {
    public static void main(String args[]) {
       SortAlpha sortAlpha = new SortAlpha();
       sortAlpha.acceptsent();
       sortAlpha.display();
    }
}