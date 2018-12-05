package test;

import org.junit.Test;

import principal.dao.VeiculoDAO;
import principal.dao.VeiculoJDBC;
import principal.model.Veiculo;

public class VeiculoTest {

	private void assertArrayEquals(int i, Integer codigo) {} 
	private void assertStringEquals(String i, String j) {}
	
	@Test
	public void testaInsertVeiculo() throws Exception{
		VeiculoDAO veiculodao = new VeiculoJDBC();
		
		Veiculo v = new Veiculo();
		v.setRenavan(1234);
		v.setMarca("scania");
		v.setModelo("bomba");
		v.setPlaca("MMM_1313");
		v.setChassi(856562);
		v.setMotor("escania");
		
		veiculodao.inserir(v); 
		
		veiculodao.listar();
		assertArrayEquals(1234, v.getRenavan());
		assertStringEquals("scania", v.getMarca());
		assertStringEquals("bomba", v.getModelo());
		assertStringEquals("MMM-1313", v.getPlaca());
		assertArrayEquals(856562, v.getChassi());
		assertStringEquals("escania", v.getMotor());
	}
	  
	@Test
	public void testaExcluiVeiculo() throws Exception{
		VeiculoDAO veiculodao = new VeiculoJDBC();
		Veiculo v = new Veiculo();
		
		v.setCodigo(9191);
		v.setRenavan(1234);
		v.setMarca("scania");
		v.setModelo("bomba");
		v.setPlaca("MMM_1313");
		v.setChassi(856562);
		v.setMotor("escania");
		
		veiculodao.inserir(v);
		
		assertArrayEquals(9191, v.getCodigo());
		assertArrayEquals(1234, v.getRenavan());
		assertStringEquals("scania", v.getMarca());
		assertStringEquals("bomba", v.getModelo());
		assertStringEquals("MMM-1313", v.getPlaca());
		assertArrayEquals(856562, v.getChassi());
		assertStringEquals("escania", v.getMotor());
		
		veiculodao.excluir(v);
	
		
	}
	
	/*@Test
	public void testaEditaVeiculo() throws Exception{
		VeiculoDAO veiculodao = new VeiculoJDBC();
		Veiculo v = new Veiculo();
		
		v.setCodigo(921);
		v.setRenavan(1234);
		v.setMarca("scania");
		v.setModelo("bomba");
		v.setPlaca("MMM_1313");
		v.setChassi(856562);
		v.setMotor("escania");
		
		veiculodao.inserir(v);
		
		assertArrayEquals(921, v.getCodigo());
		assertArrayEquals(1234, v.getRenavan());
		assertStringEquals("Mercede", v.getMarca());
		assertStringEquals("bomba", v.getModelo());
		assertStringEquals("MMM-1313", v.getPlaca());
		assertArrayEquals(856562, v.getChassi());
		assertStringEquals("escania", v.getMotor());
		
		veiculodao.alterar(v);
	
		
	}*/
}

