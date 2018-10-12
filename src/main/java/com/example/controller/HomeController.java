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
    @RequestMapping("/index")
    public  String index(){
        System.out.println("into index........");
        return  "index";
    }

    @RequestMapping("/dubbo")
    public  String sendDubbo( ){
        System.out.println("into dubbo........");
        return  "dubbo";
    }

}
