package principal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import principal.conexao.ConexaoUtil;
import principal.model.Usuario;

public class UsuarioJDBC implements UsuarioDAO {

	@Override
	public void inserir(Usuario dado) {
		try {
			// Executa esse comando no BD
			String sql = "insert into usuario(codigo, login, senha, tipo) values (?, ?, ?, ?)";

			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);

			statement.setInt(1, dado.getCodigo());
			statement.setString(2, dado.getLogin());
			statement.setString(3, dado.getSenha());
			statement.setBoolean(4,dado.getTipo());
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
	public List<Usuario> listar() {
		List<Usuario> usuarios = new ArrayList<>();

		try {
			Statement statement = ConexaoUtil.getConn().createStatement();
			ResultSet rs = statement.executeQuery("select * from usuarios");

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setCodigo(rs.getInt("codigo"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setTipo(rs.getBoolean("tipo"));	
				usuarios.add(usuario);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuarios;
	}	
	@Override
	public void alterar(Usuario dado) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void excluir(Usuario dado) {
		// TODO Auto-generated method stub
		
	}

}
