/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.albert.lozano.block6pathvariableheaders.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Class PutRequestParamsController.
 */
@RestController
@RequestMapping("/putRequestParams")
public class PutRequestParamsController {

    /**
     * Method handlePutRequest. Put request.
     * @param var1 variable 1 as a parameter.
     * @param var2 variable 2 as a parameter.
     * @return a HashMap composed of "var1" -> value of var1, "var2" -> value of var2.
     */
    @PutMapping
    public Map<String, String> handlePutRequest(
            @RequestParam("var1") String var1,
            @RequestParam("var2") String var2
    ) {
        Map<String, String> response = new HashMap<>();
        response.put("var1", var1);
        response.put("var2", var2);
        return response;
    }
}
