package srpauv.controlador;

import DAO.IntegranteDAO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import srpauv.clases.Integrante;


public class IniciarSesionController implements Initializable {

    @FXML TextField txtUsuario;
    @FXML TextField txtPassword;
    @FXML Button btnIngresar;
    @FXML Label lblMensaje;
    
    ResourceBundle rb;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.rb = rb;
        
        txtUsuario.setText("edsonM");
        txtPassword.setText("123456");
       
        btnIngresar.setOnAction((event) -> {
            validarCampos();
        });
    }    
    
    private void validarCampos(){
        String usuario = txtUsuario.getText();
        String pass = txtPassword.getText();
        if(usuario.equals("") || pass.equals("")){
            lblMensaje.setText("Campos Vacíos");
        } else{
            Integrante integrante = new Integrante(usuario, pass); //añadir el constructor
            try {
                if(!validarUsuario(integrante)){
                    lblMensaje.setText("Contraseña Incorrecta");
                }
            } catch (SQLException ex) {
                Logger.getLogger(IniciarSesionController.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("error consulta");
            }
        }
    }
    
    private boolean validarUsuario(Integrante integrante) throws SQLException{
        Integrante integranteRecuperado = IntegranteDAO.recuperarUsuario(integrante.getUsuario());
        if(integrante.getPassword().equals(integranteRecuperado.getPassword())){
            ingresar(integranteRecuperado); //El integrante recuperado debe traer el id 
            return true;
        } else {
             return false;
        }
    }
    
    private void ingresar(Integrante integrante){
        try {
            MenuController.setUsuario(integrante);
            Parent root = FXMLLoader.load(getClass().getResource("/srpauv/FXML/Menu.fxml"), rb);
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            //stage.setTitle(rb.getString("tituloG"));
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(IniciarSesionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
