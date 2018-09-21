package principal.dao;

public class JDBCFactory implements DaoFactory {

	@Override
	public EmpresaDAO empresaDAO() {
		return new EmpresaJDBC();
	}

	@Override
	public VeiculoDAO veiculoDAO() {
		return new VeiculoJDBC();
	}

}