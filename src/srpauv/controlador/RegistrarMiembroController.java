/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srpauv.controlador;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;
import srpauv.clases.Integrante;

/**
 * FXML Controller class
 *
 * @author edson
 */
public class RegistrarMiembroController implements Initializable {

    @FXML TextField txtNombre;
    @FXML TextField txtApellidoP;
    @FXML TextField txtApellidoM;
    @FXML TextField txtUsuario;
    @FXML PasswordField txtPass;
    
    @FXML Button btnGuardar;
    @FXML Button btnCancelar;
    
    @FXML Label lblMensaje;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnGuardar.setOnAction((ActionEvent event) -> {
            try {
                validarCampos();
            } catch (SQLException ex) {
                Logger.getLogger(RegistrarMiembroController.class.getName()).log(Level.SEVERE, null, ex);
                
                lblMensaje.setTextFill(Paint.valueOf("red"));
                lblMensaje.setText("Error de conexion con la bd");
            }
        });
        
        btnCancelar.setOnAction((ActionEvent event) -> {
            
        });
    }    
    
    
    private void validarCampos() throws SQLException{        
        String nombre = txtNombre.getText();
        String apellidoP = txtApellidoP.getText();
        String apellidoM = txtApellidoM.getText();
        String usuario = txtUsuario.getText();
        String pass = txtPass.getText();
        if(nombre.equals("") || apellidoP.equals("") || usuario.equals("") || 
                pass.equals("")){
            lblMensaje.setTextFill(Paint.valueOf("red"));
            lblMensaje.setText("Completa los campos vacíos");
        }else{
            boolean flag;
            if(apellidoM.equals("")){
                Integrante integrante = new Integrante(nombre, apellidoP, usuario, pass);
                flag = integrante.registrarIntegrante();
            }else{
                Integrante integrante = new Integrante(nombre, apellidoP, apellidoM, usuario, pass);
                flag = integrante.registrarIntegrante();
            }
                    
            if(flag == true){
                lblMensaje.setTextFill(Paint.valueOf("green"));
                lblMensaje.setText("Integrante Registrado");
                txtNombre.setText("");
                txtApellidoP.setText("");
                txtApellidoM.setText("");
                txtUsuario.setText("");
                txtPass.setText("");
            }else{
                System.err.println("Error consulta");
                //lblMensaje.setText("Error de conexion con la bd");
            }
        }
    }
}
