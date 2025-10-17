package ejercicio01;

public class Furgoneta extends Vehiculo{

    private int longitud;

    public Furgoneta(String matricula, int minEstacionado, int longitud) {
        super(matricula, minEstacionado);
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return super.toString() + ", Furgoneta{" +
                "longitud=" + longitud +
                '}';
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    @Override
    public double calcularPrecio(double tasaParking, double tasaLongitud, int tamTasa, double descuentoCC, int tamCC) {
        double precioFinal = super.calcularPrecio(tasaParking,tasaLongitud,tamTasa,descuentoCC,tamCC);
        if (this.longitud > tamTasa) {
            precioFinal += tasaLongitud * (longitud - tamTasa);
        }
        return precioFinal;
    }

    public void avisarLongitud(int tamMin){
        if (longitud > tamMin) {
            System.out.println("¡Cuidado, aparcar en zona especial!");
        }
    }

}
