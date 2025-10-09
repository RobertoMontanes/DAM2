package ejercicio07;

public class Bombilla {

    //Control de bombillas inteligentes: crea una clase Bombilla con atributos (estado: encendida/apagada) y
    //métodos encender, apagar, mostrarEstado. Probar en un main.

    private boolean estado;

    public Bombilla(boolean estado) {
        this.estado = estado;
    }

    public void alternar() {
        this.estado = !this.estado;
    }

    public boolean getEstado() {
        return estado;
    }



}
