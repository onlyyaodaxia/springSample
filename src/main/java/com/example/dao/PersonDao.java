package com.example.dao;

import com.example.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface PersonDao {
    Person  selectById (int id );
    ArrayList<Person> selectAll();
}
