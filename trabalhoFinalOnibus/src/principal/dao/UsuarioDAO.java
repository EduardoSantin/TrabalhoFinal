package principal.dao;

import principal.model.Usuario;

public interface UsuarioDAO  extends CrudDAO<Usuario>{

	boolean checkLogin(String login, String senha);
	
	

}
