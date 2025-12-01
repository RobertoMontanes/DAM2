
package ejercicio00;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class Tienda {
	
	private Set<Producto> productos;
	private Set<Venta> ventas;
	private int idCont;
	
	public Tienda(Set<Producto> productos) {
		this.productos = productos;
		this.ventas = new TreeSet<Venta>();
		this.idCont = 0;
	}
	
	public Tienda(Set<Producto> productos, Set<Venta> ventas, int idCont) {
		super();
		this.productos = productos;
		this.ventas = ventas;
		this.idCont = idCont;
	}

	public Tienda(Set<Producto> productos, int idCont) {
		this.productos = productos;
		this.ventas = new TreeSet<Venta>();
		this.idCont = idCont;
	}
	
	public Set<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(Set<Venta> ventas) {
		this.ventas = ventas;
	}

	public int getIdCont() {
		return idCont;
	}

	public void setIdCont(int idCont) {
		this.idCont = idCont;
	}

	public boolean addProducto(Producto p) {
		if (findProductoById(p.getId()).isEmpty()) {
			this.productos.add(p);
			return true;
		}
		return false;
	}
	
	public Venta addVenta(Map<Producto, Integer> lineasVenta) {
		Venta nueva = new Venta(lineasVenta, LocalDateTime.now(), generarIdVenta());
		this.ventas.add(nueva);
		return nueva;
	}
	
	private int generarIdVenta() {
		idCont += 1;
		return idCont - 1;
	}

	public Venta addLinea(Venta v, Producto p, int cantidad) {
		Map<Producto, Integer> newLineas = v.getLineasVenta();
		if (newLineas.containsKey(p)) {
			newLineas.put(p, v.getLineasVenta().get(p) + cantidad);
		} else {
			newLineas.put(p, cantidad);
		}
		v.setLineasVenta(newLineas);
		return v;
	}
	
	public Optional<Producto> findProductoById(Integer id) {
		for (Iterator<Producto> iterator = productos.iterator(); iterator.hasNext();) {
			Producto producto = (Producto) iterator.next();
			if (producto.getId() == id) {
				return Optional.of(producto);
			}
		}
		return Optional.empty();
	}

	public Venta getVentaById(int id) {
		for (Venta v : ventas) {
			if (v.getId() == id) {
				return v;			}
		}
		return null;
	}

	public void addAllProductos(Set<Producto> productos) {
		for(Producto p : productos) {
			this.addProducto(p);
		}
	}

	public void generarVentas() {
		Set<Integer> idProductos = new LinkedHashSet<Integer>();
		
		for (Producto p : productos) {
			idProductos.add(p.getId());
		}
		
		
		
	}

}
