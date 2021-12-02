/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import static Modelo.Utilitaria.*;
import java.util.Random;
import java.util.Stack;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author rdavi
 */
public class pruebas extends Application{
    
    @Override
    @SuppressWarnings("empty-statement")
    public void start(Stage primaryStage) {
        
        GridPane sopa = new GridPane();
        StackPane root = new StackPane();
        
        String abecedario = "abcdefghijklmnñopqrstuvwxyz";
        Random generador = new Random();
        int nfilas = 8;//deben ser las solicitaas por el jugador
        int ncolumnas = 8;//deben ser las solicitaas por el jugador
        ArrayList<String> palabras = new ArrayList();//es la lista que se adquiere del metodo diccionario 
        palabras.add("hola");
        palabras.add("crazy");
        palabras.add("tomate");
        palabras.add("adan");
        palabras.add("mama");
        palabras.add("papa");
        palabras.add("tiro");
        ArrayList<String> palabrasdef = new ArrayList();//copia de la primera para llenarla usen un for con el primer arraylist de palabras ya que ese se vacia a lo que smanda a llenar la sopa
        palabrasdef.add("hola");
        palabrasdef.add("crazy");
        palabrasdef.add("tomate");
        palabrasdef.add("adan");
        palabrasdef.add("mama");
        palabrasdef.add("papa");
        palabrasdef.add("tiro");
        
        Stack<SpecializedButton> controlador = new Stack();
        ArrayList<ArrayList<SpecializedButton>> sopaBotones = new ArrayList(ncolumnas);
        
        for (int i = 0; i<ncolumnas; i++){
            ArrayList<SpecializedButton> fila = new ArrayList(nfilas);
            for (int j =0; j<nfilas; j++){
                SpecializedButton b = new SpecializedButton(new Coordenada(j,i),"0");
                fila.add(b);
            }
            sopaBotones.add(fila);
        }
        
        while(!palabras.isEmpty()){
            Stack<Coordenada> cc = new Stack();
            ArrayList<String> direccionesPosibles = new ArrayList();
            int indice = generador.nextInt(palabras.size());
            String palabra = palabras.get(indice);
            boolean control =false;
            int tamanio = palabra.length();
            Coordenada cci = new Coordenada(generador.nextInt(nfilas),generador.nextInt(ncolumnas));
            SpecializedButton b1 = sopaBotones.get(cci.getColumna()).get(cci.getFila());
            if((b1.getText().equals("0")) || String.valueOf(palabra.charAt(0)).equals(b1.getText())){
                direccionesPosibles = analizarDirecciones(cci, tamanio, ncolumnas, nfilas);
                if(!direccionesPosibles.isEmpty()){
                    while(!direccionesPosibles.isEmpty()){
                        int j = generador.nextInt(direccionesPosibles.size());
                        String direccion = direccionesPosibles.get(j);
                        llenarPalabras(direccion, sopaBotones, cc, cci, direccionesPosibles, palabras, palabra, indice, j);                        
                    }
                }
            }
        }
        
        for(int i = 0; i<sopaBotones.size(); i++){
            for(int j = 0; j<sopaBotones.get(i).size(); j++){
                setearEvento(sopaBotones.get(i).get(j),controlador,sopaBotones,palabrasdef);
                SpecializedButton b = sopaBotones.get(i).get(j);
                if (b.getText().equals("0")){
                    b.setText(String.valueOf(abecedario.charAt(generador.nextInt(27))));
                }
                sopa.add(b,i,j);
            }
        }
        
        
        Scene scene = new Scene(root, 300, 250);
        root.getChildren().add(sopa);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        rotarFilaIzq(sopaBotones,sopa,2,root);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
