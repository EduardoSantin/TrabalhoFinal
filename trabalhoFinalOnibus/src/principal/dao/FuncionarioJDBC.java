package principal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import principal.conexao.ConexaoUtil;
import principal.model.Funcionario;

public class FuncionarioJDBC implements FuncionarioDAO {

	@Override
	public void inserir(Funcionario dado) {
		try {
			// Executa esse comando no BD
			String sql = "insert into Funcionario(codigo, nome, cpf, rg, dataNascimento, endereco, cep, bairro, cargo, salario, cargaHoraria, dataadmisao) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now())";

			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);

			statement.setInt(1, dado.getCodigo());
			statement.setString(2, dado.getNome());
			statement.setInt(3, dado.getCpf());
			statement.setInt(4, dado.getRg());
			statement.setString(5, dado.getDtNasc());
			statement.setString(6, dado.getEndereco());
			statement.setInt(7, dado.getCep());
			statement.setString(8, dado.getBairro());
			statement.setString(9, dado.getCargo());
			statement.setDouble(10, dado.getSalario());
			statement.setInt(11, dado.getCargarHoraria());

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Funcionario dado) {
		try {
			String sql = "update Funcionario set funcionario = ?" + "where codigo= ?";

			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);

			statement.setInt(1, dado.getCodigo());
			statement.setString(2, dado.getNome());
			statement.setInt(3, dado.getCpf());
			statement.setInt(4, dado.getRg());
			statement.setString(5, dado.getDtNasc());
			statement.setString(6, dado.getEndereco());
			statement.setInt(7, dado.getCep());
			statement.setString(8, dado.getBairro());
			statement.setString(9, dado.getCargo());
			statement.setDouble(10, dado.getSalario());
			statement.setInt(11, dado.getCargarHoraria());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(Funcionario dado) {
		try {
			String sql = "delete from Funcionario where codigo = ?";

			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setInt(1, dado.getCodigo());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Funcionario> listar() {
		List<Funcionario> funcionarios = new ArrayList<>();

		try {
			Statement statement = ConexaoUtil.getConn().createStatement();
			ResultSet rs = statement.executeQuery("select * from funcionario");

			while (rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setCodigo(rs.getInt("codigo"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setCpf(rs.getInt("cpf"));
				funcionario.setRg(rs.getInt("rg"));
				funcionario.setDtNasc(rs.getString("dataNascimento"));
				funcionario.setEndereco(rs.getString("endereco"));
				funcionario.setCep(rs.getInt("cep"));
				funcionario.setBairro(rs.getString("bairro"));
				funcionario.setCargo(rs.getString("cargo"));
				funcionario.setSalario(rs.getDouble("salario"));
				funcionario.setCargarHoraria(rs.getInt("cargaHoraria"));
				funcionario.setDtaAdmissao(rs.getString("dataadmisao"));

				funcionarios.add(funcionario);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return funcionarios;
	}
}