/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Christian Williams
 */

package ex46;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class App
{
    public static void main( String[] args ) throws IOException {
        // creating variables to hold the input.txt file, and some arrays for storing the input data in
        Scanner inputFile = new Scanner(new File(".\\src\\main\\java\\ex46\\exercise46_input.txt"));
        String[] words = new String[0];
        ArrayList<String> wordsList = new ArrayList<String>();

        // a couple methods for storing the input into an arraylist and then getting the frequency of each word
        arrayGen(inputFile, words, wordsList);
        frequencyGen(inputFile, words, wordsList);
    }

    public static void arrayGen(Scanner inputFile, String[] words, ArrayList<String> wordsList) {
        // same as all the other exercises, simple loop that goes line by line through the input until there's nothing left
        while (inputFile.hasNextLine()) {
            // storing a single line of input into an array with a space as the split between words
            words = inputFile.nextLine().split(" ");

            // adds each word stored in the string array into the arraylist
            for (int i = 0; i < words.length; i++){
                wordsList.add(words[i]);
            }
        }
    }

    public static void frequencyGen(Scanner inputFile, String[] words, ArrayList<String> wordsList) {
        // using a LinkedHashSet to get only unique words, in this case the set will only store badger, mushroom, and snake once each
        Set<String> newWord = new LinkedHashSet<String>(wordsList);
        // loop that goes through each word in the hashset
        for (String j : newWord) {
            // printing out each unique word from the set, formatted so that the stars are evenly spaced out
            System.out.format("%-10s", j + ": ");
            // loop that checks for the frequency of the unique word from the arraylist, then prints a single star for each time it shows up
            for (int k = 0; k < Collections.frequency(wordsList, j); k++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}