package ejercicioExtra02;

public class EspadasLaser extends Producto {
//
    private String tipo;

    public EspadasLaser(double precioBase, int unidadesAlmacen, String nombre, String tipo) {
        super(precioBase, unidadesAlmacen, nombre);
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
}
