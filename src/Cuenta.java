import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class Cuenta {
    //Atributos de la clase cuenta.
    private long idCuenta;
    private String RFC;
    private String nombre;
    private float saldo;
    private int [] fechaCreacion = new int[5];
    //private Movimiento [] mov = {};
    private ArrayList <Movimiento> retiros = new ArrayList<>();
    private ArrayList <Movimiento> depositos = new ArrayList<>();
    private Random num = new Random();


    public void Cuenta(String RFC, String nombre, float saldoInicial){

        Random num = new Random();
        this.RFC = RFC;
        this.nombre = nombre;

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
     * Regresa los retiros realizados.
     * @return
     */
    public ArrayList<Movimiento> getRetiros() {
        return retiros;
    }

    /**
     * Regresa los depositos realizados.
     * @return
     */
    public ArrayList<Movimiento> getDepositos() {
        return depositos;
    }

    /**
     * Método que realiza un retiro dentro de la cuenta.
     * @param monto
     * @param concepto
     */
    public boolean retirarMonto(float monto, String concepto){
        Movimiento retiro = new Movimiento("Retiro", monto, concepto);
        if (this.saldo > retiro.getMonto()){

            this.saldo -= retiro.getMonto();
            this.retiros.add(retiro);
            return true;
        }
        else {
            return false;
        }

    }

    /**
     * Método que deposita dinero a la cuenta.
     * @param monto
     * @param concepto
     */
    public void depositarMonto(float monto, String concepto){
        Movimiento deposito = new Movimiento("Deposito", monto, concepto);
        this.saldo += deposito.getMonto();
        this.depositos.add(deposito);
    }


}