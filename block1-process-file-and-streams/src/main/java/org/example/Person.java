/**
 * Class Person - block1-process-file-and-streams
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package org.example;

/**
 * This class represents a person with attributes name, town, and age.
 */
public class Person {
    // Class attributes
    private String name;  // The name of the person
    private String town;  // The town of the person
    private String age;   // The age of the person

    /**
     * Default constructor that initializes an instance of Person with no values.
     */
    public Person() {}

    /**
     * Constructor that initializes an instance of Person with all attributes.
     *
     * @param name The name of the person.
     * @param town The town of the person.
     * @param age  The age of the person.
     */
    public Person(String name, String town, String age) {
        this.name = name;
        this.town = town;
        this.age = age;
    }

    // Setters and Getters

    /**
     * Set the name of the person.
     *
     * @param name The name of the person.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the town of the person.
     *
     * @param town The town of the person.
     */
    public void setTown(String town) {
        this.town = town;
    }

    /**
     * Set the age of the person.
     *
     * @param age The age of the person.
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * Get the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the town of the person.
     *
     * @return The town of the person.
     */
    public String getTown() {
        return town;
    }

    /**
     * Get the age of the person.
     *
     * @return The age of the person.
     */
    public String getAge() {
        return age;
    }

    //Methods

    /**
     * toString method override. Prints a person in the console.
     *
     * @return String consisting of the person's attributes to print in the console.
     */
    public String toString() {
        return "Name: " + this.name + ". Town: " + this.town + ". Age: " + this.age + ".";
    }
}
