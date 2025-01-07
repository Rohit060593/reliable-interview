package com.reliable.products.controllers;

import com.reliable.products.entities.Address;
import com.reliable.products.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Test
    public void testCreate(){
        Address address = new Address();
        address.setAddressLine("123 Main Circle");
        address.setCity("Banglore");
        User user = new User();
        user.setName("Rohit Kumar");
        user.setAddress(address);
        var response = userController.create(user);
        assert (response != null && response.getBody().getId() != null);
    }
}
