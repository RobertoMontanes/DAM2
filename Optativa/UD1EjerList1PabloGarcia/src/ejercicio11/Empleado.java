package ejercicio11;

public class Empleado {

    private String nombre;
    private int antiguedad;
    private double sueldoBase;
    private double precioAntiguedad;
    private int horasExtra;
    private double precioHorasExtra;

    public Empleado(String nombre, int antiguedad, double sueldoBase, double precioAntiguedad, int horasExtra, double precioHorasExtra) {
        this.nombre = nombre;
        this.antiguedad = antiguedad;
        this.sueldoBase = sueldoBase;
        this.precioAntiguedad = precioAntiguedad;
        this.horasExtra = horasExtra;
        this.precioHorasExtra = precioHorasExtra;
    }

    public double calcularSueldo(){
        return sueldoBase + (antiguedad*precioAntiguedad) + (horasExtra * precioHorasExtra);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public double getPrecioAntiguedad() {
        return precioAntiguedad;
    }

    public void setPrecioAntiguedad(double precioAntiguedad) {
        this.precioAntiguedad = precioAntiguedad;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }

    public double getPrecioHorasExtra() {
        return precioHorasExtra;
    }

    public void setPrecioHorasExtra(double precioHorasExtra) {
        this.precioHorasExtra = precioHorasExtra;
    }
}

