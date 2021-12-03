/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package proyectoed;

import Modelo.ArrayList;

import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author rdavi
 */
public class ProyectoED extends Application {
   @Override
    public void start(Stage primaryStage) {
        VBox vbox = new VBox();
        Label labelTitle = new Label("Sopa de letras");
        labelTitle.setFont(new Font(40));
        Label filas = new Label("Filas");
        //Cambiamos tamaño de fuente
        filas.setFont(new Font(20));
         Label columnas = new Label("Columnas");
        //Cambiamos tamaño de fuente
        columnas.setFont(new Font(20));
        
        TextField textUser = new TextField();
        textUser.setFont(new Font(18));
        //Agregamos texto informativo al textField
        textUser.setPromptText("Ingrese las filas");
        //asignamos dimensiones predefinidas
        textUser.setPrefWidth(341);
        textUser.setPrefHeight(44);
        
        TextField textColumnas = new TextField();
        textColumnas.setFont(new Font(18));
        //Agregamos texto informativo al textField
        textColumnas.setPromptText("Ingrese las Columnas");
        //asignamos dimensiones predefinidas
        textColumnas.setPrefWidth(341);
        textColumnas.setPrefHeight(44); 
        
         Button btnLogin = new Button("Aceptar");
        btnLogin.setFont(new Font(20));
        btnLogin.setPrefWidth(370);
        btnLogin.setPrefHeight(44);                
        btnLogin.setMaxWidth(Double.MAX_VALUE);
        btnLogin.setCursor(Cursor.HAND);
                btnLogin.setOnAction(new EventHandler<ActionEvent>(){
        public void handle(ActionEvent event){
        
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
//                b.setText(String.valueOf(abecedario.charAt(random.nextInt(27))));
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
//        8x8
// ArrayList<String> 
// gato perro 
//            }
//        }

        ArrayList<String> direccion = new ArrayList(4);
        direccion.add("arriba");
        direccion.add("abajo");
        direccion.add("izquierda");
        direccion.add("derecha");
        ArrayList<String> palabras = new ArrayList(4);
        palabras.add("hola");
        
        
        for (int j = 0; j<palabras.size(); j++){
            String palabra = palabras.get(j);
            int tamanioPalabra = palabra.length();
            if(tamanioPalabra<sopaBotones.size() || tamanioPalabra<sopaBotones.get(0).size()){
                int ccc = random.nextInt(ncolumnas);
                int ccf = random.nextInt(nfilas);
                System.out.println(ccc+" "+ccf);
                boolean control = true;
                while (control){
                    int dir = random.nextInt(direccion.size()-1);
                    System.out.println(dir);
                    if (direccion.get(dir) == "abajo"){
                        if ((ccc+tamanioPalabra-1)<=ncolumnas-1){
                            for(int i = 0; i<tamanioPalabra; i++){
                                sopaBotones.get(ccc).get(ccf).setText(String.valueOf(palabra.charAt(i)));
                                ccf++;
                            }
                            control = false;
                        }
                    }else if(direccion.get(dir) == "arriba"){
                        if ((ccc-tamanioPalabra-1)<=ncolumnas-1 && (ccc-tamanioPalabra-1)>= 0){
                            for(int i = 0; i<tamanioPalabra; i++){
                                sopaBotones.get(ccc).get(ccf).setText(String.valueOf(palabra.charAt(i)));
                                ccf++;
                            }
                            control = false;
                        }
                    }else if(direccion.get(dir) == "izquierda"){
                        if ((ccf-tamanioPalabra-1)<=nfilas-1 && (ccf-tamanioPalabra-1)>= 0){
                            for(int i = 0; i<tamanioPalabra; i++){
                                sopaBotones.get(ccc).get(ccf).setText(String.valueOf(palabra.charAt(i)));
                                ccc--;
                            }
                            control = false;
                        }
                    }else if(direccion.get(dir) == "derecha"){
                        if ((ccf+tamanioPalabra-1)<=nfilas-1){
                            for(int i = 0; i<tamanioPalabra; i++){
                                sopaBotones.get(ccc).get(ccf).setText(String.valueOf(palabra.charAt(i)));
                                ccc++;
                            }
                            control = false;
                        }
                    }
                }
            }    
        }
        
        root.getChildren().add(sopa);
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
          
        }
    });
        
        VBox.setMargin(filas, new Insets(10, 0, 0, 0));
        VBox.setMargin(columnas, new Insets(10, 0, 0, 0));
        VBox.setMargin(btnLogin, new Insets(20, 0, 0, 0));
        
        vbox.getChildren().addAll(labelTitle, filas, textUser, columnas, textColumnas, btnLogin);
        vbox.setAlignment(Pos.CENTER);

        
        
        
        
        Scene scene = new Scene(vbox, 854, 503);
        
        primaryStage.setTitle("Sopa de Letras");
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
