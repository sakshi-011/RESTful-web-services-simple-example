package com.rest.webservices.restfulwebservices.user;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Schema(description = "Details about User.")
public class User {

    private Integer id;

    @Schema(description = "Name should consist of at least 2 characters.")
    @Size(min = 2, message = "Name should have at least 2 characters.")
    private String name;

    @Schema(description = "Birth date should be less than current date.")
    @Past
    private Date birthDate;

    public User(Integer id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
