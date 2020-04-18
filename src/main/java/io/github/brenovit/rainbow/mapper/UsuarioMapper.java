package io.github.brenovit.rainbow.mapper;

import java.util.List;

import io.github.brenovit.rainbow.models.Usuario;
import io.github.brenovit.rainbow.payload.usuario.UsuarioResponse;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class UsuarioMapper {
    private static MapperFactory mapperFactory;

    static {
        mapperFactory = new DefaultMapperFactory.Builder().build();
    }
  
    public static UsuarioResponse parse(Usuario request){
        return mapperFactory.getMapperFacade().map(request, UsuarioResponse.class);
    }
    
	public static List<UsuarioResponse> parse(List<Usuario> request) {
		return mapperFactory.getMapperFacade().mapAsList(request, UsuarioResponse.class);
	}

}
