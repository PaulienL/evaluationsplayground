package com.cegeka.school.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@CrossOrigin
@RestController
@RequestMapping(path = "example")
public class ExampleController {

    @RequestMapping(method = GET )
    @Secured({"ROLE_USER"})
    public String printHelloWorld(){
        return "Hello World !";
    }



}
