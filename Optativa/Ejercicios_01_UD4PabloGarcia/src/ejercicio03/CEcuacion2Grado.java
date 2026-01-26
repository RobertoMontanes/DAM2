package ejercicio03;

public class CEcuacion2Grado {

	public static double[] resolver(double a, double b, double c)
			throws EcuacionDegeneradaException, RaicesComplejasException {

		double discriminante;
		double[] solucion = new double[2];

		if (a == 0 && b == 0)
			throw new EcuacionDegeneradaException();

		discriminante = Math.pow(b, 2) - (4 * a * c);
		System.out.println(discriminante);

		if (discriminante < 0)
			throw new RaicesComplejasException();

		if (a == 0) {
			solucion[0] = -c / b;
			solucion[1] = Double.NEGATIVE_INFINITY;
		} else {
			solucion[0] = (-b + Math.sqrt(discriminante)) / (2 * a);
			solucion[1] = (-b - Math.sqrt(discriminante)) / (2 * a);
		}

		return solucion;

	}
}