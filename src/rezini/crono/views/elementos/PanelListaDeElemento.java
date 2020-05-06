/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rezini.crono.views.elementos;

import java.awt.CardLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import rezini.crono.cronoFrame;
import rezini.crono.dao.ElementosDao;
import rezini.crono.dao.OperacaoDao;
import rezini.crono.model.Elementos;
import rezini.crono.model.Operacao;

/**
 *
 * @author ivan rezini
 */
public class PanelListaDeElemento extends javax.swing.JPanel {

    private final CardLayout cl;

    /**
     * Creates new form PanelListaDeElemento
     *
     * @throws java.sql.SQLException
     */
    public PanelListaDeElemento() throws SQLException {
        initComponents();
        this.cl = (CardLayout) this.getLayout();
        this.popularTabela();

    }

    private void popularTabela() throws SQLException {

        OperacaoDao ope = new OperacaoDao();
        List<Operacao> listaProdutos;

        listaProdutos = ope.listaOperacoesComElementos();

        DefaultTableModel model = (DefaultTableModel) jTableListaOperacao.getModel();
        List<Object> lista = new ArrayList<>();

        for (int i = 0; i < listaProdutos.size(); i++) {
            Operacao p = listaProdutos.get(i);
            lista.add(new Object[]{p.getCodOperacao(), p.getNomeOperacao(), p.getNomeProduto(), p.getDescOperacao()});
        }
        for (int idx = 0; idx < lista.size(); idx++) {
            model.addRow((Object[]) lista.get(idx));
        }
    }

    private void popularTabelaElemento(int cod) throws SQLException {

        ElementosDao ele = new ElementosDao();
        List<Elementos> listaElementos;
        listaElementos = ele.listarElementos(cod);

        DefaultTableModel model = (DefaultTableModel) jTableElementos.getModel();
        List<Object> lista = new ArrayList<>();

        for (int i = 0; i < listaElementos.size(); i++) {
            Elementos e = listaElementos.get(i);
            lista.add(new Object[]{e.getNomeElemento(), e.getRitmoElemento(), e.getInterferenciaElemento(), e.getRepeticaoElemento(), e.getTotalDePecas()});
        }
        for (int idx = 0; idx < lista.size(); idx++) {
            model.addRow((Object[]) lista.get(idx));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelListaOperacao = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListaOperacao = new javax.swing.JTable();
        jLabelTitulo1 = new javax.swing.JLabel();
        jPanelListaElementos = new javax.swing.JPanel();
        jToggleVoltar = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableElementos = new javax.swing.JTable();
        jLabelOperacao = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelInsertOperacao = new javax.swing.JLabel();
        jLabelDescricao = new javax.swing.JLabel();
        jLabelInsertDescricao = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jPanelListaOperacao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

        jTableListaOperacao.setBorder(new javax.swing.border.MatteBorder(null));
        jTableListaOperacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Produto", "Descrição"
            }
        ));
        jTableListaOperacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListaOperacaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableListaOperacao);

        jLabelTitulo1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo1.setText("LISTA DE OPERAÇÕES COM ELEMENTOS");

        javax.swing.GroupLayout jPanelListaOperacaoLayout = new javax.swing.GroupLayout(jPanelListaOperacao);
        jPanelListaOperacao.setLayout(jPanelListaOperacaoLayout);
        jPanelListaOperacaoLayout.setHorizontalGroup(
            jPanelListaOperacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitulo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
        );
        jPanelListaOperacaoLayout.setVerticalGroup(
            jPanelListaOperacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListaOperacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE))
        );

        add(jPanelListaOperacao, "card3");

        jPanelListaElementos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

        jToggleVoltar.setBackground(new java.awt.Color(255, 204, 102));
        jToggleVoltar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jToggleVoltar.setText("Voltar");
        jToggleVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleVoltarMouseClicked(evt);
            }
        });

        jTableElementos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Ritimo", "Interferencia", "Repediçao", "Total de peças"
            }
        ));
        jTableElementos.setShowGrid(true);
        jTableElementos.setSurrendersFocusOnKeystroke(true);
        jScrollPane2.setViewportView(jTableElementos);

        jLabelOperacao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelOperacao.setText("Operação:");

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Lista de elementos");

        jLabelInsertOperacao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelInsertOperacao.setText("xxx");

        jLabelDescricao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDescricao.setText("Descrição:");

        jLabelInsertDescricao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelInsertDescricao.setText("xxx");

        javax.swing.GroupLayout jPanelListaElementosLayout = new javax.swing.GroupLayout(jPanelListaElementos);
        jPanelListaElementos.setLayout(jPanelListaElementosLayout);
        jPanelListaElementosLayout.setHorizontalGroup(
            jPanelListaElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelListaElementosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jToggleVoltar)
                .addGap(37, 37, 37))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelListaElementosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabelOperacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelInsertOperacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelInsertDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelListaElementosLayout.setVerticalGroup(
            jPanelListaElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelListaElementosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addGap(18, 18, 18)
                .addGroup(jPanelListaElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelOperacao)
                    .addComponent(jLabelInsertOperacao)
                    .addComponent(jLabelDescricao)
                    .addComponent(jLabelInsertDescricao))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(jToggleVoltar)
                .addGap(10, 10, 10))
        );

        add(jPanelListaElementos, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void jTableListaOperacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListaOperacaoMouseClicked

        int linha = jTableListaOperacao.getSelectedRow();
        String operacao = jTableListaOperacao.getValueAt(linha, 1).toString();
        String descricao = jTableListaOperacao.getValueAt(linha, 3).toString();
        String codigo = jTableListaOperacao.getValueAt(linha, 0).toString();
        int cod = Integer.parseInt(codigo);

        jLabelInsertDescricao.setText(descricao);
        jLabelInsertOperacao.setText(operacao);
        this.add(jPanelListaElementos, "lista");
        this.cl.show(this, "lista");
        try {
            this.popularTabelaElemento(cod);
        } catch (SQLException ex) {
            Logger.getLogger(PanelListaDeElemento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTableListaOperacaoMouseClicked

    private void jToggleVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleVoltarMouseClicked
        this.limparTabela();
        try {
            this.popularTabela();
        } catch (SQLException ex) {
            Logger.getLogger(PanelListaDeElemento.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.add(jPanelListaOperacao, "lista");
        this.cl.show(this, "lista");
        
    }//GEN-LAST:event_jToggleVoltarMouseClicked
 private void limparTabela() {
        ((DefaultTableModel) jTableElementos.getModel()).setNumRows(0);
        jTableElementos.updateUI();
         ((DefaultTableModel) jTableListaOperacao.getModel()).setNumRows(0);
        jTableListaOperacao.updateUI();

 }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelInsertDescricao;
    private javax.swing.JLabel jLabelInsertOperacao;
    private javax.swing.JLabel jLabelOperacao;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTitulo1;
    private javax.swing.JPanel jPanelListaElementos;
    private javax.swing.JPanel jPanelListaOperacao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableElementos;
    private javax.swing.JTable jTableListaOperacao;
    private javax.swing.JToggleButton jToggleVoltar;
    // End of variables declaration//GEN-END:variables
}
