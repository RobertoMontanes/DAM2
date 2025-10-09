package ejercicio11;

public class Controlado extends Empleado {

    private int horasTrabajadas;
    private double precioPorHora;


    public Controlado(String nombre, int antiguedad, double precioAntiguedad, int horasExtra, double precioHorasExtra, int horasTrabajadas, double precioPorHora) {
        super(nombre, antiguedad, 0, precioAntiguedad, horasExtra, precioHorasExtra);
        this.horasTrabajadas = horasTrabajadas;
        this.precioPorHora = precioPorHora;
    }

    @Override
    public double calcularSueldo() {
        return super.calcularSueldo() + (horasTrabajadas * precioPorHora);
    }
}
