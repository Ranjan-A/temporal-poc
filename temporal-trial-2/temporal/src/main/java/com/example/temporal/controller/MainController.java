package com.example.temporal.controller;

import com.example.temporal.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    MainService mainService;

    @GetMapping("/hello")
    public String startWorkflow(){
        return mainService.startworkflow();
    }
}
