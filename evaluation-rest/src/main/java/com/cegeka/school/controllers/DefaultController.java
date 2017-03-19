package com.cegeka.school.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class DefaultController {

    @RequestMapping(method = RequestMethod.GET)
    public String helloWorld(){
        return "Hello world";
    }

}
