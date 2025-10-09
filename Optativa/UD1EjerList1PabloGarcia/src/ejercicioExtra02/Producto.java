package ejercicioExtra02;

public abstract class Producto {

    private static int contador = 0;
    private int id;
	private double precioBase;
	private int unidadesAlmacen;
	private String nombre;
    private int unidadesVendidas;

    public abstract double calcularPVP(double porcentaje, int cantidadFija);

    public Producto(String nombre, double precioBase, int unidadesAlmacen, int unidadesVendidas) {
        this.id = ++contador;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.unidadesAlmacen = unidadesAlmacen;
        this.unidadesVendidas = unidadesVendidas;
    }

    public int getId() { return id; }

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

    @Override
    public String toString() {
        return "ID: " + id + " | " + nombre + " | Precio base: " + precioBase +
                " € | Vendidas: " + unidadesVendidas + " | En almacén: " + unidadesAlmacen;
    }
}
