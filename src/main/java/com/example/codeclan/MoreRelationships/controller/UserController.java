package com.example.codeclan.MoreRelationships.controller;

import com.example.codeclan.MoreRelationships.models.User;
import com.example.codeclan.MoreRelationships.repository.UserRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity getUser(@PathVariable Long id){
        return new ResponseEntity(userRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/users")
    public ResponseEntity postUser(@RequestBody User user){
        userRepository.save(user);
        return new ResponseEntity(user,HttpStatus.CREATED);

    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity putUser(@PathVariable Long id, @RequestBody User userDetails){
        Optional<User> user = userRepository.findById(id);
        user.get().setFolders(userDetails.getFolders());
        user.get().setName((userDetails.getName()));
        final User updatedUser = userRepository.save(user.get());
        return new ResponseEntity(updatedUser,HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
        return new ResponseEntity(userRepository.findAll(),HttpStatus.ACCEPTED);
    }
}
