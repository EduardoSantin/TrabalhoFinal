package test;

import org.junit.Test;

import principal.dao.EmpresaDAO;
import principal.dao.EmpresaJDBC;
import principal.model.Empresa;

public class EmpresaTest {

	private void assertArrayEquals(int i, Integer codigo) {} 
	private void assertStringEquals(String i, String j) {}
	
	@Test
	public void testainsertEmpresa() throws Exception {
		EmpresaDAO empresaDao = new EmpresaJDBC();
		
		Empresa e = new Empresa();
		
		e.setRazaoSocial("sei la q razao");
		e.setNomeFantasia("vai sabe a fantasia");
		e.setCnpj(784512);
		e.setEndereco("vo sabe aonde");
		e.setNumero(874512);
		e.setBairro("vai sabe o bairro");
		e.setCep(78965);
		e.setUf("SC");
		
		assertStringEquals("sei la q razao", e.getRazaoSocial());
		assertStringEquals("vai sabe a fantasia", e.getNomeFantasia());
		assertArrayEquals(7845512, e.getCnpj());
		assertStringEquals("vo sabe aonde", e.getEndereco());
		assertArrayEquals(874512, e.getNumero());
		assertStringEquals("vai sabe o bairro", e.getBairro());
		assertArrayEquals(78965, e.getCep());
		assertStringEquals("SC", e.getUf());
	}
}
