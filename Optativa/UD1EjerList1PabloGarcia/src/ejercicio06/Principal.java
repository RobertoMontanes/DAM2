package ejercicio06;

import java.util.Scanner;

public class Principal {

    //Clasificador de edades. Pedir la edad de una persona y decir en qué rango está de los siguientes: Bebé,
    //niño, adolescente, joven mayor de edad, anciano (busca más o menos las edades límite de cada). El
    //programa se debe repetir hasta que el usuario desee.

    public static void main(String[] args) {
        int edadActual = 0;
        Scanner sc = new Scanner(System.in);
        String midSc;
        boolean esNumero = true;

        System.out.println("Bienvenido al clasificador de edades.");


        do{

            System.out.print("Indica tu edad o X para salir: ");
            midSc = sc.nextLine();

            try {
                edadActual = Integer.parseInt(midSc);
            } catch (NumberFormatException e) {
                esNumero = false;
            }

            if (esNumero) {

                if (edadActual < 0) {
                    System.out.println("Edad no válida.");
                } else if (edadActual <= 3) {
                    System.out.println("Eres un bebé.");
                } else if (edadActual <= 12) {
                    System.out.println("Eres un niño.");
                } else if (edadActual <= 17) {
                    System.out.println("Eres un adolescente.");
                } else if (edadActual <= 64) {
                    System.out.println("Eres un joven mayor de edad.");
                } else {
                    System.out.println("Eres un anciano.");
                }

            }

        } while (!midSc.equalsIgnoreCase("X"));
        System.out.println("Gracias por usar el clasificador de edades. Hasta pronto.");

    }

}
