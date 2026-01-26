package ejercicioExamen;

@SuppressWarnings("serial")
public class CalculoInvalidoException extends RuntimeException {

	public CalculoInvalidoException() {
		super("The operation is invalid.");
	}
	
	public CalculoInvalidoException(String msg) {
		super(msg);
	}
	
}
