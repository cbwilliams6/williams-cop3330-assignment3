/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Christian Williams
 */

package ex43;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) throws IOException {
        Scanner input = new Scanner(System.in);

        // taking in all user inputs for the site name, author name, and if they want javascript/css folders
        System.out.print("Site name: ");
        String siteName = input.nextLine();
        System.out.print("Author: ");
        String author = input.nextLine();
        System.out.print("Do you want a folder for JavaScript? ");
        String javascript = input.nextLine();
        System.out.print("Do you want a folder for CSS? ");
        String css = input.nextLine();

        // two methods, one creates the overall website folder that everything goes in + the index.html file; the other adds the javascript and css files
        websiteGenerator(siteName, author);
        folderGenerator(siteName, javascript, css);
    }

    public static void websiteGenerator(String siteName, String author) throws IOException {
        // just setting the directory for the files to a variable, so I don't need to keep writing it out
        String directory = ".\\src\\main\\java\\ex43" + "\\" + siteName;

        // creates a folder titled with the siteName inside the ex43 package folder
        new File(directory).mkdirs();
        System.out.print("Created " + directory + "\n");

        // creates the index.html file inside the previously made folder
        FileWriter index = new FileWriter(new File(directory + "\\index.html"));
        System.out.print("Created " + directory + "\\index.html\n");

        // writes to the html file, setting the title to the input site name and adds some text saying the input author name
        index.write("<html><title>" + siteName + "</title>");
        index.write("<meta>" + author + "</meta></html>");

        // closing the FileWriter so it actually writes
        index.close();
    }

    public static void folderGenerator(String siteName, String javascript, String css) {
        String directory = ".\\src\\main\\java\\ex43" + "\\" + siteName;

        // checks if the user entered that they want the javascript folder created
        if(javascript.equalsIgnoreCase("y")) {
            // creates the new javascript folder inside the main website folder
            new File(directory + "\\js").mkdirs();
            System.out.print("Created " + directory + "\\js\n");
        }
        else
            System.out.print("Did not create JavaScript folder\n");

        // checks if the user entered that they want the css folder created
        if(css.equalsIgnoreCase("y")) {
            // creates the new css folder inside the main website folder
            new File(directory + "\\css").mkdirs();
            System.out.print("Created " + directory + "\\css\n");
        }
        else
            System.out.print("Did not create CSS folder");
    }
}