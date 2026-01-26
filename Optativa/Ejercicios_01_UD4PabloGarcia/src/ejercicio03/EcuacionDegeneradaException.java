package ejercicio03;

@SuppressWarnings("serial")
public class EcuacionDegeneradaException extends RuntimeException {
	
	public EcuacionDegeneradaException(String msg) {
		super(msg);
	}
	
    public EcuacionDegeneradaException() {
        super("La ecuación es degenerada (a y b son igual a 0).");
    }
}