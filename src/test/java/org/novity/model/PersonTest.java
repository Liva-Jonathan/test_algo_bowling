package org.novity.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person person;

    @BeforeEach
    void setUp() {
        this.person = new Person();
    }

    @Test
    void getFullName() {
        person.setFirstname("lisa");
        person.setName("simpson");
        assertEquals("lisa simpson", person.getFullName());
    }

    @Test
    void getName() {
        person.setName("simpson");
        assertEquals("simpson", person.getName());
    }

    @Test
    void getFirstname() {
        person.setFirstname("bart");
        assertEquals("bart", person.getFirstname());
    }
}