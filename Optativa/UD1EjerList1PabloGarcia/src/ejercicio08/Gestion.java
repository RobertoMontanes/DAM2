package ejercicio08;

import java.util.List;

public class Gestion {

    private int extraDevices;
    private List<String> extraExtas;

    public String resetData(){
        this.extraDevices = 0;
        this.extraExtas = List.of();
        return "Resetted alL Data";
    }

}
