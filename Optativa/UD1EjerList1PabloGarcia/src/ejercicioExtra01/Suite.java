package ejercicioExtra01;

public class Suite extends HabitacionEstandar {
	
	private double metrosCuadrados;
	private double dineroConsumidoEnServicios;
	private double porcentajeDescuento;
	
	public double calcularPrecioHabitacion() {
		double basePorcentajes = 100,precioFinal;
		precioFinal = super.calcularPrecioHabitacion() + dineroConsumidoEnServicios;

		return precioFinal - ((precioFinal * porcentajeDescuento) / basePorcentajes);
	}

	public double getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public void setMetrosCuadrados(double metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}

	public double getDineroConsumidoEnServicios() {
		return dineroConsumidoEnServicios;
	}

	public void setDineroConsumidoEnServicios(double dineroConsumidoEnServicios) {
		this.dineroConsumidoEnServicios = dineroConsumidoEnServicios;
	}

	public double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public Suite(double precioBase, boolean ocupada, String nombreCliente, int diasOcupacion, int numeroOcupantes,
			int idHabitacion, double metrosCuadrados, double dineroConsumidoEnServicios, double porcentajeDescuento) {
		super(precioBase, ocupada, nombreCliente, diasOcupacion, numeroOcupantes, idHabitacion);
		this.metrosCuadrados = metrosCuadrados;
		this.dineroConsumidoEnServicios = dineroConsumidoEnServicios;
		this.porcentajeDescuento = porcentajeDescuento;
	}
	
	
	public String obtenerDatos(boolean soloLibres) {
		String resultado = "";
		resultado = super.obtenerDatos(soloLibres);
		if(!resultado.equals("")) {
			resultado += " Suite[Metros Cuadrados = "+metrosCuadrados+" m2, Dinero gastado en servicios Extras = "+dineroConsumidoEnServicios+", Descuento aplicable a la renta = "+porcentajeDescuento+"% ]"; 
		}
		return resultado;
	}
	
	
}
