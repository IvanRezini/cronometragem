/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rezini.crono.views.relatorio;

import java.awt.CardLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rezini.crono.Utilidades.ManipularData;
import rezini.crono.controller.RelatorioController;
import rezini.crono.dao.ElementosDao;
import rezini.crono.dao.RelatorioDao;
import rezini.crono.model.Elementos;
import rezini.crono.model.Leitura;
import rezini.crono.model.TomadaDeTempo;

/**
 *
 * @author ivan rezini
 */
public class PanelRelatorio extends javax.swing.JPanel {

    private final CardLayout cl;
    private final int codigoUsuario;

    public PanelRelatorio(int cod) throws SQLException {
        initComponents();
        this.cl = (CardLayout) this.getLayout();
        this.codigoUsuario = cod;
        this.popularMenuProduto();
        this.setData();
    }

    private void popularMenuProduto() {
        List<String> produtos = null;
        jComboBoxProduto.addItem("Selecione");
        RelatorioController lista = new RelatorioController();
        produtos = lista.listaDeProdutosMenu();
        for (int i = 0; i < produtos.size(); i++) {
            jComboBoxProduto.addItem(produtos.get(i));
        }
    }

    private void popularMenuOperacao(int cod) {
        this.limparMenuOperacao();
        List<String> operacao = null;
        RelatorioController lista = new RelatorioController();
        operacao = lista.listaDeOperacoesMenu(cod);     //Ira receber o codigo do produto
        for (int i = 0; i < operacao.size(); i++) {
            jComboBoxOperacao.addItem(operacao.get(i));
        }
    }

    private void limparMenuOperacao() {
        jComboBoxOperacao.removeAllItems();
        jComboBoxOperacao.addItem("Selecione");
    }

    private void setData() {
        String date = ManipularData.obterData("dd/MM/yyyy");
        jFormattedDataInicial.setText(date);
        jFormattedDataFinal.setText(date);
    }

    private void gerarRelatorio() {
        String operacao = jComboBoxOperacao.getSelectedItem().toString();
        if ("Selecione".equals(operacao)) {
            JOptionPane.showMessageDialog(null, "Produto sem operação cadastrado", "AVISO", JOptionPane.WARNING_MESSAGE);

        }
        String date = ManipularData.obterData("dd/MM/yyyy");
        jFormattedDataInicial.setText(date);
        jFormattedDataFinal.setText(date);
    }

    private boolean validar() {
        String produto = jComboBoxProduto.getSelectedItem().toString();
        String operacao = jComboBoxOperacao.getSelectedItem().toString();
        int itens = jComboBoxOperacao.getItemCount();//total de iten do menu
        if ("Selecione".equals(produto)) {
            JOptionPane.showMessageDialog(null, "Selecione um produto", "AVISO", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if ("Selecione".equals(operacao) && itens == 1) {
            JOptionPane.showMessageDialog(null, "Produto sem operação cadastrado", "AVISO", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if ("Selecione".equals(operacao)) {
            JOptionPane.showMessageDialog(null, "Selecione uma operação", "AVISO", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    private void montarRelatorio() throws SQLException {
        /**
         * Cria a Tabela de exibicao do relatorio
         */
        String operacao = jComboBoxOperacao.getSelectedItem().toString();
        String[] cod = operacao.split("-");
        String limpar = cod[0].replaceAll("[^0-9]", "");
        int codigo = Integer.parseInt(limpar);
        List eleme = new ArrayList();
        eleme.clear();
         eleme.add("Tomada");
        eleme.add("Tomada \\ elementos");
        ElementosDao lista = new ElementosDao();
        List<Elementos> listaElementos;
        listaElementos = lista.listarElementos(codigo);
        for (int i = 0; i < listaElementos.size(); i++) {
            Elementos p = listaElementos.get(i);
            eleme.add(p.getNomeElemento());
        }
        //total de elementos da tabela
        //  this.elemento = eleme.size();

        DefaultTableModel model = (DefaultTableModel) jTableRelatorio.getModel();
        for (int i = 0; i < eleme.size(); i++) {
            model.addColumn(eleme.get(i));
        }
        //String[] toma = {(this.tomada + 1) + " Tomada", ""};
        // model.addRow(toma);
        this.popularTabela();
    }

    private void popularTabela() throws SQLException {
        RelatorioController relatorio = new RelatorioController();
      
        DefaultTableModel model = (DefaultTableModel) jTableRelatorio.getModel();
        List<Object> lista = null;
        lista = relatorio.relatorio();
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

        jPanelMenu = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jComboBoxProduto = new javax.swing.JComboBox<>();
        jLabelProduto = new javax.swing.JLabel();
        jComboBoxOperacao = new javax.swing.JComboBox<>();
        jLabelOperacao = new javax.swing.JLabel();
        jFormattedDataInicial = new javax.swing.JFormattedTextField();
        jFormattedDataFinal = new javax.swing.JFormattedTextField();
        jLabelDateInicio = new javax.swing.JLabel();
        jLabelDateFim = new javax.swing.JLabel();
        jButtonGerar = new javax.swing.JButton();
        jPanelRelatorio = new javax.swing.JPanel();
        jLabelCabecalhoRelatorio = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRelatorio = new javax.swing.JTable();

        setLayout(new java.awt.CardLayout());

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Relatorio");

        jComboBoxProduto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxProdutoItemStateChanged(evt);
            }
        });
        jComboBoxProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxProdutoMouseClicked(evt);
            }
        });
        jComboBoxProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProdutoActionPerformed(evt);
            }
        });

        jLabelProduto.setText("Produto:");

        jComboBoxOperacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        jComboBoxOperacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOperacaoActionPerformed(evt);
            }
        });

        jLabelOperacao.setText("Operacao:");

        try {
            jFormattedDataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedDataInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedDataInicialActionPerformed(evt);
            }
        });

        try {
            jFormattedDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedDataFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedDataFinalActionPerformed(evt);
            }
        });

        jLabelDateInicio.setText("Inicio:");

        jLabelDateFim.setText("Fim:");

        jButtonGerar.setBackground(new java.awt.Color(0, 255, 0));
        jButtonGerar.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jButtonGerar.setText("Gerar");
        jButtonGerar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonGerarMouseClicked(evt);
            }
        });
        jButtonGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelOperacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelMenuLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabelDateInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelMenuLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabelDateFim, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(141, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addGap(35, 35, 35)
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelProduto)
                    .addComponent(jComboBoxOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelOperacao))
                .addGap(52, 52, 52)
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDateInicio))
                .addGap(49, 49, 49)
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDateFim)
                    .addComponent(jFormattedDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(jButtonGerar)
                .addGap(125, 125, 125))
        );

        add(jPanelMenu, "card2");

        jLabelCabecalhoRelatorio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelCabecalhoRelatorio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCabecalhoRelatorio.setText("CabeÇalho relatorio");

        jTableRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableRelatorio);

        javax.swing.GroupLayout jPanelRelatorioLayout = new javax.swing.GroupLayout(jPanelRelatorio);
        jPanelRelatorio.setLayout(jPanelRelatorioLayout);
        jPanelRelatorioLayout.setHorizontalGroup(
            jPanelRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCabecalhoRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanelRelatorioLayout.setVerticalGroup(
            jPanelRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRelatorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCabecalhoRelatorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        add(jPanelRelatorio, "card3");
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxProdutoActionPerformed

    private void jComboBoxOperacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOperacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxOperacaoActionPerformed

    private void jComboBoxProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxProdutoMouseClicked

    }//GEN-LAST:event_jComboBoxProdutoMouseClicked

    private void jComboBoxProdutoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxProdutoItemStateChanged
        String produto = jComboBoxProduto.getSelectedItem().toString();
        this.limparMenuOperacao();
        if (!"Selecione".equals(produto)) {
            String[] cod = produto.split("-");
            String limpar = cod[0].replaceAll("[^0-9]", "");
            int codigo = Integer.parseInt(limpar);
            this.popularMenuOperacao(codigo);
        }
    }//GEN-LAST:event_jComboBoxProdutoItemStateChanged

    private void jFormattedDataInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedDataInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedDataInicialActionPerformed

    private void jFormattedDataFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedDataFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedDataFinalActionPerformed

    private void jButtonGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonGerarActionPerformed

    private void jButtonGerarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonGerarMouseClicked
        if (this.validar()) {
            ManipularData data = new ManipularData();
            String mensagem = "";
            String a = jFormattedDataInicial.getText();
            String b = jFormattedDataFinal.getText();
            mensagem = data.dataValida(a, b);
            if ("".equals(mensagem)) {
                mensagem = data.validarData(a, b);
                if ("".equals(mensagem)) {
                    this.gerarRelatorio();
                }
            }
            if (!"".equals(mensagem)) {
                JOptionPane.showMessageDialog(null, mensagem, "AVISO", JOptionPane.WARNING_MESSAGE);
                this.setData();
            }
            this.add(jPanelRelatorio, "relatorio");
            this.cl.show(this, "relatorio");
            try {
                this.montarRelatorio();
            } catch (SQLException ex) {
                Logger.getLogger(PanelRelatorio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonGerarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGerar;
    private javax.swing.JComboBox<String> jComboBoxOperacao;
    private javax.swing.JComboBox<String> jComboBoxProduto;
    private javax.swing.JFormattedTextField jFormattedDataFinal;
    private javax.swing.JFormattedTextField jFormattedDataInicial;
    private javax.swing.JLabel jLabelCabecalhoRelatorio;
    private javax.swing.JLabel jLabelDateFim;
    private javax.swing.JLabel jLabelDateInicio;
    private javax.swing.JLabel jLabelOperacao;
    private javax.swing.JLabel jLabelProduto;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelRelatorio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRelatorio;
    // End of variables declaration//GEN-END:variables
}
