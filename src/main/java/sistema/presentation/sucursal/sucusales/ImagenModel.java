package sistema.presentation.sucursal.sucusales;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.Objects;

public class ImagenModel extends JLabel {

    private BufferedImage mapa = null;
    private List<Point> ubicSucursales;

    public ImagenModel(List<Point> ubicaciones) {
        this.ubicSucursales = ubicaciones;
        mostrarImagen();
    }

    public void mostrarImagen() {
        try {
            mapa = ImageIO.read(new File("src/main/resources/imagenes/mapa.png"));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrio un error al cargar la imagen");
        }
    }

    public JLabel mostrarUbicaciones() {
        try {
            BufferedImage icono = ImageIO.read(new File("Sucursal.png"));

            for (int i = 0; i < ubicSucursales.size(); i++) {
                Graphics graphics = mapa.getGraphics();
                graphics.drawImage(mapa, 0, 0, null);
                graphics.drawImage(icono, ubicSucursales.get(i).x , ubicSucursales.get(i).y, null);
            }
            ImageIO.write(mapa, "png", new File("mapaCargar.png"));
            this.setIcon(new ImageIcon("mapaCargar.png"));
            return this;

        } catch (Exception e) {
        }
        return this;
    }


    public BufferedImage getMapa() {
        return mapa;
    }

    public void setMapa(BufferedImage mapa) {
        this.mapa = mapa;
    }

    public List<Point> getUbicSucursales() {
        return ubicSucursales;
    }

    public void setUbicSucursales(List<Point> ubicSucursales) {
        this.ubicSucursales = ubicSucursales;
    }
}