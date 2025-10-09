package ejercicioExtra02;

public class EspadasLaser extends Producto {
//
    private String tipo;

    public EspadasLaser(String nombre, double precioBase, int unidadesAlmacen, int unidadesVendidas, String tipo) {
        super(nombre, precioBase, unidadesAlmacen, unidadesVendidas);
        this.tipo = tipo;
    }

    @Override
    public double calcularPVP(double porcentaje, int cantidadFija) {

        int basePorcentaje = 100;
        double precioFinal =  super.getPrecioBase() +  ( porcentaje * super.getPrecioBase() ) / basePorcentaje;
        if (this.tipo == "doble") {
            precioFinal += cantidadFija;
        }

        return precioFinal;
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: " + tipo;
    }
}
