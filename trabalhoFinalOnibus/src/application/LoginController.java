package application;

import java.util.logging.Level;
import java.util.logging.Logger;

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
import principal.model.Usuario;

public class LoginController {

	@FXML
	private TextField tfCodigo;

	@FXML
	private TextField tfNome;

	@FXML
	private TextField tfSenha;

	@FXML
	private Button btnLogar;

	@FXML
	private Button btEsqueceu;

	private Usuario login;
	
	@FXML
    private void initialize() {
		btnLogar.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				if(tfNome.getText().equals("Gerente")&& tfSenha.getText().equals("g123")) {
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
					stage.setTitle(tfNome.getText());
					btnLogar.getScene().getWindow().hide();
					alertSucesso();
					
					
				}else 
					if(tfNome.getText().equals("Funcionario")&& tfSenha.getText().equals("f123")) {
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
					stage.setTitle(tfNome.getText());
					btnLogar.getScene().getWindow().hide();
					alertSucesso();
					
				}else {
					alertERRO();	
				}
				
			}
		});
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
