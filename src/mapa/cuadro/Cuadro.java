package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprite;

public class Cuadro {

    public int x, y;
    public Sprite sprite;
    private boolean solido;

    public static final int LADO = 32;

    //Tiles
    public static final Cuadro VACIO = new Cuadro(Sprite.VACIO, true);
    public static final Cuadro ASFALTO = new Cuadro(Sprite.ASFALTO);
    public static final Cuadro ARENA = new Cuadro(Sprite.ARENA, true);
    public static final Cuadro BORDE_CARRETERA_ARENA = new Cuadro(Sprite.BORDE_CARRETERA_ARENA);
    public static final Cuadro CENTRO_CARRETERA = new Cuadro(Sprite.CENTRO_CARRETERA);
    public static final Cuadro ESQUINA_CARRETERA = new Cuadro(Sprite.ESQUINA_CARRETERA);
    public static final Cuadro PARED_PIEDRA = new Cuadro(Sprite.PARED_PIEDRA, true);
    public static final Cuadro BORDE_PARED_PIEDRA_ARENA = new Cuadro(Sprite.BORDE_PARED_PIEDRA_ARENA);
    public static final Cuadro PUERTA_PARTE_SUPERIOR = new Cuadro(Sprite.PUERTA_PARTE_SUPERIOR, true);
    public static final Cuadro PUERTA_PARTE_INFERIOR = new Cuadro(Sprite.PUERTA_PARTE_INFERIOR, true);
    public static final Cuadro UNION_PARED_PIEDRA_BORDE_CARRETERA_ARENA = new Cuadro(Sprite.UNION_PARED_PIEDRA_BORDE_CARRETERA_ARENA);
    public static final Cuadro BORDE_PARED_PIEDRA_ASFALTO = new Cuadro(Sprite.BORDE_PARED_PIEDRA_ASFALTO);
    public static final Cuadro GRADA_PIEDRA = new Cuadro(Sprite.GRADA_PIEDRA);
    public static final Cuadro CENTRO_CARRETERA_GIRADO = new Cuadro(Sprite.CENTRO_CARRETERA_GIRADO);
    public static final Cuadro BORDE_CARRETERA_ARENA_INVERTIDOX = new Cuadro(Sprite.BORDE_CARRETERA_ARENA_INVERTIDOX);
    public static final Cuadro BORDE_CARRETERA_ARENA_GIRADO_IZQUIERDA = new Cuadro(Sprite.BORDE_CARRETERA_ARENA_GIRADO_IZQUIERDA);
    public static final Cuadro BORDE_CARRETERA_ARENA_GIRADO_DERECHA = new Cuadro(Sprite.BORDE_CARRETERA_ARENA_GIRADO_DERECHA);
    public static final Cuadro UNION_PARED_PIEDRA_BORDE_CARRETERA_ARENA_INVERTIDOX = new Cuadro(Sprite.UNION_PARED_PIEDRA_BORDE_CARRETERA_ARENA_INVERTIDOX);
    public static final Cuadro ESQUINA_CARRETERA_INVERTIDOX = new Cuadro(Sprite.ESQUINA_CARRETERA_INVERTIDOX);
    public static final Cuadro ESQUINA_CARRETERA_INVERTIDOY = new Cuadro(Sprite.ESQUINA_CARRETERA_INVERTIDOY);
    public static final Cuadro ESQUINA_CARRETERA_INVERTIDOXY = new Cuadro(Sprite.ESQUINA_CARRETERA_INVERTIDOXY);
    //Fin

    public Cuadro(Sprite sprite) {
        this.sprite = sprite;
        solido = false;
    }

    public Cuadro(Sprite sprite, boolean solido) {
        this.sprite = sprite;
        this.solido = solido;
    }

    public void mostrar(int x, int y, Pantalla pantalla) {
        pantalla.mostrarCuadro(x << 5, y << 5, this);
    }

    public boolean esSolido() {
        return solido;
    }
}
