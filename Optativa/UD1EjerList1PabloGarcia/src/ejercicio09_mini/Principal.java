package ejercicio09_mini;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {


    public static void main(String[] args) {
        Dado d = new Dado();
        Scanner sc = new Scanner(System.in);
        int opcion, opcionCerrar = 0;


        do {

            List<Integer> tirada;

            System.out.println("Roll:");
            tirada = d.lanzar();

            System.out.println("Higher: " + d.buscarMayor(tirada));
            System.out.println("Lower: " + d.buscarMenor(tirada));
            System.out.println("Most repeated: " + d.buscarRepetido(tirada));

            System.out.println("Rolls: ");
            tirada.forEach(i -> {
                System.out.print(i + ", ");
            });

            System.out.println("Repeat? 0 to Stop: ");
            opcion = Integer.parseInt(sc.nextLine());
        } while (opcion != opcionCerrar);

        sc.close();

    }

}
