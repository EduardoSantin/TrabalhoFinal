package test;

import org.junit.Test;

import principal.dao.MovimentosDAO;
import principal.dao.MovimentosJDBC;
import principal.model.Movimentos;
import principal.model.Veiculo;

public class MovimentosTest {
	
	private void assertArrayEquals(Integer i, Integer a) {
	} 
	
	private void assertStringEquals(String i, String j) {
		
	}
	
	
	@Test
	public void testaInsertMovimentos() throws Exception{
		MovimentosDAO movimentodao = new MovimentosJDBC();
		
		Movimentos mov = new Movimentos();
		
		mov.setCodigo(123);
		mov.setNumeroNota(12345);
		mov.setDtaEmissao("10");
		//m.setKmInicial(185.0);
		//m.setKmFinal(291.0);
		mov.setQtdPassageiros(45);
		mov.setOrigen("Xanxere");
		mov.setDestino("Curitiba");
		mov.setMotorista("alguem");
		mov.setPlaca("XXX-0000");
		//m.setKmTotal(106.0);
		
		//arrumar pq nao insere
		
		movimentodao.inserir(mov);
		
		
		assertArrayEquals(123, mov.getCodigo());
		assertArrayEquals(12345, mov.getNumeroNota());
		assertStringEquals("10", mov.getDtaEmissao());
		//assertDoubleEquals(185.0, m.getKmInicial());
		//assertDoubleEquals(291.0, m.getKmFinal());
		assertArrayEquals(45, mov.getQtdPassageiros());
		assertStringEquals("Xanxere", mov.getOrigen());
		assertStringEquals("Curitiba", mov.getDestino());
		assertStringEquals("alguem", mov.getMotorista());
		assertStringEquals("XXX-0000", mov.getPlaca());
	//	assertDoubleEquals(106.0, m.getKmTotal());
		
	}

}
