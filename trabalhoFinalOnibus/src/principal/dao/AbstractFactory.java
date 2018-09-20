package principal.dao;

public class AbstractFactory {

	private static DaoFactory factory;

	// Inicializa uma ?nica copica da fabrica

	static {
	String tipoPersistencia =
			System.getProperty("tipoPersistencia");
	
		//E apartir daqui q vai inicializar em banco ou em arquivoo
		if(tipoPersistencia.equals("arquivo")) {
		factory = new ArquivoFactroy();
	}
		if(tipoPersistencia.equals("banco")) {
			factory = (DaoFactory) new JDBCFactory();
		}
	}
	// Retorna a fabrica criada
	public static DaoFactory get() {
		return factory;
	
	}
}