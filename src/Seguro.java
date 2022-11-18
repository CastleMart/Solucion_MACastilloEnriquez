import java.util.ArrayList;

public class Seguro {
    private int [] fechaInicio = new int[5];
    private int [] fechaFin = new int[5];
    private ArrayList<TipoSeguro> tiposSeguros;

    public Seguro(){
        listaSeguros();

    }

    private void listaSeguros(){
        TipoSeguro aux;
        tiposSeguros.add(aux = new TipoSeguro("Seguro de auto",30000,4,9000));
        tiposSeguros.add(aux = new TipoSeguro("Seguro de vida",600000,4,5000));
        tiposSeguros.add(aux = new TipoSeguro("Seguro de salud",500000,4,3000));
        tiposSeguros.add(aux = new TipoSeguro("Seguro de académico",250000,4,1000));
    }
}
