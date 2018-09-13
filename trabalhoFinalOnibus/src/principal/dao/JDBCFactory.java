package principal.dao;

public class JDBCFactory implements DaoFactory {

	@Override
	public EmpresaDAO empresaDAO() {
		return new EmpresaJDBC();
	}

	
}
