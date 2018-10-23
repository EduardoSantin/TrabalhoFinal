package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import principal.model.Usuario;

public class LoginDialogFabrica {

	private Stage stageDono;

	public LoginDialogFabrica(Stage stageDono) {
		this.stageDono = stageDono;
	}

	public Usuario showDialog() {
		Usuario loginSelecionado = null;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("login.fxml"));
		try {
			AnchorPane loginDialog = (AnchorPane) loader.load();
			
			//cria o palco dialogStage pro Login
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Login");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(stageDono);
			Scene scene = new Scene(loginDialog);
			dialogStage.setScene(scene);
			
			LoginController controller = loader.getController();
			controller.setStageDialog(dialogStage);
			
			dialogStage.showAndWait();
			
			loginSelecionado = controller.getLogin();
		}catch(IOException e1) {
			e1.printStackTrace();
		}
		return loginSelecionado;
	}

}
