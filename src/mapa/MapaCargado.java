package mapa;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import mapa.cuadro.Cuadro;

public class MapaCargado extends Mapa {

    private int[] pixeles;

    public MapaCargado(String ruta) {
        super(ruta);
    }

    protected void cargarMapa(String ruta) {
        try {
            BufferedImage imagen = ImageIO.read(MapaCargado.class.getResource(ruta));
            ancho = imagen.getWidth();
            alto = imagen.getHeight();

            catalogo = new Cuadro[ancho * alto];
            pixeles = new int[ancho * alto];

            imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void generarMapa() {
        for (int i = 0; i < pixeles.length; i++) {
            switch (pixeles[i]) {
                case 0xff2b2b2b:
                    catalogo[i] = Cuadro.ASFALTO;
                    continue;
                case 0xffd3ad78:
                    catalogo[i] = Cuadro.ARENA;
                    continue;
                case 0xff696969:
                    catalogo[i] = Cuadro.BORDE_CARRETERA_ARENA;
                    continue;
                case 0xff050505:
                    catalogo[i] = Cuadro.CENTRO_CARRETERA;
                    continue;
                case 0xff5f4747:
                    catalogo[i] = Cuadro.ESQUINA_CARRETERA;
                    continue;
                case 0xff69624b:
                    catalogo[i] = Cuadro.PARED_PIEDRA;
                    continue;
                case 0xffa09673:
                    catalogo[i] = Cuadro.BORDE_PARED_PIEDRA_ARENA;
                    continue;
                case 0xff62351c:
                    catalogo[i] = Cuadro.PUERTA_PARTE_SUPERIOR;
                    continue;
                case 0xff744b30:
                    catalogo[i] = Cuadro.PUERTA_PARTE_INFERIOR;
                    continue;
                case 0xff6d623a:
                    catalogo[i] = Cuadro.UNION_PARED_PIEDRA_BORDE_CARRETERA_ARENA;
                    continue;
                case 0xff917a2c:
                    catalogo[i] = Cuadro.BORDE_PARED_PIEDRA_ASFALTO;
                    continue;
                case 0xffc1bba0:
                    catalogo[i] = Cuadro.GRADA_PIEDRA;
                    continue;
                default:
                    catalogo[i] = Cuadro.VACIO;
            }
        }
    }

}
