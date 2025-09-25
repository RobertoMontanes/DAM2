package ejercicio08;

import java.util.*;

public class Principal {

    // Crea un prograna para gestionar los pagos de una plataforma de tv. Decide
    // que atributos, como se calculan descuentos por contratar varias cosas, Inttenta que sea lo mas completo posible


    public static void main(String[] args) {

        Map<String, Double> extras = new HashMap<>();
        List<Plan> planes = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String intermedio;
        int opcion = -1, opcionSalir = 0;
        boolean error;
        Plan seleccionado;
        String[] opcionesMenu2 = {
                "Leave",
                "Add extras",
                "Add Devices",
                "Calculate PVP"
        };

        planes.add(new Plan("Basico", 5, 2, "720p", new ArrayList<>(), true));
        planes.add(new Plan("Superior", 10, 5, "1080p", List.of("Estrenos cine"), true));
        planes.add(new Plan("Avanzado", 15, 5, "1440p", List.of("Futbol, Estrenos cine"), false));
        planes.add(new Plan("Futbol", 5, 1, "720p", List.of("Futbol"), true));

        extras.put("Futbol", 3.55);
        extras.put("Motor", 2.55);
        extras.put("Tenis", 2.55);
        extras.put("Deportes", 4.99);
        extras.put("Estrenos cine", 5.99);
        extras.put("Estrenos series", 3.99);
        extras.put("Cine retro", 2.99);

        System.out.println("Welcome to the Subscription management system. ");

        do {
            System.out.println("Plans: ");
            System.out.println(opcionSalir + ". Leave");
            for (int i = 0; i < planes.size(); i++) {
                System.out.println((i + 1) + ". " + planes.get(i).getNombre());
            }


            do {
                error = false;
                System.out.println("What plan does you want to use? ");
                intermedio = sc.nextLine();

                try {
                    opcion = Integer.parseInt(intermedio);
                } catch (NumberFormatException e) {
                    System.out.println("You selected something that is not a number.");
                    error = true;
                }

                if (opcion < opcionSalir || opcion > planes.size()) {
                    System.out.println("The option you selected is not in the menu.");
                }

            } while (error || opcion < opcionSalir || opcion > planes.size());


            if (opcion != opcionSalir) {
                seleccionado = planes.get(opcion - 1);
                System.out.println("You selected the " + seleccionado.getNombre() + " plan.");



            } else {
                System.out.println("You selected to leave the program, thanks for using it.");
            }

        } while (opcion != opcionSalir);

    }

}
