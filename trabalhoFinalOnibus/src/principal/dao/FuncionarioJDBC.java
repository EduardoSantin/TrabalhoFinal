package principal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import principal.conexao.ConexaoUtil;
import principal.model.Funcionario;

public class FuncionarioJDBC implements FuncionarioDAO {

	@Override
	public void inserir(Funcionario dado) {
		try {
			// Executa esse comando no BD
			String sql = "insert into Funcionario(codigo, nome, cpf, rg, dataNascimento, endereco, cep, bairro, cargo, salario, cargaHoraria, dataAdmisao) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now())";

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
			statement.setDouble(11, dado.getCargaHoraria());

			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Funcionário inserido!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Funcionario dado) {
		try {
			String sql = "UPDATE Funcionario SET nome = ? , cpf = ? , rg = ? , dataNascimento = ? , endereco = ? , cep = ? , bairro = ? , cargo = ? , salario = ? , cargaHoraria = ?"
					+ " where codigo = ?";

			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			
			statement.setString(1, dado.getNome());
			statement.setInt(2, dado.getCpf());
			statement.setInt(3, dado.getRg());
			statement.setString(4, dado.getDtNasc());
			statement.setString(5, dado.getEndereco());
			statement.setInt(6, dado.getCep());
			statement.setString(7, dado.getBairro());
			statement.setString(8, dado.getCargo());
			statement.setDouble(9, dado.getSalario());
			statement.setDouble(10, dado.getCargaHoraria());
			statement.setInt(11, dado.getCodigo());

			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Dado alterado!");

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

			JOptionPane.showMessageDialog(null, "Funcionário deletado!");


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
				funcionario.setCargaHoraria(rs.getDouble("cargaHoraria"));
				funcionario.setDtaAdmissao(rs.getString("dataAdmisao"));

				funcionarios.add(funcionario);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return funcionarios;
	}

	@Override
	public boolean checkLogin(String login, String senha) {
		// TODO Auto-generated method stub
		return false;
	}
}