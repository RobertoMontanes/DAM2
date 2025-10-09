package ejercicio05;

import java.util.Scanner;

public class Principal {
    // Crea un programa que pida un número e indique si es primo o no.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un número: ");
        int numero = sc.nextInt();

        boolean esPrimo = true;

        if (numero <= 1) {
            esPrimo = false;
        } else {
            for (int i = 2; i * i <= numero && esPrimo; i++) { // Evitamos usar Math.sqrt
                if (numero % i == 0) {
                    esPrimo = false;
                }
            }
        }

        if (esPrimo) {
            System.out.println(numero + " es un número primo.");
        } else {
            System.out.println(numero + " no es un número primo.");
        }

        sc.close();
    }


}
