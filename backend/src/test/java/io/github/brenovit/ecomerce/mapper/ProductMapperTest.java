package io.github.brenovit.ecomerce.mapper;


import static io.github.brenovit.torrebras.mapper.ColaboradorMapper.parse;

import org.junit.Test;

import io.github.brenovit.torrebras.models.Colaborador;
import io.github.brenovit.torrebras.payload.colaborador.ColaboradorRequest;
import io.github.brenovit.torrebras.payload.colaborador.ColaboradorResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ProductMapperTest {

	@Test
	public void testParseProductRequest() {
		ColaboradorRequest request = new ColaboradorRequest();
		Colaborador response = parse(request);
		log.info(response.toString());
	}
	
	@Test
	public void testParseProduct() {
		Colaborador request = new Colaborador();
		ColaboradorResponse response = parse(request);
		log.info(response.toString());
	}
}
