package ejercicio11;

public class Administrativo extends Empleado{

    private int documentosTrabajados;
    private double extraDocumentos;

    public Administrativo(String nombre, int antiguedad, double sueldoBase, double precioAntiguedad, int horasExtra, double precioHorasExtra, int documentosTrabajados, double extraDocumentos) {
        super(nombre, antiguedad, sueldoBase, precioAntiguedad, horasExtra, precioHorasExtra);
        this.documentosTrabajados = documentosTrabajados;
        this.extraDocumentos = extraDocumentos;
    }

    @Override
    public double calcularSueldo() {
        return super.calcularSueldo() + (this.documentosTrabajados * this.extraDocumentos);
    }
}
