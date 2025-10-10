package ejercicioExtra02;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] menuOpciones = {
                "Abandonar el programa",
                "Listar productos",
                "Mostrar stock del almacén",
                "Calcular PVP de un producto",
                "Calcular total de ventas",
                "Calcular cambio a devolver"
        };

        int opcionAbandonar = 0, opcionEscogida, ajustarOpcionesArray = 1, idObjetivo, cantidad;
        double porcentaje = 0.25; // porcentaje de ganancia del vendedor
        int cantidadFija = 100;   // recargo fijo para espadas dobles
        Producto productoObjetivo;

        // Crear productos iniciales
        Producto[] listaProductos = new Producto[6];
        listaProductos[0] = new Moviles("Samsung Galaxy S22", 800, 5, 2, "Samsung", "Galaxy S22");
        listaProductos[1] = new Moviles("iPhone 14", 1200, 3, 1, "Apple", "iPhone 14");
        listaProductos[2] = new Moviles("Xiaomi Redmi Note 12", 400, 4, 1, "Xiaomi", "Redmi Note 12");
        listaProductos[3] = new EspadasLaser("Espada Jedi Azul", 600, 2, 1, "simple");
        listaProductos[4] = new EspadasLaser("Espada Sith Roja", 950, 1, 2, "doble");
        listaProductos[5] = new EspadasLaser("Espada Verde Maestro Yoda", 850, 3, 0, "simple");

        Ventas gestorVentas = new Ventas(listaProductos);

        System.out.println("=== Bienvenido al Puesto del Vendedor Ambulante de Tecnología Intergaláctica ===");

        do {
            // Mostrar menú
            for (int i = 0; i < menuOpciones.length; i++) {
                System.out.println(i + ". " + menuOpciones[i]);
            }

            System.out.print("¿Qué quieres hacer?: ");
            opcionEscogida = Integer.parseInt(sc.nextLine());

            while (opcionEscogida > menuOpciones.length - ajustarOpcionesArray && opcionEscogida > opcionAbandonar) {
                System.out.print("Has indicado una opción inválida, inserta una nueva: ");
                opcionEscogida = Integer.parseInt(sc.nextLine());
            }

            switch (opcionEscogida) {
                case 0:
                    System.out.println("Cerrando el programa...");
                    break;

                case 1:
                    gestorVentas.listarProductos();
                    break;

                case 2:
                    gestorVentas.checkAlmacen();
                    break;

                case 3:
                    System.out.print("Indica el ID del producto para calcular su PVP: ");
                    idObjetivo = Integer.parseInt(sc.nextLine());
                    productoObjetivo = gestorVentas.buscarProductoPorID(idObjetivo);

                    if (productoObjetivo == null) {
                        System.out.println("No se encontró ningún producto con ID " + idObjetivo);
                    } else {
                        double pvp = productoObjetivo.calcularPVP(porcentaje, cantidadFija);
                        System.out.println("El PVP del producto \"" + productoObjetivo.getNombre() + "\" es: " + pvp + " €");
                        if (productoObjetivo instanceof EspadasLaser) {
                            System.out.println("¡Cuidadín al sacarla de la bolsa, que hace pupa!");
                        }
                    }
                    break;

                case 4:
                    System.out.println("El total recaudado entre todas las ventas es: "
                            + gestorVentas.calcularTotalVentas(porcentaje, cantidadFija) + " €");
                    break;

                case 5:
                    System.out.print("Indica el ID del producto: ");
                    idObjetivo = Integer.parseInt(sc.nextLine());
                    productoObjetivo = gestorVentas.buscarProductoPorID(idObjetivo);

                    if (productoObjetivo == null) {
                        System.out.println("No se encontró ningún producto con ID " + idObjetivo);
                        break;
                    }

                    System.out.print("¿Cuántas unidades ha comprado el cliente?: ");
                    cantidad = Integer.parseInt(sc.nextLine());

                    System.out.print("Introduce el dinero entregado por el cliente: ");
                    double pagado = Double.parseDouble(sc.nextLine());

                    double cambio = gestorVentas.calcularCambio(productoObjetivo, pagado, cantidad, porcentaje, cantidadFija);

                    if (cambio < 0) {
                        System.out.println("Falta dinero: el cliente debe pagar " + Math.abs(cambio) + " € más.");
                    } else {
                        System.out.println("El cambio a devolver es de: " + cambio + " €");
                    }
                    break;

                default:
                    System.err.println("Opción desconocida, volviendo al menú...");
                    break;
            }

            System.out.println();

        } while (opcionEscogida != opcionAbandonar);

        System.out.println("Gracias por tu visita. ¡Que la Fuerza te acompañe!");
        sc.close();
    }

}
