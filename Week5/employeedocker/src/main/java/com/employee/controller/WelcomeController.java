package com.employee.controller;

import com.employee.services.InstanceInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Autowired
    private InstanceInformationService instanceInformationService;

    @GetMapping(path = "hello-world")
    public String hello(){
        return instanceInformationService.retrieveInstanceInfo()+": "+ "productapp "+ "v2";
    }
}