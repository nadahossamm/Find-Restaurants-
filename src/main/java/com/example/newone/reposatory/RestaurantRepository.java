package com.example.newone.reposatory;

import com.example.newone.domain.Restaurant;
import com.example.newone.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository  extends JpaRepository<Restaurant,Integer> {

    Restaurant  getByName(String email);
    Restaurant  getByLocation(String email);
    Restaurant  getByType(String email);


}
