/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © 2023 Balkrishna Srivastava. All rights reserved.
 * 
 * Solution to Question 3 of 2019 ISC Computer Science Practical Paper  
 */
import java.util.Scanner;

public class ISC2019ComputerSciencePracticalQuestion3 {
    static boolean isPalindrome(String word) {
        boolean isPalindrome = true;
        for( int i=0; i<word.length()/2; i++ )  {
            if( word.charAt(i) != word.charAt( word.length() - i - 1) ) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }
    static String getPalindromeForRepeatingLastCharacters(String word) {
        String palindrome = word;
        int i = word.length() - 1;
        while( i>=1 && word.charAt(i) == word.charAt(i-1) ) 
            i--;
        i--;
        while( i>=0 ) 
            palindrome = palindrome + word.charAt(i--);
        return palindrome;
    }

    static String convertToPalindrome(String word) {
        if( word.charAt(word.length()-1) == word.charAt(word.length()-2))
            return getPalindromeForRepeatingLastCharacters(word);

        String secondHalf = word.substring(0,word.length() - 1);
        String reverseSecondHalf = "";
        for( int i=secondHalf.length()-1; i>=0; i-- ) {
            reverseSecondHalf += secondHalf.charAt(i);
        }
        String palindrome = word + reverseSecondHalf;
        return palindrome;
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        scanner.close();

        char lastChar = sentence.charAt(sentence.length() - 1);
        if( !(lastChar == '.' || lastChar == '?' || lastChar == '!')) {
            System.out.println("INVALID INPUT");
            return;
        }

        System.out.println(sentence);

        sentence = sentence.substring(0,sentence.length() - 1);
        String words[] = sentence.split(" ");

        for( String word: words) {
            if( isPalindrome(word) ) {
                System.out.print(word);
            }
            else {
                System.out.print(convertToPalindrome(word));
            }
            System.out.print(" ");
        }
        System.out.println();
    }
}
