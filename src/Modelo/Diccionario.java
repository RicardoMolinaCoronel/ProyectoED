/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Random;

public class Diccionario {
    
    
    public static ArrayList<String> leerArchivo(String nombreArchivo) throws FileNotFoundException, IOException{
        ArrayList<String> palabras= new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/ec/edu/espol/mavenproject1/"+nombreArchivo, StandardCharsets.UTF_8));
        String line;
        while ((line= reader.readLine())!= null){
            palabras.add(line);
        }
        return palabras;
    }
    
   public static boolean calificarPalabra(String respuesta, ArrayList<String> palabras){
        boolean coincide = false;
        Iterator<String> it = palabras.iterator();
        char ch;
        String reverso="";
        for (int i=0; i<respuesta.length(); i++){
            ch= respuesta.charAt(i); 
            reverso= ch+reverso; 
        } 
        while(it.hasNext() && coincide == false){
            String palabra = it.next();
            if(respuesta.equals(palabra) || reverso.equals(palabra)) coincide= true;
        }        
        return coincide;       
    }
    
   public static ArrayList<String> hallarPalabras(int columnas, int filas, ArrayList<String> palabras){
       ArrayList<String> seleccion = new ArrayList<String>();
       int longitud=0;
       int cantidad=0;
       Random rd = new Random();
       if(columnas > filas){
           longitud = columnas;
           cantidad = filas-2;
       }else{
           longitud = filas;
           cantidad = columnas-2;
       }
       while(seleccion.size()<cantidad){
           int index = rd.nextInt(palabras.size());
           String seleccionado = palabras.get(index);
           if(seleccionado.length()<longitud+1 && !(seleccion.contains(seleccionado))){
               seleccion.add(palabras.get(index));
           }
       }
       return seleccion;
   }
   
}