package com.microservice.people.api.repository.mongo.person;

import com.microservice.people.api.domain.person.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by lusouza on 19/06/18.
 */
public interface PersonRepository extends MongoRepository<Person, String> {

}
