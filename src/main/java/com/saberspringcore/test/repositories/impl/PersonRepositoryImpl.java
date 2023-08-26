package com.saberspringcore.test.repositories.impl;

import com.saberspringcore.test.model.Person;
import com.saberspringcore.test.repositories.PersonRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private final static Map<String, Person> PERSON_DATABASE = new ConcurrentHashMap<>();
    private volatile Integer id = 0;

    @Override
    public Person save(Person person) {
        person.setId(nextId());
        PERSON_DATABASE.put(person.getNationalCode(), person);
        return person;
    }

    private synchronized Integer nextId() {
        return ++id;
    }
    @Override
    public Person update(Person person) {
        PERSON_DATABASE.remove(person.getNationalCode());
        PERSON_DATABASE.put(person.getNationalCode(), person);
        return person;
    }

    @Override
    public List<Person> findAll() {
        return new ArrayList<>(PERSON_DATABASE.values());
    }

    @Override
    public Person findByNationalCode(String nationalCode) {
        return PERSON_DATABASE.getOrDefault(nationalCode, null);
    }

    @Override
    public Person findById(Integer id) {
        return PERSON_DATABASE.values().stream().filter(person -> person.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public boolean delete(Integer id) {
        boolean result = false;
        Person person = findById(id);
        if (person != null) {
            PERSON_DATABASE.remove(person.getNationalCode());
            result = true;
        }

        return result;
    }
}
