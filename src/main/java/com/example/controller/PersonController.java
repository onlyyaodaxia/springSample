package com.example.controller;


import com.example.dao.PersonDao;
import com.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/person")
@ResponseBody
public class PersonController {
    @Autowired
    PersonDao personDao;

    @RequestMapping("/query")
    public Person query(@RequestParam(required = false) int id){
        Person person = personDao.selectById(id);
        return  person;

    }

    @RequestMapping("/queryAll")
    public ArrayList<Person> queryAll(){
        ArrayList<Person> personList = personDao.selectAll();
        return  personList;

    }


}
