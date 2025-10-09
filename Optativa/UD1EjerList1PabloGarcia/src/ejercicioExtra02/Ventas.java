package ejercicioExtra02;

import java.util.List;

public class Ventas {

    private Producto[] ventas;

    public Ventas(Producto[] ventas) {
        this.ventas = ventas;
    }

    public double calcularTotalVentas(double porcentaje, int cantidadFija){
        double total = 0;
        for (Producto p : ventas) {
             total += p.getUnidadesVendidas() * p.calcularPVP(porcentaje,cantidadFija);
        }
        return total;
    }

    public double calcularCambio(Producto p, double pagado, int cantidad,double porcentaje, int cantidadFija) {
        // Te dice cuanto tienes que devolverle al cliente basandote en cuantos productos va a comprar y cuanto te ha pagado
        return p.calcularPVP(porcentaje,cantidadFija) * cantidad - pagado;
    }

    public void listarProductos(){
        for (Producto p : ventas) {
            System.out.println(p);
        }
    }

    public void checkAlmacen(){
        for (Producto p : ventas) {
            System.out.println("Quedan: " + p.getUnidadesAlmacen() + " unidadesd de " + p.getNombre() + " en el almacen");
        }
    }

}
