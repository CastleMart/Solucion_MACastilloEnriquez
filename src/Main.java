

public class Main {
    public static void main(String[] args) {

        Movimiento mov = new Movimiento("Retiro", 400, "Para compar una coca");
        int fecha [] = mov.getFechaMovimiento();



        System.out.printf("Fecha tomada fue: %d/ %d/ %d -- %d:%d  \n", fecha[0], fecha[1], fecha[2], fecha[3], fecha[4]);

        System.out.println("tipoMov: " + mov.getTipoMovimiento());
        System.out.println("Monto:$" + mov.getMonto());
    }
}