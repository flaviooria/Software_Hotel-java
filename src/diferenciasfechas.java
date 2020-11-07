import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class diferenciasfechas {
    public static void main(String[] args) throws ParseException {
       /* //con la clase date
        String date1 = "05/11/2020";
        String date2 = "12/11/2020";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date fechaInicial=dateFormat.parse(date1);
        Date fechaFinal=dateFormat.parse(date2);

        int dias=(int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000);

        System.out.println("Hay "+dias+" dias de diferencia");*/


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

        System.out.println(diferenciaFechas);
    }
}
