package com.springboot.quickstart.model.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDaoService;
    @GetMapping("/users")
    public List<User> getAllUsers(){
       return  userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> getUserById(@PathVariable("id") int id){
        User user =   userDaoService.findById(id);
        EntityModel entityModel = EntityModel.of(user);
        if(user == null){
            // So thi s code will be returning a runtime Exception
            // And ultimatly it will be giving the 500 as internal server error
            // while the actual status code is 404 if something is not found
       //     throw new RuntimeException("User not found");
            // hence we can create our customer Exception to send as response
            throw new UserNotFoundException("id: "+id);
        }
        WebMvcLinkBuilder  link  = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
        entityModel.add(link
                .withRel("all-users"));
        return entityModel;
    }


    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable("id") int id){
         userDaoService.deleteById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody @Valid User user){
      User savedUser =  userDaoService.save(user);
      // let us decorate the controller to send response
        // with the status code of 201 which means the user ot the object is created
        // and along with that lets add the path of the newly created user

        // In order to fetch the current controller uri we will be using ServletUriComponentsBuilder
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    // In order to specify the param of parameter while using the url like
    // /user?verison=1 here we are specifing the paramter using ?
    @GetMapping(value = "/users", params = "version=1, version=2")
    public List<User> getAllUsersWithParam(){
        return
                userDaoService.findAll();
    }


}
