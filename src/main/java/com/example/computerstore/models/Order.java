package com.example.computerstore.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long ID;
    @Column(name = "product", columnDefinition = "text")
    private String product;

    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    private User user;

    public Order(String product, User user) {
        this.product = product;
        this.user = user;
    }
}
