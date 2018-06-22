package com.microservice.people.api.service.person;

import com.microservice.people.api.domain.person.Person;

/**
 * Created by lusouza on 20/06/18.
 */
public interface PersonCacheService {
    Person findById(String id);
    void save(String id);
    void delete(String id);
    void update(String id);
}
