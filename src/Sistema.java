import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

    private Banco bancoPatito;
    private Scanner sc;

    public Sistema(){
        bancoPatito = new Banco();
    }

    public void run(){

        boolean seguirPrograma = true;
        int opcion = 0;
        String respuesta = "";
        while (seguirPrograma) {
            opcion = 0;
            while (opcion <= 0 || opcion > 4) {
                sc = new Scanner(System.in);
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("              Bienvenido a Banco Patito.                       ");
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("         Opciones      ");
                System.out.println("1. Crear nueva cuenta.");
                System.out.println("2. Ingresar a una cuenta.");
                System.out.println("3. Ver ingresos y egresos del banco.");
                System.out.println("4. Salir del programa.");
                System.out.print("Seleccione una opción: ");
                try {
                    opcion = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Ocurrió un error. ");
                }

            }

            switch (opcion){
                case 1 :

                    ArrayList <String> info = new ArrayList<>(3);
                    info.add("RFC");
                    info.add("nombres");
                    info.add("apellidos");
                    float saldoInicial;

                    for(int cont = 0; cont < 3; cont ++){
                        System.out.print("Ingrese " + info.get(cont) + ": ");
                        respuesta = entradaDatosStr();
                        info.set(cont,respuesta);

                    }

                    System.out.print("Ingrese el saldo inicial del Cliente: ");
                    saldoInicial = entradaDatosFloat();

                    if(saldoInicial > 0){
                        bancoPatito.crearCuenta(info.get(0),info.get(1),info.get(2),saldoInicial);
                        System.out.println("\nSe ha creado la cuenta exitosamente.");
                    }
                    else {
                        System.out.println("No se pudo crear la cuenta.");
                    }

                    break;

                case 2:
                    long idCuenta = 0;
                    System.out.println("De el ID de la cuenta: ");
                    idCuenta = entradaDatosInt();

                    bancoPatito.entrarCuenta(idCuenta);
                    break;
                case 3:
                    System.out.println("Los ingresos del banco son: " + bancoPatito.getIngresos());
                    System.out.println("Los egresos del banco son: " + bancoPatito.getEgresos());
                    break;
                case 4:
                    seguirPrograma = false;
                    break;
                default:
                    System.out.println("Ninguna opción es válida");
                    break;
            }
            try {
                System.in.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }



        }



    }

    private String entradaDatosStr(){
        sc = new Scanner(System.in);
        String entrada = "";
        try {
            entrada = sc.nextLine();
        }
        catch (Exception e){
            System.out.print("Error de entrada.");
        }

        return entrada;
    }

    private float entradaDatosFloat(){
        sc = new Scanner(System.in);
        float entrada = -1;
        try {
            entrada = sc.nextFloat();
        }
        catch (Exception e){
            System.out.print("Error de entrada.");
        }

        return entrada;
    }

    private int entradaDatosInt(){
        sc = new Scanner(System.in);
        int entrada = -1;
        try {
            entrada = sc.nextInt();
        }
        catch (Exception e){
            System.out.print("Error de entrada.");
        }

        return entrada;
    }

}
