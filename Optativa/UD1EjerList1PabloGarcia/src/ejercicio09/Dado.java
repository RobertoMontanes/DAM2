package ejercicio09;

import java.util.*;

public class Dado {

    public List<Integer> roll(int longitud, int min, int max) {
        List<Integer> listaNum = new ArrayList<>();
        Random rnd = new Random(System.nanoTime());

        do {
            listaNum.add(rnd.nextInt(max - min + 1) + min);
        } while (listaNum.size() < longitud);

        return listaNum;
    }

    public int contarNumero(List<Integer> listaNum, int numero) {
        int cont = 0;
        for (int i : listaNum) {
            if (i == numero) {
                cont++;
            }
        }
        return cont;
    }

    public int obtenerSuma(List<Integer> tiradas) {
        int[] cont = {0};
        tiradas.forEach(i -> {
            cont[0] += i;
        });
        return cont[0];
    }

    public Integer returnHigher(List<Integer> listaNum, int min) {

//        int[] mayorScp = {min-1};
//        listaNum.forEach(num -> {
//            if (num > mayorScp[0]){
//                mayorScp[0] = num;
//            }
//        });

        //return mayorScp[0];
        return listaNum.stream().max(Integer::compareTo).get();
    }

    public Integer returnLower(List<Integer> listaNum, int max) {

//        int[] menorScp = {max+1};
//        listaNum.forEach(num -> {
//            if (num < menorScp[0]){
//                menorScp[0] = num;
//            }
//        });
//
//        return menorScp[0];

        return listaNum.stream().min(Integer::compareTo).get();
    }

    public Map<Integer, Integer> clasificarMap(List<Integer> listaNum) {

        Map<Integer, Integer> numMap = new HashMap<>();

        for (int num : listaNum) {
            int value;
            if (numMap.containsKey(num)) {
                value = numMap.get(num);
                numMap.put(num, value + 1);
            } else {
                numMap.put(num, 1);
            }
        }
        return numMap;
    }

    public List<Integer> buscarMasRepetido(List<Integer> listaNum, int min) {
        Map<Integer, Integer> numMap = clasificarMap(listaNum);
        int mayorQt = returnHigher(new ArrayList<>(numMap.values()), min);
        return deOrder(numMap, mayorQt);
    }

    public List<Integer> deOrder(Map<Integer, Integer> numMap, int mayorQt) {
        List<Integer> finalList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            if (entry.getValue() == mayorQt) {
                finalList.add(entry.getKey());
            }
        }
        return finalList;
    }


}
