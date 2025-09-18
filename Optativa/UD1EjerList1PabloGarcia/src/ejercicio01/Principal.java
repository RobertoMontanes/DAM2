package ejercicio01;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int codigo = 1234, intento, numIntentos = 0, intentosMax = 3;
        boolean continuar = true;

        System.out.println("Bienvenido a ADIVINA EL CODIGO EN 3 INTENTOS O MENOS.");

        System.out.println("Indica el codigo secreto (SOLO NUMEROS): ");
        codigo = Integer.parseInt(sc.nextLine());

        System.out.println("Deberas adivinar el co   digo secreto en al menos 3 intentos.");

        do {

            System.out.println("Indique cual es el codigo (Inteto "+ numIntentos + "/" + intentosMax +"): ");
            intento = Integer.parseInt(sc.nextLine());

            if (intento == codigo) {
                System.out.println("Felicidades, has adivinado el codigo.");
                continuar = false;
            } else {
                if (numIntentos >= intentosMax) {
                    System.out.println("Te has equivocado por ultima vez, bloqueando el candado.");
                    continuar = false;
                } else {
                    System.out.println("Te has equivocado.");
                    numIntentos++;
                }
            }

        } while (continuar);

        System.out.println("Gracias por usar el programa.");


    }

}
