package ejercicio02;

import java.util.List;
import java.util.Scanner;

public class Principal {
	
	
	/*
	 * 2. Crear un programa que trabaje con una lista de cadenas de texto con la que se puedan hacer las siguientes
	 * operaciones y un main de prueba.
	 * 	Primera parte:
	 * 	* Ordenar las cadenas por orden alfabético.
	 * 	* Buscar una cadena dada por teclado.
	 * 	* Crear un nuevo String formado por la primera letra de cada palabra que contiene la lista.
	 * 	* Borrar las palabras que tengan longitud impar de letras.
	 * 	* Pasar todas las palabras a mayúsculas.
	 * 	Segunda parte:
	 * 	Crea varios métodos a tu elección para buscar, validar y manipular dichas cadenas usando expresiones	
	 * 	 regulares con las clases Pattern y Matcher.
	 * */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String opciones[] = {
			"Abandonar",
			"Añadir una cadena a la lista",
			"Ordenar las cadenas por orden alfabético",
			"Buscar una cadena dada por teclado",
			"Crear un nuevo String formado por la primera letra de cada palabra que contiene la listas",
			"Borrar las palabras que tengan longitud impar de letras",
			"Pasar todas las palabras a mayúsculas",
		};
				
		int opcion, opcionAbanadonar = 0;
		List<String> listaAux;
		Administracion admin = new Administracion(List.of(
			    "casa",
			    "perro",
			    "gato",
			    "árbol",
			    "coche",
			    "libro",
			    "mesa",
			    "silla",
			    "ventana",
			    "puerta",
			    "ciudad",
			    "escuela",
			    "trabajo",
			    "familia",
			    "amigo",
			    "comida",
			    "agua",
			    "sol",
			    "luna",
			    "estrella",
			    "montaña",
			    "río",
			    "playa",
			    "camino"
			));
		
		System.out.println("Bienvenido al programa de gestion de cadenas.");
		
		do {
			
			for (int i = 0; i < opciones.length; i++) {
				System.out.println(i + ". " + opciones[i]);
			}
			System.out.println("¿Que quieres hacer? ");
			opcion = Integer.parseInt(sc.nextLine());
			
			switch (opcion) {
				case 0 -> {
					System.out.println("Gracias por usar el programa");
				}
				case 1 -> {
					System.out.println("Introduzca la nueva linea: ");
					if (admin.addLinea(sc.nextLine())) {
						System.out.println("Nueva linea añadida exitosamente");
					} else {
						System.out.println("Algo ha salido mal mientras se añadia la linea.");
					}
				}
				case 2 -> {
					System.out.println("Vamos a ordenar la lista de cadenas y mostrarlo por pantalla: ");
					admin.ordenarCadena().forEach(System.out::println);
				}
				case 3 -> {
					System.out.println("Introduzca la cadena de texto que esta buscando: ");
					listaAux = admin.buscarCadena(sc.nextLine());
					if (listaAux.isEmpty()) {
						System.out.println("No se han encontrado cadenas de texto que coincidan....");
					} else {
						listaAux.forEach(System.out::println);						
					}
				}
				case 4 -> {
					System.out.println("Vamos a crear una criatura de la lista: ");
					System.out.println(admin.crearCreatura());
				}
				case 5 -> {
					System.out.println("A continuacion te mostrare una lista de solo las palabras con longitud par.");
					admin.borrarImpares().forEach(System.out::println);
				}
				case 6 -> {
					System.out.println("A continuacion te mostrare la lista de palabras pero en mayusculas: ");
					admin.convertirMayus().forEach(System.out::println);;
				}
				default -> System.out.println("El valor introducido no se encuentra entre las opciones, volviendo al menu...");
			}
			
		} while (opcion != opcionAbanadonar);
		
		sc.close();
		
	}

}
