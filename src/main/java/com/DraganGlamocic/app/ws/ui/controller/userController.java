package com.DraganGlamocic.app.ws.ui.controller;

import com.DraganGlamocic.app.ws.ui.model.response.userRest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")  // http://localhost:8080/users
public class userController {

    @GetMapping
    public String getUser(@RequestParam(value="page", defaultValue = "1") int page,
                          @RequestParam(value="limit", defaultValue = "20") int limit,
                          @RequestParam(value="sort", defaultValue = "desc",required = false) String sort)
    {
        return "get users was called with [Page: " + page + "] / [Limit: " + limit + "] / [Sort: " + sort +"]";
    }

    @GetMapping(path= "/{userId}",
            produces= {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
    })

    public userRest getUser(@PathVariable String userId) {
        userRest returnValue = new userRest();
        returnValue.setFirstName("Dragan");
        returnValue.setLastName("Glamocic");
        returnValue.setEmail("example@gmail.com");
       // returnValue.setUserId("3");

    return returnValue;
    }

    @PostMapping
    public String createUser(){
        return "create user was called";
    }

    @PutMapping
    public String updateUser(){
            return "update user was called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete user was called";
    }

}
