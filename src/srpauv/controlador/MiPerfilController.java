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
import java.sql.SQLException;
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
    List<EstudiosRealizados> estudios;
    
    //PANELES MI PERFIL---------------------------------------------------------
    @FXML AnchorPane apnVentanaMiPerfil;
    @FXML AnchorPane apnBannerMiPerfil;
    @FXML AnchorPane apnSeccionesPerfil;
    @FXML Pane pneDatosPersonales;
    @FXML Pane pneDatosLaborales;
    @FXML Pane pneFormacionProfesional;
    //CAMPOS DATOS PERSONALES---------------------------------------------------
    @FXML TextField txtNoPersonal;
    @FXML TextField txtNombre;
    @FXML TextField txtApellidoPaterno;
    @FXML TextField txtApellidoMaterno;
    @FXML TextField txtRfc;
    @FXML TextField txtCurp;
    @FXML TextField txtTelCasa;
    @FXML TextField txtTelTrabajo;
    @FXML TextField txtTelCelular;
    @FXML TextField txtCorreoUv;
    @FXML TextField txtCorreoAdicional;
    @FXML TextField txtFechaNacimiento;
    @FXML ComboBox cbxGenero;
    @FXML ComboBox cbxEdoCivil;
    @FXML ComboBox cbxNacionalidad;
    @FXML ComboBox cbxArea;
    @FXML ComboBox cbxDisciplina;
    @FXML ComboBox cbxIESA;
    @FXML DatePicker dtpFechaNacimiento;   
    @FXML Button btnActualizarDP;
    @FXML Button btnCancelarDP;
    @FXML Button btnGuardarDP;
    //CAMPOS DATOS LABORALES----------------------------------------------------
    @FXML TextField txtNombramiento;
    @FXML TextField txtDes;
    @FXML ComboBox cbxUnidadAcademica;
    @FXML ComboBox cbxProgramaEducativo;
    @FXML ComboBox cbxNivelSni;
    @FXML ComboBox cbxContratoPtc;
    @FXML DatePicker dtpFechaIngresoUv;
    @FXML Button btnActualizarDL;
    @FXML Button btnCancelarDL;
    @FXML Button btnGuardarDL;
    //CAMPOS FORMACION PERSONAL-------------------------------------------------
    @FXML TextField txtOtraInstitucion;
    @FXML TextField txtEstudiosEn;
    @FXML ComboBox cbxNivelEstudios;
    @FXML ComboBox cbxAreaFP;
    @FXML ComboBox cbxDisciplinaFP;
    @FXML ComboBox cbxInstitucionOtorgante;
    @FXML DatePicker FechaInicio;
    @FXML DatePicker FechaTermino;
    @FXML DatePicker FechaObtencionGrado;
    @FXML Button btnActualizarFP;
    @FXML Button btnAnadirFP;
    @FXML Button btnCancelarFP;
    @FXML Button btnGuardarFP;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        llenarOpcionesComboBox();
        try{
            integrante = DAO.IntegranteDAO.getDatosIntegrante(4);
            datoslaborales = DAO.DatosLaboralesDAO.getDatosLaborales(4);
            estudios = DAO.EstudiosRealizadosDAO.getEstudiosRealizados(4);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        llenarCamposDatosPersonales(integrante);
        //Deshabilitando la edición de los campos-------------------------------
        
        
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
            cbxIESA.getItems().add(opciones.getOpcionesCbxInstitucion().get(x));
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
    }
    
    private void llenarCamposDatosPersonales(Integrante integrante){
        this.txtNoPersonal.setText(integrante.getNoPersonal());
        this.txtNombre.setText(integrante.getNombre());
        this.txtApellidoPaterno.setText(integrante.getApellidoP());
        this.txtApellidoMaterno.setText(integrante.getApellidoM());
        this.cbxGenero.setPromptText(integrante.getGenero());
        this.cbxEdoCivil.setPromptText(integrante.getEstadoCivil());
        this.txtRfc.setText(integrante.getRfc());
        this.txtCurp.setText(integrante.getCURP());
        this.txtTelCasa.setText(integrante.getTelefonoCasa());
        this.txtTelTrabajo.setText(integrante.getTelefonoTrabajo());
        this.cbxNacionalidad.setPromptText(integrante.getNacionalidad());
        this.txtFechaNacimiento.setText(integrante.getFechanacimiento().toString());
        this.txtCorreoUv.setText(integrante.getCorreoUV());
        this.txtCorreoAdicional.setText(integrante.getCorreoAdicional());
        this.cbxArea.setPromptText(integrante.getArea());
        this.cbxDisciplina.setPromptText(integrante.getDisciplina());
    }
    
    private void llenarCamposDatosLaborales(){
        
    }
    
    private void llenarCamposFormacionProfesional(){
        
    }
}
