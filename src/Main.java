

public class Main {
    public static void main(String[] args) {

        Movimiento mov = new Movimiento("Retiro", 400, "Para compar una coca");
        int fecha [] = mov.getFechaMovimiento();


        Banco bancoPatito = new Banco();
        Cuenta cuenta ;
        Movimiento movimiento;


        bancoPatito.crearCuenta("PD201819HASRTR07", "Pedro", "Fernandes", 5000 );
        bancoPatito.crearCuenta("JP201819HASRTR06", "Juan ", "Pérez", 6000 );

        cuenta = bancoPatito.getBuscarCuentaRFC("JP201819HASRTR06");

        System.out.println("La cuenta es de:  " + cuenta.getNombre());
        System.out.println("Su saldo inicial es de:  " + cuenta.getSaldo());

        if(cuenta.retirarMonto(500, "Retiro para pagar recibo de luz")){

            System.out.println("Su saldo es de:  " + cuenta.getSaldo());
        }
        else {
            System.out.println("Su saldo es de:  " + cuenta.getSaldo());
        }

        cuenta.depositarMonto(800, "miau");
        System.out.println("Se depositó  ");
        System.out.println("Su saldo es de:  " + cuenta.getSaldo());


        for (int cont = 0; cont < cuenta.getMov().size(); cont ++){
            movimiento = cuenta.getMov().get(cont);

            System.out.println(movimiento.getTipoMovimiento());
            System.out.println("Monto: " + movimiento.getMonto());

        }
        cuenta.historialTransacciones();

        //System.out.printf("Fecha tomada fue: %d/ %d/ %d -- %d:%d  \n", fecha[0], fecha[1], fecha[2], fecha[3], fecha[4]);


    }
}