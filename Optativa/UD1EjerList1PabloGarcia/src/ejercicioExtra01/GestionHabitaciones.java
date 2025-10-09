package ejercicioExtra01;

public class GestionHabitaciones {
	
	private HabitacionEstandar[] habitaciones;
	
	public GestionHabitaciones(HabitacionEstandar[] habitaciones) {
		super();
		this.habitaciones = habitaciones;
	}

	public HabitacionEstandar[] getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(HabitacionEstandar[] habitaciones) {
		this.habitaciones = habitaciones;
	}

	public double calcularPrecioHabitaciones(int idHabitacion) {
		HabitacionEstandar habitacionObjetivo;
		double precioFinal = -1;
		habitacionObjetivo = buscarHabitacionPorID(idHabitacion);
		if (habitacionObjetivo != null) {
			precioFinal = calcularPrecioHabitacion(habitacionObjetivo);
		} 
		return precioFinal;
	};
	
	public double calcularPrecioHabitacion(HabitacionEstandar habitacion) {
		return habitacion.calcularPrecioHabitacion();
	}
	
	
	public double calcularPrecioHabitacionesOcupadas() {
		double resultadoFinal = 0;
		for (int i = 0; i < habitaciones.length && habitaciones[i] != null; i++) {
			if (habitaciones[i].isOcupada()) {
				resultadoFinal += calcularPrecioHabitacion(habitaciones[i]);
			}
		}
		return resultadoFinal;
	}
	

	public HabitacionEstandar buscarHabitacionPorID(int idHabitacion) {
		HabitacionEstandar habitacion = null;
		boolean encontrada = false;
		
		for (int i = 0; i < habitaciones.length && habitaciones[i] != null && !encontrada; i++) {
			if (habitaciones[i].getIdHabitacion() == idHabitacion) {
				habitacion = habitaciones[i];
			}
		}
		
		return habitacion;
	}
	
	public double calcularRecaudacionTotal() {
		double precioTotal = 0;
		for (int i = 0; i < habitaciones.length && habitaciones[i] != null; i++) {
			precioTotal = calcularPrecioHabitacion(habitaciones[i]);
		}
		return precioTotal;
	};
	
	public void mostrarHabitaciones(boolean soloLibres) {
		String resultado = "";
		for (int i = 0; i < habitaciones.length && habitaciones[i] != null; i++) {
			resultado = obtenerDatosHabitacion(soloLibres, habitaciones[i]);
			if (!resultado.equals("")) {
				System.out.println(resultado);
			}
		}
	};
	
	public String obtenerDatosHabitacion(boolean soloLibres, HabitacionEstandar habitacion) {
		return habitacion.obtenerDatos(soloLibres);
	}
	
	public void mostrarTicketHabitacion(int idHabitacion) {
		HabitacionEstandar habitacionObjetivo;
		habitacionObjetivo = buscarHabitacionPorID(idHabitacion);
		double descuentos = 0;
		descuentos = obtenerDescuentos(habitacionObjetivo);
		double precioHabitacion = 0;
		precioHabitacion = calcularPrecioHabitacion(habitacionObjetivo);
		
		String tipoHabitacion;
		tipoHabitacion = obtenerTipoHabitacion(habitacionObjetivo);
		int tamMin = 10;
		while(tipoHabitacion.length() < tamMin) {
			tipoHabitacion += " ";
		}
		
		if (habitacionObjetivo != null) {
			if (habitacionObjetivo.isOcupada()) {
				System.out.printf("""
						TICKET DE HABITACION A NOMBRE DE %s
				Tipo de Habitacion		Precio/Dia	Extra por servicios		Dias Ocupada	Ocupantes
				%s			%.2f/Dia		%.2f				%d		%d
					
							SubTotal:	%.2f Euros
							Descuento:	%.2f Euros
							Total:		%.2f Euros
				""",
				habitacionObjetivo.getNombreCliente(),tipoHabitacion,habitacionObjetivo.getPrecioBase(),obtenerServiciosExtra(habitacionObjetivo),
				habitacionObjetivo.getDiasOcupacion(),habitacionObjetivo.getNumeroOcupantes(),
				precioHabitacion + descuentos,
				descuentos,
				precioHabitacion
				);
			} else {
				System.out.println("No puedes solicitar el ticket de una habitacion que este Libre.");
			}
		} else {
			System.out.println("No existe habitacion con ese ID");
		}

	}
	
	public String obtenerTipoHabitacion(HabitacionEstandar habitacion) {
		String tipoHabitacion;
		if (habitacion instanceof Suite) {
			tipoHabitacion = "Suite";
		} else if (habitacion instanceof Apartamento) {
			tipoHabitacion = "Apartamento";
		} else {
			tipoHabitacion = "Habitacion Estandar";
		}
		return tipoHabitacion;
	}
	
	public double obtenerServiciosExtra(HabitacionEstandar habitacion) {
		double totalExtras;
		if (habitacion instanceof Suite) {
			totalExtras = ((Suite) habitacion).getDineroConsumidoEnServicios();
		} else if (habitacion instanceof Apartamento) {
			totalExtras = ((Apartamento) habitacion).getPrecioServicioLimpieza();
		} else {
			totalExtras = 0;
		}
		return totalExtras;
	}
	
	public double obtenerDescuentos(HabitacionEstandar habitacion) {
		double descuentos;
		double basePorcentaje = 100;
		if (habitacion instanceof Suite) {
			descuentos = ( (habitacion.getPrecioBase() * habitacion.getDiasOcupacion()) *  ((Suite) habitacion).getPorcentajeDescuento()) / basePorcentaje ;
		} else {
			descuentos = 0;
		}
		return descuentos;
	}
}
