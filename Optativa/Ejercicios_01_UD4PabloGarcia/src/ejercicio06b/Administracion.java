package ejercicio06b;

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
	
	public List<Empleado> obtenerActivosSobrePromedio() throws EmpleadoNoEncontradoException {
        if (empleados.isEmpty()) throw new EmpleadoNoEncontradoException("No hay empleados en la base de datos.");

        double promedio = empleados.stream()
                .mapToDouble(Empleado::getSalario)
                .average()
                .orElse(0.0);

        List<Empleado> resultado = empleados.stream()
                .filter(e -> e.isActivo() && e.getSalario() > promedio)
                .toList();

        if (resultado.isEmpty()) throw new EmpleadoNoEncontradoException("Ningún empleado activo supera el promedio de " + promedio);
        return resultado;
    }

	public Optional<Empleado> buscarPorNombre(String nombreBusqueda) {
		return empleados.stream().filter(e -> e.getNombre().equalsIgnoreCase(nombreBusqueda)).findFirst();
	}
	
	public Map<String, Empleado> obtenerMayorSalarioPorDepartamento() throws EmpleadoNoEncontradoException  {
		Map<String, Empleado> departamentos = new HashMap<String, Empleado>();
		
        if (empleados.isEmpty()) throw new EmpleadoNoEncontradoException("No existen departamentos registrados.");
		
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
        if (anios < 0) throw new AdministracionException("La antigüedad no puede ser negativa.");

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
