package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import principal.dao.UsuarioDAO;
import principal.dao.UsuarioJDBC;
import principal.model.Usuario;

public class UsuarioController {

	@FXML
	private Button btnSalvar;

	@FXML
	private TextField tfLogin;

	@FXML
	private TextField tfSenha;

	private Usuario usuario;

	private UsuarioDAO usuarioDao = new UsuarioJDBC();

	@FXML
	void Salvar(ActionEvent event) {
		populaUsuario();
		usuarioDao.inserir(usuario);
		novoUsuario();
	}

	public void populaUsuario() {
		usuario = new Usuario();
		usuario.setLogin(tfLogin.getText());
		usuario.setSenha(tfSenha.getText());

		novoUsuario();

	}

	public void populaTela(Usuario usuario) {
		tfLogin.setText(usuario.getLogin());
		tfSenha.setText(usuario.getSenha());
	}

	void novoUsuario() {
		tfLogin.clear();
		tfSenha.clear();
		usuario = new Usuario();
	}

}
