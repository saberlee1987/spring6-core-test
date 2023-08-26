package com.saberspringcore.test.services.impl;

import com.saberspringcore.test.model.Person;
import com.saberspringcore.test.repositories.PersonRepository;
import com.saberspringcore.test.services.PersonService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

   // @Autowired
    private PersonRepository personRepository;

    public PersonServiceImpl() {
        System.out.println("~~~~~~ constructor personService called    ~~~~~~~");
       // this.personRepository = personRepository;
    }

    @PostConstruct
    public void init(){
        System.out.println("~~~ init method in personService ~~~~");
    }

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        System.out.println("~ injecting dependency using setter  personRepository ~");
        this.personRepository = personRepository;
    }

    @Override
    public Person save(Person person) {
        String nationalCode = person.getNationalCode();
        Person personFind = personRepository.findByNationalCode(nationalCode);
        if (personFind != null) {
            throw new RuntimeException(String.format("person with nationalCode %s already exist", nationalCode));
        }
        return personRepository.save(person);
    }

    @Override
    public Person update(Person person) {
        return null;
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findByNationalCode(String nationalCode) {
        Person person = personRepository.findByNationalCode(nationalCode);
        if (person == null) {
            throw new RuntimeException(String.format("person with nationalCode %s does not exist", nationalCode));
        }
        return person;
    }

    @Override
    public Person findById(Integer id) {
        Person person = personRepository.findById(id);
        if (person == null) {
            throw new RuntimeException(String.format("person with id %s does not exist", id));
        }
        return person;
    }

    @Override
    public boolean delete(Integer id) {
        findById(id);
        return personRepository.delete(id);
    }
}
