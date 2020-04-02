package io.github.brenovit.torrebras.mapper;

import java.util.List;

import io.github.brenovit.torrebras.models.Curso;
import io.github.brenovit.torrebras.payload.curso.CursoRequest;
import io.github.brenovit.torrebras.payload.curso.CursoResponse;
import lombok.experimental.UtilityClass;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@UtilityClass
public class CursoMapper {
    private static MapperFactory mapperFactory;

    static {
        mapperFactory = new DefaultMapperFactory.Builder().build();
    }

    public Curso parse(CursoRequest request){    	
    	mapperFactory.classMap(CursoRequest.class, Curso.class)
    	.field("categoryId", "category.id")
    	.register();
        return mapperFactory.getMapperFacade().map(request, Curso.class);
    }
  
    public CursoResponse parse(Curso request){
    	mapperFactory
    	.classMap(Curso.class, CursoResponse.class)
    	.field("category.id", "categoryId").byDefault()
    	.register();
        return mapperFactory.getMapperFacade().map(request, CursoResponse.class);
    }
    
	public List<CursoResponse> parse(List<Curso> request) {
		mapperFactory.classMap(Curso.class, CursoResponse.class)
		.field("category.id", "categoryId").byDefault()
    	.register();
		return mapperFactory.getMapperFacade().mapAsList(request, CursoResponse.class);
	}

}
