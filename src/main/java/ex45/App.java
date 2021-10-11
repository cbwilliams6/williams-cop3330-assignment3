/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Christian Williams
 */

package ex45;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) throws IOException {
        Scanner input = new Scanner(System.in);

        // scanner that lets us get the text from the input file
        Scanner inputFile = new Scanner(new File(".\\src\\main\\java\\ex45\\exercise45_input.txt"));

        // asking the user for a name for the output file, then creates the file and automatically makes it a .txt file
        System.out.print("Enter a name for the output file: ");
        String outputName = input.nextLine();
        FileWriter outputFile = new FileWriter(".\\src\\main\\java\\ex45\\" + outputName + ".txt");

        // calling a method that does the word replacement
        outputReplace(inputFile, outputFile);
    }

    public static void outputReplace(Scanner inputFile, FileWriter outputFile) throws IOException {
        // loop continues until there are no lines of text left to check
        while (inputFile.hasNextLine()) {
            // stores a line of text in a string variable
            String inputLine = inputFile.nextLine();
            // changes each instance of "utilize" with "use" in the string
            inputLine = inputLine.replaceAll("utilize", "use");
            // writes the full line, with replacements, into the output file
            outputFile.write(inputLine + "\n");
        }

        // closing the FileWriter
        outputFile.close();
    }
}
