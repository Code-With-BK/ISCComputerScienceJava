/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © CodeWithBK 2024. All rights reserved.
 * 
 * Java code solution for Question 3 of 
 * ISC 2023 Computer Science Practical Boards Paper
 */
import java.util.Scanner;

public class ISC2023ComputerScienceBoardsPracticalQ3 {

    static boolean isValidTerminatingChar(char c) {
        return c=='.' || c=='?' || c=='!';
    }

    static String[] extractWords(String sentence) {
        // split() 
         

        // remove the last char
        sentence = sentence.substring(0, sentence.length() - 1);
        // return sentence.split(" ");

        // count number of whitespaces
        int numWhitespaces = 0;
        for( int i=0; i<sentence.length(); i++ ) {
            char c = sentence.charAt(i);
            if( c==' ' ) {
                numWhitespaces++;
            }
        }

        // find the number of words
        int numWords = numWhitespaces + 1;

        // create an array to store all the words
        String[] words = new String[numWords];

        // extract words
        String word = "";
        int index = 0;
        int i = 0;
        while( i<sentence.length()) {
            char c = sentence.charAt(i);
            if( c==' ' ) {
                words[index] = word;
                word = "";
                index++;
            }
            else {
                word += c;
            }
            i++;
        }
        words[index] = word;

        // return the array of words
        return words;
    }

    static String[] findCommonWords(String words1[], String words2[]) {
        // create array to store common words
        String[] commonWords = new String[ words1.length + words2.length ];

        // find common words
        for( int i=0; i<words1.length; i++ ) {
            String word = words1[i];

            // find word in words2
            boolean found = false;
            for( int j=0; j<words2.length; j++ ) {
                if( word.equals(words2[j]) ) {
                    found = true;
                    break;
                }
            }

            // add this word to common list of words
            if( found ) {
                // make sure, not adding the same word twice to the common words
                boolean alreadyAdded = false;
                int j = 0;
                for( j=0; j<commonWords.length && commonWords[j]!=null ; j++ ) {
                    if( commonWords[j].equals(word) ) {
                        alreadyAdded = true;
                        break;
                    }
                }

                if( !alreadyAdded ) {
                    // add the word to common words
                    commonWords[j] = word;
                }
            }
        }

        return commonWords;
    }

    static String[] extractSentences(String paragraph) {
        int numValidTerminatingChars = 0;
        for( int i=0; i<paragraph.length(); i++ ) {
            char c = paragraph.charAt(i);
            if( isValidTerminatingChar(c) ) {
                numValidTerminatingChars++;
            }
        }

        if( numValidTerminatingChars!=2 ) {
            return null;
        }

        // here, number of valid terminating chars are 2 
        // last char must be a valid terminating char
        char lastChar = paragraph.charAt(paragraph.length() - 1);
        if( !isValidTerminatingChar(lastChar) ) {
            return null;
        }

        // extract sentences
        String[] sentences = new String[2];

        // extract first sentence
        // "IS IT CLOUDY? IT MAY RAIN BECAUSE IT IS CLOUDY."
        int firstValidTerminatingCharIndex = 0;
        for( int i=0; i<paragraph.length(); i++ ) {
            char c = paragraph.charAt(i);
            if( isValidTerminatingChar(c) ) {
                firstValidTerminatingCharIndex = i;
                break;
            }
        }

        String sentence1 = paragraph.substring(0, firstValidTerminatingCharIndex+1);
        String sentence2 = paragraph.substring(firstValidTerminatingCharIndex+1);
        sentences[0] = sentence1;
        sentences[1] = sentence2.trim();

        return sentences;
    }
    
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String paragraph = scanner.nextLine();

        String sentence1;
        String sentence2;
        String[] sentences = extractSentences(paragraph);
        if( sentences==null ) {
            System.out.println("INVALID INPUT");
            return;
        }
        sentence1 = sentences[0];
        sentence2 = sentences[1];

        // read the two sentences
        // sentence1 = scanner.nextLine();
        // sentence2 = scanner.nextLine();

        // validate the sentences
        // char lastChar1 = sentence1.charAt(sentence1.length()-1);
        // char lastChar2 = sentence2.charAt(sentence2.length()-1);
        
        // if( !isValidTerminatingChar(lastChar1) || !isValidTerminatingChar(lastChar2) ) {
        //     System.out.println("INVALID INPUT");
        //     return;
        // }

        String[] words1 = extractWords(sentence1);
        String[] words2 = extractWords(sentence2);

        System.out.println("SENTENCE 1: " + words1.length + " WORDS");
        System.out.println("SENTENCE 2: " + words2.length + " WORDS");

        String commonWords[] = findCommonWords(words1, words2);
        System.out.print("COMMON WORDS: ");
        for( int i=0; i<commonWords.length && commonWords[i]!=null; i++ ) {
            System.out.print(commonWords[i] + " ");
        }
        System.out.println();
    }
}