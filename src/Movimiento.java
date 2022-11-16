import java.util.Calendar;

public class Movimiento {
    //Atributos de la clase Movimiento.
    private int fechaMovimiento [] = new int[3];
    private String tipoMovimiento;
    private double monto;
    private String concepto;


    public Movimiento(String tipoMovimiento, double monto, String concepto){

        Calendar fecha = Calendar.getInstance();

        this.fechaMovimiento[0] = fecha.get(Calendar.DATE);
        this.fechaMovimiento[1] = fecha.get(Calendar.MONTH);
        this.fechaMovimiento[2] = fecha.get(Calendar.YEAR);
        this.tipoMovimiento = tipoMovimiento;
        this.monto = monto;
        this.concepto = concepto;
    }

    public int[] getFechaMovimiento() {
        return fechaMovimiento;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public double getMonto() {
        return monto;
    }

    public String getConcepto() {
        return concepto;
    }
}
