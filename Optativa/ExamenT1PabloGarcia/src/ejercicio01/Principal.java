package ejercicio01;


import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        int opcion, opcionAbandonar = 0;
        Scanner sc = new Scanner(System.in);

        String[] menuInicial = {
                "Leave",
                "Show vehicles",
                "Check all vans length",
                "Check A cost",
                "Check collected by motorbikes",
                "Modify default parking values."
        };

        String[] menuParametros = {
                "Leave",
                "Modify parking per minute tax",
                "Modify van extra length tax",
                "Modify divisible by discount motorbikes",
                "Modify van minimal length preTax",
                "Modify motorbike CC for discount",
                "Modify van advise length"
        };

        double tasaParking = 0.05, tasaLongitud = 2, descuentoCC =2;
        int tamTasa = 4, tamCC = 250, tamMin = 3;

        Vehiculo vInt;

        List<Vehiculo> vehiculoList = List.of(
                new Vehiculo("1234ABC",120),
                new Vehiculo("2345BCD",65),
                new Vehiculo("3456CDE",13),
                new Moto("4567DEF",43, 125),
                new Furgoneta("5678EFG",234,6),
                new Furgoneta("6789FGH",92,2),
                new Moto("7890GHI",5,300)
        );

        Parking parking  = new Parking("Pl. del Altozano, s/n",vehiculoList,tasaParking,tasaLongitud,tamTasa,descuentoCC,tamCC);

        System.out.println("Welcome, In today's program we are going to emulate a Parking....");

        do {

            for (int i = 0; i < menuInicial.length; i++) {
                System.out.println(i + ". " + menuInicial[i]);
            }

            System.out.println("What do you want to do? ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion){
                case 0:
                    System.out.println("Thanks for using the program, have a nice day.");
                    break;
                case 1:
                    System.out.println("Loading vehicles....");
                    parking.mostrarDatos();
                    break;
                case 2:
                    System.out.println("Loading vans....");
                    parking.comprobarTamanyo(tamMin);
                    break;
                case 3:
                    System.out.println("Loading....");
                    System.out.println("Insert the plate of the Vehicle you want to check: ");
                    vInt = parking.findByMatricula(sc.nextLine());

                    if (vInt == null) {
                        System.out.println("The selected Plate doesnt exist in the Parking.");
                    } else {
                        System.out.printf("The selected vehicle needs to pay: %.2f € \n",parking.calcularPrecioUnVehiculo(vInt));
                    }
                    break;
                case 4:
                    System.out.println("Loading motorbikes....");

                    System.out.printf("Only by motorbikes, the parking has collected: %.2f € \n",parking.calcularRecaudadoMotos());

                    break;
                case 5:
                    System.out.println("Loading actual parameters....");

                    for (int i = 0; i < menuParametros.length; i++) {
                        System.out.println(i + ". " + menuParametros[i]);
                    }

                    System.out.println("What do you want to do? ");
                    opcion = Integer.parseInt(sc.nextLine());

                    switch (opcion){
                        case 0:
                            System.out.println("Returning to the menu...");
                            opcion = -1;
                            break;
                        case 1:
                            System.out.printf("Insert the new quantity (Actual is %.2f): ",tasaParking);
                            parking.setTasaParking(Double.parseDouble(sc.nextLine()));
                            break;
                        case 2:
                            System.out.printf("Insert the new quantity (Actual is %.2f): ",tasaLongitud);
                            parking.setTasaLongitud(Double.parseDouble(sc.nextLine()));
                            break;
                        case 3:
                            System.out.printf("Insert the new quantity (Actual is %.2f): ",descuentoCC);
                            parking.setDescuentoCC(Double.parseDouble(sc.nextLine()));
                            break;
                        case 4:
                            System.out.printf("Insert the new quantity (Actual is %d): ",tamTasa);
                            parking.setTamTasa(Integer.parseInt(sc.nextLine()));
                            break;
                        case 5:
                            System.out.printf("Insert the new quantity (Actual is %d): ",tamCC);
                            parking.setTamCC(Integer.parseInt(sc.nextLine()));
                            break;
                        case 6:
                            System.out.printf("Insert the new quantity (Actual is %d): ",tamMin);
                            tamMin = Integer.parseInt(sc.nextLine());
                            break;
                    }

                    break;
            }

        } while (opcion != opcionAbandonar);

        sc.close();

    }

}