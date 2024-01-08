
/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © CodeWithBK 2024. All rights reserved.
 * 
 * Java code solution for Question 8 of 
 * ISC 2024 Computer Science Specimen Paper
 */
import java.util.Scanner;

class Encode {
    private String word;
    private int length;
    private String new_word;

    public Encode() {
        word = "";
        length = 0;
        new_word = "";
    }

    public void acceptWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        word = scanner.nextLine();
        length = word.length();
    }

    public void nextVowel() {

        String lcVowels = "aeiou";
        String ucVowels = "AEIOU";

        for( int i=0; i<length; i++ ) {
            char c = word.charAt(i);
            // if this character c is a lower case vowel
            if( lcVowels.indexOf(c) != -1 ) {
                int vowelIndex = lcVowels.indexOf(c);
                int nextVowelIndex = (vowelIndex+1)%5;
                char nextVowel = lcVowels.charAt(nextVowelIndex);
                new_word += nextVowel;
            }
            // else if character c is an upper case vowel
            else if( ucVowels.indexOf(c) != -1 ) {
                int vowelIndex = ucVowels.indexOf(c);
                int nextVowelIndex = (vowelIndex+1)%5;
                char nextVowel = ucVowels.charAt(nextVowelIndex);
                new_word += nextVowel;
            }
            else {
                new_word += c;
            }
        }
    }

    public void display() {
        System.out.println("Original word: " + word);
        System.out.println("Encrypted word: " + new_word);
    }

}

public class ISC2024ComputerScienceSpecimenPaperQuestion8 {
    public static void main(String args[]) {
        Encode encode = new Encode();
        encode.acceptWord();
        encode.nextVowel();
        encode.display();
    }
}