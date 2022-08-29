package com.Elizabeth.eccomerceStore1.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String category;
    @NotEmpty
    private float price;
    @NotEmpty
    private String image;
    @NotEmpty
    private int quantity;
}
