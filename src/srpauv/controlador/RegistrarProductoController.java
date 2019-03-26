/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srpauv.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import srpauv.clases.Tesis;

/**
 * FXML Controller class
 *
 * @author edson
 */
public class RegistrarProductoController implements Initializable {
    
    @FXML Button btnPollo;
    
    private int flagProducto = 0;
    
    //BOTONES ACCION------------------------------------------------------------
    @FXML Button btnCancelar;
    @FXML Button btnGuardar;
    @FXML Button btnAsociarProyecto;
    @FXML Button btnAgregarColaborador;
    //--------------------------------------------------------------------------

    //PANELES PRODUCTOS---------------------------------------------------------
    @FXML AnchorPane apnTesis;
    @FXML AnchorPane apnArticuloIndexado;
    @FXML AnchorPane apnArticuloArbitrado;
    @FXML AnchorPane apnArticulo;
    @FXML AnchorPane apnCapituloLibro;
    @FXML AnchorPane apnLibro;
    @FXML AnchorPane apnProduccionInnovadora;
    @FXML AnchorPane apnMemoriaExtenso;
    @FXML AnchorPane apnPrototipo;
    //--------------------------------------------------------------------------
    
    //BOTONES PRODUCTOS---------------------------------------------------------
    @FXML ToggleButton btnTesis;
    @FXML ToggleButton btnArticuloIndexado;
    @FXML ToggleButton btnArticuloArbitrado;
    @FXML ToggleButton btnArticulo;
    @FXML ToggleButton btnCapituloLibro;
    @FXML ToggleButton btnLibro;
    @FXML ToggleButton btnProduccionInnovadora;
    @FXML ToggleButton btnMemoriaExtenso;
    @FXML ToggleButton btnPrototipo;
    //--------------------------------------------------------------------------
    
//CAMPOS DE PRODUCTOS-------------------------------------------------------------------------
    //TESIS---------------------------------------------------------------------
    @FXML TextField txtTituloTesis;
    @FXML TextField txtGradoTesis;
    @FXML TextField txtNoAlumnosTesis;
    @FXML DatePicker dtpFechaInicioTesis;
    @FXML DatePicker dtpFechaFinTesis;
    @FXML ComboBox  cbxLGACtesis;
    @FXML CheckBox chkCAtesis;
    //--------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnTesis.setOnAction((ActionEvent event) -> {
            btnArticuloIndexado.setSelected(false);
            btnArticuloArbitrado.setSelected(false);
            btnArticulo.setSelected(false);
            btnCapituloLibro.setSelected(false);
            btnLibro.setSelected(false);
            btnProduccionInnovadora.setSelected(false);
            btnMemoriaExtenso.setSelected(false);
            btnPrototipo.setSelected(false);
            MostrarProductos();
            flagProducto = 1;
        });
        
        btnArticuloIndexado.setOnAction((ActionEvent event) -> {
            btnTesis.setSelected(false);
            btnArticuloArbitrado.setSelected(false);
            btnArticulo.setSelected(false);
            btnCapituloLibro.setSelected(false);
            btnLibro.setSelected(false);
            btnProduccionInnovadora.setSelected(false);
            btnMemoriaExtenso.setSelected(false);
            btnPrototipo.setSelected(false);
            MostrarProductos();
            flagProducto = 2;
        });
        
        btnArticuloArbitrado.setOnAction((ActionEvent event) -> {
            btnTesis.setSelected(false);
            btnArticuloIndexado.setSelected(false);
            btnArticulo.setSelected(false);
            btnCapituloLibro.setSelected(false);
            btnLibro.setSelected(false);
            btnProduccionInnovadora.setSelected(false);
            btnMemoriaExtenso.setSelected(false);
            btnPrototipo.setSelected(false);
            MostrarProductos();
            flagProducto = 3;
        });
        
        btnArticulo.setOnAction((ActionEvent event) -> {
            btnTesis.setSelected(false);
            btnArticuloIndexado.setSelected(false);
            btnArticuloArbitrado.setSelected(false);
            btnCapituloLibro.setSelected(false);
            btnLibro.setSelected(false);
            btnProduccionInnovadora.setSelected(false);
            btnMemoriaExtenso.setSelected(false);
            btnPrototipo.setSelected(false);
            MostrarProductos();
            flagProducto = 4;
        });
        
        btnCapituloLibro.setOnAction((ActionEvent event) -> {
            btnTesis.setSelected(false);
            btnArticuloIndexado.setSelected(false);
            btnArticuloArbitrado.setSelected(false);
            btnArticulo.setSelected(false);
            btnLibro.setSelected(false);
            btnProduccionInnovadora.setSelected(false);
            btnMemoriaExtenso.setSelected(false);
            btnPrototipo.setSelected(false);
            MostrarProductos();
            flagProducto = 5;
        });
        
        btnLibro.setOnAction((ActionEvent event) -> {
            btnTesis.setSelected(false);
            btnArticuloIndexado.setSelected(false);
            btnArticuloArbitrado.setSelected(false);
            btnArticulo.setSelected(false);
            btnCapituloLibro.setSelected(false);
            btnProduccionInnovadora.setSelected(false);
            btnMemoriaExtenso.setSelected(false);
            btnPrototipo.setSelected(false);
            MostrarProductos();
            flagProducto = 6;
        });
        
        btnProduccionInnovadora.setOnAction((ActionEvent event) -> {
            btnTesis.setSelected(false);
            btnArticuloIndexado.setSelected(false);
            btnArticuloArbitrado.setSelected(false);
            btnArticulo.setSelected(false);
            btnCapituloLibro.setSelected(false);
            btnLibro.setSelected(false);
            btnMemoriaExtenso.setSelected(false);
            btnPrototipo.setSelected(false);
            MostrarProductos();
            flagProducto = 7;
        });
        
        btnMemoriaExtenso.setOnAction((ActionEvent event) -> {
            btnTesis.setSelected(false);
            btnArticuloIndexado.setSelected(false);
            btnArticuloArbitrado.setSelected(false);
            btnArticulo.setSelected(false);
            btnCapituloLibro.setSelected(false);
            btnLibro.setSelected(false);
            btnProduccionInnovadora.setSelected(false);
            btnPrototipo.setSelected(false);
            MostrarProductos();
            flagProducto = 8;
        });
        
        btnPrototipo.setOnAction((ActionEvent event) -> {
            btnTesis.setSelected(false);
            btnArticuloIndexado.setSelected(false);
            btnArticuloArbitrado.setSelected(false);
            btnArticulo.setSelected(false);
            btnCapituloLibro.setSelected(false);
            btnLibro.setSelected(false);
            btnProduccionInnovadora.setSelected(false);
            btnMemoriaExtenso.setSelected(false);
            MostrarProductos();
            flagProducto = 9; 
        });
        
        btnGuardar.setOnAction((ActionEvent event) -> {
            if(flagProducto == 1){
                guardarTesis();
            }
            if(flagProducto == 2){
                
            }
            if(flagProducto == 3){
                
            }
            if(flagProducto == 4){
                
            }
            if(flagProducto == 5){
                
            }
            if(flagProducto == 6){
                
            }
            if(flagProducto == 7){
                
            }
            if(flagProducto == 8){
                
            }
            if(flagProducto == 9){
                
            }
        });
    }
    
    
    private void MostrarProductos(){
        boolean flag = true;
        if(btnTesis.isSelected()){
            apnTesis.setVisible(true);
            flag = false;
        }else{
            apnTesis.setVisible(false);
        }
        if(btnArticuloIndexado.isSelected()){
            apnArticuloIndexado.setVisible(true);
            flag = false;
        }else{
            apnArticuloIndexado.setVisible(false);
        }
        if(btnArticuloArbitrado.isSelected()){
            apnArticuloArbitrado.setVisible(true);
            flag = false;
        }else{
            apnArticuloArbitrado.setVisible(false);
        }
        if(btnArticulo.isSelected()){
            apnArticulo.setVisible(true);
            flag = false;
        }else{
            apnArticulo.setVisible(false);
        }
        if(btnCapituloLibro.isSelected()){
            apnCapituloLibro.setVisible(true);
            flag = false;
        }else{
            apnCapituloLibro.setVisible(false);
        }
        if(btnLibro.isSelected()){
            apnLibro.setVisible(true);
            flag = false;
        }else{
            apnLibro.setVisible(false);
        }
        if(btnProduccionInnovadora.isSelected()){
            apnProduccionInnovadora.setVisible(true);
            flag = false;
        }else{
            apnProduccionInnovadora.setVisible(false);
        }
        if(btnMemoriaExtenso.isSelected()){
            apnMemoriaExtenso.setVisible(true);
            flag = false;
        }else{
            apnMemoriaExtenso.setVisible(false);
        }
        if(btnPrototipo.isSelected()){
            apnPrototipo.setVisible(true);
            flag = false;
        }else{
            apnPrototipo.setVisible(false);
        }
        if(flag){
            btnPollo.setVisible(flag);
            btnCancelar.setVisible(!flag);
            btnGuardar.setVisible(!flag);
            btnAsociarProyecto.setVisible(!flag);
            btnAgregarColaborador.setVisible(!flag);
        }else{
            btnPollo.setVisible(flag);
            btnGuardar.setVisible(!flag);
            btnAsociarProyecto.setVisible(!flag);
            btnAgregarColaborador.setVisible(!flag);
        }
    }
    
    private void guardarTesis(){
        
        Tesis tesis = new Tesis();
    }
}
