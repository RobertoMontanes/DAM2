package ejercicioMap;

import java.util.Set;

public class Gestion {
	
	private Set<Producto> productos;

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	public Gestion(Set<Producto> productos) {
		super();
		this.productos = productos;
	}
	
	
	

}
