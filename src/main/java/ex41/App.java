/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Christian Williams
 */

package ex41;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// note: deleted output file before pushing to github so you don't have to go in and delete it before running the code
public class App
{
    public static void main( String[] args ) throws IOException {
        // create a scanner that points to the input file and an arraylist to hold all the names for sorting later
        Scanner input = new Scanner(new File(".\\src\\main\\java\\ex41\\exercise41_input.txt"));
        ArrayList<String> nameList = new ArrayList<String>();

        // calling a method that adds the input file names to the arraylist and then sorts it
        addNames(input, nameList);

        // closing the scanner
        input.close();

        // calling another method that creates the output file using the sorted arraylist
        outputNames(nameList);
    }

    public static void addNames(Scanner input, ArrayList<String> nameList) {
        // simple loop that keeps adding names to the arraylist until there are none left
        while (input.hasNextLine()) {
            nameList.add(input.nextLine());
        }

        // sorts the arraylist alphabetically
        Collections.sort(nameList);
    }

    public static void outputNames(ArrayList<String> nameList) throws IOException {
        // FileWriter creates an output file and allows writing to it
        FileWriter output = new FileWriter(".\\src\\main\\java\\ex41\\exercise41_output.txt");

        // just writing the basic formatting stuff into the output
        output.write("Total of " + nameList.size() + " names\n");
        output.write("-----------------\n");

        // loop writes the sorted namelist to the output file until there are no names left to add
        for (int i = 0; i < nameList.size(); i++) {
            output.write(nameList.get(i) + "\n");
        }

        // close the FileWriter
        output.close();
    }
}
