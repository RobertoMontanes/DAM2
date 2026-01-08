package ejercicio04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Administracion {
	
	private List<Empleado> empleados;

	public Administracion(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public List<Empleado> obtenerActivosSobrePromedio() {
		double promedio = empleados.stream().mapToDouble(Empleado::getSalario).sum() / empleados.size();
		return empleados.stream().filter(e -> e.isActivo() && e.getSalario() > promedio).toList();
	}

	public Optional<Empleado> buscarPorNombre(String nombreBusqueda) {
		return empleados.stream().filter(e -> e.getNombre().equalsIgnoreCase(nombreBusqueda)).findFirst();
	}

	public Map<String, Empleado> obtenerMayorSalarioPorDepartamento() {
		Map<String, Empleado> departamentos = new HashMap<String, Empleado>();
		
		for (Empleado empleado : empleados) {
			if (departamentos.containsKey(empleado.getDepartamento())) {
				if (empleado.getSalario() > departamentos.get(empleado.getDepartamento()).getSalario()) {
					departamentos.put(empleado.getDepartamento(), empleado);
				}
			} else {
				departamentos.put(empleado.getDepartamento(), empleado);
			}
		}
		
		return departamentos;
	}

	public double calcularSalarioTotalActivosMasDeXAnios(int anios) {
		return empleados.stream()
				.filter(e -> e.isActivo() && e.getAntiguedad() > anios)
				.mapToDouble(Empleado::getSalario)
				.sum();
	}

	public List<Empleado> obtenerRankingEmpleados() {
		List<Empleado> empleadosSort = new ArrayList<Empleado>(empleados);
		empleadosSort.sort(new EmpleadoComparator());
		return empleadosSort.reversed();
	}

}
