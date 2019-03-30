/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srpauv.controlador;

import DAO.DAOregistrarProducto;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import srpauv.clases.*;

/**
 * FXML Controller class
 *
 * @author edson
 */
public class RegistrarProductoController implements Initializable {
    
    String textoTextField = "";
    
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
    @FXML ComboBox<Linea>  cbxLGACtesis;
    @FXML CheckBox chkCAtesis;
    //--------------------------------------------------------------------------
    
    //ARTICULO ARBITRADO--------------------------------------------------------
    
    //--------------------------------------------------------------------------
    
    //ARTICULO INDEXADO---------------------------------------------------------
    
    //--------------------------------------------------------------------------
    
    //ARTICULO------------------------------------------------------------------
    
    //--------------------------------------------------------------------------
    
    //CAPITULO DE LIBRO---------------------------------------------------------
    @FXML TextField txtTituloCL;
    @FXML TextField txtTituloLibroCL;
    @FXML TextField txtEstadoActualCL;
    @FXML TextField txtISBNcl;
    @FXML TextField txtPropositoCL;
    @FXML TextField txtAutoresCL;
    @FXML TextField txtPaisCL;
    @FXML TextField txtEditorialCL;
    @FXML TextField txtNoEdicionesCL;
    @FXML TextField txtPaginasCL;
    @FXML TextField txtTotalEjemplaresCL;
    @FXML TextField txtAñoCL;
    @FXML ComboBox<Linea> cbxLGACcl;
    @FXML CheckBox chkCAcl;
    //--------------------------------------------------------------------------
    
    //LIBRO---------------------------------------------------------------------
    @FXML TextField txtTituloLibro;
    @FXML TextField txtAutoresLibro;
    @FXML TextField txtISBNlibro;
    @FXML TextField txtPropositoLibro;
    @FXML TextField txtPaisLibro;
    @FXML TextField txtEditorialLibro;
    @FXML TextField txtNoEdicionesLibro;
    @FXML TextField txtEstadoActualLibro;
    @FXML TextField txtTotalEjemplaresLibro;
    @FXML TextField txtAñoLibro;
    @FXML ComboBox<Linea> cbxLGAClibro;
    @FXML CheckBox chkCAlibro;
    //--------------------------------------------------------------------------
    
    //PRODUCCIÓN INNOVADORA-----------------------------------------------------
    
    //--------------------------------------------------------------------------
    
    //MEMORIA EN EXTENSO--------------------------------------------------------
    
    //--------------------------------------------------------------------------
    
    //PROTOTIPO-----------------------------------------------------------------
    @FXML TextField txtNombreProto;
    @FXML TextField txtInstitucionCreadoraProto;
    @FXML TextField txtAñoProto;
    @FXML TextField txtPaisProto;
    @FXML TextField txtEstadoActualProto;
    @FXML TextArea txaObjetivosProto;
    @FXML TextArea txaCaracteristicasProto;
    @FXML TextArea txaPropositoProto;
    @FXML ComboBox<Linea> cbxLGACproto;
    @FXML CheckBox chkCAproto;
    //--------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        llenarCombos();
        
        txtNoAlumnosTesis.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    txtNoAlumnosTesis.setText(oldValue);
                }
            }
        });
        
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
    
    private void llenarCombos(){
        List<Linea> listaLineas = DAOregistrarProducto.recuperarLineas();
        for(int i = 0; i < listaLineas.size(); i++){
            cbxLGACtesis.getItems().add(listaLineas.get(i));
            cbxLGACcl.getItems().add(listaLineas.get(i));
        }
    }
    
    private void guardarTesis(){
        String titulo = txtTituloTesis.getText();
        String grado = txtGradoTesis.getText();
        String numAlumnos = txtNoAlumnosTesis.getText();
        boolean ca = chkCAtesis.isSelected();
        LocalDate fechaInicio = dtpFechaInicioTesis.getValue();
        LocalDate fechaFin = dtpFechaFinTesis.getValue();
        
        
        try{
            String lgac = cbxLGACtesis.getSelectionModel().getSelectedItem().getNombre();
            
            if(titulo.isEmpty() || grado.isEmpty() || numAlumnos.isEmpty()){
                System.err.println("campos vacios");
            }else{
                if(fechaInicio == null || fechaFin == null){
                    System.out.println("selecciona ambas fechas");
                }else{
                    Tesis tesis = new Tesis();
                    tesis.setTitulo(titulo);                    
                    tesis.setGrado(grado);
                    tesis.setNumAlumnos(Integer.parseInt(numAlumnos));
                    tesis.setLgac(lgac);
                    tesis.setValidadoCA(ca);
                    tesis.setFechaInicio(fechaInicio);
                    tesis.setFechaFin(fechaFin);
                    tesis.registrarProducto();
                }
            }
        }catch(NullPointerException ex){
            System.err.println("lgac nula");
        }
    }
    
    private void guardarCapituloLibro(){
        String titulo = txtTituloCL.getText();
        String tituloLibro = txtTituloLibroCL.getText();
        String estadoActual = txtEstadoActualCL.getText();
        String isbn = txtISBNcl.getText();
        String proposito = txtPropositoCL.getText();
        String autores = txtAutoresCL.getText();
        String pais = txtPaisCL.getText();
        String editorial = txtEditorialCL.getText();
        String noEdiciones = txtNoEdicionesCL.getText();
        String paginas = txtPaginasCL.getText();
        String totalEjemplares = txtTotalEjemplaresCL.getText();
        String año = txtAñoCL.getText();
        boolean ca = chkCAcl.isSelected();
        
        try{    
            String lgac = cbxLGACcl.getSelectionModel().getSelectedItem().getNombre();
        
            if(titulo.isEmpty() || tituloLibro.isEmpty() || estadoActual.isEmpty()
                    || isbn.isEmpty() || proposito.isEmpty() || autores.isEmpty()
                    || pais.isEmpty() || editorial.isEmpty() || noEdiciones.isEmpty()
                    || paginas.isEmpty() || totalEjemplares.isEmpty() || año.isEmpty()){
                System.err.println("campos vacios");
            }else{
                CapituloLibro capLib = new CapituloLibro();
                capLib.setTitulo(titulo);
                capLib.setTituloLibro(tituloLibro);
                capLib.setAutor_es(autores);
                capLib.setAño(año);
                capLib.setConsiderarCA(ca);
                capLib.setEditorial(editorial);
                capLib.setISBN(isbn);
                capLib.setLgac(lgac);
                capLib.setNoEdiciones(Integer.parseInt(noEdiciones));
                capLib.setPaginas(paginas);
                capLib.setPais(pais);
                capLib.setProposito(proposito);
                capLib.setTotalEjemplares(Integer.parseInt(totalEjemplares));
                capLib.registrarProducto();
            }   
        }catch(NullPointerException ex){
            System.out.println("lgac no seleccionada");
        }
    }
    
    private void guardarLibro(){
        String titulo = txtTituloLibro.getText();
        String autor_es = txtAutoresLibro.getText();
        String isbn = txtISBNlibro.getText();
        String proposito = txtPropositoLibro.getText();
        String pais = txtPaisLibro.getText();
        String editorial = txtEditorialLibro.getText();
        String noEdiciones = txtNoEdicionesLibro.getText();
        String estadoActual = txtEstadoActualLibro.getText();
        String totalEjemplares = txtTotalEjemplaresLibro.getText();
        String año = txtAñoLibro.getText();
        boolean ca = chkCAlibro.isSelected();
        
        try{
            String lgac = cbxLGAClibro.getSelectionModel().getSelectedItem().getNombre();
            
            if(titulo.isEmpty() || autor_es.isEmpty() || isbn.isEmpty() ||
                    proposito.isEmpty() || pais.isEmpty() || editorial.isEmpty()
                    || noEdiciones.isEmpty() || estadoActual.isEmpty() || 
                    totalEjemplares.isEmpty() || año.isEmpty()){
                System.err.println("campos vacios");
            }else{
                Libro libro = new Libro();
                libro.setTitulo(titulo);
                libro.setAutor_es(autor_es);
                libro.setISBN(isbn);
                libro.setProposito(proposito);
                libro.setPais(pais);
                libro.setEditorial(editorial);
                libro.setNoEdiciones(Integer.parseInt(noEdiciones));
                libro.setEstado(estadoActual);
                libro.setTotalEjemplares(Integer.parseInt(totalEjemplares));
                libro.setConsiderarCA(ca);
                libro.setLgac(lgac);
                libro.registrarProducto();
            }
        }catch(NullPointerException ex){
            System.out.println("lgac no seleccionada");
        }
    }
    
    private void guardarPrototipo(){
        
    }
}
