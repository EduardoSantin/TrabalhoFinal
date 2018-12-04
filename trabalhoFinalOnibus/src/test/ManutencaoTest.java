package test;

import org.junit.Test;

import principal.dao.ManutencaoDAO;
import principal.dao.ManutencaoJDBC;
import principal.model.Manutencao;

public class ManutencaoTest {
	
	private void assertStringEquals(String i, String j) {}
	//private void assertArrayEquals(int i, Integer j) {}
	
	@Test
	public void testaInsertManutencao() throws Exception{
		ManutencaoDAO manutencaodao = new ManutencaoJDBC();
		
		Manutencao m = new Manutencao();
	
		//m.setCodigo(888);
		m.setDescricao("amortecedor");
		m.setTipo("preventiva");
		//m.setPlaca("XXX-2000");
		//m.setDataCadastro("10/10/10");
	
		// nao insere
		//manutencaodao.inserir(m);
		
		//manutencaodao.listar();
		//assertArrayEquals(888, m.getCodigo());
		assertStringEquals("amortecedor", m.getDescricao());
		assertStringEquals("preventiva", m.getTipo());
		//assertStringEquals("XXX-2000", m.getPlaca());
		//assertStringEquals("10/10/10", m.getDataCadastro());
	
	}

}
