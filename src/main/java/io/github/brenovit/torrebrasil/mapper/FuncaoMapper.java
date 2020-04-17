package io.github.brenovit.torrebrasil.mapper;

import java.util.List;

import io.github.brenovit.torrebrasil.models.Funcao;
import io.github.brenovit.torrebrasil.payload.funcao.FuncaoRequest;
import io.github.brenovit.torrebrasil.payload.funcao.FuncaoResponse;
import lombok.experimental.UtilityClass;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@UtilityClass
public class FuncaoMapper {
    private static MapperFactory mapperFactory;

    static {
        mapperFactory = new DefaultMapperFactory.Builder().build();
    }

    public static Funcao parse(FuncaoRequest request){    	
        return mapperFactory.getMapperFacade().map(request, Funcao.class);
    }
  
    public static FuncaoResponse parse(Funcao request){
        return mapperFactory.getMapperFacade().map(request, FuncaoResponse.class);
    }
    
	public static List<FuncaoResponse> parse(List<Funcao> request) {
		return mapperFactory.getMapperFacade().mapAsList(request, FuncaoResponse.class);
	}

}
