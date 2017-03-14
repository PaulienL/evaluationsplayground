package com.cegeka.school.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(path = "example")
public class ExampleController {

    @RequestMapping(method = GET )
    public String printHelloWorld(){
        return "Hello World !";
    }

}
