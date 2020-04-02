package io.github.brenovit.torrebras.assembler;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import io.github.brenovit.torrebras.controller.ProductRestController;
import io.github.brenovit.torrebras.payload.product.ProductResponse;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ProducResponsetModelAssembler implements RepresentationModelAssembler<ProductResponse, EntityModel<ProductResponse>> {

	@Override
	public EntityModel<ProductResponse> toModel(ProductResponse entity) {
	    return new EntityModel<>(entity,
	      linkTo(methodOn(ProductRestController.class).findById(entity.getId())).withSelfRel(),
	      linkTo(methodOn(ProductRestController.class).findAll()).withRel("products"));
	}	
}
