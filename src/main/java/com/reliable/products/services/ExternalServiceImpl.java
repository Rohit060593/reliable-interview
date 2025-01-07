package com.reliable.products.services;

import com.reliable.products.constants.ApplicationConstants;
import com.reliable.products.dto.Product;
import com.reliable.products.dto.ProductResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ExternalServiceImpl implements ExternalService{

    private static final Logger logger = LogManager
            .getLogger(ExternalServiceImpl.class);

    private final RestTemplate restTemplate;

    public ExternalServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> getExternalProducts() {
        ResponseEntity<ProductResponse> response = restTemplate.getForEntity(ApplicationConstants.PRODUCT_URI,
                ProductResponse.class);
        return response.getBody().getProducts();
    }

    @Override
    public String getGoogleHomePage() {
        ResponseEntity<String> response = restTemplate.getForEntity(ApplicationConstants.GOOGLE_URI,
                String.class);
        return response.getBody();
    }
}
