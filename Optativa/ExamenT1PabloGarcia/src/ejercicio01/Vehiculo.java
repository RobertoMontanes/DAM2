package ejercicio01;

public class Vehiculo {

    private String matricula;
    private int minEstacionado;

    public Vehiculo(String matricula, int minEstacionado) {
        this.matricula = matricula;
        this.minEstacionado = minEstacionado;
    }



    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getMinEstacionado() {
        return minEstacionado;
    }

    public void setMinEstacionado(int minEstacionado) {
        this.minEstacionado = minEstacionado;
    }

    public double calcularPrecio(double tasaParking, double tasaLongitud, int tamTasa, double descuentoCC, int tamCC) {
        return tasaParking * this.minEstacionado;
    }

}
