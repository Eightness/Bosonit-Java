package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PersonDiffblueTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Person#Person()}
     *   <li>{@link Person#toString()}
     *   <li>{@link Person#getAge()}
     *   <li>{@link Person#getName()}
     *   <li>{@link Person#getTown()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Person actualPerson = new Person();
        String actualToStringResult = actualPerson.toString();
        String actualAge = actualPerson.getAge();
        String actualName = actualPerson.getName();
        assertNull(actualAge);
        assertNull(actualName);
        assertNull(actualPerson.getTown());
        assertEquals("Name: null. Town: null. Age: null.", actualToStringResult);
    }

    /**
     * Method under test: {@link Person#Person(String, String, String)}
     */
    @Test
    void testConstructor2() throws FieldRequiredException {
        Person actualPerson = new Person("Name", "Oxford", "Age");

        assertEquals("Unknown", actualPerson.getAge());
        assertEquals("Oxford", actualPerson.getTown());
        assertEquals("Name", actualPerson.getName());
    }

    /**
     * Method under test: {@link Person#Person(String, String, String)}
     */
    @Test
    void testConstructor3() throws FieldRequiredException {
        Person actualPerson = new Person("foo", "foo", (String) "0");

        assertEquals("Unknown", actualPerson.getAge());
        assertEquals("foo", actualPerson.getTown());
        assertEquals("foo", actualPerson.getName());
    }

    /**
     * Method under test: {@link Person#Person(String, String, String)}
     */
    @Test
    void testConstructor4() throws FieldRequiredException {
        assertThrows(FieldRequiredException.class, () -> new Person("", "Oxford", "Age"));

    }

    /**
     * Method under test: {@link Person#Person(String, String, String)}
     */
    @Test
    void testConstructor5() throws FieldRequiredException {
        Person actualPerson = new Person("Name", "", "Age");

        assertEquals("Unknown", actualPerson.getAge());
        assertEquals("Unknown", actualPerson.getTown());
        assertEquals("Name", actualPerson.getName());
    }

    /**
     * Method under test: {@link Person#Person(String, String, String)}
     */
    @Test
    void testConstructor6() throws FieldRequiredException {
        Person actualPerson = new Person("Name", "Oxford", "42");

        assertEquals("42", actualPerson.getAge());
        assertEquals("Oxford", actualPerson.getTown());
        assertEquals("Name", actualPerson.getName());
    }

    /**
     * Method under test: {@link Person#setName(String)}
     */
    @Test
    void testSetName() throws FieldRequiredException {
        Person person = new Person("Name", "Oxford", "Age");
        person.setName("Name");
        assertEquals("Name", person.getName());
    }

    /**
     * Method under test: {@link Person#setName(String)}
     */
    @Test
    void testSetName2() throws FieldRequiredException {
        assertThrows(FieldRequiredException.class, () -> (new Person("Name", "Oxford", "Age")).setName(""));
    }

    /**
     * Method under test: {@link Person#setTown(String)}
     */
    @Test
    void testSetTown() throws FieldRequiredException {
        Person person = new Person("Name", "Oxford", "Age");
        person.setTown("Oxford");
        assertEquals("Oxford", person.getTown());
    }

    /**
     * Method under test: {@link Person#setTown(String)}
     */
    @Test
    void testSetTown2() throws FieldRequiredException {
        Person person = new Person("Name", "Oxford", "Age");
        person.setTown("");
        assertEquals("Unknown", person.getTown());
    }

    /**
     * Method under test: {@link Person#setAge(String)}
     */
    @Test
    void testSetAge() throws FieldRequiredException {
        Person person = new Person("Name", "Oxford", "Age");
        person.setAge("Age");
        assertEquals("Unknown", person.getAge());
    }

    /**
     * Method under test: {@link Person#setAge(String)}
     */
    @Test
    void testSetAge2() throws FieldRequiredException {
        Person person = new Person("Name", "Oxford", "Age");
        person.setAge((String) "0");
        assertEquals("Unknown", person.getAge());
    }

    /**
     * Method under test: {@link Person#setAge(String)}
     */
    @Test
    void testSetAge3() throws FieldRequiredException {
        Person person = new Person("Name", "Oxford", "Age");
        person.setAge("42");
        assertEquals("42", person.getAge());
    }
}

