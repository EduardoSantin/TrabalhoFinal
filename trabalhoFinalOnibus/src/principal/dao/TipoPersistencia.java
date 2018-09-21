package principal.dao;

public enum TipoPersistencia {


	BANCO(new JDBCFactory()), ARQUIVO(new ArquivoFactroy());
	
	TipoPersistencia(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	private DaoFactory daoFactory;

	public DaoFactory createFactory() {
		return daoFactory;
	}

}
