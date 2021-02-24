package com.tosloth.toslothserver;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "Users")
public class User {

    @Id
    private String id;
    private String nickname;
    private String firstname;
    private String lastname;
    private String email;

    public User() {}

    public User(String nickname, String firstname, String lastname, String email) {
        this.nickname = nickname;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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
        return Objects.equals(this.id, employee.id) && Objects.equals(this.nickname, employee.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.nickname);
    }

    @Override
    public String toString() {
        return "Employee: {" + "id=" + this.id + ", name='" + this.nickname + '\'' + ", role='" + this.lastname + '\'' + '}';
    }
}