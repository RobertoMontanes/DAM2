package ejercicio01;

import java.util.List;
import java.util.Optional;

public class Secretaria {
	
	private List<Alumno> alumnos;
	
	

	public Secretaria(List<Alumno> alumnos) {
		super();
		this.alumnos = alumnos;
	}

	public void agregarAlumno(Alumno alumno) {
		this.alumnos.add(alumno);
	}

	public void mostrarTodos() {
		this.alumnos.forEach(System.out::println);
	}

	public void imprimirPorLetra(char letraAux) {
		String starter = String.valueOf(letraAux);
		this.alumnos.stream().filter(a -> a.getNombre().startsWith(starter)).forEach(System.out::println);
	}

	public int contarAlumnos() {
		return this.alumnos.size();
	}

	public List<Alumno> obtenerPorNotaMayor(double notaAux) {
		List<Alumno> finalList = this.alumnos.stream().filter(a -> a.getNotaMedia() > notaAux).toList();
		return finalList;
	}

	public void imprimirTresPrimeros() {
		this.alumnos.stream().limit(3).forEach(System.out::println);
	}

	public Optional<Alumno> obtenerMenorEdad() {
		int menorEdad = this.alumnos.stream().mapToInt(Alumno::getEdad).min().orElse(-1);
		
		if (menorEdad == -1) {
			return Optional.empty();
		} 
		return this.alumnos.stream().filter(a -> a.getEdad() == menorEdad).findFirst();
	}

	public Optional<Alumno> obtenerPrimerAlumno() {
		return this.alumnos.stream().findFirst();
	}

	public List<Alumno> obtenerPorLongitudNombre(int longitudAux) {
		return this.alumnos.stream().filter(a -> a.getNombre().length() >= longitudAux).toList();
	}

	public List<Alumno> obtenerPorLetraAYLongitud(int longitudAux) {
		return this.alumnos.stream().filter(a -> a.getNombre().length() <= longitudAux).filter(a -> a.getNombre().startsWith("A")).toList();
	}
	
	

}
