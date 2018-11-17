package principal.dao;

import principal.model.Empresa;

public class EmpresaArquivo extends CrudArquivo<Empresa> implements EmpresaDAO {

	@Override
	protected ManipuladorArquivo<Empresa> criarManipulador(){
		return new ManipuladorArquivo<>("empresa.ser");
	}

	@Override
	public boolean checkLogin(String login, String senha) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void calcula(Empresa dado) {
		// TODO Auto-generated method stub
		
	}

}