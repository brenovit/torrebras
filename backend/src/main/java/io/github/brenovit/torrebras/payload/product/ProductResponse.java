package io.github.brenovit.torrebras.payload.product;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ProductResponse{
    private Long id;
    private String name;
    private BigDecimal unitPrice;
	private int unitsInStock;
    private String description;
    private Date createdAt;
    private Date updatedAt;
	private String imageUrl;
	private Long categoryId;
}
