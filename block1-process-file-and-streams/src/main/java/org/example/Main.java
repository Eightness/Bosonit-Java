/**
 * Class Main - block1-process-file-and-streams
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Main class of the program.
 */
public class Main {
    /**
     * The main entry point for the application.
     *
     * @param args The command-line arguments provided when running the application.
     */
    public static void main(String[] args) {

        PersonReader personReader = new PersonReader();

        List<Person> personList = new ArrayList<>();
        String relativePath = "res/people.csv";

        try {
            personList = personReader.readPersonsFromCSV(relativePath);
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file. Details: " + e.getMessage());
            e.printStackTrace();
        }

        //Output
        for (Person person : personList) {
            System.out.println(person);
        }
    }
}