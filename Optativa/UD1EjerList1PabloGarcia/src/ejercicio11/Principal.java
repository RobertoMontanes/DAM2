package ejercicio11;

import java.util.ArrayList;
import java.util.List;

public class Principal {

    /*
    Haz un estudio de los distintos puestos que pueden tener los empleados de una empresa de programación
    y cuánto gana cada uno. Crea las clases, con sus atributos y métodos necesarios para poder calcular el
    sueldo dependiendo de las horas trabajadas, horas extra, según las distintas funciones o responsabilidades,
    etc.
     */

    public static void main(String[] args) {

        System.out.println("Bienvenido al programa.");

        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new Administrativo("Jose Miguel",3,1200,200,8,20,5,100));
        empleados.add(new Controlado("Antonio",4,100,3,10,137,5));
        empleados.add(new Empleado("Joaquin",6,1000,10,25,10));

        System.out.println("Los sueldos de los diferentes empleados son: ");

        for (Empleado e: empleados) {
            System.out.println(e.getNombre() + " es un " + e.getClass().getName() + " y cobra: " + e.calcularSueldo() + " euros");
        }


        System.out.println("Gracias por usar el programa.");


    }

}
