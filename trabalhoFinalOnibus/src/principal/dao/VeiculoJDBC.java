package principal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import principal.conexao.ConexaoUtil;
import principal.model.Veiculo;

public class VeiculoJDBC implements VeiculoDAO {

	@Override
	public void inserir(Veiculo dado) {
		try {
			// Executa esse comando no BD
			String sql = "insert into veiculo(codigo, renavan, marca, modelo, placa, motor, chassi) values (?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);

			statement.setInt(1, dado.getCodigo());
			statement.setInt(2, dado.getRenavan());
			statement.setString(3, dado.getMarca());
			statement.setString(4, dado.getModelo());
			statement.setString(5, dado.getPlaca());
			statement.setString(6, dado.getMotor());
			statement.setInt(7, dado.getChassi());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Veiculo dado) {
		try {
			String sql = "update veiculo set veiculo = ?" + "where codigo= ?";

			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);

			statement.setInt(1, dado.getCodigo());
			statement.setInt(2, dado.getRenavan());
			statement.setString(3, dado.getMarca());
			statement.setString(4, dado.getModelo());
			statement.setString(5, dado.getPlaca());
			statement.setString(6, dado.getMotor());
			statement.setInt(7, dado.getChassi());
			statement.setString(8, dado.getCategoria());
			statement.setString(9, dado.getCombustivel());
			statement.setString(10, dado.getDataCadastro());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void excluir(Veiculo dado) {
		try {
			String sql = "delete from veiculo where codigo = ?";

			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setInt(1, dado.getCodigo());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Veiculo> listar() {
		List<Veiculo> veiculos = new ArrayList<>();

		try {
			Statement statement = ConexaoUtil.getConn().createStatement();
			ResultSet rs = statement.executeQuery("select * from veiculo");

			while (rs.next()) {
				Veiculo veiculo = new Veiculo();
				veiculo.setCodigo(rs.getInt("codigo"));
				veiculo.setRenavan(rs.getInt("renavan"));
				veiculo.setMarca(rs.getString("marca"));
				veiculo.setModelo(rs.getString("modelo"));
				veiculo.setPlaca(rs.getString("placa"));
				veiculo.setMotor(rs.getString("motor"));
				veiculo.setChassi(rs.getInt("chassi"));
				veiculos.add(veiculo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return veiculos;
	}
}
