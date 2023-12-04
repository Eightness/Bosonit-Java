/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.albert.lozano.block6pathvariableheaders.controller;

import com.bosonit.albert.lozano.block6pathvariableheaders.model.AllDataResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class PostAllDataController.
 */
@RestController
@RequestMapping("/all")
public class PostAllDataController {

    @PostMapping
    public AllDataResponse handlePostRequest(
        @RequestBody(required = false) String body,
        @RequestParam(required = false) List<String> requestParams,
        @RequestHeader(value = "h1", required = false) String h1,
        @RequestHeader(value = "h2", required = false) String h2
    ) {
        AllDataResponse response = new AllDataResponse();
        response.setBody(body);
        response.setRequestParams(requestParams);
        response.setH1(h1);
        response.setH2(h2);

        return response;
    }
}
