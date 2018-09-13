package principal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import principal.model.Empresa;

public class EmpresaJDBC implements EmpresaDAO {

	@Override
	public void inserir(Empresa dado) {
		try {
			// Executa esse comando no BD
			String sql = "insert into empresa values (?, ?)";

			PreparedStatement statement = application.Conexao.getConn().prepareStatement(sql);

			statement.setInt(1, dado.getCodigo());
			statement.setString(2, dado.getRazaoSocial());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void alterar(Empresa dado) {
		try {
			String sql = "update empresa set empresa = ?" + "where codigo= ?";

			PreparedStatement statement = application.Conexao.getConn().prepareStatement(sql);
			statement.setString(1, dado.getRazaoSocial());
			statement.setInt(2, dado.getCodigo());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void excluir(Empresa dado) {
		try {
			String sql = "delete from empresa codigo = ?";

			PreparedStatement statement = application.Conexao.getConn().prepareStatement(sql);
			statement.setInt(1, dado.getCodigo());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Empresa> listar() {
		List<Empresa> empresas = new ArrayList<>();

		try {
			Statement statement = application.Conexao.getConn().createStatement();
			ResultSet rs = statement.executeQuery("select * from cidade");

			while (rs.next()) {
				Empresa empresa = new Empresa();
				empresa.setRazaoSocial(rs.getString("razaoSocial"));
				empresa.setCodigo(rs.getInt("codigo"));
				empresas.add(empresa);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return empresas;
		}
}
	
	