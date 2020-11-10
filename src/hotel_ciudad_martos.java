
import java.util.*;
import java.util.concurrent.TimeUnit;

public class hotel_ciudad_martos {
    public static void main(String[] args) throws InterruptedException {
        //Declarando variables
        var s = new Scanner(System.in);

        String opcion, opcionAdmin, usuario, pass, nombreCliente, fechaReserva = "";
        int habitacionesDobles = 8, habitacionesIndividuales = 2;
        int precioDoble = 60, precioindividual = 45;
        int numeroReservas = 0, reserva = 0;
        boolean salidaSistema = false;
        int cambio, precioHabitacion, pagoCliente = 0;
        int dia, mes, anio, diferenciaFechas = 0;
        float iva, monto;
        int subTotal, total, ingresoTotal = 0, pago;
        int de100 = 20, de50 = 20, de20 = 20, de10 = 20, de5 = 20, de2 = 20, de1 = 20;
        boolean paseB = false;
        String codigoHabitacion1 = " ",codigoHabitacion2 = " ",codigoHabitacion3,codigoHabitacion4,codigoHabitacion5,codigoHabitacion6,codigoHabitacion7,codigoHabitacion8,codigoHabitacion9,codigoHabitacion10;
        boolean re1 = false, re2= false, re3 = false, re4= false, re5 = false, re6 = false, re7 =  false, re8 = false, re9 = false, re10 = false;

        do {
            //Menu de Bienvenida

            System.out.println("******* Hotel Ciudad Martos *******");
            System.out.println("a. Ver el estado de ocupacion de las habitantes");
            System.out.println("b. Reservar una habitación");
            System.out.println("c. Realizar el checkout de una habitación");
            System.out.println("d. Menú de Administrador");
            System.out.println();

            opcion = s.nextLine();
            System.out.println();

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
                do {
                    System.out.println("Desea una habitacion doble o individual (1/2)");
                    reserva = Integer.parseInt(s.nextLine());
                    if (reserva > 2 || reserva == 0) {
                        Thread.sleep(500);
                        System.out.println("Solo pueden ser habitaciones dobles o individuales");
                    }
                } while (reserva == 0 || reserva > 2);
                System.out.println();

                System.out.print("Comprobando disponibilidad ");
                for (int i = 0; i < 3; i++) {
                    System.out.print(".");
                    TimeUnit.SECONDS.sleep(1);
                }
                System.out.println();

                Calendar fechaHoy = new GregorianCalendar();

                if (reserva == 2) {
                    System.out.println("Reserva satisfactoria");
                    System.out.println();
                    habitacionesDobles -= 1;
                    numeroReservas++;
                    //GENERAMOS UN NUMERO DE HABITACION
                    if (codigoHabitacion2 == " ") {
                        codigoHabitacion2 = String.valueOf(reserva)  + String.valueOf(fechaHoy.get(Calendar.YEAR)) + String.valueOf(fechaHoy.get(Calendar.MONTH)) + String.valueOf(fechaHoy.get(Calendar.DAY_OF_MONTH)) + String.valueOf(fechaHoy.get(Calendar.HOUR)) +  String.valueOf(fechaHoy.get(Calendar.MINUTE))+ String.valueOf(fechaHoy.get(Calendar.SECOND));
                        re1 = true;
                    }
                    System.out.println(codigoHabitacion2);
                } else {
                    System.out.println("Reserva satisfactoria");
                    System.out.println();
                    habitacionesIndividuales -= 1;
                    numeroReservas++;
                    codigoHabitacion1 = String.valueOf(reserva)  + String.valueOf(fechaHoy.get(Calendar.YEAR)) + String.valueOf(fechaHoy.get(Calendar.MONTH)) + String.valueOf(fechaHoy.get(Calendar.DAY_OF_MONTH)) + String.valueOf(fechaHoy.get(Calendar.HOUR)) +  String.valueOf(fechaHoy.get(Calendar.MINUTE))+ String.valueOf(fechaHoy.get(Calendar.SECOND));
                    System.out.println(codigoHabitacion1);
                }

                //GUARDAR LA FECHA AUTOMATICAMENTE fechaReserva
                /* Instanciamos el objeto Calendar
                   Obtenemos el valor del año, mes, día,
                   usando el método get y el parámetro correspondiente*/

                int anioActual = fechaHoy.get(Calendar.YEAR);
                int mesActual = fechaHoy.get(Calendar.MONTH);
                int diaActual = fechaHoy.get(Calendar.DAY_OF_MONTH);

                //Mostramos por pantalla dia/mes/año
                fechaReserva = diaActual + "/" + (mesActual + 1) + "/" + anioActual;
                paseB = true;
            }

            if (opcion.equals("c")) {
                if (paseB) {
                    boolean mesOk = false, diaOk = false;
                    //Realizando el checkout
                    System.out.println("\t**Realizar el checkout de una habitación**");
                    System.out.println("Indique su codigo de habitación");
                    s.nextLine();

                    //comprobando si el numero de reserva es igual a la reserva

                    do {
                        System.out.println("\tIndique la fecha de salida:");
                        System.out.print("Ingresa el día ");
                        dia = Integer.parseInt(s.nextLine());
                        System.out.print("Ingresa el mes ");
                        mes = Integer.parseInt(s.nextLine());
                        System.out.print("Ingresa el año ");
                        anio = Integer.parseInt(s.nextLine());
                        //comprobando si el dia y el mes son correctos.
                        if (dia > 31) {
                            System.out.println("Parametro incorrecto");
                        } else {
                            diaOk = true;
                        }

                        if (mes > 12 || mes == 0 ) {
                            System.out.println("Parametro incorrecto");
                        } else {
                            mesOk = true;
                        }
                    } while (!mesOk  || !diaOk );

                    Calendar fechaSalida = new GregorianCalendar();
                    fechaSalida.set(anio, mes - 1, dia + 1);
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

                    //PEDIR NOMBRE COMPLETO DEL CLIENTEç
                    do {
                        System.out.println("Indique su nombre completo, por favor");
                        nombreCliente = s.nextLine();
                        if (nombreCliente.isEmpty()) {
                            System.out.println("Parametro incorrecto");
                        }
                    } while (nombreCliente.isEmpty());


                    System.out.print("Generando factura ");
                    for (int i = 0; i < 3; i++) {
                        System.out.print(".");
                        TimeUnit.SECONDS.sleep(1);
                    }
                    System.out.println();

                    //GENERAR FACTURA
                    System.out.println("|==================================|");
                    System.out.println("|\t\t\t  Factura              |");
                    System.out.println("|==================================|");
                    System.out.printf("|\tDescripción\t\t %12s  |\n", nombreCliente);
                    System.out.println("|\tConfirmación\t\t\t" + codigoHabitacion1 + "  |");
                    System.out.println("|\tEntrada\t\t\t\t" + fechaReserva + "  |");
                    System.out.println("|\tSalida\t\t\t   " + dia + "/" + mes + "/" + anio + "  |");
                    System.out.printf("|\tPax:\t\t\t %12d  |\n", reserva);
                    System.out.printf("|\tNoches:\t\t\t %12d  |\n", diferenciaFechas);
                    System.out.println("|==================================|");
                    // comprobando si el numero de reserva es doble o individual de ese modo el precio varia
                    if (reserva == 2) {
                        total = precioHabitacion;
                        monto = (float) (precioHabitacion * 0.79);
                        iva = (float) (precioHabitacion * 0.21);
                        subTotal = total;
                        System.out.printf("|\tTarifa:\t\t\t %12d  |\n", precioDoble);
                        System.out.printf("|\tMonto:\t\t\t%13.2f  |\n", monto);
                        System.out.printf("|\tSubtotal:\t\t\t%9d  |\n", subTotal);
                        System.out.printf("|\tIVA:\t\t\t%13.2f  |\n", iva);
                        System.out.printf("|\tTotal:\t\t\t%13d  |\n", total);
                        System.out.println("|==================================|");
                        habitacionesDobles++;
                        ingresoTotal += total;
                    } else {
                        total = precioHabitacion;
                        monto = (float) (precioHabitacion * 0.79);
                        iva = (float) (precioHabitacion * 0.21);
                        subTotal = total;
                        System.out.printf("|\tTarifa:\t\t\t %12d|\n", precioindividual);
                        System.out.printf("|\tMonto:\t\t\t%13.2f|\n", monto);
                        System.out.printf("|\tsubtotal:\t\t\t%9d|\n", subTotal);
                        System.out.printf("|\tIVA:\t\t\t%13.2f|\n", iva);
                        System.out.printf("|\ttotal:\t\t\t%13d|\n", total);
                        System.out.println("|================================|");
                        habitacionesIndividuales++;
                        ingresoTotal += total;
                    }
                    System.out.println();

                    //PEDIR DINERO Y COMPROBAR LA VUELTA
                    do {
                        System.out.println("Ingresa la cantidad con la cual va a pagar: ");
                        pagoCliente = Integer.parseInt(s.nextLine());
                        if (pagoCliente < 0 || String.valueOf(pagoCliente ).isEmpty() )
                            System.out.println("Parametro incorrecto, vuelve a introducir la cantidad");
                    } while (pagoCliente < 0);

                    pago = pagoCliente - precioHabitacion;
                    cambio = pago;

                    int billetes100, billetes50, billete20, billete10, monedas5, monedas2, monedas1;
                    int resultado100, resultado50, resultado20, resultado10, resultado5, resultado2, resultado1;

                    billetes100 = pago / 100;
                    if (billetes100 <= de100) {
                        pago = pago - (billetes100 * 100);
                        resultado100 = billetes100;
                        de100 -= billetes100;
                    } else {
                        pago = pago - (de100 * 100);
                        resultado100 = de100;
                        de100 = 0;
                    }

                    billetes50 = pago / 50;
                    if (billetes50 <= de50) {
                        pago = pago - (billetes50 * 50);
                        resultado50 = billetes50;
                        de50 -= billetes50;
                    } else {
                        pago = pago - (de50 * 50);
                        resultado50 = de50;
                        de50 = 0;
                    }


                    billete20 = pago / 20;
                    if (billete20 <= de20) {
                        pago = pago - (billete20 * 20);
                        resultado20 = billete20;
                        de20 -= billete20;
                    } else {
                        pago = pago - (de20 * 20);
                        resultado20 = de20;
                        de20 = 0;
                    }


                    billete10 = pago / 10;
                    if (billete10 <= de10) {
                        pago = pago - (billete10 * 10);
                        resultado10 = billete10;
                        de10 -= billete10;
                    } else {
                        pago = pago - (de10 * 10);
                        resultado10 = de10;
                        de10 = 0;
                    }

                    monedas5 = pago / 5;
                    if (monedas5 <= de5) {
                        pago = pago - (monedas5 * 5);
                        resultado5 = monedas5;
                        de5 -= monedas5;
                    } else {
                        pago = pago - (de5 * 5);
                        resultado5 = de5;
                        de5 = 0;
                    }

                    monedas2 = pago / 2;
                    if (monedas2 <= de2) {
                        pago = pago - (monedas2 * 2);
                        resultado2 = monedas2;
                        de2 -= monedas2;
                    } else {
                        pago = pago - (de2 * 2);
                        resultado2 = de2;
                        de2 = 0;
                    }

                    monedas1 = pago;
                    if (monedas1 <= de1) {
                        pago = pago - (monedas1);
                        resultado1 = monedas1;
                        de1 -= monedas1;
                    } else {
                        pago = pago - (de1);
                        resultado1 = de1;
                        de1 = 0;
                    }

                    System.out.println("Tu cambio es de: " + cambio);
                    if (billetes100 > 0) System.out.println("Cambio en billetes de 100 es: " + resultado100);
                    if (billetes50 > 0) System.out.println("Cambio en billetes de 50 es: " + resultado50);
                    if (billete20 > 0) System.out.println("Cambio en billetes de 20 es: " + resultado20);
                    if (billete10 > 0) System.out.println("Cambio en billetes de 10 es: " + resultado10);
                    if (monedas5 > 0) System.out.println("Cambio en billetes de 5 es: " + resultado5);
                    if (monedas2 > 0) System.out.println("Cambio en monedas de 2 es: " + resultado2);
                    if (monedas1 > 0) System.out.println("Cambio en monedas de 1 es: " + resultado1);
                    System.out.println("Pulsa una tecla para continuar . . . ");
                    s.nextLine();
                } else {
                    Thread.sleep(1000);
                    System.out.println("Acceso denegado, debe de realizar la opción b");
                }
                System.out.println();
            }

            // Menu Admin
            if (opcion.equals("d")) {
                int contador = 1;
                boolean logeado = false;

                //Login de Admin
                do {
                    System.out.print("Espere un momento\n");
                    Thread.sleep(1500);
                    System.out.println();
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
                    boolean paseAdmi = false;

                    System.out.print("Validando credenciales ");
                    for (int i = 0; i < 3; i++) {
                        System.out.print(".");
                        TimeUnit.SECONDS.sleep(1);
                    }

                    do {
                        // comprobando si la opción es correcta
                        System.out.println();
                        System.out.println();
                        System.out.println("\t\t\t******* Menu Administrador *******");
                        System.out.println("1. Consultar los ingresos totales y el número de reservas finalizadas. ");
                        System.out.println("2. Consultar las monedas restantes para el cambio.");
                        System.out.println("3. Apagar el software \n");
                        System.out.println();

                        opcionAdmin = s.nextLine();

                        if(opcionAdmin.equals("1") || opcionAdmin.equals("2") || opcionAdmin.equals("3")) paseAdmi = true;
                        else System.out.println("Indica las opciones que se encuentran en el menú");
                    } while (!paseAdmi);


                    // Ingresos y reseravas totales.
                    if (opcionAdmin.equals("1")) {
                        System.out.println("El numero de Ingresos totales son: " + ingresoTotal);
                        System.out.println("Número de reservas totales son: " + numeroReservas);
                        System.out.println("Pulsa una tecla para continuar");
                        s.nextLine();
                    }

                    //Consultar cambio
                    if (opcionAdmin.equals("2")) {
                        System.out.print("Comprobando dinero en caja ");
                        for (int i = 0; i < 3; i++) {
                            System.out.print(".");
                            TimeUnit.SECONDS.sleep(1);
                        }
                        System.out.println();

                        System.out.println("Billetes y monedas restantes");
                        System.out.println("Billetes de 100 es: " + de100);
                        System.out.println("Billetes de 50 es: " + de50);
                        System.out.println("Billetes de 20 es: " + de20);
                        System.out.println("Billetes de 10 es: " + de10);
                        System.out.println("Monedas de 5 es: " + de5);
                        System.out.println("Monedas de 2 es: " + de2);
                        System.out.println("Monedas de 1 es: " + de1);
                        System.out.println("Pulsa una tecla para continuar");
                        s.nextLine();
                    }

                    //Apagado del sistema
                    if (opcionAdmin.equals("3")) {
                        System.out.print("Apagando ");
                        for (int i = 0; i < 3; i++) {
                            System.out.print(".");
                            TimeUnit.SECONDS.sleep(1);
                        }
                        salidaSistema = true;
                    }
                }
            }
        } while (!salidaSistema && !opcion.equals("x"));
    }
}
