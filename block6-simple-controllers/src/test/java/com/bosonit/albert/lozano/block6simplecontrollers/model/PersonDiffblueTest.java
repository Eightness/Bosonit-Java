package com.bosonit.albert.lozano.block6simplecontrollers.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PersonDiffblueTest {
    /**
     * Method under test: {@link Person#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new Person()).canEqual("Other"));
    }

    /**
     * Method under test: {@link Person#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        Person person = new Person();
        person.setAge(1);
        person.setName("Name");
        person.setTown("Oxford");

        Person person2 = new Person();
        person2.setAge(1);
        person2.setName("Name");
        person2.setTown("Oxford");
        assertTrue(person.canEqual(person2));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Person}
     *   <li>{@link Person#setAge(int)}
     *   <li>{@link Person#setName(String)}
     *   <li>{@link Person#setTown(String)}
     *   <li>{@link Person#toString()}
     *   <li>{@link Person#getAge()}
     *   <li>{@link Person#getName()}
     *   <li>{@link Person#getTown()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Person actualPerson = new Person();
        actualPerson.setAge(1);
        actualPerson.setName("Name");
        actualPerson.setTown("Oxford");
        String actualToStringResult = actualPerson.toString();
        int actualAge = actualPerson.getAge();
        String actualName = actualPerson.getName();
        assertEquals(1, actualAge);
        assertEquals("Name", actualName);
        assertEquals("Oxford", actualPerson.getTown());
        assertEquals("Person(name=Name, town=Oxford, age=1)", actualToStringResult);
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals() {
        Person person = new Person();
        person.setAge(1);
        person.setName("Name");
        person.setTown("Oxford");
        assertNotEquals(person, null);
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals2() {
        Person person = new Person();
        person.setAge(1);
        person.setName("Name");
        person.setTown("Oxford");
        assertNotEquals(person, "Different type to Person");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Person#equals(Object)}
     *   <li>{@link Person#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        Person person = new Person();
        person.setAge(1);
        person.setName("Name");
        person.setTown("Oxford");
        assertEquals(person, person);
        int expectedHashCodeResult = person.hashCode();
        assertEquals(expectedHashCodeResult, person.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Person#equals(Object)}
     *   <li>{@link Person#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        Person person = new Person();
        person.setAge(1);
        person.setName("Name");
        person.setTown("Oxford");

        Person person2 = new Person();
        person2.setAge(1);
        person2.setName("Name");
        person2.setTown("Oxford");
        assertEquals(person, person2);
        int expectedHashCodeResult = person.hashCode();
        assertEquals(expectedHashCodeResult, person2.hashCode());
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals5() {
        Person person = new Person();
        person.setAge(3);
        person.setName("Name");
        person.setTown("Oxford");

        Person person2 = new Person();
        person2.setAge(1);
        person2.setName("Name");
        person2.setTown("Oxford");
        assertNotEquals(person, person2);
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals6() {
        Person person = new Person();
        person.setAge(1);
        person.setName("Oxford");
        person.setTown("Oxford");

        Person person2 = new Person();
        person2.setAge(1);
        person2.setName("Name");
        person2.setTown("Oxford");
        assertNotEquals(person, person2);
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals7() {
        Person person = new Person();
        person.setAge(1);
        person.setName(null);
        person.setTown("Oxford");

        Person person2 = new Person();
        person2.setAge(1);
        person2.setName("Name");
        person2.setTown("Oxford");
        assertNotEquals(person, person2);
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals8() {
        Person person = new Person();
        person.setAge(1);
        person.setName("Name");
        person.setTown("Name");

        Person person2 = new Person();
        person2.setAge(1);
        person2.setName("Name");
        person2.setTown("Oxford");
        assertNotEquals(person, person2);
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals9() {
        Person person = new Person();
        person.setAge(1);
        person.setName("Name");
        person.setTown(null);

        Person person2 = new Person();
        person2.setAge(1);
        person2.setName("Name");
        person2.setTown("Oxford");
        assertNotEquals(person, person2);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Person#equals(Object)}
     *   <li>{@link Person#hashCode()}
     * </ul>
     */
    @Test
    void testEquals10() {
        Person person = new Person();
        person.setAge(1);
        person.setName(null);
        person.setTown("Oxford");

        Person person2 = new Person();
        person2.setAge(1);
        person2.setName(null);
        person2.setTown("Oxford");
        assertEquals(person, person2);
        int expectedHashCodeResult = person.hashCode();
        assertEquals(expectedHashCodeResult, person2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Person#equals(Object)}
     *   <li>{@link Person#hashCode()}
     * </ul>
     */
    @Test
    void testEquals11() {
        Person person = new Person();
        person.setAge(1);
        person.setName("Name");
        person.setTown(null);

        Person person2 = new Person();
        person2.setAge(1);
        person2.setName("Name");
        person2.setTown(null);
        assertEquals(person, person2);
        int expectedHashCodeResult = person.hashCode();
        assertEquals(expectedHashCodeResult, person2.hashCode());
    }
}

