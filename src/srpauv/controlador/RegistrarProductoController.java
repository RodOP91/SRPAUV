/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srpauv.controlador;

import DAO.DAOregistrarProducto;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import srpauv.clases.*;

/**
 * FXML Controller class
 *
 * @author edson
 */
public class RegistrarProductoController implements Initializable {
    
    @FXML Button btnPollo;
    
    @FXML ListView listProyectos;
    private Proyecto proySelec = null;
    
    private int flagProducto = 0;
    
    
    private static List<Colaborador> colaboradores;
    private static List<Integrante> integrantes;

    public static void setColaboradores(List<Colaborador> colaboradores) {
        RegistrarProductoController.colaboradores = colaboradores;
    }

    public static void setIntegrantes(List<Integrante> integrantes) {
        RegistrarProductoController.integrantes = integrantes;
    }
    
    
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
    @FXML TextField txtautorarbitrado;
    @FXML TextField txttituloarbitrado;
    @FXML TextField txtnomrevistaarbitrado;
    @FXML TextField txteditorialarbitrado;
    @FXML TextField txtpropositoarbitrado;
    @FXML TextField txtissnarbitrado;
    @FXML TextField txtdirelecarbitrado;
    @FXML TextField txtvolarbitrado;
    @FXML TextField txtpagsarbitrado;
    @FXML TextField txtpaisarbitrado;
    @FXML TextField txtanoarbitrado;
    @FXML TextField txtedoactualarbitrado;
    @FXML ComboBox<Linea> cbxlgacarbitrado;
    @FXML TextArea txtadescarbitrado;
    @FXML CheckBox chkcaarbitrado;
    //--------------------------------------------------------------------------
    
    //ARTICULO INDEXADO---------------------------------------------------------
    @FXML TextField txtautorindexado;
    @FXML TextField txttituloindexado;
    @FXML TextField txtnomrevistaindexado;
    @FXML TextField txteditorialindexado;
    @FXML TextField txtpropositoindexado;
    @FXML TextField txtissnindexado;
    @FXML TextField txtdirelecindexado;
    @FXML TextField txtvolindexado;
    @FXML TextField txtpagsindexado;
    @FXML TextField txtpaisindexado;
    @FXML TextField txtanoindexado;
    @FXML TextField txtedoactualindexado;
    @FXML ComboBox<Linea> cbxlgacindexado;
    @FXML TextArea txtadescindexado;
    @FXML CheckBox chkcaindexado;
    //--------------------------------------------------------------------------
    
    //ARTICULO------------------------------------------------------------------
    @FXML TextField txtautorarticulo;
    @FXML TextField txttituloarticulo;
    @FXML TextField txtnomrevistaarticulo;
    @FXML TextField txteditorialarticulo;
    @FXML TextField txtpropositoarticulo;
    @FXML TextField txtissnarticulo;    
    @FXML TextField txtvolarticulo;
    @FXML TextField txtpagsarticulo;
    @FXML TextField txtpaisarticulo;
    @FXML TextField txtanoarticulo;
    @FXML TextField txtedoactualarticulo;
    @FXML ComboBox<Linea> cbxlgacarticulo;
    @FXML TextArea txtadescarticulo;
    @FXML CheckBox chkcaarticulo;
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
    @FXML TextField txttituloprod;
    @FXML TextField txtparticipanteprod;
    @FXML TextField txtclasifprod;
    @FXML TextField txtnumregprod;
    @FXML TextField txtpaisprod;
    @FXML TextField txtpropositoprod;
    @FXML TextArea txtadescprod;
    @FXML DatePicker dtpfechaprod;
    @FXML ComboBox<Linea> cbxlgacprod;    
    @FXML CheckBox chkcaprod;
    //--------------------------------------------------------------------------
    
    //MEMORIA EN EXTENSO--------------------------------------------------------
    @FXML TextField txtautormem;
    @FXML TextField txttitulopresmem;
    @FXML TextField txtpagsmem;
    @FXML TextField txtedomem;
    @FXML TextField txtpaismem;
    @FXML TextField txtciudadmem;    
    @FXML TextField txtanomem;
    @FXML TextField txtedoactualmem;
    @FXML TextField txtcongresomem;
    @FXML ComboBox<Linea> cbxlgacmem;
    @FXML TextArea txtapropositomem;
    @FXML CheckBox chkcamem;
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
    
    private ResourceBundle rb;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        this.rb = rb;
        
        try{
            llenarCombos();
            recuperarProyectos();
        }catch(SQLException ex) {
            Logger.getLogger(RegistrarProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
//VALIDACIONES CAMPOS-----------------------------------------------------------
        txtNoAlumnosTesis.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    txtNoAlumnosTesis.setText(oldValue);
                }
            }
        });
//------------------------------------------------------------------------------
    
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
            if(listProyectos.isVisible()){
                listProyectos.setVisible(false);
            }
            if(proySelec != null){
                listProyectos.getSelectionModel().select(-1);
                proySelec = null;
            }
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
            if(listProyectos.isVisible()){
                listProyectos.setVisible(false);
            }
            if(proySelec != null){
                listProyectos.getSelectionModel().select(-1);
                proySelec = null;
            }
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
            if(listProyectos.isVisible()){
                listProyectos.setVisible(false);
            }
            if(proySelec != null){
                listProyectos.getSelectionModel().select(-1);
                proySelec = null;
            }
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
            if(listProyectos.isVisible()){
                listProyectos.setVisible(false);
            }
            if(proySelec != null){
                listProyectos.getSelectionModel().select(-1);
                proySelec = null;
            }
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
            if(listProyectos.isVisible()){
                listProyectos.setVisible(false);
            }
            if(proySelec != null){
                listProyectos.getSelectionModel().select(-1);
                proySelec = null;
            }
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
            if(listProyectos.isVisible()){
                listProyectos.setVisible(false);
            }
            if(proySelec != null){
                listProyectos.getSelectionModel().select(-1);
                proySelec = null;
            }
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
            if(listProyectos.isVisible()){
                listProyectos.setVisible(false);
            }
            if(proySelec != null){
                listProyectos.getSelectionModel().select(-1);
                proySelec = null;
            }
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
            if(listProyectos.isVisible()){
                listProyectos.setVisible(false);
            }
            if(proySelec != null){
                listProyectos.getSelectionModel().select(-1);
                proySelec = null;
            }
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
            if(listProyectos.isVisible()){
                listProyectos.setVisible(false);
            }
            if(proySelec != null){
                listProyectos.getSelectionModel().select(-1);
                proySelec = null;
            }
        });
        
        btnGuardar.setOnAction((ActionEvent event) -> {
            if(listProyectos.isVisible()){
                listProyectos.setVisible(false);
            }
            switch(flagProducto){
                case 1:
                    guardarTesis();                    
                    break;
                case 2:
                    guardarArticuloIndexado();
                    break;
                case 3:
                    guardarArticuloArbitrado();
                    break;
                case 4:
                    guardarArticulo();
                    break;
                case 5:
                    guardarCapituloLibro();
                    break;
                case 6:
                    guardarLibro();
                    break;
                case 7:
                    guardarProduccionInnovadora();
                    break;
                case 8:
                    guardarMemoriaExtenso();
                    break;
                case 9:
                    guardarPrototipo();
                    break;
            }
        });
       
        btnAsociarProyecto.setOnAction((ActionEvent event) -> {
            if(listProyectos.isVisible()){
                listProyectos.setVisible(false);
            }else{
                if(proySelec == null){
                    listProyectos.getSelectionModel().select(-1);
                }
                listProyectos.setVisible(true);
            } 
        });
        
        btnAgregarColaborador.setOnAction((ActionEvent event) -> {
            try {
                mostrarVentanaColaboradores();
            } catch (IOException ex) {
                Logger.getLogger(RegistrarProductoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        listProyectos.setOnMouseClicked((MouseEvent event) -> {
            proySelec = (Proyecto) listProyectos.getSelectionModel().getSelectedItem();
        });
        
        listProyectos.setOnMouseExited((MouseEvent event) -> {
            if(listProyectos.isVisible()){
                Proyecto proy = (Proyecto) listProyectos.getSelectionModel().getSelectedItem();
                listProyectos.setVisible(false);
            }
        });
    }
    
    //Método que maneja la navegavilidad de la ventana
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
    
    //Método que llena los combos de lgac de cada producto
    private void llenarCombos() throws SQLException{
        List<Linea> listaLineas = DAOregistrarProducto.recuperarLineas();
        for(int i = 0; i < listaLineas.size(); i++){
            cbxLGACtesis.getItems().add(listaLineas.get(i));
            cbxLGACcl.getItems().add(listaLineas.get(i));
            cbxLGAClibro.getItems().add(listaLineas.get(i));
            cbxLGACproto.getItems().add(listaLineas.get(i));                
            cbxlgacarbitrado.getItems().add(listaLineas.get(i));
            cbxlgacarticulo.getItems().add(listaLineas.get(i));
            cbxlgacindexado.getItems().add(listaLineas.get(i));
            cbxlgacmem.getItems().add(listaLineas.get(i));
            cbxlgacprod.getItems().add(listaLineas.get(i));
        }
    }
    
    //Método que llena la lista de proyectos
    private void recuperarProyectos() throws SQLException{
        List<Proyecto> listaProyectos = DAO.DAOregistrarProducto.recuperarProyectos();
        for(int i = 0; i < listaProyectos.size(); i++){
            listProyectos.getItems().add(listaProyectos.get(i));
        }
    }
    
    //
    private void mostrarVentanaColaboradores() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/srpauv/FXML/AgregarColaborador.fxml"), rb);
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        //stage.setTitle(rb.getString("tituloG"));
        stage.show();
        
    }
    
    //Método que recupera y valida los campos de Tesis
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
                    
                    //tesis.setIntegranteR();//integrante que registra el producto
                    tesis.setProyectoAsociado(proySelec);
                    tesis.setIntegrantes(integrantes);
                    tesis.setColaboradores(colaboradores);
                    
                    tesis.registrarProducto();
                }
            }
        }catch(NullPointerException ex){
            System.err.println("lgac nula");
        }
    }
    
    /*
    .setIdIntegranteR(1);
    .setProyectoAsociado(proySelec);
    .setIntegrantes(integrantes);
    .setColaboradores(colaboradores);
    */
    
    //Método que recupera y valida los campos de Articulo Indexado
    private void guardarArticuloIndexado(){
        /**
         * Recopilación de datos de campos de texto
         */
        ArticuloIndexado articuloindexado = new ArticuloIndexado();
        String titulo = txttituloindexado.getText();
        String autor = txtautorindexado.getText();
        String nomrevista = txtnomrevistaindexado.getText();
        String editorial = txteditorialindexado.getText();
        String proposito = txtpropositoindexado.getText();
        String issn = txtissnindexado.getText();
        String direlec = txtdirelecindexado.getText();
        String vol = txtvolindexado.getText();
        String pags = txtpagsindexado.getText();
        String pais = txtpaisindexado.getText();
        String ano = txtanoindexado.getText();
        String edoactual = txtedoactualindexado.getText();
        boolean ca = chkcaindexado.isSelected();
        /**
         * Validación de campos vacíos
         */
        try{
            String lgac = cbxlgacindexado.getSelectionModel().getSelectedItem().getNombre();
            if(titulo.isEmpty() || autor.isEmpty() || nomrevista.isEmpty() || editorial.isEmpty()
                || proposito.isEmpty() || issn.isEmpty() || direlec.isEmpty()||
                vol.isEmpty() || pags.isEmpty() || pais.isEmpty() || ano.isEmpty()
                || edoactual.isEmpty()){
            System.err.println("Campos Vacíos");
            }else{
                articuloindexado.setTitulo(titulo);          
                articuloindexado.setAutor(autor); 
                articuloindexado.setNomrevista(nomrevista); 
                articuloindexado.setEditorial(editorial); 
                articuloindexado.setVolumen(vol);
                articuloindexado.setPags(pags);
                articuloindexado.setPais(pais);
                articuloindexado.setAno(ano);
                articuloindexado.setEstado(edoactual);
                articuloindexado.setLgac(lgac);
                articuloindexado.setValidadoCA(ca);     
                articuloindexado.setProyectoAsociado(proySelec);
                articuloindexado.registrarProducto();
            }
        }catch(NullPointerException ex){
            System.err.println("lgac nula");
        }
        
    }
    
    //Método que recupera y valida los campos de Articulo Arbitrado
    private void guardarArticuloArbitrado(){
        /**
         * Recopilación de datos de campos de texto
         */
        ArticuloArbitrado articuloarbitrado = new ArticuloArbitrado();
        String titulo = txttituloarbitrado.getText();
        String autor = txtautorarbitrado.getText();
        String nomrevista = txtnomrevistaarbitrado.getText();
        String editorial = txteditorialarbitrado.getText();
        String proposito = txtpropositoarbitrado.getText();
        String issn = txtissnarbitrado.getText();
        String direlec = txtdirelecarbitrado.getText();
        String vol = txtvolarbitrado.getText();
        String pags = txtpagsarbitrado.getText();
        String pais = txtpaisarbitrado.getText();
        String ano = txtanoarbitrado.getText();
        String edoactual = txtedoactualarbitrado.getText();
        
        boolean ca = chkcaarbitrado.isSelected();
        /**
         * Validación de campos vacíos
         */
        try{
            String lgac = cbxlgacarbitrado.getSelectionModel().getSelectedItem().getNombre();
            if(titulo.isEmpty() || autor.isEmpty() || nomrevista.isEmpty() || editorial.isEmpty()
                || proposito.isEmpty() || issn.isEmpty() || direlec.isEmpty()||
                vol.isEmpty() || pags.isEmpty() || pais.isEmpty() || ano.isEmpty()
                || edoactual.isEmpty()){
            System.err.println("Campos Vacíos");
            }else{               
                articuloarbitrado.setTitulo(titulo);          
                articuloarbitrado.setAutor(autor); 
                articuloarbitrado.setNomrevista(nomrevista); 
                articuloarbitrado.setEditorial(editorial); 
                articuloarbitrado.setVolumen(vol);
                articuloarbitrado.setPaginas(pags);
                articuloarbitrado.setPais(pais);
                articuloarbitrado.setAno(ano);
                articuloarbitrado.setEstado(edoactual);
                articuloarbitrado.setLgac(lgac);
                articuloarbitrado.setValidadoCA(ca);  
                articuloarbitrado.setProyectoAsociado(proySelec);
                articuloarbitrado.registrarProducto();
                    
                }
        
            }catch(NullPointerException ex){
                System.err.println("lgac nula");
            }
}
    
    //Método que recupera y valida los campos de Articulo
    private void guardarArticulo(){
        /**
         * Recopilación de datos de campos de texto
         */
        Articulo articulo = new Articulo();
        String titulo = txttituloarticulo.getText();
        String autor = txtautorarticulo.getText();
        String nomrevista = txtnomrevistaarticulo.getText();
        String editorial = txteditorialarticulo.getText();
        String proposito = txtpropositoarticulo.getText();
        String issn = txtissnarticulo.getText();
        String vol = txtvolarticulo.getText();
        String pags = txtpagsarticulo.getText();
        String pais = txtpaisarticulo.getText();
        String ano = txtanoarticulo.getText();
        String edoactual = txtedoactualarticulo.getText();
        
        boolean ca = chkcaarticulo.isSelected();
        /**
         * Validación de campos vacíos
         */
        try{
            String lgac = cbxlgacarticulo.getSelectionModel().getSelectedItem().getNombre();
            if(titulo.isEmpty() || autor.isEmpty() || nomrevista.isEmpty() || editorial.isEmpty()
                || proposito.isEmpty() || issn.isEmpty() || vol.isEmpty() || 
                pags.isEmpty() || pais.isEmpty() || ano.isEmpty()
                || edoactual.isEmpty()){
            System.err.println("Campos Vacíos");
            }else{
                    articulo.setTitulo(titulo);          
                    articulo.setAutor(autor); 
                    articulo.setNomrevista(nomrevista); 
                    articulo.setEditorial(editorial); 
                    articulo.setVolumen(vol);
                    articulo.setPaginas(pags);
                    articulo.setPais(pais);
                    articulo.setAno(ano);
                    articulo.setEstado(edoactual);
                    articulo.setLgac(lgac);
                    articulo.setValidadoCA(ca);      
                    articulo.setProyectoAsociado(proySelec);
                    articulo.registrarProducto();

                }
        }catch(NullPointerException ex){
            System.err.println("lgac nula");
        }
        
}
    
    //Método que recupera y valida los campos de Cap de Libro
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
                capLib.setEstado(estadoActual);
                capLib.setProyectoAsociado(proySelec);
                capLib.registrarProducto();
            }   
        }catch(NullPointerException ex){
            System.out.println("lgac no seleccionada");
        }
    }
    
    //Método que recupera y valida los campos de Libro
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
                libro.setProyectoAsociado(proySelec);
                libro.registrarProducto();
            }
        }catch(NullPointerException ex){
            System.out.println("lgac no seleccionada");
        }
    }
    
    //Método que recupera y valida los campos de Prod Innov
    private void guardarProduccionInnovadora(){
        /**
         * Recopilación de datos de campos de texto
         */
        ProduccionInnovadora produccioninnovadora = new ProduccionInnovadora();
        String titulo = txttituloprod.getText();
        String participante = txtparticipanteprod.getText();
        String clasifinter = txtclasifprod.getText();
        String numreg = txtnumregprod.getText();
        LocalDate fecha = dtpfechaprod.getValue();
        String proposito = txtpropositoindexado.getText();
        String pais = txtpaisindexado.getText();
        String edoactual = txtedoactualindexado.getText();
        
        boolean ca = chkcaindexado.isSelected();
        /**
         * Validación de campos vacíos
         */
        try{
            String lgac = cbxlgacindexado.getSelectionModel().getSelectedItem().getNombre();
            if(titulo.isEmpty() || participante.isEmpty() || clasifinter.isEmpty() || numreg.isEmpty()
                || proposito.isEmpty() || fecha == null){
            System.err.println("Campos Vacíos");
            }else{

                        produccioninnovadora.setTitulo(titulo);          
                        produccioninnovadora.setParticipante(participante); 
                        produccioninnovadora.setClasifinternacional(clasifinter); 
                        produccioninnovadora.setNumregistro(numreg); 
                        produccioninnovadora.setFechapub(fecha);
                        produccioninnovadora.setPais(pais);
                        produccioninnovadora.setEstado(edoactual);
                        produccioninnovadora.setLgac(lgac);
                        produccioninnovadora.setValidadoCA(ca);  
                        produccioninnovadora.setProyectoAsociado(proySelec);
                        produccioninnovadora.registrarProducto();

                }
        }catch(NullPointerException ex){
            System.err.println("lgac nula");
        }
        
}
   
    //Método que recupera y valida los campos de Memoria en extenso
    private void guardarMemoriaExtenso(){
        /**
         * Recopilación de datos de campos de texto
         */
        MemoriaExtenso memoriaextenso = new MemoriaExtenso();
        String titulo = txttitulopresmem.getText();
        String autor = txtautormem.getText();
        String congreso = txtcongresomem.getText();
        String pags = txtpagsmem.getText();
        String estado = txtedomem.getText();
        String ciudad = txtciudadmem.getText();
        String pais = txtpaismem.getText();
        String ano = txtanomem.getText();
        String proposito = txtapropositomem.getText();
        String edoactual = txtedoactualmem.getText();
        
        boolean ca = chkcamem.isSelected();
        /**
         * Validación de campos vacíos
         */
        try{
            String lgac = cbxlgacmem.getSelectionModel().getSelectedItem().getNombre();
            if(titulo.isEmpty() || autor.isEmpty() || congreso.isEmpty() || estado.isEmpty()
                || ciudad.isEmpty() || pags.isEmpty() || pais.isEmpty() || ano.isEmpty()
                || edoactual.isEmpty()){
            System.err.println("Campos Vacíos");
            }else{
            
                    memoriaextenso.setTitulo(titulo);          
                    memoriaextenso.setAutor(autor);
                    memoriaextenso.setCongreso(congreso);
                    memoriaextenso.setRangopags(pags);
                    memoriaextenso.setCiudad(ciudad);
                    memoriaextenso.setEstadoG(estado);
                    memoriaextenso.setPais(pais);
                    memoriaextenso.setAno(ano);
                    memoriaextenso.setProposito(proposito);
                    memoriaextenso.setEstado(edoactual);
                    memoriaextenso.setLgac(lgac);
                    memoriaextenso.setValidadoCA(ca);  
                    memoriaextenso.setProyectoAsociado(proySelec);
                    memoriaextenso.registrarProducto();
                }
        }catch(NullPointerException ex){
            System.err.println("lgac nula");
        }
        
            
}
    
    //Método que recupera y valida los campos de Prototipo
    private void guardarPrototipo(){
        String nombre = txtNombreProto.getText();
        String institucion = txtInstitucionCreadoraProto.getText();
        String año = txtAñoProto.getText();
        String pais = txtPaisProto.getText();
        String estado = txtEstadoActualProto.getText();
        String objetivos = txaObjetivosProto.getText();
        String caracteristicas = txaCaracteristicasProto.getText();
        String proposito = txaPropositoProto.getText();
        boolean ca = chkCAproto.isSelected();
        
        try{
            String lgac = cbxLGACproto.getSelectionModel().getSelectedItem().getNombre();
            
            if(nombre.isEmpty() || institucion.isEmpty() || año.isEmpty() ||
                    pais.isEmpty() || estado.isEmpty() || objetivos.isEmpty() ||
                    caracteristicas.isEmpty() || proposito.isEmpty()){
                System.err.println("campos vacios");
            }else{
                Prototipo proto = new Prototipo();
                proto.setTitulo(nombre);
                proto.setInstitucion(institucion);
                proto.setAño(año);
                proto.setPais(pais);
                proto.setEstado(estado);
                proto.setObjetivos(objetivos);
                proto.setCaracteristicas(caracteristicas);
                proto.setProposito(proposito);
                proto.setConsiderarCA(ca);
                proto.setLgac(lgac);
                proto.setProyectoAsociado(proySelec);
                proto.recuperarProducto();
            }
        }catch(NullPointerException ex){
            System.out.println("lgac no seleccionada");
        }
    }
}
