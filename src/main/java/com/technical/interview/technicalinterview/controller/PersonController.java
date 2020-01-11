package com.technical.interview.technicalinterview.controller;

import com.technical.interview.technicalinterview.model.Person;
import com.technical.interview.technicalinterview.repository.PersonRepository;
import com.technical.interview.technicalinterview.exception.ResourceNotFoundException;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Api(value="Employee Management System")
public class PersonController {

    @Autowired
    private PersonRepository personRepository ;

    /**
     * Creates and inserts person into database
     * @param person person object
     * @return the person object for the created person with valid ID
     */
    @PostMapping("/person")
    public Person createPerson(@Valid @RequestBody Person person){
        return personRepository.save(person);
    }

    /**
     * Updates a person's info with another person object
     * @param id Person's ID
     * @param updatedPerson Updated info for person going to be updated
     * @return Returns server response
     * @throws ResourceNotFoundException Thrown if person with said ID doesn't exist
     */
    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") Long id, @Valid @RequestBody Person updatedPerson) throws ResourceNotFoundException {
        Person personData = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found" + id));
        personData.setFirstName(updatedPerson.getFirstName());
        personData.setLastName(updatedPerson.getLastName());
        personData.setCapitalWorth(updatedPerson.getCapitalWorth());
        personData.setLastUpdatedDate(new Date());
        return ResponseEntity.ok(personData);
    }

    /**
     * Gets all the people in the database
     * @return Returns list of all people
     */
    @GetMapping("/person")
    public List<Person> getAllPerson(){
        return personRepository.findAll();
    }

    /**
     * Gets a person with a certain ID
     * @param id ID of person to be retrieved
     * @return Returns person object
     * @throws ResourceNotFoundException Thrown if person doesn't exist
     */
    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found" + id));
        return ResponseEntity.ok().body(person);
    }
}
