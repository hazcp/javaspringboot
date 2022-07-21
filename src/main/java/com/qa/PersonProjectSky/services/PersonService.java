package com.qa.PersonProjectSky.services;

import com.qa.PersonProjectSky.entities.Person;
import com.qa.PersonProjectSky.entities.PersonRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private PersonRepo repo;

    public PersonService(PersonRepo repo) {
        super();
        this.repo = repo;
    }

    public String test() {
        return "Testing 1, 2, 3";
    }

    public Person addPerson(Person person) {
        return this.repo.save(person);
    }

    public List<Person> getAll() {
        return this.repo.findAll();
    }

    public Person updatePerson(Long id, Person person) {
        Optional<Person> existingOptional = this.repo.findById(id);
        Person existingPerson = existingOptional.get();
        existingPerson.setAge(person.getAge());
        existingPerson.setFirstName(person.getFirstName());
        existingPerson.setLastName(person.getLastName());
        return this.repo.save(existingPerson);
    }

    public boolean deletePerson(Long id) {
        this.repo.deleteById(id);
        boolean exists = this.repo.existsById(id);
        return !exists;
    }
}
