import java.util.ArrayList;

public class Banco {
    private ArrayList <Cuenta> cuentas ;

    /**
     * Constructor de la Clase Banco.
     */
    public void Banco(){
        cuentas = new ArrayList<>();
    }

    /**
     * Método que crear las cuentas de los usuarios del banco.
     * @param rfc
     * @param nombre
     * @param apellidos
     * @param saldoInicial
     */
    public void crearCuenta(String rfc, String nombre, String apellidos, float saldoInicial){

        Cuenta cuenta = new Cuenta( rfc, nombre, apellidos, saldoInicial);


        cuenta.generarIdCuenta();
        for (int cont = 0; cont < this.cuentas.size(); cont ++){
            if (cuenta.getIdCuenta() == this.cuentas.get(cont).getIdCuenta()){
                cuenta.generarIdCuenta();
                cont = 0;
            }
        }

        this.cuentas.add(cuenta);
        System.out.println("Se ha agregado la cuenta con éxito");
        System.out.println("La id de la cuenta es: " + cuenta.getIdCuenta());
    }



    public void BusquedaCuenta(){

    }

    /**
     * Busca por medio de la Id una cuenta.
     * @param idCuenta
     * @return
     */
    public Cuenta getCuentaID (long idCuenta){

        for (int cont = 0; cont < this.cuentas.size(); cont ++){
            if (idCuenta == this.cuentas.get(cont).getIdCuenta()){

                return this.cuentas.get(cont);
            }
        }

        return null;

    }
}
