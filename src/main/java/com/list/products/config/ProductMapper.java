package com.list.products.config;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.list.products.entity.ProductEntity;
import com.list.products.useCases.DTOs.ProductPatchRequest;
import com.list.products.useCases.DTOs.ProductResponseDTO;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {
    @BeanMapping(ignoreByDefault = false)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateEntityFromDto(ProductPatchRequest dto, @MappingTarget ProductEntity entity);

    ProductResponseDTO toDto(ProductEntity entity);
}
