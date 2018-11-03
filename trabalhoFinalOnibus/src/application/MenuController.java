package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import principal.model.Usuario;

public class MenuController {

	@FXML
	private MenuItem mmiEmpresa;

	@FXML
	private MenuItem mmiDespesas;

	@FXML
	private MenuItem mmiManutencao;

	@FXML
	private MenuItem mmiControleFinanceiro;

	@FXML
	private MenuItem mmiVeiculo;

	@FXML
	private MenuItem mmiFuncionario;

	@FXML
	private BorderPane bpPrincipal;

	@FXML
	private Button btnEntrar;

	@FXML
	private MenuItem mniUsuario;

	@FXML
	private Label lbUser;


	@FXML
	void MenuEmpresa(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("CadastroEmpresa.fxml"));
		try {
			AnchorPane menuView = (AnchorPane) loader.load();
			bpPrincipal.setCenter(menuView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	void MenuVeiculo(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Veiculo.fxml"));
		try {
			AnchorPane menuView = (AnchorPane) loader.load();
			bpPrincipal.setCenter(menuView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	@FXML
	void MenuFuncionario(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("CadastroFuncionario.fxml"));
		try {
			AnchorPane menuView = (AnchorPane) loader.load();
			bpPrincipal.setCenter(menuView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	void MenuManutencao(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("CadastroManutencao.fxml"));
		try {
			AnchorPane menuView = (AnchorPane) loader.load();
			bpPrincipal.setCenter(menuView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	void MenuControleFinanceiro(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Movimentos.fxml"));
		try {
			AnchorPane menuView = (AnchorPane) loader.load();
			bpPrincipal.setCenter(menuView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	void MenuDespesas(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("CadastroManutencao.fxml"));
		try {
			AnchorPane menuView = (AnchorPane) loader.load();
			bpPrincipal.setCenter(menuView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	void MenuUsuario(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("CadastroUsuario.fxml"));
		try {
			AnchorPane menuView = (AnchorPane) loader.load();
			bpPrincipal.setCenter(menuView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

}