package com.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    //Versioning using different URIs
    @GetMapping("v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Maria Sharapova");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Maria", "Sharapova"));
    }

    //Versioning using request parameter
    @GetMapping(value = "/person/param",params = "version=1")
    public PersonV1 paramV1(){
        return new PersonV1("Steffi Graf");
    }

    @GetMapping(value = "/person/param", params = "version=2")
    public PersonV2 paramV2(){
        return new PersonV2(new Name("Steffi", "Graf"));
    }

    //Versioning using header
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 headerV1(){
        return new PersonV1("Serena Williams");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 headerV2(){
        return new PersonV2(new Name("Serena", "Williams"));
    }

    //Accept header versioning
    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
    public PersonV1 producesV1(){
        return new PersonV1("Venus Williams");
    }

    @GetMapping(value = "/person/produces", headers = "application/vnd.company.app-v2+json")
    public PersonV2 producesV2(){
        return new PersonV2(new Name("Venus", "Williams"));
    }

}
