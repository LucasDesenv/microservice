package com.microservice.people.api.service.person;

import com.microservice.people.api.domain.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by lusouza on 20/06/18.
 */
@Service
public class PersonCacheServiceImpl implements PersonCacheService {
    private RedisTemplate<String, Person> redisTemplate;
    private HashOperations hashOps;

    @Autowired
    public PersonCacheServiceImpl(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOps = redisTemplate.opsForHash();
    }

    @Override
    public Person findById(String id) {
        return (Person) hashOps.get("person", id);
    }

    @Override
    public void save(Person person) {
        hashOps.put("person", person.getId() , person);
    }

    @Override
    public void delete(String id) {

    }
}
