	package ejercicio00;
	
	import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
	import java.util.Scanner;
	import java.util.Set;
import java.util.TreeMap;
	
	public class Principal {
	
	    public static void main(String[] args) {
	
	        Scanner sc = new Scanner(System.in);
	
	        Set<Producto> productos = new HashSet<>();
	        Tienda tienda = new Tienda(productos);
	        
	        Map<Double, Venta> ventasOrdenadas = new TreeMap<Double, Venta>();
	        
	        int ventasACrear = 5;
	        int  maxVentas = 10;
	        int ProductosPorVenta = 6;
	
	        Venta ventaActual = null;
	        
	        String[] menu = {
	    		"Salir",
	            "Agregar producto",
	            "Listar productos",
	            "Crear nueva venta",
	            "Añadir línea a venta",
	            "Mostrar ventas",
	            "Seleccionar una venta",
	            "Ordenar ventas por su total"
	        };
	
	        int opcion = -1;
	        
	        tienda.addAllProductos(Set.of(
	        	    new Producto(1, "Pan", 1.20),
	        	    new Producto(2, "Leche", 0.99),
	        	    new Producto(3, "Café", 4.50),
	        	    new Producto(4, "Huevos", 2.75),
	        	    new Producto(5, "Arroz", 1.85),
	        	    new Producto(6, "Azúcar", 1.10),
	        	    new Producto(7, "Pasta", 1.40),
	        	    new Producto(8, "Queso", 3.25),
	        	    new Producto(9, "Aceite", 5.10),
	        	    new Producto(10, "Manzanas", 2.30)
	        	));
	        
	        tienda.generarVentas(ventasACrear, maxVentas, ProductosPorVenta);
	        
	        while (opcion != 0) {
	
	            for (int i = 0; i < menu.length; i++) {
	            	System.out.println(i + ". " + menu[i]);
	            }
	            System.out.printf("Seleccione una opción: ");
	            try {
	                opcion = Integer.parseInt(sc.nextLine());
	            } catch (NumberFormatException e) {
	                System.out.println("Debe introducir un número válido.");
	                continue;
	            }
	
	            switch (opcion) {
	
	                case 1:
	                        System.out.print("ID del producto: ");
	                        int idProd = Integer.parseInt(sc.nextLine());
	
	                        System.out.print("Nombre del producto: ");
	                        String nombre = sc.nextLine();
	
	                        System.out.print("Precio del producto: ");
	                        double precio = Double.parseDouble(sc.nextLine());
	
	                        Producto p = new Producto(idProd, nombre, precio);
	
	                        if (tienda.addProducto(p)) {
	                            System.out.println("Producto agregado correctamente.");
	                        } else {
	                            System.out.println("Ya existe un producto con ese ID.");
	                        }
	                    break;
	
	                case 2:
	                    System.out.println("\n*** Productos Disponibles ***");
	                    if (productos.isEmpty()) {
	                        System.out.println("No hay productos registrados.");
	                    } else {
	                        productos.forEach(System.out::println);
	                    }
	                    break;
	
	                case 3:
	                    if (productos.isEmpty()) {
	                        System.out.println("No puede crear una venta sin productos disponibles en la tienda.");
	                        break;
	                    }
	
	                    ventaActual = tienda.addVenta(new HashMap<Producto, Integer>());
	                    System.out.println("Nueva venta creada con ID: " + ventaActual.getId());
	                    break;
	
	                case 4:
	                    if (ventaActual == null) {
	                        System.out.println("Debe seleccionar una venta antes de agregar líneas.");
	                        break;
	                    }
	
	                    try {
	                        System.out.print("ID del producto: ");
	                        int idBuscar = Integer.parseInt(sc.nextLine());
	
	                        Optional<Producto> prodEncontrado = tienda.findProductoById(idBuscar);
	                        if (prodEncontrado.isEmpty()) {
	                            System.out.println("Producto no encontrado.");
	                            break;
	                        }
	
	                        System.out.print("Cantidad: ");
	                        int cantidad = Integer.parseInt(sc.nextLine());
	
	                        tienda.addLinea(ventaActual, prodEncontrado.get(), cantidad);
	                        System.out.println("Producto añadido a la venta.");
	                    } catch (NumberFormatException e) {
	                        System.out.println("Cantidad inválida.");
	                    }
	                    break;
	
	                case 5:
	                	if (tienda.getVentas().isEmpty()) {
	                		System.out.println("La tienda aun no dispone de ventas.");
	                	} else {
	                		for (Venta v : tienda.getVentas()) {
	                			System.out.println("\nVenta ID: " + v.getId());
	                			System.out.println("Fecha: " + v.getFecha());
	                			System.out.println("Productos:");
	                			
	                			v.getLineasVenta().forEach((prod, cant) ->
	                			System.out.println("\t "+prod.getNombre() + " - Cantidad: " + cant)
	                							);
	                		}                		
	                	}
	                    break;
	
	                case 6:
	                	System.out.printf("Indique el ID de la venta que desea seleccionar: ");
	                	ventaActual = tienda.getVentaById(Integer.parseInt(sc.nextLine()));
	                	
	                	if (ventaActual == null) {
							System.out.println("La venta seleccionada no existe.");
						}
	                	
	                	break;
	                case 7:
	                	if (tienda.getVentas().isEmpty()) {
	                        System.out.println("La tienda aun no dispone de ventas para ordenar.");
	                        break;
	                    }
	                    
	                	ventasOrdenadas.clear();
	                    for (Venta v : tienda.getVentas()) {
	                        ventasOrdenadas.put(tienda.getUniqueKey(v.getImporteTotal(), v.getId()), v);
	                    }
	                    
	                    System.out.println("\n*** Ventas Ordenadas por Importe Total (Menor a Mayor) ***");
	                    for (Map.Entry<Double, Venta> entry : ventasOrdenadas.entrySet()) {
	                        Venta v = entry.getValue();
	                        System.out.printf("Venta ID: %d | Total: %.2f€ | Fecha: %s\n", 
	                                          v.getId(), v.getImporteTotal(), v.getFecha());
	                    }
	                    break;
	                case 0:
	                    System.out.println("Saliendo del programa...");
	                    break;
	
	                default:
	                    System.out.println("Opción no válida.");
	            }
	        }
	
	        sc.close();
	    }
	}
