/*
 * Proyecto creado con propósitos educativos en la Facultad de  
 *  Estadística e Informática de la Universidad Veracruzana.
 * Código libre.
 */
package srpauv.controlador;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import srpauv.clases.OpcionesCampos;
import srpauv.clases.Integrante;
import DAO.DatosLaboralesDAO;
import DAO.IntegranteDAO;
import DAO.EstudiosRealizadosDAO;
import java.sql.Date;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import srpauv.clases.DatosLaborales;
import srpauv.clases.EstudiosRealizados;

/**
 * FXML Controller class
 *
 * @author J. Rodrigo Ordóñez Pacheco
 */
public class MiPerfilController implements Initializable {
    OpcionesCampos opciones = new OpcionesCampos();
    Integrante integrante;
    DatosLaborales datoslaborales;
    ObservableList<EstudiosRealizados> estudios;
    EstudiosRealizados estudioSeleccionado;
    int indicadorDP=0;
    int indicadorFP=0;
    int indicadorDL=0;
    boolean modificarFP = false;
    //PANELES MI PERFIL---------------------------------------------------------
    @FXML AnchorPane apnVentanaMiPerfil;
    @FXML AnchorPane apnBannerMiPerfil;
    @FXML AnchorPane apnSeccionesPerfil;
    @FXML Pane pneDatosPersonales;
    @FXML Pane pneDatosLaborales;
    @FXML Pane pneFormacionProfesional;
    //CAMPOS DATOS PERSONALES---------------------------------------------------
    // <editor-fold defaultstate="collapsed" desc=" Componentes FXML de Datos Personales ">
    @FXML
    TextField txtNoPersonal;
    @FXML
    TextField txtNombre;
    @FXML
    TextField txtApellidoPaterno;
    @FXML
    TextField txtApellidoMaterno;
    @FXML
    TextField txtRfc;
    @FXML
    TextField txtCurp;
    @FXML
    TextField txtTelCasa;
    @FXML
    TextField txtTelTrabajo;
    @FXML
    TextField txtTelCelular;
    @FXML
    TextField txtCorreoUv;
    @FXML
    TextField txtCorreoAdicional;
    @FXML
    TextField txtFechaNacimiento;    
    @FXML
    ComboBox cbxGenero;
    @FXML
    ComboBox cbxEdoCivil;
    @FXML
    ComboBox cbxNacionalidad;
    @FXML
    ComboBox cbxArea;
    @FXML
    ComboBox cbxDisciplina;
    //@FXML ComboBox cbxIESA;
    @FXML
    DatePicker dtpFechaNacimiento;    
    @FXML
    Button btnActualizarDP;
    @FXML
    Button btnCancelarDP;
    @FXML
    Button btnGuardarDP;
    @FXML
    Label lblAvisosDatosPersonales;

// </editor-fold>
    //CAMPOS DATOS LABORALES----------------------------------------------------
    // <editor-fold defaultstate="collapsed" desc=" Componentes FXML de Datos Laborales ">
    @FXML
    TextField txtNombramiento;
    @FXML
    TextField txtDes;
    @FXML
    TextField txtUnidadAcademica;
    @FXML
    TextField txtProgramaEducativo;
    @FXML
    TextField txtNivelSNI;
    @FXML
    TextField txtContratoPTC;
    @FXML
    TextField txtFechaIngresoUV;
    @FXML
    ComboBox cbxDES;
    @FXML
    ComboBox cbxUnidadAcademica;
    @FXML
    ComboBox cbxProgramaEducativo;
    @FXML
    ComboBox cbxNivelSni;
    @FXML
    ComboBox cbxContratoPtc;
    @FXML
    DatePicker dtpFechaIngresoUv;
    @FXML
    Button btnActualizarDL;
    @FXML
    Button btnCancelarDL;
    @FXML
    Button btnGuardarDL;
    @FXML
    Label lblAvisosDL;

// </editor-fold>
    //CAMPOS FORMACION PERSONAL-------------------------------------------------
    // <editor-fold defaultstate="collapsed" desc=" Componentes FXML de Estudios Realizados ">
    @FXML
    Label lblAvisosFP;
    //Tabla ESTUDIOS REALIZADOS-------------------------------------------------
    @FXML
    TableView<EstudiosRealizados> tbvFormacionProfesional = new TableView<EstudiosRealizados>();
    @FXML
    TableColumn tbcGrado;
    @FXML
    TableColumn tbcEstudiosEn;
    @FXML
    TableColumn tbcFechaObtencion;
    @FXML
    TableColumn tbcInstitucionOtorgante;
    //CAMPOS REGISTRAR ESTUDIOS--------------------------------------------------
    @FXML
    Label lblNivelEstudiosFP;
    @FXML
    Label lblEstudiosEnFP;
    @FXML
    Label lblAreaFP;
    @FXML
    Label lblDisciplinaFP;
    @FXML
    Label lblInstitucionFP;
    @FXML
    Label lblOtraFP;
    @FXML
    Label lblFechaInicioFP;
    @FXML
    Label lblFechaTerminoFP;
    @FXML
    Label lblFechaObtencionFP;
    @FXML
    Label lblPaisFP;
    
    @FXML
    TextField txtOtraInstitucion;
    @FXML
    TextField txtEstudiosEn;
    @FXML
    ComboBox cbxNivelEstudios;
    @FXML
    ComboBox cbxAreaFP;
    @FXML
    ComboBox cbxDisciplinaFP;
    @FXML
    ComboBox cbxInstitucionOtorgante;
    @FXML
    ComboBox cbxPaisFP;
    @FXML
    DatePicker dtpFechaInicio;
    @FXML
    DatePicker dtpFechaTermino;
    @FXML
    DatePicker dtpFechaObtencionGrado;
    @FXML
    Button btnActualizarFP;
    @FXML
    Button btnAnadirFP;
    @FXML
    Button btnCancelarFP;
    @FXML
    Button btnGuardarFP;

// </editor-fold>
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        llenarOpcionesComboBox();
        // <editor-fold defaultstate="collapsed" desc=" Consultas: Integrante, DatosLaborales y EstudiosRealizados ">
        try {
            integrante = DAO.IntegranteDAO.getDatosIntegrante(4);
            datoslaborales = DAO.DatosLaboralesDAO.getDatosLaborales(4);
            estudios = DAO.EstudiosRealizadosDAO.getEstudiosRealizados(4);
        } catch (SQLException ex) {
            lblAvisosDatosPersonales.setText("Error en la conexión con la Base de datos");
            System.out.println(ex.getMessage());
        } catch (NullPointerException ex) {
            lblAvisosDatosPersonales.setText("Error en la conexión con la Base de datos");
            System.out.println(ex.getMessage());
        }

// </editor-fold>

       // Llenando campos con datos recuperados y deshabilitando la edición de los campos
        llenarCamposDatosPersonales(integrante);
        System.out.println(datoslaborales.getNombramiento());
        llenarCamposDatosLaborales(datoslaborales);
        llenarCamposFormacionProfesional(estudios);
        
        //ACTUALIZAR DATOS PERSONALES-------------------------------------------
        // <editor-fold defaultstate="collapsed" desc=" BtnActualizarDP onAction ">
        btnActualizarDP.setOnAction((ActionEvent event) -> {
            manipularCamposDatosPersonales();
            lblAvisosDatosPersonales.setText("");
            
        });

// </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc=" BtnGuardarDP onAction ">
        btnGuardarDP.setOnAction((ActionEvent event) -> {
            
            if (validarCamposDatosPersonales()) {
                lblAvisosDatosPersonales.setText("Datos actualizados con éxito");
                try {
                    integrante = IntegranteDAO.getDatosIntegrante(this.integrante.getIdIntegrante());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    
                }
                llenarCamposDatosPersonales(integrante);
                manipularCamposDatosPersonales();
                btnGuardarDP.setVisible(false);
                btnCancelarDP.setVisible(false);
                btnActualizarDP.setDisable(false);
            } else {
                lblAvisosDatosPersonales.setText("Campos obligatorios vacíos, favor de acompletarlos");
            }
            
        });

// </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc=" BtnCancelarDP onAction ">
        btnCancelarDP.setOnAction((ActionEvent event) -> {
            btnGuardarDP.setVisible(false);
            btnCancelarDP.setVisible(false);
            manipularCamposDatosPersonales();
            btnActualizarDP.setDisable(false);
            lblAvisosDatosPersonales.setText("");
            
        });

// </editor-fold>
        //TERMINA ACTUALIZAR DATOS PERSONALES-----------------------------------
        
        
        // SECCIÓN AÑADIR NUEVO GRADO DE ESTUDIO-------------------------------
        // <editor-fold defaultstate="collapsed" desc=" BtnAñadirFP onAction">
        btnAnadirFP.setOnAction((ActionEvent event) -> {
            System.out.println("Boton presionado");
            manipularCamposFormacionProfesional();
            lblAvisosFP.setText("");            
        });

// </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc=" BtnGuardarFP onAction">
        btnGuardarFP.setOnAction((ActionEvent event) -> {
            if(modificarFP){
                System.out.println("Modificar FP:" +modificarFP);
                if(validarCamposRegistrarEstudios()){
                    lblAvisosFP.setText("Datos actualizados con éxito");
                    manipularCamposFormacionProfesional();
                    try {
                        estudios = EstudiosRealizadosDAO.getEstudiosRealizados(this.integrante.getIdIntegrante());

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } finally {
                        llenarCamposFormacionProfesional(estudios);
                    }
                }else{
                    lblAvisosFP.setText("Campos obligatorios vacíos, favor de acompletarlos");
                }
                modificarFP = false;
            }else{
                if (validarCamposRegistrarEstudios()) {
                lblAvisosFP.setText("Estudios registrados con éxito");
                manipularCamposFormacionProfesional();
                    try {
                        estudios = EstudiosRealizadosDAO.getEstudiosRealizados(this.integrante.getIdIntegrante());

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } finally {
                        llenarCamposFormacionProfesional(estudios);
                    }
                } else {
                    lblAvisosFP.setText("Campos obligatorios vacíos, favor de acompletarlos");
                }
            }
            
        });

// </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc=" BtnCancelarFP onAction ">
        btnCancelarFP.setOnAction((ActionEvent event) -> {
            manipularCamposFormacionProfesional();
            lblAvisosFP.setText("");
            if(modificarFP){
                modificarFP=false;
            }
        });

// </editor-fold>
        //TERMINA AÑADIR NUEVO GRADO DE ESTUDIO--------------------------------
        
        //SECCIÓN MODIFICAR GRADO DE ESTUDIO------------------------------------
        
        // <editor-fold defaultstate="collapsed" desc=" BtnActualizarFp onAction ">
        btnActualizarFP.setOnAction((ActionEvent event) -> {
            estudioSeleccionado = (EstudiosRealizados) tbvFormacionProfesional.getSelectionModel().getSelectedItem();
            lblAvisosFP.setText("");
            indicadorFP = 2;
            modificarFP = true;
            manipularCamposFormacionProfesional();
        });

// </editor-fold>
        
        //TERMINA SECCIÓN MODIFICAR GRADO DE ESTUDIO----------------------------
        
        //SECCIÓN ACTUALIZAR DATOS LABORALES------------------------------------
        
        btnActualizarDL.setOnAction((ActionEvent event)->{
            btnActualizarDL.setVisible(false);
            btnGuardarDL.setVisible(true);
            btnCancelarDL.setVisible(true);
            manipularCamposDatosLaborales();
            lblAvisosDL.setText("");
            
        });
        
        btnCancelarDL.setOnAction((ActionEvent event)->{
            btnActualizarDL.setVisible(true);
            btnGuardarDL.setVisible(false);
            btnCancelarDL.setVisible(false);
            manipularCamposDatosLaborales();
        });
        
        btnGuardarDL.setOnAction((ActionEvent event) -> {
            if(validarCamposDatosLaborales()){
                lblAvisosDL.setText("Datos Actualizados con éxito");
                try{
                    datoslaborales = DatosLaboralesDAO.getDatosLaborales(integrante.getIdIntegrante());
                }catch(SQLException ex){
                    ex.printStackTrace();
                }
                llenarCamposDatosLaborales(datoslaborales);
                manipularCamposDatosLaborales();
                btnCancelarDL.setVisible(false);
                btnGuardarDL.setVisible(false);
                btnActualizarDL.setVisible(true);
                btnActualizarDL.setDisable(false);
                
            }else{
                lblAvisosDL.setText("Campos obligatorios vacíos, favor de completarlos");
            }
        });
        //TERMINA SECCIÓN ACTUALIZAR DATOS LABORALES----------------------------
    }    
    
    private void llenarOpcionesComboBox(){
        for(int x=0; x<opciones.getOpcionesCbxGenero().size(); x++){
            cbxGenero.getItems().add(opciones.getOpcionesCbxGenero().get(x));
        }
        for(int x=0; x<opciones.getOpcionesCbxEdocivil().size(); x++){
            cbxEdoCivil.getItems().add(opciones.getOpcionesCbxEdocivil().get(x));
        }
        for(int x=0; x<opciones.getOpcionesCbxNacionalidad().size(); x++){
            cbxNacionalidad.getItems().add(opciones.getOpcionesCbxNacionalidad().get(x));
        }
        for(int x=0; x<opciones.getOpcionesCbxArea().size(); x++){
            cbxArea.getItems().add(opciones.getOpcionesCbxArea().get(x));
            cbxAreaFP.getItems().add(opciones.getOpcionesCbxArea().get(x));
            
        }
        for(int x=0; x<opciones.getOpcionesCbxDisciplina().size(); x++){
            cbxDisciplina.getItems().add(opciones.getOpcionesCbxDisciplina().get(x));
            cbxDisciplinaFP.getItems().add(opciones.getOpcionesCbxDisciplina().get(x));
        }
        for(int x=0; x<opciones.getOpcionesCbxInstitucion().size(); x++){
            //cbxIESA.getItems().add(opciones.getOpcionesCbxInstitucion().get(x));
            cbxInstitucionOtorgante.getItems().add(opciones.getOpcionesCbxInstitucion().get(x));
        }
        for(int x=0; x<opciones.getOpcionesCbxSNI().size(); x++){
            cbxNivelSni.getItems().add(opciones.getOpcionesCbxSNI().get(x));
        }
        for(int x=0; x<opciones.getOpcionesCbxUnidadA().size(); x++){
            cbxUnidadAcademica.getItems().add(opciones.getOpcionesCbxUnidadA().get(x));
        }
        for(int x=0; x<opciones.getOpcionesCbxPrograma().size(); x++){
            cbxProgramaEducativo.getItems().add(opciones.getOpcionesCbxPrograma().get(x));
        }
        for(int x=0; x<opciones.getOpcionesCbxPTC().size(); x++){
            cbxContratoPtc.getItems().add(opciones.getOpcionesCbxPTC().get(x));
        }
        for(int x=0; x<opciones.getOpcionesCbxNivelEstudios().size(); x++){
            cbxNivelEstudios.getItems().add(opciones.getOpcionesCbxNivelEstudios().get(x));
        }
        for(int x=0; x<opciones.getOpcionesCbxPais().size(); x++){
            cbxPaisFP.getItems().add(opciones.getOpcionesCbxPais().get(x));
        }
        for(int x=0; x<opciones.getOpcionesCbxDes().size(); x++){
            cbxDES.getItems().add(opciones.getOpcionesCbxDes().get(x));
        }
    }
    
    private void llenarCamposDatosPersonales(Integrante integrante){
        
        this.txtNoPersonal.setText(integrante.getNoPersonal());
        this.txtNoPersonal.setDisable(true);
        
        this.txtNombre.setText(integrante.getNombre());
        this.txtNombre.setDisable(true);
        
        this.txtApellidoPaterno.setText(integrante.getApellidoP());
        this.txtApellidoPaterno.setDisable(true);
        
        this.txtApellidoMaterno.setText(integrante.getApellidoM());
        this.txtApellidoMaterno.setDisable(true);
        
        this.cbxGenero.setPromptText(integrante.getGenero());
        this.cbxGenero.getSelectionModel().select(integrante.getGenero());
        this.cbxGenero.setDisable(true);       
        
        this.cbxEdoCivil.setPromptText(integrante.getEstadoCivil());
        this.cbxEdoCivil.getSelectionModel().select(integrante.getEstadoCivil());
        this.cbxEdoCivil.setDisable(true);
        
        this.txtRfc.setText(integrante.getRfc());
        this.txtRfc.setDisable(true);
        
        this.txtCurp.setText(integrante.getCURP());
        this.txtCurp.setDisable(true);
        
        this.txtTelCasa.setText(integrante.getTelefonoCasa());
        this.txtTelCasa.setDisable(true);
        
        this.txtTelTrabajo.setText(integrante.getTelefonoTrabajo());
        this.txtTelTrabajo.setDisable(true);
        
        this.cbxNacionalidad.setPromptText(integrante.getNacionalidad());
        this.cbxNacionalidad.setDisable(true);

        if(integrante.getFechanacimiento().toString().equals("1111-11-11")){
            this.txtFechaNacimiento.setText("");
        } else{
            this.txtFechaNacimiento.setText(integrante.getFechanacimiento().toString());
        }
        this.txtFechaNacimiento.setDisable(true);
        
        this.txtCorreoUv.setText(integrante.getCorreoUV());
        this.txtCorreoUv.setDisable(true);
        
        this.txtCorreoAdicional.setText(integrante.getCorreoAdicional());
        this.txtCorreoAdicional.setDisable(true);
        
        this.cbxArea.setPromptText(integrante.getArea());
        this.cbxArea.getSelectionModel().select(integrante.getArea());
        this.cbxArea.setDisable(true);
        
        this.cbxDisciplina.setPromptText(integrante.getDisciplina());
        this.cbxDisciplina.getSelectionModel().select(integrante.getDisciplina());
        this.cbxDisciplina.setDisable(true);
        
        
    }
    
    private void manipularCamposDatosPersonales(){
        if(indicadorDP==0){
            //Habilitar Campos Datos Personales para edición--------------------
            this.txtNoPersonal.setDisable(true); 
            this.txtNombre.setDisable(false); 
            this.txtApellidoPaterno.setDisable(false);          
            this.txtApellidoMaterno.setDisable(false);            
            this.cbxEdoCivil.setPromptText(integrante.getEstadoCivil());
            this.cbxEdoCivil.setVisible(true);
            this.cbxEdoCivil.setDisable(false);         
            this.txtRfc.setDisable(false);           
            this.txtCurp.setDisable(false);         
            this.txtTelCasa.setDisable(false);          
            this.txtTelTrabajo.setDisable(false);
            this.cbxNacionalidad.setPromptText(integrante.getNacionalidad());
            this.cbxNacionalidad.setDisable(true);                                
            this.txtFechaNacimiento.setDisable(true);            
            this.txtCorreoUv.setDisable(false);           
            this.txtCorreoAdicional.setDisable(false);
            this.cbxArea.setPromptText(integrante.getArea());
            this.cbxArea.setDisable(false);           
            this.cbxDisciplina.setPromptText(integrante.getDisciplina());
            this.cbxDisciplina.setDisable(false);
            
            //Habilitar Botones Guardar y Cancelar DP---------------------------
            this.btnGuardarDP.setVisible(true);
            this.btnCancelarDP.setVisible(true);
            this.btnActualizarDP.setDisable(true);
            indicadorDP=1;
            
        }else{
            //Deshabilitando campos Datos Personales----------------------------
            this.txtNoPersonal.setDisable(true); 
            this.txtNombre.setDisable(true); 
            this.txtApellidoPaterno.setDisable(true);          
            this.txtApellidoMaterno.setDisable(true);            
            this.cbxEdoCivil.setPromptText(integrante.getEstadoCivil());
            this.cbxEdoCivil.setDisable(true);         
            this.txtRfc.setDisable(true);           
            this.txtCurp.setDisable(true);         
            this.txtTelCasa.setDisable(true);          
            this.txtTelTrabajo.setDisable(true);
            this.cbxNacionalidad.setPromptText(integrante.getNacionalidad());
            this.cbxNacionalidad.setDisable(true);                                
            this.txtFechaNacimiento.setDisable(true);            
            this.txtCorreoUv.setDisable(true);           
            this.txtCorreoAdicional.setDisable(true);
            this.cbxArea.setPromptText(integrante.getArea());
            this.cbxArea.setDisable(true);           
            this.cbxDisciplina.setPromptText(integrante.getDisciplina());
            this.cbxDisciplina.setDisable(true);
            //Dehabilitando botones Guardar y Cancelar DP-----------------------
            this.btnGuardarDP.setVisible(false);
            this.btnCancelarDP.setVisible(false);
            this.btnActualizarDP.setDisable(false);
            indicadorDP=0;
        }
        
    }
    
    private void llenarCamposDatosLaborales(DatosLaborales datoslaborales){
        this.txtNombramiento.setText(datoslaborales.getNombramiento());
        this.txtNombramiento.setDisable(true);
        System.out.println(datoslaborales.getNombramiento());
        this.txtDes.setText(datoslaborales.getDes());
        this.txtDes.setDisable(true);
        this.cbxDES.getSelectionModel().select(datoslaborales.getDes());
       
        
        this.cbxUnidadAcademica.setPromptText(datoslaborales.getUnidadAcademica());
        this.cbxUnidadAcademica.getSelectionModel().select(datoslaborales.getUnidadAcademica());
        this.txtUnidadAcademica.setText(datoslaborales.getUnidadAcademica());
        this.txtUnidadAcademica.setDisable(true);
        
        this.txtFechaIngresoUV.setText(datoslaborales.getFechaIngresoUV().toString());
        this.txtFechaIngresoUV.setDisable(true);
        
        this.cbxProgramaEducativo.setPromptText(datoslaborales.getProgramaEducativo());
        this.cbxProgramaEducativo.getSelectionModel().select(datoslaborales.getProgramaEducativo());
        this.txtProgramaEducativo.setText(datoslaborales.getProgramaEducativo());
        this.txtProgramaEducativo.setDisable(true);
        
        this.cbxNivelSni.setPromptText(datoslaborales.getNivelSNI());
        this.cbxNivelSni.getSelectionModel().select(datoslaborales.getNivelSNI());
        this.txtNivelSNI.setText(datoslaborales.getNivelSNI());
        this.txtNivelSNI.setDisable(true);
        
        if(datoslaborales.getContratoPTC()){
            this.cbxContratoPtc.setPromptText("Sí");
            this.cbxContratoPtc.getSelectionModel().select("Sí");            
            this.txtContratoPTC.setText("Sí");
            this.txtContratoPTC.setDisable(true);
        }else{
            this.cbxContratoPtc.setPromptText("No");
            this.cbxContratoPtc.getSelectionModel().select("No"); 
            this.txtContratoPTC.setText("No");
            this.txtContratoPTC.setDisable(true);
        }
        
    }
    
    private void llenarCamposFormacionProfesional(ObservableList<EstudiosRealizados> estudios){
        //System.out.println(estudios.get(0).getGrado());
        //System.out.println(estudios.get(1).getGrado());
        tbcGrado.setCellValueFactory( new PropertyValueFactory<EstudiosRealizados, String>("grado"));
        tbcEstudiosEn.setCellValueFactory( new PropertyValueFactory<EstudiosRealizados, String>("estudiosEn"));
        tbcFechaObtencion.setCellValueFactory( new PropertyValueFactory<EstudiosRealizados, String>("fechaObtencionTitulo"));
        tbcInstitucionOtorgante.setCellValueFactory( new PropertyValueFactory<EstudiosRealizados, String>("institucionOtorgante"));
        tbvFormacionProfesional.setItems((ObservableList) estudios);
        //tbvFormacionProfesional.getColumns().addAll(tbcGrado, tbcEstudiosEn, tbcFechaObtencion, tbcInstitucionOtorgante);
        
    }
    
    private void manipularCamposFormacionProfesional(){
        if(indicadorFP == 0){
            System.out.println("Primer if Indicador es :" + indicadorFP);
            this.lblNivelEstudiosFP.setVisible(true);
            this.lblEstudiosEnFP.setVisible(true);
            this.lblAreaFP.setVisible(true);
            this.lblDisciplinaFP.setVisible(true);
            this.lblInstitucionFP.setVisible(true);
            //this.lblOtraFP.setVisible(true);
            this.lblFechaInicioFP.setVisible(true);
            this.lblFechaTerminoFP.setVisible(true);
            this.lblFechaObtencionFP.setVisible(true);
            this.lblPaisFP.setVisible(true);
            
            //this.txtOtraInstitucion.setVisible(true);
            this.txtEstudiosEn.setVisible(true);
            this.txtEstudiosEn.setText("");
            
            this.cbxNivelEstudios.setVisible(true);
            this.cbxNivelEstudios.setPromptText("");
            this.cbxNivelEstudios.getSelectionModel().clearSelection();
            
            this.cbxAreaFP.setVisible(true);
            this.cbxAreaFP.setPromptText("");
            this.cbxAreaFP.getSelectionModel().clearSelection();
            
            this.cbxDisciplinaFP.setVisible(true);
            this.cbxDisciplinaFP.setPromptText("");
            this.cbxDisciplinaFP.getSelectionModel().clearSelection();
            
            this.cbxInstitucionOtorgante.setVisible(true);
            this.cbxInstitucionOtorgante.setPromptText("");
            this.cbxInstitucionOtorgante.getSelectionModel().clearSelection();
            
            this.cbxPaisFP.setVisible(true);
            this.cbxPaisFP.setPromptText("");
            this.cbxPaisFP.getSelectionModel().clearSelection();
            
            this.dtpFechaInicio.setVisible(true);
            this.dtpFechaInicio.setValue(null);
            this.dtpFechaTermino.setVisible(true);
            this.dtpFechaTermino.setValue(null);
            this.dtpFechaObtencionGrado.setVisible(true);
            this.dtpFechaObtencionGrado.setValue(null);
            
            btnGuardarFP.setVisible(true);
            btnCancelarFP.setVisible(true);
            btnAnadirFP.setVisible(false);
            btnActualizarFP.setVisible(false);
            
            this.tbvFormacionProfesional.setVisible(false);
            indicadorFP=1;
            System.out.println("Primer if Indicador es :" + indicadorFP);
            return;
        }
        if(indicadorFP==1){
            System.out.println("Segundo if Indicador es :" + indicadorFP);
            this.lblNivelEstudiosFP.setVisible(false);
            this.lblEstudiosEnFP.setVisible(false);
            this.lblAreaFP.setVisible(false);
            this.lblDisciplinaFP.setVisible(false);
            this.lblInstitucionFP.setVisible(false);
            //this.lblOtraFP.setVisible(false);
            this.lblFechaInicioFP.setVisible(false);
            this.lblFechaTerminoFP.setVisible(false);
            this.lblFechaObtencionFP.setVisible(false);
            this.lblPaisFP.setVisible(false);
            
            //this.txtOtraInstitucion.setVisible(false);
            this.txtEstudiosEn.setVisible(false);
            this.cbxNivelEstudios.setVisible(false);
            this.cbxAreaFP.setVisible(false);
            this.cbxDisciplinaFP.setVisible(false);
            this.cbxInstitucionOtorgante.setVisible(false);
            this.cbxPaisFP.setVisible(false);
            this.dtpFechaInicio.setVisible(false);
            this.dtpFechaTermino.setVisible(false);
            this.dtpFechaObtencionGrado.setVisible(false);
            
            btnGuardarFP.setVisible(false);
            btnCancelarFP.setVisible(false);
            btnAnadirFP.setVisible(true);
            btnActualizarFP.setVisible(true);
            
            this.tbvFormacionProfesional.setVisible(true);
            indicadorFP=0;
            System.out.println("Indicador es :" + indicadorFP);
            return;
        }
        
        if(indicadorFP==2){
            System.out.println("Indicador es :" + indicadorFP);
            this.lblNivelEstudiosFP.setVisible(true);
            this.lblEstudiosEnFP.setVisible(true);
            this.lblAreaFP.setVisible(true);
            this.lblDisciplinaFP.setVisible(true);
            this.lblInstitucionFP.setVisible(true);
            //this.lblOtraFP.setVisible(true);
            this.lblFechaInicioFP.setVisible(true);
            this.lblFechaTerminoFP.setVisible(true);
            this.lblFechaObtencionFP.setVisible(true);
            this.lblPaisFP.setVisible(true);
            
            //this.txtOtraInstitucion.setVisible(true);
            this.txtEstudiosEn.setVisible(true);
            this.txtEstudiosEn.setText(estudioSeleccionado.getEstudiosEn());
            this.cbxNivelEstudios.setVisible(true);
            this.cbxNivelEstudios.getSelectionModel().select(estudioSeleccionado.getGrado());
            this.cbxAreaFP.setVisible(true);
            this.cbxAreaFP.getSelectionModel().select(estudioSeleccionado.getArea());
            this.cbxDisciplinaFP.setVisible(true);
            this.cbxDisciplinaFP.getSelectionModel().select(estudioSeleccionado.getDisciplina());
            this.cbxInstitucionOtorgante.setVisible(true);
            this.cbxInstitucionOtorgante.getSelectionModel().select(estudioSeleccionado.getInstitucionOtorgante());
            this.cbxPaisFP.setVisible(true);
            this.cbxPaisFP.getSelectionModel().select(estudioSeleccionado.getPais());
            this.dtpFechaInicio.setVisible(true);
            this.dtpFechaInicio.setValue(estudioSeleccionado.getFechaInicio().toLocalDate());
            this.dtpFechaTermino.setVisible(true);
            this.dtpFechaTermino.setValue(estudioSeleccionado.getFechaFin().toLocalDate());
            this.dtpFechaObtencionGrado.setVisible(true);
            this.dtpFechaObtencionGrado.setValue(estudioSeleccionado.getFechaObtencionTitulo().toLocalDate());
            
            btnGuardarFP.setVisible(true);
            btnCancelarFP.setVisible(true);
            btnAnadirFP.setVisible(false);
            btnActualizarFP.setVisible(false);
            
            this.tbvFormacionProfesional.setVisible(false);
            indicadorFP=1;
            System.out.println("Indicador es :" + indicadorFP);
            return;
        }
    }
           
    private boolean validarCamposDatosPersonales(){
        boolean flag = false;
        if(txtNoPersonal.getText().equals("")||
                txtNombre.getText().equals("")||
                txtApellidoPaterno.getText().equals("")||
                txtApellidoMaterno.getText().equals("")||
                txtRfc.getText().equals("") ||
                txtCurp.getText().equals("")||
                txtCorreoUv.getText().equals("")||
                txtCorreoAdicional.getText().equals("")||
                txtTelCasa.getText().equals("")||
                txtTelTrabajo.getText().equals("")){
            return flag = false;     
        }else{
            actualizarDatosPersonales();
            return flag = true;
        }
    }
    
    private boolean actualizarDatosPersonales(){
        boolean flag=false;
        Integrante integranteActualizado = integrante;
        integranteActualizado.setNombre(this.txtNombre.getText());
        integranteActualizado.setApellidoP(this.txtApellidoPaterno.getText());
        integranteActualizado.setApellidoM(this.txtApellidoMaterno.getText());
        integranteActualizado.setTelefonoCasa(this.txtTelCasa.getText());
        integranteActualizado.setTelefonoTrabajo(this.txtTelTrabajo.getText());
        integranteActualizado.setEstadoCivil(this.cbxEdoCivil.getSelectionModel().getSelectedItem().toString());
        integranteActualizado.setRfc(this.txtRfc.getText());
        integranteActualizado.setCURP(this.txtCurp.getText());
        integranteActualizado.setCorreoAdicional(this.txtCorreoAdicional.getText());
        integranteActualizado.setCorreoUV(this.txtCorreoUv.getText());
        integranteActualizado.setArea(this.cbxArea.getSelectionModel().getSelectedItem().toString());
        integranteActualizado.setDisciplina(this.cbxDisciplina.getSelectionModel().getSelectedItem().toString());
        try{
            flag=IntegranteDAO.actualizarDatosIntegrante(integranteActualizado);
        }catch(SQLException ex){
            
            System.out.println("Error: ");
            ex.printStackTrace();
        }
        return flag;
        
        
    }
    
    private boolean validarCamposRegistrarEstudios(){
        boolean flag = false;
        if(this.txtEstudiosEn.getText().equals("") ||
                this.dtpFechaInicio.getValue().equals(null) ||
                this.dtpFechaTermino.getValue().equals(null) ||
                this.dtpFechaObtencionGrado.getValue().equals(null) ||
                this.cbxNivelEstudios.getSelectionModel().isEmpty() ||
                this.cbxAreaFP.getSelectionModel().isEmpty() ||
                this.cbxDisciplinaFP.getSelectionModel().isEmpty() ||
                this.cbxInstitucionOtorgante.getSelectionModel().isEmpty() ||
                this.txtEstudiosEn.getText().equals("") ||
                this.cbxPaisFP.getSelectionModel().getSelectedItem().equals(null)){
            
            
            return flag;
        }else{
            if(modificarFP){
                modificarEstudiosRealizados();
                return flag=true;
            }else{
                registrarEstudiosRealizados();
                return flag=true;
            }
            
        }
        
    }
    
    private boolean registrarEstudiosRealizados(){
        boolean flag = false;
        EstudiosRealizados nuevoEstudio = new EstudiosRealizados(0,
                this.cbxAreaFP.getSelectionModel().getSelectedItem().toString(),
                this.cbxDisciplinaFP.getSelectionModel().getSelectedItem().toString(),
                this.txtEstudiosEn.getText(),
                Date.valueOf(this.dtpFechaInicio.getValue()),
                Date.valueOf(this.dtpFechaTermino.getValue()),
                Date.valueOf(this.dtpFechaObtencionGrado.getValue()),
                this.cbxNivelEstudios.getSelectionModel().getSelectedItem().toString(),
                this.cbxInstitucionOtorgante.getSelectionModel().getSelectedItem().toString(),
                this.cbxPaisFP.getSelectionModel().getSelectedItem().toString());
        
        
        try{
            EstudiosRealizadosDAO.registrar(this.integrante.getIdIntegrante(),nuevoEstudio);
            return flag = true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return flag;
        }
    }
    
    private boolean modificarEstudiosRealizados(){
        boolean flag = false;
        EstudiosRealizados estudioModificado = new EstudiosRealizados(0,
                this.cbxAreaFP.getSelectionModel().getSelectedItem().toString(),
                this.cbxDisciplinaFP.getSelectionModel().getSelectedItem().toString(),
                this.txtEstudiosEn.getText(),
                Date.valueOf(this.dtpFechaInicio.getValue()),
                Date.valueOf(this.dtpFechaTermino.getValue()),
                Date.valueOf(this.dtpFechaObtencionGrado.getValue()),
                this.cbxNivelEstudios.getSelectionModel().getSelectedItem().toString(),
                this.cbxInstitucionOtorgante.getSelectionModel().getSelectedItem().toString(),
                this.cbxPaisFP.getSelectionModel().getSelectedItem().toString());
        
        
        try{
            EstudiosRealizadosDAO.actualizar(estudioSeleccionado.getIdEstudio(),estudioModificado);
            return flag = true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return flag;
        }
    }
    
    private void manipularCamposDatosLaborales(){
        if(indicadorDL==0){
            this.txtNombramiento.setDisable(false);
        
            this.txtDes.setVisible(false);
            this.cbxDES.setVisible(true);
            this.cbxDES.setDisable(false);

            this.cbxUnidadAcademica.setVisible(true);
            this.cbxUnidadAcademica.setDisable(false);
            this.txtUnidadAcademica.setVisible(false);

            this.txtFechaIngresoUV.setVisible(false);
            this.dtpFechaIngresoUv.setVisible(true);
            this.dtpFechaIngresoUv.setValue(datoslaborales.getFechaIngresoUV().toLocalDate());

            this.txtProgramaEducativo.setVisible(false);
            this.cbxProgramaEducativo.setVisible(true);
            this.cbxProgramaEducativo.setDisable(false);

            this.txtNivelSNI.setVisible(false);
            this.cbxNivelSni.setVisible(true);
            this.cbxNivelSni.setDisable(false);

            this.txtContratoPTC.setVisible(false);
            this.cbxContratoPtc.setVisible(true);
            this.cbxContratoPtc.setDisable(false);       
            this.cbxContratoPtc.setVisible(true);
            indicadorDL=1;
        }else{
            this.txtNombramiento.setDisable(true);
            this.txtNombramiento.setDisable(true);
        
            this.txtDes.setVisible(true);
            this.txtDes.setDisable(true);
            this.cbxDES.setVisible(false);
            this.cbxDES.setDisable(true);

            this.cbxUnidadAcademica.setVisible(false);
            this.cbxUnidadAcademica.setDisable(true);
            this.txtUnidadAcademica.setVisible(true);
            this.txtUnidadAcademica.setDisable(true);

            this.txtFechaIngresoUV.setVisible(true);
            this.txtFechaIngresoUV.setDisable(true);
            this.dtpFechaIngresoUv.setVisible(false);
            this.dtpFechaIngresoUv.setValue(datoslaborales.getFechaIngresoUV().toLocalDate());

            this.txtProgramaEducativo.setVisible(true);
            this.txtProgramaEducativo.setDisable(true);
            this.cbxProgramaEducativo.setVisible(false);
            this.cbxProgramaEducativo.setDisable(true);

            this.txtNivelSNI.setVisible(true);
            this.txtNivelSNI.setDisable(true);
            this.cbxNivelSni.setVisible(false);
            this.cbxNivelSni.setDisable(true);

            this.txtContratoPTC.setVisible(true);
            this.txtContratoPTC.setDisable(true);
            this.cbxContratoPtc.setVisible(false);
            this.cbxContratoPtc.setDisable(true);       
            
            indicadorDL=0;
        }
        
    }
    
    private boolean validarCamposDatosLaborales(){
        boolean flag = false;
        
        if(this.txtNombramiento.getText().equals("") ||
                this.cbxDES.getSelectionModel().isEmpty() ||
                this.cbxUnidadAcademica.getSelectionModel().isEmpty() ||
                this.dtpFechaIngresoUv.valueProperty().equals(null) ||
                this.cbxProgramaEducativo.getSelectionModel().isEmpty() ||
                this.cbxNivelSni.getSelectionModel().isEmpty() ||
                this.cbxContratoPtc.getSelectionModel().isEmpty()){
            
            return flag;
            
        }else{
            modificarDatosLaborales();
            return flag=true;
        }
    }
    
    private boolean modificarDatosLaborales(){
        boolean contrato = false;
        boolean flag = false;
        if(this.cbxContratoPtc.getSelectionModel().getSelectedItem().equals("Sí")){
            contrato = true;
        }else{
            
        }
        DatosLaborales datosActualizados = new DatosLaborales(integrante.getIdIntegrante(), 
        contrato,
        Date.valueOf(this.dtpFechaIngresoUv.getValue()),
        this.cbxDES.getSelectionModel().getSelectedItem().toString(),
        this.cbxNivelSni.getSelectionModel().getSelectedItem().toString(),
        this.txtNombramiento.getText(),
        this.cbxProgramaEducativo.getSelectionModel().getSelectedItem().toString(), 
        this.cbxUnidadAcademica.getSelectionModel().getSelectedItem().toString());
        
        System.out.println("Nombramiento :" + datosActualizados.getNombramiento());
        System.out.println("Des: " + datosActualizados.getDes());
        System.out.println("Nivel SNI: " + datosActualizados.getNivelSNI());
        try{
            DatosLaboralesDAO.actualizar(integrante.getIdIntegrante(),datosActualizados);
            return flag = true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return flag;
        }
        
    }
    
    
    
}
