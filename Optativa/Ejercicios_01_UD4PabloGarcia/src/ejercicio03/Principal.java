package ejercicio03;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a,b,c;
        double[] resultados;
        int opcion, opcionAbandonar = 0;
        String[] opciones = {"Abandonar", "Resolver Ecuación"};

        
        System.out.println("Bienvenido al programa de resolver ecuaciones: ");
        do {
            try {
                for (int i = 0; i < opciones.length; i++) {
                    System.out.println(i + ". " + opciones[i]);
                }
                System.out.print("Seleccione una opción: ");
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 0 -> System.out.println("Muchas gracias por usar el programa, Saliendo del programa...");
                    case 1 -> {
                        System.out.print("Coeficiente a: ");
                        a = Double.parseDouble(sc.nextLine());
                        System.out.print("Coeficiente b: ");
                        b = Double.parseDouble(sc.nextLine());
                        System.out.print("Coeficiente c: ");
                        c = Double.parseDouble(sc.nextLine());

                        resultados = CEcuacion2Grado.resolver(a, b, c);

                        if (resultados[1] == Double.NEGATIVE_INFINITY) {
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