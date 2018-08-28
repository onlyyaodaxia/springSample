package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("/hello")
    public  String hello(){
        System.out.println("into hello........");
        return  "hello";
    }
}
