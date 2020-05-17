/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rezini.crono.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public List relatorio(){
       RelatorioDao yy = new RelatorioDao();
        List<TomadaDeTempo> listaTomadas = null;
        List<Leitura> leituras = null;
        ArrayList lll = new ArrayList();
        try {
            listaTomadas = yy.tomadaTempo("2020/04/10 00:00:00", "2020/05/15 00:00:00", 1);
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < listaTomadas.size(); i++) {
            RelatorioDao xy = new RelatorioDao();
            TomadaDeTempo tt = listaTomadas.get(i);
            int codigo = tt.getCodTomadaTempo();
           try {
               leituras = xy.listaTempos(codigo);
           } catch (SQLException ex) {
               Logger.getLogger(RelatorioController.class.getName()).log(Level.SEVERE, null, ex);
           }
            lll.add(leituras);
        }
         List<Object> lista = new ArrayList<>();
        for (int i = 0; i < lll.size(); i++) {
            List<Leitura> jj = (List<Leitura>) lll.get(i);
            for (int ix = 0; ix < jj.size(); ix++) {
                Leitura p = jj.get(ix);
                lista.add(new Object[]{p.getCodLeitura(), p.getSequencia(), p.getLeitura(), p.getCodLeitura()});
            }
        }
        
        return lista;
    }
    
    
    
}
