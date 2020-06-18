package com.assignment.webapi.core.product;

import com.assignment.webapi.core.category.AnimalCategory;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @SequenceGenerator(name = "products_id_generator", sequenceName = "products_id_sequence")
    @GeneratedValue(strategy = SEQUENCE, generator = "products_id_generator")
    private Integer id;

    private String name;
    private Double price;
    private String description;

    @ManyToMany(cascade = {PERSIST, MERGE})
    @JoinTable(name = "products_animal_categories", joinColumns = @JoinColumn(name = "products_fk"), inverseJoinColumns = @JoinColumn(name = "animal_categories_fk"))
    private List<AnimalCategory> animalCategories = new ArrayList<>();
}
