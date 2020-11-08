
import java.util.*;
import static java.lang.Integer.parseInt;

public class hotel_ciudad_martos {
    public static void main(String[] args) {
        //Declarando variables
        var s = new Scanner(System.in);

        String opcion, opcionAdmin, usuario, pass,nombreCliente,fechaReserva = "";
        int habitacionesDobles = 8, habitacionesIndividuales = 2;
        int precioDoble = 60, precioindividual = 45;
        int numeroReservas = 0, reserva = 0;
        boolean salidaSistema = false;
        int codigoHabitacion = 0;
        int pagoTotal,precioHabitacion, pagoCliente;
        int dia, mes, anio, diferenciaFechas = 0;
        int total = 0;

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
                reserva = Integer.parseInt(s.nextLine());

                if (reserva == 2) {
                    System.out.println("Reserva satisfactoria");
                    habitacionesDobles -= 1;
                    numeroReservas++;
                } else {
                    System.out.println("Reserva satisfactoria");
                    habitacionesIndividuales -= 1;
                    numeroReservas++;
                }

                //GUARDAR LA FECHA AUTOMATICAMENTE fechaReserva
                /* Instanciamos el objeto Calendar
                   Obtenemos el valor del año, mes, día,
                   usando el método get y el parámetro correspondiente*/

                Calendar fechaHoy = new GregorianCalendar();
                int anioActual = fechaHoy.get(Calendar.YEAR);
                int mesActual = fechaHoy.get(Calendar.MONTH);
                int diaActual = fechaHoy.get(Calendar.DAY_OF_MONTH);

                String hoy = diaActual + "/" + (mesActual + 1) + "/" + anioActual;
                //Mostramos por pantalla dia/mes/año
                fechaReserva = hoy;

                //GENERAMOS UN NUMERO DE HABITACION

            }

            if (opcion.equals("c")) {

                //Realizando el checkout
                System.out.println("\t**Realizar el checkout de una habitación**");
                System.out.println("\tIndique la fecha de salida:");
                System.out.print("Ingresa el día ");
                dia = Integer.parseInt(s.nextLine());
                System.out.print("Ingresa el mes ");
                mes = Integer.parseInt(s.nextLine());
                System.out.print("Ingresa el año ");
                anio = Integer.parseInt(s.nextLine());

                Calendar fechaSalida = new GregorianCalendar();
                fechaSalida.set(anio, mes - 1, dia);
                fechaSalida.set(Calendar.HOUR, 0);
                fechaSalida.set(Calendar.HOUR_OF_DAY, 0);
                fechaSalida.set(Calendar.MINUTE, 0);
                fechaSalida.set(Calendar.SECOND, 0);

                Calendar fechaActual = new GregorianCalendar();
                fechaActual.set(Calendar.HOUR, 0);
                fechaActual.set(Calendar.HOUR_OF_DAY, 0);
                fechaActual.set(Calendar.MINUTE, 0);
                fechaActual.set(Calendar.SECOND, 0);

                long actual = fechaActual.getTimeInMillis();
                long salida = fechaSalida.getTimeInMillis();

                //COMPROBAR QUE LA FECHA DE SALIDA NO SEA MENOR A LA FECHA DE RESERVA
                if (fechaSalida.after(fechaActual)) {
                    //RESTAR LAS FECHAS Y DEVOLVER EL RESULTADO EN DIAS
                    diferenciaFechas = (int) ((Math.abs(salida - actual)) / (1000 * 60 * 60 * 24));
                    System.out.println(diferenciaFechas);
                } else {
                    System.out.println("Fecha incorrecta");
                }

                //MULTIPLICAR LOS DIAS POR EL COSTE DE LA HABITACION
                precioHabitacion = ((reserva == 2) ? precioDoble * diferenciaFechas : precioindividual * diferenciaFechas);
                System.out.println(precioHabitacion);
                //PEDIR NOMBRE COMPLETO DEL CLIENTE
                System.out.println("Indique su nombre completo, por favor");
                nombreCliente = s.nextLine();
                //PEDIR DINERO Y COMPROBAR LA VUELTA

                //GENERAR FACTURA
                System.out.println("|================================|");
                System.out.println("|\t\t\tFactura              |");
                System.out.println("|================================|");
                System.out.printf("|\tDescripción\t\t %12s|\n",nombreCliente);
                System.out.println("|\tConfirmación\t\t\t");
                System.out.println("|\tEntrada\t\t\t\t" + fechaReserva + "|");
                System.out.println("|\tSalida\t\t\t   " + dia + "/" + mes + "/" + anio + "|");
                System.out.printf("|\tPax:\t\t\t %12d|\n",reserva);
                System.out.printf("|\tNoches:\t\t\t %12d|\n",diferenciaFechas);
                System.out.println("|================================|");
                // comprobando si el numero de reserva es doble o individual de ese modo el precio varia
                if (reserva == 2) {
                    total = (int) ( precioHabitacion  * 0.79);
                    System.out.printf("|\tTarifa:\t\t\t %12d|\n", precioDoble);
                    System.out.printf("|\tMonto:\t\t\t%13d|\n",total);
                    System.out.printf("|\tsubtotal:\t\t\t%9d|\n",total);
                    System.out.printf("|\tIVA:\t\t\t%13d|\n",total);
                    System.out.printf("|\ttotal:\t\t\t%13d|\n",total);
                    System.out.println("|================================|");
                } else {
                    total = (int) ( precioHabitacion  * 0.79);
                    System.out.printf("|\tTarifa:\t\t\t %12d|\n", precioindividual);
                    System.out.printf("|\tMonto:\t\t\t%13d|\n",total);
                    System.out.printf("|\tsubtotal:\t\t\t%9d|\n",total);
                    System.out.printf("|\tIVA:\t\t\t%13d|\n",total);
                    System.out.printf("|\ttotal:\t\t\t%13d|\n",total);
                    System.out.println("|================================|");
                }
                System.out.println("Pulsa una tecla para continuar . . . ");
                s.nextLine();

            }

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
                    } while (!logeado && contador < 4);
                    System.out.println();

                    if (logeado) {

                        System.out.println("******* Menu Administrador *******");
                        System.out.println("1. Consultar los ingresos totales y el número de reservas finalizadas. ");
                        System.out.println("2. Consultar las monedas restantes para el cambio.");
                        System.out.println("3. Apagar el software \n");

                        opcionAdmin = s.nextLine();

                        // Ingresos y reseravas totales.
                        if (opcionAdmin.equals("1")) {

//                        System.out.println("El numero de Ingresos totales son: " + ingresosTotales);
                            System.out.println("Número de reservas totales son: " + numeroReservas);
                            System.out.println();
                        }

                        //Consultar cambio
                        if (opcionAdmin.equals("2")) {

                        }

                        //Apagado del sistema
                        if (opcionAdmin.equals("3")) {

                            System.out.println("Finalizando Sesión");
                            salidaSistema = true;
                        }
                    }
                }
        } while (!salidaSistema && !opcion.equals("x")) ;
    }
}
