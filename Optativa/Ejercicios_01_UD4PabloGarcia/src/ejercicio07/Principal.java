package ejercicio07;

import java.util.List;
import java.util.Scanner;

public class Principal {

	/* 7) Crear un programa para gestionar las matrículas de un coche leyendo estas por teclado. Las matrículas se
	 * componen de 7 caracteres y deben empezar obligatoriamente por una letra. Generar las excepciones necesarias
	 * para comprobar el tamaño de la matrícula y que empiecen por una letra.
	 * */
	
	public static void main(String[] args) {
				
		int opcion, opcionAbandonar = 0, intIntermedio;
		String opciones[] = {"Abandonar", "Añadir matricula", "Comprobar matricula"}, stringIntermedio;
		Scanner sc = new Scanner(System.in);
		List<String> matriculas = List.of(
				"ABC1234",
				"BC2345A",
				"C3456AB",
				"3456ABC",
				"456ABC",
				"456ABC34"
				);
		
		System.out.println("  -- Bienvenido al programa de gestion de matriculas -- ");
		do {
			
			try {
				
				for (int i = 0; i < opciones.length; i++) {
					System.out.println(i + ". " + opciones[i]);
				}
				System.out.println("¿Que quieres hacer?");
				opcion = Integer.parseInt(sc.nextLine());
				
				switch (opcion) {
					case 0 -> {
						System.out.println("Gracias por usar el programa, tenga un buen dia.");
					}
					case 1 -> {
						System.out.println("Indique la matricula que desea añadir: ");
						stringIntermedio = sc.nextLine();
						if (comprobarMatricula(stringIntermedio))
							System.out.println("La matricula indicada es valida, añadiendo al listado...");
						matriculas.add(stringIntermedio);
					}
					case 2 -> {
						for (int i = 0; i < matriculas.size(); i++) {
							System.out.println(i + ". " + matriculas.get(i));
						}
						
						System.out.println("Indique que matricula desea revisar: ");
						intIntermedio = Integer.parseInt(sc.nextLine());
						
						if (comprobarMatricula(matriculas.get(intIntermedio)))
							System.out.println("La matricula: " + matriculas.get(intIntermedio) + " es completamente valida.");
					}
					default -> {
						System.out.println("Has introducido una opcion invalida, volviendo al menu...");
					}
				}
				
			} catch (MatriculaIncorrectaException e) {
				System.err.println(e.getMessage());
				opcion = -1;
			} catch (NumberFormatException e) {
				System.out.println("Has introducido un dato invalido en un campo de formulario, volviendo al menu...");
				opcion = -1;
			} catch (Exception e) {
				System.err.println("Se ha producido un error inesperado durante la ejecucion del programa: " + e.getMessage());
				opcion = -1;
			}
			
		} while(opcion != opcionAbandonar);

		sc.close();
		
	}	
	
	private static boolean comprobarMatricula(String matricula) throws MatriculaIncorrectaException {
		
		int longitudMatricula = 7;
		
		if (matricula.length() != longitudMatricula)
				throw new MatriculaIncorrectaException("Las matriculas deben disponer exactamente de " + longitudMatricula + " caracters.");
		
		if (Character.isDigit(matricula.charAt(0)))
				throw new MatriculaIncorrectaException("Las matriculas deben empezar siempre por letras.");
		
		return true;
	}
	
}
