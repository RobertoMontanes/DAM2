package ejercicio01;

import java.util.List;

public class Parking {

    private String direccion;
    private List<Vehiculo> vehiculos;
    private double tasaParking;
    private double tasaLongitud;
    private int tamTasa;
    private double descuentoCC;
    private int tamCC;

    public Parking(String direccion, List<Vehiculo> vehiculos, double tasaParking, double tasaLongitud, int tamTasa, double descuentoCC, int tamCC) {
        this.direccion = direccion;
        this.vehiculos = vehiculos;
        this.tasaParking = tasaParking;
        this.tasaLongitud = tasaLongitud;
        this.tamTasa = tamTasa;
        this.descuentoCC = descuentoCC;
        this.tamCC = tamCC;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public double getTasaParking() {
        return tasaParking;
    }

    public void setTasaParking(double tasaParking) {
        this.tasaParking = tasaParking;
    }

    public double getTasaLongitud() {
        return tasaLongitud;
    }

    public void setTasaLongitud(double tasaLongitud) {
        this.tasaLongitud = tasaLongitud;
    }

    public int getTamTasa() {
        return tamTasa;
    }

    public void setTamTasa(int tamTasa) {
        this.tamTasa = tamTasa;
    }

    public double getDescuentoCC() {
        return descuentoCC;
    }

    public void setDescuentoCC(double descuentoCC) {
        this.descuentoCC = descuentoCC;
    }

    public int getTamCC() {
        return tamCC;
    }

    public void setTamCC(int tamCC) {
        this.tamCC = tamCC;
    }

    public void comprobarTamanyo(int tamMin){
        for (Vehiculo v : vehiculos) {
            if (v instanceof Furgoneta){
                System.out.println("Checking van with plate: " + v.getMatricula());
                ((Furgoneta) v).avisarLongitud(tamMin);
            }
        }
    }

    public double calcularRecaudadoMotos() {
        double sum = 0;
        for (Vehiculo v : vehiculos) {
            if (v instanceof Moto) {
                sum += v.calcularPrecio (tasaParking,tasaLongitud,tamTasa,descuentoCC,tamCC);
            }
        }
        return sum;
    }

    public double calcularPrecioUnVehiculo(Vehiculo v) {
        return v.calcularPrecio(tasaParking,tasaLongitud,tamTasa,descuentoCC,tamCC);
    }

    public void mostrarDatos(){
        for (Vehiculo v : vehiculos) {
            System.out.println(v);
        }
    }

    public Vehiculo findByMatricula(String matricula) {
        for (Vehiculo v : vehiculos) {
            if (v.getMatricula().equalsIgnoreCase(matricula)) {
                return v;
            }
        }
        return null;
    }
}
