package com.example.studycommerce.services;

import com.example.studycommerce.DTO.ProductDTO;
import com.example.studycommerce.entities.Product;
import com.example.studycommerce.repositories.ProductRepository;
import com.example.studycommerce.services.exceptions.DatabaseException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;


@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;


    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product product = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found."));
        return new ProductDTO(product);

    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> products = repository.findAll(pageable);
        return products.map(ProductDTO::new);
    }

    @Transactional
    public ProductDTO insert(ProductDTO productDTO) {
        Product entity = new Product();
        copyDtoToProduct(entity, productDTO);
        entity = repository.save(entity);
        return new ProductDTO(entity);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO productDTO) {
        if (!repository.existsById(id)) throw new EntityNotFoundException("Produto não existe");
        Product entity = repository.getReferenceById(id);
        copyDtoToProduct(entity, productDTO);
        entity = repository.save(entity);
        return new ProductDTO(entity);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) throw new EntityNotFoundException("Produto não existe");
        try {
            repository.deleteById(id);
        } catch(DataIntegrityViolationException e) {
            throw new DatabaseException("Deleção negada: o produto está associado a outros registros");
        }
    }

    private void copyDtoToProduct(Product product, ProductDTO productDTO) {
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setImgUrl(productDTO.getImgUrl());
    }
}
