package ejercicioExamen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		
		int opcion, opcionAbandonar = 0, mayoriaEdad = 18, longitudMinima = 3;
		Scanner sc = new Scanner(System.in);
		Usuario nuevoUsuario;
		
		String caracteresMinimo = "@";
		String opciones[] = {
				"Leave",
				"Modify default values",
				"Add user",
				"List users"
				};
		
		String defaultVaues[] = {
				"Leave",
				"Age of coming",
				"Minimun length of a name",
				"Mandatory characters on an email"
		};
		
		
		GestionUsuarios gUsuarios = new GestionUsuarios(new ArrayList<Usuario>());
		
		gUsuarios.getUsuarios().addAll(List.of(
				new Usuario("Hugo Carmona Jimenez", "carmona.jimgo@salesianos.triana.edu", 22),
				new Usuario("Mauro Serrano", "serrano.maur@salesianos.triana.edu", 20),
				new Usuario("Gabriel Perez", "perez.gab@salesianos.triana.edu", 20),
				new Usuario("Gonzalo Antonio Dios Fiestas", "dios.fiesgon@salesianos.triana.edu", 23)
			));
		
		System.out.println("Welcome to our user validation platform ");
		do {
			
			try {
				
				for (int i = 0; i < opciones.length; i++) {
					System.out.println(i + ". " + opciones[i]);
				}
				System.out.printf("What do you want to do? ");
				opcion = Integer.parseInt(sc.nextLine());
				
				switch (opcion) {
					case 0 -> 
						System.out.println("Leaving the program...");
					case 1 -> {
						
						for (int i = 0; i < defaultVaues.length; i++) {
							System.out.println(i + ". " + defaultVaues[i]);
						}
						System.out.printf("What value do you want to modify? ");
						opcion = Integer.parseInt(sc.nextLine());
						
						switch (opcion) {
							case 0 ->
								System.out.println("Returning to the principal menu...");
							case 1 -> {
								System.out.printf("The actual value of age of coming is: %d, wich would be the new one: ", mayoriaEdad);
								mayoriaEdad = Integer.parseInt(sc.nextLine());
							
							}
							case 2 -> {
								System.out.printf("The actual value of minimun length of a name is: %d, wich would be the new one: ", longitudMinima);
								longitudMinima = Integer.parseInt(sc.nextLine());
							}
							case 3 -> {
								System.out.printf("The actual value of mandatory characters on an email is: %s, wich would be the new one/s: ", caracteresMinimo);
								caracteresMinimo = sc.nextLine();
							}
							default ->
								System.out.println("Invalid option selected, returning to principal menu...");
						}
						opcion = -1;
						
					}
					case 2 -> {
						nuevoUsuario = new Usuario();
						
						System.out.printf("What is the name of the new user: ");
						nuevoUsuario.setNombre(GestionUsuarios.validarNombre(sc.nextLine(), longitudMinima));
						
						System.out.printf("What is the email of the new user: ");
						nuevoUsuario.setEmail(GestionUsuarios.validarEmail(sc.nextLine(), caracteresMinimo));
						

						System.out.printf("What is the age of the new user: ");
						nuevoUsuario.setEdad(GestionUsuarios.validarEdad(Integer.parseInt(sc.nextLine()), mayoriaEdad));
						
						System.out.println("Creation succesfull, here you have your new user: ");
						System.out.println(nuevoUsuario);
						gUsuarios.getUsuarios().add(nuevoUsuario);
					}
					case 3 -> 
						gUsuarios.listarUsuarios();
					default ->
						System.out.println("The number you inserted is not avaible on the program options, returning to the menu...");
				}
				
			} catch (TextoInvalidoException | CalculoInvalidoException e) {
				System.err.println(e.getMessage());
				opcion = -1;
			} catch (NumberFormatException e) {
				System.err.println("You inserted something invalid, please limit yourself to use only numbers...");
				opcion = -1;
			} catch (Exception e) {
				System.err.println("Something unexpected happened: " + e.getMessage());
				System.err.println(e);
				opcion = -1;
			}
			
		} while(opcion != opcionAbandonar);
		
		
		sc.close();
		System.out.println("Thanks for using the program, have a nice day...");
	}

}
