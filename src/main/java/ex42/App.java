/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Christian Williams
 */

package ex42;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) throws IOException {
        // create a scanner that points to the input file
        Scanner input = new Scanner(new File(".\\src\\main\\java\\ex42\\exercise42_input.txt"));

        // formatting the table column header
        System.out.print("Last\t\tFirst\t\tSalary\n-------------------------------\n");

        // calling another method using the scanner that will print out the data
        outputNames(input);
    }

    public static void outputNames(Scanner input) throws IOException {
        // while loop will print out each line of data from the input file until there's nothing left
        while(input.hasNextLine()) {
            // creating an array to hold a line of 3 different sets of data, each one differentiated by a comma between them
            String[] data = input.nextLine().split(",");
            // just prints out each part of the line of data formatted into even columns
            System.out.printf("%-11s %-11s $%-11s \n", data[0], data[1], data[2]);
        }
    }
}
