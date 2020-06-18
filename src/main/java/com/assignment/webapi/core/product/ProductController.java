package com.assignment.webapi.core.product;

import com.assignment.webapi.core.product.dto.ProductAdminDto;
import com.assignment.webapi.core.product.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import static com.assignment.webapi.common.Routing.API_PREFIX;
import static com.assignment.webapi.common.Routing.PRODUCT;

@RestController
@RequestMapping(API_PREFIX + PRODUCT)
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Page<ProductDto> getProducts(Pageable pageable) {
        return this.productService.getProducts(pageable);
    }

    @GetMapping("{id}")
    public Product getProduct(@PathVariable Integer id) {
        return this.productService.getProduct(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody ProductAdminDto productAdminDto) {
        productAdminDto.setId(null);
        return this.productService.save(productAdminDto);
    }
}
