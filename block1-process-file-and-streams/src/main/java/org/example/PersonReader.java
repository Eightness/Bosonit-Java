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
     * @param filePath the path to the CSV file to read
     * @return a list of Person objects read from the CSV file
     * @throws IOException if there is an issue reading the file
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
                    System.err.println("Error processing line: " + line + ". Cause: " + e.getMessage());
                }
            }
        }

        return personList;
    }

    /**
     * Parses a single line from the CSV file and creates a Person object.
     *
     * @param line a line from the CSV file
     * @return a Person object representing the data in the CSV line
     * @throws InvalidLineFormatException if the CSV line has an invalid format
     */
    private Person parsePersonFromCSV(String line) throws InvalidLineFormatException {
        String[] fields = line.split(":");

        if (fields.length != 3) {
            switch (fields.length) {
                case 1 -> throw new InvalidLineFormatException("Invalid line format: 2 delimiters ':' missing.");
                case 2 -> throw new InvalidLineFormatException("Invalid line format: 1 delimiter ':' missing");
                default -> throw new InvalidLineFormatException("Invalid line format: more than 3 delimiters ':' found.");
            }
        }

        String name = fields[0];
        if (name.trim().isEmpty()) {
            throw new InvalidLineFormatException("Name is required: " + line);
        }

        String town = (fields[1].trim().isEmpty()) ? "Blank" : fields[1];
        String age;
        if (fields[2].equals("0")) {
            age = "Unknown";
        } else if (fields[2].isBlank()) {
            age = "0";
        } else {
            age = fields[2];
        }

        return new Person(name, town, age);
    }

}
