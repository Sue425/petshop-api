package com.assignment.webapi.core.product;

import com.assignment.webapi.core.category.AnimalCategory;
import com.assignment.webapi.core.category.AnimalCategoryDao;
import com.assignment.webapi.core.product.dto.ProductAdminDto;
import com.assignment.webapi.core.product.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;
import static java.util.stream.Collectors.*;

@Service
public class ProductService {

    private final ProductDao productDao;
    private final AnimalCategoryDao animalCategoryDao;

    public ProductService(ProductDao productDao, AnimalCategoryDao animalCategoryDao) {
        this.productDao = productDao;
        this.animalCategoryDao = animalCategoryDao;
    }

    public Page<ProductDto> getProducts(Pageable pageable) {
        var productsPage =  this.productDao.findAll(pageable);
        var productDtos = productsPage.get().map(product -> ProductDto.of(product.getId(), product.getName(), product.getPrice())).collect(toList());
        return new PageImpl<>(productDtos, pageable, productsPage.getTotalElements()) ;
    }

    public Product getProduct(Integer id) {
        var productOptional =  this.productDao.findById(id);
        if (productOptional.isEmpty()) {
            throw new RuntimeException("Product with id " + id + " doesn't exist.");
        }
        return productOptional.get();
    }

    public Product save(ProductAdminDto productAdminDto) {
        validateProduct(productAdminDto);
        return this.productDao.save(getProduct(productAdminDto));
    }

    private void validateProduct(ProductAdminDto productAdminDto) {
        if (productAdminDto.getAnimalCategories() == null || productAdminDto.getAnimalCategories().isEmpty()) {
            throw new RuntimeException("Product must have at least one animal category.");
        }

        if (productAdminDto.getPrice() == null || productAdminDto.getPrice() <= 0) {
            throw new RuntimeException("Invalid value for price.");
        }

        if (productAdminDto.getName() == null || productAdminDto.getName().trim().isEmpty()) {
            throw new RuntimeException("Invalid value for name.");
        }

        if (productAdminDto.getDescription() == null || productAdminDto.getDescription().trim().isEmpty()) {
            throw new RuntimeException("Invalid value for description.");
        }
    }

    private Product getProduct(ProductAdminDto productAdminDto) {
        var product = new Product();
        product.setId(productAdminDto.getId());
        product.setDescription(productAdminDto.getDescription());
        product.setName(productAdminDto.getName());
        product.setPrice(productAdminDto.getPrice());

        var productAnimalCategories = new ArrayList<AnimalCategory>();
        var knownAnimalCategories = StreamSupport.stream(this.animalCategoryDao.findAll().spliterator(), false).collect(toList());
        for (var productAnimalCategory : productAdminDto.getAnimalCategories()) {
            productAnimalCategories.add(getAnimalCategory(productAnimalCategory, knownAnimalCategories));
        }
        product.setAnimalCategories(productAnimalCategories);

        return product;
    }

    private AnimalCategory getAnimalCategory(AnimalCategory productAnimalCategory, List<AnimalCategory> knownAnimalCategories) {
        for (var knownAnimalCategory : knownAnimalCategories) {
            if (productAnimalCategory.getName().name().equals(knownAnimalCategory.getName().name())) {
                return knownAnimalCategory;
            }
        }
        throw new RuntimeException("Nemalo by sa stat.");
    }

}
