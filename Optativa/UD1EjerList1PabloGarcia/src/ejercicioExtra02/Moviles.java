package ejercicioExtra02;

public class Moviles extends Producto {

    private String marca;
    private String modelo;

    public Moviles(String nombre, double precioBase, int unidadesAlmacen, int unidadesVendidas, String marca, String modelo) {
        super(nombre, precioBase, unidadesAlmacen, unidadesVendidas);
        this.marca = marca;
        this.modelo = modelo;
    }


    @Override
    public double calcularPVP(double porcentaje, int cantidadFija) {
        int basePorcentaje = 100;
        double finalPorcent = (porcentaje / basePorcentaje) + 1;
        return super.getPrecioBase() * finalPorcent;
    }

    @Override
    public String toString() {
        return super.toString() + " | Marca: " + marca + " | Modelo: " + modelo;
    }

}
