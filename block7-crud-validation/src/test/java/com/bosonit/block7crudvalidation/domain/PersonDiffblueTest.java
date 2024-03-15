package com.bosonit.block7crudvalidation.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {Person.class})
@ExtendWith(SpringExtension.class)
class PersonDiffblueTest {
    @Autowired
    private Person person;

    /**
     * Method under test: {@link Person#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        // Arrange, Act and Assert
        assertFalse((new Person()).canEqual("Other"));
    }

    /**
     * Method under test: {@link Person#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        // Arrange
        Person person2 = new Person();

        Person person3 = new Person();
        person3.setActive(true);
        person3.setCity("Oxford");
        person3.setCompanyEmail("jane.doe@example.org");
        person3.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person3.setImageUrl("https://example.org/example");
        person3.setLogin("Login");
        person3.setName("Name");
        person3.setPassword("iloveyou");
        person3.setPersonId(1L);
        person3.setPersonalEmail("jane.doe@example.org");
        person3.setSurname("Doe");
        person3.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        // Act and Assert
        assertTrue(person2.canEqual(person3));
    }

    /**
     * Method under test: {@link Person#canEqual(Object)}
     */
    @Test
    void testCanEqual3() {
        // Arrange
        java.sql.Date createdDate = mock(java.sql.Date.class);

        // Act and Assert
        assertFalse((new Person(1L, "Login", "iloveyou", "Name", "Doe", "jane.doe@example.org", "jane.doe@example.org",
                "Oxford", true, createdDate, "https://example.org/example",
                java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())))
                .canEqual("Other"));
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals() {
        // Arrange
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompanyEmail("jane.doe@example.org");
        person.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person.setImageUrl("https://example.org/example");
        person.setLogin("Login");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonId(1L);
        person.setPersonalEmail("jane.doe@example.org");
        person.setSurname("Doe");
        person.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        // Act and Assert
        assertNotEquals(person, null);
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals2() {
        // Arrange
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompanyEmail("jane.doe@example.org");
        person.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person.setImageUrl("https://example.org/example");
        person.setLogin("Login");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonId(1L);
        person.setPersonalEmail("jane.doe@example.org");
        person.setSurname("Doe");
        person.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        // Act and Assert
        assertNotEquals(person, "Different type to Person");
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals3() {
        // Arrange
        Person person = new Person();
        person.setActive(false);
        person.setCity("Oxford");
        person.setCompanyEmail("jane.doe@example.org");
        person.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person.setImageUrl("https://example.org/example");
        person.setLogin("Login");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonId(1L);
        person.setPersonalEmail("jane.doe@example.org");
        person.setSurname("Doe");
        person.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        Person person2 = new Person();
        person2.setActive(true);
        person2.setCity("Oxford");
        person2.setCompanyEmail("jane.doe@example.org");
        person2.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person2.setImageUrl("https://example.org/example");
        person2.setLogin("Login");
        person2.setName("Name");
        person2.setPassword("iloveyou");
        person2.setPersonId(1L);
        person2.setPersonalEmail("jane.doe@example.org");
        person2.setSurname("Doe");
        person2.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        // Act and Assert
        assertNotEquals(person, person2);
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals4() {
        // Arrange
        Person person = new Person();
        person.setActive(null);
        person.setCity("Oxford");
        person.setCompanyEmail("jane.doe@example.org");
        person.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person.setImageUrl("https://example.org/example");
        person.setLogin("Login");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonId(1L);
        person.setPersonalEmail("jane.doe@example.org");
        person.setSurname("Doe");
        person.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        Person person2 = new Person();
        person2.setActive(true);
        person2.setCity("Oxford");
        person2.setCompanyEmail("jane.doe@example.org");
        person2.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person2.setImageUrl("https://example.org/example");
        person2.setLogin("Login");
        person2.setName("Name");
        person2.setPassword("iloveyou");
        person2.setPersonId(1L);
        person2.setPersonalEmail("jane.doe@example.org");
        person2.setSurname("Doe");
        person2.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        // Act and Assert
        assertNotEquals(person, person2);
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals5() {
        // Arrange
        Person person = new Person();
        person.setActive(true);
        person.setCity("London");
        person.setCompanyEmail("jane.doe@example.org");
        person.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person.setImageUrl("https://example.org/example");
        person.setLogin("Login");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonId(1L);
        person.setPersonalEmail("jane.doe@example.org");
        person.setSurname("Doe");
        person.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        Person person2 = new Person();
        person2.setActive(true);
        person2.setCity("Oxford");
        person2.setCompanyEmail("jane.doe@example.org");
        person2.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person2.setImageUrl("https://example.org/example");
        person2.setLogin("Login");
        person2.setName("Name");
        person2.setPassword("iloveyou");
        person2.setPersonId(1L);
        person2.setPersonalEmail("jane.doe@example.org");
        person2.setSurname("Doe");
        person2.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        // Act and Assert
        assertNotEquals(person, person2);
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals6() {
        // Arrange
        Person person = new Person();
        person.setActive(true);
        person.setCity(null);
        person.setCompanyEmail("jane.doe@example.org");
        person.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person.setImageUrl("https://example.org/example");
        person.setLogin("Login");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonId(1L);
        person.setPersonalEmail("jane.doe@example.org");
        person.setSurname("Doe");
        person.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        Person person2 = new Person();
        person2.setActive(true);
        person2.setCity("Oxford");
        person2.setCompanyEmail("jane.doe@example.org");
        person2.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person2.setImageUrl("https://example.org/example");
        person2.setLogin("Login");
        person2.setName("Name");
        person2.setPassword("iloveyou");
        person2.setPersonId(1L);
        person2.setPersonalEmail("jane.doe@example.org");
        person2.setSurname("Doe");
        person2.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        // Act and Assert
        assertNotEquals(person, person2);
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals7() {
        // Arrange
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompanyEmail("john.smith@example.org");
        person.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person.setImageUrl("https://example.org/example");
        person.setLogin("Login");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonId(1L);
        person.setPersonalEmail("jane.doe@example.org");
        person.setSurname("Doe");
        person.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        Person person2 = new Person();
        person2.setActive(true);
        person2.setCity("Oxford");
        person2.setCompanyEmail("jane.doe@example.org");
        person2.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person2.setImageUrl("https://example.org/example");
        person2.setLogin("Login");
        person2.setName("Name");
        person2.setPassword("iloveyou");
        person2.setPersonId(1L);
        person2.setPersonalEmail("jane.doe@example.org");
        person2.setSurname("Doe");
        person2.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        // Act and Assert
        assertNotEquals(person, person2);
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals8() {
        // Arrange
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompanyEmail(null);
        person.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person.setImageUrl("https://example.org/example");
        person.setLogin("Login");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonId(1L);
        person.setPersonalEmail("jane.doe@example.org");
        person.setSurname("Doe");
        person.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        Person person2 = new Person();
        person2.setActive(true);
        person2.setCity("Oxford");
        person2.setCompanyEmail("jane.doe@example.org");
        person2.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person2.setImageUrl("https://example.org/example");
        person2.setLogin("Login");
        person2.setName("Name");
        person2.setPassword("iloveyou");
        person2.setPersonId(1L);
        person2.setPersonalEmail("jane.doe@example.org");
        person2.setSurname("Doe");
        person2.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        // Act and Assert
        assertNotEquals(person, person2);
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals9() {
        // Arrange
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompanyEmail("jane.doe@example.org");
        person.setCreatedDate(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person.setImageUrl("https://example.org/example");
        person.setLogin("Login");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonId(1L);
        person.setPersonalEmail("jane.doe@example.org");
        person.setSurname("Doe");
        person.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        Person person2 = new Person();
        person2.setActive(true);
        person2.setCity("Oxford");
        person2.setCompanyEmail("jane.doe@example.org");
        person2.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person2.setImageUrl("https://example.org/example");
        person2.setLogin("Login");
        person2.setName("Name");
        person2.setPassword("iloveyou");
        person2.setPersonId(1L);
        person2.setPersonalEmail("jane.doe@example.org");
        person2.setSurname("Doe");
        person2.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        // Act and Assert
        assertNotEquals(person, person2);
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals10() {
        // Arrange
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompanyEmail("jane.doe@example.org");
        person.setCreatedDate(null);
        person.setImageUrl("https://example.org/example");
        person.setLogin("Login");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonId(1L);
        person.setPersonalEmail("jane.doe@example.org");
        person.setSurname("Doe");
        person.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        Person person2 = new Person();
        person2.setActive(true);
        person2.setCity("Oxford");
        person2.setCompanyEmail("jane.doe@example.org");
        person2.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person2.setImageUrl("https://example.org/example");
        person2.setLogin("Login");
        person2.setName("Name");
        person2.setPassword("iloveyou");
        person2.setPersonId(1L);
        person2.setPersonalEmail("jane.doe@example.org");
        person2.setSurname("Doe");
        person2.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        // Act and Assert
        assertNotEquals(person, person2);
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals11() {
        // Arrange
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompanyEmail("jane.doe@example.org");
        person.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person.setImageUrl("Login");
        person.setLogin("Login");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonId(1L);
        person.setPersonalEmail("jane.doe@example.org");
        person.setSurname("Doe");
        person.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        Person person2 = new Person();
        person2.setActive(true);
        person2.setCity("Oxford");
        person2.setCompanyEmail("jane.doe@example.org");
        person2.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person2.setImageUrl("https://example.org/example");
        person2.setLogin("Login");
        person2.setName("Name");
        person2.setPassword("iloveyou");
        person2.setPersonId(1L);
        person2.setPersonalEmail("jane.doe@example.org");
        person2.setSurname("Doe");
        person2.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        // Act and Assert
        assertNotEquals(person, person2);
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals12() {
        // Arrange
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompanyEmail("jane.doe@example.org");
        person.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person.setImageUrl(null);
        person.setLogin("Login");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonId(1L);
        person.setPersonalEmail("jane.doe@example.org");
        person.setSurname("Doe");
        person.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        Person person2 = new Person();
        person2.setActive(true);
        person2.setCity("Oxford");
        person2.setCompanyEmail("jane.doe@example.org");
        person2.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person2.setImageUrl("https://example.org/example");
        person2.setLogin("Login");
        person2.setName("Name");
        person2.setPassword("iloveyou");
        person2.setPersonId(1L);
        person2.setPersonalEmail("jane.doe@example.org");
        person2.setSurname("Doe");
        person2.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        // Act and Assert
        assertNotEquals(person, person2);
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals13() {
        // Arrange
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompanyEmail("jane.doe@example.org");
        person.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person.setImageUrl("https://example.org/example");
        person.setLogin("iloveyou");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonId(1L);
        person.setPersonalEmail("jane.doe@example.org");
        person.setSurname("Doe");
        person.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        Person person2 = new Person();
        person2.setActive(true);
        person2.setCity("Oxford");
        person2.setCompanyEmail("jane.doe@example.org");
        person2.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person2.setImageUrl("https://example.org/example");
        person2.setLogin("Login");
        person2.setName("Name");
        person2.setPassword("iloveyou");
        person2.setPersonId(1L);
        person2.setPersonalEmail("jane.doe@example.org");
        person2.setSurname("Doe");
        person2.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        // Act and Assert
        assertNotEquals(person, person2);
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals14() {
        // Arrange
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompanyEmail("jane.doe@example.org");
        person.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person.setImageUrl("https://example.org/example");
        person.setLogin(null);
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonId(1L);
        person.setPersonalEmail("jane.doe@example.org");
        person.setSurname("Doe");
        person.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        Person person2 = new Person();
        person2.setActive(true);
        person2.setCity("Oxford");
        person2.setCompanyEmail("jane.doe@example.org");
        person2.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person2.setImageUrl("https://example.org/example");
        person2.setLogin("Login");
        person2.setName("Name");
        person2.setPassword("iloveyou");
        person2.setPersonId(1L);
        person2.setPersonalEmail("jane.doe@example.org");
        person2.setSurname("Doe");
        person2.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        // Act and Assert
        assertNotEquals(person, person2);
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals15() {
        // Arrange
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompanyEmail("jane.doe@example.org");
        person.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person.setImageUrl("https://example.org/example");
        person.setLogin("Login");
        person.setName("Login");
        person.setPassword("iloveyou");
        person.setPersonId(1L);
        person.setPersonalEmail("jane.doe@example.org");
        person.setSurname("Doe");
        person.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        Person person2 = new Person();
        person2.setActive(true);
        person2.setCity("Oxford");
        person2.setCompanyEmail("jane.doe@example.org");
        person2.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person2.setImageUrl("https://example.org/example");
        person2.setLogin("Login");
        person2.setName("Name");
        person2.setPassword("iloveyou");
        person2.setPersonId(1L);
        person2.setPersonalEmail("jane.doe@example.org");
        person2.setSurname("Doe");
        person2.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        // Act and Assert
        assertNotEquals(person, person2);
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals16() {
        // Arrange
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompanyEmail("jane.doe@example.org");
        person.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person.setImageUrl("https://example.org/example");
        person.setLogin("Login");
        person.setName(null);
        person.setPassword("iloveyou");
        person.setPersonId(1L);
        person.setPersonalEmail("jane.doe@example.org");
        person.setSurname("Doe");
        person.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        Person person2 = new Person();
        person2.setActive(true);
        person2.setCity("Oxford");
        person2.setCompanyEmail("jane.doe@example.org");
        person2.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person2.setImageUrl("https://example.org/example");
        person2.setLogin("Login");
        person2.setName("Name");
        person2.setPassword("iloveyou");
        person2.setPersonId(1L);
        person2.setPersonalEmail("jane.doe@example.org");
        person2.setSurname("Doe");
        person2.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        // Act and Assert
        assertNotEquals(person, person2);
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals17() {
        // Arrange
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompanyEmail("jane.doe@example.org");
        person.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person.setImageUrl("https://example.org/example");
        person.setLogin("Login");
        person.setName("Name");
        person.setPassword("Login");
        person.setPersonId(1L);
        person.setPersonalEmail("jane.doe@example.org");
        person.setSurname("Doe");
        person.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        Person person2 = new Person();
        person2.setActive(true);
        person2.setCity("Oxford");
        person2.setCompanyEmail("jane.doe@example.org");
        person2.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person2.setImageUrl("https://example.org/example");
        person2.setLogin("Login");
        person2.setName("Name");
        person2.setPassword("iloveyou");
        person2.setPersonId(1L);
        person2.setPersonalEmail("jane.doe@example.org");
        person2.setSurname("Doe");
        person2.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        // Act and Assert
        assertNotEquals(person, person2);
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals18() {
        // Arrange
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompanyEmail("jane.doe@example.org");
        person.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person.setImageUrl("https://example.org/example");
        person.setLogin("Login");
        person.setName("Name");
        person.setPassword(null);
        person.setPersonId(1L);
        person.setPersonalEmail("jane.doe@example.org");
        person.setSurname("Doe");
        person.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        Person person2 = new Person();
        person2.setActive(true);
        person2.setCity("Oxford");
        person2.setCompanyEmail("jane.doe@example.org");
        person2.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person2.setImageUrl("https://example.org/example");
        person2.setLogin("Login");
        person2.setName("Name");
        person2.setPassword("iloveyou");
        person2.setPersonId(1L);
        person2.setPersonalEmail("jane.doe@example.org");
        person2.setSurname("Doe");
        person2.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        // Act and Assert
        assertNotEquals(person, person2);
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals19() {
        // Arrange
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompanyEmail("jane.doe@example.org");
        person.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person.setImageUrl("https://example.org/example");
        person.setLogin("Login");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonId(2L);
        person.setPersonalEmail("jane.doe@example.org");
        person.setSurname("Doe");
        person.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        Person person2 = new Person();
        person2.setActive(true);
        person2.setCity("Oxford");
        person2.setCompanyEmail("jane.doe@example.org");
        person2.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person2.setImageUrl("https://example.org/example");
        person2.setLogin("Login");
        person2.setName("Name");
        person2.setPassword("iloveyou");
        person2.setPersonId(1L);
        person2.setPersonalEmail("jane.doe@example.org");
        person2.setSurname("Doe");
        person2.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        // Act and Assert
        assertNotEquals(person, person2);
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals20() {
        // Arrange
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompanyEmail("jane.doe@example.org");
        person.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person.setImageUrl("https://example.org/example");
        person.setLogin("Login");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonId(1L);
        person.setPersonalEmail("john.smith@example.org");
        person.setSurname("Doe");
        person.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        Person person2 = new Person();
        person2.setActive(true);
        person2.setCity("Oxford");
        person2.setCompanyEmail("jane.doe@example.org");
        person2.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person2.setImageUrl("https://example.org/example");
        person2.setLogin("Login");
        person2.setName("Name");
        person2.setPassword("iloveyou");
        person2.setPersonId(1L);
        person2.setPersonalEmail("jane.doe@example.org");
        person2.setSurname("Doe");
        person2.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        // Act and Assert
        assertNotEquals(person, person2);
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals21() {
        // Arrange
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompanyEmail("jane.doe@example.org");
        person.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person.setImageUrl("https://example.org/example");
        person.setLogin("Login");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonId(1L);
        person.setPersonalEmail(null);
        person.setSurname("Doe");
        person.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        Person person2 = new Person();
        person2.setActive(true);
        person2.setCity("Oxford");
        person2.setCompanyEmail("jane.doe@example.org");
        person2.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person2.setImageUrl("https://example.org/example");
        person2.setLogin("Login");
        person2.setName("Name");
        person2.setPassword("iloveyou");
        person2.setPersonId(1L);
        person2.setPersonalEmail("jane.doe@example.org");
        person2.setSurname("Doe");
        person2.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        // Act and Assert
        assertNotEquals(person, person2);
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals22() {
        // Arrange
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompanyEmail("jane.doe@example.org");
        person.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person.setImageUrl("https://example.org/example");
        person.setLogin("Login");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonId(1L);
        person.setPersonalEmail("jane.doe@example.org");
        person.setSurname("Login");
        person.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        Person person2 = new Person();
        person2.setActive(true);
        person2.setCity("Oxford");
        person2.setCompanyEmail("jane.doe@example.org");
        person2.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person2.setImageUrl("https://example.org/example");
        person2.setLogin("Login");
        person2.setName("Name");
        person2.setPassword("iloveyou");
        person2.setPersonId(1L);
        person2.setPersonalEmail("jane.doe@example.org");
        person2.setSurname("Doe");
        person2.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        // Act and Assert
        assertNotEquals(person, person2);
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals23() {
        // Arrange
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompanyEmail("jane.doe@example.org");
        person.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person.setImageUrl("https://example.org/example");
        person.setLogin("Login");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonId(1L);
        person.setPersonalEmail("jane.doe@example.org");
        person.setSurname(null);
        person.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        Person person2 = new Person();
        person2.setActive(true);
        person2.setCity("Oxford");
        person2.setCompanyEmail("jane.doe@example.org");
        person2.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person2.setImageUrl("https://example.org/example");
        person2.setLogin("Login");
        person2.setName("Name");
        person2.setPassword("iloveyou");
        person2.setPersonId(1L);
        person2.setPersonalEmail("jane.doe@example.org");
        person2.setSurname("Doe");
        person2.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        // Act and Assert
        assertNotEquals(person, person2);
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals24() {
        // Arrange
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompanyEmail("jane.doe@example.org");
        person.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person.setImageUrl("https://example.org/example");
        person.setLogin("Login");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonId(1L);
        person.setPersonalEmail("jane.doe@example.org");
        person.setSurname("Doe");
        person.setTerminationDate(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        Person person2 = new Person();
        person2.setActive(true);
        person2.setCity("Oxford");
        person2.setCompanyEmail("jane.doe@example.org");
        person2.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person2.setImageUrl("https://example.org/example");
        person2.setLogin("Login");
        person2.setName("Name");
        person2.setPassword("iloveyou");
        person2.setPersonId(1L);
        person2.setPersonalEmail("jane.doe@example.org");
        person2.setSurname("Doe");
        person2.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        // Act and Assert
        assertNotEquals(person, person2);
    }

    /**
     * Method under test: {@link Person#equals(Object)}
     */
    @Test
    void testEquals25() {
        // Arrange
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompanyEmail("jane.doe@example.org");
        person.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person.setImageUrl("https://example.org/example");
        person.setLogin("Login");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonId(1L);
        person.setPersonalEmail("jane.doe@example.org");
        person.setSurname("Doe");
        person.setTerminationDate(null);

        Person person2 = new Person();
        person2.setActive(true);
        person2.setCity("Oxford");
        person2.setCompanyEmail("jane.doe@example.org");
        person2.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person2.setImageUrl("https://example.org/example");
        person2.setLogin("Login");
        person2.setName("Name");
        person2.setPassword("iloveyou");
        person2.setPersonId(1L);
        person2.setPersonalEmail("jane.doe@example.org");
        person2.setSurname("Doe");
        person2.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        // Act and Assert
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
    void testEqualsAndHashCode() {
        // Arrange
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompanyEmail("jane.doe@example.org");
        person.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person.setImageUrl("https://example.org/example");
        person.setLogin("Login");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonId(1L);
        person.setPersonalEmail("jane.doe@example.org");
        person.setSurname("Doe");
        person.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        // Act and Assert
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
    void testEqualsAndHashCode2() {
        // Arrange
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompanyEmail("jane.doe@example.org");
        person.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person.setImageUrl("https://example.org/example");
        person.setLogin("Login");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonId(1L);
        person.setPersonalEmail("jane.doe@example.org");
        person.setSurname("Doe");
        person.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        Person person2 = new Person();
        person2.setActive(true);
        person2.setCity("Oxford");
        person2.setCompanyEmail("jane.doe@example.org");
        person2.setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        person2.setImageUrl("https://example.org/example");
        person2.setLogin("Login");
        person2.setName("Name");
        person2.setPassword("iloveyou");
        person2.setPersonId(1L);
        person2.setPersonalEmail("jane.doe@example.org");
        person2.setSurname("Doe");
        person2.setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        // Act and Assert
        assertEquals(person, person2);
        int expectedHashCodeResult = person.hashCode();
        assertEquals(expectedHashCodeResult, person2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Person#Person()}
     *   <li>{@link Person#setActive(Boolean)}
     *   <li>{@link Person#setCity(String)}
     *   <li>{@link Person#setCompanyEmail(String)}
     *   <li>{@link Person#setCreatedDate(Date)}
     *   <li>{@link Person#setImageUrl(String)}
     *   <li>{@link Person#setLogin(String)}
     *   <li>{@link Person#setName(String)}
     *   <li>{@link Person#setPassword(String)}
     *   <li>{@link Person#setPersonId(long)}
     *   <li>{@link Person#setPersonalEmail(String)}
     *   <li>{@link Person#setSurname(String)}
     *   <li>{@link Person#setTerminationDate(Date)}
     *   <li>{@link Person#toString()}
     *   <li>{@link Person#getActive()}
     *   <li>{@link Person#getCity()}
     *   <li>{@link Person#getCompanyEmail()}
     *   <li>{@link Person#getCreatedDate()}
     *   <li>{@link Person#getImageUrl()}
     *   <li>{@link Person#getLogin()}
     *   <li>{@link Person#getName()}
     *   <li>{@link Person#getPassword()}
     *   <li>{@link Person#getPersonId()}
     *   <li>{@link Person#getPersonalEmail()}
     *   <li>{@link Person#getSurname()}
     *   <li>{@link Person#getTerminationDate()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        Person actualPerson = new Person();
        actualPerson.setActive(true);
        actualPerson.setCity("Oxford");
        actualPerson.setCompanyEmail("jane.doe@example.org");
        Date createdDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        actualPerson.setCreatedDate(createdDate);
        actualPerson.setImageUrl("https://example.org/example");
        actualPerson.setLogin("Login");
        actualPerson.setName("Name");
        actualPerson.setPassword("iloveyou");
        actualPerson.setPersonId(1L);
        actualPerson.setPersonalEmail("jane.doe@example.org");
        actualPerson.setSurname("Doe");
        Date terminationDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        actualPerson.setTerminationDate(terminationDate);
        actualPerson.toString();
        Boolean actualActive = actualPerson.getActive();
        String actualCity = actualPerson.getCity();
        String actualCompanyEmail = actualPerson.getCompanyEmail();
        Date actualCreatedDate = actualPerson.getCreatedDate();
        String actualImageUrl = actualPerson.getImageUrl();
        String actualLogin = actualPerson.getLogin();
        String actualName = actualPerson.getName();
        String actualPassword = actualPerson.getPassword();
        long actualPersonId = actualPerson.getPersonId();
        String actualPersonalEmail = actualPerson.getPersonalEmail();
        String actualSurname = actualPerson.getSurname();

        // Assert that nothing has changed
        assertEquals("Doe", actualSurname);
        assertEquals("Login", actualLogin);
        assertEquals("Name", actualName);
        assertEquals("Oxford", actualCity);
        assertEquals("https://example.org/example", actualImageUrl);
        assertEquals("iloveyou", actualPassword);
        assertEquals("jane.doe@example.org", actualCompanyEmail);
        assertEquals("jane.doe@example.org", actualPersonalEmail);
        assertEquals(1L, actualPersonId);
        assertTrue(actualActive);
        assertSame(createdDate, actualCreatedDate);
        assertSame(terminationDate, actualPerson.getTerminationDate());
    }

    /**
     * Method under test:
     * {@link Person#Person(long, String, String, String, String, String, String, String, Boolean, Date, String, Date)}
     */
    @Test
    void testNewPerson() {
        // Arrange
        Date createdDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        Date terminationDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

        // Act
        Person actualPerson = new Person(1L, "Login", "iloveyou", "Name", "Doe", "jane.doe@example.org",
                "jane.doe@example.org", "Oxford", true, createdDate, "https://example.org/example", terminationDate);

        // Assert
        assertEquals("Doe", actualPerson.getSurname());
        assertEquals("Login", actualPerson.getLogin());
        assertEquals("Name", actualPerson.getName());
        assertEquals("Oxford", actualPerson.getCity());
        assertEquals("https://example.org/example", actualPerson.getImageUrl());
        assertEquals("iloveyou", actualPerson.getPassword());
        assertEquals("jane.doe@example.org", actualPerson.getCompanyEmail());
        assertEquals("jane.doe@example.org", actualPerson.getPersonalEmail());
        assertEquals(1L, actualPerson.getPersonId());
        assertTrue(actualPerson.getActive());
        assertSame(createdDate, actualPerson.getCreatedDate());
        assertSame(terminationDate, actualPerson.getTerminationDate());
    }

    /**
     * Method under test:
     * {@link Person#Person(long, String, String, String, String, String, String, String, Boolean, java.util.Date, String, java.util.Date)}
     */
    @Test
    void testNewPerson2() {
        // Arrange
        java.sql.Date createdDate = mock(java.sql.Date.class);
        java.util.Date terminationDate = java.util.Date
                .from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

        // Act
        Person actualPerson = new Person(1L, "Login", "iloveyou", "Name", "Doe", "jane.doe@example.org",
                "jane.doe@example.org", "Oxford", true, createdDate, "https://example.org/example", terminationDate);

        // Assert
        assertEquals("Doe", actualPerson.getSurname());
        assertEquals("Login", actualPerson.getLogin());
        assertEquals("Name", actualPerson.getName());
        assertEquals("Oxford", actualPerson.getCity());
        assertEquals("https://example.org/example", actualPerson.getImageUrl());
        assertEquals("iloveyou", actualPerson.getPassword());
        assertEquals("jane.doe@example.org", actualPerson.getCompanyEmail());
        assertEquals("jane.doe@example.org", actualPerson.getPersonalEmail());
        assertEquals(1L, actualPerson.getPersonId());
        assertTrue(actualPerson.getActive());
        assertSame(terminationDate, actualPerson.getTerminationDate());
        assertSame(createdDate, actualPerson.getCreatedDate());
    }
}
