 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Stack;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import static Modelo.Diccionario.*;


/**
 *
 * @author rdavi
 */
public class Utilitaria{
    
    public static void removeAndSetNodeFromGridPane(GridPane gridPane, SpecializedButton boton, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                gridPane.getChildren().remove(node);
                gridPane.add(boton, col, row);
                break;
            }
        }
    }
    
    public static ArrayList<String> analizarDirecciones(Coordenada cci, int tamanio, int ncolumnas, int nfilas){
        ArrayList<String> direccionesPosibles = new ArrayList();
        tamanio--;
        ncolumnas--;
        nfilas--;
        if((cci.getFila() - tamanio) >= 0){
            direccionesPosibles.add("arriba");
        }//arriba
        if((cci.getFila() + tamanio) <= nfilas){
            direccionesPosibles.add("abajo");
        }
        if((cci.getColumna() + tamanio) <= ncolumnas){
            direccionesPosibles.add("derecha");
        }
        if((cci.getColumna() - tamanio) >= 0){
            direccionesPosibles.add("izquierda");
        }
        if (((cci.getColumna() - tamanio) >= 0) && ((cci.getFila() + tamanio) <= nfilas)){
            direccionesPosibles.add("diagonalii");
        }
        if ((cci.getColumna()+(tamanio) <= ncolumnas) && ((cci.getFila() + tamanio) <= nfilas)){
            direccionesPosibles.add("diagonalid");
        }
        if (((cci.getColumna() - tamanio) >= 0) && ((cci.getFila() - tamanio) >= 0)){
            direccionesPosibles.add("diagonalsi");
        }
        if (((cci.getColumna() + tamanio) <= ncolumnas) && ((cci.getFila() - tamanio) >= 0)){
            direccionesPosibles.add("diagonalsd");
        }
        return direccionesPosibles;
    }
    
    public static boolean escribirIzq(ArrayList<ArrayList<SpecializedButton>> sopa, Coordenada cci, String palabra, Stack<Coordenada> cc){
        int ccP;
        String cha;
        int tamanio =palabra.length();
        for(int i =0; i<tamanio; i++){
            ccP=i;
            cha = String.valueOf(palabra.charAt(ccP));
            int fila = cci.getFila();
            int columna = cci.getColumna()-i;
            SpecializedButton b = sopa.get(columna).get(fila);
            if (b!=null) {
                if (b.getText().equals("0")){
                    SpecializedButton reemplazo = new SpecializedButton(new Coordenada(fila,columna),cha);
                    sopa.get(columna).set(fila, reemplazo);
                    cc.push(new Coordenada(fila,columna));
                }else if(b.getText().equals(cha)){
                    cc.push(new Coordenada(fila,columna,true));
                }else{
                    while(!cc.isEmpty()){
                        Coordenada re = cc.pop();
                        SpecializedButton reemplazoVacio = new SpecializedButton(new Coordenada(re.getFila(),re.getColumna()),"0");
                        if(!re.isOcurrencia()){
                            sopa.get(re.getColumna()).set(re.getFila(), reemplazoVacio);
                        }
                    }
                    return false;
                }
            }
            if(i==tamanio-1){
                return true;
            }
        }
        
        return false;
    }
        
    public static boolean escribirDer(ArrayList<ArrayList<SpecializedButton>> sopa, Coordenada cci, String palabra, Stack<Coordenada> cc){
        int ccP;
        String cha;
        int tamanio =palabra.length();
        for(int i =0; i<tamanio; i++){
            ccP=i;
            cha = String.valueOf(palabra.charAt(ccP));
            int fila = cci.getFila();
            int columna = cci.getColumna()+i;
            SpecializedButton b = sopa.get(columna).get(fila);
            if (b!=null) {
                if (b.getText().equals("0")){
                    SpecializedButton reemplazo = new SpecializedButton(new Coordenada(fila,columna),cha);
                    sopa.get(columna).set(fila, reemplazo);
                    cc.push(new Coordenada(fila,columna));
                }else if(b.getText().equals(cha)){
                    cc.push(new Coordenada(fila,columna,true));
                }else{
                    while(!cc.isEmpty()){
                        Coordenada re = cc.pop();
                        SpecializedButton reemplazoVacio = new SpecializedButton(new Coordenada(re.getFila(),re.getColumna()),"0");
                        if(!re.isOcurrencia()){
                            sopa.get(re.getColumna()).set(re.getFila(), reemplazoVacio);
                        }
                    }
                    return false;
                }
            }
            if(i==tamanio-1){
                return true;
            }
        }    
        return false;
    }
        
    public static boolean escribirArr(ArrayList<ArrayList<SpecializedButton>> sopa, Coordenada cci, String palabra, Stack<Coordenada> cc){
        int ccP;
        String cha;
        int tamanio =palabra.length();
        for(int i =0; i<tamanio; i++){
            ccP=i;
            cha = String.valueOf(palabra.charAt(ccP));
            int fila = cci.getFila()-i;
            int columna = cci.getColumna();
            SpecializedButton b = sopa.get(columna).get(fila);
            if (b!=null) {
                if (b.getText().equals("0")){
                    SpecializedButton reemplazo = new SpecializedButton(new Coordenada(fila,columna),cha);
                    sopa.get(columna).set(fila, reemplazo);
                    cc.push(new Coordenada(fila,columna));
                }else if(b.getText().equals(cha)){
                    cc.push(new Coordenada(fila,columna,true));
                }else{
                    while(!cc.isEmpty()){
                        Coordenada re = cc.pop();
                        SpecializedButton reemplazoVacio = new SpecializedButton(new Coordenada(re.getFila(),re.getColumna()),"0");
                        if(!re.isOcurrencia()){
                            sopa.get(re.getColumna()).set(re.getFila(), reemplazoVacio);
                        }
                    }
                    return false;
                }
            }
            if(i==tamanio-1){
                return true;
            }
        }
        
        return false;
    }
        
    public static boolean escribirAbj(ArrayList<ArrayList<SpecializedButton>> sopa, Coordenada cci, String palabra, Stack<Coordenada> cc){
        int ccP;
        String cha;
        int tamanio =palabra.length();
        for(int i =0; i<tamanio; i++){
            ccP=i;
            cha = String.valueOf(palabra.charAt(ccP));
            int fila = cci.getFila()+i;
            int columna = cci.getColumna();
            SpecializedButton b = sopa.get(columna).get(fila);
            if (b!=null) {
                if (b.getText().equals("0")){
                    SpecializedButton reemplazo = new SpecializedButton(new Coordenada(fila,columna),cha);
                    sopa.get(columna).set(fila, reemplazo);
                    cc.push(new Coordenada(fila,columna));
                }else if(b.getText().equals(cha)){
                    cc.push(new Coordenada(fila,columna,true));
                }else{
                    while(!cc.isEmpty()){
                        Coordenada re = cc.pop();
                        SpecializedButton reemplazoVacio = new SpecializedButton(new Coordenada(re.getFila(),re.getColumna()),"0");
                        if(!re.isOcurrencia()){
                            sopa.get(re.getColumna()).set(re.getFila(), reemplazoVacio);
                        }
                    }
                    return false;
                }
            }
            if(i==tamanio-1){
                return true;
            }
        }
        
        return false;
    }
        
    public static boolean escribirDII(ArrayList<ArrayList<SpecializedButton>> sopa, Coordenada cci, String palabra, Stack<Coordenada> cc){
        int ccP;
        String cha;
        int tamanio =palabra.length();
        for(int i =0; i<tamanio; i++){
            ccP=i;
            cha = String.valueOf(palabra.charAt(ccP));
            int fila = cci.getFila()+i;
            int columna = cci.getColumna()-i;
            SpecializedButton b = sopa.get(columna).get(fila);
            if (b!=null) {
                if (b.getText().equals("0")){
                    SpecializedButton reemplazo = new SpecializedButton(new Coordenada(fila,columna),cha);
                    sopa.get(columna).set(fila, reemplazo);
                    cc.push(new Coordenada(fila,columna));
                }else if(b.getText().equals(cha)){
                    cc.push(new Coordenada(fila,columna,true));
                }else{
                    while(!cc.isEmpty()){
                        Coordenada re = cc.pop();
                        SpecializedButton reemplazoVacio = new SpecializedButton(new Coordenada(re.getFila(),re.getColumna()),"0");
                        if(!re.isOcurrencia()){
                            sopa.get(re.getColumna()).set(re.getFila(), reemplazoVacio);
                        }
                    }
                    return false;
                }
            }
            if(i==tamanio-1){
                return true;
            }
        }
        
        return false;
    }

    public static boolean escribirDID(ArrayList<ArrayList<SpecializedButton>> sopa, Coordenada cci, String palabra, Stack<Coordenada> cc){
        int ccP;
        String cha;
        int tamanio =palabra.length();
        for(int i =0; i<tamanio; i++){
            ccP=i;
            cha = String.valueOf(palabra.charAt(ccP));
            int fila = cci.getFila()+i;
            int columna = cci.getColumna()+i;
            SpecializedButton b = sopa.get(columna).get(fila);
            if (b!=null) {
                if (b.getText().equals("0")){
                    SpecializedButton reemplazo = new SpecializedButton(new Coordenada(fila,columna),cha);
                    sopa.get(columna).set(fila, reemplazo);
                    cc.push(new Coordenada(fila,columna));
                }else if(b.getText().equals(cha)){
                    cc.push(new Coordenada(fila,columna,true));
                }else{
                    while(!cc.isEmpty()){
                        Coordenada re = cc.pop();
                        SpecializedButton reemplazoVacio = new SpecializedButton(new Coordenada(re.getFila(),re.getColumna()),"0");
                        if(!re.isOcurrencia()){
                            sopa.get(re.getColumna()).set(re.getFila(), reemplazoVacio);
                        }
                    }
                    return false;
                }
            }
            if(i==tamanio-1){
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean escribirDSI(ArrayList<ArrayList<SpecializedButton>> sopa, Coordenada cci, String palabra, Stack<Coordenada> cc){
        int ccP;
        String cha;
        int tamanio =palabra.length();
        for(int i =0; i<tamanio; i++){
            ccP=i;
            cha = String.valueOf(palabra.charAt(ccP));
            int fila = cci.getFila()-i;
            int columna = cci.getColumna()-i;
            SpecializedButton b = sopa.get(columna).get(fila);
            if (b!=null) {
                if (b.getText().equals("0")){
                    SpecializedButton reemplazo = new SpecializedButton(new Coordenada(fila,columna),cha);
                    sopa.get(columna).set(fila, reemplazo);
                    cc.push(new Coordenada(fila,columna));
                }else if(b.getText().equals(cha)){
                    cc.push(new Coordenada(fila,columna,true));
                }else{
                    while(!cc.isEmpty()){
                        Coordenada re = cc.pop();
                        SpecializedButton reemplazoVacio = new SpecializedButton(new Coordenada(re.getFila(),re.getColumna()),"0");
                        if(!re.isOcurrencia()){
                            sopa.get(re.getColumna()).set(re.getFila(), reemplazoVacio);
                        }
                    }
                    return false;
                }
            }
            if(i==tamanio-1){
                return true;
            }
        }
        
        return false;
    }    
    
    public static boolean escribirDSD(ArrayList<ArrayList<SpecializedButton>> sopa, Coordenada cci, String palabra, Stack<Coordenada> cc){
        int ccP;
        String cha;
        int tamanio =palabra.length();
        for(int i =0; i<tamanio; i++){
            ccP=i;
            cha = String.valueOf(palabra.charAt(ccP));
            int fila = cci.getFila()-i;
            int columna = cci.getColumna()+i;
            SpecializedButton b = sopa.get(columna).get(fila);
            if (b!=null) {
                if (b.getText().equals("0")){
                    SpecializedButton reemplazo = new SpecializedButton(new Coordenada(fila,columna),cha);
                    sopa.get(columna).set(fila, reemplazo);
                    cc.push(new Coordenada(fila,columna));
                }else if(b.getText().equals(cha)){
                    cc.push(new Coordenada(fila,columna,true));
                }else{
                    while(!cc.isEmpty()){
                        Coordenada re = cc.pop();
                        SpecializedButton reemplazoVacio = new SpecializedButton(new Coordenada(re.getFila(),re.getColumna()),"0");
                        if(!re.isOcurrencia()){
                            sopa.get(re.getColumna()).set(re.getFila(), reemplazoVacio);
                        }
                    }
                    return false;
                }
            }
            if(i==tamanio-1){
                return true;
            }
        }
        
        return false;
    }
    
    public static String recorrerHorizontal(ArrayList<ArrayList<SpecializedButton>> sopa, SpecializedButton b1,SpecializedButton b2, ArrayList<String> palabras){
        
        String palabra = "";
        int fi = b1.getCoordenadas().getFila();
        int ci = b1.getCoordenadas().getColumna();
        int cf = b2.getCoordenadas().getColumna();
        Stack<SpecializedButton> botones = new Stack();
        
        for (; ci <= cf; ci++){
            SpecializedButton b = sopa.get(ci).get(fi);
            palabra += b.getText();
            botones.push(b);
        }

        if(calificarPalabra(palabra,palabras)){
            while(!botones.isEmpty()){
                SpecializedButton b = botones.pop();
                b.setStyle("-fx-background-color: GRAY");
                if(!(b.getCoordenadas().isOcurrencia())){
                    b.setDisable(true);
                }   
            }
        }else{
            while(!botones.isEmpty()){
                SpecializedButton b = botones.pop();
                b.setStyle("button");
            }
        }        
        return palabra;
    }
    public static String recorrerVertical(ArrayList<ArrayList<SpecializedButton>> sopa, SpecializedButton b1,SpecializedButton b2, ArrayList<String> palabras){
        
        String palabra = "";
        int fi = b1.getCoordenadas().getFila();
        int ff = b2.getCoordenadas().getFila();
        int ci = b1.getCoordenadas().getColumna();
        
        Stack<SpecializedButton> botones = new Stack();
        
        for (; fi <= ff; fi++){
            SpecializedButton b = sopa.get(ci).get(fi);
            palabra += b.getText();
            botones.push(b);
        }

        if(calificarPalabra(palabra,palabras)){
            while(!botones.isEmpty()){
                SpecializedButton b = botones.pop();
                b.setStyle("-fx-background-color: GRAY");
                if(!(b.getCoordenadas().isOcurrencia())){
                    b.setDisable(true);
                }   
            }
        }else{
            while(!botones.isEmpty()){
                SpecializedButton b = botones.pop();
                b.setStyle("button");
            }
        }        
        return palabra;
    }
    
    public static String recorrerDiagonal1(ArrayList<ArrayList<SpecializedButton>> sopa, SpecializedButton b1,SpecializedButton b2, ArrayList<String> palabras){
        
        String palabra = "";
        int fi = b1.getCoordenadas().getFila();
        int ff = b2.getCoordenadas().getFila();
        int ci = b1.getCoordenadas().getColumna();
        int cf = b2.getCoordenadas().getColumna();
        Stack<SpecializedButton> botones = new Stack();
        
        for (; fi <= ff && ci <= cf; fi++,ci++){
            SpecializedButton b = sopa.get(ci).get(fi);
            palabra += b.getText();
            botones.push(b);
        }
        
        if(calificarPalabra(palabra,palabras)){
            while(!botones.isEmpty()){
                SpecializedButton b = botones.pop();
                b.setStyle("-fx-background-color: GRAY");
                if(!(b.getCoordenadas().isOcurrencia())){
                    b.setDisable(true);
                }   
            }
        }else{
            while(!botones.isEmpty()){
                SpecializedButton b = botones.pop();
                b.setStyle("button");
            }
        }
        return palabra;
    }
    public static String recorrerDiagonal2(ArrayList<ArrayList<SpecializedButton>> sopa, SpecializedButton b1,SpecializedButton b2, ArrayList<String> palabras){
        
        String palabra = "";
        int fi = b1.getCoordenadas().getFila();
        int ff = b2.getCoordenadas().getFila();
        int ci = b1.getCoordenadas().getColumna();
        int cf = b2.getCoordenadas().getColumna();
        Stack<SpecializedButton> botones = new Stack();
        
        for (; fi <= ff && ci >= cf; fi++,ci--){
            SpecializedButton b = sopa.get(ci).get(fi);
            palabra += b.getText();
            botones.push(b);
        }
        
        if(calificarPalabra(palabra,palabras)){
            while(!botones.isEmpty()){
                SpecializedButton b = botones.pop();
                b.setStyle("-fx-background-color: GRAY");
                if(!(b.getCoordenadas().isOcurrencia())){
                    b.setDisable(true);
                }   
            }
        }else{
            while(!botones.isEmpty()){
                SpecializedButton b = botones.pop();
                b.setStyle("button");
            }
        }
        
        return palabra;
    }
    
    public static void recorrer(SpecializedButton bp1, SpecializedButton bp2, ArrayList<ArrayList<SpecializedButton>> sopaBotones, ArrayList<String> palabras,Stack<SpecializedButton> controlador){
        Coordenada ccbp1 = bp1.getCoordenadas();
        Coordenada ccbp2 = bp2.getCoordenadas();
        if (ccbp1.getFila() == ccbp2.getFila() && ccbp1.getColumna() < ccbp2.getColumna()){
            String palabra = recorrerHorizontal(sopaBotones, bp1, bp2, palabras);
        }else if (ccbp1.getFila() == ccbp2.getFila() && ccbp2.getColumna() < ccbp1.getColumna()){
            String palabra = recorrerHorizontal(sopaBotones ,bp2, bp1, palabras);
        }else if (ccbp1.getColumna() == ccbp2.getColumna() && ccbp1.getFila() < ccbp2.getFila()){
            String palabra = recorrerVertical(sopaBotones ,bp1, bp2, palabras);
        }else if (ccbp1.getColumna() == ccbp2.getColumna() && ccbp2.getFila() < ccbp1.getFila()){
            String palabra = recorrerVertical(sopaBotones ,bp2, bp1, palabras);
        }else if (ccbp1.getColumna() > ccbp2.getColumna()&& ccbp1.getFila() > ccbp2.getFila()){
            String palabra = recorrerDiagonal1(sopaBotones ,bp2, bp1, palabras);
        }else if (ccbp2.getColumna() > ccbp1.getColumna()&& ccbp2.getFila() > ccbp1.getFila()){
            String palabra = recorrerDiagonal1(sopaBotones ,bp1 ,bp2 ,palabras);
        }else if (ccbp1.getColumna() < ccbp2.getColumna()&& ccbp1.getFila() > ccbp2.getFila()){
            String palabra = recorrerDiagonal2(sopaBotones ,bp2 ,bp1 ,palabras);
        }else if (ccbp2.getColumna() < ccbp1.getColumna()&& ccbp2.getFila() > ccbp1.getFila()){
            String palabra = recorrerDiagonal2(sopaBotones ,bp1 ,bp2 ,palabras);
        }else{
                bp1.setStyle("button");
                bp2.setStyle("button");
                while(!controlador.isEmpty()){
                    controlador.pop();
                }
        }
    }
    
    public static void setearEvento(SpecializedButton b, Stack<SpecializedButton> controlador, ArrayList<ArrayList<SpecializedButton>> sopaBotones, ArrayList<String> palabras){
        b.setOnAction(
            new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent MOUSE_CLICKED) {
                controlador.push(b);
                b.setStyle("-fx-background-color: GRAY");
                if(controlador.size() == 2){
                    SpecializedButton bp1 = controlador.pop();
                    SpecializedButton bp2 = controlador.pop();
                    recorrer(bp1,bp2,sopaBotones,palabras,controlador);
                }
            }
        });
    }
    
    public static void llenarPalabras(String direccion, ArrayList<ArrayList<SpecializedButton>> sopaBotones, Stack<Coordenada> cc, Coordenada cci, ArrayList<String> direccionesPosibles, ArrayList<String> palabras, String palabra,int indice, int j){
        if(direccion.equals("izquierda")){
            if(escribirIzq(sopaBotones,cci,palabra,cc)){
                direccionesPosibles.clear();
                palabras.remove(indice);
            }else{
                direccionesPosibles.remove(j);
            }
        }
        if(direccion.equals("derecha")){
            if(escribirDer(sopaBotones,cci,palabra,cc)){
                direccionesPosibles.clear();
                palabras.remove(indice);
            }else{
                direccionesPosibles.remove(j);
            }
        }
        if(direccion.equals("arriba")){
            if(escribirArr(sopaBotones,cci,palabra,cc)){
                direccionesPosibles.clear();
                palabras.remove(indice);
            }else{
                direccionesPosibles.remove(j);
            }
        }
        if(direccion.equals("abajo")){
            if(escribirAbj(sopaBotones,cci,palabra,cc)){
                direccionesPosibles.clear();
                palabras.remove(indice);
            }else{
                direccionesPosibles.remove(j);
            }
        } 
        if(direccion.equals("diagonalii")){
            if(escribirDII(sopaBotones,cci,palabra,cc)){
                direccionesPosibles.clear();
                palabras.remove(indice);
            }else{
                direccionesPosibles.remove(j);
            }
        } 
        if(direccion.equals("diagonalid")){
            if(escribirDID(sopaBotones,cci,palabra,cc)){
                direccionesPosibles.clear();
                palabras.remove(indice);
            }else{
                direccionesPosibles.remove(j);
            }
        } 
        if(direccion.equals("diagonalsd")){
            if(escribirDSD(sopaBotones,cci,palabra,cc)){
                direccionesPosibles.clear();
                palabras.remove(indice);
            }else{
                direccionesPosibles.remove(j);
            }
        } 
        if(direccion.equals("diagonalsi")){
            if(escribirDSI(sopaBotones,cci,palabra,cc)){
                direccionesPosibles.clear();
                palabras.remove(indice);
            }else{
                direccionesPosibles.remove(j);
            }
        }
    }
}
