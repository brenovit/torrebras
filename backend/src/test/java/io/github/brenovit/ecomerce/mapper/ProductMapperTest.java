package io.github.brenovit.ecomerce.mapper;


import static io.github.brenovit.torrebras.mapper.ProductMapper.parse;

import java.math.BigDecimal;

import org.junit.Test;

import io.github.brenovit.torrebras.models.Colaborador;
import io.github.brenovit.torrebras.models.Funcao;
import io.github.brenovit.torrebras.payload.product.ProductRequest;
import io.github.brenovit.torrebras.payload.product.ProductResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ProductMapperTest {

	@Test
	public void testParseProductRequest() {
		ProductRequest request = new ProductRequest();
		request.setCategoryId(10L);
		request.setDescription("Descritption of product");
		request.setName("Name of product");
		request.setSku("sku");
		request.setUnitPrice(new BigDecimal("45.9"));
		request.setUnitsInStock(20);
		request.setImageUrl(null);
		Colaborador response = parse(request);
		log.info(response.toString());
	}
	
	@Test
	public void testParseProduct() {
		Colaborador request = new Colaborador();
		ProductResponse response = parse(request);
		log.info(response.toString());
	}
}
