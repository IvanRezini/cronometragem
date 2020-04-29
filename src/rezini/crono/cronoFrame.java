/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rezini.crono;

import java.awt.CardLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import rezini.crono.views.elementos.PanelCadastroElemento;
import rezini.crono.views.elementos.PanelListaDeElemento;
import rezini.crono.views.operacao.PanelCadastroOperacao;
import rezini.crono.views.operacao.PanelListagemOperacao;
import rezini.crono.views.padrao.PanelPadrao;
import rezini.crono.views.produto.PanelCadastroProduto;
import rezini.crono.views.usuario.PanelCadastroUsuario;
import rezini.crono.views.produto.PanelListarProdutos;
import rezini.crono.views.usuario.PanelListaDeUsuarios;

/**
 *
 * @author ivan rezini
 */
public class cronoFrame extends javax.swing.JFrame {

    private CardLayout cl;

    /**
     * Creates new form cronoFrame
     */
    public cronoFrame() {
        initComponents();
        this.cl = (CardLayout) jPanelPrincipal.getLayout();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        jPanelLogin = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelnome = new javax.swing.JLabel();
        LabelUsuario = new javax.swing.JLabel();
        cpUsuario = new javax.swing.JTextField();
        LabelSenha = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        cpSenha = new javax.swing.JPasswordField();
        baraMenuSuperior = new javax.swing.JMenuBar();
        jMenuInicio = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuUsuarioCadastro = new javax.swing.JMenuItem();
        jMenuUsuarioListar = new javax.swing.JMenuItem();
        jMenuUsuarioEditar = new javax.swing.JMenuItem();
        jMenuUsuarioExcluir = new javax.swing.JMenuItem();
        jMenuProduto = new javax.swing.JMenu();
        jMenuProdutoCadastro = new javax.swing.JMenuItem();
        jMenuProdutoListar = new javax.swing.JMenuItem();
        jMenuProdutoEditar = new javax.swing.JMenuItem();
        jMenuOperacao = new javax.swing.JMenu();
        jMenuOperacaoCadastro = new javax.swing.JMenuItem();
        jMenuOperacaoListar = new javax.swing.JMenuItem();
        jMenuOperacaoEditar = new javax.swing.JMenuItem();
        jMenuElemento = new javax.swing.JMenu();
        jMenuElementoCadastro = new javax.swing.JMenuItem();
        jMenuRelatorio = new javax.swing.JMenu();
        jMenuTomadaTempo = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(750, 500));

        jPanelPrincipal.setLayout(new java.awt.CardLayout());

        jPanelLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelLogin.setNextFocusableComponent(this);

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Sistem crono");

        jLabelnome.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabelnome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelnome.setText("Sistema de cronometragem Rezini");

        LabelUsuario.setFont(new java.awt.Font("Ultra", 1, 14)); // NOI18N
        LabelUsuario.setText("Usuário:");

        cpUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpUsuarioActionPerformed(evt);
            }
        });

        LabelSenha.setFont(new java.awt.Font("Ultra", 1, 14)); // NOI18N
        LabelSenha.setText("Senha:");

        btnEntrar.setBackground(new java.awt.Color(51, 255, 0));
        btnEntrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        cpSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLoginLayout = new javax.swing.GroupLayout(jPanelLogin);
        jPanelLogin.setLayout(jPanelLoginLayout);
        jPanelLoginLayout.setHorizontalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(LabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(cpUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(LabelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(cpSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelnome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelLoginLayout.setVerticalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabelnome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(btnEntrar))
        );

        jPanelPrincipal.add(jPanelLogin, "card2");

        baraMenuSuperior.setBackground(new java.awt.Color(51, 51, 255));

        jMenuInicio.setText("Inicio");
        jMenuInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuInicioMouseClicked(evt);
            }
        });
        baraMenuSuperior.add(jMenuInicio);

        jMenu1.setText("Usuario");

        jMenuUsuarioCadastro.setText("Cadastro");
        jMenuUsuarioCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUsuarioCadastroActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuUsuarioCadastro);

        jMenuUsuarioListar.setText("Listar");
        jMenuUsuarioListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUsuarioListarActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuUsuarioListar);

        jMenuUsuarioEditar.setText("Editar");
        jMenuUsuarioEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUsuarioEditarActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuUsuarioEditar);

        jMenuUsuarioExcluir.setText("Excluir");
        jMenuUsuarioExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUsuarioExcluirActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuUsuarioExcluir);

        baraMenuSuperior.add(jMenu1);

        jMenuProduto.setText("Produtos");

        jMenuProdutoCadastro.setText("Cadastro");
        jMenuProdutoCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuProdutoCadastroMouseClicked(evt);
            }
        });
        jMenuProdutoCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuProdutoCadastroActionPerformed(evt);
            }
        });
        jMenuProduto.add(jMenuProdutoCadastro);

        jMenuProdutoListar.setText("Listar");
        jMenuProdutoListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuProdutoListarActionPerformed(evt);
            }
        });
        jMenuProduto.add(jMenuProdutoListar);

        jMenuProdutoEditar.setText("Editar");
        jMenuProdutoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuProdutoEditarActionPerformed(evt);
            }
        });
        jMenuProduto.add(jMenuProdutoEditar);

        baraMenuSuperior.add(jMenuProduto);

        jMenuOperacao.setText("Operaçoes");

        jMenuOperacaoCadastro.setText("Cadastro");
        jMenuOperacaoCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuOperacaoCadastroActionPerformed(evt);
            }
        });
        jMenuOperacao.add(jMenuOperacaoCadastro);

        jMenuOperacaoListar.setText("Listar");
        jMenuOperacaoListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuOperacaoListarActionPerformed(evt);
            }
        });
        jMenuOperacao.add(jMenuOperacaoListar);

        jMenuOperacaoEditar.setText("Editar");
        jMenuOperacaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuOperacaoEditarActionPerformed(evt);
            }
        });
        jMenuOperacao.add(jMenuOperacaoEditar);

        baraMenuSuperior.add(jMenuOperacao);

        jMenuElemento.setText("Elementos");

        jMenuElementoCadastro.setText("Cadastro");
        jMenuElementoCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuElementoCadastroActionPerformed(evt);
            }
        });
        jMenuElemento.add(jMenuElementoCadastro);

        baraMenuSuperior.add(jMenuElemento);

        jMenuRelatorio.setText("Relatorios");
        baraMenuSuperior.add(jMenuRelatorio);

        jMenuTomadaTempo.setText("Tomada de tempo");
        baraMenuSuperior.add(jMenuTomadaTempo);

        setJMenuBar(baraMenuSuperior);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuUsuarioCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUsuarioCadastroActionPerformed
        PanelCadastroUsuario cadastroUsuario = new PanelCadastroUsuario();
        jPanelPrincipal.add(cadastroUsuario, "cadastroUsuario");
        this.cl.show(jPanelPrincipal, "cadastroUsuario");
// TODO add your handling code here:
    }//GEN-LAST:event_jMenuUsuarioCadastroActionPerformed

    private void jMenuUsuarioListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUsuarioListarActionPerformed
        PanelListaDeUsuarios listaUsuario = new PanelListaDeUsuarios(1);//Parametro que lista so usuarios ativos
        jPanelPrincipal.add(listaUsuario, "listaUsuario");
        this.cl.show(jPanelPrincipal, "listaUsuario");
    }//GEN-LAST:event_jMenuUsuarioListarActionPerformed

    private void jMenuUsuarioEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUsuarioEditarActionPerformed
        PanelListaDeUsuarios listaUsuario = new PanelListaDeUsuarios(2);//Parametro que lista so usuarios permite ediçao
        jPanelPrincipal.add(listaUsuario, "editarUsuario");
        this.cl.show(jPanelPrincipal, "editarUsuario");
    }//GEN-LAST:event_jMenuUsuarioEditarActionPerformed

    private void jMenuOperacaoCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuOperacaoCadastroActionPerformed
        try {
            PanelCadastroOperacao operacao = new PanelCadastroOperacao();
            jPanelPrincipal.add(operacao, "panelCadastroOperacao");
            this.cl.show(jPanelPrincipal, "panelCadastroOperacao");
        } catch (SQLException ex) {
            Logger.getLogger(cronoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuOperacaoCadastroActionPerformed

    private void jMenuOperacaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuOperacaoEditarActionPerformed
        try {
            PanelListagemOperacao listaOperacao = new PanelListagemOperacao(3);// parametro 3 permite a ediçao da operaçao que nao tem elementos cadastrados
            jPanelPrincipal.add(listaOperacao, "listaEditarOperacao");
            this.cl.show(jPanelPrincipal, "listaEditarOperacao");
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(cronoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuOperacaoEditarActionPerformed

    private void cpUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpUsuarioActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        PanelPadrao padrao = new PanelPadrao();
        jPanelPrincipal.add(padrao, "panelPadrao");
        this.cl.show(jPanelPrincipal, "panelPadrao");

    }//GEN-LAST:event_btnEntrarActionPerformed

    private void cpSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpSenhaActionPerformed

    private void jMenuProdutoCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuProdutoCadastroActionPerformed
        PanelCadastroProduto cadastro = new PanelCadastroProduto();
        jPanelPrincipal.add(cadastro, "panelCadastro");
        this.cl.show(jPanelPrincipal, "panelCadastro");
    }//GEN-LAST:event_jMenuProdutoCadastroActionPerformed

    private void jMenuProdutoCadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuProdutoCadastroMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuProdutoCadastroMouseClicked

    private void jMenuProdutoListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuProdutoListarActionPerformed
        try {
            PanelListarProdutos listar = new PanelListarProdutos(1); //parametro 1 tabela so ira listar os produtos
            jPanelPrincipal.add(listar, "listar");
            this.cl.show(jPanelPrincipal, "listar");
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(cronoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuProdutoListarActionPerformed

    private void jMenuProdutoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuProdutoEditarActionPerformed
        try {
            PanelListarProdutos editarProduto = new PanelListarProdutos(2); //parametro 2 tabela ira permitir a ediçao de produtos
            jPanelPrincipal.add(editarProduto, "editarProduto");
            this.cl.show(jPanelPrincipal, "editarProduto");
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(cronoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuProdutoEditarActionPerformed

    private void jMenuOperacaoListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuOperacaoListarActionPerformed
        try {
            PanelListagemOperacao listaOperacao = new PanelListagemOperacao(1); //lista todas as operaçoes
            jPanelPrincipal.add(listaOperacao, "listaOperacao");
            this.cl.show(jPanelPrincipal, "listaOperacao");
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(cronoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuOperacaoListarActionPerformed

    private void jMenuElementoCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuElementoCadastroActionPerformed
        PanelCadastroElemento cadastroElemento = new PanelCadastroElemento();
        jPanelPrincipal.add(cadastroElemento, "cadastroElemento");
        this.cl.show(jPanelPrincipal, "cadastroElemento");

        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuElementoCadastroActionPerformed

    private void jMenuUsuarioExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUsuarioExcluirActionPerformed
        PanelListaDeUsuarios listaUsuario = new PanelListaDeUsuarios(3);//Parametro que permite exclusão de usuarios
        jPanelPrincipal.add(listaUsuario, "excluirUsuario");
        this.cl.show(jPanelPrincipal, "excluirUsuario");
    }//GEN-LAST:event_jMenuUsuarioExcluirActionPerformed

    private void jMenuInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuInicioMouseClicked
        PanelPadrao padrao = new PanelPadrao();
        jPanelPrincipal.add(padrao, "panelPadrao");
        this.cl.show(jPanelPrincipal, "panelPadrao");

    }//GEN-LAST:event_jMenuInicioMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(cronoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cronoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cronoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cronoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cronoFrame().setVisible(true);
                System.out.println("hsnfgnfgnfgnfg \n whtwhrtrww \n wehwh");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelSenha;
    private javax.swing.JLabel LabelUsuario;
    private javax.swing.JMenuBar baraMenuSuperior;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JPasswordField cpSenha;
    private javax.swing.JTextField cpUsuario;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelnome;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenuElemento;
    private javax.swing.JMenuItem jMenuElementoCadastro;
    private javax.swing.JMenu jMenuInicio;
    private javax.swing.JMenu jMenuOperacao;
    private javax.swing.JMenuItem jMenuOperacaoCadastro;
    private javax.swing.JMenuItem jMenuOperacaoEditar;
    private javax.swing.JMenuItem jMenuOperacaoListar;
    private javax.swing.JMenu jMenuProduto;
    private javax.swing.JMenuItem jMenuProdutoCadastro;
    private javax.swing.JMenuItem jMenuProdutoEditar;
    private javax.swing.JMenuItem jMenuProdutoListar;
    private javax.swing.JMenu jMenuRelatorio;
    private javax.swing.JMenu jMenuTomadaTempo;
    private javax.swing.JMenuItem jMenuUsuarioCadastro;
    private javax.swing.JMenuItem jMenuUsuarioEditar;
    private javax.swing.JMenuItem jMenuUsuarioExcluir;
    private javax.swing.JMenuItem jMenuUsuarioListar;
    private javax.swing.JPanel jPanelLogin;
    private javax.swing.JPanel jPanelPrincipal;
    // End of variables declaration//GEN-END:variables

}
