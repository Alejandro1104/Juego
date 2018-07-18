package graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class HojaSprites {

    private final int ancho, alto;
    public final int[] pixeles;

    public HojaSprites(final String ruta, final int ancho, final int alto) {
        this.ancho = ancho;
        this.alto = alto;
        pixeles = new int[ancho * alto];

        BufferedImage imagen;
        try {
            imagen = ImageIO.read(HojaSprites.class.getResource(ruta));
            imagen.getRGB(0, 0, this.ancho, this.alto, pixeles, 0, this.ancho);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int obtenerAncho() {
        return ancho;
    }
}
