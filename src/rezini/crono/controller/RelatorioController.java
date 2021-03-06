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
import rezini.crono.model.Elementos;
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
    public List tabela(String dataInicial, String dataFinal, String codOperacao, String codTomadaTempo) throws ParseException, SQLException {
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
        tabela.add(this.intervaloConfianca((ArrayList) tabela));//Intervalo de confiança de 95%
        tabela.add(this.totalQuadrado((ArrayList) tabela));//total ao quadrado
        tabela.add(this.diferencaDosQuadrados((ArrayList) tabela));//diferença dos total ao quadrado
        tabela.add(this.raizDaDiferenca((ArrayList) tabela));//raiz quadrada da diferença
        tabela.add(this.raizVezDez((ArrayList) tabela));//raiz vezes dez
        tabela.add(this.raizVezDezDivididoTotal((ArrayList) tabela)); //raizVezDezDivididoTotal
        tabela.add(this.nObsNes((ArrayList) tabela));//numero de observaçoes nessesarias
        tabela.add(this.ritmo((ArrayList) tabela));//ritmo do elemento
        tabela.add(this.tempoNormal((ArrayList) tabela));//Tempo normal
        tabela.add(this.quVezes((ArrayList) tabela));//Automatico em uma vez
        tabela.add(this.porPc((ArrayList) tabela));//quantas eses na mesma peça
        tabela.add(this.tempoAjustado((ArrayList) tabela));//Tempo ajustado
        tabela.add(this.interferencia((ArrayList) tabela));//Interferencia
        tabela.add(this.tempoBase((ArrayList) tabela));//Tempo base
        tabela.add(this.concessoes((ArrayList) tabela));//concessoes
        tabela.add(this.tempoPadrao((ArrayList) tabela));//Tempo padrao 
        tabela.add(this.tempoPadraoOperacaoMi((ArrayList) tabela));//Tempo padrao da operação 
        tabela.add(this.tempoPadraoOperacaoNor((ArrayList) tabela));//Tempo padrão de operação em horas
        tabela.add(this.producaoHora((ArrayList) tabela));//produção por hora
        tabela.add(this.producaoDia((ArrayList) tabela));//produçã por dia 8 Horas
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
        media.add("Minutos centecimal");
        media.add("Media:");
        int temp = tabela.size() - 2;
        int leitura = tabela.size() - 1;
        for (int p = 2; p < tabela.get(0).size(); p++) {
            String tempo = (String) tabela.get(temp).get(p);
            int nLeituras = Integer.parseInt((String) tabela.get(leitura).get(p));
            double total = this.converterEmMinutoCentecimal(tempo);
            total = total / nLeituras;
            media.add("" + total);
        }
        return media;
    }

    public List somarAoQuadrado(ArrayList table) throws ParseException {
        ArrayList<List> tabela;
        tabela = (ArrayList) table;
        List<String> totalQ = new ArrayList<>();
        totalQ.add("Minutos centecimal");
        totalQ.add("Tempo T² somados:");
        String tempo;
        for (int i = 2; i < tabela.get(0).size(); i++) {
            int leituras = tabela.size() - 3;
            double soma = 0;
            for (int p = 0; p < leituras; p++) {
                tempo = (String) tabela.get(p).get(i);
                double total = this.converterEmMinutoCentecimal(tempo);
                soma = soma + (total * total);
            }
            totalQ.add("" + soma);
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
            double result = 0;

            int nLeituras = Integer.parseInt((String) tabela.get(nLei).get(i));
            String media = (String) tabela.get(med).get(i);
            double totalM = Double.parseDouble(media);
            for (int p = 0; p < leituras; p++) {
                String tempo = (String) tabela.get(p).get(i);
                double total = this.converterEmMinutoCentecimal(tempo);
                result += Math.pow((total - totalM), 2);
            }
            result = (double) Math.sqrt(result / nLeituras);
            DecimalFormat df = new DecimalFormat("0.0000");
            String mm = df.format(result) + "";
            desvio.add(mm);
        }
        return desvio;
    }

    public List intervaloConfianca(ArrayList table) throws ParseException {
        ArrayList<List> tabela;
        tabela = (ArrayList) table;
        List<String> total = new ArrayList<>();
        total.add("");
        total.add("Int. conf. ±");
        float nivelCofianca = (float) 1.96;// indice de confiança de 95% ja convertido
        int desvio = tabela.size() - 1;//linha do desvio padrao
        int nLei = tabela.size() - 6;//linha do numero de leituras
        for (int i = 2; i < tabela.get(0).size(); i++) {
            String des = (String) tabela.get(desvio).get(i);
            String[] attM = des.split(",");
            des = attM[0] + "." + attM[1];
            double desvioPadrao = Double.valueOf(des);
            int leituras = Integer.parseInt((String) tabela.get(nLei).get(i));
            DecimalFormat df = new DecimalFormat("0.0000");
            String mm = df.format((nivelCofianca * (desvioPadrao / (Math.sqrt(leituras)))));
            total.add(mm);
        }
        return total;
    }

    public List totalQuadrado(ArrayList table) throws ParseException {
        ArrayList<List> tabela;
        tabela = (ArrayList) table;
        List<String> total = new ArrayList<>();
        total.add("Minuto centecimal.");
        total.add("Total ao quadrado:");
        int tota = tabela.size() - 8;//linha do soma das medidas
        for (int i = 2; i < tabela.get(0).size(); i++) {
            String tempo = (String) tabela.get(tota).get(i);

            double tot = this.converterEmMinutoCentecimal(tempo);
            tot = Math.pow(tot, 2);
            total.add("" + tot);
        }
        return total;
    }

    public List diferencaDosQuadrados(ArrayList table) throws ParseException {
        ArrayList<List> tabela;
        tabela = (ArrayList) table;
        List<String> total = new ArrayList<>();
        total.add("");
        total.add("S² x A - T²:");
        int medidas = tabela.size() - 8;//linha do numero de medidas
        int somaQua = tabela.size() - 6;//linha da soma das medidas ao quadrado
        int totalQua = tabela.size() - 1;//linha do total ao quadrado

        for (int i = 2; i < tabela.get(0).size(); i++) {
            int medi = Integer.parseInt((String) tabela.get(medidas).get(i));
            String somaQ = (String) tabela.get(somaQua).get(i);
            String totalQ = (String) tabela.get(totalQua).get(i);
            double somaQu = Double.parseDouble(somaQ);
            double totalQu = Double.parseDouble(totalQ);
            double tot = (somaQu * medi) - totalQu;
            total.add("" + tot);
        }
        return total;
    }

    public List raizDaDiferenca(ArrayList table) throws ParseException {
        ArrayList<List> tabela;
        tabela = (ArrayList) table;
        List<String> total = new ArrayList<>();
        total.add("");
        total.add("Raiz diferença:");
        int linhaDif = tabela.size() - 1;//linha da diferença

        for (int i = 2; i < tabela.get(0).size(); i++) {
            double medi = Double.parseDouble((String) tabela.get(linhaDif).get(i));

            double tot = Math.sqrt(medi);
            total.add("" + tot);
        }
        return total;
    }

    public List raizVezDez(ArrayList table) throws ParseException {
        ArrayList<List> tabela;
        tabela = (ArrayList) table;
        List<String> total = new ArrayList<>();
        total.add("");
        total.add("Raiz veses 10:");
        int linhaRaiz = tabela.size() - 1;//linha da diferença

        for (int i = 2; i < tabela.get(0).size(); i++) {
            double medi = Double.parseDouble((String) tabela.get(linhaRaiz).get(i));

            double tot = medi * 10;
            total.add("" + tot);
        }
        return total;
    }

    public List raizVezDezDivididoTotal(ArrayList table) throws ParseException {
        ArrayList<List> tabela;
        tabela = (ArrayList) table;
        List<String> total = new ArrayList<>();
        total.add("");
        total.add("Raiz veses 10/total:");
        int linhaRaiz = tabela.size() - 1;//linha da diferença
        int linhaTotal = tabela.size() - 12;
        for (int i = 2; i < tabela.get(0).size(); i++) {
            double medi = Double.parseDouble((String) tabela.get(linhaRaiz).get(i));
            String soma = (String) tabela.get(linhaTotal).get(i);
            double miles = this.converterEmMinutoCentecimal(soma);
            double tot = medi / miles;
            total.add("" + tot);
        }
        return total;
    }

    public List nObsNes(ArrayList table) throws ParseException {
        ArrayList<List> tabela;
        tabela = (ArrayList) table;
        List<String> total = new ArrayList<>();
        total.add("");
        total.add("n° obs. nes. :");
        int linhaRaiz = tabela.size() - 1;//

        for (int i = 2; i < tabela.get(0).size(); i++) {
            double medi = Double.parseDouble((String) tabela.get(linhaRaiz).get(i));

            int tot = (int) Math.pow(medi, 2);
            if (tot == 0) {
                tot = 1;
            }
            total.add("" + tot);
        }
        return total;
    }

    public List ritmo(ArrayList table) throws ParseException, SQLException {
        RelatorioDao relatorio = new RelatorioDao();
        List<Elementos> elementos;
        ArrayList<List> tabela;
        tabela = (ArrayList) table;
        List<String> total = new ArrayList<>();
        total.add("");
        total.add("Ritmo %:");
        int codTomadaTempo = Integer.parseInt((String) tabela.get(0).get(0));
        elementos = relatorio.atributosElementos(codTomadaTempo);
        for (int i = 2; i < tabela.get(0).size(); i++) {
            Elementos ele = elementos.get(i - 2);
            total.add("" + ele.getRitmoElemento());
        }
        return total;
    }

    public List tempoNormal(ArrayList table) throws ParseException {
        ArrayList<List> tabela;
        tabela = (ArrayList) table;
        List<String> total = new ArrayList<>();
        total.add("Minutos centecimal.");
        total.add("Tempo Normal:");
        int linhaRitimo = tabela.size() - 1;//
        int linhaTempoTotal = tabela.size() - 15;//
        for (int i = 2; i < tabela.get(0).size(); i++) {
            double ritimo = Double.parseDouble((String) tabela.get(linhaRitimo).get(i));
            double tempoTotal = this.converterEmMinutoCentecimal((String) tabela.get(linhaTempoTotal).get(i));
            double tot = (tempoTotal / ritimo) * 100;
            total.add("" + tot);
        }
        return total;
    }

    public List quVezes(ArrayList table) throws ParseException {
        ArrayList<List> tabela;
        tabela = (ArrayList) table;
        List<String> total = new ArrayList<>();
        total.add("");
        total.add("Quantas vezes:");
        for (int i = 2; i < tabela.get(0).size(); i++) {
            total.add("1");
        }
        return total;
    }

    public List porPc(ArrayList table) throws ParseException, SQLException {
        RelatorioDao relatorio = new RelatorioDao();
        List<Elementos> elementos;
        ArrayList<List> tabela;
        tabela = (ArrayList) table;
        List<String> total = new ArrayList<>();
        total.add("");
        total.add("Por peça:");
        int codTomadaTempo = Integer.parseInt((String) tabela.get(0).get(0));
        elementos = relatorio.atributosElementos(codTomadaTempo);
        for (int i = 2; i < tabela.get(0).size(); i++) {
            Elementos ele = elementos.get(i - 2);
            total.add("" + ele.getTotalDePecas());
        }
        return total;
    }

    public List tempoAjustado(ArrayList table) throws ParseException, SQLException {
        ArrayList<List> tabela;
        tabela = (ArrayList) table;
        List<String> total = new ArrayList<>();
        total.add("Minutos centecimal.");
        total.add("Tempo Ajustado:");
        int linhaPorPc = tabela.size() - 1;//linha da diferença
        int linhaQuVez = tabela.size() - 2;//Linha de quantas vezes
        int linhaTempoNor = tabela.size() - 3;//Linha de tempo Normal
        for (int i = 2; i < tabela.get(0).size(); i++) {
            double porPc = Double.parseDouble((String) tabela.get(linhaPorPc).get(i));
            double quVez = Double.parseDouble((String) tabela.get(linhaQuVez).get(i));
            double tempoNor = Double.parseDouble((String) tabela.get(linhaTempoNor).get(i));
            double tot = (tempoNor * quVez) / porPc;
            total.add("" + tot);
        }
        return total;
    }

    public List interferencia(ArrayList table) throws ParseException, SQLException {
        RelatorioDao relatorio = new RelatorioDao();
        List<Elementos> elementos;
        ArrayList<List> tabela;
        tabela = (ArrayList) table;
        List<String> total = new ArrayList<>();
        total.add("");
        total.add("Interferencia:");
        int codTomadaTempo = Integer.parseInt((String) tabela.get(0).get(0));
        elementos = relatorio.atributosElementos(codTomadaTempo);
        for (int i = 2; i < tabela.get(0).size(); i++) {
            Elementos ele = elementos.get(i - 2);
            total.add("" + ele.getInterferenciaElemento());
        }
        return total;
    }

    public List tempoBase(ArrayList table) throws ParseException, SQLException {
        ArrayList<List> tabela;
        tabela = (ArrayList) table;
        List<String> total = new ArrayList<>();
        total.add("Minutos centecimal.");
        total.add("Tempo base:");
        int linhaInter = tabela.size() - 1;//linha da Interferencia
        int linhaTemAju = tabela.size() - 2;//Linha de Tempo ajustado
        for (int i = 2; i < tabela.get(0).size(); i++) {
            double interferencia = Double.parseDouble((String) tabela.get(linhaInter).get(i));
            double tempoAjus = Double.parseDouble((String) tabela.get(linhaTemAju).get(i));
            double tot = ((tempoAjus * interferencia) / 100) + tempoAjus;
            total.add("" + tot);
        }
        return total;
    }

    public List concessoes(ArrayList table) throws ParseException, SQLException {
        RelatorioDao relatorio = new RelatorioDao();
        List<Elementos> elementos;
        ArrayList<List> tabela;
        tabela = (ArrayList) table;
        List<String> total = new ArrayList<>();
        total.add("");
        total.add("Concessoes:");
        int codTomadaTempo = Integer.parseInt((String) tabela.get(0).get(0));
        elementos = relatorio.atributosElementos(codTomadaTempo);
        for (int i = 2; i < tabela.get(0).size(); i++) {
            Elementos ele = elementos.get(i - 2);
            total.add("" + ele.getConcessaoElemento());
        }
        return total;
    }

    public List tempoPadrao(ArrayList table) throws ParseException, SQLException {
        ArrayList<List> tabela;
        tabela = (ArrayList) table;
        List<String> total = new ArrayList<>();
        total.add("Minutos centecimal.");
        total.add("Tempo padrao:");
        int linhaConc = tabela.size() - 1;//linha da concessoes
        int linhaTemBas = tabela.size() - 2;//Linha de Tempo base
        for (int i = 2; i < tabela.get(0).size(); i++) {
            double concessoes = Double.parseDouble((String) tabela.get(linhaConc).get(i));
            double tempoBase = Double.parseDouble((String) tabela.get(linhaTemBas).get(i));
            double tot = ((tempoBase * concessoes) / 100) + tempoBase;
            total.add("" + tot);
        }
        return total;
    }

    public List tempoPadraoOperacaoMi(ArrayList table) throws ParseException, SQLException {
        ArrayList<List> tabela;
        tabela = (ArrayList) table;
        List<String> total = new ArrayList<>();
        total.add("Minutos centecimal.");
        total.add("Tempo padrao operação:");
        int linhaTemPad = tabela.size() - 1;//linha do Tempo Padrao
        double tot = 0;
        for (int i = 2; i < tabela.get(0).size(); i++) {
            double concessoes = Double.parseDouble((String) tabela.get(linhaTemPad).get(i));
            tot += concessoes;
            total.add("");
        }
        total.remove(2);
        total.add(2, "" + tot);
        return total;
    }

    public List tempoPadraoOperacaoNor(ArrayList table) throws ParseException, SQLException {
        ArrayList<List> tabela;
        tabela = (ArrayList) table;
        List<String> total = new ArrayList<>();
        total.add("");
        total.add("Tempo padrao operação:");
        int linhaTemPad = tabela.size() - 2;//linha do Tempo Padrao
        double tot = 0;
        for (int i = 2; i < tabela.get(0).size(); i++) {
            double concessoes = Double.parseDouble((String) tabela.get(linhaTemPad).get(i));
            tot += concessoes;
            total.add("");
        }
        total.remove(2);
        total.add(2, this.converterEmHora(tot));
        return total;
    }

    public List producaoHora(ArrayList table) throws ParseException, SQLException {
        ArrayList<List> tabela;
        tabela = (ArrayList) table;
        List<String> total = new ArrayList<>();
        total.add("");
        total.add("Produção por Hora:");
        int linhaTemPad = tabela.size() - 2;//linha do Tempo Padrao operaão
        double tot = 0;
        for (int i = 2; i < tabela.get(0).size(); i++) {
            total.add("");
        }
        double proHor = Double.parseDouble((String) tabela.get(linhaTemPad).get(2));
        total.remove(2);
        total.add(2, "" + (60 / proHor));
        return total;
    }

    public List producaoDia(ArrayList table) throws ParseException, SQLException {
        ArrayList<List> tabela;
        tabela = (ArrayList) table;
        List<String> total = new ArrayList<>();
        total.add("8 Horas");
        total.add("Produção por dia:");
        int linhaHor = tabela.size() - 1;//linha produção por hora
        double tot = 0;
        for (int i = 2; i < tabela.get(0).size(); i++) {
            total.add("");
        }
        double proDia = Double.parseDouble((String) tabela.get(linhaHor).get(2));
        total.remove(2);
        total.add(2, "" + (proDia * 8));
        return total;
    }

    public double converterEmMinutoCentecimal(String tempo) throws ParseException {
        String[] att = tempo.split(":");
        int milesimo = Integer.parseInt(att[3]);
        int segundo = Integer.parseInt(att[2]);
        int minuto = Integer.parseInt(att[1]);
        int hora = Integer.parseInt(att[0]);
        double total = (hora * 60 * 60 * 1000) + (minuto * 60 * 1000) + (segundo * 1000) + milesimo;
        total = (total / 1000) / 60;
        return total;
    }

    public String converterEmHora(double total) throws ParseException {
        total = total * 60 * 1000;
        int hora = (int) (total / 3600000);
        int minuto = (int) (total % 3600000) / 60000;
        int segundo = (int) ((total % 3600000) % 60000) / 1000;
        int milesimo = (int) ((total % 3600000) % 60000) % 1000;
        String tempo = null;
        if (hora == 0) {
            tempo = "00:";
        }
        if (hora < 10) {
            tempo = "0" + hora + ":";
        }
        if (hora > 9) {
            tempo = hora + ":";
        }
        if (minuto < 10) {
            tempo += "0" + minuto + ":";
        }
        if (minuto > 9) {
            tempo += minuto + ":";
        }
        if (segundo < 10) {
            tempo += "0" + segundo + ":";
        }
        if (segundo > 9) {
            tempo += segundo + ":";
        }
        if (milesimo < 10) {
            tempo += "00" + milesimo;
        }
        if (milesimo < 100 && milesimo > 9) {
            tempo += "0" + milesimo;
        }
        if (milesimo > 99) {
            tempo += milesimo;
        }
        return tempo;
    }
}
//https://www.proenem.com.br/enem/fisica/estatistica-desvio-medio-desvio-padrao-e-variancia/
//https://pt.wikihow.com/Calcular-o-Intervalo-de-Confian%C3%A7a
