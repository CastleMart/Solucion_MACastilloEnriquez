import jdk.jfr.Unsigned;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class Cuenta {
    //Atributos de la clase cuenta.
    private long idCuenta;

    private String RFC;
    private String nombre;
    private String apellidos;
    private float saldo;
    private int [] fechaCreacion = new int[5];
    //private Movimiento [] mov = {};
    private ArrayList <Movimiento> mov = new ArrayList<>();
    private Random num = new Random();
    private double ingresos, egresos;

    /**
     * Constructor de la clase cuenta.
     * @param RFC
     * @param nombres
     * @param apellidos
     * @param saldoInicial
     */
    public Cuenta(String RFC, String nombres, String apellidos, float saldoInicial){

        Random num = new Random();
        this.RFC = RFC;
        this.nombre = nombres;
        this.apellidos = apellidos;
        this.ingresos = 0;
        this.egresos = 0;

        Calendar fecha = Calendar.getInstance();

        this.fechaCreacion[0] = fecha.get(Calendar.DATE);
        this.fechaCreacion[1] = fecha.get(Calendar.MONTH);
        this.fechaCreacion[2] = fecha.get(Calendar.YEAR);
        this.fechaCreacion[3] = fecha.get(Calendar.HOUR_OF_DAY);
        this.fechaCreacion[4] = fecha.get(Calendar.MINUTE);

        this.saldo = saldoInicial;


    }

    /**
     * Método que genera la id de la cuenta aleatoriamente.
     */
    public void generarIdCuenta(){

        this.idCuenta = num.nextInt(999999999);

    }

    /**
     * Setter que modifica el nombre del cliente
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Setter que modifica el RFC del cliente.
     * @param RFC
     */
    public void setRFC(String RFC) {
        this.RFC = RFC;
    }
    //************************** GETTERS***************************************

    /**
     * Regresa el nombre del cliente.
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Regresa los apellidos.
     * @return apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Regresa el RFC del cliente.
     * @return RFC
     */
    public String getRFC() {
        return RFC;
    }

    /**
     * Regresa el saldo de la cuenta.
     * @return saldo
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     * Regresa el id de la cuenta
     * @return
     */
    public long getIdCuenta() {
        return idCuenta;
    }

    /**
     * Regresa la fecha de creación de la cuenta.
     * @return
     */
    public int[] getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Regresa los movimientos realizados.
     * @return
     */
    public ArrayList<Movimiento> getMov() {
        return mov;
    }

    /**
     * Se regresa los egresos totales de la cuenta
     * @return
     */
    public double getEgresos() {
        return egresos;
    }

    /**
     * Se regresa los ingresos totales de la cuenta.
     * @return
     */
    public double getIngresos() {
        return ingresos;
    }

    //---------------------------------------------------------------------------------------------------------------------


    /**
     * Método que realiza un retiro dentro de la cuenta.
     * @param monto
     * @param concepto
     */
    public boolean retirarMonto(float monto, String concepto){
        Movimiento retiro = new Movimiento("Retiro", monto, concepto);
        if (this.saldo > retiro.getMonto() && this.saldo > 0){

            this.saldo -= retiro.getMonto();
            this.egresos += retiro.getMonto();
            this.mov.add(retiro);
            System.out.println("El retiro fue exitoso.");

            return true;
        }
        else {
            System.out.println("No es posible retirar.");
            return false;
        }

    }

    /**
     * Método que deposita dinero a la cuenta.
     * @param monto
     * @param concepto
     */
    public boolean depositarMonto(float monto, String concepto){
        if(monto > 0){
            System.out.println("No es valido la entrada del monto.");
            return false;
        }
        Movimiento deposito = new Movimiento("Deposito", monto, concepto);
        this.saldo += deposito.getMonto();
        this.ingresos += deposito.getMonto();
        this.mov.add(deposito);

        return true;
    }


    /**
     * Muestra el historial de transacciones.
     */
    public void historialTransacciones(){

        Movimiento movimiento ;
        int [] fecha;



        for(int cont = 0; cont < this.mov.size(); cont ++){
            movimiento = this.mov.get(cont);
            fecha = movimiento.getFechaMovimiento();

            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println(" * * *         " + movimiento.getTipoMovimiento() + "         * * *");
            System.out.printf("   %d/%d/%d a las %d con %d minutos.\n", fecha[0], fecha[1], fecha[2], fecha[3], fecha[4]);
            System.out.println("El " + movimiento.getTipoMovimiento() + " fue de  $" + movimiento.getMonto() + " Pesos");
            System.out.println("Concepto:  " + movimiento.getConcepto());

        }

        System.out.println("------------------------------------------------------------------------------------------");
    }
}
