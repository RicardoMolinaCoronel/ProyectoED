
package Modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Diccionario {
    private ArrayList<String> palabras= new ArrayList<String>();
    public ArrayList<String> getPalabras() {
        return palabras;
    }
    
    
    public void leerArchivo(String nombreArchivo) throws FileNotFoundException, IOException{
        BufferedReader reader = new BufferedReader(new FileReader("src/Modelo/"+nombreArchivo, StandardCharsets.UTF_8));
        String line;
        while ((line= reader.readLine())!= null){
            palabras.add(line);
        }
        Iterator it = palabras.iterator();
    }
    
   public boolean calificarPalabra(String respuesta, ArrayList<String> palabras){
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
    
   public ArrayList<String> hallarPalabras(int columnas, int filas, ArrayList<String> palabras){
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
