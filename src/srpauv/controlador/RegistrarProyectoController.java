package srpauv.controlador;

import DAO.LineaDAO;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import srpauv.clases.Integrante;
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
    
    private static Integrante usuario;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            recuperarLineas();
        } catch (SQLException ex) {
            Logger.getLogger(RegistrarProyectoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        btnGuardar.setOnAction((event) -> {
            validarCampos();
        });
        
        btnCancelar.setOnAction((event) -> {
            cerrar();
        });
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
                lblMensaje.setTextFill(Paint.valueOf("red"));
                lblMensaje.setText("Completa todos los campos");
            } else{
                if(fechaInicio == null || fechaFin == null){
                    lblMensaje.setTextFill(Paint.valueOf("red"));
                    lblMensaje.setText("Selecciona ambas fechas");
                } else{
                    if(fechaInicio.isAfter(fechaFin)){
                        lblMensaje.setTextFill(Paint.valueOf("red"));
                        lblMensaje.setText("La fecha de inicio debe ser anterior a la fecha de fin");
                    } else {
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
                        proyecto.setLgac(lgac);
                        proyecto.setIdIntegrante(usuario.getIdIntegrante());

                        boolean flag = proyecto.registrarProyecto();

                        if (flag == true){
                            lblMensaje.setTextFill(Paint.valueOf("green"));
                            lblMensaje.setText("Proyecto Registrado");
                        }
                    }
                }
            }
        } catch(NullPointerException ex){
            lblMensaje.setTextFill(Paint.valueOf("red"));
            lblMensaje.setText("No has seleccionado una linea");
        }
    }
    private void cerrar(){
        Stage stage = (Stage) this.btnCancelar.getScene().getWindow();
        stage.close();
    }

    /**
     * @return the usuario
     */
    public static Integrante getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public static void setUsuario(Integrante usuario) {
        RegistrarProyectoController.usuario = usuario;
    }
}
