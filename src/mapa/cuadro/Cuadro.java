package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprite;

public abstract class Cuadro {

    public int x, y;
    public Sprite sprite;

    //Tiles
    public static final Cuadro VACIO = new CuadroVacio(Sprite.VACIO);
    public static final Cuadro ASFALTO = new CuadroAsfalto(Sprite.ASFALTO);
    //Fin

    public Cuadro(Sprite sprite) {
        this.sprite = sprite;
    }

    public void mostrar(int x, int y, Pantalla pantalla) {

    }

    public boolean solido() {
        return false;
    }
}
