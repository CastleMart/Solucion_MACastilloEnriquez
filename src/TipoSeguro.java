public class TipoSeguro {

    private String tipoSeguro;
    private String descripcion;
    private float precioSeguro;
    private int duracionMeses;
    private float pagoMensual;

    /**
     * Constructor de la clase tipo de seguro.
     * @param tipoSeguro
     * @param precio
     * @param duracionMeses
     * @param precioSeguro
     */
    public TipoSeguro(String tipoSeguro,float precio, int duracionMeses, float precioSeguro){
        this.tipoSeguro = tipoSeguro;
        this.precioSeguro = precio;
        this.duracionMeses = duracionMeses;
        this.precioSeguro = precioSeguro;

    }

    /**
     * Se puede ingresar una descripción del seguro.
     * @param tipoSeguro
     */
    public void setDescripcion(String tipoSeguro){
        this.tipoSeguro = tipoSeguro;
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
