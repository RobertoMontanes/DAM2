package ejercicio09_mini;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dado {

    public List<Integer> lanzar(){
        List<Integer> tiradas = new ArrayList<>();
        Random rnd = new Random(System.nanoTime());
        for (int i = 0; i < 10; i++) {
            tiradas.add(rnd.nextInt(6)+1);
        }
        return tiradas;
    }

    public Integer buscarMayor(List<Integer> tiradas){
        int num = tiradas.getLast();
        for (int i : tiradas) {
            if (i > num) {
                num = i;
            }
        }
        return num;
    }

    public Integer buscarMenor(List<Integer> tiradas){
        int num = tiradas.getLast();
        for (int i : tiradas) {
            if (i < num) {
                num = i;
            }
        }
        return num;
    }

    public List<Integer> buscarRepetido(List<Integer> tiradas) {
        // [0,0,0,0,0,0,0]
        int[] arrayOrden = new int[7];
        int mayor = tiradas.getLast();
        List<Integer> listaDev = new ArrayList<>();
        for (int i:tiradas) {
            arrayOrden[i]++;
        }
        
        for (int i = 0; i < arrayOrden.length; i++) {
            if (arrayOrden[i] > mayor) {
                mayor = arrayOrden[i];
            }
        }

        for (int i = 0; i < arrayOrden.length; i++) {
            if (arrayOrden[i] == mayor) {
                listaDev.add(i);
            }
        }
        return listaDev;
    }

}

