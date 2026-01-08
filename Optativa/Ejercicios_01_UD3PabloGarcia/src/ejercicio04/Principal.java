package ejercicio04;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

	/*
	 * 4. Se desea gestionar una lista de empleados del colegio. Cada empleado
	 * tiene: id, nombre, departamento, salario, activo y años de antigüedad.
	 * Implementar una clase Administración que permita realizar las siguientes
	 * operaciones: 
	 * 	a) Obtener empleados activos con salario superior al promedio general. 
	 * 	b) Buscar un empleado por nombre y devolverlo como Optional (se puede usar el APIGermán) 
	 * 	c) Obtener el empleado con mayor salario por departamento (groupingBy). 
	 * 	d) Calcular el salario total de empleados activos con más de X años. 
	 * 	e) Obtener un ranking ordenado de empleados por salario y antigüedad.
	 */

	public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        List<Empleado> lista = List.of(
        	    new Empleado(1, "Juan Perez", "Matemáticas", 2500.0, true, 10),
        	    new Empleado(2, "Maria Garcia", "Lengua", 2800.0, true, 5),
        	    new Empleado(3, "Luis Lopez", "Matemáticas", 3000.0, true, 12),
        	    new Empleado(4, "Ana Sanz", "Ciencias", 2200.0, false, 3),
        	    new Empleado(5, "Pedro Ruiz", "Lengua", 2900.0, true, 8),
        	    // Casos para probar el desempate (Mismo salario, distinta antigüedad):
        	    new Empleado(6, "Laura Beltrán", "Ciencias", 2800.0, true, 10), // Misma que Maria, pero más antigua
        	    new Empleado(7, "Carlos Mejia", "Matemáticas", 2500.0, true, 4),  // Misma que Juan, pero menos antiguo
        	    new Empleado(8, "Elena Nito", "Sistemas", 3000.0, true, 2),      // Misma que Luis, pero mucho menos antigua
        	    // Más variedad
        	    new Empleado(9, "Roberto Soler", "Sistemas", 3500.0, true, 15),
        	    new Empleado(10, "Lucía Torres", "Lengua", 2200.0, true, 7)      // Misma que Ana, pero más antigua
        	);
        
        Administracion admin = new Administracion(lista);
        
        

        String[] menuOpciones = {
            "Salir",
            "Empleados activos con salario superior al promedio",
            "Buscar empleado por nombre (Optional)",
            "Empleado con mayor salario por departamento",
            "Calcular salario total de activos con antigüedad > X años",
            "Ranking de empleados (Salario y Antigüedad)"
        };

        int opcion = -1;
        String entrada;

        System.out.println("GESTIÓN DE EMPLEADOS DEL COLEGIO");

        do {
            System.out.println("\n---------------- MENU ----------------");
            for (int i = 0; i < menuOpciones.length; i++) {
                System.out.println(i + ". " + menuOpciones[i]);
            }
            System.out.print("Seleccione una opción: ");

            try {
                entrada = sc.nextLine();
                opcion = Integer.parseInt(entrada);

                switch (opcion) {
                    case 0:
                        System.out.println("Saliendo del sistema de administración...");
                        break;

                    case 1:
                        System.out.println("\n--- Activos con salario superior a la media ---");
                        List<Empleado> superiores = admin.obtenerActivosSobrePromedio();
                        superiores.forEach(System.out::println);
                        break;

                    case 2:
                        System.out.print("Introduce el nombre del empleado: ");
                        String nombreBusqueda = sc.nextLine();
                        Optional<Empleado> empOpt = admin.buscarPorNombre(nombreBusqueda);
                        empOpt.ifPresentOrElse(
                            System.out::println,
                            () -> System.out.println("Empleado no encontrado.")
                        );
                        break;

                    case 3:
                        System.out.println("\n--- Top Salario por Departamento ---");
                        Map<String, Empleado> topPorDept = admin.obtenerMayorSalarioPorDepartamento();
                        topPorDept.forEach((dept, emp) -> {
                            System.out.print("Departamento: " + dept + " -> " + emp);
                        });
                        break;

                    case 4:
                        System.out.print("Introduce los años de antigüedad mínimos: ");
                        int anios = Integer.parseInt(sc.nextLine());
                        double totalSalario = admin.calcularSalarioTotalActivosMasDeXAnios(anios);
                        System.out.printf("El salario total acumulado es: %.2f€\n", totalSalario);
                        break;

                    case 5:
                        System.out.println("\n--- Ranking de Empleados ---");
                        List<Empleado> ranking = admin.obtenerRankingEmpleados();
                        ranking.forEach(System.out::println);
                        break;

                    default:
                        System.out.println("Opción no válida.");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, introduce un número entero.");
                opcion = -1;
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }

        } while (opcion != 0);

        sc.close();
    }
}
