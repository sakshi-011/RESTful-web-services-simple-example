package com.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserController {

    @Autowired
    private UserDaoService service = new UserDaoService();

    @GetMapping(path="/users")
    public List<User> getAllUsers(){
        return service.findAllUsers();
    }

    @GetMapping(path="/user/{id}")
    public EntityModel<User> getUserById(@PathVariable int id){
        User user = service.findUserById(id);
        if(user == null)
            throw new UserNotFoundException("id - "+id);

        //HATEOAS
        EntityModel<User> resource = EntityModel.of(user);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUsers());
        resource.add(linkTo.withRel("all-users"));

        return resource;
    }

    @PostMapping(path = "/user")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = service.addNewUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path="/user/{id}")
    public void deleteUserById(@PathVariable int id){
        User user = service.removeUser(id);
        if(user == null)
            throw new UserNotFoundException("id - "+id);
    }

}
