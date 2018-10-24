package principal.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import principal.conexao.ConexaoUtil;
import principal.model.Usuario;

public class UsuarioJDBC implements UsuarioDAO{
		
	@Override
	public void inserir(Usuario dado) {
		try {
			// Executa esse comando no BD
			String sql = "insert into usuario(codigo, login, senha,) values (?, ?, ?)";

			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);

			statement.setInt(1, dado.getCodigo());
			statement.setString(2, dado.getLogin());
			statement.setString(3, dado.getSenha());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Usuario dado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Usuario dado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
	
