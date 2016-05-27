package com.theironyard;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static String FILE_NAME = "Countries.txt";

    public static void main(String[] args) throws Exception {
        HashMap<String, ArrayList<Country>> map = new HashMap<>();
        File f = new File(FILE_NAME);
        Scanner fileScanner = new Scanner(f);
        Scanner scanner = new Scanner(System.in);

        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\|");
            Country country = new Country(columns[0], columns[1]);
            String firstLetter = String.valueOf(columns[1].charAt(0));
            String letter = firstLetter.toUpperCase();

            if (!map.containsKey(letter)) {
                map.put(letter, new ArrayList<>());
            }
            //map.get(letter).add(country);
            ArrayList<Country> arrayList = map.get(letter);
            arrayList.add(country);
        }

        System.out.println("Enter a letter to return all countries whose name starts with that letter.");
        String query = (scanner.nextLine());
        String finalQuery = query.toUpperCase();

        File file = new File(finalQuery + "_countries.txt");
        FileWriter fw = new FileWriter(file);

        ArrayList<Country> aL2 = map.get(finalQuery);
        for (Country country : aL2) {
            String line = String.format("%s\n", country.name);
            fw.append(line);
        }
        fw.close();




//        System.out.println(map);

//
//        if (finalQuery.length() > 1) {
//            throw new Exception ("You did not enter a single letter.");
//        }
//        else {
//
//            JsonSerializer serializer = new JsonSerializer();
//            String json = serializer.serialize(map.get(finalQuery));
//            String fileLetter = query.toUpperCase();
//            String fileName = fileLetter + "_countries.txt";
//            File file = new File(fileName);
//            FileWriter fw = new FileWriter(file);
//            fw.write(json);
//            fw.close();
    }
}
