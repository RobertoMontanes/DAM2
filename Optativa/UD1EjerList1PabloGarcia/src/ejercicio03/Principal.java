package ejercicio03;

import java.util.Scanner;

public class Principal {

    // Programa que pida el precio de varios productos (hasta que el usuario escriba 0) y calcula el total a pagar
    //aplicando un 10% de descuento solo si supera 100 €.

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double precioActual = 0;
        int salir = 0, max = 100, discount = 10, basePorcentaje = 100;
        double precioTotal = 0;

        do {
            precioTotal += precioActual;
            System.out.println("Ingrese un valor para la operacion ("+salir+" para salir): ");
            precioActual = Double.parseDouble(sc.nextLine());
        } while (precioActual != salir);

        System.out.println("Has decidido salir de la insercion de precios.");
        precioTotal -= precioTotal >= max ? (precioTotal * discount) / basePorcentaje : 0;
        System.out.println("El precio final es: " + precioTotal);



    }

}
