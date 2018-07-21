package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprite;

public class Cuadro {

    public int x, y;
    public Sprite sprite;

    public static final int LADO = 32;

    //Tiles
    public static final Cuadro VACIO = new Cuadro(Sprite.VACIO);
    public static final Cuadro ASFALTO = new Cuadro(Sprite.ASFALTO);
    public static final Cuadro ARENA = new Cuadro(Sprite.ARENA);
    public static final Cuadro BORDE_CARRETERA_ARENA = new Cuadro(Sprite.BORDE_CARRETERA_ARENA);
    public static final Cuadro CENTRO_CARRETERA = new Cuadro(Sprite.CENTRO_CARRETERA);
    public static final Cuadro ESQUINA_CARRETERA = new Cuadro(Sprite.ESQUINA_CARRETERA);
    public static final Cuadro PARED_PIEDRA = new Cuadro(Sprite.PARED_PIEDRA);
    public static final Cuadro BORDE_PARED_PIEDRA_ARENA = new Cuadro(Sprite.BORDE_PARED_PIEDRA_ARENA);
    public static final Cuadro PUERTA_PARTE_SUPERIOR = new Cuadro(Sprite.PUERTA_PARTE_SUPERIOR);
    public static final Cuadro PUERTA_PARTE_INFERIOR = new Cuadro(Sprite.PUERTA_PARTE_INFERIOR);
    public static final Cuadro UNION_PARED_PIEDRA_BORDE_CARRETERA_ARENA = new Cuadro(Sprite.UNION_PARED_PIEDRA_BORDE_CARRETERA_ARENA);
    public static final Cuadro BORDE_PARED_PIEDRA_ASFALTO = new Cuadro(Sprite.BORDE_PARED_PIEDRA_ASFALTO);
    public static final Cuadro GRADA_PIEDRA = new Cuadro(Sprite.GRADA_PIEDRA);
    //Fin

    public Cuadro(Sprite sprite) {
        this.sprite = sprite;
    }

    public void mostrar(int x, int y, Pantalla pantalla) {
        pantalla.mostrarCuadro(x << 5, y << 5, this);
    }

    public boolean solido() {
        return false;
    }
}
