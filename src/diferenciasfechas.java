

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class diferenciasfechas {
    public static void main(String[] args)  {
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

        /*generando numero de habitaciones
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

        System.out.println("Indica el pago");
        pago =  Integer.parseInt(s.nextLine());

        int billetes100,billetes50,billete20,billete10,monedas5,monedas1;

        billetes100 = pago / 100;
        pago = pago - (billetes100 * 100);

        billetes50 = pago / 50;
        pago = pago - (billetes50 * 50);

        billete20 = pago / 20;
        pago = pago - (billete20 * 20);

        billete10 = pago / 10;
        pago = pago - (billete10 * 10);

        monedas5 = pago / 5;
        pago = pago - (monedas5 * 5);

        monedas1 = pago / 1;
        pago = pago - (monedas1 * 1);

            if (billetes100 > 0) System.out.println("Cambio en billetes de 100 es: " +  billetes100);
            if (billetes50 > 0) System.out.println("Cambio en billetes de 50 es: " +  billetes50);
            if (billete20 > 0) System.out.println("Cambio en billetes de 20 es: " +  billete20);
            if (billete10 > 0) System.out.println("Cambio en billetes de 10 es: " +  billete10);
            if (monedas5 > 0) System.out.println("Cambio en billetes de 5 es: " +  monedas5);
            if (monedas1 > 0) System.out.println("Cambio en billetes de 1 es: " +  monedas1);

    }
}
