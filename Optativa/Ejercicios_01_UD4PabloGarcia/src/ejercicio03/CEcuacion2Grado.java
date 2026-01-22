package ejercicio03;

public class CEcuacion2Grado {

    public static double[] resolver(double a, double b, double c) 
            throws EcuacionDegeneradaException, RaicesComplejasException {
        
        if (a == 0 && b == 0) {
            throw new EcuacionDegeneradaException();
        }

        if (a == 0) {
            return new double[] { -c / b };
        }

        double discriminante = Math.pow(b, 2) - (4 * a * c);

        if (discriminante < 0) {
            throw new RaicesComplejasException();
        }

        double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
        double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);

        return new double[] { x1, x2 };
    }
}