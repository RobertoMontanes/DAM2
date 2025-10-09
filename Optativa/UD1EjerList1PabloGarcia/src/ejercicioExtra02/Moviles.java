package ejercicioExtra02;

public class Moviles extends Producto {

    private String marca;
    private String modelo;

    public Moviles(double precioBase, int unidadesAlmacen, String nombre, String marca, String modelo) {
        super(precioBase, unidadesAlmacen, nombre);
        this.marca = marca;
        this.modelo = modelo;
    }


    @Override
    public double calcularPVP(double porcentaje, int cantidadFija) {
        int basePorcentaje = 100;
        double finalPorcent = (porcentaje / basePorcentaje) + 1;
        return super.getPrecioBase() * finalPorcent;
    }
}
