package srpauv.controlador;

import DAO.Conexion;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import srpauv.clases.Integrante;


public class GenerarReporteController implements Initializable {

    private static Integrante usuario;
    
    @FXML DatePicker dtpFechaInicio;
    @FXML DatePicker dtpFechaFin;
    @FXML Label lblMensaje;
    @FXML Button btnGenerar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnGenerar.setOnAction((event) -> {
            LocalDate fechaInicio = dtpFechaInicio.getValue();
            LocalDate fechaFin = dtpFechaFin.getValue();
            
            int flag = validarFechas(fechaInicio, fechaFin);
            
            if(flag == 1){
                Date fecha = Date.valueOf("1111-11-10");
                fechaInicio = fecha.toLocalDate();
                fecha = Date.valueOf("2050-11-10");
                fechaFin = fecha.toLocalDate();
                generarReporte(fechaInicio, fechaFin);
            } else if (flag == 4) {
                generarReporte(fechaInicio, fechaFin);
            }
            
        });
    }    
    private int validarFechas(LocalDate fi, LocalDate ff){
        if(fi == null && ff == null){
                lblMensaje.setTextFill(Paint.valueOf("green"));
                lblMensaje.setText("Generando reporte completo");
            return 1;
        } else {
            if(fi == null || ff == null){
                lblMensaje.setTextFill(Paint.valueOf("red"));
                lblMensaje.setText("Debes indicar ambas fechas");
                return 2;
            } else {
                if(fi.isAfter(ff)){ 
                    lblMensaje.setTextFill(Paint.valueOf("red"));
                    lblMensaje.setText("La fecha de inicio debe ser menor");
                    return 3;
                } else { 
                    lblMensaje.setTextFill(Paint.valueOf("green"));
                    lblMensaje.setText("Generando Reporte");
                    return 4;
                }
            }
        }
    }
    private void generarReporte(LocalDate fi, LocalDate ff){
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConexion();
            JasperReport reporte = null;
            URL path = this.getClass().getResource("/reportes/reportProductosCA.jasper");
            
            reporte = (JasperReport) JRLoader.loadObject(path);
            
            Map parametro = new HashMap();
            parametro.put("id_responsable", usuario.getIdIntegrante());
            parametro.put("fecha_inicio", fi.toString());
            parametro.put("fecha_fin", ff.toString());
            
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, conn);
            
            JasperViewer view = new JasperViewer(jprint, false);
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(GenerarReporteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the usuario
     */
    public static Integrante getUsuario() {
        return usuario;
    }

    /**
     * @param aUsuario the usuario to set
     */
    public static void setUsuario(Integrante aUsuario) {
        usuario = aUsuario;
    }
}
