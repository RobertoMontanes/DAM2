package ejercicio03;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Principal {
	
	/*
	 * 3. Crea un programa que sirva para gestionar una lista de canciones, a modo de Playlist (no hay que incluir el
	 * archivo de audio). En dicha lista de canciones, se podrá buscar por nombre, por autor, por duración, número
	 * de canciones de un determinado género (por ejemplo, Pop). Ver si todas las canciones duran más de una
	 * duración dada, cuántos intérpretes distintos hay...
	 * */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String opciones[] = {
				"Abandonar",
				"Buscar cancion por nombre",
				"Buscar cancion por autor",
				"Buscar cancion por duracion",
				"Listar canciones por genero",
				"Comprobar canciones por duracion",
				"Contar interpretas",
			};
		
		int opcion, opcionAbandonar = 0;
		List<Cancion> canciones = List.of();
		Playlist playlist = new Playlist(canciones);
		
		System.out.println("Bienvenido al programa gestor de playlist: ");
		
		do {
			
			for (int i = 0; i < opciones.length; i++) {
				System.out.println(i + ". " + opciones[i]);
			}

			try {
				System.out.printf("¿Que opcion escoges? ");
				opcion = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				opcion = -1;
			}
			
			switch (opcion) {
				case 0 -> {
					System.out.println("Gracias por usar el programa, que tenga buen dia!!");
				}
				case 1 -> {
					System.out.printf("Indica el nombre de la cancion que buscas: ");
					playlist.findByNombre(sc.nextLine()).forEach(System.out::print);
				}
				case 2 -> {
					System.out.printf("Indica el nombre del autor de canciones que buscas: ");
					playlist.findByAutor(sc.nextLine()).forEach(System.out::println);
				}
				case 3 -> {
					System.out.println("Indica los minutos que dura la cancion: ");
				}
				default -> {
					System.out.println("Has indicado una opcion invalida, volviendo al menu.");
				}
			}
			
		} while (opcion != opcionAbandonar);
	
		sc.close();
	}

}
