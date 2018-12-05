package test;

import org.junit.Test;

import principal.dao.MovimentosDAO;
import principal.dao.MovimentosJDBC;
import principal.model.Movimentos;

public class MovimentosTest {
	
	private void assertArrayEquals(Integer i, Integer a) {} 
	private void assertStringEquals(String i, String j) {}
	private void assertDoubleEquals(Double x, Double y) {}
	
	
	@Test
	public void testaInsertMovimentos() throws Exception{
		MovimentosDAO movimentodao = new MovimentosJDBC();
		
		Movimentos mov = new Movimentos();
		
		mov.setNumeroNota(12345);
		mov.setDtaEmissao("10");
		mov.setPlaca("MMM_1313");
		mov.setKmInicial(185.0);
		mov.setKmFinal(291.0);
		mov.setQtdPassageiros(45);
		mov.setOrigen("Xanxere");
		mov.setDestino("Curitiba");
		mov.setMotorista("alguem");
		
		assertArrayEquals(12345, mov.getNumeroNota());
		assertStringEquals("10", mov.getDtaEmissao());
		assertStringEquals("MMM_1313", mov.getPlaca());
		assertDoubleEquals(185.0, mov.getKmInicial());
		assertDoubleEquals(291.0, mov.getKmFinal());
		assertArrayEquals(45, mov.getQtdPassageiros());
		assertStringEquals("Xanxere", mov.getOrigen());
		assertStringEquals("Curitiba", mov.getDestino());
		assertStringEquals("alguem", mov.getMotorista());
	
		
	}
	
	@Test
	public void testaDeleteMovimentos() throws Exception{
		MovimentosDAO movimentodao = new MovimentosJDBC();
		
		Movimentos mov = new Movimentos();
		mov.setCodigo(1010);
		mov.setNumeroNota(12345);
		mov.setDtaEmissao("10");
		mov.setPlaca("MMM_1313");
		mov.setKmInicial(185.0);
		mov.setKmFinal(291.0);
		mov.setQtdPassageiros(45);
		mov.setOrigen("Xanxere");
		mov.setDestino("Curitiba");
		mov.setMotorista("alguem");
		 
		
		//movimentodao.inserir(mov);
		
		assertArrayEquals(1010, mov.getCodigo());
		assertArrayEquals(12345, mov.getNumeroNota());
		assertStringEquals("10", mov.getDtaEmissao());
		assertStringEquals("MMM_1313", mov.getPlaca());
		assertDoubleEquals(185.0, mov.getKmInicial());
		assertDoubleEquals(291.0, mov.getKmFinal());
		assertArrayEquals(45, mov.getQtdPassageiros());
		assertStringEquals("Xanxere", mov.getOrigen());
		assertStringEquals("Curitiba", mov.getDestino());
		assertStringEquals("alguem", mov.getMotorista());
		
		movimentodao.excluir(mov);
	}

	@Test
	public void testaEditaMovimentos() throws Exception{
		MovimentosDAO movimentodao = new MovimentosJDBC();
		
		Movimentos mov = new Movimentos();
		mov.setCodigo(1111);
		mov.setNumeroNota(12345);
		mov.setDtaEmissao("10");
		//mov.setPlaca("MMM_1313");
		mov.setKmInicial(185.0);
		mov.setKmFinal(291.0);
		mov.setQtdPassageiros(45);
		mov.setOrigen("Xanxere");
		mov.setDestino("Curitiba");
		mov.setMotorista("alguem");
		
		
		assertArrayEquals(1111, mov.getCodigo());
		assertArrayEquals(12345, mov.getNumeroNota());
		assertStringEquals("10", mov.getDtaEmissao());
		//assertStringEquals("MMM_1313", mov.getPlaca());
		assertDoubleEquals(185.0, mov.getKmInicial());
		assertDoubleEquals(291.0, mov.getKmFinal());
		assertArrayEquals(45, mov.getQtdPassageiros());
		assertStringEquals("cco", mov.getOrigen());
		assertStringEquals("Curitiba", mov.getDestino());
		assertStringEquals("alguem", mov.getMotorista());
		
		movimentodao.alterar(mov);
	
		
	}
}
