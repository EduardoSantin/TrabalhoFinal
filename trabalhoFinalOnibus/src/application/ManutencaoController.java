package application;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import principal.dao.ManutencaoDAO;
import principal.dao.ManutencaoJDBC;
import principal.dao.VeiculoDAO;
import principal.dao.VeiculoJDBC;
import principal.model.Manutencao;
import principal.model.Veiculo;

public class ManutencaoController {

	@FXML
	private TextField tfCodigo;

	@FXML
	private TextField tfDescricao;

	@FXML
	private Button btnDeletar;

	@FXML
	private TableColumn<Manutencao, Integer> tbcCodigo;

	@FXML
	private TableColumn<Manutencao, String> tbcDescricao;

	@FXML
	private TableColumn<Manutencao, String> tbcTipo;
	
    @FXML
    private TableColumn<Manutencao, String> tbcPlaca;

	@FXML
	private TableColumn<Manutencao, String> tbcDataCadastro;

	@FXML
	private TableView<Manutencao> tblManutencao;

	@FXML
	private TextField tfTipo;

	@FXML
	private Button btnSalvar;

	@FXML
	private ComboBox<Veiculo> cmbPlaca;

	@FXML
	private Button btnNovo;

	@FXML
	private Button btnBuscar;

	private Manutencao manutencao;

	private boolean editando;

	@FXML
   	private Button btnVoltarMenu;
	
	private ManutencaoDAO manutencaoDao = new ManutencaoJDBC();

	private VeiculoDAO veiculoDao = new VeiculoJDBC();

	@FXML
	private void initialize() {
		tbcCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		tbcPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
		tbcTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		tbcDataCadastro.setCellValueFactory(new PropertyValueFactory<>("dataCadastro"));
		populaCombo();
		NovoManutencao();
	}

	public void populaManutencao() {
		manutencao.setCodigo(Integer.valueOf(tfCodigo.getText()));
		manutencao.setDescricao(tfDescricao.getText());
		manutencao.setTipo(tfTipo.getText());
		manutencao.setVeiculo(cmbPlaca.getValue());

	}

	public void populaTela(Manutencao manutencao) {
		tfCodigo.setText(manutencao.getCodigo().toString());
		tfDescricao.setText(manutencao.getDescricao());
		tfTipo.setText(manutencao.getTipo());
		cmbPlaca.getSelectionModel().select(manutencao.getVeiculo());
	}

	@FXML
	void selecionaManutencao(MouseEvent event) {
		if (tblManutencao.getSelectionModel().getSelectedItem() != null) {
			manutencao = tblManutencao.getSelectionModel().getSelectedItem();
			populaTela(manutencao);
			populaManutencao();
			editando = true;
		}
	}

	private void populaCombo() {
		for (Veiculo veiculo : veiculoDao.listar()) {
			cmbPlaca.getItems().add(veiculo);
		}
	}

	@FXML
	void salvar(ActionEvent event) {
		populaManutencao();

		if (editando) {
			manutencaoDao.alterar(manutencao);
		} else {
			manutencaoDao.inserir(manutencao);
		}
		NovoManutencao();
		tblManutencao.refresh();

	}

	@FXML
	void novo(ActionEvent event) {
		NovoManutencao();
	}

	@FXML
	void deletar(ActionEvent event) {
		manutencaoDao.excluir(manutencao);
		NovoManutencao();
	}

	void NovoManutencao() {
		tfCodigo.clear();
		tfDescricao.clear();
		tfTipo.clear();
		manutencao = new Manutencao();
		editando = false;
		cmbPlaca.getSelectionModel().clearSelection();
		tblManutencao.setItems(FXCollections.observableArrayList(manutencaoDao.listar()));
	}

	@FXML
	void Buscar(ActionEvent event) {
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
