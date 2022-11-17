public class Sistema {

    private Banco bancoPatito;

    public Sistema(){
        bancoPatito = new Banco();



    }

    public void run(){
        bancoPatito.crearCuenta("miau", "Juan", "Perez", 6000);
        bancoPatito.entrarCuenta(bancoPatito.getCuentas().get(0).getIdCuenta());

        System.out.println("Ingresos: " + bancoPatito.getIngresos());


    }


}
