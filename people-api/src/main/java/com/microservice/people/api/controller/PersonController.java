package com.microservice.people.api.controller;

import com.microservice.people.api.domain.person.Person;
import com.microservice.people.api.queue.PersonAuthorizationProducer;
import com.microservice.people.api.service.person.PersonService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

/**
 * Created by lusouza on 18/06/18.
 */
@Api
@RestController
@RequestMapping(value = "/v1/api/people", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class PersonController {

    @Autowired
    private PersonService personService;
    @Autowired
    private PersonAuthorizationProducer personAuthorizationProducer;

    @GetMapping("/{id}")
    public Person get(@PathVariable String id){
        return personService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Person> post (@RequestBody Person person) throws Exception {
        final Person personSaved = personService.save(person);
        return ResponseEntity.created(new URI("/api/people/"+personSaved.getId())).body(personSaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> requestAuthorization(@PathVariable String id){
        personAuthorizationProducer.send(id);
        return ResponseEntity.accepted().body("Under review.");
    }
}
