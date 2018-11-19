package application;

import java.net.URL;

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
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import principal.conexao.ConexaoUtil;
import principal.dao.MovimentosDAO;
import principal.dao.MovimentosJDBC;
import principal.dao.VeiculoDAO;
import principal.dao.VeiculoJDBC;
import principal.model.Movimentos;
import principal.model.Veiculo;

public class MovimentosController {

	@FXML
	private TextField tfCodigo;

	@FXML
	private TextField tfNumeroNota;

	@FXML
	private TextField tfKmInicial;

	@FXML
	private TextField tfQtdPassageiros;

	@FXML
	private TextField tfOrigem;

	@FXML
	private TextField tfNomeMotorista;

	@FXML
	private TableColumn<Movimentos, Integer> tbcCodigo;

	@FXML
	private TableColumn<Movimentos, Integer> tbcNota;

	@FXML
	private TableColumn<Movimentos, String> tbcDataEmissao;

	@FXML
	private TableColumn<Movimentos, String> tbcPlaca;

	@FXML
	private TableColumn<Movimentos, Double> tbcKmInicial;

	@FXML
	private TableColumn<Movimentos, Double> tbcKmFinal;

	@FXML
	private TableColumn<Movimentos, Integer> tbcQtdPassageiros;

	@FXML
	private TableColumn<Movimentos, String> tbcOrigem;

	@FXML
	private TableColumn<Movimentos, String> tbcDestino;

	@FXML
	private TableColumn<Movimentos, String> tbcMotorista;

	@FXML
	private TableColumn<Movimentos, String> tbckmTotal;
	
	@FXML
	private TableView<Movimentos> tblMovimentos;

	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnNovo;

	@FXML
	private Button btnVoltarMenu;

	@FXML
	private Button btnDeletar;

	@FXML
	private TextField tfDataEmissao;

	@FXML
	private ComboBox<Veiculo> cbxPlacaVeiculo;

	@FXML
	private TextField tfKmFinal;

	@FXML
	private TextField tfDestino;

	private Movimentos movimento;

	private boolean editando;

	private MovimentosDAO movimentoDao = new MovimentosJDBC();

	private VeiculoDAO veiculoDao = new VeiculoJDBC();

	@FXML
	private void initialize() {
		tbcCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		tbcNota.setCellValueFactory(new PropertyValueFactory<>("numeroNota"));
		tbcDataEmissao.setCellValueFactory(new PropertyValueFactory<>("dataEmisao"));
		tbcPlaca.setCellValueFactory(new PropertyValueFactory<>("placaVeiculo"));
		tbcKmInicial.setCellValueFactory(new PropertyValueFactory<>("kmInicial"));
		tbcKmFinal.setCellValueFactory(new PropertyValueFactory<>("kmFinal"));
		tbcQtdPassageiros.setCellValueFactory(new PropertyValueFactory<>("qtdPassageiros"));
		tbcOrigem.setCellValueFactory(new PropertyValueFactory<>("origen"));
		tbcDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
		tbcMotorista.setCellValueFactory(new PropertyValueFactory<>("nomeMotorista"));
		tbckmTotal.setCellValueFactory(new PropertyValueFactory<>("kmTotal"));
		populaCombo();
		novoMovimento();
	}

	private void populaMoviemntos() {
		movimento.setCodigo(Integer.valueOf(tfCodigo.getText()));
		movimento.setNumeroNota(Integer.valueOf(tfNumeroNota.getText()));
		movimento.setDtaEmissao(tfDataEmissao.getText());
		movimento.setVeiculo(cbxPlacaVeiculo.getValue());
		movimento.setKmInicial(Double.valueOf(tfKmInicial.getText()));
		movimento.setKmFinal(Double.valueOf(tfKmFinal.getText()));
		movimento.setQtdPassageiros(Integer.valueOf(tfQtdPassageiros.getText()));
		movimento.setOrigen(tfOrigem.getText());
		movimento.setDestino(tfDestino.getText());
		movimento.setMotorista(tfNomeMotorista.getText());
	}

	private void populaTela(Movimentos movimento) {
		tfCodigo.setText(movimento.getCodigo().toString());
		tfNumeroNota.setText(movimento.getNumeroNota().toString());
		tfDataEmissao.setText(movimento.getDtaEmissao());
		cbxPlacaVeiculo.getSelectionModel().select(movimento.getVeiculo());
		tfKmInicial.setText(movimento.getKmInicial().toString());
		tfKmFinal.setText(movimento.getKmFinal().toString());
		tfQtdPassageiros.setText(movimento.getQtdPassageiros().toString());
		tfOrigem.setText(movimento.getOrigen());
		tfDestino.setText(movimento.getDestino());
		tfNomeMotorista.setText(movimento.getMotorista());

	}

	private void populaCombo() {
		// cbxPlacaVeiculo.getItems().clear();
		for (Veiculo veiculo : veiculoDao.listar()) {
			cbxPlacaVeiculo.getItems().add(veiculo);
		}
	}

	@FXML
	void Salvar(ActionEvent event) {
		populaMoviemntos();
		if (editando) {
			movimentoDao.alterar(movimento);
		} else {
			movimentoDao.inserir(movimento);
		}
		novoMovimento();
		tblMovimentos.refresh();

	}

	@FXML
	void Deletar(ActionEvent event) {
		if(tblMovimentos.getSelectionModel().getSelectedItem() != null) {
			movimento = tblMovimentos.getSelectionModel().getSelectedItem();
			populaTela(movimento);
			if(new AlertaFactory().confirmaExclusao()) {
				movimentoDao.excluir(movimento);
				novoMovimento();
				
			}
		}
	}

	@FXML
	void Novo(ActionEvent event) {
		novoMovimento();

	}

	@FXML
	void selecionaMovimento(MouseEvent event) {
		if (tblMovimentos.getSelectionModel().getSelectedItem() != null) {
			movimento = tblMovimentos.getSelectionModel().getSelectedItem();
			populaTela(movimento);
			editando = true;
		}
	}

	private void novoMovimento() {
		tfCodigo.clear();
		tfNumeroNota.clear();
		tfKmInicial.clear();
		tfKmFinal.clear();
		tfQtdPassageiros.clear();
		tfOrigem.clear();
		tfDestino.clear();
		tfNomeMotorista.clear();
		tfDataEmissao.clear();
		movimento = new Movimentos();
		editando = false;
		cbxPlacaVeiculo.getSelectionModel().clearSelection();
		tblMovimentos.setItems(FXCollections.observableArrayList(movimentoDao.listar()));
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

	@FXML
	void exibirRelatorio(ActionEvent event) {
		URL url = getClass().getResource("/relatorios/viagens.jasper");
		try {
			JasperPrint jasperPrint = JasperFillManager.fillReport(url.getPath(), null, ConexaoUtil.getConn());
			JasperViewer.viewReport(jasperPrint);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void atualizar(ActionEvent event) {
		movimentoDao.calcula(movimento);
		novoMovimento();
		tblMovimentos.refresh();
	}
}
