package com.reliable.products.controllers;

import com.reliable.products.dto.Product;
import com.reliable.products.services.ExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ext")
public class ExternalServiceController {

    @Autowired
    private ExternalService externalService;

    @GetMapping("/products")
    public List<Product> findExternalProducts(){
        return externalService.getExternalProducts();
    }


    @GetMapping("/google")
    public String findGoogleHomePage(){
        return externalService.getGoogleHomePage();
    }
}
