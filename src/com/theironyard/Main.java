package com.theironyard;

import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static String FILE_NAME = "Countries.txt";


    //method to read the Countries.txt file
    public static void readFile(Scanner fileScanner, HashMap<String, ArrayList<Country>> map) {
        String line = fileScanner.nextLine();
        String[] columns = line.split("\\|");
        Country country = new Country(columns[0], columns[1]);
        String firstLetter = String.valueOf(columns[1].charAt(0));
        String letter = firstLetter.toUpperCase();

        if (!map.containsKey(letter)) map.put(letter, new ArrayList<>());

        ArrayList<Country> aL = map.get(letter);
        aL.add(country); //why can't i pass country.name as arg here?
    }



    //method to put each country on its own line in the file i write out for the chosen state
    public static void createList(String finalQuery, HashMap<String, ArrayList<Country>> map) throws IOException {

        File file = new File(finalQuery + "_countries.txt");
        FileWriter fw = new FileWriter(file);

        ArrayList<Country> aL = map.get(finalQuery);
        for (Country country : aL) {
            String line = String.format("%s\n", country.name);
            fw.append(line);
        }
        fw.close();


/**
 *  option 2: JSONSerializer. Working, utilizes JSON, and returns output. chose to go with what is above instead as
 *  output doesn't look as clean as what is above. Maybe just needed to format the output a little better.
 */

//        ArrayList<Country> aL = map.get(finalQuery);
//        JsonSerializer serializer = new JsonSerializer();
//        String json = serializer.serialize(aL);
//        File file = new File(finalQuery + "_countries.txt");
//        FileWriter fw = new FileWriter(file);
//        fw.write(json);
//        fw.close();

    }


    public static void main(String[] args) throws Exception {

        HashMap<String, ArrayList<Country>> map = new HashMap<>();

        File f = new File(FILE_NAME);

        //instantiate 2 different scanners

        Scanner fileScanner = new Scanner(f); // so we can read the countries.txt file
        Scanner scanner = new Scanner(System.in); // so we can read user input

        //while loop that runs readFile method
        while (fileScanner.hasNext()) {
            readFile(fileScanner, map);
        }

        //ask for user input, convert input to uppercase, and then evaluate for valid input.
        System.out.println("Enter a letter to return all countries whose name starts with your chosen letter.");
        String query = (scanner.nextLine());
        String finalQuery = query.toUpperCase();

        if (finalQuery.length() > 1) {
            throw new Exception ("You did not enter a single letter.");
        }
        else {
            createList(finalQuery, map);
        }
    }
}
