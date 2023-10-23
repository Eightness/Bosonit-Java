/**
 * Class Main - block1-process-file-and-streams
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        String relativePath = "res/people.csv"; //Change if needed

        //Getting the list from the CSV file.
        try {
            personList = personReader.readPersonsFromCSV(relativePath);
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file. Details: " + e.getMessage());
            e.printStackTrace();
        }

        //Filter people by age, < 25.
        List<Person> filteredList1 = getFilteredList1(personReader, relativePath, 25);

        //Filter people by name, starts with A.
        List<Person> filteredList2 = getFilteredList2(personReader, relativePath, "A");

        //OUTPUT:

        //First output.
        System.out.println();
        printArray(personList);

        //Second output.
        System.out.println();
        printArray(filteredList1);

        //Third output.
        System.out.println();
        printArray(filteredList2);

        //Fourth output.
        System.out.println();
        getFirstPersonFrom(filteredList1, "Madrid").ifPresent(person -> {
            System.out.println("First person from Madrid: " + person);
        });

        //Fifth output.
        System.out.println();
        getFirstPersonFrom(filteredList2, "Barcelona").ifPresent(person -> {
            System.out.println("First person from Barcelona: " + person);
        });
    }

    /**
     * Function to filter people by age (known and inferior to x).
     *
     * @param personReader Instance of class PersonReader.
     * @param path Path to find the file.
     * @param age Age to filter.
     * @return Returns the desired filtered list or an empty one if fails.
     */
    private static List<Person> getFilteredList1(PersonReader personReader, String path, int age) {
        try {
            return personReader.readPersonsFromCSV(path).stream()
                    .filter(person -> !person.getAge().equals("Unknown"))   //Checking "Unknown" first to get rid of all the "String" ages, so the next filter won't fail.
                    .filter(person -> Integer.parseInt(person.getAge()) < age)
                    .toList();
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file. Details: " + e.getMessage());
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    /**
     * Function to filter people by the name's first letter.
     *
     * @param personReader Instance of class PersonReader.
     * @param path Path to find the file.
     * @param firstLetter Name's first letter to filter.
     * @return Returns the desired filtered list or an empty one if fails.
     */
    private static List<Person> getFilteredList2(PersonReader personReader, String path, String firstLetter) {
        try {
            return personReader.readPersonsFromCSV(path).stream()
                    .filter(person -> !person.getName().startsWith(firstLetter))
                    .toList();
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file. Details: " + e.getMessage());
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    /**
     * Function to get the first element from a list that lives in a determined town.
     *
     * @param personList People list.
     * @param town Town to search for.
     * @return First person that lives in a determined town.
     */
    private static Optional<Person> getFirstPersonFrom(List<Person> personList, String town) {
        return personList.stream()
                .filter(person -> person.getTown().equalsIgnoreCase(town))
                .findFirst();
    }

    /**
     * Function to print a given people list.
     *
     * @param personList List to print.
     */
    private static void printArray(List<Person> personList) {
        for (Person person : personList) {
            System.out.println(person);
        }
    }

}