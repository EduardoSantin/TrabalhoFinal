package test;

import org.junit.Test;

import principal.dao.UsuarioDAO;
import principal.dao.UsuarioJDBC;
import principal.model.Usuario;

public class UsuarioTest {

	private void assertStringEquals(String i, String j) {

	}

	@Test
	public void testaInsereUsuario() throws Exception {
		UsuarioDAO usuariodao = new UsuarioJDBC();

		Usuario u = new Usuario();
		
		u.setLogin("root");
		u.setSenha("root");
		
		usuariodao.inserir(u);
		
		assertStringEquals("root", u.getLogin());
		assertStringEquals("root", u.getSenha());
		
	}

}
