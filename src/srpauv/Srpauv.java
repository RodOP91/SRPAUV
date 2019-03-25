/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srpauv;

import com.sun.javaws.security.Resource;
import java.io.IOException;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author edson
 */
public class Srpauv extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        ResourceBundle idioma = ResourceBundle.getBundle("recursos.default_MX_es");        
        Parent root = FXMLLoader.load(getClass().getResource("/srpauv/FXML/RegistrarProducto.fxml"), idioma);
        
        Scene escena = new Scene(root);
        primaryStage.setScene(escena);
        primaryStage.setMaximized(true);
        primaryStage.setMinWidth(1000);
        primaryStage.setMinHeight(650);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
