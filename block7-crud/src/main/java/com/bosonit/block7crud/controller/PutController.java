/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block7crud.controller;

import com.bosonit.block7crud.application.PersonService;
import com.bosonit.block7crud.controller.dto.PersonInputDto;
import com.bosonit.block7crud.controller.dto.PersonOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Class PutController. Controller that will manage all put requests.
 */
@RestController
@RequestMapping("/person")
public class PutController {
    //Dependencies injection.
    @Autowired
    private PersonService personService;

    //Methods.
    /**
     * Method updatePerson. Updates an already existing person in our database.
     * @param id provided by the user.
     * @param personInputDto new person provided by the user.
     * @return ResponseEntity with this new person to PersonOutputDto.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<PersonOutputDto> updatePerson(
            @PathVariable int id,
            @RequestBody PersonInputDto personInputDto
    ) {
        try {
            return ResponseEntity.ok().body(personService.updatePerson(id, personInputDto));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
