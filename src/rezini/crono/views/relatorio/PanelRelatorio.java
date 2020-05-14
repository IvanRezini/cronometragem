/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rezini.crono.views.relatorio;

import java.awt.CardLayout;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import rezini.crono.Utilidades.ManipularData;
import rezini.crono.controller.RelatorioController;

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
        jComboBoxOperacao.addItem("Selecione");
        RelatorioController lista = new RelatorioController();
        operacao = lista.listaDeOperacoesMenu(cod);     //Ira receber o codigo do produto
        for (int i = 0; i < operacao.size(); i++) {
            jComboBoxOperacao.addItem(operacao.get(i));
        }
    }

    private void limparMenuOperacao() {
        jComboBoxOperacao.removeAllItems();
    }

    private void setData() {
        String date = ManipularData.obterData("dd/MM/yyyy");
        jFormattedDataInicial.setText(date);
        jFormattedDataFinal.setText(date);
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
        jButton1 = new javax.swing.JButton();
        jPanelRlatorio = new javax.swing.JPanel();
        jLabelCabecalhoRelatorio = new javax.swing.JLabel();

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

        jButton1.setBackground(new java.awt.Color(0, 255, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jButton1.setText("Gerar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(125, 125, 125))
        );

        add(jPanelMenu, "card2");

        jLabelCabecalhoRelatorio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelCabecalhoRelatorio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCabecalhoRelatorio.setText("CabeÇalho relatorio");

        javax.swing.GroupLayout jPanelRlatorioLayout = new javax.swing.GroupLayout(jPanelRlatorio);
        jPanelRlatorio.setLayout(jPanelRlatorioLayout);
        jPanelRlatorioLayout.setHorizontalGroup(
            jPanelRlatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCabecalhoRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        );
        jPanelRlatorioLayout.setVerticalGroup(
            jPanelRlatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRlatorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCabecalhoRelatorio)
                .addContainerGap(446, Short.MAX_VALUE))
        );

        add(jPanelRlatorio, "card3");
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
        if (produto != "Selecione") {
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        ManipularData data = new ManipularData();
        String mensagem = "";
        String a = jFormattedDataInicial.getText();
        String b = jFormattedDataFinal.getText();
        mensagem = data.dataValida(a, b);
        if ("".equals(mensagem)) {
            mensagem = data.validarData(a, b);
        }
        if (!"".equals(mensagem)) {
            JOptionPane.showMessageDialog(null, mensagem, "AVISO", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_jButton1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
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
    private javax.swing.JPanel jPanelRlatorio;
    // End of variables declaration//GEN-END:variables
}
