

public class Main {
    public static void main(String[] args) {

        Movimiento mov = new Movimiento("Retiro", 400, "Para compar una coca");
        int fecha [] = mov.getFechaMovimiento();



        System.out.printf("Fecha tomada fue: %d/ %d/ %d", fecha[0], fecha[1], fecha[2]);

        System.out.println("tipoMov: " + mov.getTipoMovimiento());
        System.out.println("Monto:$" + mov.getMonto());
    }
}