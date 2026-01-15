package ejercicio02;

public class TemperaturaErronea extends RuntimeException{

	public TemperaturaErronea() {
		super("No puede haber temperaturas menores a -273 ºC");
	}

}
