/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srpauv.controlador;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;
import srpauv.clases.Colaborador;
import srpauv.clases.Integrante;

/**
 * FXML Controller class
 *
 * @author edson
 */
public class AgregarColaboradorController implements Initializable {

    
    @FXML ListView integrantes;
    @FXML ListView colaboradores;
    
    @FXML Button btnAgregar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        integrantes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        try {
            recuperarColaboradores();
            recuperarIntegrantes();
        } catch (SQLException ex) {
            Logger.getLogger(AgregarColaboradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        btnAgregar.setOnAction((ActionEvent event) -> {
            List<Integrante> listI = integrantes.getSelectionModel().getSelectedItems();
            List<Colaborador> listC = colaboradores.getSelectionModel().getSelectedItems();
            
            RegistrarProductoController.setIntegrantes(listI);
            RegistrarProductoController.setColaboradores(listC);
            
            Stage stage = (Stage) this.integrantes.getScene().getWindow();
            stage.close();
        });
    }
    
    private void recuperarIntegrantes() throws SQLException{
        List<Integrante> lista = DAO.DAOregistrarProducto.recuperarIntegrantes();
        for(int i = 0; i < lista.size(); i++){
            integrantes.getItems().add(lista.get(i));
        }
    }
    private void recuperarColaboradores() throws SQLException{
        List<Colaborador> lista = DAO.DAOregistrarProducto.recuperarColaboradores();
        for(int i = 0; i < lista.size(); i++){
            colaboradores.getItems().add(lista.get(i));
        }
    }
}
