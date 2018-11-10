package principal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import principal.conexao.ConexaoUtil;
import principal.model.Usuario;

public class UsuarioJDBC implements UsuarioDAO {

	@Override
	public void inserir(Usuario dado) {
		try {
			// Executa esse comando no BD
			String sql = "insert into usuario(login, senha) values (?, ?)";

			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);

			statement.setString(2, dado.getLogin());
			statement.setString(3, dado.getSenha());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean checkLogin(String login, String senha) {
		boolean check = false;
		ResultSet rs = null;
		try {
			String sql = "select * from usuario where login = ? and senha = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			
			statement.setString(1, login);
			statement.setString(2, senha);
			rs = statement.executeQuery();
			
			if(rs.next()) {
				check = true;
				
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return check;
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
