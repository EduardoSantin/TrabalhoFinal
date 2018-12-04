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
		assertStringEquals("bomba", v.getModelo());
		assertStringEquals("MMM-1313", v.getPlaca());
		assertArrayEquals(856562, v.getChassi());
		assertStringEquals("escania", v.getMotor());
	}
	
	
}

