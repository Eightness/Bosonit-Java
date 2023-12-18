package com.bosonit.block7crud.controller;

import static org.mockito.Mockito.when;

import com.bosonit.block7crud.application.PersonService;
import com.bosonit.block7crud.controller.dto.PersonInputDto;
import com.bosonit.block7crud.controller.dto.PersonOutputDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {PostController.class})
@ExtendWith(SpringExtension.class)
class PostControllerDiffblueTest {
    @MockBean
    private PersonService personService;

    @Autowired
    private PostController postController;

    /**
     * Method under test: {@link PostController#addPerson(PersonInputDto)}
     */
    @Test
    void testAddPerson() throws Exception {
        when(personService.addPerson(Mockito.<PersonInputDto>any()))
                .thenReturn(new PersonOutputDto(1, "Output Name", "Output Age", "Output Town"));

        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setInputAge("Input Age");
        personInputDto.setInputName("Input Name");
        personInputDto.setInputTown("Input Town");
        String content = (new ObjectMapper()).writeValueAsString(personInputDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/person/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(postController).build().perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"outputName\":\"Output Name\",\"outputAge\":\"Output Age\",\"outputTown\":\"Output Town\"}"));
    }
}

