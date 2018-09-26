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
	
	
}