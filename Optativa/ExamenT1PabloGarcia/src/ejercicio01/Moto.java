package ejercicio01;

public class Moto extends Vehiculo {

    private int centcub;

    public Moto(String matricula, int minEstacionado, int centcub) {
        super(matricula, minEstacionado);
        this.centcub = centcub;
    }

    @Override
    public String toString() {
        return super.toString() + ", Moto{" +
                "centcub=" + centcub +
                '}';
    }

    public int getCentcub() {
        return centcub;
    }

    public void setCentcub(int centcub) {
        this.centcub = centcub;
    }

    @Override
    public double calcularPrecio(double tasaParking, double tasaLongitud, int tamTasa, double descuentoCC, int tamCC) {
        double precioFinal = super.calcularPrecio(tasaParking,tasaLongitud,tamTasa,descuentoCC,tamCC);
        if (this.centcub < tamCC) {
            precioFinal = precioFinal / descuentoCC;
        }
        return precioFinal;
    }

}
