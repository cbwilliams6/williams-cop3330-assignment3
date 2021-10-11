/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Christian Williams
 */

package ex44;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) throws IOException {
        Scanner input = new Scanner(System.in);
        Gson gson = new Gson();
        // creating a file reader to be able to read from the input, so we can make a json object out of it
        FileReader fileReader = new FileReader(".\\src\\main\\java\\ex44\\exercise44_input.json");
        // creating a json object out of the contents of the input file
        JsonObject jsonObject = gson.fromJson(fileReader, JsonObject.class);
        // converting the json object into a json array to search through later
        JsonArray jsonArray = jsonObject.getAsJsonArray("products");
        boolean nameFound = false;

        // looping through the other method until the user enters a valid product name
        while (nameFound == false){
            // prompting for the product name
            System.out.print("What is the product name? ");
            String enteredName = input.nextLine();
            nameFound = searchProducts(jsonArray, enteredName);
        }
    }

    public static boolean searchProducts(JsonArray jsonArray, String enteredName) {
        boolean nameFound = false;

        // loops through each object in the json array, so we can pull out the info one at a time
        for (Object object : jsonArray) {
            // to be honest I don't really understand what this line does, but through lots of trying random things I found that it's really necessary
            JsonObject product = (JsonObject) object;
            // storing each value of the object into a respective variable
            String name = product.get("name").getAsString();
            double price = product.get("price").getAsDouble();
            int quantity = product.get("quantity").getAsInt();

            // checking if the name of the product matches what the user entered earlier
            if (name.equalsIgnoreCase(enteredName)) {
                // if so, then set that the name was found, so we don't loop anymore and then print out all that product's info
                nameFound = true;
                System.out.print("\nName: " + name + "\nPrice: $" + String.format("%.2f", price) + "\nQuantity: " + quantity);
            }
        }

        if (nameFound == false) {
            // if the name of the product wasn't found in the json array then keep nameFound as false, so we can prompt for a new name and rerun the whole thing
            System.out.print("Sorry, that product was not found in our inventory.\n");
        }

        // return whether the user found the product they searched for or not
        return nameFound;
    }
}