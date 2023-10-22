/**
 * Class PersonReader - block1-process-file-and-streams
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A utility class for reading and parsing data from a CSV file to create a list of persons.
 */
public class PersonReader {

    /**
     * Reads a CSV file containing person data and returns a list of persons.
     *
     * @param filePath The path to the CSV file to read.
     * @return A list of Person objects read from the CSV file.
     * @throws IOException If there is an issue reading the file.
     */
    public List<Person> readPersonsFromCSV(String filePath) throws IOException {
        List<Person> personList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    Person person = parsePersonFromCSV(line);
                    personList.add(person);
                } catch (InvalidLineFormatException e) {
                    System.err.println("Error processing line: '" + line + "'.");
                    e.printStackTrace();
                }
            }
        }

        return personList;
    }

    /**
     * Parses a single line from the CSV file and creates a Person object.
     *
     * @param line A line from the CSV file.
     * @return A Person object representing the data in the CSV line.
     * @throws InvalidLineFormatException If the CSV line has an invalid format.
     */
    private Person parsePersonFromCSV(String line) throws InvalidLineFormatException {
        String[] fields = line.split(":", -1);  //The limit parameter controls the number of times the pattern is applied and therefore affects the length of the resulting array.

        if (fields.length != 3) {
            throw new InvalidLineFormatException("Expected 2 delimiters ':' but found " + (fields.length - 1) + ".");
        }

        try {
            String name = fields[0];
            String town = fields[1];
            String age = fields[2];
            return new Person(name, town, age);
        } catch (FieldRequiredException e) {
            throw new InvalidLineFormatException(e.getMessage());
        }

    }

}
