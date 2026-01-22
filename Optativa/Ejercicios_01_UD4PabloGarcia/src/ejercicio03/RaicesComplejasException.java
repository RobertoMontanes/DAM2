package ejercicio03;

@SuppressWarnings("serial")
public class RaicesComplejasException extends Exception {
    public RaicesComplejasException() {
        super("Las raíces son complejas (el discriminante es menor que 0).");
    }
}