package com.reliable.products.controllers;

import com.reliable.products.entities.User;
import com.reliable.products.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserServices userServices;

    @GetMapping
    public Page<User> findAll(@RequestParam(value = "offset", required = false) Integer offset,
                              @RequestParam(value = "limit", required = false) Integer limit){

        return userServices.findAll(PageRequest.of(offset, limit));
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        return userServices.findById(id);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        return ResponseEntity.ok(userServices.create(user));
    }


    @PutMapping("/{id}")
    public ResponseEntity<User> create(@PathVariable Long id,
            @RequestBody User user){
        return ResponseEntity.ok(userServices.Update(user, id));
    }
}
