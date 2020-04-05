package io.github.brenovit.torrebras.mapper;

import java.util.List;

import io.github.brenovit.torrebras.models.Colaborador;
import io.github.brenovit.torrebras.payload.colaborador.ColaboradorRequest;
import io.github.brenovit.torrebras.payload.colaborador.ColaboradorResponse;
import lombok.experimental.UtilityClass;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@UtilityClass
public class ColaboradorMapper {
    private static MapperFactory mapperFactory;

    static {
        mapperFactory = new DefaultMapperFactory.Builder().build();
    }

    public Colaborador parse(ColaboradorRequest request){    	
    	mapperFactory.classMap(ColaboradorRequest.class, Colaborador.class)
    	.field("categoryId", "category.id")
    	.register();
        return mapperFactory.getMapperFacade().map(request, Colaborador.class);
    }
  
    public ColaboradorResponse parse(Colaborador request){
    	mapperFactory
    	.classMap(Colaborador.class, ColaboradorResponse.class)
    	.field("category.id", "categoryId").byDefault()
    	.register();
        return mapperFactory.getMapperFacade().map(request, ColaboradorResponse.class);
    }
    
	public List<ColaboradorResponse> parse(List<Colaborador> request) {
		mapperFactory.classMap(Colaborador.class, ColaboradorResponse.class)
		.field("category.id", "categoryId").byDefault()
    	.register();
		return mapperFactory.getMapperFacade().mapAsList(request, ColaboradorResponse.class);
	}

}
