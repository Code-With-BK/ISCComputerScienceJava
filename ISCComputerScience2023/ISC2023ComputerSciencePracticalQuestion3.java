
/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © CodeWithBK 2023. All rights reserved.
 * 
 * Java code solution for Question 3 of 
 * ISC 2023 Computer Science Practical Boards Paper
 */

import java.util.Scanner;

public class ISC2023ComputerSciencePracticalQuestion3 {

    static boolean isValidTerminatingChar(char c) {
        return (c=='.' || c=='?' || c=='!');
    }

    static String[] extractWords(String sentence) {
        // remove the last char
        sentence = sentence.substring(0, sentence.length()-1);

        // NOTE: Alternate split() method, comment the rest of the code in this function
        // return sentence.split(" ");

        // 1. count the number of words in the sentence
        // number of words = number of whitespaces + 1
        int numWhitespaces = 0;
        for( int i=0; i<sentence.length(); i++ ) {
            // get the ith character
            char c = sentence.charAt(i);
            // if this is a blank space, increment the number of whitespaces
            if( c==' ' ) {
                numWhitespaces++;
            }
        }

        // 2. count words and create array to store words
        int numWords = numWhitespaces + 1;
        String[] words = new String[numWords];

        // 3. extarct the words from the sentence into the array
        int i = 0;
        String word = "";
        int index = 0;
        // sentence += " ";
        while( i<sentence.length() ) {
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
        // add the last word
        words[index] = word;

        return words;
    }

    static String[] getCommonWords(String words1[], String words2[]) {
        // create an array to hold the common words
        // NOTE: the maximum number of common words between the two = min(words1.length, words1.length)
        String[] commonWords = new String[words1.length + words2.length];

        // extract common words

        // iterrate the words of sentence 1
        for( int i=0; i<words1.length; i++ ) {
            String word1 = words1[i];
            boolean found = false;
            // find this word in the second sentence
            for( int j=0; j<words2.length; j++ ) {
                if( word1.equals(words2[j])) {
                    found = true;
                }
            }

            if( found ) {
                // check if word1 is in commonWords
                boolean exists = false;
                int j;
                for( j=0; j<commonWords.length && commonWords[j]!=null ; j++ ) {
                    if( commonWords[j].equals(word1) ) {
                        exists = true;
                        break;
                    }
                }

                // add the common word to commonWords[] only if it does not exists
                if( !exists ) {
                    commonWords[j] = word1;
                }
            }
        }

        return commonWords;
    }

    static String[] extractLines(String paragraph) {
        // 1. there must be exactly two sentences in this paragraph
        int numValidTerminatingChars = 0;
        for( int i=0; i<paragraph.length(); i++ ) {
            char c = paragraph.charAt(i);
            if( isValidTerminatingChar(c) ) {
                numValidTerminatingChars++;
            }
        }

        // number of valid terminating chars must be exactly two to contains two sentences only
        if( numValidTerminatingChars!=2 ) {
            return null;
        }

        // 2. the last character of the paragraph must be a valid terminating char
        if( !isValidTerminatingChar( paragraph.charAt(paragraph.length()-1)) ) {
            return null;
        }

        // 3. extract lines
        String[] lines = new String[2];

        // "IS IT CLOUDY? IT MAY RAIN BECAUSE IT IS CLOUDY."
        int i = 0;
        while( i<paragraph.length() && !isValidTerminatingChar(paragraph.charAt(i))) {
            i++;
        }
        // i stops at the first valid terminating char
        // extract line 1
        lines[0] = paragraph.substring(0, i+1);

        // extract second line
        lines[1] = paragraph.substring(i+1).trim();

        return lines;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // B. considering the input was one single line
        String paragraph = scanner.nextLine();
        String lines[] = extractLines(paragraph);

        if( lines==null ) {
            System.out.println("INVALID INPUT");
            return;
        }

        String line1 = lines[0];
        String line2 = lines[1];
        
        // A. considering the input was two separate lines as two lines of the paragraph
        // read the two lines
        // String line1 = scanner.nextLine();
        // String line2 = scanner.nextLine();

        // check if these two lines end with the correct terminating char
        // char c1 = line1.charAt(line1.length()-1);
        // char c2 = line2.charAt(line2.length()-1);
        // if( !isValidTerminatingChar(c1) || !isValidTerminatingChar(c2) ) {
        //     // print invalid input
        //     System.out.println("INVALID INPUT");
        //     return;
        // }

        // NOTE: Do not check for UPPER CASE WORDS/SINGLE BLANK SPACE BETWEEN TWO WORDS

        // print number of words in each sentence
        String words1[] = extractWords(line1);
        String words2[] = extractWords(line2);
        System.out.println("SENTENCE 1: " + words1.length + " WORDS");
        System.out.println("SENTENCE 2: " + words2.length + " WORDS");

        // get the common words
        String commonWords[] = getCommonWords(words1, words2);
        System.out.print("COMMON WORDS: ");
        for (int i=0; i<commonWords.length && commonWords[i]!=null; i++ ) {
            System.out.print(commonWords[i] + " ");
        }
        System.out.println();

        scanner.close();
    }
}