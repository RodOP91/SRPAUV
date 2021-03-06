/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srpauv.controlador;

import DAO.LineaDAO;
import DAO.ProductosDAO;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import srpauv.clases.Articulo;
import srpauv.clases.ArticuloArbitrado;
import srpauv.clases.ArticuloIndexado;
import srpauv.clases.CapituloLibro;
import srpauv.clases.Integrante;
import srpauv.clases.Libro;
import srpauv.clases.Linea;
import srpauv.clases.MemoriaExtenso;
import srpauv.clases.ProduccionInnovadora;
import srpauv.clases.Producto;
import srpauv.clases.Prototipo;
import srpauv.clases.Tesis;

/**
 * FXML Controller class
 *
 * @author edson
 */
public class EditarProductoController implements Initializable {

    private static Integrante usuario;
    
    @FXML ListView<Producto> lstProductos;
    
    private List<Linea> listaLineas;
    
    private int flagProducto = 0;
    
    @FXML Button btnPollo;
    @FXML Label lblMensaje;
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
//CAMPOS DE PRODUCTOS-------------------------------------------------------------------------
    // <editor-fold defaultstate="collapsed" desc=" Campos Productos ">
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
    // </editor-fold>
//--------------------------------------------------------------------------------------------
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            llenarCombos();
        } catch (SQLException ex) {
            Logger.getLogger(EditarProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            recuperarProductosIntegrante();
        } catch (SQLException ex) {
            Logger.getLogger(EditarProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        lstProductos.setOnMouseClicked((event) -> {
            Producto prod = lstProductos.getSelectionModel().getSelectedItem();
            String tipoProd = lstProductos.getSelectionModel().getSelectedItem().getTipoProducto();
            MostrarProductos(tipoProd, prod);
        });
        
        btnGuardar.setOnAction((event) -> {
            Producto prod = lstProductos.getSelectionModel().getSelectedItem();
            
            switch(flagProducto){
                case 1:
                    guardarTesis(prod);                    
                    break;
                case 2:
                    guardarArticuloIndexado(prod);
                    break;
                case 3:
                    guardarArticuloArbitrado(prod);
                    break;
                case 4:
                    guardarArticulo(prod);
                    break;
                case 5:
                    guardarCapituloLibro(prod);
                    break;
                case 6:
                    guardarLibro(prod);
                    break;
                case 7:
                    guardarProduccionInnovadora(prod);
                    break;
                case 8:
                    guardarMemoriaExtenso(prod);
                    break;
                case 9:
                    guardarPrototipo(prod);
                    break;
            }
        });
    }  
    
    private void recuperarProductosIntegrante() throws SQLException {
        List<Producto> productos = ProductosDAO.recuperarPorIntegrante(usuario.getIdIntegrante());
        lstProductos.getItems().addAll(productos);
    }

    /**
     * @return the usuario
     */
    public static Integrante getUsuario() {
        return usuario;
    }

    /**
     * @param integrante the usuario to set
     */
    public static void setUsuario(Integrante integrante) {
        usuario = integrante;
    }
    
    private int seleccionarLgac(String lgac){
        int flag = -1;
        for(int x = 0; x < listaLineas.size(); x++){
            if(listaLineas.get(x).getNombre().equals(lgac)){
                flag = x;
            }
        }
        return flag;
    }
    
    private void MostrarProductos(String tipo, Producto producto){
        System.err.println(producto.getTipoProducto());
        boolean flag = true;
        if(tipo.equals("tesis")){
            flagProducto = 1;
            apnTesis.setVisible(true);
            Tesis tesis = (Tesis) producto;
            
            txtTituloTesis.setText(tesis.getTitulo()); 
            txtGradoTesis.setText(tesis.getGrado());
            txtNoAlumnosTesis.setText(String.valueOf(tesis.getNumAlumnos()));
            dtpFechaInicioTesis.setValue(tesis.getFechaInicio().toLocalDate());
            dtpFechaFinTesis.setValue(tesis.getFechaFin().toLocalDate());
            cbxLGACtesis.getSelectionModel().select(seleccionarLgac(tesis.getLgac()));
            chkCAtesis.setSelected(tesis.isConsiderarCA());
            
            flag = false;
        }else{
            apnTesis.setVisible(false);
        }
        if(tipo.equals("articuloIndexado")){
            flagProducto = 2;
            apnArticuloIndexado.setVisible(true);
            
            
            flag = false;
        }else{
            apnArticuloIndexado.setVisible(false);
        }
        if(tipo.equals("articuloArbitrado")){
            flagProducto = 3;
            apnArticuloArbitrado.setVisible(true);
            flag = false;
        }else{
            apnArticuloArbitrado.setVisible(false);
        }
        if(tipo.equals("articulo")){
            flagProducto = 4;
            apnArticulo.setVisible(true);
            Articulo prod = (Articulo) producto;
            
            txtautorarticulo.setText(prod.getAutor());
            txttituloarticulo.setText(prod.getAutor());
            txtnomrevistaarticulo.setText(prod.getNomrevista());
            txteditorialarticulo.setText(prod.getEditorial());
            txtpropositoarticulo.setText(prod.getProposito());
            txtissnarticulo.setText(prod.getIssn());
            txtvolarticulo.setText(prod.getVolumen());
            txtpagsarticulo.setText(prod.getPaginas());
            txtpaisarticulo.setText(prod.getPais());
            txtanoarticulo.setText(prod.getAno());
            txtedoactualarticulo.setText(prod.getEstado());
            cbxlgacarticulo.getSelectionModel().select(seleccionarLgac(prod.getLgac()));
            //txtadescarticulo.setText();
            chkcaarticulo.setSelected(prod.isConsiderarCA())
                    ;
            flag = false;
        }else{
            apnArticulo.setVisible(false);
        }
        if(tipo.equals("capituloLibro")){
            flagProducto = 5;
            apnCapituloLibro.setVisible(true);
            CapituloLibro prod = (CapituloLibro) producto;
            
            txtTituloCL.setText(prod.getTitulo());
            txtTituloLibroCL.setText(prod.getTituloLibro());
            txtEstadoActualCL.setText(prod.getEstado());
            txtISBNcl.setText(prod.getISBN());
            txtPropositoCL.setText(prod.getProposito());
            txtAutoresCL.setText(prod.getAutor_es());
            txtPaisCL.setText(prod.getPais());
            txtEditorialCL.setText(prod.getEditorial());
            txtNoEdicionesCL.setText(String.valueOf(prod.getNoEdiciones()));
            txtPaginasCL.setText(prod.getPaginas());
            txtTotalEjemplaresCL.setText(String.valueOf(prod.getTotalEjemplares()));
            txtAñoCL.setText(prod.getAño());
            cbxLGACcl.getSelectionModel().select(seleccionarLgac(prod.getLgac()));
            chkCAcl.setSelected(prod.isConsiderarCA());
            
            flag = false;
        }else{
            apnCapituloLibro.setVisible(false);
        }
        if(tipo.equals("libro")){
            flagProducto = 6;
            apnLibro.setVisible(true);
            Libro prod = (Libro) producto;
            
            txtTituloLibro.setText(prod.getTitulo());
            txtAutoresLibro.setText(prod.getAutor_es());
            txtISBNlibro.setText(prod.getISBN());
            txtPropositoLibro.setText(prod.getProposito());
            txtPaisLibro.setText(prod.getPais());
            txtEditorialLibro.setText(prod.getEditorial());
            txtNoEdicionesLibro.setText(String.valueOf(prod.getNoEdiciones()));
            txtEstadoActualLibro.setText(prod.getEstado());
            txtTotalEjemplaresLibro.setText(String.valueOf(prod.getTotalEjemplares()));
            txtAñoLibro.setText(prod.getAño());
            cbxLGAClibro.getSelectionModel().select(seleccionarLgac(prod.getLgac()));
            chkCAlibro.setSelected(prod.isConsiderarCA());
            
            flag = false;
        }else{
            apnLibro.setVisible(false);
        }
        if(tipo.equals("produccionInnovadora")){
            flagProducto = 7;
            apnProduccionInnovadora.setVisible(true);
            ProduccionInnovadora prod = (ProduccionInnovadora) producto;
            
            txttituloprod.setText(prod.getTitulo());
            txtparticipanteprod.setText(prod.getParticipante());
            txtclasifprod.setText(prod.getClasifinternacional());
            txtnumregprod.setText(String.valueOf(prod.getNumregistro()));
            txtpaisprod.setText(prod.getPais());
            txtpropositoprod.setText(prod.getProposito());
            txtadescprod.setText(prod.getDescripcion());
            dtpfechaprod.setValue(prod.getFechapub().toLocalDate());
            cbxlgacprod.getSelectionModel().select(seleccionarLgac(prod.getLgac()));
            chkcaprod.setSelected(prod.isConsiderarCA());
            
            flag = false;
        }else{
            apnProduccionInnovadora.setVisible(false);
        }
        if(tipo.equals("memoriaExtenso")){
            flagProducto = 8;
            apnMemoriaExtenso.setVisible(true);
            MemoriaExtenso prod = (MemoriaExtenso) producto;
            
            txtautormem.setText(prod.getAutor());
            txttitulopresmem.setText(prod.getTitulo());
            txtpagsmem.setText(prod.getRangopags());
            txtedomem.setText(prod.getEstadoG());
            txtpaismem.setText(prod.getPais());
            txtciudadmem.setText(prod.getCiudad());
            txtanomem.setText(prod.getAno());
            txtedoactualmem.setText(prod.getEstado());
            txtcongresomem.setText(prod.getCongreso());
            cbxlgacmem.getSelectionModel().select(seleccionarLgac(prod.getLgac()));
            txtapropositomem.setText(prod.getProposito());
            chkcamem.setSelected(prod.isConsiderarCA());
            
            flag = false;
        }else{
            apnMemoriaExtenso.setVisible(false);
        }
        if(tipo.equals("prototipo")){
            flagProducto = 9;
            apnPrototipo.setVisible(true);
            Prototipo prod = (Prototipo) producto;
            
            txtNombreProto.setText(prod.getTitulo());
            txtInstitucionCreadoraProto.setText(prod.getInstitucion());
            txtAñoProto.setText(prod.getAño());
            txtPaisProto.setText(prod.getPais());
            txtEstadoActualProto.setText(prod.getEstado());
            txaObjetivosProto.setText(prod.getObjetivos());
            txaCaracteristicasProto.setText(prod.getCaracteristicas());
            txaPropositoProto.setText(prod.getProposito());
            cbxLGACproto.getSelectionModel().select(seleccionarLgac(prod.getLgac()));
            chkCAproto.setSelected(prod.isConsiderarCA());
            
            flag = false;
        }else{
            apnPrototipo.setVisible(false);
        }
        if(flag){
            btnPollo.setVisible(flag);
            btnCancelar.setVisible(!flag);
            btnGuardar.setVisible(!flag);
            //btnAsociarProyecto.setVisible(!flag);
            //btnAgregarColaborador.setVisible(!flag);
        }else{
            btnPollo.setVisible(flag);
            btnGuardar.setVisible(!flag);
            //btnAsociarProyecto.setVisible(!flag);
            //btnAgregarColaborador.setVisible(!flag);
        }
    }
    
    private void llenarCombos() throws SQLException{
        listaLineas = LineaDAO.recuperarLineas();
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
    
    private void guardarTesis(Producto prod){
        
        String titulo = txtTituloTesis.getText();
        String grado = txtGradoTesis.getText();
        String numAlumnos = txtNoAlumnosTesis.getText();
        boolean ca = chkCAtesis.isSelected();
        LocalDate fechaInicio = dtpFechaInicioTesis.getValue();
        LocalDate fechaFin = dtpFechaFinTesis.getValue();
        
        
        try{
            String lgac = cbxLGACtesis.getSelectionModel().getSelectedItem().getNombre();
            
            if(titulo.isEmpty() || grado.isEmpty() || numAlumnos.isEmpty()){
                lblMensaje.setTextFill(Paint.valueOf("red"));
                lblMensaje.setText("Campos vacios"); 
            }else{
                if(fechaInicio == null || fechaFin == null){
                    lblMensaje.setTextFill(Paint.valueOf("red"));
                    lblMensaje.setText("Selecciona ambas fechas");
                }else{
                    Tesis tesis = (Tesis) prod;
                    tesis.setTitulo(titulo);                    
                    tesis.setGrado(grado);
                    tesis.setNumAlumnos(Integer.parseInt(numAlumnos));
                    tesis.setLgac(lgac);
                    tesis.setConsiderarCA(ca);
                    tesis.setFechaInicio(Date.valueOf(fechaInicio));
                    tesis.setFechaFin(Date.valueOf(fechaFin));
                    
                    if(tesis.actualizarProducto()== 0){
                        lblMensaje.setTextFill(Paint.valueOf("green"));
                        lblMensaje.setText("Producto Actualizado");
                    }
                }
            }
        }catch(NullPointerException ex){
            lblMensaje.setTextFill(Paint.valueOf("red"));
            lblMensaje.setText("Selecciona una LGAC");
        }
    }
    
    
    //Método que recupera y valida los campos de Articulo Indexado
    private void guardarArticuloIndexado(Producto prod){
        /**
         * Recopilación de datos de campos de texto
         */
        ArticuloIndexado articuloindexado = (ArticuloIndexado) prod;
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
                lblMensaje.setTextFill(Paint.valueOf("red"));
                lblMensaje.setText("Campos vacios"); 
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
                articuloindexado.setConsiderarCA(ca);     
                //articuloindexado.setProyectoAsociado(proySelec);
                
                if(articuloindexado.actualizarProducto()== 0){
                    lblMensaje.setTextFill(Paint.valueOf("green"));
                    lblMensaje.setText("Producto Actualizado");
                }
            }
        }catch(NullPointerException ex){
            lblMensaje.setTextFill(Paint.valueOf("red"));
            lblMensaje.setText("Selecciona una LGAC"); 
        }
        
    }
    
    //Método que recupera y valida los campos de Articulo Arbitrado
    private void guardarArticuloArbitrado(Producto prod){
        /**
         * Recopilación de datos de campos de texto
         */
        ArticuloArbitrado articuloarbitrado = (ArticuloArbitrado) prod;
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
             lblMensaje.setTextFill(Paint.valueOf("red"));
                lblMensaje.setText("Campos vacios"); 
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
                articuloarbitrado.setConsiderarCA(ca);  
                //articuloarbitrado.setProyectoAsociado(proySelec);
                
                if(articuloarbitrado.actualizarProducto()== 0){
                        lblMensaje.setTextFill(Paint.valueOf("green"));
                        lblMensaje.setText("Producto Actualizado");
                    }
                    
                }
        
            }catch(NullPointerException ex){
                lblMensaje.setTextFill(Paint.valueOf("red"));
            lblMensaje.setText("Selecciona una LGAC");
            }
}
    
    //Método que recupera y valida los campos de Articulo
    private void guardarArticulo(Producto prod){
        /**
         * Recopilación de datos de campos de texto
         */
        Articulo articulo = (Articulo) prod;
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
             lblMensaje.setTextFill(Paint.valueOf("red"));
                lblMensaje.setText("Campos vacios"); 
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
                    articulo.setConsiderarCA(ca);   
                    articulo.setProposito(proposito);
                    articulo.setIssn(issn);
                    //articulo.setProyectoAsociado(proySelec);
                    
                    if(articulo.actualizarProducto()== 0){
                        lblMensaje.setTextFill(Paint.valueOf("green"));
                        lblMensaje.setText("Producto Actualizado");
                    }

                }
        }catch(NullPointerException ex){
            lblMensaje.setTextFill(Paint.valueOf("red"));
            lblMensaje.setText("Selecciona una LGAC");
        }
        
}
    
    //Método que recupera y valida los campos de Cap de Libro
    private void guardarCapituloLibro(Producto prod){
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
                 lblMensaje.setTextFill(Paint.valueOf("red"));
                lblMensaje.setText("Campos vacios"); 
            }else{
                CapituloLibro capLib = (CapituloLibro) prod;
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
                //capLib.setProyectoAsociado(proySelec);
                
                if(capLib.actualizarProducto()== 0){
                        lblMensaje.setTextFill(Paint.valueOf("green"));
                        lblMensaje.setText("Producto Actualizado");
                    }
            }   
        }catch(NullPointerException ex){
            lblMensaje.setTextFill(Paint.valueOf("red"));
            lblMensaje.setText("Selecciona una LGAC");
        }
    }
    
    //Método que recupera y valida los campos de Libro
    private void guardarLibro(Producto prod){
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
                 lblMensaje.setTextFill(Paint.valueOf("red"));
                lblMensaje.setText("Campos vacios"); 
            }else{
                Libro libro = (Libro) prod;
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
                //libro.setProyectoAsociado(proySelec);
                
                if(libro.actualizarProducto()== 0){
                        lblMensaje.setTextFill(Paint.valueOf("green"));
                        lblMensaje.setText("Producto Actualizado");
                    }
            }
        }catch(NullPointerException ex){
            lblMensaje.setTextFill(Paint.valueOf("red"));
            lblMensaje.setText("Selecciona una LGAC");
        }
    }
    
    //Método que recupera y valida los campos de Prod Innov
    private void guardarProduccionInnovadora(Producto prod){
        /**
         * Recopilación de datos de campos de texto
         */
        ProduccionInnovadora produccioninnovadora = (ProduccionInnovadora) prod;
        String titulo = txttituloprod.getText();
        String participante = txtparticipanteprod.getText();
        String clasifinter = txtclasifprod.getText();
        String numreg = txtnumregprod.getText();
        LocalDate fecha = dtpfechaprod.getValue();
        String proposito = txtpropositoprod.getText();
        String pais = txtpaisprod.getText();
        
        boolean ca = chkcaindexado.isSelected();
        /**
         * Validación de campos vacíos
         */
        try{
            String lgac = cbxlgacprod.getSelectionModel().getSelectedItem().getNombre();
            if(titulo.isEmpty() || participante.isEmpty() || clasifinter.isEmpty() || numreg.isEmpty()
                || proposito.isEmpty() || fecha == null){
             lblMensaje.setTextFill(Paint.valueOf("red"));
                lblMensaje.setText("Campos vacios"); 
            }else{

                        produccioninnovadora.setTitulo(titulo);          
                        produccioninnovadora.setParticipante(participante); 
                        produccioninnovadora.setClasifinternacional(clasifinter); 
                        produccioninnovadora.setNumregistro(numreg); 
                        produccioninnovadora.setFechapub(Date.valueOf(fecha));
                        produccioninnovadora.setPais(pais);
                        produccioninnovadora.setLgac(lgac);
                        produccioninnovadora.setConsiderarCA(ca);  
                        //produccioninnovadora.setProyectoAsociado(proySelec);
                        
                        if(produccioninnovadora.actualizarProducto()== 0){
                        lblMensaje.setTextFill(Paint.valueOf("green"));
                        lblMensaje.setText("Producto Actualizado");
                    }

                }
        }catch(NullPointerException ex){
            lblMensaje.setTextFill(Paint.valueOf("red"));
            lblMensaje.setText("Selecciona una LGAC");
        }
        
}
   
    //Método que recupera y valida los campos de Memoria en extenso
    private void guardarMemoriaExtenso(Producto prod){
        /**
         * Recopilación de datos de campos de texto
         */
        MemoriaExtenso memoriaextenso = (MemoriaExtenso)prod;
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
             lblMensaje.setTextFill(Paint.valueOf("red"));
                lblMensaje.setText("Campos vacios"); 
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
                    memoriaextenso.setConsiderarCA(ca);  
                   // memoriaextenso.setProyectoAsociado(proySelec);
                    
                    if(memoriaextenso.actualizarProducto()== 0){
                        lblMensaje.setTextFill(Paint.valueOf("green"));
                        lblMensaje.setText("Producto Actualizado");
                    }
                }
        }catch(NullPointerException ex){
            lblMensaje.setTextFill(Paint.valueOf("red"));
            lblMensaje.setText("Selecciona una LGAC");
        }
        
            
}
    
    //Método que recupera y valida los campos de Prototipo
    private void guardarPrototipo(Producto prod){
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
                 lblMensaje.setTextFill(Paint.valueOf("red"));
                lblMensaje.setText("Campos vacios"); 
            }else{
                Prototipo proto = (Prototipo) prod;
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
                //proto.setProyectoAsociado(proySelec);
                
                if(proto.actualizarProducto()== 0){
                        lblMensaje.setTextFill(Paint.valueOf("green"));
                        lblMensaje.setText("Producto Actualizado");
                    }
            }
        }catch(NullPointerException ex){
            lblMensaje.setTextFill(Paint.valueOf("red"));
            lblMensaje.setText("Selecciona una LGAC");
        }
    }
}

// <editor-fold defaultstate="collapsed" desc="">
// </editor-fold>