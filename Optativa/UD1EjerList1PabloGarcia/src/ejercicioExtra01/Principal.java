package ejercicioExtra01;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

		String[] menuOpciones = {
				"Abandonar el programa",
				"Listar habitaciones",
				"Calcular precio de una Habitacion",
				"Calcular lo recaudado por las habitaciones actualmente ocupadas",
				"Mostrar ticket de una Habitacion",
				"Listar habitaciones no ocupadas"
		};
		
		int opcionAbandonar = 0, opcionEscogida, ajustarOpcionesArray = 1,tamInicio = 100,idObjetivo;
		HabitacionEstandar habitacionObjetivo;
		
		HabitacionEstandar []listaHabitaciones = new HabitacionEstandar[tamInicio];
		
		HabitacionEstandar hab1 = new Suite(700, true, "Pablo Garcia", 3, 1, 3, 50, 320, 20);
		listaHabitaciones[0] = hab1;
		HabitacionEstandar hab2 = new Suite(700, false, "Sin ocupante", 0, 0, 7, 50, 0, 20);
		listaHabitaciones[1] = hab2;
		
		HabitacionEstandar hab3 = new Apartamento(350, false, "Sin ocupante", 0, 0, 8, false, 25);
		listaHabitaciones[2] = hab3;
		HabitacionEstandar hab4 = new Apartamento(350, true, "Ocupante 1", 5, 2, 10, false, 25);
		listaHabitaciones[3] = hab4;
		HabitacionEstandar hab5 = new Apartamento(350, true, "Ocupante 2", 5, 2, 11, true, 25);
		listaHabitaciones[4] = hab5;
		
		HabitacionEstandar hab6 = new HabitacionEstandar(350, true, "Ocupante 3", 2, 3, 12);
		listaHabitaciones[5] = hab6;
		HabitacionEstandar hab7 = new HabitacionEstandar(350, false, "Sin Ocupante", 0, 0, 13);
		listaHabitaciones[6] = hab7;
		
		GestionHabitaciones gestorHotel = new GestionHabitaciones(listaHabitaciones);
		
		System.out.println("Bienvenido a mi MiniHotel, espero que tu experiencia aqui sea gratificante.");
		
		do {
			
			for (int i = 0; i < menuOpciones.length; i++) {
				System.out.println(i + ". " + menuOpciones[i]);
			}
			System.out.print("?Que quieres hacer? ");
			opcionEscogida = Integer.parseInt(sc.nextLine());
			
			while (opcionEscogida > menuOpciones.length - ajustarOpcionesArray && opcionAbandonar < opcionEscogida) {
				System.out.print("Has indicado una opcion invalida, inserte una nueva: ");
				opcionEscogida = Integer.parseInt(sc.nextLine());
			}
			
			switch (opcionEscogida) {
				case 0:
					System.out.println("Cerrando el programa...");
					break;
				case 1:
					gestorHotel.mostrarHabitaciones(false);
					break;
				case 2:
					System.out.println("Dime el ID de la habitacion sobre la que quieres saber el precio");
					idObjetivo = Integer.parseInt(sc.nextLine());
					habitacionObjetivo = gestorHotel.buscarHabitacionPorID(idObjetivo);
										
					if (habitacionObjetivo  == null) {
						System.out.println("No hemos podido encontrar ninguna habitacion de ID "+idObjetivo);
					} else {
						if (habitacionObjetivo.isOcupada()) {
							System.out.println("El precio final de la habitacion seleccionada sera: "+habitacionObjetivo.calcularPrecioHabitacion());							
						} else {
							System.out.println("El precio por noche de la habitacion seleccionada sera: "+habitacionObjetivo.getPrecioBase());
						}
					}
					
					break;
				case 3:
					System.out.println("El dinero recaudado en las habitaciones actualmente ocupadas ha sido un total de: " + gestorHotel.calcularPrecioHabitacionesOcupadas() + " Euros");
					break;
				case 4:
					System.out.println("Dime el ID de la habitacion sobre la que quieres obtener el ticket");
					idObjetivo = Integer.parseInt(sc.nextLine());
					gestorHotel.mostrarTicketHabitacion(idObjetivo);
					break;
				case 5:
					gestorHotel.mostrarHabitaciones(true);
				default:
					System.err.println("Opcion desconocida, volviendo al menu.");
					break;
			}
			System.out.println();
			
		} while (opcionEscogida != opcionAbandonar);
		
		System.out.println("Gracias por visitar mi MiniHotel, espero verte de vuelta pronto!!!!");
	}
	
	

}
