package io.github.brenovit.torrebras.mapper;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;

import io.github.brenovit.rainbow.mapper.UsuarioMapper;
import io.github.brenovit.rainbow.models.Usuario;
import io.github.brenovit.rainbow.payload.usuario.UsuarioResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
class UsuarioMapperTest {

	@Test
	void testParseUsuario() {
		Usuario request = new Usuario().setCpf("12345789").setDataAtualizacao(new Date()).setDataCriacao(new Date())
				.setEmail("email").setNome("breno").setId(12L);
		UsuarioResponse response = UsuarioMapper.parse(request);
		log.info(response.toString());
		assertNotNull(response);
		assertNotNull(response.getCpf());
	}

}
