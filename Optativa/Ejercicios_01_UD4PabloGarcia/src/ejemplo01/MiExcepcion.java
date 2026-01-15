package ejemplo01;

public class MiExcepcion extends RuntimeException {
	
	public MiExcepcion() {
		super();
	}
	
	public MiExcepcion(String error) {
		super(error);
	}
	
}
