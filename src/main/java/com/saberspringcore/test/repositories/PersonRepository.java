package com.saberspringcore.test.repositories;

import com.saberspringcore.test.model.Person;

import java.util.List;
public interface PersonRepository {
    Person save(Person person);
    Person update(Person person);
    List<Person> findAll();
    Person findByNationalCode(String nationalCode);
    Person findById(Integer id);
    boolean delete(Integer id);
}