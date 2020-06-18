package com.assignment.webapi.core.category;

import lombok.Data;
import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "animal_categories")
@Data
public class AnimalCategory {

    @Id
    @SequenceGenerator(name = "animal_categories_id_generator", sequenceName = "animal_categories_id_sequence")
    @GeneratedValue(strategy = SEQUENCE, generator = "animal_categories_id_generator")
    private Integer id;

    @Enumerated(EnumType.STRING)
    private AnimalCategoryEnum name;
}
