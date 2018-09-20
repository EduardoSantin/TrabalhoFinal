package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FuncionarioController {

    @FXML
    private TextField tfCodigo;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfCPF;

    @FXML
    private TextField tfRg;

    @FXML
    private TextField tfCtps;

    @FXML
    private TextField tfEndereco;

    @FXML
    private TextField tfCep;

    @FXML
    private TextField tfBairro;

    @FXML
    private TableView<?> tblFuncionario;

    @FXML
    private TableColumn<?, ?> tbcCodigo;

    @FXML
    private TableColumn<?, ?> tbcnome;

    @FXML
    private TableColumn<?, ?> tbcCpf;

    @FXML
    private TableColumn<?, ?> tbcRg;

    @FXML
    private TableColumn<?, ?> tbcCtps;

    @FXML
    private TableColumn<?, ?> tbcDataNascimento;

    @FXML
    private TableColumn<?, ?> tbcEndereco;

    @FXML
    private TableColumn<?, ?> tbcCep;

    @FXML
    private TableColumn<?, ?> tbcBairo;

    @FXML
    private TableColumn<?, ?> tbcBanco;

    @FXML
    private TableColumn<?, ?> tbcSalario;

    @FXML
    private TableColumn<?, ?> tbcCargo;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnNovo;

    @FXML
    private Button btnDeletar;

    @FXML
    private TextField tfCargo;

    @FXML
    private TextField tfSalario;

    @FXML
    private TextField tfCargaHoraria;

    @FXML
    private TextField tfBanco;

    @FXML
    private TextField tfAgencia;

    @FXML
    private TextField tfConta;

    @FXML
    private DatePicker dpData;

    @FXML
    private DatePicker dpDataAdmissao;

    @FXML
    private DatePicker dpDataNascimento;

    @FXML
    void deletar(ActionEvent event) {

    }

    @FXML
    void novo(ActionEvent event) {

    }

    @FXML
    void salvar(ActionEvent event) {

    }

}
