import java.util.ArrayList;
import java.util.Calendar;

public class Seguro {
    private int [] fechaInicio = new int[5];
    private int [] fechaFin = new int[5];
    private double mensualidadSeguro;
    private TipoSeguro seguroObtenido;
    public final byte ENERO_ABRIL = 1;
    public final byte MAYO_AGOSTO = 2;
    public final byte SEPTIEMBRE_DICIEMBRE = 3;
    private ArrayList<TipoSeguro> tiposSeguros = new ArrayList<>();
    Calendar fecha = Calendar.getInstance();

    public Seguro(){
        listaSeguros();


    }

    /**
     * Aquí se carga todos los seguros disponibles.
     */
    private void listaSeguros(){
        TipoSeguro aux;
        aux = new TipoSeguro("Seguro de auto",1500,5,50000,ENERO_ABRIL);
        tiposSeguros.add(aux);
        aux = new TipoSeguro("Seguro de vida",1000,3,20000,MAYO_AGOSTO);
        tiposSeguros.add(aux);
        aux = new TipoSeguro("Seguro de salud",3000,8,80000,SEPTIEMBRE_DICIEMBRE);
        tiposSeguros.add(aux);


    }


    /**
     * retorna la fecha en que se pidió el seguro.
     * @return
     */
    public int[] getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Fecha en que temina el seguro.
     * @return
     */
    public int[] getFechaFin() {
        return fechaFin;
    }


    /**
     * Regresa el cuatrimestre actual.
     * @return
     */
    public byte cuatrimestreActual(){

        int [] fechaActual = new int[5];
        fechaActual[0] = fecha.get(Calendar.DATE);
        fechaActual[1] = fecha.get(Calendar.MONTH);
        fechaActual[2] = fecha.get(Calendar.YEAR);
        fechaActual[3] = fecha.get(Calendar.HOUR_OF_DAY);
        fechaActual[4] = fecha.get(Calendar.MINUTE);

        if(fechaActual[1] >= 1 && fechaActual[1] <= 4){
            return ENERO_ABRIL;
        } else if (fechaActual[1] >= 5 && fechaActual[1] <= 8) {
            return MAYO_AGOSTO;
        } else if (fechaActual[1] >= 9 && fechaActual[1] <= 12) {
            return SEPTIEMBRE_DICIEMBRE;
        }

        return -1;
    }

    /**
     * Método que muestra las ofertas de los seguros.
     */
    public void mostrarOfertas(){

        for (int cont = 0; cont < tiposSeguros.size(); cont ++){
            if(cuatrimestreActual() == this.tiposSeguros.get(cont).getCuatrimestreOferta()){
                System.out.println("Hay una oferta del 50% para " + this.tiposSeguros.get(cont).getTipoSeguro());
            }
        }

    }

    /**
     * Método que muestra los seguros disponibles junto con las ofertas
     */
    public void mostrarSeguros(){

        mostrarOfertas();
        System.out.println("          Lista de seguros disponibles" );
        for (int cont = 0; cont < tiposSeguros.size(); cont ++){
            if(tiposSeguros.get(cont).getCuatrimestreOferta() == cuatrimestreActual() )    {
                System.out.println(cont + 1 + ". " + tiposSeguros.get(cont).getTipoSeguro() + " con pago mensual de: $" + tiposSeguros.get(cont).getPagoMensual()/2 + " ***");
            }
            else {
                System.out.println(cont + 1 + ". " + tiposSeguros.get(cont).getTipoSeguro() + " con pago mensual de: $" + tiposSeguros.get(cont).getPagoMensual());
            }
        }



    }

    /**
     * Método que aplica el seguro.
     * @param seguro
     */
    public void aplicarSeguro(TipoSeguro seguro){

        if (seguro.getCuatrimestreOferta() == cuatrimestreActual() ){
            seguro.setPagoMensual(seguro.getPagoMensual() / 2);
        }

        this.seguroObtenido = seguro;


    }
}
