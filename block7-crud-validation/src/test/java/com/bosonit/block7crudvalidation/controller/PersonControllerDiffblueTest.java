package com.bosonit.block7crudvalidation.controller;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.bosonit.block7crudvalidation.application.implementations.PersonServiceImpl;
import com.bosonit.block7crudvalidation.controller.dto.inputDto.PersonInputDto;
import com.bosonit.block7crudvalidation.controller.dto.outputDto.PersonOutputDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {PersonController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class PersonControllerDiffblueTest {
  @Autowired
  private PersonController personController;

  @MockBean
  private PersonServiceImpl personServiceImpl;

  /**
   * Method under test: {@link PersonController#deleteAllPersons()}
   */
  @Test
  void testDeleteAllPersons() throws Exception {
    // Arrange
    doNothing().when(personServiceImpl).deleteAllEntities();
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/person/delete/all");

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(personController)
            .build()
            .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
  }

  /**
   * Method under test:
   * {@link PersonController#getCustomPersons(String, String, String, Date, boolean, boolean, int, int)}
   */
  @Test
  void testGetCustomPersons() throws Exception {
    // Arrange
    when(personServiceImpl.getCustomPersons(Mockito.<HashMap<String, Object>>any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/person/get/custom");
    MockHttpServletRequestBuilder paramResult = getResult.param("pageNumber", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(personController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Method under test:
   * {@link PersonController#getCustomPersons(String, String, String, Date, boolean, boolean, int, int)}
   */
  @Test
  void testGetCustomPersons2() throws Exception {
    // Arrange
    when(personServiceImpl.getCustomPersons(Mockito.<HashMap<String, Object>>any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/person/get/custom");
    MockHttpServletRequestBuilder paramResult = getResult.param("pageNumber", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(0));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(personController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Method under test:
   * {@link PersonController#getCustomPersons(String, String, String, Date, boolean, boolean, int, int)}
   */
  @Test
  void testGetCustomPersons3() throws Exception {
    // Arrange
    when(personServiceImpl.getCustomPersons(Mockito.<HashMap<String, Object>>any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/person/get/custom");
    MockHttpServletRequestBuilder paramResult = getResult.param("pageNumber", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1))
            .param("login", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(personController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Method under test:
   * {@link PersonController#getCustomPersons(String, String, String, Date, boolean, boolean, int, int)}
   */
  @Test
  void testGetCustomPersons4() throws Exception {
    // Arrange
    when(personServiceImpl.getCustomPersons(Mockito.<HashMap<String, Object>>any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/person/get/custom");
    MockHttpServletRequestBuilder paramResult = getResult.param("pageNumber", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1))
            .param("name", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(personController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Method under test:
   * {@link PersonController#getCustomPersons(String, String, String, Date, boolean, boolean, int, int)}
   */
  @Test
  void testGetCustomPersons5() throws Exception {
    // Arrange
    when(personServiceImpl.getCustomPersons(Mockito.<HashMap<String, Object>>any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/person/get/custom");
    MockHttpServletRequestBuilder paramResult = getResult.param("pageNumber", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1))
            .param("surname", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(personController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Method under test: {@link PersonController#deleteAllPersons()}
   */
  @Test
  void testDeleteAllPersons2() throws Exception {
    // Arrange
    doNothing().when(personServiceImpl).deleteAllEntities();
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/person/delete/all");
    requestBuilder.contentType("https://example.org/example");

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(personController)
            .build()
            .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
  }

  /**
   * Method under test: {@link PersonController#deletePersonById(long)}
   */
  @Test
  void testDeletePersonById() throws Exception {
    // Arrange
    doNothing().when(personServiceImpl).deleteEntityById(Mockito.<Long>any());
    MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/person/delete");
    MockHttpServletRequestBuilder requestBuilder = deleteResult.param("id", String.valueOf(1L));

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(personController)
            .build()
            .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
  }

  /**
   * Method under test: {@link PersonController#getAllPersons()}
   */
  @Test
  void testGetAllPersons() throws Exception {
    // Arrange
    when(personServiceImpl.getAllEntities(anyInt(), anyInt())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/person/get/all");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(personController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Method under test: {@link PersonController#getPersonById(long)}
   */
  @Test
  void testGetPersonById() throws Exception {
    // Arrange
    when(personServiceImpl.getEntityById(Mockito.<Long>any())).thenReturn(new PersonOutputDto());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/person/get");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1L));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(personController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content()
                    .string(
                            "{\"personId\":0,\"login\":null,\"name\":null,\"surname\":null,\"companyEmail\":null,\"personalEmail\":null,\"city"
                                    + "\":null,\"active\":false,\"createdDate\":null,\"imageUrl\":null,\"terminationDate\":null}"));
  }

  /**
   * Method under test:
   * {@link PersonController#patchPersonById(long, PersonInputDto)}
   */
  @Test
  void testPatchPersonById() throws Exception {
    // Arrange
    when(personServiceImpl.modifyEntityById(Mockito.<Long>any(), Mockito.<PersonInputDto>any()))
            .thenReturn(new PersonOutputDto());

    PersonInputDto personInputDto = new PersonInputDto();
    personInputDto.setActive(true);
    personInputDto.setCity("Oxford");
    personInputDto.setCompanyEmail("jane.doe@example.org");
    personInputDto
            .setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    personInputDto.setImageUrl("https://example.org/example");
    personInputDto.setLogin("Login");
    personInputDto.setName("Name");
    personInputDto.setPassword("iloveyou");
    personInputDto.setPersonalEmail("jane.doe@example.org");
    personInputDto.setSurname("Doe");
    personInputDto
            .setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    String content = (new ObjectMapper()).writeValueAsString(personInputDto);
    MockHttpServletRequestBuilder patchResult = MockMvcRequestBuilders.patch("/person/patch");
    MockHttpServletRequestBuilder requestBuilder = patchResult.param("id", String.valueOf(1L))
            .contentType(MediaType.APPLICATION_JSON)
            .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(personController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content()
                    .string(
                            "{\"personId\":0,\"login\":null,\"name\":null,\"surname\":null,\"companyEmail\":null,\"personalEmail\":null,\"city"
                                    + "\":null,\"active\":false,\"createdDate\":null,\"imageUrl\":null,\"terminationDate\":null}"));
  }

  /**
   * Method under test: {@link PersonController#postPerson(PersonInputDto)}
   */
  @Test
  void testPostPerson() throws Exception {
    // Arrange
    when(personServiceImpl.addEntity(Mockito.<PersonInputDto>any())).thenReturn(new PersonOutputDto());

    PersonInputDto personInputDto = new PersonInputDto();
    personInputDto.setActive(true);
    personInputDto.setCity("Oxford");
    personInputDto.setCompanyEmail("jane.doe@example.org");
    personInputDto
            .setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    personInputDto.setImageUrl("https://example.org/example");
    personInputDto.setLogin("Login");
    personInputDto.setName("Name");
    personInputDto.setPassword("iloveyou");
    personInputDto.setPersonalEmail("jane.doe@example.org");
    personInputDto.setSurname("Doe");
    personInputDto
            .setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    String content = (new ObjectMapper()).writeValueAsString(personInputDto);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/person/post")
            .contentType(MediaType.APPLICATION_JSON)
            .content(content);

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(personController)
            .build()
            .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content()
                    .string(
                            "{\"personId\":0,\"login\":null,\"name\":null,\"surname\":null,\"companyEmail\":null,\"personalEmail\":null,\"city"
                                    + "\":null,\"active\":false,\"createdDate\":null,\"imageUrl\":null,\"terminationDate\":null}"));
  }

  /**
   * Method under test:
   * {@link PersonController#putPersonById(long, PersonInputDto)}
   */
  @Test
  void testPutPersonById() throws Exception {
    // Arrange
    when(personServiceImpl.updateEntityById(Mockito.<Long>any(), Mockito.<PersonInputDto>any()))
            .thenReturn(new PersonOutputDto());

    PersonInputDto personInputDto = new PersonInputDto();
    personInputDto.setActive(true);
    personInputDto.setCity("Oxford");
    personInputDto.setCompanyEmail("jane.doe@example.org");
    personInputDto
            .setCreatedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    personInputDto.setImageUrl("https://example.org/example");
    personInputDto.setLogin("Login");
    personInputDto.setName("Name");
    personInputDto.setPassword("iloveyou");
    personInputDto.setPersonalEmail("jane.doe@example.org");
    personInputDto.setSurname("Doe");
    personInputDto
            .setTerminationDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    String content = (new ObjectMapper()).writeValueAsString(personInputDto);
    MockHttpServletRequestBuilder putResult = MockMvcRequestBuilders.put("/person/put");
    MockHttpServletRequestBuilder requestBuilder = putResult.param("id", String.valueOf(1L))
            .contentType(MediaType.APPLICATION_JSON)
            .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(personController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content()
                    .string(
                            "{\"personId\":0,\"login\":null,\"name\":null,\"surname\":null,\"companyEmail\":null,\"personalEmail\":null,\"city"
                                    + "\":null,\"active\":false,\"createdDate\":null,\"imageUrl\":null,\"terminationDate\":null}"));
  }
}
