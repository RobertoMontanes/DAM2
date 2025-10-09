package ejercicioExtra01;

public class Apartamento extends HabitacionEstandar{
	
	private boolean servicioLimpieza;
	private double precioServicioLimpieza;
	
	public double calcularPrecioHabitacion() {
		double extras= 0;
		if (servicioLimpieza) {
			extras = precioServicioLimpieza;
		}
		return super.calcularPrecioHabitacion() + extras;
	}

	public boolean isServicioLimpieza() {
		return servicioLimpieza;
	}

	public void setServicioLimpieza(boolean servicioLimpieza) {
		this.servicioLimpieza = servicioLimpieza;
	}

	public double getPrecioServicioLimpieza() {
		return precioServicioLimpieza;
	}

	public void setPrecioServicioLimpieza(double precioServicioLimpieza) {
		this.precioServicioLimpieza = precioServicioLimpieza;
	}

	public Apartamento(double precioBase, boolean ocupada, String nombreCliente, int diasOcupacion, int numeroOcupantes,
			int idHabitacion, boolean servicioLimpieza, double precioServicioLimpieza) {
		super(precioBase, ocupada, nombreCliente, diasOcupacion, numeroOcupantes, idHabitacion);
		this.servicioLimpieza = servicioLimpieza;
		this.precioServicioLimpieza = precioServicioLimpieza;
	}
	
	public String obtenerDatos(boolean soloLibres) {
		String resultado = "";
		resultado = super.obtenerDatos(soloLibres);
		if(!resultado.equals("")) {
			resultado += " Apartamento[?Servicio de limpieza contratado? = "+servicioLimpieza+", Precio servicio de limpieza = "+precioServicioLimpieza+"]"; 
		}
		return resultado;
	}
	
	

}
