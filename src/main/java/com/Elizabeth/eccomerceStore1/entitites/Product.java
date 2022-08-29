package com.Elizabeth.eccomerceStore1.entitites;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@ToString
@NoArgsConstructor @AllArgsConstructor
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private float price;


    private int quantity;
    @Column(nullable = false)
    private String category;
    private String image;




}
