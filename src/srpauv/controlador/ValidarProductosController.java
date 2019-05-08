/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srpauv.controlador;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;
import srpauv.clases.Producto;

/**
 * FXML Controller class
 *
 * @author edson
 */
public class ValidarProductosController implements Initializable {

    @FXML ListView lstProductosCA;
    @FXML TextField txtTitulo;
    @FXML TextField txtLGAC;
    @FXML TextField txtIntegrante;
    
    @FXML Button btnValidar;
    
    @FXML Label lblMensaje;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            recuperarProductosCA();
        } catch (SQLException ex) {
            Logger.getLogger(ValidarProductosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        lstProductosCA.setOnMouseClicked((event) -> {
            mostrarDetalleProducto();
            if(lstProductosCA.getSelectionModel().getSelectedIndex() > -1){
               btnValidar.setDisable(false);
            }
        });
        
        btnValidar.setOnAction((event) -> {
            validarProducto();
        });
    }    
    
    private void validarProducto(){
        Producto prod = (Producto) lstProductosCA.getSelectionModel().getSelectedItem();
            boolean flag = DAO.ProductosDAO.validarCA(prod.getIdProducto(), prod.getTipoProducto());
            if(flag == true){
                lblMensaje.setText("Producto Validado");
                lblMensaje.setTextFill(Paint.valueOf("green"));
            } else {
                lblMensaje.setText("Error de conexión con la base de datos");
                lblMensaje.setTextFill(Paint.valueOf("red"));
            }
    }
    
    private void recuperarProductosCA() throws SQLException{
        List<Producto> lista = DAO.ProductosDAO.recuperarTodos();
        for(int i = 0; i < lista.size(); i++){
            lstProductosCA.getItems().add(lista.get(i));
        }
    }
    private void mostrarDetalleProducto(){
        Producto prod = (Producto) lstProductosCA.getSelectionModel().getSelectedItem();
            txtTitulo.setText(prod.getTitulo());
            txtLGAC.setText(prod.getLgac());
            txtIntegrante.setText(prod.getIntegranteR().toString());
    }
}
