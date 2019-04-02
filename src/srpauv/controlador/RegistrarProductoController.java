/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srpauv.controlador;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import srpauv.clases.*;

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
    @FXML ComboBox<String>  cbxLGACtesis;
    @FXML CheckBox chkCAtesis;
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
    @FXML ComboBox<String> cbxlgacindexado;
    @FXML TextArea txtadescindexado;
    @FXML CheckBox chkcaindexado;
    //ARTICULO ARBITRADO-------------------------------------------------------
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
    @FXML ComboBox<String> cbxlgacarbitrado;
    @FXML TextArea txtadescarbitrado;
    @FXML CheckBox chkcaarbitrado;
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
    @FXML ComboBox<String> cbxlgacarticulo;
    @FXML TextArea txtadescarticulo;
    @FXML CheckBox chkcaarticulo;
    //PRODUCCION INNOVADORA-----------------------------------------------------
    @FXML TextField txttituloprod;
    @FXML TextField txtparticipanteprod;
    @FXML TextField txtclasifprod;
    @FXML TextField txtnumregprod;
    @FXML TextField txtpaisprod;
    @FXML TextField txtpropositoprod;
    @FXML TextArea txtadescprod;
    @FXML DatePicker dtpfechaprod;
    @FXML ComboBox<String> cbxlgacprod;    
    @FXML CheckBox chkcaprod;
    //MEMORIA EN EXTENSO
    @FXML TextField txtautormem;
    @FXML TextField txttitulopresmem;
    @FXML TextField txtpagsmem;
    @FXML TextField txtedomem;
    @FXML TextField txtpaismem;
    @FXML TextField txtciudadmem;    
    @FXML TextField txtanomem;
    @FXML TextField txtedoactualmem;
    @FXML TextField txtcongresomem;
    @FXML ComboBox<String> cbxlgacmem;
    @FXML TextArea txtapropositomem;
    @FXML CheckBox chkcamem;
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
                guardarArticuloIndexado();
            }
            if(flagProducto == 3){
                guardarArticuloArbitrado();
            }
            if(flagProducto == 4){
                guardarArticulo();
            }
            if(flagProducto == 5){
                
            }
            if(flagProducto == 6){
                
            }
            if(flagProducto == 7){
                guardarProduccionInnovadora();
            }
            if(flagProducto == 8){
                guardarMemoriaExtenso();
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
    
    /**
     * Metódo que recopila la información de los campos en la GUI para la creación
     * de un objeto TESIS
     */
    private void guardarTesis(){
        Tesis tesis = new Tesis();
        String titulo = txtTituloTesis.getText();
        String grado = txtGradoTesis.getText();
        String numAlumnos = txtNoAlumnosTesis.getText();
        String lgac = cbxLGACtesis.getSelectionModel().getSelectedItem();
        boolean ca = chkCAtesis.isSelected();
        LocalDate fechaInicio = dtpFechaInicioTesis.getValue();
        LocalDate fechaFin = dtpFechaFinTesis.getValue();
        if(titulo.isEmpty() || grado.isEmpty() || numAlumnos.isEmpty()){
            System.err.println("campos vacios");
        }else{
            if(lgac == null){
                System.out.println("lgac no seleccionada");
            }else{
                if(fechaInicio == null || fechaFin == null){
                    System.out.println("selecciona ambas fechas");
                }else{
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
        }
    }
    
    /**
     * Metódo que recopila la información de los campos en la GUI para la creación
     * de un objeto TESIS
     */
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
        String lgac = cbxlgacindexado.getSelectionModel().getSelectedItem();
        boolean ca = chkcaindexado.isSelected();
        /**
         * Validación de campos vacíos
         */
        if(titulo.isEmpty() || autor.isEmpty() || nomrevista.isEmpty() || editorial.isEmpty()
                || proposito.isEmpty() || issn.isEmpty() || direlec.isEmpty()||
                vol.isEmpty() || pags.isEmpty() || pais.isEmpty() || ano.isEmpty()
                || edoactual.isEmpty()){
            System.err.println("Campos Vacíos");
        }else{
            if(lgac == null){
                System.out.println("LGAC no seleccionada");
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
                    articuloindexado.registrarProducto();
                }
            }
        }
    
    /**
     * Metódo que recopila la información de los campos en la GUI para la creación
     * de un objeto ARTICULO INDEXADO
     */
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
        String lgac = cbxlgacarbitrado.getSelectionModel().getSelectedItem();
        boolean ca = chkcaarbitrado.isSelected();
        /**
         * Validación de campos vacíos
         */
        if(titulo.isEmpty() || autor.isEmpty() || nomrevista.isEmpty() || editorial.isEmpty()
                || proposito.isEmpty() || issn.isEmpty() || direlec.isEmpty()||
                vol.isEmpty() || pags.isEmpty() || pais.isEmpty() || ano.isEmpty()
                || edoactual.isEmpty()){
            System.err.println("Campos Vacíos");
        }else{
            if(lgac == null){
                System.out.println("LGAC no seleccionada");
            }else{
                    articuloarbitrado.setTitulo(titulo);          
                    articuloarbitrado.setAutor(autor); 
                    articuloarbitrado.setNomrevista(nomrevista); 
                    articuloarbitrado.setEditorial(editorial); 
                    articuloarbitrado.setVolumen(vol);
                    articuloarbitrado.setPags(pags);
                    articuloarbitrado.setPais(pais);
                    articuloarbitrado.setAno(ano);
                    articuloarbitrado.setEstado(edoactual);
                    articuloarbitrado.setLgac(lgac);
                    articuloarbitrado.setValidadoCA(ca);                    
                    articuloarbitrado.registrarProducto();
                }
            }
        }
    
    /**
     * Metódo que recopila la información de los campos en la GUI para la creación
     * de un objeto ARTICULO ARBITRADO
     */
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
        String lgac = cbxlgacarticulo.getSelectionModel().getSelectedItem();
        boolean ca = chkcaarticulo.isSelected();
        /**
         * Validación de campos vacíos
         */
        if(titulo.isEmpty() || autor.isEmpty() || nomrevista.isEmpty() || editorial.isEmpty()
                || proposito.isEmpty() || issn.isEmpty() || vol.isEmpty() || 
                pags.isEmpty() || pais.isEmpty() || ano.isEmpty()
                || edoactual.isEmpty()){
            System.err.println("Campos Vacíos");
        }else{
            if(lgac == null){
                System.out.println("LGAC no seleccionada");
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
                    articulo.registrarProducto();
                }
            }
        }
    
    /**
     * Metódo que recopila la información de los campos en la GUI para la creación
     * de un objeto PRODDUCCION INNOVADORA
     */
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
        String lgac = cbxlgacindexado.getSelectionModel().getSelectedItem();
        boolean ca = chkcaindexado.isSelected();
        /**
         * Validación de campos vacíos
         */
        if(titulo.isEmpty() || participante.isEmpty() || clasifinter.isEmpty() || numreg.isEmpty()
                || proposito.isEmpty() || fecha == null){
            System.err.println("Campos Vacíos");
        }else{
            if(lgac == null){
                System.out.println("LGAC no seleccionada");
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
                    produccioninnovadora.registrarProducto();
                }
            }
        }
    
    /**
     * Metódo que recopila la información de los campos en la GUI para la creación
     * de un objeto MEMORIA EN EXTENSO
     */
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
        String lgac = cbxlgacmem.getSelectionModel().getSelectedItem();
        boolean ca = chkcamem.isSelected();
        /**
         * Validación de campos vacíos
         */
        if(titulo.isEmpty() || autor.isEmpty() || congreso.isEmpty() || estado.isEmpty()
                || ciudad.isEmpty() || pags.isEmpty() || pais.isEmpty() || ano.isEmpty()
                || edoactual.isEmpty()){
            System.err.println("Campos Vacíos");
        }else{
            if(lgac == null){
                System.out.println("LGAC no seleccionada");
            }else{
                    memoriaextenso.setTitulo(titulo);          
                    memoriaextenso.setAutor(autor);
                    memoriaextenso.setCongreso(congreso);
                    memoriaextenso.setRangopags(pags);
                    memoriaextenso.setCiudad(ciudad);
                    memoriaextenso.setEstado(estado);
                    memoriaextenso.setPais(pais);
                    memoriaextenso.setAno(ano);
                    memoriaextenso.setProposito(proposito);
                    memoriaextenso.setEstado(edoactual);
                    memoriaextenso.setLgac(lgac);
                    memoriaextenso.setValidadoCA(ca);                    
                    memoriaextenso.registrarProducto();
                }
            }
        }
    }


