package ejercicio09;

// Crea una clase dado con algun metodo como  lanzar que devuelva
// un numero aleatoriio entre 1 y 6. Simula 10 tiradas y muesla puntuacion mayor,
// la menor y que numero se ha repetido mas veces.

import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Dado dado = new Dado();
        Scanner scanner = new Scanner(System.in);
        int rollNm, max = 6, min = 1;
        List<Integer> numbersRolled;
        String[] textChange = {
                "The most repeated number is: ",
                "The most repeated numbers are: "
        };
        int opcion, opcionSalir = 0,opcionMax = 1;

        System.out.println("Welcome to our roll the dice program.");

        do {

            System.out.println("How many times do you want to roll the dice? ");
            rollNm = Integer.parseInt(scanner.nextLine());

            numbersRolled = dado.roll(rollNm,min,max);

            System.out.println("The numbers rolled are: " + numbersRolled);

            System.out.println("The highest rolled number is: " + dado.returnHigher(numbersRolled,min));
            System.out.println("The lowest rolled number is: " + dado.returnLower(numbersRolled,max));
            System.out.println((numbersRolled.size() > 1 ? textChange[0] : textChange[1]) + dado.buscarMasRepetido(numbersRolled,min) );

            System.out.println("Wich number do you want to check how many times did it appear? ");
            opcion = Integer.parseInt(scanner.nextLine());
            System.out.println("The number: " + opcion + " appear " + dado.contarNumero(numbersRolled,opcion) + " times. ");

            System.out.println("The addition of all the numbers is: " + dado.obtenerSuma(numbersRolled));

            System.out.println("Do you want to repeat? 1-Yes,0-No");
            opcion = Integer.parseInt(scanner.nextLine());

            while (opcion > opcionMax || opcion < opcionSalir) {
                System.out.println("Invalid option selected, try again... ");
                opcion = Integer.parseInt(scanner.nextLine());
            }


        } while (opcion != opcionSalir);

        System.out.println("Thanks for using the program");




    }

}
