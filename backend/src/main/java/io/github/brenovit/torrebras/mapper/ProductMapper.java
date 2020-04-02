package io.github.brenovit.torrebras.mapper;

import java.util.List;

import io.github.brenovit.torrebras.models.Colaborador;
import io.github.brenovit.torrebras.models.Funcao;
import io.github.brenovit.torrebras.payload.product.ProductCategoryResponse;
import io.github.brenovit.torrebras.payload.product.ProductRequest;
import io.github.brenovit.torrebras.payload.product.ProductResponse;
import lombok.experimental.UtilityClass;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@UtilityClass
public class ProductMapper {
    private static MapperFactory mapperFactory;

    static {
        mapperFactory = new DefaultMapperFactory.Builder().build();
    }

    public Colaborador parse(ProductRequest request){    	
    	mapperFactory.classMap(ProductRequest.class, Colaborador.class)
    	.field("categoryId", "category.id")
    	.register();
        return mapperFactory.getMapperFacade().map(request, Colaborador.class);
    }
  
    public ProductResponse parse(Colaborador request){
    	mapperFactory
    	.classMap(Colaborador.class, ProductResponse.class)
    	.field("category.id", "categoryId").byDefault()
    	.register();
        return mapperFactory.getMapperFacade().map(request, ProductResponse.class);
    }
    
    public ProductCategoryResponse parse(Funcao request){
        return mapperFactory.getMapperFacade().map(request, ProductCategoryResponse.class);
    }
    
    public List<ProductCategoryResponse> parseCategory(List<Funcao> request) {
		return mapperFactory.getMapperFacade().mapAsList(request, ProductCategoryResponse.class);
	}
    
	public List<ProductResponse> parse(List<Colaborador> request) {
		mapperFactory.classMap(Colaborador.class, ProductResponse.class)
		.field("category.id", "categoryId").byDefault()
    	.register();
		return mapperFactory.getMapperFacade().mapAsList(request, ProductResponse.class);
	}

}
