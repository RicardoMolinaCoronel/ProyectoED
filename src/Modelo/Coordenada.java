/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author rdavi
 */
public class Coordenada {
    private int fila;
    private int columna;
    private boolean ocurrencia;
    
    public Coordenada(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        ocurrencia = false;
    }

    public Coordenada(int fila, int columna, boolean ocurrencia) {
        this.fila = fila;
        this.columna = columna;
        this.ocurrencia = ocurrencia;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public boolean isOcurrencia() {
        return ocurrencia;
    }

    @Override
    public String toString() {
        return fila + " " + columna;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
}
