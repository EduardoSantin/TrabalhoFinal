package principal.dao;

import principal.model.Empresa;

public class EmpresaArquivo extends CrudArquivo<Empresa> implements EmpresaDAO {

	@Override
	protected ManipuladorArquivo<Empresa> criarManipulador(){
		return new ManipuladorArquivo<>("empresa.ser");
	}

}
