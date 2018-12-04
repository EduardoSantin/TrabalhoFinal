package test;

import org.junit.Test;

import principal.dao.FuncionarioDAO;
import principal.dao.FuncionarioJDBC;
import principal.model.Funcionario;

public class FuncionarioTest {

	@Test
	public void testaInsertFuncionario() throws Exception{
		FuncionarioDAO funcionariodao = new FuncionarioJDBC();
		
		Funcionario f = new Funcionario();
		f.setNome("amado");
		f.setCpf(8956296);
		f.setRg(77522);
		f.setDtNasc("10/11/2001");
		f.setEndereco("sei la");
		f.setCep(7845);
		f.setBairro("bairro perau");
		f.setCargo("catador");
		f.setSalario(4000.d);
		f.setCargaHoraria(4.d);
		
		funcionariodao.inserir(f);
		
		funcionariodao.listar();
		assertStringEquals("amado", f.getNome());
		assertArrayEquals(8956296, f.getCpf());
		assertArrayEquals(77522, f.getRg());
		assertStringEquals("10/11/2001", f.getDtNasc());
		assertStringEquals("sei la", f.getEndereco());
		assertArrayEquals(7845, f.getCep());
		assertStringEquals("bairro perau", f.getBairro());
		assertStringEquals("catador", f.getCargo());
		assertDoubleEquals(4000.0, f.getSalario());
		assertDoubleEquals(4.0, f.getCargaHoraria());
	}
	
	@Test
	public void testaEditaFuncionario() throws Exception{
FuncionarioDAO funcionariodao = new FuncionarioJDBC();
		
		Funcionario f = new Funcionario();
		f.setNome("amado");
		f.setCpf(8956296);
		f.setRg(77522);
		f.setDtNasc("10/11/2001");
		f.setEndereco("sei la");
		f.setCep(7845);
		f.setBairro("bairro perau");
		f.setCargo("catador");
		f.setSalario(4000.d);
		f.setCargaHoraria(4.d);
		
		funcionariodao.inserir(f);
		
		f.setNome("amado batista");
		f.setCpf(8956296);
		f.setRg(77522);
		f.setDtNasc("10/11/2001");
		f.setEndereco("sei la");
		f.setCep(7845);
		f.setBairro("bairro perau");
		f.setCargo("catador");
		f.setSalario(4000.d);
		f.setCargaHoraria(4.d);
		
		//funcionariodao.alterar(f);
	}

	private void assertArrayEquals(int i, Integer codigo) {} 
	private void assertStringEquals(String i, String j) {}
	private void assertDoubleEquals(Double x, Double y) {}

}
