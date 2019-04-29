/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srpauv.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import srpauv.clases.Colaborador;

/**
 * FXML Controller class
 *
 * @author edson
 */
public class RegistrarColaboradorController implements Initializable {

    
    @FXML TextField txtNombre;
    @FXML TextField txtApellidoP;
    @FXML TextField txtApellidoM;
    @FXML TextField txtInstitucion;
    @FXML TextField txtCuerpoA;
    
    @FXML Label lblMensaje;
    
    @FXML Button btnGuardar;
    @FXML Button btnCancelar;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnGuardar.setOnAction((event) -> {
           validarCampos();
        });
        
        btnCancelar.setOnAction((event) -> {
        });
    }    
    
    
    private void validarCampos(){
        String nombre = txtNombre.getText();
        String apellidoP =  txtApellidoP.getText();
        String apellidoM =  txtApellidoM.getText();
        String institucion = txtInstitucion.getText();
        String cuerpoA = txtCuerpoA.getText();
        if(nombre.equals("") || apellidoP.equals("") || apellidoM.equals("") ||
                institucion.equals("") || cuerpoA.equals("")){
            
        }else{
            Colaborador colaborador = new Colaborador();
            colaborador.setNombre(nombre);
            colaborador.setApellidoM(apellidoM);
            colaborador.setApellidoP(apellidoP);
            colaborador.setInstitucion(institucion);
            colaborador.setCuerpoAcademico(cuerpoA);
            
            boolean flag = colaborador.registrarColaborador();
            
            if(flag == true){
                lblMensaje.setText("Integrante Registrado");
            }else{
                lblMensaje.setText("Error de conexion con la bd");
            }
        }
    }
}
