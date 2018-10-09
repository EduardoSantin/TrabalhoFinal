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
    private TextField tfCtps;

    @FXML
    private TextField tfEndereco;

    @FXML
    private TextField tfCep;

    @FXML
    private TextField tfBairro;

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
    private TableColumn<Funcionario, Integer> tbcCtps;

    @FXML
    private TableColumn<Funcionario, String> tbcDataNascimento;

    @FXML
    private TableColumn<Funcionario, String> tbcEndereco;

    @FXML
    private TableColumn<Funcionario, Integer> tbcCep;

    @FXML
    private TableColumn<Funcionario, String> tbcBairo;

    @FXML
    private TableColumn<Funcionario, Float> tbcSalario;

    @FXML
    private TableColumn<Funcionario, String> tbcCargo;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnNovo;

    @FXML
    private Button btnDeletar;

    @FXML
    private TextField tfCargo;

    @FXML
    private TextField tfSalario;

    @FXML
    private TextField tfCargaHoraria;

    @FXML
    private DatePicker dpDataAdmissao;

    @FXML
    private DatePicker dpDataNascimento;

    private Funcionario funcionario;
    
    private boolean editando;
    
    private FuncionarioDAO funcionarioDao = new FuncionarioJDBC();
  
    @FXML
    private void initialize() {
    	tbcCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
    	tbcnome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	tbcCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
    	tbcRg.setCellValueFactory(new PropertyValueFactory<>("rg"));
    	tbcCtps.setCellValueFactory(new PropertyValueFactory<>("ctps"));
    	tbcDataNascimento.setCellValueFactory(new PropertyValueFactory<>("dtnasc"));
    	tbcEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
    	tbcCep.setCellValueFactory(new PropertyValueFactory<>("cep"));
    	tbcBairo.setCellValueFactory(new PropertyValueFactory<>("bairro"));
    	tbcSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
    	tbcCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
    	
    	novoFuncionario();
    }
    
    public void populaFuncionario() {
    	funcionario = new Funcionario();
    	funcionario.setCodigo(Integer.valueOf(tfCodigo.getText()));
    	funcionario.setNome(tfNome.getText());
    	funcionario.setCpf(Integer.valueOf(tfCPF.getText()));
    	funcionario.setRg(Integer.valueOf(tfRg.getText()));
    	funcionario.setClps(Integer.valueOf(tfCtps.getText()));
    	funcionario.setEndereco(tbcEndereco.getText());
    	funcionario.setCep(Integer.valueOf(tfCep.getText()));
    	funcionario.setBairro(tfBairro.getText());
    	funcionario.setSalario(Float.valueOf(tfSalario.getText()));
    	funcionario.setCargo(tfCargo.getText());
    	
    	novoFuncionario();
    }
    
    public void populaTela(Funcionario funcionario) {
    	tfCodigo.setText(funcionario.getCodigo().toString());
    	tfNome.setText(funcionario.getNome());
    	tfCPF.setText(funcionario.getCpf().toString());
    	tfRg.setText(funcionario.getRg().toString());
    	tfCtps.setText(funcionario.getClps().toString());
    	tfEndereco.setText(funcionario.getEndereco());
    	tfCep.setText(funcionario.getCep().toString());
    	tfBairro.setText(funcionario.getBairro());
    	//tfSalario.setText(funcionario.getSalario());
    	tfCargo.setText(funcionario.getCargo());
    }
    
    @FXML
    void deletar(ActionEvent event) {
    	funcionarioDao.excluir(funcionario);
    	novoFuncionario();
    }

    @FXML
    void novo(ActionEvent event) {
    	novoFuncionario();
    }

    @FXML
    void salvar(ActionEvent event) {
    	populaFuncionario();
    	if(editando) {
    		funcionarioDao.alterar(funcionario);
    	} else {
    		funcionarioDao.inserir(funcionario);
    	}
    	novoFuncionario();
    	tblFuncionario.refresh();
    }

    @FXML
    void selecionaFuncionario(MouseEvent event) {
    	if(tblFuncionario.getSelectionModel().getSelectedItem() != null) {
    		funcionario = tblFuncionario.getSelectionModel().getSelectedItem();
    		populaTela(funcionario);
    		editando = true;
    	}
    }
    
    void novoFuncionario() {
    	tfCodigo.clear();
    	tfNome.clear();
    	tfCPF.clear();
    	tfRg.clear();
    	tfCtps.clear();
    	dpDataNascimento.setValue(null);
    	tfEndereco.clear();
    	tfBairro.clear();
    	tfCep.clear();
    	tfCargo.clear();
    	tfSalario.clear();
    	dpDataAdmissao.setValue(null);
    	tfCargaHoraria.clear();
    	editando = false;
    	tblFuncionario.setItems(FXCollections.observableArrayList(funcionarioDao.listar()));
    }
}
