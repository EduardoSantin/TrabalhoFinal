package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import principal.dao.ManutencaoDAO;
import principal.dao.ManutencaoJDBC;
import principal.model.Manutencao;

public class ManutencaoController {

	@FXML
	private TextField tfCodigo;

	@FXML
	private TextField tfDescricao;

	@FXML
	private TextField tfTipo;

	@FXML
	private TextField tfMarca;

	@FXML
	private TextField tfAplicacao;

	@FXML
	private TableView<Manutencao> tblManutencao;

	@FXML
	private TableColumn<Manutencao, Integer> tbcCodigo;

	@FXML
	private TableColumn<Manutencao, String> tbcDescricao;

	@FXML
	private TableColumn<Manutencao, String> tbcTipo;

	@FXML
	private TableColumn<Manutencao, String> tbcMarca;

	@FXML
	private TableColumn<Manutencao, String> tbcAplicacao;

	@FXML
	private TableColumn<Manutencao, String> tbcDataCadastro;

	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnNovo;

	@FXML
	private Button btnDeletar;

	@FXML
	private DatePicker dtpDataCadastro;

	private boolean editando;

	private ManutencaoDAO manutencaoDao = new ManutencaoJDBC();

	private Manutencao manutencao;

	@FXML
	private void initialize() {
		tbcCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		tbcTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		tbcMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
		tbcAplicacao.setCellValueFactory(new PropertyValueFactory<>("aplicacao"));
		tbcDataCadastro.setCellValueFactory(new PropertyValueFactory<>("dataCadastro"));

		novoManutencao();
	}

	@FXML
	void salvar(ActionEvent event) {

		populaManutencao();

		if (editando) {
			manutencaoDao.alterar(manutencao);
		} else {
			manutencaoDao.inserir(manutencao);
		}
		novoManutencao();
		tblManutencao.refresh();
	}

	public void populaManutencao() {
		manutencao.setCodigo(Integer.valueOf(tfCodigo.getText()));
		manutencao.setDescricao(tfDescricao.getText());
		manutencao.setTipo(tfTipo.getText());
		manutencao.setMarca(tfMarca.getText());
		manutencao.setAplicacao(tfAplicacao.getText());
		manutencao.setDataCadastro(dtpDataCadastro.getPromptText());
	}

	public void populaTela(Manutencao manutencao) {
		tfCodigo.setText(manutencao.getCodigo().toString());
		tfDescricao.setText(manutencao.getDescricao());
		tfTipo.setText(manutencao.getTipo());
		tfMarca.setText(manutencao.getMarca());
		tfAplicacao.setText(manutencao.getAplicacao());
		dtpDataCadastro.setAccessibleText(manutencao.getDataCadastro());
	}

	@FXML
	void deletar(ActionEvent event) {
		manutencaoDao.excluir(manutencao);
		novoManutencao();
	}

	@FXML
	void novo(ActionEvent event) {
		novoManutencao();
	}

	@FXML
	void selecionaManutencao(MouseEvent event) {
		if (tblManutencao.getSelectionModel().getSelectedItem() != null) {
			manutencao = tblManutencao.getSelectionModel().getSelectedItem();
			populaTela(manutencao);
			editando = true;
		}
	}

	void novoManutencao() {
		tfCodigo.clear();
		tfDescricao.clear();
		tfTipo.clear();
		tfMarca.clear();
		tfAplicacao.clear();
		dtpDataCadastro.setValue(null);
	}

}
