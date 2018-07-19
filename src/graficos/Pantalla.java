package graficos;

import mapa.cuadro.Cuadro;

public final class Pantalla {

    private final int ancho, alto;
    
    private int diferenciaX, diferenciaY;

    public final int[] pixeles;

    public Pantalla(final int ancho, final int alto) {
        this.ancho = ancho;
        this.alto = alto;

        pixeles = new int[ancho * alto];
    }

    public void limpiar() {
        for (int i = 0; i < pixeles.length; i++) {
            pixeles[i] = 0;
        }
    }

    public void mostrarCuadro(int compensacionX, int compensacionY, Cuadro cuadro) {
        compensacionX -= diferenciaX;
        compensacionY -= diferenciaY;
        
        for (int y = 0; y < cuadro.sprite.obtenerLado(); y++) {
            int posicionY = y + compensacionY;

            for (int x = 0; x < cuadro.sprite.obtenerLado(); x++) {
                int posicionX = x + compensacionX;
                if (posicionX < -cuadro.sprite.obtenerLado() || posicionX >= ancho || posicionY < 0 || posicionY >= alto) {
                    break;
                }
                if (posicionX < 0) {
                    posicionX = 0;
                }
                pixeles[posicionX + posicionY * ancho] = cuadro.sprite.pixeles[x + y * cuadro.sprite.obtenerLado()];
            }
        }
    }
    
    public void modificarDiferencia(final int diferenciaX, final int diferenciaY) {
        this.diferenciaX = diferenciaX;
        this.diferenciaY = diferenciaY;
    }
    
    public int obtenerAncho() {
        return ancho;
    }
    
    public int obtenerAlto() {
        return alto;
    }
}
