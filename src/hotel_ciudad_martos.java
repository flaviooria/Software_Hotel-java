import java.util.Scanner;

public class hotel_ciudad_martos {
    public static void main(String[] args) {
        //Declarando variables
        var s = new Scanner(System.in);
        String opcionA, opcionB ,opcionC, opcionD;
        int habitacionesDobles = 8;
        int habitacionesIndividuales = 2;
        //tabulador \t
        //Menu de Bienvenida
        System.out.println("******* Hotel Ciudad Martos *******");
        System.out.println("a. Ver el estado de habitaciones");
        System.out.println("b. Reservar una habitación");
        System.out.println("c. Realizar el checkout de una habitación");
        System.out.println("d. Menú de Administrador\n");

        opcionA = s.nextLine();

        if(opcionA.equals("a")) {
            System.out.println("\t**Habitaciones disponibles** \n");
            System.out.println(". Habitaciones dobles hay: " + habitacionesDobles);
            System.out.println(". Habitaciones individuales hay: " + habitacionesIndividuales);
        }

        /*System.out.println("i. Consultar los ingresos totales y el número de reservas finalizadas. ");
        System.out.println("ii. Consultar las monedas restantes para el cambio. \n");
        System.out.println("iii. Apagar el software \n");*/




    }
}
