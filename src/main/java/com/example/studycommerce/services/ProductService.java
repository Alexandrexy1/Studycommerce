package com.example.studycommerce.services;

import com.example.studycommerce.DTO.ProductDTO;
import com.example.studycommerce.entities.Product;
import com.example.studycommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> products = repository.findAll(pageable);
        return products.map(ProductDTO::new);
    }
}
