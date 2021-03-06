package principal.dao;

import java.util.List;

public interface CrudDAO<T> {

	void inserir(T dado);

	void alterar(T dado);

	void excluir(T dado);

	List<T> listar();

	boolean checkLogin(String login, String senha);
	
	void calcula(T dado);

}