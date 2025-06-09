package com.list.products.config;

import com.list.products.entity.ProductEntity;
import com.list.products.useCases.DTOs.ProductPatchRequest;
import com.list.products.useCases.DTOs.ProductResponseDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-09T15:35:01-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public void updateEntityFromDto(ProductPatchRequest dto, ProductEntity entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getName() != null ) {
            entity.setName( dto.getName() );
        }
        if ( dto.getDescription() != null ) {
            entity.setDescription( dto.getDescription() );
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

        productResponseDTO.setId( entity.getId() );
        productResponseDTO.setName( entity.getName() );
        productResponseDTO.setDescription( entity.getDescription() );
        productResponseDTO.setPrice( entity.getPrice() );
        productResponseDTO.setCreatedAt( entity.getCreatedAt() );

        return productResponseDTO;
    }
}
