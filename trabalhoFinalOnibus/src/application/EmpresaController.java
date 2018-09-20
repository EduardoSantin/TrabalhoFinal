package application;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import principal.dao.AbstractFactory;
import principal.dao.EmpresaDAO;
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
	private Button btnDeletar;

	@FXML
	private Button btnNovo;

	private Empresa empresa;

	private boolean editando;

	private EmpresaDAO empresadao = AbstractFactory.get().empresaDAO();

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

	public void populaTela(Empresa area) {
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
			empresa = (Empresa) tblEmpresa.getSelectionModel().getSelectedItem();
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
		novoEmpresa();
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
		tblEmpresa.setItems(FXCollections.observableArrayList(empresadao.listar()));
	}
}
