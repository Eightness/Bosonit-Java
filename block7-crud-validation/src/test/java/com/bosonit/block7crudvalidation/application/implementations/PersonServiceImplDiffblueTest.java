package com.bosonit.block7crudvalidation.application.implementations;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.bosonit.block7crudvalidation.controller.dto.inputDto.PersonInputDto;
import com.bosonit.block7crudvalidation.controller.dto.mappers.PersonMapper;
import com.bosonit.block7crudvalidation.controller.dto.outputDto.PersonOutputDto;
import com.bosonit.block7crudvalidation.domain.Person;
import com.bosonit.block7crudvalidation.respository.PersonRepository;
import jakarta.persistence.EntityExistsException;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PersonServiceImpl.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class PersonServiceImplDiffblueTest {
    @MockBean
    private PersonMapper personMapper;

    @MockBean
    private PersonRepository personRepository;

    @Autowired
    private PersonServiceImpl personServiceImpl;

    /**
     * Method under test: {@link PersonServiceImpl#getEntityById(Long)}
     */
    @Test
    void testGetEntityById() {
        // Arrange
        PersonOutputDto personOutputDto = new PersonOutputDto();
        when(personMapper.domainToOutput(Mockito.<Person>any())).thenReturn(personOutputDto);

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
        Optional<Person> ofResult = Optional.of(person);
        when(personRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        PersonOutputDto actualEntityById = personServiceImpl.getEntityById(1L);

        // Assert
        verify(personMapper).domainToOutput(Mockito.<Person>any());
        verify(personRepository).findById(Mockito.<Long>any());
        assertSame(personOutputDto, actualEntityById);
    }

    /**
     * Method under test: {@link PersonServiceImpl#getEntityById(Long)}
     */
    @Test
    void testGetEntityById2() {
        // Arrange
        when(personMapper.domainToOutput(Mockito.<Person>any())).thenThrow(new EntityExistsException("An error occurred"));

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
        Optional<Person> ofResult = Optional.of(person);
        when(personRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act and Assert
        assertThrows(EntityExistsException.class, () -> personServiceImpl.getEntityById(1L));
        verify(personMapper).domainToOutput(Mockito.<Person>any());
        verify(personRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link PersonServiceImpl#getAllEntities(int, int)}
     */
    @Test
    void testGetAllEntities() {
        // Arrange
        ArrayList<PersonOutputDto> personOutputDtoList = new ArrayList<>();
        when(personMapper.domainToOutput(Mockito.<List<Person>>any())).thenReturn(personOutputDtoList);
        when(personRepository.findAll()).thenReturn(new ArrayList<>());

        // Act
        List<PersonOutputDto> actualAllEntities = personServiceImpl.getAllEntities(10, 3);

        // Assert
        verify(personMapper).domainToOutput(Mockito.<List<Person>>any());
        verify(personRepository).findAll();
        assertTrue(actualAllEntities.isEmpty());
        assertSame(personOutputDtoList, actualAllEntities);
    }

    /**
     * Method under test: {@link PersonServiceImpl#getAllEntities(int, int)}
     */
    @Test
    void testGetAllEntities2() {
        // Arrange
        when(personRepository.findAll()).thenThrow(new EntityExistsException("An error occurred"));

        // Act and Assert
        assertThrows(EntityExistsException.class, () -> personServiceImpl.getAllEntities(10, 3));
        verify(personRepository).findAll();
    }

    /**
     * Method under test: {@link PersonServiceImpl#addEntity(PersonInputDto)}
     */
    @Test
    void testAddEntity() {
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
        PersonOutputDto personOutputDto = new PersonOutputDto();
        when(personMapper.domainToOutput(Mockito.<Person>any())).thenReturn(personOutputDto);
        when(personMapper.inputToDomain(Mockito.<PersonInputDto>any())).thenReturn(person);

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
        when(personRepository.save(Mockito.<Person>any())).thenReturn(person2);

        // Act
        PersonOutputDto actualAddEntityResult = personServiceImpl.addEntity(new PersonInputDto());

        // Assert
        verify(personMapper).domainToOutput(Mockito.<Person>any());
        verify(personMapper).inputToDomain(Mockito.<PersonInputDto>any());
        verify(personRepository).save(Mockito.<Person>any());
        assertSame(personOutputDto, actualAddEntityResult);
    }

    /**
     * Method under test: {@link PersonServiceImpl#addEntity(PersonInputDto)}
     */
    @Test
    void testAddEntity2() {
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
        when(personMapper.inputToDomain(Mockito.<PersonInputDto>any())).thenReturn(person);
        when(personRepository.save(Mockito.<Person>any())).thenThrow(new EntityExistsException("An error occurred"));

        // Act and Assert
        assertThrows(EntityExistsException.class, () -> personServiceImpl.addEntity(new PersonInputDto()));
        verify(personMapper).inputToDomain(Mockito.<PersonInputDto>any());
        verify(personRepository).save(Mockito.<Person>any());
    }

    /**
     * Method under test:
     * {@link PersonServiceImpl#updateEntityById(Long, PersonInputDto)}
     */
    @Test
    void testUpdateEntityById() {
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
        PersonOutputDto personOutputDto = new PersonOutputDto();
        when(personMapper.domainToOutput(Mockito.<Person>any())).thenReturn(personOutputDto);
        when(personMapper.inputToDomain(Mockito.<PersonInputDto>any())).thenReturn(person);

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
        Optional<Person> ofResult = Optional.of(person2);

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
        when(personRepository.save(Mockito.<Person>any())).thenReturn(person3);
        when(personRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        PersonOutputDto actualUpdateEntityByIdResult = personServiceImpl.updateEntityById(1L, new PersonInputDto());

        // Assert
        verify(personMapper).domainToOutput(Mockito.<Person>any());
        verify(personMapper).inputToDomain(Mockito.<PersonInputDto>any());
        verify(personRepository).findById(Mockito.<Long>any());
        verify(personRepository).save(Mockito.<Person>any());
        assertSame(personOutputDto, actualUpdateEntityByIdResult);
    }

    /**
     * Method under test:
     * {@link PersonServiceImpl#updateEntityById(Long, PersonInputDto)}
     */
    @Test
    void testUpdateEntityById2() {
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
        when(personMapper.inputToDomain(Mockito.<PersonInputDto>any())).thenReturn(person);

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
        Optional<Person> ofResult = Optional.of(person2);
        when(personRepository.save(Mockito.<Person>any())).thenThrow(new EntityExistsException("An error occurred"));
        when(personRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act and Assert
        assertThrows(EntityExistsException.class, () -> personServiceImpl.updateEntityById(1L, new PersonInputDto()));
        verify(personMapper).inputToDomain(Mockito.<PersonInputDto>any());
        verify(personRepository).findById(Mockito.<Long>any());
        verify(personRepository).save(Mockito.<Person>any());
    }

    /**
     * Method under test:
     * {@link PersonServiceImpl#modifyEntityById(Long, PersonInputDto)}
     */
    @Test
    void testModifyEntityById() {
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
        PersonOutputDto personOutputDto = new PersonOutputDto();
        when(personMapper.domainToOutput(Mockito.<Person>any())).thenReturn(personOutputDto);
        when(personMapper.inputToDomain(Mockito.<PersonInputDto>any())).thenReturn(person);

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
        Optional<Person> ofResult = Optional.of(person2);

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
        when(personRepository.save(Mockito.<Person>any())).thenReturn(person3);
        when(personRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        PersonOutputDto actualModifyEntityByIdResult = personServiceImpl.modifyEntityById(1L, new PersonInputDto());

        // Assert
        verify(personMapper).domainToOutput(Mockito.<Person>any());
        verify(personMapper).inputToDomain(Mockito.<PersonInputDto>any());
        verify(personRepository).findById(Mockito.<Long>any());
        verify(personRepository).save(Mockito.<Person>any());
        assertSame(personOutputDto, actualModifyEntityByIdResult);
    }

    /**
     * Method under test:
     * {@link PersonServiceImpl#modifyEntityById(Long, PersonInputDto)}
     */
    @Test
    void testModifyEntityById2() {
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
        when(personMapper.inputToDomain(Mockito.<PersonInputDto>any())).thenReturn(person);

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
        Optional<Person> ofResult = Optional.of(person2);
        when(personRepository.save(Mockito.<Person>any())).thenThrow(new EntityExistsException("An error occurred"));
        when(personRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act and Assert
        assertThrows(EntityExistsException.class, () -> personServiceImpl.modifyEntityById(1L, new PersonInputDto()));
        verify(personMapper).inputToDomain(Mockito.<PersonInputDto>any());
        verify(personRepository).findById(Mockito.<Long>any());
        verify(personRepository).save(Mockito.<Person>any());
    }

    /**
     * Method under test: {@link PersonServiceImpl#deleteEntityById(Long)}
     */
    @Test
    void testDeleteEntityById() {
        // Arrange
        doNothing().when(personRepository).deleteById(Mockito.<Long>any());

        // Act
        personServiceImpl.deleteEntityById(1L);

        // Assert that nothing has changed
        verify(personRepository).deleteById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link PersonServiceImpl#deleteEntityById(Long)}
     */
    @Test
    void testDeleteEntityById2() {
        // Arrange
        doThrow(new EntityExistsException("An error occurred")).when(personRepository).deleteById(Mockito.<Long>any());

        // Act and Assert
        assertThrows(EntityExistsException.class, () -> personServiceImpl.deleteEntityById(1L));
        verify(personRepository).deleteById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link PersonServiceImpl#deleteAllEntities()}
     */
    @Test
    void testDeleteAllEntities() {
        // Arrange
        doNothing().when(personRepository).deleteAll();

        // Act
        personServiceImpl.deleteAllEntities();

        // Assert that nothing has changed
        verify(personRepository).deleteAll();
    }

    /**
     * Method under test: {@link PersonServiceImpl#deleteAllEntities()}
     */
    @Test
    void testDeleteAllEntities2() {
        // Arrange
        doThrow(new EntityExistsException("An error occurred")).when(personRepository).deleteAll();

        // Act and Assert
        assertThrows(EntityExistsException.class, () -> personServiceImpl.deleteAllEntities());
        verify(personRepository).deleteAll();
    }

    /**
     * Method under test: {@link PersonServiceImpl#getCustomPersons(HashMap)}
     */
    @Test
    void testGetCustomPersons() {
        // Arrange
        ArrayList<PersonOutputDto> personOutputDtoList = new ArrayList<>();
        when(personRepository.getCustomPersons(Mockito.<HashMap<String, Object>>any())).thenReturn(personOutputDtoList);

        // Act
        List<PersonOutputDto> actualCustomPersons = personServiceImpl.getCustomPersons(new HashMap<>());

        // Assert
        verify(personRepository).getCustomPersons(Mockito.<HashMap<String, Object>>any());
        assertTrue(actualCustomPersons.isEmpty());
        assertSame(personOutputDtoList, actualCustomPersons);
    }

    /**
     * Method under test: {@link PersonServiceImpl#getCustomPersons(HashMap)}
     */
    @Test
    void testGetCustomPersons2() {
        // Arrange
        when(personRepository.getCustomPersons(Mockito.<HashMap<String, Object>>any()))
                .thenThrow(new EntityExistsException("An error occurred"));

        // Act and Assert
        assertThrows(EntityExistsException.class, () -> personServiceImpl.getCustomPersons(new HashMap<>()));
        verify(personRepository).getCustomPersons(Mockito.<HashMap<String, Object>>any());
    }
}
