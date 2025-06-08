package com.list.products.config;

import com.list.products.entity.ProductEntity;
import com.list.products.useCases.DTOs.ProductPatchRequest;
import com.list.products.useCases.DTOs.ProductResponseDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-08T20:20:46-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.v20250514-1000, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public void updateEntityFromDto(ProductPatchRequest dto, ProductEntity entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getDescription() != null ) {
            entity.setDescription( dto.getDescription() );
        }
        if ( dto.getName() != null ) {
            entity.setName( dto.getName() );
        }
        if ( dto.getPrice() != null ) {
            entity.setPrice( dto.getPrice() );
        }
    }

    @Override
    public ProductResponseDTO toDto(ProductEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();

        productResponseDTO.setCreatedAt( entity.getCreatedAt() );
        productResponseDTO.setDescription( entity.getDescription() );
        productResponseDTO.setId( entity.getId() );
        productResponseDTO.setName( entity.getName() );
        productResponseDTO.setPrice( entity.getPrice() );

        return productResponseDTO;
    }
}
