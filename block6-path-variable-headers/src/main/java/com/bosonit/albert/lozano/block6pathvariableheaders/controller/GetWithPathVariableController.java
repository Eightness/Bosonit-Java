/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.albert.lozano.block6pathvariableheaders.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class GetWithPathVariableController.
 */
@RestController
@RequestMapping("/user")
public class GetWithPathVariableController {

    /**
     * Method handleGetRequest. Get request.
     * @param id String via path variable.
     * @return id.
     */
    @GetMapping("/{id}")
    public String handleGetRequest(@PathVariable String id) {
        return id;
    }
}
