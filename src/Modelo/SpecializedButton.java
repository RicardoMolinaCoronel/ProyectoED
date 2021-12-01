 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import javafx.scene.control.Button;

/**
 *
 * @author rdavi
 */
public class SpecializedButton extends Button{
    private Coordenada coordenadas;

    public SpecializedButton(Coordenada coordenadas, String string) {
        super(string);
        this.coordenadas = coordenadas;
    }

    public Coordenada getCoordenadas() {
        return coordenadas;
    }
}
