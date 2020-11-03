
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class hotel_ciudad_martos {
    public static void main(String[] args) throws ParseException {
        //Declarando variables
        var s = new Scanner(System.in);

        String opcion, opcionAdmin, usuario, pass;
        int habitacionesDobles = 8;
        int habitacionesIndividuales = 2;
        int precioDoble = 60;
        int precioindividual = 45;
        int numeroReservas = 0;
        boolean salidaSistema = false;
        int codigoHabitacion = 0;

        //Instanciamos el objeto Calendar
        //en fecha obtenemos la fecha y hora del sistema
        Calendar fecha = new GregorianCalendar();

        //Obtenemos el valor del año, mes, día,
        //hora, minuto y segundo del sistema
        //usando el método get y el parámetro correspondiente
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);

        String hoy = dia + "/" + (mes+1) + "/" + año;

        String fechaReserva = "";
        String fechaSalida = "";

        //Mostramos por pantalla dia/mes/año
        System.out.println(hoy);

        do {
            //Menu de Bienvenida

            System.out.println("******* Hotel Ciudad Martos *******");
            System.out.println("a. Ver el estado de ocupacion de las habitantes");
            System.out.println("b. Reservar una habitación");
            System.out.println("c. Realizar el checkout de una habitación");
            System.out.println("d. Menú de Administrador");
            System.out.println();

            opcion = s.nextLine();

            // Eligiendo opciones.

            // Estado
            if (opcion.equals("a")) {
                System.out.println("\t**Habitaciones disponibles** \n");
                System.out.println(". Habitaciones dobles hay: " + habitacionesDobles);
                System.out.println(". Habitaciones individuales hay: " + habitacionesIndividuales);
                System.out.println();
            }

            // Reservas
            if (opcion.equals("b")) {
                System.out.println("Desea una habitacion doble o individual (1/2)");
                int reserva = Integer.parseInt(s.nextLine());

                if (reserva == 2) {
                    System.out.println("Reserva satisfactoria");
                    habitacionesDobles = habitacionesDobles - 1;
                    numeroReservas++;
                } else {
                    System.out.println("Reserva satisfactoria");
                    habitacionesIndividuales = habitacionesIndividuales - 1;
                    numeroReservas++;
                }

                //GENERAMOS EL NUMERO ALEATORIO
                Random r = new Random();
                int valorDado = r.nextInt(100)+1;  // Entre 0 y 5, más 1.

                codigoHabitacion = Math.abs(((int)fecha.getTimeInMillis())+valorDado);
                System.out.println(codigoHabitacion);

                //GUARDAR LA FECHA AUTOMATICAMENTE fechaReserva
            }

            if (opcion.equals("c")) {
                System.out.println("\t**Realizar el checkout de una habitación** \n");
                System.out.println("Indique la fecha de salida");

                fechaSalida = s.nextLine();
                System.out.println(fechaSalida);

                //COMPROBAR QUE LA FECHA DE SALIDA NO SEA MENOR A LA FECHA DE RESERVA

                //RESTAR LAS FECHAS Y DEVOLVER EL RESULTADO EN DIAS
                //MULTIPLICAR LOS DIAS POR EL COSTE DE LA HABITACION
                //PEDIR NOMBRE COMPLETO DEL CLIENTE
                //PEDIR DINERO Y COMPROBAR LA VUELTA
                //GENERAR FACTURA
            }
            System.out.println();

            // Menu Admin
            if (opcion.equals("d")) {
                int contador = 1;
                boolean logeado = false;

                //Login de Admin
                do {
                    System.out.println("Introduce el usuario");
                    usuario = s.nextLine();

                    System.out.println("Introduce la contraseña");
                    pass = s.nextLine();
                    System.out.println();

                    if (usuario.equals("flavio") && pass.equals("1234")) {
                        logeado = true;
                    } else {

                        System.out.println("Intento número: " + contador + " de 3");
                        System.out.println("Usuario y/o contraseña incorrecta.");
                        contador++;
                    }
                } while ( !logeado && contador < 4);
                System.out.println();

                if (logeado) {

                    System.out.println("******* Menu Administrador *******");
                    System.out.println("i. Consultar los ingresos totales y el número de reservas finalizadas. ");
                    System.out.println("ii. Consultar las monedas restantes para el cambio.");
                    System.out.println("iii. Apagar el software \n");

                    opcionAdmin = s.nextLine();

                    // Ingresos y reseravas totales.
                    if (opcionAdmin.equals("i")) {

//                        System.out.println("El numero de Ingresos totales son: " + ingresosTotales);
                        System.out.println("Número de reservas totales son: " + numeroReservas);
                        System.out.println();
                    }

                    //Consultar cambio
                    if(opcionAdmin.equals("ii")) {

                    }

                    //Apagado del sistema
                    if (opcionAdmin.equals("iii")) {

                        System.out.println("Finalizando Sesión");
                        salidaSistema = true;
                    }
                }
            }
        } while (!salidaSistema && !opcion.equals("x"));
    }
}
