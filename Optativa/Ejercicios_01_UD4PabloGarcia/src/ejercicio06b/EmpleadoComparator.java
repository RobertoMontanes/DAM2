package ejercicio06b;

import java.util.Comparator;

public class EmpleadoComparator implements Comparator<Empleado> {

	@Override
	public int compare(Empleado o1, Empleado o2) {
		int val1 = Double.compare(o1.getSalario(), o2.getSalario());
		if (val1 == 0) {
			return Integer.compare(o1.getAntiguedad(), o2.getAntiguedad());
		}
		return val1;
	}
	

}
