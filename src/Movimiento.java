import java.util.Calendar;

public class Movimiento {
    //Atributos de la clase Movimiento.
    private int fechaMovimiento [] = new int[5];
    private String tipoMovimiento;
    private double monto;
    private String concepto;


    /**
     * Constructos de la clase movimiento que recibe el tipo, el monto y el concepto.
     * @param tipoMovimiento
     * @param monto
     * @param concepto
     */
    public Movimiento(String tipoMovimiento, double monto, String concepto){

        Calendar fecha = Calendar.getInstance();

        this.fechaMovimiento[0] = fecha.get(Calendar.DATE);
        this.fechaMovimiento[1] = fecha.get(Calendar.MONTH);
        this.fechaMovimiento[2] = fecha.get(Calendar.YEAR);
        this.fechaMovimiento[3] = fecha.get(Calendar.HOUR_OF_DAY);
        this.fechaMovimiento[4] = fecha.get(Calendar.MINUTE);
        //this.fechaMovimiento[5] = fecha.get(Calendar.AM_PM);

        this.tipoMovimiento = tipoMovimiento;
        this.monto = monto;
        this.concepto = concepto;
    }

    /**
     * Retorna la fecha del movimiento.
     * @return fechaMovimiento
     */
    public int[] getFechaMovimiento() {
        return fechaMovimiento;
    }


    /**
     * Regresa el tipo de movimiento realizado.
     * @return tipoMovimiento
     */
    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    /**
     * Regresa el monto realizado.
     * @return monto
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Regresa el concepto del movimineto.
     * @return concepto
     */
    public String getConcepto() {
        return concepto;
    }
}
