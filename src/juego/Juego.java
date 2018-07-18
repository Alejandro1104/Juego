package juego;

import control.Teclado;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Juego extends Canvas implements Runnable {

    private static JFrame ventana;
    private static Thread hilo;

    private static final int ANCHO = 800, ALTO = 600;
    private static final String NOMBRE = "Juego";
    private static int aps = 0, fps = 0;
    private static volatile boolean enFuncionamiento = false;
    private static Teclado teclado;

    private Juego() {
        this.setPreferredSize(new Dimension(ANCHO, ALTO));

        teclado = new Teclado();
        this.addKeyListener(teclado);

        ventana = new JFrame(NOMBRE);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLayout(new BorderLayout());
        ventana.add(this, BorderLayout.CENTER);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.iniciar();
    }

    private synchronized void iniciar() {
        enFuncionamiento = true;

        hilo = new Thread(this, "Graficos");
        hilo.start();
    }

    private synchronized void detener() {
        enFuncionamiento = false;

        try {
            hilo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void actualizar() {
        teclado.actualizar();
        if (teclado.arriba) {
            System.out.println("arriba");
        } else if (teclado.abajo) {
            System.out.println("abajo");
        } else if (teclado.izquierda) {
            System.out.println("izquierda");
        } else if (teclado.derecha) {
            System.out.println("derecha");
        }
        
        aps++;
    }

    private void mostrar() {
        fps++;
    }

    public void run() {
        final int NS_POR_SEGUNDO = 1000000000;
        final byte APS_OBJETIVO = 60;
        final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;

        long referenciaActualizacion = System.nanoTime();
        long referenciaContador = System.nanoTime();
        double tiempoTranscurrido;
        double delta = 0;
        
        this.requestFocus();

        while (enFuncionamiento) {
            final long inicioBucle = System.nanoTime();
            tiempoTranscurrido = inicioBucle - referenciaActualizacion;
            referenciaActualizacion = inicioBucle;
            delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;

            while (delta >= 1) {
                actualizar();
                delta--;
            }

            mostrar();

            if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
                ventana.setTitle(NOMBRE + " || APS: " + aps + " || FPS: " + fps);
                aps = 0;
                fps = 0;
                referenciaContador = System.nanoTime();
            }
        }
    }
}
