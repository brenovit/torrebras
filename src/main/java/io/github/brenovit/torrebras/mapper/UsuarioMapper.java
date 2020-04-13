package io.github.brenovit.torrebras.mapper;

import java.util.List;

import io.github.brenovit.torrebras.models.Usuario;
import io.github.brenovit.torrebras.payload.usuario.UsuarioResponse;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class UsuarioMapper {
    private static MapperFactory mapperFactory;

    static {
        mapperFactory = new DefaultMapperFactory.Builder().build();
    }
  
    public static UsuarioResponse parse(Usuario request){
    	mapperFactory
    	.classMap(Usuario.class, UsuarioResponse.class)
    	.register();
        return mapperFactory.getMapperFacade().map(request, UsuarioResponse.class);
    }
    
	public static List<UsuarioResponse> parse(List<Usuario> request) {
		mapperFactory.classMap(Usuario.class, UsuarioResponse.class)
    	.register();
		return mapperFactory.getMapperFacade().mapAsList(request, UsuarioResponse.class);
	}

}
