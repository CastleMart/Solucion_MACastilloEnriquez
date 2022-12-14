import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Banco {
    private ArrayList<Cuenta> cuentas;
    private Seguro seguro;
    private double ingresos;
    private double egresos;
    private Cuenta sesion;

    /**
     * Constructor de la Clase Banco.
     */
    public Banco() {
        seguro = new Seguro();
        cuentas = new ArrayList<>();
        ingresos = 0;
        egresos = 0;

    }

    /**
     * Método que crear las cuentas de los usuarios del banco.
     * @param rfc
     * @param nombre
     * @param apellidos
     * @param saldoInicial
     * @param password
     */
    public void crearCuenta(String rfc, String nombre, String apellidos, float saldoInicial, int password) {

        Cuenta cuenta = new Cuenta(rfc, nombre, apellidos, saldoInicial, password);


        cuenta.generarIdCuenta();
        for (int cont = 0; cont < this.cuentas.size(); cont++) {
            if (cuenta.getIdCuenta() == this.cuentas.get(cont).getIdCuenta()) {
                cuenta.generarIdCuenta();
                cont = 0;
            }
        }

        this.cuentas.add(cuenta);
        this.ingresos += saldoInicial;
        System.out.println("Se ha agregado la cuenta con éxito");
        System.out.println("La id de la cuenta es: " + cuenta.getIdCuenta());
    }

    /**
     * Busca por medio de la Id una cuenta.
     *
     * @param idCuenta
     * @return cuenta o nulo
     */
    public Cuenta getBuscarCuentaID(long idCuenta) {


        for (int cont = 0; cont < this.cuentas.size(); cont++) {
            if (idCuenta == this.cuentas.get(cont).getIdCuenta()) {

                return this.cuentas.get(cont);
            }
        }

        return null;

    }

    /**
     * Busca por medio del apellido una cuenta
     *
     * @param apellidos
     * @return lista de posibles cuentas
     */
    public ArrayList<Cuenta> getBuscarCuentaApellido(String apellidos) {

        ArrayList<Cuenta> busCuentas = new ArrayList<>();

        for (int cont = 0; cont < this.cuentas.size(); cont++) {
            if (apellidos == this.cuentas.get(cont).getApellidos()) {

                busCuentas.add(this.cuentas.get(cont));
            }
        }

        return busCuentas;
    }

    /**
     * Busca por medio del RFC del usuario de la cuenta.
     *
     * @param rfc
     * @return cuenta o nulo
     */
    public Cuenta getBuscarCuentaRFC(String rfc) {


        for (int cont = 0; cont < this.cuentas.size(); cont++) {
            if (rfc == this.cuentas.get(cont).getRFC()) {

                return this.cuentas.get(cont);
            }
        }

        return null;

    }

    /**
     * Se regresa los ingresos del banco.
     * @return ingresos
     */
    public double getIngresos(){
        return this.ingresos;
    }

    /**
     * Se regresa los egresos del banco.
      * @return egresos
     */
    public double getEgresos() {
        return egresos;
    }



    /**
     * Método para iniciar sesión en una cuenta.
     *
     * @param idCuenta
     * @param password
     * @return true o false
     */
    public boolean entrarCuenta(long idCuenta, int password) {
        Scanner sc = new Scanner(System.in);
        String opcion = "";
        this.sesion = getBuscarCuentaID(idCuenta);

        if (sesion == null) {
            System.out.println("No se ha encontrado la cuenta.");
            return false;
        } else if (this.sesion.verificarPassword(password)) {
            opciones();
        }
        else {
            System.out.println("Contraseña incorrecta.");
        }






        return true;
    }

    /**
     * Guarda  la sesión en el arreglo de las cuentas del banco.
     */
    private void guardarDatos() {

        for (int cont = 0; cont < this.cuentas.size(); cont++) {
            if (sesion.getIdCuenta() == this.cuentas.get(cont).getIdCuenta()) {

                cuentas.set(cont, sesion);
                cont = this.cuentas.size();
            }
        }

        System.out.print("Se ha guardado la información.");


    }

    /**
     * Realiza todo lo referente a la sesión y las opciones que posee.
     */
    private void opciones() {

        Scanner sc = new Scanner(System.in);
        int opcion;
        int monto;
        String concepto = "";
        boolean estado;
        boolean salir = false;

        do {
            opcion = 0;
            while (opcion <= 0 || opcion > 6) {
                sc = new Scanner(System.in);
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("La cuenta ingresada es de: " + sesion.getNombre() +" " + sesion.getApellidos());
                System.out.println("--------------------------------------------------------------------------------");

                System.out.println("                Menú                      ");
                System.out.println("1. Mostrar Saldo.");
                System.out.println("2. Deposiar a cuenta.");
                System.out.println("3. Retirar a cuenta.");
                System.out.println("4. Historial de transacciones");
                System.out.println("5. Ver ofertas de seguros.");
                System.out.println("6. Salir de la sesión.\n");
                System.out.print("Seleccione un número: ");
                try {
                    opcion = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Ocurrió un error. ");
                }
            }

            concepto = "";

            salir = true;

            switch (opcion) {


                case 1:
                    System.out.println("Saldo: " + sesion.getSaldo());
                    break;

                case 2:
                    monto = 1;

                    //concepto = "";


                    System.out.print("Monto a depositar: ");

                    try {
                        monto = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error.");
                    }

                    System.out.print("Concepto: ");
                    sc = new Scanner(System.in);

                    try {
                        concepto = sc.next();
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error.");
                    }

                    estado = sesion.depositarMonto(monto, concepto);
                    if (estado) {
                        guardarDatos();
                        this.ingresos += monto;
                    }

                    break;
                case 3:
                    monto = 0;
                    concepto = "";

                    System.out.print("Monto a retirar: ");

                    try {
                        monto = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error.");
                    }

                    System.out.print("Concepto: ");
                    sc = new Scanner(System.in);
                    try {
                        concepto = sc.nextLine();
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error.");
                    }

                    estado = sesion.retirarMonto(monto, concepto);
                    if (estado) {
                        guardarDatos();
                        this.egresos += monto;
                    }

                    break;

                case 4:
                    sesion.historialTransacciones();
                    break;
                case 5:
                    this.seguro.mostrarSeguros();
                    break;

                case 6:
                    sesion = null;
                    salir = false;
                    System.out.println("Se ha salido de la sesión.");
                    break;

                default:
                    System.out.println("No se agregó una opción válida.");
                    break;
            }
            try {
                System.in.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }while (salir) ;

    }

    /**
     * Método que muestra una lista de las cuentas creadas.
     */
    public void mostrarCuentasCreadas() {

        int id;
        String nombre, apellido;
        //System.out.println("       id         Nombre        Apellido");
        for (int cont = 0; cont < this.cuentas.size(); cont ++){
            id = (int) this.cuentas.get(cont).getIdCuenta();
            nombre = this.cuentas.get(cont).getNombre();
            apellido = this.cuentas.get(cont).getApellidos();

            System.out.printf("id:%d -  Nombres: %s  -  Apellidos: %s\n", id, nombre, apellido);
        }
    }
}


