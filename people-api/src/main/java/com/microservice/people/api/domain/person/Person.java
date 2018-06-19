package com.microservice.people.api.domain.person;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by lusouza on 18/06/18.
 */
@Document(collection = "person")
public class Person {
    @Id
    private String id;
    private String name;
    private String lastName;
    private Integer age;
    private String document;
    private boolean authorized;

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getDocument() {
        return document;
    }

    public String getId() {
        return id;
    }

    public boolean isAuthorized() {
        return authorized;
    }
}
