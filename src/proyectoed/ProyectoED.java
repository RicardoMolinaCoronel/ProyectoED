/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package proyectoed;

import Modelo.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author rdavi
 */
public class ProyectoED extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        String abecedario = "abcdefghijklmnñopqrstuvwxyz";
        StackPane root = new StackPane();
        Random random = new Random();
        GridPane sopa = new GridPane();
        int nfilas = 8;
        int ncolumnas = 8;
        
        ArrayList<ArrayList<Button>> sopaBotones = new ArrayList(nfilas);
        for (int i = 0; i<nfilas; i++){
            ArrayList<Button> fila = new ArrayList(ncolumnas);
            for (int j =0; j<ncolumnas; j++){
                Button b = new Button();
                b.setText(String.valueOf(abecedario.charAt(random.nextInt(27))));
                fila.add(b);
            }    
            sopaBotones.add(fila);
        }
        
        for(int i = 0; i<sopaBotones.size(); i++){
            for(int j = 0; j<sopaBotones.get(i).size(); j++){
                Button b = sopaBotones.get(i).get(j);
                sopa.add(b,i,j);
            }
        }
//        int contadorf =0;
//        int contadorc =0;
//        Iterator<ArrayList<Button>> iterator1 = sopaBotones.iterator();
//        while(iterator1.hasNext()){
//            Iterator<Button> iterator2 = iterator1.next().iterator();
//            while(iterator2.hasNext()){
//                sopa.add(iterator2.next(),contadorc,contadorf);
//                contadorc++;
//            }
//            contadorc = 0;
//            contadorf++;
//        }
        
//        ArrayList<ArrayList<String>> sopaBotones = new ArrayList(nfilas);
//        for (int i = 0; i<nfilas; i++){
//            ArrayList<String> fila = new ArrayList(ncolumnas);
//            for (int j =0; j<ncolumnas; j++){
//                
//            }
//        }
        System.out.println(sopa.getColumnCount()+" "+sopa.getRowCount());
        root.getChildren().add(sopa);
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
