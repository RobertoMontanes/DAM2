package ejercicioExtra01;

public class HabitacionEstandar {
	
	private double precioBase;
	private boolean ocupada;
	private String nombreCliente;
	private int diasOcupacion;
	private int numeroOcupantes;
	private int idHabitacion;
	
	public int getIdHabitacion() {
		return idHabitacion;
	}
	
	public void setIdHabitacion(int idHabitacion) {
		this.idHabitacion = idHabitacion;
	}
	
	
	public double calcularPrecioHabitacion() {
		return precioBase * diasOcupacion;
	}
	
	public String obtenerDatos(boolean soloLibres) {
		String resultado = "";
		if (soloLibres) {
			if (!ocupada) {
				resultado = "HabitacionEstandar[ID de Habitacion = "+idHabitacion+", PrecioBase = "+precioBase+"]";				
			}
		} else {
			resultado = "HabitacionEstandar[ID de Habitacion = "+idHabitacion+", PrecioBase = "+precioBase+","
					+ " Ocupada = "+ocupada+", Nombre del Ocupante = "+nombreCliente+", Dias Ocupada = "+diasOcupacion+","
					+ " Numero de Ocupantes ="+numeroOcupantes+"]";
		}
		return resultado;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	public boolean isOcupada() {
		return ocupada;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public int getDiasOcupacion() {
		return diasOcupacion;
	}

	public void setDiasOcupacion(int diasOcupacion) {
		this.diasOcupacion = diasOcupacion;
	}

	public int getNumeroOcupantes() {
		return numeroOcupantes;
	}

	public void setNumeroOcupantes(int numeroOcupantes) {
		this.numeroOcupantes = numeroOcupantes;
	}

	public HabitacionEstandar(double precioBase, boolean ocupada, String nombreCliente, int diasOcupacion,
			int numeroOcupantes, int idHabitacion) {
		super();
		this.precioBase = precioBase;
		this.ocupada = ocupada;
		this.nombreCliente = nombreCliente;
		this.diasOcupacion = diasOcupacion;
		this.numeroOcupantes = numeroOcupantes;
		this.idHabitacion = idHabitacion;
	}
	
	

}
