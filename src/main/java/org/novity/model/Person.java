package org.novity.model;

public class Person {
    private String name;
    private String firstname;

    public String getFullName() {
        return getFirstname() + " " + getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
