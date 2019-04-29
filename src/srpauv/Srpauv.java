/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srpauv;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author edson
 */
public class Srpauv extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        ResourceBundle idioma = ResourceBundle.getBundle("recursos.default_MX_es");        
        Parent root = FXMLLoader.load(getClass().getResource("/srpauv/FXML/Menu.fxml"), idioma);
        
        Scene escena = new Scene(root);
        primaryStage.setScene(escena);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}




/*  CONFIG VENTANA REGISTRO PRODUCTO
        primaryStage.setMaximized(true);
        primaryStage.setMinWidth(1000);
        primaryStage.setMinHeight(650);
        primaryStage.maximizedProperty().addListener((Observable observable) -> {
            primaryStage.setWidth(1000);
            primaryStage.setHeight(650);
        });
*/