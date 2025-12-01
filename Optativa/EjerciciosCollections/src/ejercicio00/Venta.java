package ejercicio00;

import java.time.LocalDateTime;
import java.util.Map;

public class Venta {
	
	private int id;
	private Map<Producto,Integer> lineasVenta;
	private LocalDateTime fecha;
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<Producto, Integer> getLineasVenta() {
		return lineasVenta;
	}

	public void setLineasVenta(Map<Producto, Integer> lineasVenta) {
		this.lineasVenta = lineasVenta;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Venta(Map<Producto, Integer> lineasVenta, LocalDateTime fecha, int id) {
		super();
		this.id = id;
		this.lineasVenta = lineasVenta;
		this.fecha = fecha;
	}
	
	

}
