package com.list.products.service;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.list.products.config.ProductMapper;
import com.list.products.entity.ProductEntity;
import com.list.products.repository.ProductRepository;
import com.list.products.useCases.DTOs.ProductResponseDTO;
import com.list.products.useCases.DTOs.ProductPatchRequest;
import com.list.products.useCases.DTOs.ProductRequestDTO;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository repository;

    @Autowired
    private final ModelMapper mapper;

    @Autowired
    private final ProductMapper prodMapper;

    public ProductService(ProductRepository repository, ModelMapper mapper, ProductMapper prodMapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.prodMapper = prodMapper;
    }

    public List<ProductResponseDTO> listProducts() {
        return repository.findAll().stream()
                .map(produto -> mapper.map(produto, ProductResponseDTO.class))
                .toList();
    }

    public ProductResponseDTO getProductById(Long id) {
        ProductEntity Product = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
        return mapper.map(Product, ProductResponseDTO.class);
    }

    public ProductResponseDTO createProduct(ProductRequestDTO dto) {
        ProductEntity createdProduct = mapper.map(dto, ProductEntity.class);
        createdProduct.setName(dto.getName());
        createdProduct.setPrice(dto.getPrice());
        createdProduct.setDescription(dto.getDescription());
        createdProduct.setCreatedAt(LocalDate.now());
        return mapper.map(repository.save(createdProduct), ProductResponseDTO.class);
    }

    public ProductResponseDTO updateProduct(Long id, ProductPatchRequest dto) {
        ProductEntity productToUpdate = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
        prodMapper.updateEntityFromDto(dto, productToUpdate);
        return mapper.map(repository.save(productToUpdate), ProductResponseDTO.class);
    }

    public void deleteProduct(Long id) {
        repository.delete(
                repository.findById(id).orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado")));
    }
}
