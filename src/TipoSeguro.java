public class TipoSeguro {

    private String tipoSeguro;
    private String descripcion;
    private float precioSeguro;
    private int duracionMeses;
    private float pagoMensual;

    private byte cuatrimestreOferta;


    /**
     * Constructor de la clase tipo de seguro.
     * @param tipoSeguro
     * @param pagoMensual
     * @param duracionMeses
     * @param precioSeguro
     */
    public TipoSeguro(String tipoSeguro,float pagoMensual, int duracionMeses, float precioSeguro, byte cuatrimestreOferta){
        this.tipoSeguro = tipoSeguro;
        this.pagoMensual = pagoMensual;
        this.duracionMeses = duracionMeses;
        this.precioSeguro = precioSeguro;
        this.cuatrimestreOferta = cuatrimestreOferta;

    }

    /**
     * Se puede ingresar una descripción del seguro.
     * @param tipoSeguro
     */
    public void setDescripcion(String tipoSeguro){
        this.tipoSeguro = tipoSeguro;
    }

    /**
     * Setter del pago del seguro.
     * @param pagoMensual
     */
    public void setPagoMensual(float pagoMensual) {
        this.pagoMensual = pagoMensual;
    }

    /**
     * Regresa que cuatrimestre del año corresponde la oferta.
     * @return
     */
    public byte getCuatrimestreOferta() {
        return cuatrimestreOferta;
    }

    /**
     * Se retorna el tipo de seguro.
     * @return tipoSeguro
     */
    public String getTipoSeguro() {
        return tipoSeguro;
    }

    /**
     * Se retorna el precio del seguro.
     * @return
     */
    public float getPrecioSeguro() {
        return precioSeguro;
    }

    /**
     * Se retorna el pago mensual.
     * @return
     */
    public float getPagoMensual() {
        return pagoMensual;
    }

    /**
     * Se retorna la duración del seguro.
     * @return
     */
    public int getDuracionMeses() {
        return duracionMeses;
    }

    /**
     * Se da la descripción del seguro.
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }
}
