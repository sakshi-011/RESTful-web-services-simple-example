package com.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(value = {"ssn","password"})
@JsonFilter("UserInfoFilter")
public class UserInfo {

    private int id;
    private String name;
    private int age;
    @JsonIgnore
    private int ssn;
    @JsonIgnore
    private String password;

    public UserInfo(int id, String name, int age, int ssn, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.ssn = ssn;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", ssn=" + ssn +
                ", password='" + password + '\'' +
                '}';
    }
}
