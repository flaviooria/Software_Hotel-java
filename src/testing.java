

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class testing {
    public static <Exeption extends Throwable> void main(String[] args)  {
        int pago;
        var s = new Scanner(System.in);

       /* //con la clase date
        String date1 = "05/11/2020";
        String date2 = "12/11/2020";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date fechaInicial=dateFormat.parse(date1);
        Date fechaFinal=dateFormat.parse(date2);

        int dias=(int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000);

        System.out.println("Hay "+dias+" dias de diferencia");*/

       /* clase calendar
        var s = new Scanner(System.in);
        int dia = 0, mes = 0, anio = 0;
        int diferenciaFechas = 0;

        System.out.println("Ingresa fecha de salida");
        System.out.print("Ingresa el día ");
        dia = Integer.parseInt(s.nextLine());
        System.out.print("Ingresa el mes ");
        mes = Integer.parseInt(s.nextLine());
        System.out.print("Ingresa el año ");
        anio = Integer.parseInt(s.nextLine());

        Calendar  fechaSalida = new GregorianCalendar();
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


        if(fechaSalida.after(fechaActual)) diferenciaFechas = (int) ((Math.abs(salida - actual)) / (1000 * 60 * 60 * 24));
        else System.out.println("fecha incorrecta");

        System.out.println(diferenciaFechas);*/

       /*// generando numero de habitaciones
        Calendar hoy = new GregorianCalendar();
        int hoydia = hoy.get(Calendar.DAY_OF_MONTH);
        int meshoy = hoy.get(Calendar.MONTH);
        int aniohoy = hoy.get(Calendar.YEAR);

        String today = hoydia + "/" + meshoy + "/" + aniohoy + "_";
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                today += String.valueOf(i) ;
                System.out.printf("numeros pares %h\n",today);
            } else {
                today += String.valueOf(i);
                System.out.printf("numeros impares %h\n",today);
            }
        }*/

       /* boolean mesOk = false, anioOk = false, diaOk = false;
        do {
            try {
                if (!mesOk) {
                    //Introduzca el mes
                    mesOk = true;
                }

                if (!anioOk) {
                    //Introduzca el anio
                    anioOk = true;
                }

                if (!diaOk) {
                    //Introduzca el dia
                    diaOk = true;
                }
            } catch (Exception e) {
                System.out.printf("Parametro introducido incorrecto, por favor introduzca ....");
            }
        }while(!mesOk && !anioOk && !diaOk);*/

        /*//cambio de  billetes y monedas
        System.out.println("Indica el pago");
        pago =  Integer.parseInt(s.nextLine());

        int billetes100,billetes50,billete20,billete10,monedas5,monedas2,monedas1;
        int de100 = 10, de50 = 20, de20 = 20, de10 = 20, de5 = 20, de2= 20, de1= 20;
        int resultado100, resultado50, resultado20, resultado10, resultado5, resultado2, resultado1;


        billetes100 = pago / 100;
        if (billetes100 <= de100) {
            pago = pago - (billetes100 * 100);
            resultado100 = billetes100;
        } else {
            pago = pago - (de100 * 100);
            resultado100 = de100;
        }

        billetes50 = pago / 50;
        if (billetes50 <= de50) {
            pago = pago - (billetes50 * 50);
            resultado50 = billetes50;
        } else {
            pago = pago - (de50 * 50);
            resultado50 = de50;
        }


        billete20 = pago / 20;
        if (billete20 <= de20) {
            pago = pago - (billete20 * 20);
            resultado20 = billete20;
        } else {
            pago = pago - (de20 * 20);
            resultado20 = de20;
        }


        billete10 = pago / 10;
        if (billete10 <= de10) {
            pago = pago - (billete10 * 10);
            resultado10 = billete10;
        } else {
            pago = pago - (de10 * 10);
            resultado10 = de10;
        }

        monedas5 = pago / 5;
        if (monedas5 <= de5){
            pago = pago - (monedas5 * 5);
            resultado5 = monedas5;
        } else {
            pago = pago - (de5 * 5);
            resultado5 = de5;
        }

        monedas2 = pago / 2;
        if (monedas2 <= de2) {
            pago = pago - (monedas2 * 2);
            resultado2 = monedas2;
        } else {
            pago = pago - (de2 * 2);
            resultado2 = de2;
        }

        monedas1 = pago / 1;
        if (monedas1 <= de1) {
            pago = pago - (monedas1 * 1);
            resultado1 = monedas1;
        } else {
            pago = pago - (de1 * 1);
            resultado1 = de1;
        }


            if (billetes100 > 0) System.out.println("Cambio en billetes de 100 es: " +  resultado100);
            if (billetes50 > 0) System.out.println("Cambio en billetes de 50 es: " +  resultado50);
            if (billete20 > 0) System.out.println("Cambio en billetes de 20 es: " +  resultado20);
            if (billete10 > 0) System.out.println("Cambio en billetes de 10 es: " +  resultado10);
            if (monedas5 > 0) System.out.println("Cambio en billetes de 5 es: " +  resultado5);
            if (monedas2 > 0) System.out.println("Cambio en monedas de 2 es: " +  resultado2);
            if (monedas1 > 0) System.out.println("Cambio en monedas de 1 es: " +  resultado1);*/
/*
        String codigoIntroducido = "";

        do {
            System.out.println("Indique su codigo de habitación");
            codigoIntroducido = s.nextLine();
        } while (Integer.parseInt(codigoIntroducido) < 9999 || Integer.parseInt(codigoIntroducido) > 999999 );*/
    }
}
