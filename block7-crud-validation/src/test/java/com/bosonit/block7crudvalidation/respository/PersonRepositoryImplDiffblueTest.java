package com.bosonit.block7crudvalidation.respository;

import com.bosonit.block7crudvalidation.controller.dto.outputDto.PersonOutputDto;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PersonRepositoryImpl.class})
@ExtendWith(SpringExtension.class)
class PersonRepositoryImplDiffblueTest {
    @Autowired
    private PersonRepositoryImpl personRepositoryImpl;

    /**
     * Method under test: {@link PersonRepositoryImpl#getCustomPersons(HashMap)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetCustomPersons() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        HashMap<String, Object> conditions = null;

        // Act
        List<PersonOutputDto> actualCustomPersons = this.personRepositoryImpl.getCustomPersons(conditions);

        // Assert
        // TODO: Add assertions on result
    }
}
