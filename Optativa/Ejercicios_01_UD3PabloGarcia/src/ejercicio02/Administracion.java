package ejercicio02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Administracion {
	

	private List<String> listaCadenas;
	
	public Administracion(List<String> listaCadenas) {
		this.listaCadenas = listaCadenas;
	}

	public List<String> getListaCadenas() {
		return listaCadenas;
	}

	public void setListaCadenas(List<String> listaCadenas) {
		this.listaCadenas = listaCadenas;
	}

	public boolean addLinea(String nuevaLinea) {
		return listaCadenas.add(nuevaLinea);
	}

	public List<String> ordenarCadena() {
		List<String> sortedList = new ArrayList<String>();
		listaCadenas.forEach(c -> sortedList.add(c));
		Collections.sort(sortedList);
		return sortedList;
	}

	public List<String> buscarCadena(String nextLine) {
		return listaCadenas.stream().filter(c -> c.contains(nextLine)).toList();
	}

	public String crearCreatura() {
		String finalString[] = {""};
		listaCadenas.forEach(a -> {
			finalString[0] += a.charAt(0);
		});
		return finalString[0];
	}

	public List<String> borrarImpares() {
		return listaCadenas.stream().filter(c -> c.length() % 2 == 0).toList();
	}

	public List<String> convertirMayus() {
		return listaCadenas.stream().map(c -> c.toUpperCase()).toList();
	}

	

}
