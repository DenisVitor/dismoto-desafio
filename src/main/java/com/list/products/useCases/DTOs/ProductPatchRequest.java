package com.list.products.useCases.DTOs;

import java.math.BigDecimal;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPatchRequest {
    private String name;
    private String description;
    @Positive(message = "Preço deve ser positivo")
    private BigDecimal price;
}
