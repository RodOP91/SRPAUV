/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srpauv.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import srpauv.clases.Integrante;

/**
 * FXML Controller class
 *
 * @author edson
 */
public class MenuController implements Initializable {

    private static Integrante usuario;
    
    @FXML Label lblUsuario;
    
    @FXML Button btnRegistrarIntegrante;
    @FXML Button btnRegistrarProducto;
    @FXML Button btnRegistrarColaborador;
    @FXML Button btnValidarProductos;
    @FXML Button btnEditarProducto;
    @FXML Button btnRegistrarProyecto;
    @FXML Button btnGenerarReporte;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        if(usuario.getResponsable() == 0){
            btnRegistrarIntegrante.setVisible(false);
            btnValidarProductos.setVisible(false);
            btnGenerarReporte.setVisible(false);
        }
        
        lblUsuario.setText(usuario.getUsuario());
        
        lblUsuario.setOnMouseClicked((event) -> {
            try {
                MiPerfilController.setUsuario(usuario);
                Parent root = FXMLLoader.load(getClass().getResource("/srpauv/FXML/MiPerfil.fxml"), rb);
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setResizable(false);
                //stage.setTitle(rb.getString("tituloG"));
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btnRegistrarIntegrante.setOnAction((ActionEvent event) -> {
            try {
                RegistrarProductoController.setUsuario(usuario);
                Parent root = FXMLLoader.load(getClass().getResource("/srpauv/FXML/RegistrarMiembro.fxml"), rb);
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setResizable(false);
                //stage.setTitle(rb.getString("tituloG"));
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btnRegistrarProducto.setOnAction((ActionEvent event) -> {
            try {
                RegistrarProductoController.setUsuario(usuario);
                Parent root = FXMLLoader.load(getClass().getResource("/srpauv/FXML/RegistrarProducto.fxml"), rb);
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                //stage.setTitle(rb.getString("tituloG"));
                
                stage.setMaximized(true);
                stage.setMinWidth(1000);
                stage.setMinHeight(650);
                stage.maximizedProperty().addListener((Observable observable) -> {
                    stage.setWidth(1000);
                    stage.setHeight(650);
                });
                
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btnRegistrarColaborador.setOnAction((event) -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/srpauv/FXML/RegistrarColaborador.fxml"), rb);
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                //stage.setTitle(rb.getString("tituloG"));
                stage.setResizable(false);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btnValidarProductos.setOnAction((event) -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/srpauv/FXML/ValidarProductos.fxml"), rb);
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                //stage.setTitle(rb.getString("tituloG"));
                stage.setResizable(false);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btnEditarProducto.setOnAction((event) -> {
            try {
                EditarProductoController.setUsuario(usuario);
                Parent root = FXMLLoader.load(getClass().getResource("/srpauv/FXML/EditarProducto.fxml"), rb);
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                //stage.setTitle(rb.getString("tituloG"));
                
                stage.setMaximized(true);
                stage.setMinWidth(1000);
                stage.setMinHeight(650);
                stage.maximizedProperty().addListener((Observable observable) -> {
                    stage.setWidth(1000);
                    stage.setHeight(650);
                });
                
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btnRegistrarProyecto.setOnAction((event) -> {
            try {
                RegistrarProyectoController.setUsuario(usuario);
                Parent root = FXMLLoader.load(getClass().getResource("/srpauv/FXML/RegistrarProyecto.fxml"), rb);
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                //stage.setTitle(rb.getString("tituloG"));
                stage.setResizable(false);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btnGenerarReporte.setOnAction((event) -> {
            try {
                GenerarReporteController.setUsuario(usuario);
                Parent root = FXMLLoader.load(getClass().getResource("/srpauv/FXML/GenerarReporte.fxml"), rb);
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                //stage.setTitle(rb.getString("tituloG"));
                stage.setResizable(false);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }    
    
    public static void setUsuario(Integrante integrante){
        usuario = integrante;
    }
    
    public static Integrante getUsuario(){
        return usuario;
    }
}
