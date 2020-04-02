package io.github.brenovit.torrebras.payload.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {
    private String name;
    private String sku;
    private BigDecimal unitPrice;
    private String description;
    private String imageUrl;
    private int unitsInStock;
    private Long categoryId;
}
