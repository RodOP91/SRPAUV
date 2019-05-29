package srpauv.controlador;

import DAO.LineaDAO;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import srpauv.clases.Linea;
import srpauv.clases.Proyecto;

/**
 * FXML Controller class
 *
 * @author edson
 */
public class RegistrarProyectoController implements Initializable {

    @FXML TextField txtTituloProyecto;
    @FXML TextField txtPatrocinador;
    @FXML DatePicker dpkInicio;
    @FXML DatePicker dpkFin;
    @FXML TextField txtTipoPatrocinador;
    @FXML TextArea txtInvParticipantes;
    @FXML TextArea txtAlumParticipantes;
    @FXML TextArea txtActRealizadas;
    @FXML TextField txtNoMiembros;
    @FXML ComboBox<Linea> cbxLGAC;
    @FXML CheckBox chkIncluirCA;
    
    @FXML Button btnGuardar;
    @FXML Button btnCancelar;
    @FXML Label lblMensaje;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private void recuperarLineas() throws SQLException{
        List<Linea> lineas = LineaDAO.recuperarLineas();
        for(int i = 0; i < lineas.size(); i++){
            cbxLGAC.getItems().add(lineas.get(i));
        }
    }
    
    private void validarCampos(){
        String titulo = txtTituloProyecto.getText();
        String patrocinador = txtPatrocinador.getText();
        LocalDate fechaInicio = dpkInicio.getValue();
        LocalDate fechaFin = dpkFin.getValue();
        String tipoPatrocinador = txtTipoPatrocinador.getText();
        String investigadoresParticipantes = txtInvParticipantes.getText();
        String alumnosParticipantes = txtAlumParticipantes.getText();
        String actividades = txtActRealizadas.getText();
        String noMiembros = txtNoMiembros.getText();
        boolean ca = chkIncluirCA.isSelected();
        
        try{
            String lgac = cbxLGAC.getSelectionModel().getSelectedItem().getNombre();
            
            if(titulo.isEmpty() || patrocinador.isEmpty() || tipoPatrocinador.isEmpty()
                    || investigadoresParticipantes.isEmpty() || alumnosParticipantes.isEmpty()
                    || actividades.isEmpty() || noMiembros.isEmpty()){
                
                lblMensaje.setText("Completa todos los campos");
            } else{
                if(fechaInicio == null || fechaFin == null){
                    lblMensaje.setText("Selecciona ambas fechas");
                } else{
                    Proyecto proyecto = new Proyecto();
                    proyecto.setTituloProyecto(titulo);
                    proyecto.setPatrocinador(patrocinador);
                    proyecto.setFechaInicio(fechaInicio);
                    proyecto.setFechaFin(fechaFin);
                    proyecto.setTipoPatrocinador(tipoPatrocinador);
                    proyecto.setInvestigadoresParticipantes(investigadoresParticipantes);
                    proyecto.setAlumnosParticipantes(alumnosParticipantes);
                    proyecto.setActividades(actividades);
                    proyecto.setNumMiembros(noMiembros);
                    proyecto.setCa(ca);
                    
                    boolean flag = proyecto.registrarProyecto();
                    
                    if (flag == true){
                        lblMensaje.setText("Proyecto Registrado");
                    }
                }
            }
        } catch(NullPointerException ex){
            lblMensaje.setText("No has seleccionado una linea");
        }
    }
}
