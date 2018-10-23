package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import principal.dao.UsuarioDAO;
import principal.dao.UsuarioJDBC;
import principal.model.Usuario;

public class UsuarioController {

    @FXML
    private Button btnSalvar;

    @FXML
    private TextField tfCodigo;

    @FXML
    private TextField tfLogin;

    @FXML
    private TextField tfSenha;
    
    private Usuario usuario;
    
    private UsuarioDAO usuarioDao = new UsuarioJDBC();

    @FXML
    void Salvar(ActionEvent event) {
    	usuarioDao.inserir(usuario);
    	novoUsuario();
    }
    
    public void populaUsuario() {
    	usuario.setCodigo(Integer.valueOf(tfCodigo.getText()));
    	usuario.setLogin(tfLogin.getText());
    	usuario.setSenha(tfSenha.getText());
    }
 
	void novoUsuario() {
	tfCodigo.clear();
	tfLogin.clear();
	tfSenha.clear();
}

}
