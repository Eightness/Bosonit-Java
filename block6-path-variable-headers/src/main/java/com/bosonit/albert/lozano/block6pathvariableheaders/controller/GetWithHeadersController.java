/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.albert.lozano.block6pathvariableheaders.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class GetWithHeadersController.
 */
@RestController
@RequestMapping("/header")
public class GetWithHeadersController {

    /**
     * Method handleGetRequest. Get request.
     * @param h1 String with the value of header 1.
     * @param h2 String with the value of header 2.
     * @return a message that shows both values.
     */
    @GetMapping
    public String handleGetRequest(
            @RequestHeader("h1") String h1,
            @RequestHeader("h2") String h2
    ) {
        return "Header h1: " + h1 + ", Header h2: " + h2;
    }
}
