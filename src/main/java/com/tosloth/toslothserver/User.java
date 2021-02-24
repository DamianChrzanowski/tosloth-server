package com.tosloth.toslothserver;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "Users")
class User {

    @Id
    private String id;
    private String name;
    private String lastname;
    private String email;

    public User() {}

    User(String name, String lastname, String email) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof User))
            return false;
        User employee = (User) o;
        return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name)
                && Objects.equals(this.lastname, employee.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.lastname);
    }

    @Override
    public String toString() {
        return "Employee: {" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.lastname + '\'' + '}';
    }
}