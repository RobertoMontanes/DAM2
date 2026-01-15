package ejercicio02;

import java.util.Scanner;

public class Principal {
	
	/*
	 * 2) Crear un programa que convierta los grados Celsius a Fahrenheit y que tenga previsto un mecanismo para que
	 * al introducir una temperatura menor a -273 ºC, aparezca algún mensaje: “no puede haber temperaturas menores
	 * a -273 ºC” y vuelva a pedir la temperatura.
	 * */
	
	public static void main(String[] args) {
		
		int opcion, opcionAbandonar = 0;
		String[] opciones = {
				"Abandonar",
				"Convertir temperatura"
		};
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Bienvenido al programa de conversion de temperaturas.");
		
		do {
			
			try {
				
				for (int i = 0; i < opciones.length; i++) {
					System.out.println(i + ". " + opciones[i]);
				}
				System.out.printf("Que opcion escoges: ");
				opcion = Integer.parseInt(sc.nextLine());
				
				switch (opcion) {
					case 0-> {
						System.out.println("Gracias por usar el programa, tenga un buen dia.");
					}
					case 1-> {
						System.out.println("Introduzca la temperatura que desea convertir: ");
						convertirTemperatura(Double.parseDouble(sc.nextLine()));

					}
					default ->
						System.out.println("Opcion erronea, volviendo al menu.");
				}
				
				
			} catch (TemperaturaErronea e) {
				System.err.println(e.getMessage());
				opcion = -1;			
			} catch (NumberFormatException e) {
				System.err.println("Has introducido un dato erroneo.");
			} catch (Exception e) {
				System.err.println("Se ha encontrado un error inesperado: \n" + e);
				opcion = -1;			
			}
		} while (opcion != opcionAbandonar);
		
		sc.close();
		
	}
	
	public static double convertirTemperatura(double celsius) {
		double temperaturaError = -273;
		
		if (celsius <= temperaturaError)
			throw new TemperaturaErronea();
		
		return (celsius * 2) + 30;
	}

}
