package ejercicio03;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion, opcionAbandonar = 0;
        String[] opciones = {"Abandonar", "Resolver Ecuación"};

        do {
            try {
                for (int i = 0; i < opciones.length; i++) {
                    System.out.println(i + ". " + opciones[i]);
                }
                System.out.print("Seleccione una opción: ");
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 0 -> System.out.println("Saliendo del programa...");
                    case 1 -> {
                        System.out.print("Coeficiente a: ");
                        double a = Double.parseDouble(sc.nextLine());
                        System.out.print("Coeficiente b: ");
                        double b = Double.parseDouble(sc.nextLine());
                        System.out.print("Coeficiente c: ");
                        double c = Double.parseDouble(sc.nextLine());

                        double[] resultados = CEcuacion2Grado.resolver(a, b, c);

                        if (resultados.length == 1) {
                            System.out.printf("Ecuación de 1er grado. Raíz única: %.2f\n", resultados[0]);
                        } else {
                            System.out.printf("Raíz 1: %.2f | Raíz 2: %.2f\n", resultados[0], resultados[1]);
                        }
                    }
                    default -> System.out.println("Opción no válida.");
                }

            } catch (EcuacionDegeneradaException | RaicesComplejasException e) {
                System.err.println(e.getMessage());
                opcion = -1;
            } catch (NumberFormatException e) {
                System.err.println("Error: Introduzca un valor numérico válido.");
                opcion = -1;
            } catch (Exception e) {
                System.err.println("Error inesperado: " + e.getMessage());
                opcion = -1;
            }
            System.out.println();
        } while (opcion != opcionAbandonar);

        sc.close();
    }
}