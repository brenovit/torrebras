package io.github.brenovit.torrebras.mapper;

import java.util.List;

import io.github.brenovit.torrebras.models.Curso;
import io.github.brenovit.torrebras.payload.curso.CursoRequest;
import io.github.brenovit.torrebras.payload.curso.CursoResponse;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class CursoMapper {
    private static MapperFactory mapperFactory;

    static {
        mapperFactory = new DefaultMapperFactory.Builder().build();
    }

    public static Curso parse(CursoRequest request){    	
        return mapperFactory.getMapperFacade().map(request, Curso.class);
    }
  
    public static CursoResponse parse(Curso request){
        return mapperFactory.getMapperFacade().map(request, CursoResponse.class);
    }
    
	public static List<CursoResponse> parse(List<Curso> request) {
		return mapperFactory.getMapperFacade().mapAsList(request, CursoResponse.class);
	}

}
