package ejercicio04;

import java.util.Scanner;

public class Principal {
	
	/* 4) Crea un programa que use dos variables, a y b. Si la suma de estas dos variables es mayor que 10, 
	 * al ejecutarse el programa debe aparecer una excepción que diga "La suma no puede ser mayor que 10". 
	 * Por lo tanto, dale valores a "a" y a "b" para que su suma sea superior a 10.
	 * */
	
	public static void main(String[] args) {
		
		int opcion, opcionAbandonar = 0;
		Scanner sc = new Scanner(System.in);
		
		String[] opciones = {
			"Abandonar",
			"Sumar"
		};
		
		System.out.println("Bienvenido al programa CALCULADORA, solo suma.");
		
		do {
			
			try {
				for (int i = 0; i < opciones.length; i++) {
					System.out.println(i + ". " + opciones[i]);
				}
				System.out.printf("¿Que quieres hacer? ");
				opcion = Integer.parseInt(sc.nextLine());
				
				switch (opcion) {
					case 0:
						System.out.println("¡Gracias por usar el programa!");
						break;
					case 1:
						System.out.println("Indique los numeros que desea sumar, pulsando enter entre numeros: ");
						System.out.printf("El resultado de la suma es: %.2f \n", calcularSuma(Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine())));
						break;
					default:
						System.out.println("Has introducido un valor no reconocido, volviendo al menu...");
						break;
				}
				
			} catch (ErrorSuma e) {
				System.err.println(e.getMessage());
				opcion = -1;
			} catch (NumberFormatException e) {
				System.err.println("Has introducido un valor erroneo, por favor use solo numeros.");
				opcion = -1;
			} catch (Exception e) {
				System.err.println("Se ha producido un error inesperado: " + e); 
				opcion = -1;
			}
				
			
		} while(opcion != opcionAbandonar);
		
		sc.close();
		
	}
	
	public static double calcularSuma(double a, double b) throws ErrorSuma {
		double resul;
		resul = a+b;
		if (resul > ErrorSuma.ERROR)
			throw new ErrorSuma();
		
		return resul;
	}

}
