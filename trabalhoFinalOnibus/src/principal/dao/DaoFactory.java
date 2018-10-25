package principal.dao;

public interface DaoFactory {
	
	EmpresaDAO empresaDAO();
	VeiculoDAO veiculoDAO();
	FuncionarioDAO funcionarioDAO();
}