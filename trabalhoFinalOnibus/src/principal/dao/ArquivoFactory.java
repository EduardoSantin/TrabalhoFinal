package principal.dao;

public class ArquivoFactory implements DaoFactory {

	@Override
	public EmpresaDAO empresaDAO() {
		return new EmpresaArquivo();
	}

	@Override
	public VeiculoDAO veiculoDAO() {
		return null;
	}

	@Override
	public FuncionarioDAO funcionarioDAO() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}