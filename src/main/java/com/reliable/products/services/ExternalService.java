package com.reliable.products.services;

import com.reliable.products.dto.Product;

import java.util.List;

public interface ExternalService {

    List<Product> getExternalProducts();
    String getGoogleHomePage();
}
