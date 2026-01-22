package ejercicio03;

@SuppressWarnings("serial")
public class EcuacionDegeneradaException extends Exception {
    public EcuacionDegeneradaException() {
        super("La ecuación es degenerada (a y b son igual a 0).");
    }
}