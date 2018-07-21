package mapa;

import graficos.Pantalla;
import mapa.cuadro.Cuadro;

public abstract class Mapa {

    protected int ancho, alto;
    protected int[] tiles;

    public Mapa(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;

        tiles = new int[ancho * alto];
        generarMapa();
    }

    public Mapa(String ruta) {
        cargarMapa(ruta);
    }

    protected void generarMapa() {

    }

    private void cargarMapa(String ruta) {

    }

    public void actualizar() {

    }

    public void mostrar(int compensacionX, int compensacionY, Pantalla pantalla) {
        pantalla.modificarDiferencia(compensacionX, compensacionY);

        int oeste = compensacionX >> 5,
                este = (compensacionX + pantalla.obtenerAncho() + Cuadro.LADO) >> 5,
                norte = compensacionY >> 5,
                sur = (compensacionY + pantalla.obtenerAlto() + Cuadro.LADO) >> 5;

        for (int y = norte; y < sur; y++) {
            for (int x = oeste; x < este; x++) {
                obtenerCuadro(x, y).mostrar(x, y, pantalla);
            }
        }
    }

    public Cuadro obtenerCuadro(final int x, final int y) {
        if (x < 0 || y < 0 || x >= ancho || y >= alto) {
            return Cuadro.VACIO;
        }
        switch (tiles[x + y * ancho]) {
            case 0:
                return Cuadro.ASFALTO;
            case 1:
                return Cuadro.ARENA;
            case 2:
                return Cuadro.BORDE_CARRETERA_ARENA;
            case 3:
                return Cuadro.CENTRO_CARRETERA;
            case 4:
                return Cuadro.ESQUINA_CARRETERA;
            case 5:
                return Cuadro.PARED_PIEDRA;
            case 6:
                return Cuadro.BORDE_PARED_PIEDRA_ARENA;
            case 7:
                return Cuadro.PUERTA_PARTE_SUPERIOR;
            case 8:
                return Cuadro.PUERTA_PARTE_INFERIOR;
            case 9:
                return Cuadro.UNION_PARED_PIEDRA_BORDE_CARRETERA_ARENA;
            case 10:
                return Cuadro.BORDE_PARED_PIEDRA_ASFALTO;
            case 11:
                return Cuadro.GRADA_PIEDRA;
            default:
                return Cuadro.VACIO;
        }
    }
}
