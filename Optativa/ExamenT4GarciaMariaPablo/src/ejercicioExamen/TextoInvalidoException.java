package ejercicioExamen;

@SuppressWarnings("serial")
public class TextoInvalidoException extends RuntimeException {

	public TextoInvalidoException() {
		super("The inserted text is invalid.");
	}
	
	public TextoInvalidoException(String msg) {
		super(msg);
	}
	
}
