package application;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    	
    	
    	if(editando) {
    		veiculodao.alterar(veiculo);
    	} else {
			veiculodao.inserir(veiculo);
		}
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
    	tfCategoria.clear();
    	tfCombustivel.clear();
    	editando = false;
    	tblVeiculo.setItems(FXCollections.observableArrayList(veiculodao.listar()));
    }

}
