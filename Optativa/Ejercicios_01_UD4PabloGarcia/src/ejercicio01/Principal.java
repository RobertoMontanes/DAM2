package ejercicio01;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		/*
		 * 1) Realizar un programa que haga las operaciones básicas de una calculadora
		 * solo con números enteros (sumar, resta, multiplicar, dividir y raíz cuadrada)
		 * teniendo en cuenta las posibles excepciones que se pueden producir (entrada
		 * de datos, división por cero, raíz de un número negativo, etc.)
		 */
		
		
		Scanner sc = new Scanner(System.in);
		
		String[] opciones = {
			"Abandonar",
			"Sumar",
			"Restar",
			"Multiplicar",
			"Dividir",
			"Raiz cuadrada"
		};
		
		double num1, num2;
		int opcion, opcionAbandonar = 0;
		
			do {
				try {
					printList(opciones);
					System.out.println("¿Qué quieres hacer? ");
					opcion = Integer.parseInt(sc.nextLine());
					
					switch (opcion) {
					case 0 -> System.out.println("Saliendo...");
						case 1 -> {
							System.out.println("Introduzca el primer numero de la suma: ");
							num1 = Double.parseDouble(sc.nextLine());
							
							System.out.println("Introduzca el segundo numero de la suma: ");
							num2 = Double.parseDouble(sc.nextLine());
							
							System.out.println("El resultado de la suma: " + (num1+num2));
						}
						case 2 -> {
							System.out.println("Introduzca el primer numero de la resta: ");
							num1 = Double.parseDouble(sc.nextLine());
							
							System.out.println("Introduzca el segundo numero de la resta: ");
							num2 = Double.parseDouble(sc.nextLine());
							
							System.out.println("El resultado de la resta: " + (num1-num2));						}
						case 3 -> {
							System.out.println("Introduzca el primer numero de la multiplicacion: ");
							num1 = Double.parseDouble(sc.nextLine());
							
							System.out.println("Introduzca el segundo numero de la multiplicacion: ");
							num2 = Double.parseDouble(sc.nextLine());
							
							System.out.println("El resultado de la multiplicacion: " + (num1*num2));		
						}
						case 4 -> {
							System.out.println("Introduzca el primer numero de la division: ");
							num1 = Double.parseDouble(sc.nextLine());
							
							System.out.println("Introduzca el segundo numero de la division: ");
							num2 = Double.parseDouble(sc.nextLine());
							
							System.out.println("El resultado de la multiplicacion: " + (num1/num2));	
						}
						case 5 -> {
							System.out.println("Introduzca el numero de la raiz cuadrada: ");
							num1 = Double.parseDouble(sc.nextLine());
							
							System.out.println("El resultado de la raiz cuadrada: " + (Math.sqrt(num1)));		
							
						}
						default -> {
							System.out.println("Has introducido un valor invalido, volviendo al menu...");
						}
					}
					
				} catch (NumberFormatException e) {
					System.err.println("Introduce solo números válidos, por favor.");
					opcion = -1;
				} catch (ArithmeticException e) {
	                System.err.println("Error matemático");
					opcion = -1;
				} catch (IllegalArgumentException e) {
	                System.err.println(e.getMessage());
					opcion = -1;
	            }
			} while (opcion != opcionAbandonar);
			
			sc.close();
			
	}

	public static void printList(String[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.println(i + ". " + list[i]);
		}
	}
}
