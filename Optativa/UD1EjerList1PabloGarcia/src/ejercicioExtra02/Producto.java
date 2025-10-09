package ejercicioExtra02;

public abstract class Producto {

	private double precioBase;
	private int unidadesAlmacen;
	private String nombre;
    private int unidadesVendidas;

    public abstract double calcularPVP(double porcentaje, int cantidadFija);

    public Producto(double precioBase, int unidadesAlmacen, String nombre) {
        this.precioBase = precioBase;
        this.unidadesAlmacen = unidadesAlmacen;
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public int getUnidadesAlmacen() {
        return unidadesAlmacen;
    }

    public void setUnidadesAlmacen(int unidadesAlmacen) {
        this.unidadesAlmacen = unidadesAlmacen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getUnidadesVendidas() {
        return unidadesVendidas;
    }

    public void setUnidadesVendidas(int unidadesVendidas) {
        this.unidadesVendidas = unidadesVendidas;
    }
}
