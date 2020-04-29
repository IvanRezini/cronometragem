/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rezini.crono.views.operacao;

import java.awt.CardLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rezini.crono.dao.ElementosDao;
import rezini.crono.dao.OperacaoDao;
import rezini.crono.model.Elementos;
import rezini.crono.model.Operacao;

/**
 *
 * @author ivan rezini
 */
public class PanelListagemOperacao extends javax.swing.JPanel {

    private CardLayout cl;
    private int acao; /// Parametro 1 apenas lista operacoes parametro 2 lista e permite cadastro elementos
//parametro 3 permite edicao das operaçoes // prametro 4 lista elementos da operacao clicada

    /**
     * Creates new form PanelListagemOperacao
     */
    public PanelListagemOperacao(int i) throws SQLException {
        this.acao = i;
        initComponents();
        this.cl = (CardLayout) this.getLayout();
        this.popularTabela();
    }

    private void limparTabela() {
        ((DefaultTableModel) jTableListaOperacao.getModel()).setNumRows(0);
        jTableListaOperacao.updateUI();
    }

    private void popularTabela() throws SQLException {

        OperacaoDao ope = new OperacaoDao();
        List<Operacao> listaProdutos;
        if (this.acao == 1) {
            listaProdutos = ope.listaOperacoes();
        } else {
            listaProdutos = ope.listaOperacoesSemElementos();
        }
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

    private void popularTabelaElementos(int cod, String produto) throws SQLException {
        OperacaoDao ope = new OperacaoDao();
        Operacao op = null;
        op = ope.getOperacoe(cod);
        jLabelOperacao.setText("Operação: " + op.getCodOperacao());
        jLabelInsertCriacao.setText(op.getCreateOperacao());
        jLabelInsertDescricao.setText(op.getDescOperacao());
        jLabelInsertNome.setText(op.getNomeOperacao());
        jLabelInsertProduto.setText(produto);
        ElementosDao ele = new ElementosDao();

        List<Elementos> listaElementos;

        listaElementos = ele.listarElementos(cod);

        DefaultTableModel model = (DefaultTableModel) jTableElementos.getModel();
        List<Object> lista = new ArrayList<>();

        for (int i = 0; i < listaElementos.size(); i++) {
            Elementos p = listaElementos.get(i);
            lista.add(new Object[]{p.getNomeElemento(), p.getRitmoElemento(), p.getInterverenciaElemento(), p.getRepeticaoElemento(), p.getTotalDePecas()});
        }
        for (int idx = 0; idx < lista.size(); idx++) {
            model.addRow((Object[]) lista.get(idx));
        }
        this.add(jPanelElementos, "elementos");
        this.cl.show(this, "elementos");
        // TODO add your handling code here:
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelListaOperacao = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListaOperacao = new javax.swing.JTable();
        jPanelElementos = new javax.swing.JPanel();
        jLabelOperacao = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jLabelProduto = new javax.swing.JLabel();
        jLabelElementos = new javax.swing.JLabel();
        jLabelInsertNome = new javax.swing.JLabel();
        jLabelInsertProduto = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableElementos = new javax.swing.JTable();
        jLabelDescricao = new javax.swing.JLabel();
        jLabelInsertDescricao = new javax.swing.JLabel();
        jLabelCriacao = new javax.swing.JLabel();
        jLabelInsertCriacao = new javax.swing.JLabel();
        jPanelEditarOperacao = new javax.swing.JPanel();
        jLabelCodigo = new javax.swing.JLabel();
        jLabelInsertCodigo = new javax.swing.JLabel();
        jLabelTituloEdicao = new javax.swing.JLabel();
        jLabelProduto1 = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jTextDescricao = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jLabelOperacao1 = new javax.swing.JLabel();
        jTextOperacao = new javax.swing.JTextField();
        jLabelDescricao1 = new javax.swing.JLabel();
        jLabelInsertProdutoPanelEdicao = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("LISTA DE OPERAÇÕES");

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

        javax.swing.GroupLayout jPanelListaOperacaoLayout = new javax.swing.GroupLayout(jPanelListaOperacao);
        jPanelListaOperacao.setLayout(jPanelListaOperacaoLayout);
        jPanelListaOperacaoLayout.setHorizontalGroup(
            jPanelListaOperacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
        );
        jPanelListaOperacaoLayout.setVerticalGroup(
            jPanelListaOperacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListaOperacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE))
        );

        add(jPanelListaOperacao, "card3");

        jLabelOperacao.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelOperacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelOperacao.setText("OPERAÇÃO: xxx");

        jLabelNome.setText("Nome:");

        jLabelProduto.setText("Produto:");

        jLabelElementos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelElementos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelElementos.setText("Elementos");

        jLabelInsertNome.setText("xxxx");

        jLabelInsertProduto.setText("xxxxx");

        jTableElementos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Ritimo", "Interferencia", "Repediçao", "Total de peças"
            }
        ));
        jScrollPane2.setViewportView(jTableElementos);

        jLabelDescricao.setText("Descriçao:");

        jLabelInsertDescricao.setText("xxxx");

        jLabelCriacao.setText("Criação:");

        jLabelInsertCriacao.setText("xxxx");

        javax.swing.GroupLayout jPanelElementosLayout = new javax.swing.GroupLayout(jPanelElementos);
        jPanelElementos.setLayout(jPanelElementosLayout);
        jPanelElementosLayout.setHorizontalGroup(
            jPanelElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelOperacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelElementos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
            .addGroup(jPanelElementosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelInsertDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelElementosLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelInsertNome, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelInsertProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCriacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelInsertCriacao, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanelElementosLayout.setVerticalGroup(
            jPanelElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelElementosLayout.createSequentialGroup()
                .addComponent(jLabelOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(jLabelProduto)
                    .addComponent(jLabelInsertNome)
                    .addComponent(jLabelInsertProduto)
                    .addComponent(jLabelCriacao)
                    .addComponent(jLabelInsertCriacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDescricao)
                    .addComponent(jLabelInsertDescricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelElementos)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
        );

        add(jPanelElementos, "card4");

        jLabelCodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelCodigo.setText("Codigo:");

        jLabelInsertCodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelInsertCodigo.setText("xxxx");

        jLabelTituloEdicao.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTituloEdicao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTituloEdicao.setText("Edição de Operação");
        jLabelTituloEdicao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelProduto1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelProduto1.setText("Produto:");

        jButtonCancelar.setBackground(new java.awt.Color(255, 51, 0));
        jButtonCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCancelarMouseClicked(evt);
            }
        });

        jButtonSalvar.setBackground(new java.awt.Color(0, 255, 51));
        jButtonSalvar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSalvarMouseClicked(evt);
            }
        });

        jLabelOperacao1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelOperacao1.setText("Operação:");

        jLabelDescricao1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDescricao1.setText("Descriçao:");

        jLabelInsertProdutoPanelEdicao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelInsertProdutoPanelEdicao.setText("xxxx");

        javax.swing.GroupLayout jPanelEditarOperacaoLayout = new javax.swing.GroupLayout(jPanelEditarOperacao);
        jPanelEditarOperacao.setLayout(jPanelEditarOperacaoLayout);
        jPanelEditarOperacaoLayout.setHorizontalGroup(
            jPanelEditarOperacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTituloEdicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelEditarOperacaoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelEditarOperacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEditarOperacaoLayout.createSequentialGroup()
                        .addComponent(jLabelDescricao1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelEditarOperacaoLayout.createSequentialGroup()
                        .addComponent(jLabelProduto1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelInsertProdutoPanelEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelEditarOperacaoLayout.createSequentialGroup()
                        .addGroup(jPanelEditarOperacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelOperacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCodigo))
                        .addGroup(jPanelEditarOperacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelEditarOperacaoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelEditarOperacaoLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabelInsertCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEditarOperacaoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCancelar)
                .addGap(18, 18, 18)
                .addComponent(jButtonSalvar)
                .addGap(31, 31, 31))
        );
        jPanelEditarOperacaoLayout.setVerticalGroup(
            jPanelEditarOperacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEditarOperacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTituloEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanelEditarOperacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodigo)
                    .addComponent(jLabelInsertCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEditarOperacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelProduto1)
                    .addComponent(jLabelInsertProdutoPanelEdicao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelEditarOperacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelOperacao1)
                    .addComponent(jTextOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelEditarOperacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDescricao1)
                    .addComponent(jTextDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addGroup(jPanelEditarOperacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonCancelar))
                .addGap(24, 24, 24))
        );

        add(jPanelEditarOperacao, "card4");
    }// </editor-fold>//GEN-END:initComponents
    private void popularPainelEdicao(String codigo) throws SQLException {
        int cod = Integer.parseInt(codigo);
        OperacaoDao ope = new OperacaoDao();
        Operacao op = null;
        op = ope.getOperacoe(cod);
        jLabelInsertProdutoPanelEdicao.setText(op.getNomeProduto());
        jLabelInsertCodigo.setText(codigo);
        jTextOperacao.setText(op.getNomeOperacao());
        jTextDescricao.setText(op.getDescOperacao());
          this.add(jPanelEditarOperacao, "editar");
        this.cl.show(this, "editar");
    }


    private void jTableListaOperacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListaOperacaoMouseClicked
        //prametro 4 lista elementos da operacao clicada
        if (this.acao == 4) {
            int linha = jTableListaOperacao.getSelectedRow();
            String produto = jTableListaOperacao.getValueAt(linha, 2).toString();
            String codigo = jTableListaOperacao.getValueAt(linha, 0).toString();
            int cod = Integer.parseInt(codigo);
            try {
                this.popularTabelaElementos(cod, produto);
            } catch (SQLException ex) {
                Logger.getLogger(PanelListagemOperacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } //parametro 2 lista e permite cadastro elementos
        else if (this.acao == 2) {

        } //parametro 3 lista permite edicao das operaçoes 
        else if (this.acao == 3) {
            try {
                int linha = jTableListaOperacao.getSelectedRow();
                String codigo = jTableListaOperacao.getValueAt(linha, 0).toString();
                this.popularPainelEdicao(codigo);
            } catch (SQLException ex) {
                Logger.getLogger(PanelListagemOperacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTableListaOperacaoMouseClicked

    private void jButtonSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSalvarMouseClicked
        if (validarCampos()) {
            Operacao op = new Operacao();
            op.setNomeOperacao(jTextOperacao.getText());
            op.setDescOperacao(jTextDescricao.getText());
            op.setCodOperacao(Integer.parseInt(jLabelInsertCodigo.getText())); 
            OperacaoDao opDao = new OperacaoDao();

            try {
                opDao.alterar(op);
                JOptionPane.showMessageDialog(null, "Cadastro alterado com susesso");
                limparCampos();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Falha");
            }
        }
    }

    private void limparCampos() {
        try {
            jTextOperacao.setText(null);
            jTextDescricao.setText(null);
            this.acao = 1;
            this.limparTabela();
            this.popularTabela();
            this.add(jPanelListaOperacao, "list");
            this.cl.show(this, "list");
        } catch (SQLException ex) {
            Logger.getLogger(PanelListagemOperacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean validarCampos() {
        String nome = jTextOperacao.getText();
        if (nome.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe uma operaçao");
            return false;
        }
        String desc = jTextDescricao.getText();
        if (desc.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe uma Descrição");
            return false;
        } else {
            return true;
        }

    }//GEN-LAST:event_jButtonSalvarMouseClicked

    private void jButtonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCancelarMouseClicked
        this.limparCampos();
    }//GEN-LAST:event_jButtonCancelarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelCriacao;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelDescricao1;
    private javax.swing.JLabel jLabelElementos;
    private javax.swing.JLabel jLabelInsertCodigo;
    private javax.swing.JLabel jLabelInsertCriacao;
    private javax.swing.JLabel jLabelInsertDescricao;
    private javax.swing.JLabel jLabelInsertNome;
    private javax.swing.JLabel jLabelInsertProduto;
    private javax.swing.JLabel jLabelInsertProdutoPanelEdicao;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelOperacao;
    private javax.swing.JLabel jLabelOperacao1;
    private javax.swing.JLabel jLabelProduto;
    private javax.swing.JLabel jLabelProduto1;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTituloEdicao;
    private javax.swing.JPanel jPanelEditarOperacao;
    private javax.swing.JPanel jPanelElementos;
    private javax.swing.JPanel jPanelListaOperacao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableElementos;
    private javax.swing.JTable jTableListaOperacao;
    private javax.swing.JTextField jTextDescricao;
    private javax.swing.JTextField jTextOperacao;
    // End of variables declaration//GEN-END:variables
}
