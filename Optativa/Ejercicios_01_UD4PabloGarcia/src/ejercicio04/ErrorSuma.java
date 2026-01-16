package ejercicio04;

@SuppressWarnings("serial")
public class ErrorSuma extends Exception {

	public static final  double ERROR = 10;
	
	public ErrorSuma() {
		super("La suma no puede ser mayor que " + ERROR);
	}
	
}
