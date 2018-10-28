package principal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import principal.conexao.ConexaoUtil;
import principal.model.Movimentos;

public class MovimentosJDBC implements MovimentosDAO {

	@Override
	public void inserir(Movimentos dado) {
		try {
			// Executa esse comando no BD
			String sql = "insert into Movimentos(codigo, numeroNota, dataEmisao, kmInicial, kmFinal, qtdPassageiros, origen, destino, nomeMotorista) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);

			statement.setInt(1, dado.getCodigo());
			statement.setInt(2, dado.getNumeroNota());
			statement.setString(3, dado.getDtaEmissao());
			statement.setDouble(4,dado.getKmInicial());
			statement.setDouble(5,dado.getKmFinal());
			statement.setInt(6,dado.getQtdPassageiros());
			statement.setString(7,dado.getOrigen());
			statement.setString(8,dado.getDestino());
			statement.setString(9, dado.getMotorista());
			
			
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterar(Movimentos dado) {
		try {
			String sql = "update Movimentos set movimentos = ?" + "where codigo= ?";

			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);

			statement.setInt(1, dado.getCodigo());
			statement.setInt(2, dado.getNumeroNota());
			statement.setString(3, dado.getDtaEmissao());
			statement.setDouble(4,dado.getKmInicial());
			statement.setDouble(5,dado.getKmFinal());
			statement.setInt(6,dado.getQtdPassageiros());
			statement.setString(7,dado.getOrigen());
			statement.setString(8,dado.getDestino());
			statement.setString(9, dado.getMotorista());
			

			statement.executeUpdate();

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
				movimento.setKmInicial(rs.getDouble("kmInicial"));
				movimento.setKmFinal(rs.getDouble("kmFinal"));
				movimento.setQtdPassageiros(rs.getInt("qtdPassageiros"));
				movimento.setOrigen(rs.getString("origen"));
				movimento.setDestino(rs.getString("destino"));
				movimento.setMotorista(rs.getString("nomeMotorista"));
				
				movimentos.add(movimento);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return movimentos;
	}

}
