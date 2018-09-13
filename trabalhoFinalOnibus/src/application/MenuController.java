package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

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
    void MenuEmpresa(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("CadastroEmpresa.fxml"));
		try {
			AnchorPane cursoView = (AnchorPane) loader.load();
			bpPrincipal.setCenter(cursoView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    }

    @FXML
    void MenuVeiculo(ActionEvent event) {

    }

    @FXML
    void MenuFuncionario(ActionEvent event) {

    }

    @FXML
    void MenuManutencao(ActionEvent event) {

    }

    @FXML
    void MenuControleFinanceiro(ActionEvent event) {

    }

    @FXML
    void MenuDespesas(ActionEvent event) {

    }

}
