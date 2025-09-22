package ejercicio02;

/* Escribe un programa que solicite las notas de una asignatura de 10 alumnos y calcule cuántos han
aprobado, cuántos suspendido y la nota media entre todos. Usar un array de doubles relleno de forma
aleatoria */

import java.util.Random;

public class Principal {

    public static void main(String[] args) {
        float[] notas;
        float media = 0, total = 0;
        int aprobado = 0, suspensos = 0, max = 10, min = 0,tam = 10, minSuspenso = 5;
        Random rnd = new Random();
        notas = new float[tam];

        for (int i = 0; i < notas.length; i++) {
            notas[i] = (float) (Math.floor((min + (max - min) * rnd.nextDouble()) * 100) / 100);
            System.out.println("Nota del Alumno " + i + ": " + notas[i]);

            if (notas[i] < minSuspenso) {
                suspensos++;
            } else {
                aprobado++;
            }

            total += notas[i];

        }

        media = total / notas.length;

        media = (float) (Math.floor(media * 100) / 100);

        System.out.println("Hay un total de: " + suspensos + " suspensos");
        System.out.println("Hay un total de: " + aprobado + " aprobados");
        System.out.println("La nota media de la clase es: " + media);


    }

}
