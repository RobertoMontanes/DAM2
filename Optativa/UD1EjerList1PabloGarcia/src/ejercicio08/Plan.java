package ejercicio08;

import java.util.ArrayList;
import java.util.List;

public class Plan {

    private String nombre;
    private double precioBase;
    private int dispositivos;
    private String calidadImagen;
    private List<String> extras;
    private boolean anuncios;

    public Plan(String nombre, double precioBase, int dispositivos, String calidadImagen, List<String> extras, boolean anuncios) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.dispositivos = dispositivos;
        this.calidadImagen = calidadImagen;
        this.extras = extras;
        this.anuncios = anuncios;
    }

    public double calcularPVP(double annadidoExtras, double annadidoDispositivos, int descuentoAnnadidoQt, double descuentoAnnadidoPr, double annadidoAnuncios) {
        double precioFinal = precioBase, basePorcentaje = 100;

        precioFinal += (annadidoExtras * this.extras.size()); // Si es 0, 0 * X = 0;
        precioFinal += (annadidoDispositivos * this.dispositivos); // Si es 0, 0 * X = 0;

        if (this.extras.size() >= descuentoAnnadidoQt) {
            precioFinal =- (basePorcentaje * descuentoAnnadidoPr) / precioBase;
        }

        if (this.anuncios) {
            precioFinal += annadidoAnuncios;
        }

        return precioFinal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public int getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(int dispositivos) {
        this.dispositivos = dispositivos;
    }

    public String getCalidadImagen() {
        return calidadImagen;
    }

    public void setCalidadImagen(String calidadImagen) {
        this.calidadImagen = calidadImagen;
    }

    public List<String> getExtras() {
        return extras;
    }

    public void setExtras(List<String> extras) {
        this.extras = extras;
    }
}
