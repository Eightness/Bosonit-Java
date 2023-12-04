/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.albert.lozano.block6pathvariableheaders.controller;

import com.bosonit.albert.lozano.block6pathvariableheaders.model.MyObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Class PostJsonController.
 */
@RestController
@RequestMapping("/postJson")
public class PostJsonController {

    /** STATIC
     * Method handlePostRequest. Post request. -> Using as a template "MyObject".
     * @param myObject an instance of MyObject.
     * @return that instance.
     */
    @PostMapping
    public MyObject handlePostRequest(@RequestBody MyObject myObject) {
        return myObject;
    }

    /** DYNAMIC
     * Method handlePostRequest. Post request. -> Using a map to process any Object.
     * @param json a map that contains a String key and the object requested in the body.
     * @return json, map created.
     */
    @PostMapping
    public Map<String, Object> handlePostRequest(Map<String, Object> json) {
        //We could proceed and modify the map logic here.
        //This way we will get any object type from the body's json.
        return json;
    }

}
