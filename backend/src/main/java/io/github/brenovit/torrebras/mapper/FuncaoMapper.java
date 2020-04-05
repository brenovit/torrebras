package io.github.brenovit.torrebras.mapper;

import java.util.List;

import io.github.brenovit.torrebras.models.Funcao;
import io.github.brenovit.torrebras.payload.funcao.FuncaoRequest;
import io.github.brenovit.torrebras.payload.funcao.FuncaoResponse;
import lombok.experimental.UtilityClass;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@UtilityClass
public class FuncaoMapper {
    private static MapperFactory mapperFactory;

    static {
        mapperFactory = new DefaultMapperFactory.Builder().build();
    }

    public Funcao parse(FuncaoRequest request){    	
    	mapperFactory.classMap(FuncaoRequest.class, Funcao.class)
    	.field("categoryId", "category.id")
    	.register();
        return mapperFactory.getMapperFacade().map(request, Funcao.class);
    }
  
    public FuncaoResponse parse(Funcao request){
    	mapperFactory
    	.classMap(Funcao.class, FuncaoResponse.class)
    	.field("category.id", "categoryId").byDefault()
    	.register();
        return mapperFactory.getMapperFacade().map(request, FuncaoResponse.class);
    }
    
	public List<FuncaoResponse> parse(List<Funcao> request) {
		mapperFactory.classMap(Funcao.class, FuncaoResponse.class)
		.field("category.id", "categoryId").byDefault()
    	.register();
		return mapperFactory.getMapperFacade().mapAsList(request, FuncaoResponse.class);
	}

}
