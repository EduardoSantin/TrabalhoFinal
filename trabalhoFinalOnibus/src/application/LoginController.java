package application;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
				
				if(tfNome.getText().equals("admin")&& tfSenha.getText().equals("123")) {
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
					stage.setTitle("logado");
					
					btnLogar.getScene().getWindow().hide();
				}
				// por enquanto ta logando com adm e senha padrao
			}
		});
	}
	

	public Usuario getLogin() {
		return login;
	}
}
