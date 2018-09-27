package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import principal.model.Login;

public class LoginController {

	
	@FXML
	private TextField tfCodigo;

	@FXML
	private TextField tfNome;

	@FXML
	private TextField tfSenha;

	@FXML
	private Button btnConectar;

	private Stage dialogStage;
	
	private Login login;
	
	@FXML
	void conectar(ActionEvent event) {

	}

	public void setStageDialog(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	public Login getLogin(){
		return login;
	}
}
