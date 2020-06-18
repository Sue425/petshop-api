package com.assignment.webapi.core.order;

import com.assignment.webapi.core.product.Product;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @SequenceGenerator(name = "orders_id_generator", sequenceName = "orders_id_sequence")
    @GeneratedValue(strategy = SEQUENCE, generator = "orders_id_generator")
    private Integer id;

    private double totalPrice;
    private Integer amount;
    private LocalDateTime createdAt;

    @ManyToMany(cascade = {PERSIST, MERGE})
    @JoinTable(name = "products_orders", joinColumns = @JoinColumn(name = "orders_fk"), inverseJoinColumns = @JoinColumn(name = "products_fk"))
    private List<Product> products = new ArrayList<>();
}
