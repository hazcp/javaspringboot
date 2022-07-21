package com.qa.PersonProjectSky.services;

import com.qa.PersonProjectSky.entities.Person;
import com.qa.PersonProjectSky.entities.PersonDTO;
import com.qa.PersonProjectSky.entities.PersonRepo;
import com.qa.PersonProjectSky.exceptions.PersonNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepo repo;
    private ModelMapper mapper;

    public PersonService(PersonRepo repo, ModelMapper mapper) {
        super();
        this.repo = repo;
        this.mapper = mapper;
    }

    private PersonDTO mapToDTO(Person person) {
        return this.mapper.map(person, PersonDTO.class);
    }

    public String test() {
        return "Testing 1, 2, 3";
    }

    public PersonDTO addPerson(Person person) {
        Person saved = this.repo.save(person);
        return this.mapToDTO(saved);
    }

    public List<PersonDTO> getAll() {
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public PersonDTO getById(Long id) {
        Person found = this.repo.findById(id).orElseThrow(PersonNotFoundException::new);
        return this.mapToDTO(found);
    }

    public PersonDTO updatePerson(Long id, Person person) {
        Optional<Person> existingOptional = this.repo.findById(id);
        Person existing = existingOptional.get();
        existing.setAge(person.getAge());
        existing.setFirstName(person.getFirstName());
        existing.setLastName(person.getLastName());
        Person updated = this.repo.save(existing);
        return this.mapToDTO(updated);
    }

    public boolean deletePerson(Long id) {
        this.repo.deleteById(id);
        boolean exists = this.repo.existsById(id);
        return !exists;
    }
}
