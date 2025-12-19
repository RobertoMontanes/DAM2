package ejercicio03;

import java.time.Period;
import java.util.List;

public class Cancion {

	private String nombre;
	private Period duracion;
	private List<Genero> generos;
	private String autor;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Period getDuracion() {
		return duracion;
	}
	
	public void setDuracion(Period duracion) {
		this.duracion = duracion;
	}
	
	public List<Genero> getGeneros() {
		return generos;
	}
	
	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public Cancion(String nombre, Period duracion, List<Genero> generos, String autor) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.generos = generos;
		this.autor = autor;
	}
	
	
	
	
	
}
