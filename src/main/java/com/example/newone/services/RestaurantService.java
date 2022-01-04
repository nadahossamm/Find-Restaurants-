package com.example.newone.services;

import com.example.newone.domain.Restaurant;
import com.example.newone.domain.User;
import com.example.newone.reposatory.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> ListAll()
    {
        return  restaurantRepository.findAll();
    }
    public  void save(Restaurant restaurant)
    {
        restaurantRepository.save(restaurant);
    }
    public Restaurant get(int id) {
        return restaurantRepository.findById(id).get();
    }
    public  void delete(Integer id)
    {
        restaurantRepository.deleteById(id);
    }
    public  Restaurant getByName(String email)
    {
        return restaurantRepository.getByName(email);
    }
    public  Restaurant getByType(String type)
    {
        return restaurantRepository.getByType(type);
    }
    public  Restaurant getByLocation(String location)
    {
        return restaurantRepository.getByName(location);
    }




}
