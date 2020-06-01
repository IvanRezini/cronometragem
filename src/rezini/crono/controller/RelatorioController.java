/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rezini.crono.controller;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.MaskFormatter;
import rezini.crono.Utilidades.ManipularData;
import rezini.crono.dao.ProdutoDao;
import rezini.crono.dao.RelatorioDao;
import rezini.crono.model.Leitura;
import rezini.crono.model.Operacao;
import rezini.crono.model.Produto;
import rezini.crono.model.TomadaDeTempo;

/**
 *
 * @author ivan rezini
 */
public class RelatorioController {

    public List listaDeProdutos() {
        List<Produto> produtos = null;
        try {
            ProdutoDao lista = new ProdutoDao();
            produtos = lista.listaProdutos();
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;
    }

    public List listaDeProdutosMenu() {
        List<Produto> produtos = null;
        ArrayList menu = new ArrayList();
        produtos = this.listaDeProdutos();
        for (int i = 0; i < produtos.size(); i++) {
            Produto pro = produtos.get(i);
            String composto = pro.getcodProduto() + " - " + pro.getNomeProduto();
            menu.add(composto);
        }
        return menu;
    }

    public List listaDeOperacoes(int cod) {
        List<Operacao> operacoes = null;
        try {
            RelatorioDao lista = new RelatorioDao();
            operacoes = lista.operacaoPorProduto(cod);
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return operacoes;
    }

    public List listaDeOperacoesMenu(int cod) {
        List<Operacao> operacoes = null;
        ArrayList menu = new ArrayList();
        operacoes = this.listaDeOperacoes(cod);
        for (int i = 0; i < operacoes.size(); i++) {
            Operacao op = operacoes.get(i);
            String composto = op.getCodOperacao() + " - " + op.getNomeOperacao();
            menu.add(composto);
        }
        return menu;
    }

    public List listaDeTomadaTempo(int cod) {
        List<TomadaDeTempo> tomadas = null;
        try {
            RelatorioDao lista = new RelatorioDao();
            tomadas = lista.listaTomadaTempos(cod);
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tomadas;
    }

    public List listaDeTomadaTempoMenu(int cod) {
        List<TomadaDeTempo> tomadas = null;
        ArrayList menu = new ArrayList();
        tomadas = this.listaDeTomadaTempo(cod);
        for (int i = 0; i < tomadas.size(); i++) {
            TomadaDeTempo op = tomadas.get(i);
            String composto = op.getCodTomadaTempo() + " - " + op.getDataTomadaTempo();
            menu.add(composto);
        }
        return menu;
    }

    public List relatorioData(String dadaInicial, String dataFinal, int codOperacao) {
        RelatorioDao yy = new RelatorioDao();
        List<TomadaDeTempo> listaTomadas = null;
        try {
            listaTomadas = yy.tomadaTempo(dadaInicial, dataFinal, codOperacao);
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaTomadas;
    }

    public List relatorioTomada(int cod) {
        RelatorioDao yy = new RelatorioDao();
        List<Leitura> leituras = null;
        try {
            leituras = yy.listaTempos(cod);
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return leituras;
    }

    /*
    recebe os parametros para montar o relatorio que sera exibido na tabela
     */
    public List tabela(String dataInicial, String dataFinal, String codOperacao, String codTomadaTempo) throws ParseException {
        List<Object> tabela = new ArrayList<>();
        List<String> linha = new ArrayList<>();
        List<TomadaDeTempo> listaTomada = null;
        List<Leitura> lista = null;
        int seguencia = 0;
        if ("Todas".equals(codTomadaTempo)) {
            ManipularData mani = new ManipularData();
            String dataIn = mani.dataBancoDeDados(dataInicial) + " 00:00:00";//Adicionar a hora inicial do dia O banco quarda a data e hora junto
            String dataFi = mani.dataBancoDeDados(dataFinal) + " 23:59:59";
            String[] code = codOperacao.split("-");
            String cod = code[0].replaceAll("[^0-9]", "");
            int codOpe = Integer.parseInt(cod);
            listaTomada = this.relatorioData(dataIn, dataFi, codOpe);
            for (int i = 0; i < listaTomada.size(); i++) {
                lista = null;
                TomadaDeTempo tt = listaTomada.get(i);
                int codigo = tt.getCodTomadaTempo();
                lista = this.relatorioTomada(codigo);
                for (int idx = 0; idx < lista.size(); idx++) {
                    Leitura p = lista.get(idx);
                    if (seguencia != p.getSequencia()) {
                        if (p.getSequencia() > 1 || tabela.size() > 0) {
                            tabela.add(linha);
                            linha = new ArrayList<>();
                        }
                        linha.add(p.getCodTomada() + "");
                        linha.add(p.getSequencia() + "");
                        seguencia++;
                        if (p.getSequencia() == 1) {
                            seguencia = 1;
                        }
                    }
                    if (seguencia == p.getSequencia()) {
                        linha.add(p.getLeitura());
                    }
                }
            }
            tabela.add(linha);
        } else {
            String cod;
            String[] co = codTomadaTempo.split("-");
            cod = co[0].replaceAll("[^0-9]", "");
            int codigo = Integer.parseInt(cod);
            lista = this.relatorioTomada(codigo);
            linha.clear();
            tabela.clear();
            for (int idx = 0; idx < lista.size(); idx++) {
                Leitura p = lista.get(idx);

                if (seguencia != p.getSequencia()) {
                    if (p.getSequencia() > 1 || tabela.size() > 0) {

                        tabela.add(linha);
                        linha = new ArrayList<>();
                    }
                    linha.add(p.getCodTomada() + "");
                    linha.add(p.getSequencia() + "");
                    seguencia++;
                    if (p.getSequencia() == 1) {
                        seguencia = 1;
                    }
                }
                if (seguencia == p.getSequencia()) {
                    linha.add(p.getLeitura());
                }

            }
            tabela.add(linha);
        }
        tabela.add(this.somarTempos((ArrayList) tabela));//Soma os tempos
        tabela.add(this.contarLeituras((ArrayList) tabela));//conta as leituras
        tabela.add(this.mediaLeituras((ArrayList) tabela));//Media das leituras
        tabela.add(this.somarAoQuadrado((ArrayList) tabela));//Soma das leituras ao Quadrado
        tabela.add(this.minimo((ArrayList) tabela));//Menor leitura
        tabela.add(this.maximo((ArrayList) tabela));//Maior leitura
        tabela.add(this.desvioPadrao((ArrayList) tabela));//Desvio padrao
        return tabela;
    }

    public List somarTempos(ArrayList table) throws ParseException {
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SSS");
        ArrayList<List> tabela;
        tabela = (ArrayList) table;
        List<String> total = new ArrayList<>();
        total.add("");
        total.add("Tempo Total");
        String tempo;
        for (int i = 2; i < tabela.get(0).size(); i++) {
            gc.setTime(sdf.parse("00:00:00:000"));
            for (int p = 0; p < tabela.size(); p++) {
                tempo = (String) tabela.get(p).get(i);
                String[] att = tempo.split(":");
                gc.add(Calendar.HOUR, Integer.parseInt(att[0]));
                gc.add(Calendar.MINUTE, Integer.parseInt(att[1]));
                gc.add(Calendar.SECOND, Integer.parseInt(att[2]));
                gc.add(Calendar.MILLISECOND, Integer.parseInt(att[3]));
            }
            long rr = gc.getTimeInMillis();
            Date d = new Date(rr);
            String temp = sdf.format(d);
            total.add(temp);
        }
        return total;

    }

    public List contarLeituras(ArrayList table) throws ParseException {
        ArrayList<List> tabela;
        tabela = (ArrayList) table;
        List<String> numerLeitura = new ArrayList<>();
        numerLeitura.add("");
        numerLeitura.add("N° Observaçoes:");
        for (int i = 2; i < tabela.get(0).size(); i++) {
            numerLeitura.add((tabela.size() - 1) + "");
        }
        return numerLeitura;
    }

    public List mediaLeituras(ArrayList table) throws ParseException {
        ArrayList<List> tabela;
        tabela = (ArrayList) table;
        List<String> media = new ArrayList<>();
        media.add("");
        media.add("Media:");
        int temp = tabela.size() - 2;
        int leitura = tabela.size() - 1;
        for (int p = 2; p < tabela.get(0).size(); p++) {
            String tempo = (String) tabela.get(temp).get(p);
            int nLeituras = Integer.parseInt((String) tabela.get(leitura).get(p));
            String[] att = tempo.split(":");
            int milesimo = Integer.parseInt(att[3]);
            int segundo = Integer.parseInt(att[2]);
            int minuto = Integer.parseInt(att[1]);
            int hora = Integer.parseInt(att[0]);
            long total = (hora * 60 * 60 * 1000) + (minuto * 60 * 1000) + (segundo * 1000) + milesimo;
            total = total / nLeituras;
            hora = (int) (total / 3600000);
            minuto = (int) (total % 3600000) / 60000;
            segundo = (int) ((total % 3600000) % 60000) / 1000;
            milesimo = (int) ((total % 3600000) % 60000) % 1000;
            String mm = null;
            if (hora == 0) {
                mm = "00:";
            }
            if (hora < 10) {
                mm = "0" + hora + ":";
            }
            if (hora > 9) {
                mm = hora + ":";
            }
            if (minuto < 10) {
                mm += "0" + minuto + ":";
            }
            if (minuto > 9) {
                mm += minuto + ":";
            }
            if (segundo < 10) {
                mm += "0" + segundo + ":";
            }
            if (segundo > 9) {
                mm += segundo + ":";
            }
            if (milesimo < 10) {
                mm += "00" + milesimo;
            }
            if (milesimo < 100 && milesimo > 9) {
                mm += "0" + milesimo;
            }
            if (milesimo > 99) {
                mm += milesimo;
            }
            media.add(mm);
        }
        return media;
    }

    //prolema no tempo ao quadrado
    public List somarAoQuadrado(ArrayList table) throws ParseException {
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SSS");
        ArrayList<List> tabela;
        tabela = (ArrayList) table;
        List<String> totalQ = new ArrayList<>();
        totalQ.add("");
        totalQ.add("Tempo T²");
        String tempo;
        for (int i = 2; i < tabela.get(0).size(); i++) {
            gc.setTime(sdf.parse("00:00:00:000"));
            String mm = null;
            int leituras = tabela.size() - 3;
            int milesimo;
            int segundo;
            int minuto;
            int hora;
            long soma = 0;
            for (int p = 0; p < leituras; p++) {
                tempo = (String) tabela.get(p).get(i);
                String[] att = tempo.split(":");
                milesimo = Integer.parseInt(att[3]);
                segundo = Integer.parseInt(att[2]);
                minuto = Integer.parseInt(att[1]);
                hora = Integer.parseInt(att[0]);
                // System.out.println("Hora: " + hora + " minuto " + minuto + "  segundo  " + segundo + " mil  " + milesimo);
                long total = (hora * 60 * 60 * 1000) + (minuto * 60 * 1000) + (segundo * 1000) + milesimo;
                // System.out.println("Soma: " + soma + "   Total: " + total + "    contador:  " + p);
                soma = soma + (total * total);

            }
            hora = (int) (soma / 3600000);
            minuto = (int) (soma % 3600000) / 60000;
            segundo = (int) ((soma % 3600000) % 60000) / 1000;
            milesimo = (int) ((soma % 3600000) % 60000) % 1000;
            if (hora == 0) {
                mm = "00:";
            }
            if (hora < 10) {
                mm = "0" + hora + ":";
            }
            if (hora > 9) {
                mm = hora + ":";
            }
            if (minuto < 10) {
                mm += "0" + minuto + ":";
            }
            if (minuto > 9) {
                mm += minuto + ":";
            }
            if (segundo < 10) {
                mm += "0" + segundo + ":";
            }
            if (segundo > 9) {
                mm += segundo + ":";
            }
            if (milesimo < 10) {
                mm += "00" + milesimo;
            }
            if (milesimo < 100 && milesimo > 9) {
                mm += "0" + milesimo;
            }
            if (milesimo > 99) {
                mm += milesimo;
            }
            totalQ.add(mm);
        }
        return totalQ;
    }

    public List minimo(ArrayList table) throws ParseException {
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SSS");
        ArrayList<List> tabela;
        tabela = (ArrayList) table;
        List<String> total = new ArrayList<>();
        total.add("");
        total.add("Mínimo: ");
        String tempo;
        for (int i = 2; i < tabela.get(0).size(); i++) {
            String minimo = null;
            long com = 0;
            int leituras = tabela.size() - 4;
            for (int p = 0; p < leituras; p++) {
                gc.setTime(sdf.parse("00:00:00:000"));
                tempo = (String) tabela.get(p).get(i);
                String[] att = tempo.split(":");
                gc.add(Calendar.HOUR, Integer.parseInt(att[0]));
                gc.add(Calendar.MINUTE, Integer.parseInt(att[1]));
                gc.add(Calendar.SECOND, Integer.parseInt(att[2]));
                gc.add(Calendar.MILLISECOND, Integer.parseInt(att[3]));
                long rr = gc.getTimeInMillis();
                if (com > rr || com == 0) {
                    com = rr;
                    minimo = tempo;
                }
            }
            total.add(minimo);
        }
        return total;
    }

    public List maximo(ArrayList table) throws ParseException {
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SSS");
        ArrayList<List> tabela;
        tabela = (ArrayList) table;
        List<String> total = new ArrayList<>();
        total.add("");
        total.add("Máximo");
        String tempo;
        for (int i = 2; i < tabela.get(0).size(); i++) {
            String maximo = null;
            long com = 0;
            int leituras = tabela.size() - 5;
            for (int p = 0; p < leituras; p++) {
                gc.setTime(sdf.parse("00:00:00:000"));
                tempo = (String) tabela.get(p).get(i);
                String[] att = tempo.split(":");
                gc.add(Calendar.HOUR, Integer.parseInt(att[0]));
                gc.add(Calendar.MINUTE, Integer.parseInt(att[1]));
                gc.add(Calendar.SECOND, Integer.parseInt(att[2]));
                gc.add(Calendar.MILLISECOND, Integer.parseInt(att[3]));
                long rr = gc.getTimeInMillis();
                if (com < rr || com == 0) {
                    com = rr;
                    maximo = tempo;
                }
            }
            total.add(maximo);
        }
        return total;
    }

    public List desvioPadrao(ArrayList table) throws ParseException {
        ArrayList<List> tabela;
        tabela = (ArrayList) table;
        List<String> desvio = new ArrayList<>();
        desvio.add("");
        desvio.add("Desvio padrao:");
        int leituras = tabela.size() - 6;
        int med = tabela.size() - 4;//linha da media
        int nLei = tabela.size() - 5;//numero de leituras
        for (int i = 2; i < tabela.get(0).size(); i++) {
            float result = 0000;
            int milesimo;
            int segundo;
            int minuto;
            int hora;
            long nLeituras = Long.parseLong((String) tabela.get(nLei).get(i));
            String media = (String) tabela.get(med).get(i);
            String[] attM = media.split(":");
            milesimo = Integer.parseInt(attM[3]);
            segundo = Integer.parseInt(attM[2]);
            minuto = Integer.parseInt(attM[1]);
            hora = Integer.parseInt(attM[0]);
            long totalM = (hora * 60 * 60 * 1000) + (minuto * 60 * 1000) + (segundo * 1000) + milesimo;
            for (int p = 0; p < leituras; p++) {
                String tempo = (String) tabela.get(p).get(i);
                String[] att = tempo.split(":");
                milesimo = Integer.parseInt(att[3]);
                segundo = Integer.parseInt(att[2]);
                minuto = Integer.parseInt(att[1]);
                hora = Integer.parseInt(att[0]);
                long total = (hora * 60 * 60 * 1000) + (minuto * 60 * 1000) + (segundo * 1000) + milesimo;
                result += Math.pow((total - totalM), 2);
            }
            result = (float) Math.sqrt(result / nLeituras);
            DecimalFormat df = new DecimalFormat("0.000");
            String mm = df.format(result) + "";
            desvio.add(mm);
        }
        return desvio;
    }

}
//https://www.proenem.com.br/enem/fisica/estatistica-desvio-medio-desvio-padrao-e-variancia/
