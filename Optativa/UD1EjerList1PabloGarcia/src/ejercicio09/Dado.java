package ejercicio09;

import java.util.*;

public class Dado {

    public List<Integer> roll(int longitud,int min, int max){
        List<Integer> listaNum = new ArrayList<>();
        Random rnd = new Random(System.nanoTime());

        do {
            listaNum.add(rnd.nextInt(max - min + 1) + min);
        } while (listaNum.size() < longitud);

        return listaNum;
    }

    public int contarNumero(List<Integer> listaNum, int numero) {
        int[] cont = {0};
        listaNum.forEach(i -> {
            if (i == numero) {
                cont[0]++;
            }
        });
        return cont[0];
    }

    public int obtenerSuma(List<Integer> tiradas) {
        int[] cont = {0};
        tiradas.forEach(i -> {
            cont[0]+= i;
        });
        return cont[0];    }

    public Integer returnHigher(List<Integer> listaNum,int min) {

        int[] mayorScp = {min-1};

        listaNum.forEach(num -> {
            if (num > mayorScp[0]){
                mayorScp[0] = num;
            }
        });

        return mayorScp[0];
    }

    public Integer returnLower(List<Integer> listaNum,int max) {

        int[] menorScp = {max+1};

        listaNum.forEach(num -> {
            if (num < menorScp[0]){
                menorScp[0] = num;
            }
        });

        return menorScp[0];
    }

    public Map<Integer,Integer> clasificarMap(List<Integer> listaNum){

        Map<Integer,Integer> numDict = new HashMap<>();

        for (int num:listaNum) {
            if (numDict.containsKey(num)) {
                int value = numDict.get(num);
                numDict.put(num,value+1);
            } else {
                numDict.put(num,1);
            }
        }
        return numDict;
    }

    public List<Integer> buscarMasRepetido(List<Integer> listaNum, int min) {
        Map<Integer,Integer> numDict = clasificarMap(listaNum);
        int mayorQt= returnHigher(new ArrayList<>(numDict.values()),min);
        return deOrder(numDict,mayorQt);
    }

    public List<Integer> deOrder(Map<Integer,Integer> numDict, Integer mayorQt) {
        List<Integer> finalList = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : numDict.entrySet()) {
            if (entry.getValue() == mayorQt) {finalList.add(entry.getKey());}
        }
        return finalList;
    }



}
