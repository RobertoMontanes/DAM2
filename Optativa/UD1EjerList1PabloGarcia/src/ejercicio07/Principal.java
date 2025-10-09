package ejercicio07;

public class Principal {

    public static void main(String[] args) {

        System.out.println("Bienvenido al control de bombillas inteligentes");
        Bombilla bombilla1 = new Bombilla(false);

        System.out.println("Estado inicial de la bombilla: " + (bombilla1.getEstado() ? "Encendida" : "Apagada"));
        bombilla1.alternar();
        System.out.println("Estado de la bombilla después de alternar: " + (bombilla1.getEstado() ? "Encendida" : "Apagada"));

    }

}
