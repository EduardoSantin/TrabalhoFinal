package principal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import principal.conexao.ConexaoUtil;
import principal.model.Veiculo;

public class VeiculoJDBC implements VeiculoDAO {

	@Override
	public void inserir(Veiculo dado) {
		try {
			// Executa esse comando no BD
			String sql = "insert into veiculo(renavan, marca, modelo, placa, motor, chassi, dataCadastro) values (?, ?, ?, ?, ?, ?, now())";

			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);

			statement.setInt(1, dado.getRenavan());
			statement.setString(2, dado.getMarca());
			statement.setString(3, dado.getModelo());
			statement.setString(4, dado.getPlaca());
			statement.setString(5, dado.getMotor());
			statement.setInt(6, dado.getChassi());
			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Ve�culo inserido!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Veiculo dado) {
		/*try {
			String sql = "UPDATE Veiculo SET renavan = ? , marca = ? , modelo = ? , placa = ? , chassi = ? , motor = ? "
					+ "WHERE codigo = ?";

			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);

			statement.setInt(1, dado.getRenavan());
			statement.setString(2, dado.getMarca());
			statement.setString(3, dado.getModelo());
			statement.setString(4, dado.getPlaca());
			statement.setInt(5, dado.getChassi());
			statement.setString(6, dado.getMotor());
			statement.setInt(7, dado.getCodigo());
			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Dado alterado!");

		} catch (SQLException e) {
			e.printStackTrace();
		}*/

	}

	@Override
	public void excluir(Veiculo dado) {
		try {
			String sql = "delete from veiculo where codigo = ?";

			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setInt(1, dado.getCodigo());
			statement.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Ve�culo deletado!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Veiculo> listar() {
		List<Veiculo> veiculos = new ArrayList<>();

		try {
			Statement statement = ConexaoUtil.getConn().createStatement();
			ResultSet rs = statement.executeQuery("select * from veiculo order by marca");

			while (rs.next()) {
				Veiculo veiculo = new Veiculo();
				veiculo.setCodigo(rs.getInt("codigo"));
				veiculo.setRenavan(rs.getInt("renavan"));
				veiculo.setMarca(rs.getString("marca"));
				veiculo.setModelo(rs.getString("modelo"));
				veiculo.setPlaca(rs.getString("placa"));
				veiculo.setMotor(rs.getString("motor"));
				veiculo.setChassi(rs.getInt("chassi"));
				veiculo.setDataCadastro(rs.getString("dataCadastro"));
				veiculos.add(veiculo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return veiculos;
	}

	@Override
	public boolean checkLogin(String login, String senha) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void calcula(Veiculo dado) {
		// TODO Auto-generated method stub
		
	}
}
