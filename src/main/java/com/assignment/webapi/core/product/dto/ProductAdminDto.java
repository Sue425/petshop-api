package com.assignment.webapi.core.product.dto;

import com.assignment.webapi.core.category.AnimalCategory;
import lombok.Data;

import java.util.List;

@Data
public class ProductAdminDto extends ProductDto {

    private String description;
    private List<AnimalCategory> animalCategories;
}
