package application;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
    private TextField tfCategoria;

    @FXML
    private TextField tfCombustivel;

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
    private TableColumn<Veiculo, String> tbcCategoria;

    @FXML
    private TableColumn<Veiculo, String> tbcCombustivel;

    @FXML
    private TableColumn<Veiculo, String> tbcDataCadastrada;

    @FXML
    private Button btSalvar;

    @FXML
    private Button btNovo;

    @FXML
    private Button btDeletar;

    @FXML
    private DatePicker dtpDataCadastro;
    
   private Veiculo veiculo;
   
   private boolean editando;

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
	   tbcCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
	   tbcCombustivel.setCellValueFactory(new PropertyValueFactory<>("combustivel"));
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
	   veiculo.setCategoria(tfCategoria.getText());
	   veiculo.setCombustivel(tfCombustivel.getText());
	   veiculo.setDataCadastro(dtpDataCadastro.getAccessibleText());
	   
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
	   tfCategoria.setText(veiculo.getCategoria());
	   tfCombustivel.setText(veiculo.getCombustivel());
	   dtpDataCadastro.setAccessibleText(veiculo.getDataCadastro());
   }
   
    @FXML
    void deletar(ActionEvent event) {
    	veiculodao.excluir(veiculo);
    	novoVeiculo();
    }

    @FXML
    void novo(ActionEvent event) {
    	novoVeiculo();
    }

    @FXML
    void salvar(ActionEvent event) {
    	
    	populaVeiculo();
    	if(editando) {
    		veiculodao.alterar(veiculo);
    	} else {
			veiculodao.inserir(veiculo);
		}
    	novoVeiculo();
    	tblVeiculo.refresh();
    }
    @FXML
    void selecionaVeiculo(MouseEvent event) {
    	if(tblVeiculo.getSelectionModel().getSelectedItem() != null) {
    		veiculo = tblVeiculo.getSelectionModel().getSelectedItem();
    		populaTela(veiculo);
    		editando = true;
    	}
    }
    
    void novoVeiculo() {
    	tfCodigo.clear();
    	tfRenavan.clear();
    	tfMarca.clear();
    	tfModelo.clear();
    	tfPlaca.clear();
    	tfMotor.clear();
    	tfChassi.clear();
    	tfCategoria.clear();
    	tfCombustivel.clear();
    	dtpDataCadastro.setValue(null);
    	editando = false;
    	tblVeiculo.setItems(FXCollections.observableArrayList(veiculodao.listar()));
    }

}
