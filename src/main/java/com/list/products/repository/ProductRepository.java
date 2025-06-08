package com.list.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.list.products.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
