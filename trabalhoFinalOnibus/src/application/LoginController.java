package application;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.glass.ui.Menu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import principal.dao.UsuarioDAO;
import principal.dao.UsuarioJDBC;
import principal.model.Usuario;

public class LoginController {

	@FXML
	private TextField tfCodigo;

	@FXML
	private TextField tfLogin;

	@FXML
	private TextField tfSenha;

	@FXML
	private Button btnLogar;

	@FXML
	private Button btEsqueceu;

	private Usuario login;
	
	
	@FXML
    private void initialize() {
		UsuarioDAO usuarioDao = new UsuarioJDBC();
		btnLogar.setOnAction(new EventHandler<ActionEvent>() {

			
			@Override
			public void handle(ActionEvent event) {
				if(usuarioDao.checkLogin(tfLogin.getText(), tfSenha.getText())) {
					
					Stage stage = new Stage();
					Parent root = null;
					try {
						root = FXMLLoader.load(getClass().getResource("menu.fxml"));
					} catch (Exception ex) {
						Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null,ex);
					}
					Scene scene = new Scene(root);	
					stage.setScene(scene);
					stage.show();
					
					btnLogar.getScene().getWindow().hide();
					alertSucesso();	
				}else {
					alertERRO();
					limpar();
				}
			}
		});
		
	}
	// metodo para limpar os textField
	void limpar() {
		tfLogin.clear();
		tfSenha.clear();
	}
	
	public Usuario getLogin() {
		return login;
	}
	
	//metodo alert que confirma o login com sucesso
	public void alertSucesso() {
		Alert alert  = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("LOGIN");
		alert.setHeaderText("Logado com Sucesso");
		alert.show();	
	}
	//metodo alert erro de login ou senha 
	public void alertERRO() {
		Alert alert  = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("LOGIN");
		alert.setHeaderText("ERRO! Login ou senha incorretos");
		alert.show();	
	}
	
}
