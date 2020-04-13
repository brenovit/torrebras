package io.github.brenovit.torrebras.mapper;

import java.util.List;

import io.github.brenovit.torrebras.models.Colaborador;
import io.github.brenovit.torrebras.payload.colaborador.ColaboradorRequest;
import io.github.brenovit.torrebras.payload.colaborador.ColaboradorResponse;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class ColaboradorMapper {
    private static MapperFactory mapperFactory;

    static {
        mapperFactory = new DefaultMapperFactory.Builder().build();
    }

    public static Colaborador parse(ColaboradorRequest request){    	
    	mapperFactory.classMap(ColaboradorRequest.class, Colaborador.class)
    	.register();
        return mapperFactory.getMapperFacade().map(request, Colaborador.class);
    }
  
    public static ColaboradorResponse parse(Colaborador request){
    	mapperFactory
    	.classMap(Colaborador.class, ColaboradorResponse.class)
    	.register();
        return mapperFactory.getMapperFacade().map(request, ColaboradorResponse.class);
    }
    
	public static List<ColaboradorResponse> parse(List<Colaborador> request) {
		mapperFactory.classMap(Colaborador.class, ColaboradorResponse.class)
    	.register();
		return mapperFactory.getMapperFacade().mapAsList(request, ColaboradorResponse.class);
	}

}
