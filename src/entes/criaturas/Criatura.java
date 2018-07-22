package entes.criaturas;

import entes.Ente;
import graficos.Sprite;

public abstract class Criatura extends Ente {

    protected Sprite sprite;
    protected char direccion = 'n';
    protected boolean enMovimiento = false;

    public void actualizar() {

    }

    public void mostrar() {

    }

    public void mover(int desplazamientoX, int desplazamientoY) {
        if (desplazamientoX > 0) {
            direccion = 'e';
        }
        if (desplazamientoX < 0) {
            direccion = 'o';
        }
        if (desplazamientoY > 0) {
            direccion = 's';
        }
        if (desplazamientoY < 0) {
            direccion = 'n';
        }

        if (!estaEliminado()) {
            if (!enColision(desplazamientoX, 0)) {
                modificarPosicionX(desplazamientoX);
            }
            if (!enColision(0, desplazamientoY)) {
                modificarPosicionY(desplazamientoY);
            }
        }
    }

    private boolean enColision(int desplazamientoX, int desplazamientoY) {
        boolean colision = false;

        int posicionX = x + desplazamientoX;
        int posicionY = y + desplazamientoY;

        int margenIzquierdo =  -22;
        int margenDerecho = 1;

        int margenSuperior = 1;
        int margenInferior = 10;

        int bordeIzquierdo = (posicionX + margenDerecho) / sprite.obtenerLado();
        int bordeDerecho = (posicionX + margenIzquierdo) / sprite.obtenerLado();
        int bordeSuperior = (posicionY + margenInferior) / sprite.obtenerLado();
        int bordeInferior = (posicionY + margenSuperior) / sprite.obtenerLado();

        if (mapa.obtenerCatalago(bordeIzquierdo + bordeSuperior * mapa.obtenerAncho()).esSolido()) {
            colision = true;
        }
        if (mapa.obtenerCatalago(bordeIzquierdo + bordeInferior * mapa.obtenerAncho()).esSolido()) {
            colision = true;
        }
        if (mapa.obtenerCatalago(bordeDerecho + bordeSuperior * mapa.obtenerAncho()).esSolido()) {
            colision = true;
        }
        if (mapa.obtenerCatalago(bordeDerecho + bordeInferior * mapa.obtenerAncho()).esSolido()) {
            colision = true;
        }

        return colision;
    }

    public Sprite obtenerSprite() {
        return sprite;
    }

}
