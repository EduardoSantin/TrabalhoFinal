package principal.dao;

public class ArquivoFactroy implements DaoFactory {

	@Override
	public EmpresaDAO empresaDAO() {
		return new EmpresaArquivo();
	}

	@Override
	public VeiculoDAO veiculoDAO() {
		return null;
	}
	
	
}