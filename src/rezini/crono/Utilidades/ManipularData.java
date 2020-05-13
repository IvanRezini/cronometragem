/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rezini.crono.Utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivan rezini
 */
public class ManipularData {

    public static String obterData(String mascara) {

        Date data = new Date();
        if (mascara == null) {
            mascara = "yyyy-MM-dd";
        }
        SimpleDateFormat formatador = new SimpleDateFormat(mascara);
        String dataTxt = formatador.format(data);

        return dataTxt;

    }

    public String validarData(String dateInicial, String dateFinal) {
        String dataAtual = obterData("dd/MM/yyyy");
        GregorianCalendar ini = new GregorianCalendar();
        GregorianCalendar fim = new GregorianCalendar();
        GregorianCalendar atual = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            ini.setTime(sdf.parse(dateInicial));

        } catch (ParseException ex) {
            Logger.getLogger(ManipularData.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            fim.setTime(sdf.parse(dateFinal));
        } catch (ParseException ex) {
            Logger.getLogger(ManipularData.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            atual.setTime(sdf.parse(dataAtual));

        } catch (ParseException ex) {
            Logger.getLogger(ManipularData.class.getName()).log(Level.SEVERE, null, ex);
        }
        long data = atual.getTimeInMillis();
        long dt1 = ini.getTimeInMillis();
        long dt2 = fim.getTimeInMillis();
        System.out.println(data + "     " + dt1 + "             " + dt2);
        int diferencaDatas = (int) ((dt2 - dt1) / (24 * 60 * 60 * 1000));
        String mensagem = "";

        if (dt1 > data || dt2 > data) {
            mensagem = "Corija as datas";
        } else if (diferencaDatas < 0) {
            mensagem = "Data inicial maior que que data final";
        } 
 return mensagem;
    }
}
