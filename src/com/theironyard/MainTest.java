package com.theironyard;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by will on 5/28/16.
 */
public class MainTest {

    static final String FILE_NAME = "Countries.txt";

    @Test
    public void readAndCreate() throws Exception {
        HashMap<String, ArrayList<Country>> testMap = new HashMap<>();

        File f = new File(FILE_NAME);
        Scanner testScanner = new Scanner(f);

        while (testScanner.hasNext()) {
            Main.readFile(testScanner, testMap);
        }

        String finalQuery = "B";

        Main.createList(finalQuery, testMap);

        assertTrue(testMap != null);
    }



}