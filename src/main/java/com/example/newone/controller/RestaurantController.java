package com.example.newone.controller;

import com.example.newone.domain.Restaurant;
import com.example.newone.domain.User;
import com.example.newone.services.RestaurantService;
import com.example.newone.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

public class RestaurantController {


    @Autowired
    private RestaurantService restaurantService ;
    @GetMapping("/restaurant/")
    List<Restaurant> list()
    {
        return  restaurantService.ListAll();
    }

    @GetMapping("/restaurant/{id}")
    public ResponseEntity<Restaurant> get(@PathVariable int id) {
        try {
            Restaurant r = restaurantService.get(id);
            return new ResponseEntity<Restaurant>(r, HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            return new ResponseEntity<Restaurant>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/restaurant/name/{name}/")
    public ResponseEntity<Restaurant> getByName(@PathVariable String name) {
        try {
            Restaurant r = restaurantService.getByName(name);
            return new ResponseEntity<Restaurant>(r, HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            return new ResponseEntity<Restaurant>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/restaurant/type/{type}/")
    public ResponseEntity<Restaurant> getByType(@PathVariable String type) {
        try {
            Restaurant r = restaurantService.getByType(type);
            return new ResponseEntity<Restaurant>(r, HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            return new ResponseEntity<Restaurant>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/restaurant/location/{type}/")
    public ResponseEntity<Restaurant> getByLocation(@PathVariable String location) {
        try {
            Restaurant r = restaurantService.getByLocation(location);
            return new ResponseEntity<Restaurant>(r, HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            return new ResponseEntity<Restaurant>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/restaurant/")
    public void add(@RequestBody Restaurant r) {
        restaurantService.save(r);
    }
    @DeleteMapping("/restaurant/{id}")
    public void delete(@PathVariable Integer id) {
        restaurantService.delete(id);
    }

    @PutMapping("/restaurant/{id}/")
    public ResponseEntity<?> update(@RequestBody Restaurant r, @PathVariable Integer id) {
        try {
            r.setId(id);
            restaurantService.save(r);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
