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
			String sql = "insert into Funcionario(codigo, nome, cpf, rg, clps, dataNascimento, endereco, bairro, cep, cargo, salario, dataadmisao) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);

			statement.setInt(1, dado.getCodigo());
			statement.setString(2, dado.getNome());
			statement.setInt(3, dado.getCpf());
			statement.setInt(4, dado.getRg());
			statement.setInt(5, dado.getClps());
			statement.setString(6, dado.getDtNasc());
			statement.setString(7, dado.getEndereco());
			statement.setString(8, dado.getBairro());
			statement.setInt(9, dado.getCep());
			statement.setString(10, dado.getCargo());
			statement.setFloat(11, dado.getSalario());
			statement.setString(12, dado.getDtaAdmissao());

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
			statement.setInt(5, dado.getClps());
			statement.setString(6, dado.getDtNasc());
			statement.setString(7, dado.getEndereco());
			statement.setString(8, dado.getBairro());
			statement.setInt(9, dado.getCep());
			statement.setString(10, dado.getCargo());
			statement.setFloat(11, dado.getSalario());
			statement.setString(12, dado.getDtaAdmissao());

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
				funcionario.setClps(rs.getInt("clps"));
				funcionario.setDtNasc(rs.getString("dataNascimento"));
				funcionario.setEndereco(rs.getString("endereco"));
				funcionario.setBairro(rs.getString("bairro"));
				funcionario.setCep(rs.getInt("cep"));
				funcionario.setCargo(rs.getString("cargo"));
				funcionario.setSalario(rs.getInt("salario"));
				funcionario.setDtaAdmissao(rs.getString("dataadmisao"));
				funcionarios.add(funcionario);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return funcionarios;
	}
}