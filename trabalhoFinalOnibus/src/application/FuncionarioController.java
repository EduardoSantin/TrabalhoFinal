package application;

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
import javafx.stage.Stage;
import principal.dao.FuncionarioDAO;
import principal.dao.FuncionarioJDBC;
import principal.model.Funcionario;

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
	private TextField tfDataNascimento;

	@FXML
	private TextField tfEndereco;

	@FXML
	private TextField tfCep;

	@FXML
	private TextField tfBairro;

	@FXML
	private TextField tfCargo;

	@FXML
	private TextField tfSalario;

	@FXML
	private TextField tfCargaHoraria;

	@FXML
	private TableView<Funcionario> tblFuncionario;

	@FXML
	private TableColumn<Funcionario, Integer> tbcCodigo;

	@FXML
	private TableColumn<Funcionario, String> tbcnome;

	@FXML
	private TableColumn<Funcionario, Integer> tbcCpf;

	@FXML
	private TableColumn<Funcionario, Integer> tbcRg;

	@FXML
	private TableColumn<Funcionario, String> tbcDataNascimento;

	@FXML
	private TableColumn<Funcionario, String> tbcEndereco;

	@FXML
	private TableColumn<Funcionario, Integer> tbcCep;

	@FXML
	private TableColumn<Funcionario, String> tbcBairo;

	@FXML
	private TableColumn<Funcionario, String> tbcCargo;

	@FXML
	private TableColumn<Funcionario, Float> tbcSalario;

	@FXML
	private TableColumn<Funcionario, Float> tbcCargaHoraria;

	@FXML
	private Button btnVoltarMenu;

	@FXML
	private TableColumn<Funcionario, String> tbcDataAdmisao;

	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnNovo;

	@FXML
	private Button btnDeletar;

	private Funcionario funcionario;


	private boolean editando;

	private FuncionarioDAO funcionarioDao = new FuncionarioJDBC();


	public void populaFuncionario() {
		funcionario.setCodigo(Integer.valueOf(tfCodigo.getText()));
		funcionario.setNome(tfNome.getText());
		funcionario.setCpf(Integer.valueOf(tfCPF.getText()));
		funcionario.setRg(Integer.valueOf(tfRg.getText()));
		funcionario.setDtNasc(tfDataNascimento.getText());
		funcionario.setEndereco(tfEndereco.getText());
		funcionario.setCep(Integer.valueOf(tfCep.getText()));
		funcionario.setBairro(tfBairro.getText());
		funcionario.setSalario(Double.valueOf(tfSalario.getText()));
		funcionario.setCargo(tfCargo.getText());
		funcionario.setCargaHoraria(Integer.valueOf(tfCargaHoraria.getText()));
	}


	@FXML
	private void initialize() {
		tbcCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		tbcnome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tbcCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tbcRg.setCellValueFactory(new PropertyValueFactory<>("rg"));
		tbcDataNascimento.setCellValueFactory(new PropertyValueFactory<>("dataNascimento"));
		tbcEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		tbcCep.setCellValueFactory(new PropertyValueFactory<>("cep"));
		tbcBairo.setCellValueFactory(new PropertyValueFactory<>("bairro"));
		tbcCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
		tbcSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
		tbcCargaHoraria.setCellValueFactory(new PropertyValueFactory<>("cargaHoraria"));
		tbcDataAdmisao.setCellValueFactory(new PropertyValueFactory<>("dataAdmisao"));
		novoFuncionario();
	}

	@FXML
	void selecionaFuncionario(MouseEvent event) {
		if (tblFuncionario.getSelectionModel().getSelectedItem() != null) {
			funcionario = tblFuncionario.getSelectionModel().getSelectedItem();
			populaTela(funcionario);
			editando = true;
		}
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


	public void populaTela(Funcionario funcionario) {
		tfCodigo.setText(funcionario.getCodigo().toString());
		tfNome.setText(funcionario.getNome());
		tfCPF.setText(funcionario.getCpf().toString());
		tfRg.setText(funcionario.getRg().toString());
		tfDataNascimento.setText(funcionario.getDtNasc());
		tfEndereco.setText(funcionario.getEndereco());
		tfCep.setText(funcionario.getCep().toString());
		tfBairro.setText(funcionario.getBairro());
		tfCargo.setText(funcionario.getCargo());
		tfSalario.setText(funcionario.getSalario().toString());
		tfCargaHoraria.setText(funcionario.getCargaHoraria().toString());
	}

	@FXML
	void deletar(ActionEvent event) {

		if (tblFuncionario.getSelectionModel().getSelectedItem() != null) {
			funcionario = tblFuncionario.getSelectionModel().getSelectedItem();
			populaTela(funcionario);
			if (new AlertaFactory().confirmaExclusao()) {
				funcionarioDao.excluir(funcionario);
				novoFuncionario();
			}
		}
	}

	@FXML
	void novo(ActionEvent event) {
		novoFuncionario();
	}

	@FXML
	void salvar(ActionEvent event) {

		populaFuncionario();

		if (editando) {
			funcionarioDao.alterar(funcionario);
		} else {
			funcionarioDao.inserir(funcionario);
		}

		novoFuncionario();
		tblFuncionario.refresh();
	}


	void novoFuncionario() {
		tfCodigo.clear();
		tfNome.clear();
		tfCPF.clear();
		tfRg.clear();
		tfDataNascimento.clear();
		tfEndereco.clear();
		tfCep.clear();
		tfBairro.clear();
		tfCargo.clear();
		tfSalario.clear();
		tfCargaHoraria.clear();
		editando = false;
		funcionario = new Funcionario();
		tblFuncionario.setItems(FXCollections.observableArrayList(funcionarioDao.listar()));
	}
}
