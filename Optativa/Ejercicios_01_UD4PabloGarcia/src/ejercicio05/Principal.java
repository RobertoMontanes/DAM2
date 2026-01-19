package ejercicio05;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Principal {
    
    private static List<Integer> historialAleatorios = new ArrayList<>();
    private static List<Integer> idsExistentes = new ArrayList<>();
    private static double saldoBizum = 100.0; // Saldo inicial de prueba

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        
        System.out.println("--- SISTEMA DE GESTIÓN DE EXCEPCIONES ESPECÍFICAS ---");

        do {
            try {
                imprimirMenu();
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1 -> {
                        int num = generarAleatorio();
                        System.out.println("Número generado con éxito: " + num);
                    }
                    case 2 -> {
                        System.out.print("Introduce ID a registrar: ");
                        registrarId(Integer.parseInt(sc.nextLine()));
                        System.out.println("ID registrado correctamente.");
                    }
                    case 3 -> {
                        System.out.print("Introduce un número par: ");
                        comprobarPar(Integer.parseInt(sc.nextLine()));
                        System.out.println("Validación de paridad correcta.");
                    }
                    case 4 -> {
                        System.out.print("Cantidad para el Bizum: ");
                        enviarBizum(Double.parseDouble(sc.nextLine()));
                        System.out.println("Envío realizado. Saldo actual: " + saldoBizum);
                    }
                    case 5 -> {
                        System.out.print("Introduce tu edad: ");
                        verificarMayoriaEdad(Integer.parseInt(sc.nextLine()));
                        System.out.println("Acceso permitido.");
                    }
                    case 6 -> {
                        System.out.print("Introduce código de producto (4 caracteres): ");
                        validarCodigo(sc.nextLine());
                        System.out.println("Código válido.");
                    }
                    case 0 -> System.out.println("Cerrando programa...");
                    default -> System.out.println("Opción no válida.");
                }
            } 
            // Bloques Catch específicos para cada excepción custom
            catch (AleatorioRepetidoException | IdDuplicadoException | NumeroImparException | 
                   SaldoInsuficienteException | MenorEdadException | FormatoCodigoException e) {
                System.err.println("ERROR ESPECÍFICO: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.err.println("ERROR: Por favor, introduce un dato numérico válido.");
            } catch (Exception e) {
                System.err.println("ERROR INESPERADO: " + e.getMessage());
            }
        } while (opcion != 0);
        
        sc.close();
    }

    private static void imprimirMenu() {
        System.out.println("\n1. Generar Aleatorio | 2. Seteo ID | 3. Validar Par | 4. Bizum | 5. Edad | 6. Código | 0. Salir");
        System.out.print("Seleccione: ");
    }

    // --- MÉTODOS SOLICITADOS ---

    public static int generarAleatorio() throws AleatorioRepetidoException {
        int n = new Random().nextInt(10) + 1; // Rango 1-10 para facilitar el test de error
        if (historialAleatorios.contains(n)) throw new AleatorioRepetidoException("El número " + n + " ya salió.");
        historialAleatorios.add(n);
        return n;
    }

    public static void registrarId(int id) throws IdDuplicadoException {
        if (idsExistentes.contains(id)) throw new IdDuplicadoException("El ID " + id + " ya está en uso.");
        idsExistentes.add(id);
    }

    public static void comprobarPar(int n) throws NumeroImparException {
        if (n % 2 != 0) throw new NumeroImparException("El número " + n + " es impar.");
    }

    public static void enviarBizum(double cantidad) throws SaldoInsuficienteException {
        if (cantidad > saldoBizum) throw new SaldoInsuficienteException("No tienes saldo suficiente (" + saldoBizum + "€).");
        saldoBizum -= cantidad;
    }

    public static void verificarMayoriaEdad(int edad) throws MenorEdadException {
        if (edad < 18) throw new MenorEdadException("Acceso denegado: Eres menor de edad.");
    }

    public static void validarCodigo(String cod) throws FormatoCodigoException {
        if (cod.length() != 4) throw new FormatoCodigoException("El código debe tener exactamente 4 caracteres.");
    }
}