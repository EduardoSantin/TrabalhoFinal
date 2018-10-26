package application;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import principal.dao.MovimentosDAO;
import principal.dao.MovimentosJDBC;
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
    private DatePicker dtpDataEmissao;

    @FXML
    private ComboBox<Veiculo> cbxPlacaVeiculo;

    @FXML
    private TextField tfKmFinal;

    @FXML
    private TextField tfDestino;
    
    private Movimentos movimento;
    
    private boolean editando;
    
    private MovimentosDAO movimentoDao = new MovimentosJDBC();

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

	
	
	private void populaMoviemntos() {
		movimento.setCodigo(Integer.valueOf(tfCodigo.getText()));
		movimento.setNumeroNota(Integer.valueOf(tfNumeroNota.getText()));
		movimento.setKmInicial(Double.valueOf(tfKmInicial.getText()));
		movimento.setKmFinal(Double.valueOf(tfKmFinal.getText()));
		movimento.setQtdPassageiros(Integer.valueOf(tfQtdPassageiros.getText()));
		movimento.setOrigem(tfOrigem.getText());
		movimento.setDestino(tfDestino.getText());
		movimento.setMotorista(tfNomeMotorista.getText());
	}
	private void populaTela(Movimentos movimento) {
		tfCodigo.setText(movimento.getCodigo().toString());
		tfNumeroNota.setText(movimento.getNumeroNota().toString());
		tfKmInicial.setText(movimento.getKmInicial().toString());
		tfKmFinal.setText(movimento.getKmFinal().toString());
		tfQtdPassageiros.setText(movimento.getQtdPassageiros().toString());
		tfOrigem.setText(movimento.getOrigem());
		tfDestino.setText(movimento.getDestino());
		tfNomeMotorista.setText(movimento.getMotorista());
		cbxPlacaVeiculo.getSelectionModel().select(movimento.getVeiculo());
		//falta fazer o pupula do data emissao

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
		editando = false;
		movimento = new Movimentos();
		tblMovimentos.setItems(FXCollections.observableArrayList(movimentoDao.listar()));
	}
	

}
