package principal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import principal.conexao.ConexaoUtil;
import principal.model.Manutencao;

public class ManutencaoJDBC implements ManutencaoDAO{

	@Override
	public void inserir(Manutencao dado) {
		try {
			String sql = "insert into manutencao(codigo, descricao, tipo, marca, aplicacao) values(?, ?, ?, ?, ?)";
			PreparedStatement stmt = ConexaoUtil.getConn().prepareStatement(sql);
			
			stmt.setInt(1, dado.getCodigo());
			stmt.setString(2, dado.getDescricao());
			stmt.setString(3, dado.getTipo());
			stmt.setString(4, dado.getMarca());
			stmt.setString(5, dado.getAplicacao());
			//stmt.setString(6, dado.getDataCadastro());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Manutencao dado) {
		try {
			String sql = "update manutencao set descricao = ?" +  "where codigo = ?";
			PreparedStatement stmt = ConexaoUtil.getConn().prepareStatement(sql);
			stmt.setInt(1, dado.getCodigo());
			stmt.setString(2, dado.getDescricao());
			stmt.setString(3, dado.getTipo());
			stmt.setString(4, dado.getMarca());
			stmt.setString(5, dado.getAplicacao());
			stmt.setString(6, dado.getDataCadastro());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(Manutencao dado) {
		try {
			String sql = "delete from manutencao where codigo = ?";
			
			PreparedStatement stmt = ConexaoUtil.getConn().prepareStatement(sql);
			stmt.setInt(1, dado.getCodigo());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public List<Manutencao> listar() {
		List<Manutencao> manutencoes = new ArrayList<>();
		try {
			Statement stmt = ConexaoUtil.getConn().createStatement();
			ResultSet rs = stmt.executeQuery("select * from manutencao");
			while(rs.next()) {
				Manutencao manutencao = new Manutencao();
				manutencao.setCodigo(rs.getInt("codigo"));
				manutencao.setDescricao(rs.getString("descricao"));
				manutencao.setTipo(rs.getString("tipo"));
				manutencao.setMarca(rs.getString("marca"));
				manutencao.setAplicacao(rs.getString("aplicacao"));
				manutencao.setDataCadastro(rs.getString("dataCadastro"));
				manutencoes.add(manutencao);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return manutencoes;
	}

}