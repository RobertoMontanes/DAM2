package ejercicio03;

@SuppressWarnings("serial")
public class RaicesComplejasException extends RuntimeException {
    
	public RaicesComplejasException(String msg) {
		super(msg);
	}
	
	public RaicesComplejasException() {
        super("Las raíces son complejas (el discriminante es menor que 0).");
    }
}