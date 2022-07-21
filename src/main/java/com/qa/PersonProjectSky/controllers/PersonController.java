package com.qa.PersonProjectSky.controllers;

import com.qa.PersonProjectSky.entities.Person;
import com.qa.PersonProjectSky.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.*;

@RestController
public class PersonController {

    private PersonService service;

    public PersonController(PersonService service) {
        super();
        this.service = service;
    }

    @GetMapping("/test")
    public String test() {
        return "Testing 1, 2, 3";
    }

    @PostMapping("/create")
    public Person addPerson(@RequestBody @Valid Person person) {
        return this.service.addPerson(person);
    }

    @GetMapping("/getAll")
    public List<Person> getAll() {
        return this.service.getAll();
    }

    @PutMapping("/update/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person person) {
        return this.service.updatePerson(id, person);
    }

    @DeleteMapping("/delete")
    public boolean deletePerson(@PathParam("id") Long id) {
        return this.service.deletePerson(id);
    }
}
