package application;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import principal.dao.EmpresaDAO;
import principal.dao.EmpresaJDBC;
import principal.model.Empresa;

public class EmpresaController {

	@FXML
	private TextField tfNomeFantasia;

	@FXML
	private Pane apEmpresa;

	@FXML
	private TextField tfCodigo;

	@FXML
	private TextField tfEndereco;

	@FXML
	private TextField tfCep;

	@FXML
	private TextField tfUf;

	@FXML
	private TextField tfNumero;

	@FXML
	private TextField tfCnpj;

	@FXML
	private TextField tfBairro;

	@FXML
	private TextField tfRazaoSocial;

	@FXML
	private TableView<Empresa> tblEmpresa;

	@FXML
	private TableColumn<Empresa, Integer> tbcNumero;

	@FXML
	private TableColumn<Empresa, String> tbcRazaoSocial;

	@FXML
	private TableColumn<Empresa, Integer> tbcCodigo;

	@FXML
	private TableColumn<Empresa, String> tbcUf;

	@FXML
	private TableColumn<Empresa, String> tbcNomeFantasia;

	@FXML
	private TableColumn<Empresa, Integer> tbcCnpj;

	@FXML
	private TableColumn<Empresa, String> tbcBairro;

	@FXML
	private TableColumn<Empresa, Integer> tbcCep;

	@FXML
	private TableColumn<Empresa, String> tbcEndereco;

	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnVoltarMenu;
	
	@FXML
	private Button btnDeletar;

	@FXML
	private Button btnNovo;

	private Empresa empresa;

	private boolean editando;

	private EmpresaDAO empresadao = new EmpresaJDBC();

	@FXML
	private void initialize() {
		tbcCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		tbcRazaoSocial.setCellValueFactory(new PropertyValueFactory<>("razaoSocial"));
		tbcNomeFantasia.setCellValueFactory(new PropertyValueFactory<>("nomeFantasia"));
		tbcCnpj.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
		tbcEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		tbcNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
		tbcBairro.setCellValueFactory(new PropertyValueFactory<>("bairro"));
		tbcCep.setCellValueFactory(new PropertyValueFactory<>("cep"));
		tbcUf.setCellValueFactory(new PropertyValueFactory<>("uf"));
		
		novoEmpresa();
		
	}

	@FXML
	void Salvar(ActionEvent event) {

		populaEmpresa();

		if (editando) {
			empresadao.alterar(empresa);
		} else {
			empresadao.inserir(empresa);
		}
		novoEmpresa();
		tblEmpresa.refresh();
	}

	public void populaEmpresa() {
		empresa.setCodigo(Integer.valueOf(tfCodigo.getText()));
		empresa.setRazaoSocial(tfRazaoSocial.getText());
		empresa.setNomeFantasia(tfNomeFantasia.getText());
		empresa.setCnpj(Integer.valueOf(tfCnpj.getText()));
		empresa.setEndereco(tfEndereco.getText());
		empresa.setNumero(Integer.valueOf(tfNumero.getText()));
		empresa.setBairro(tfBairro.getText());
		empresa.setCep(Integer.valueOf(tfCep.getText()));
		empresa.setUf(tfUf.getText());

	}

	public void populaTela(Empresa empresa) {
		tfCodigo.setText(empresa.getCodigo().toString());
		tfRazaoSocial.setText(empresa.getRazaoSocial());
		tfNomeFantasia.setText(empresa.getNomeFantasia());
		tfCnpj.setText(empresa.getCnpj().toString());
		tfEndereco.setText(empresa.getEndereco());
		tfNumero.setText(empresa.getNumero().toString());
		tfBairro.setText(empresa.getBairro());
		tfCep.setText(empresa.getCep().toString());
		tfUf.setText(empresa.getUf());

	}

	@FXML
	void selecionaEmpresa(MouseEvent event) {
		if (tblEmpresa.getSelectionModel().getSelectedItem() != null) {
			empresa = tblEmpresa.getSelectionModel().getSelectedItem();
			populaTela(empresa);
			editando = true;
		}
	}

	@FXML
	void Novo(ActionEvent event) {
		novoEmpresa();
	}

	@FXML
	void Deletar(ActionEvent event) {
		if (tblEmpresa.getSelectionModel().getSelectedItem() != null) {
			empresa = tblEmpresa.getSelectionModel().getSelectedItem();
			populaTela(empresa);
		if ( new  AlertaFactory () . confirmaExclusao ()) {
			empresadao . excluir (empresa);
			novoEmpresa();
		}
		}
	}

	void novoEmpresa() {
		tfCodigo.clear();
		tfRazaoSocial.clear();
		tfNomeFantasia.clear();
		tfCnpj.clear();
		tfEndereco.clear();
		tfNumero.clear();
		tfBairro.clear();
		tfCep.clear();
		tfUf.clear();
		editando = false;
		empresa = new Empresa();
		tblEmpresa.setItems(FXCollections.observableArrayList(empresadao.listar()));
	}
	
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
