
/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © 2023 Balkrishna Srivastava. All rights reserved.
 * 
 * Solution to Question 8 of 2023 ISC Computer Science Specimen Paper 
 * Create a class Encrypt
 */
import java.util.Scanner; 
class Encrypt {
    private String wrd;
    private int len;
    private String newwrd;

    public Encrypt() {
        wrd = "";
        len = 0;
        newwrd = "";
    }

    public void acceptword() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word in UPPER CASE: ");
        wrd = scanner.nextLine();
        len = wrd.length();
    }

    public void freqvowcon() {
        int numVowels = 0;
        int numConsonants = 0;
        for( int i=0; i<len; i++ ) {
            char ch = wrd.charAt(i);
            // check if ch is a vowel using indexOf()
            // String vowels = "AEIOU";
            // if( vowels.indexOf(ch) != -1 ) {
            //     numVowels++;
            // }

            // alternate method to check if ch is a vowel
            boolean isVowel = false;
            switch(ch) {
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                   numVowels++; 
                   isVowel = true;
            }
            // if( Character.isLetter(ch) && vowels.indexOf(ch) == -1 ) {
            // alternate if condition to check if ch is a consonant
            if( ch>='A' && ch<='Z' && !isVowel ) {
                numConsonants++;
            }
        }
        System.out.println("Number of vowels in '" + wrd + "' : " + numVowels);
        System.out.println("Number of consonants in '" + wrd + "' : " + numConsonants);
    }

    public void nextVowel() {
        for( int i=0; i<len; i++ ) {
            char ch = wrd.charAt(i);
            String vowels = "AEIOU"; 
            if( vowels.indexOf(ch) != -1 ) {
                int index = vowels.indexOf(ch);
                int nextIndex = (index+1)%5;
                char nextVowel = vowels.charAt(nextIndex);
                newwrd += nextVowel;
            }
            else {
                newwrd += ch;
            }
        }
    }

    public void disp() {
        System.out.println("Original word: " + wrd);
        nextVowel();
        System.out.println("Encrypted word: " + newwrd);
    }
}

public class ISC2023ComputerScienceSpecimenPaperQuestion8 {
    public static void main(String args[]) {
        Encrypt encrypt = new Encrypt();
        encrypt.acceptword();
        encrypt.freqvowcon();
        encrypt.disp();
    }
}