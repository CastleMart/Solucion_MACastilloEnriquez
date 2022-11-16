public class Movimiento {
    //Atributos de la clase Movimiento.
    private  int fechaMovimiento;
    private String tipoMovimiento;
    private double monto;
    private String concepto;

    
    public Movimiento(String tipoMovimiento, double monto, String concepto){


        this.tipoMovimiento = tipoMovimiento;
        this.monto = monto;
        this.concepto = concepto;
    }
}
