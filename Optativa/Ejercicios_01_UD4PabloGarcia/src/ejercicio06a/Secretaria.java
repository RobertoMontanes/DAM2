package ejercicio06a;

import java.util.Comparator;
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

	public void mostrarTodos() throws AlumnoNoEncontradoException {
        if (alumnos.isEmpty()) throw new AlumnoNoEncontradoException("No hay alumnos registrados.");
        this.alumnos.forEach(System.out::println);
    }

	public void imprimirPorLetra(char letraAux) {
		String starter = String.valueOf(letraAux);
		this.alumnos.stream().filter(a -> a.getNombre().startsWith(starter)).forEach(System.out::println);
	}

	public int contarAlumnos() {
		return this.alumnos.size();
	}

	public List<Alumno> obtenerPorNotaMayor(double notaAux) throws AlumnoNoEncontradoException {
        List<Alumno> resultado = this.alumnos.stream()
                .filter(a -> a.getNotaMedia() > notaAux)
                .toList();
        
        if (resultado.isEmpty()) 
            throw new AlumnoNoEncontradoException("Ningún alumno supera la nota de " + notaAux);
        
        return resultado;
    }

	public void imprimirTresPrimeros() {
		this.alumnos.stream().limit(3).forEach(System.out::println);
	}

	public Alumno obtenerMenorEdad() throws AlumnoNoEncontradoException {
        return this.alumnos.stream()
                .min(Comparator.comparingInt(Alumno::getEdad))
                .orElseThrow(() -> new AlumnoNoEncontradoException("No se pudo determinar el alumno más joven (lista vacía)."));
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
