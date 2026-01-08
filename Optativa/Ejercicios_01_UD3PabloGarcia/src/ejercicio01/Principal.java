package ejercicio01;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Principal {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Secretaria secretaria = new Secretaria(new ArrayList<Alumno>());
        
        String entrada = ""; 
        
        int opcion = -1;
        String[] menuOpciones = {
            "Salir",
            "Mostrar todos los alumnos (forEach)",
            "Buscar alumnos por letra inicial",
            "Contar total de alumnos",
            "Buscar por nota media mayor a...",
            "Mostrar los 3 primeros alumnos",
            "Obtener el alumno de menor edad",
            "Obtener el primer alumno de la lista",
            "Buscar por longitud de nombre (Mayor a...)",
            "Buscar: Empieza por 'A' y longitud menor o igual a..."
        };

        char letraAux = ' ';
        double notaAux = 0.0;
        int longitudAux = 0;
        
        List<Alumno> listaResultado = null;
        Optional<Alumno> alumnoOptional = null;


        secretaria.agregarAlumno(new Alumno("Ana", "García", "Java", 8.5, 22));
        secretaria.agregarAlumno(new Alumno("Antonio", "Pérez", "Python", 5.0, 25));
        secretaria.agregarAlumno(new Alumno("Beatriz", "López", "Java", 9.2, 20));
        secretaria.agregarAlumno(new Alumno("Carlos", "Ruiz", "C++", 6.5, 21));
        secretaria.agregarAlumno(new Alumno("Amalia", "Sanz", "Java", 7.8, 19));
        secretaria.agregarAlumno(new Alumno("David", "Mora", "Python", 4.5, 23));
        secretaria.agregarAlumno(new Alumno("Alejandro", "Vidal", "Java", 9.0, 24));
        

        do {
            System.out.println("\n--- GESTIÓN DE ALUMNOS (STREAMS) ---");
            for (int i = 0; i < menuOpciones.length; i++) {
                System.out.println(i + ". " + menuOpciones[i]);
            }
            System.out.print("Seleccione una opción: ");

            try {
                entrada = scanner.nextLine();
                opcion = Integer.parseInt(entrada);

                switch (opcion) {
                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;

                    case 1:
                        System.out.println("\n--- Lista de Alumnos ---");
                        secretaria.mostrarTodos();
                        break;

                    case 2:
                        System.out.print("Introduce la letra inicial: ");
                        entrada = scanner.nextLine();
                        
                        if (!entrada.isEmpty()) {
                            letraAux = entrada.toUpperCase().charAt(0);
                            System.out.println("--- Alumnos que empiezan por '" + letraAux + "' ---");
                            secretaria.imprimirPorLetra(letraAux);
                        } else {
                            System.out.println("No has introducido ninguna letra.");
                        }
                        break;

                    case 3:
                        System.out.println("\nTotal de alumnos: " + secretaria.contarAlumnos());
                        break;

                    case 4:
                        System.out.print("Introduce la nota media mínima (ej. 5.5): ");
                        entrada = scanner.nextLine();
                        notaAux = Double.parseDouble(entrada);
                        
                        listaResultado = secretaria.obtenerPorNotaMayor(notaAux);
                        System.out.println("--- Alumnos con nota mayor a " + notaAux + " ---");
                        listaResultado.forEach(System.out::println);
                        break;

                    case 5:
                        System.out.println("\n--- Los 3 primeros alumnos ---");
                        secretaria.imprimirTresPrimeros();
                        break;

                    case 6:
                        alumnoOptional = secretaria.obtenerMenorEdad();
                        System.out.println("\n--- Alumno más joven ---");
                        alumnoOptional.ifPresentOrElse(
                            System.out::println,
                            () -> System.out.println("La lista está vacía.")
                        );
                        break;

                    case 7:
                        alumnoOptional = secretaria.obtenerPrimerAlumno();
                        System.out.println("\n--- Primer alumno de la lista ---");
                        alumnoOptional.ifPresent(System.out::println);
                        break;

                    case 8:
                        System.out.print("Introduce la longitud mínima del nombre: ");
                        entrada = scanner.nextLine();
                        longitudAux = Integer.parseInt(entrada);
                        
                        listaResultado = secretaria.obtenerPorLongitudNombre(longitudAux);
                        System.out.println("--- Alumnos con nombre más largo de " + longitudAux + " letras ---");
                        listaResultado.forEach(System.out::println);
                        break;

                    case 9:
                        System.out.print("Introduce la longitud MÁXIMA del nombre (que empiece por A): ");
                        entrada = scanner.nextLine();
                        longitudAux = Integer.parseInt(entrada);
                        
                        listaResultado = secretaria.obtenerPorLetraAYLongitud(longitudAux);
                        System.out.println("--- Alumnos (A...) con longitud <= " + longitudAux + " ---");
                        listaResultado.forEach(System.out::println);
                        break;

                    default:
                        System.out.println("Opción no reconocida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Debes introducir un número válido.");
                opcion = -1;
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }

        } while (opcion != 0);

        scanner.close();
    }

}