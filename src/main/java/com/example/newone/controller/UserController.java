package com.example.newone.controller;

import com.example.newone.domain.User;
import com.example.newone.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@RestController
public class UserController {
    @Autowired
    private UserServices  userServices;

    @GetMapping("/user")
    List<User> list()
    {
            return  userServices.ListAll();
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> get(@PathVariable int id) {
        try {
            User user = userServices.get(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/user")
    public void add(@RequestBody User user) {
        userServices.save(user);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id) {
        try {
            user.setId(id);
            userServices.save(user);
           // User existProduct = userServices.get(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable Integer id) {
        userServices.delete(id);
    }




}
