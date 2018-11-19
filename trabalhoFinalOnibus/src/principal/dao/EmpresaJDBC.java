package principal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import principal.conexao.ConexaoUtil;
import principal.model.Empresa;

public class EmpresaJDBC implements EmpresaDAO {

	@Override
	public void inserir(Empresa dado) {
		try {
			// Executa esse comando no BD
			String sql = "insert into empresa (codigo, razaoSocial, nomeFantasia, cnpj, endereco, numero, bairro, cep, uf) values (?, ?, ?, ?, ? ,?, ?, ?, ?)";

			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);

			statement.setInt(1, dado.getCodigo());
			statement.setString(2, dado.getRazaoSocial());
			statement.setString(3, dado.getNomeFantasia());
			statement.setInt(4, dado.getCnpj());
			statement.setString(5, dado.getEndereco());
			statement.setInt(6, dado.getNumero());
			statement.setString(7, dado.getBairro());
			statement.setInt(8, dado.getCep());
			statement.setString(9, dado.getUf());
			statement.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Empresa inserida!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	@Override
	public void alterar(Empresa dado) {
		try {
			String sql = "UPDATE Empresa SET razaoSocial = ? , nomeFantasia = ? , cnpj = ? , endereco = ? , numero = ? , bairro = ? , cep = ? , uf = ?"
					+ "WHERE codigo = ?";

			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);

			statement.setString(1, dado.getRazaoSocial());
			statement.setString(2, dado.getNomeFantasia());
			statement.setInt(3, dado.getCnpj());
			statement.setString(4, dado.getEndereco());
			statement.setInt(5, dado.getNumero());
			statement.setString(6, dado.getBairro());
			statement.setInt(7, dado.getCep());
			statement.setString(8, dado.getUf());
			statement.setInt(9, dado.getCodigo());
			statement.executeUpdate();

			JOptionPane.showMessageDialog(null, "Dado alterado!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void excluir(Empresa dado) {
		try {
			String sql = "delete from empresa where codigo = ?";

			PreparedStatement statement =ConexaoUtil.getConn().prepareStatement(sql);
			statement.setInt(1, dado.getCodigo());
			statement.executeUpdate();
			//JOptionPane.showMessageDialog(null, "Empresa deletado!");

		} catch (SQLException e) {
			e.printStackTrace();
			
			
		}
	}

	@Override
	public List<Empresa> listar() {
		List<Empresa> empresas = new ArrayList<>();

		try {
			Statement statement = ConexaoUtil.getConn().createStatement();
			ResultSet rs = statement.executeQuery("select * from empresa");

			while (rs.next()) {
				Empresa empresa = new Empresa();
				empresa.setCodigo(rs.getInt("codigo"));
				empresa.setRazaoSocial(rs.getString("razaoSocial"));
				empresa.setNomeFantasia(rs.getString("nomeFantasia"));
				empresa.setCnpj(rs.getInt("cnpj"));
				empresa.setEndereco(rs.getString("endereco"));
				empresa.setNumero(rs.getInt("numero"));
				empresa.setBairro(rs.getString("bairro"));
				empresa.setCep(rs.getInt("cep"));
				empresa.setUf(rs.getString("uf"));
				empresas.add(empresa);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return empresas;
	}

	@Override
	public boolean checkLogin(String login, String senha) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void calcula(Empresa dado) {
		// TODO Auto-generated method stub
		
	}
}
