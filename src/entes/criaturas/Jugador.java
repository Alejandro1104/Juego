package entes.criaturas;

import control.Teclado;
import graficos.Pantalla;
import graficos.Sprite;

public class Jugador extends Criatura {

    private Teclado teclado;
    private int animacion;

    public Jugador(Teclado teclado, Sprite sprite) {
        this.teclado = teclado;
        this.sprite = sprite;
    }

    public Jugador(Teclado teclado, int posicionX, int posicionY, Sprite sprite) {
        this.teclado = teclado;
        this.x = posicionX;
        this.y = posicionY;
        this.sprite = sprite;
    }

    public void actualizar() {
        int desplazamientoX = 0, desplazamientoY = 0;

        if (animacion < 32767) {
            animacion++;
        } else {
            animacion = 0;
        }

        if (teclado.arriba) {
            desplazamientoY--;
        }
        if (teclado.abajo) {
            desplazamientoY++;
        }
        if (teclado.izquierda) {
            desplazamientoX--;
        }
        if (teclado.derecha) {
            desplazamientoX++;
        }

        if (desplazamientoX != 0 || desplazamientoY != 0) {
            mover(desplazamientoX, desplazamientoY);
            enMovimiento = true;
        } else {
            enMovimiento = false;
        }

        if (direccion == 'n') {
            sprite = Sprite.ARRIBA0;
            if (enMovimiento) {
                int resto = animacion % 30;
                if (resto > 10 && resto <= 20) {
                    sprite = Sprite.ARRIBA2;
                } else if (resto > 20) {
                    sprite = Sprite.ARRIBA1;
                } else {
                    sprite = Sprite.ARRIBA0;
                }
            }
        }
        if (direccion == 's') {
            sprite = Sprite.ABAJO0;
            if (enMovimiento) {
                int resto = animacion % 30;
                if (resto > 10 && resto <= 20) {
                    sprite = Sprite.ABAJO2;
                } else if (resto > 20) {
                    sprite = Sprite.ABAJO1;
                } else {
                    sprite = Sprite.ABAJO0;
                }
            }
        }
        if (direccion == 'o') {
            sprite = Sprite.IZQUIERDA0;
            if (enMovimiento) {
                int resto = animacion % 30;
                if (resto > 10 && resto <= 20) {
                    sprite = Sprite.IZQUIERDA2;
                } else if (resto > 20) {
                    sprite = Sprite.IZQUIERDA1;
                } else {
                    sprite = Sprite.IZQUIERDA0;
                }
            }
        }
        if (direccion == 'e') {
            sprite = Sprite.DERECHA0;
            if (enMovimiento) {
                int resto = animacion % 30;
                if (resto > 10 && resto <= 20) {
                    sprite = Sprite.DERECHA2;
                } else if (resto > 20) {
                    sprite = Sprite.DERECHA1;
                } else {
                    sprite = Sprite.DERECHA0;
                }
            }
        }
    }

    public void mostrar(Pantalla pantalla) {
        pantalla.mostrarJugador(x, y, this);
    }

}
