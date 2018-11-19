package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import principal.dao.UsuarioDAO;
import principal.dao.UsuarioJDBC;
import principal.model.Usuario;

public class UsuarioController {

	@FXML
	private Button btnSalvar;

	@FXML
	private TextField tfLogin;

	@FXML
	private TextField tfsenha;

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
 		usuario.setSenha(tfsenha.getText());

	//	novoUsuario();

	}

	public void populaTela(Usuario usuario) {
		tfLogin.setText(usuario.getLogin());
		tfsenha.setText(usuario.getSenha());
	}

	void novoUsuario() {
		tfLogin.clear();
		tfsenha.clear();
		usuario = new Usuario();
	}
	@FXML
	private Button btnVoltarMenu;
	
	@FXML
	void Voltar(ActionEvent event) {
		btnVoltarMenu.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Stage stage = new Stage();
				Parent root = null;
				try {
					root = FXMLLoader.load(getClass().getResource("menu.fxml"));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
				btnVoltarMenu.getScene().getWindow().hide();
			}
		});
	}
}
