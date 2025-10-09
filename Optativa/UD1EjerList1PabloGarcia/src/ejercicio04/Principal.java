package ejercicio04;

import java.util.Scanner;

public class Principal {

    //En los pueblos del Aljarafe, en muchos bares existe un contador de días para que llegue el lunes del Rocío,
    //en otros sitios para un cumpleaños, para fin de año... Crea un programa con una cuenta atrás de un evento:
    //pide un número de días y muestra cuantos días quedan hasta el día del evento.

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String eventoName;
        int days;

        System.out.println("Bienvenido al contador de dias.");

        System.out.println("Indica el nombre del evento: ");
        eventoName = sc.nextLine();

        System.out.println("Indica cuantos dias faltan para el evento: ");
        days = Integer.parseInt(sc.nextLine());

        System.out.println("Faltan " + days + " dias para " + eventoName + ".");


    }

}
