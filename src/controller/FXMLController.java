/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class FXMLController{

    /**
     * Initializes the controller class.
     */
    @FXML
    TextField txt1;
    @FXML
    TextField txt2;
    
    @FXML
    public void empezar() throws IOException{
        int filas = Integer.valueOf(txt1.getText());
        int columnas = Integer.valueOf(txt2.getText());
    }
    
   
    
        
    
}
