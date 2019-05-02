/*
 * Proyecto creado con propósitos educativos en la Facultad de  
 *  Estadística e Informática de la Universidad Veracruzana.
 * Código libre.
 */
package srpauv.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author J. Rodrigo Ordóñez Pacheco
 */
public class MiPerfilController implements Initializable {

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
        
    }    
    
}
