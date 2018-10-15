package com.szymanowski;

public abstract class Entity {

    private String name;
    private String surname;


    public Entity(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Entity(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
