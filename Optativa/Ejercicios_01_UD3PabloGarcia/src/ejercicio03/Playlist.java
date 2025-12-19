package ejercicio03;

import java.util.List;

public class Playlist {
	
	private List<Cancion> canciones;

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}

	public Playlist(List<Cancion> canciones) {
		super();
		this.canciones = canciones;
	}

	public List<Cancion> findByNombre(String nombre) {
		return canciones.stream().filter(c ->  c.getNombre().toLowerCase().contains(nombre.toLowerCase()) ).toList();
	}

	public List<Cancion> findByAutor(String nombreAutor) {
		return canciones.stream().filter(c ->  c.getAutor().toLowerCase().contains(nombreAutor.toLowerCase()) ).toList();
	}

}
