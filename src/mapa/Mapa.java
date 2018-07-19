package mapa;

import graficos.Pantalla;

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
        
    }
}
