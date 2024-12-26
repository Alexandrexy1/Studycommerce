package com.example.studycommerce.services;

import com.example.studycommerce.DTO.ProductDTO;
import com.example.studycommerce.entities.Product;
import com.example.studycommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;


    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        if (repository.findById(id).isPresent()) {
            Product product = repository.findById(id).get();
            return new ProductDTO(product);
        } else throw new IllegalArgumentException("Id does not exist.");
    }
}
