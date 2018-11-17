package principal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import principal.conexao.ConexaoUtil;
import principal.model.Movimentos;

public class MovimentosJDBC implements MovimentosDAO {

	@Override
	public void inserir(Movimentos dado) {
		try {
			// Executa esse comando no BD
			String sql = "insert into Movimentos(codigo, numeroNota, dataEmisao, placaVeiculo, kmInicial, kmFinal, qtdPassageiros, origen, destino, nomeMotorista) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);

			statement.setInt(1, dado.getCodigo());
			statement.setInt(2, dado.getNumeroNota());
			statement.setString(3, dado.getDtaEmissao());
			statement.setString(4, dado.getVeiculo().toString());
			statement.setDouble(5, dado.getKmInicial());
			statement.setDouble(6, dado.getKmFinal());
			statement.setInt(7, dado.getQtdPassageiros());
			statement.setString(8, dado.getOrigen());
			statement.setString(9, dado.getDestino());
			statement.setString(10, dado.getMotorista());

			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Viagem inserida!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void alterar(Movimentos dado) {
		try {
			String sql = "UPDATE Movimentos SET numeroNota = ? , dataEmisao = ? , kmInicial = ? , kmFinal = ? , qtdPassageiros = ? , origen = ? , destino = ? , nomeMotorista = ?"
					+ " WHERE codigo = ?";

			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);

			statement.setInt(1, dado.getNumeroNota());
			statement.setString(2, dado.getDtaEmissao());
			statement.setDouble(3, dado.getKmInicial());
			statement.setDouble(4, dado.getKmFinal());
			statement.setInt(5, dado.getQtdPassageiros());
			statement.setString(6, dado.getOrigen());
			statement.setString(7, dado.getDestino());
			statement.setString(8, dado.getMotorista());
			statement.setInt(9, dado.getCodigo());
			
			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Dado alterado!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(Movimentos dado) {
		try {
			String sql = "delete from Movimentos where codigo = ?";

			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setInt(1, dado.getCodigo());
			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Viagem deletado!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Movimentos> listar() {
		List<Movimentos> movimentos = new ArrayList<>();
		try {
			Statement statement = ConexaoUtil.getConn().createStatement();
			ResultSet rs = statement.executeQuery("select * from movimentos");
			while (rs.next()) {
				Movimentos movimento = new Movimentos();
				movimento.setCodigo(rs.getInt("codigo"));
				movimento.setNumeroNota(rs.getInt("numeroNota"));
				movimento.setDtaEmissao(rs.getString("dataEmisao"));
				movimento.setPlaca(rs.getString("placaVeiculo"));
				movimento.setKmInicial(rs.getDouble("kmInicial"));
				movimento.setKmFinal(rs.getDouble("kmFinal"));
				movimento.setQtdPassageiros(rs.getInt("qtdPassageiros"));
				movimento.setOrigen(rs.getString("origen"));
				movimento.setDestino(rs.getString("destino"));
				movimento.setMotorista(String.valueOf(rs.getString("nomeMotorista")));
				movimento.setKmTotal(rs.getDouble("kmTotal"));

				movimentos.add(movimento);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return movimentos;
	}
	
	@Override
	public boolean checkLogin(String login, String senha) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void calcula(Movimentos dado) {
		try {
			String sql = "call atualizarKmTotal()";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
