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
import principal.dao.VeiculoDAO;
import principal.dao.VeiculoJDBC;
import principal.model.Veiculo;

public class VeiculoController {

	@FXML
	private TextField tfCodigo;

	@FXML
	private TextField tfRenavan;

	@FXML
	private TextField tfMarca;

	@FXML
	private TextField tfModelo;

	@FXML
	private TextField tfPlaca;

	@FXML
	private TextField tfMotor;

	@FXML
	private TextField tfChassi;

	@FXML
	private TextField tfDataCadastro;

	@FXML
	private TableView<Veiculo> tblVeiculo;

	@FXML
	private TableColumn<Veiculo, Integer> tbcCodigo;

	@FXML
	private TableColumn<Veiculo, Integer> tbcRenavan;

	@FXML
	private TableColumn<Veiculo, String> tbcMarca;

	@FXML
	private TableColumn<Veiculo, String> tbcModelo;

	@FXML
	private TableColumn<Veiculo, String> tbcPlaca;

	@FXML
	private TableColumn<Veiculo, Integer> tbcMotor;

	@FXML
	private TableColumn<Veiculo, Integer> tbcChassi;

	@FXML
	private TableColumn<Veiculo, String> tbcDataCadastrada;

	@FXML
	private Button btSalvar;

	@FXML
	private Button btnVoltarMenu;

	@FXML
	private Button btDeletar;

	private Veiculo veiculo;

	private VeiculoDAO veiculodao = new VeiculoJDBC();

	@FXML
	private void initialize() {
		tbcCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		tbcRenavan.setCellValueFactory(new PropertyValueFactory<>("renavan"));
		tbcMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
		tbcModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
		tbcPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
		tbcMotor.setCellValueFactory(new PropertyValueFactory<>("motor"));
		tbcChassi.setCellValueFactory(new PropertyValueFactory<>("chassi"));
		tbcDataCadastrada.setCellValueFactory(new PropertyValueFactory<>("dataCadastro"));

		novoVeiculo();
	}

	public void populaVeiculo() {
		veiculo = new Veiculo();
		veiculo.setCodigo(Integer.valueOf(tfCodigo.getText()));
		veiculo.setRenavan(Integer.valueOf(tfRenavan.getText()));
		veiculo.setMarca(tfMarca.getText());
		veiculo.setModelo(tfModelo.getText());
		veiculo.setPlaca(tfPlaca.getText());
		veiculo.setMotor(tfMotor.getText());
		veiculo.setChassi(Integer.valueOf(tfChassi.getText()));

		novoVeiculo();
	}

	public void populaTela(Veiculo veiculo) {
		tfCodigo.setText(veiculo.getCodigo().toString());
		tfRenavan.setText(veiculo.getRenavan().toString());
		tfMarca.setText(veiculo.getMarca());
		tfModelo.setText(veiculo.getModelo());
		tfPlaca.setText(veiculo.getPlaca());
		tfMotor.setText(veiculo.getMotor());
		tfChassi.setText(veiculo.getChassi().toString());
	}

	@FXML
	void deletar(ActionEvent event) {
		if(tblVeiculo.getSelectionModel().getSelectedItem() != null) {
			veiculo = tblVeiculo.getSelectionModel().getSelectedItem();
			populaTela(veiculo);
			if(new AlertaFactory().confirmaExclusao()) {
				veiculodao.excluir(veiculo);
				novoVeiculo();				
			}
		}
	}

	@FXML
	void novo(ActionEvent event) {
		novoVeiculo();
	}

	@FXML
	void selecionaVeiculo(MouseEvent event) {
		if (tblVeiculo.getSelectionModel().getSelectedItem() != null) {
			veiculo = tblVeiculo.getSelectionModel().getSelectedItem();
			populaTela(veiculo);
		}
	}

	@FXML
	void salvar(ActionEvent event) {
		populaVeiculo();
		veiculodao.inserir(veiculo);
		novoVeiculo();
		tblVeiculo.refresh();
	}

	void novoVeiculo() {
		tfCodigo.clear();
		tfRenavan.clear();
		tfMarca.clear();
		tfModelo.clear();
		tfPlaca.clear();
		tfMotor.clear();
		tfChassi.clear();
		tblVeiculo.setItems(FXCollections.observableArrayList(veiculodao.listar()));
	}

	@Override
	public String toString() {
		return " tfPlaca ";
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
		URL url = getClass().getResource("/relatorios/Veiculos.jasper");
		try {
			JasperPrint jasperPrint = JasperFillManager
					 .fillReport(
							 url.getPath(),
							 null,
							 ConexaoUtil.getConn());
			JasperViewer.viewReport(jasperPrint);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

}
