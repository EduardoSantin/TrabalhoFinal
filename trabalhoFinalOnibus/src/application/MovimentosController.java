package application;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
    private TableView<Movimentos> tblMovimentos;

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
    private Button btnSalvar;

    @FXML
    private Button btnNovo;

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
    	tbcKmInicial.setCellValueFactory(new PropertyValueFactory<>("kmInicial"));
    	tbcKmFinal.setCellValueFactory(new PropertyValueFactory<>("kmFinal"));
    	tbcQtdPassageiros.setCellValueFactory(new PropertyValueFactory<>("qtdPassageiros"));
    	tbcPlaca.setCellValueFactory(new PropertyValueFactory<>("placaVeiculo"));
    	tbcOrigem.setCellValueFactory(new PropertyValueFactory<>("origen"));
    	tbcDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
    	tbcMotorista.setCellValueFactory(new PropertyValueFactory<>("nomeMotorista"));
    	populaCombo();
    	novoMovimento();
    }

	private void populaMoviemntos() {
		movimento.setCodigo(Integer.valueOf(tfCodigo.getText()));
		movimento.setNumeroNota(Integer.valueOf(tfNumeroNota.getText()));
		movimento.setKmInicial(Double.valueOf(tfKmInicial.getText()));
		movimento.setKmFinal(Double.valueOf(tfKmFinal.getText()));
		movimento.setQtdPassageiros(Integer.valueOf(tfQtdPassageiros.getText()));
		movimento.setOrigen(tfOrigem.getText());
		movimento.setDestino(tfDestino.getText());
		movimento.setMotorista(tfNomeMotorista.getText());
		movimento.setDtaEmissao(tfDataEmissao.getText());
	}
	
	private void populaTela(Movimentos movimento) {
		tfCodigo.setText(movimento.getCodigo().toString());
		tfNumeroNota.setText(movimento.getNumeroNota().toString());
		tfKmInicial.setText(movimento.getKmInicial().toString());
		tfKmFinal.setText(movimento.getKmFinal().toString());
		tfQtdPassageiros.setText(movimento.getQtdPassageiros().toString());
		tfOrigem.setText(movimento.getOrigen());
		tfDestino.setText(movimento.getDestino());
		tfNomeMotorista.setText(movimento.getMotorista());
		cbxPlacaVeiculo.getSelectionModel().select(movimento.getVeiculo());
		tfDataEmissao.setText(movimento.getDtaEmissao());

	}
	
	private void populaCombo(){
		cbxPlacaVeiculo.getItems().clear();
		for(Veiculo veiculo: veiculoDao.listar()){
			cbxPlacaVeiculo.getItems().add(veiculo);
		}
	}
	@FXML
    void Salvar(ActionEvent event) {
		populaMoviemntos();
    	if(editando) {
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
		   	if ( new  AlertaFactory () . confirmaExclusao ()) {
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
	    void SelecionaMovimento(MouseEvent event) {
	    	if(tblMovimentos.getSelectionModel().getSelectedItem() != null) {
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
		editando = false;
		movimento = new Movimentos();
		tblMovimentos.setItems(FXCollections.observableArrayList(movimentoDao.listar()));
	}
	

}
