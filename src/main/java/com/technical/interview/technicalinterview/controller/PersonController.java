package com.technical.interview.technicalinterview.controller;

import com.technical.interview.technicalinterview.model.Person;
import com.technical.interview.technicalinterview.repository.PersonRepository;
import com.technical.interview.technicalinterview.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PersonController {
    private PersonRepository personRepository;

    @PostMapping("/person")
    public Person createPerson(@Valid @RequestBody Person person){
        return personRepository.save(person);
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") Long id, @Valid @RequestBody Person updatedPerson) throws ResourceNotFoundException {
        Person personData = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found" + id));
        personData.setFirstName(updatedPerson.getFirstName());
        personData.setLastName(updatedPerson.getLastName());
        personData.setCapitalWorth(updatedPerson.getCapitalWorth());
        personData.setLastUpdatedDate(new Date());
        return ResponseEntity.ok(personData);
    }

    @GetMapping("/users")
    public List<Person> getAllPerson(){
        return personRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found" + id));
        return ResponseEntity.ok().body(person);
    }
}
