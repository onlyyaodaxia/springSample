package com.example.service;

import com.example.dao.PersonDao;
import com.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    PersonDao personDao;

    public String query(int id){
        Person person = personDao.selectById(1);
        return  person.getEmail();

    }

    public static void main(String[] args) {

//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext1.xml");
        ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");

        PersonService personService = (PersonService)ctx.getBean("personService");;
        System.out.println(personService.query(1));
    }

}
