package ejercicio06a;

@SuppressWarnings("serial")
public class AlumnoNoEncontradoException extends RuntimeException {
	public AlumnoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
