/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rezini.crono;

import java.awt.CardLayout;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rezini.crono.Utilidades.GerenciaDeDados;
import rezini.crono.Utilidades.ManipularData;
import rezini.crono.dao.UsuarioDao;
import rezini.crono.model.Usuario;
import rezini.crono.views.elementos.PanelCadastroElemento;
import rezini.crono.views.elementos.PanelListaDeElemento;
import rezini.crono.views.operacao.PanelCadastroOperacao;
import rezini.crono.views.operacao.PanelListagemOperacao;
import rezini.crono.views.produto.PanelCadastroProduto;
import rezini.crono.views.usuario.PanelCadastroUsuario;
import rezini.crono.views.produto.PanelListarProdutos;
import rezini.crono.views.relatorio.PanelRelatorio;
import rezini.crono.views.tomadatempo.PanelTomadaDeTempo;
import rezini.crono.views.usuario.PanelListaDeUsuarios;

/**
 *
 * @author ivan rezini
 */
public class cronoFrame extends javax.swing.JFrame {

    private CardLayout cl;
    public Usuario usuario;
    public List<Object> usu = new ArrayList<>();

    /**
     * Creates new form cronoFrame
     */
    public cronoFrame() {
        initComponents();
        baraMenuSuperior.setVisible(false);
        this.cl = (CardLayout) jPanelPrincipal.getLayout();
        jPanelPrincipal.add(jPanelPadrao, "padrao");
        this.cl.show(jPanelPrincipal, "padrao");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelUsuario = new javax.swing.JLabel();
        jPanelPrincipal = new javax.swing.JPanel();
        jPanelPadrao = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonLogin = new javax.swing.JButton();
        jPanelLogin = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelnome = new javax.swing.JLabel();
        LabelUsuario = new javax.swing.JLabel();
        cpUsuario = new javax.swing.JTextField();
        LabelSenha = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        cpSenha = new javax.swing.JPasswordField();
        jLabelInsertUsuario = new javax.swing.JLabel();
        jLabelInsertCodigoUsuario = new javax.swing.JLabel();
        jLabelData = new javax.swing.JLabel();
        jLabelInsertData = new javax.swing.JLabel();
        baraMenuSuperior = new javax.swing.JMenuBar();
        jMenuInicio = new javax.swing.JMenu();
        jMenuUsuario = new javax.swing.JMenu();
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
        jMenuElementoListar = new javax.swing.JMenuItem();
        jMenuRelatorio = new javax.swing.JMenu();
        jMenuRelatorioGerar = new javax.swing.JMenu();
        jMenuTomadaTempo = new javax.swing.JMenu();
        jMenuTomadaTempoIniciar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(900, 600));

        jLabelUsuario.setText("Usuario:");

        jPanelPrincipal.setLayout(new java.awt.CardLayout());

        jPanelPadrao.setBackground(new java.awt.Color(51, 0, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bem vindo");

        jButtonLogin.setText("Login");
        jButtonLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonLoginMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelPadraoLayout = new javax.swing.GroupLayout(jPanelPadrao);
        jPanelPadrao.setLayout(jPanelPadraoLayout);
        jPanelPadraoLayout.setHorizontalGroup(
            jPanelPadraoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelPadraoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButtonLogin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelPadraoLayout.setVerticalGroup(
            jPanelPadraoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPadraoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonLogin)
                .addGap(144, 144, 144)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelPrincipal.add(jPanelPadrao, "card3");

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
        LabelUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LabelUsuario.setText("Usuário:");

        cpUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpUsuarioActionPerformed(evt);
            }
        });

        LabelSenha.setFont(new java.awt.Font("Ultra", 1, 14)); // NOI18N
        LabelSenha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LabelSenha.setText("Senha:   ");

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
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LabelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cpUsuario)
                            .addComponent(cpSenha))))
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
                .addComponent(btnEntrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelPrincipal.add(jPanelLogin, "card2");

        jLabelInsertUsuario.setText("xxx");

        jLabelInsertCodigoUsuario.setText("xxx");

        jLabelData.setText("Data:");

        jLabelInsertData.setText("xx/xx/xxxx");

        baraMenuSuperior.setBackground(new java.awt.Color(51, 51, 255));

        jMenuInicio.setText("Inicio");
        jMenuInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuInicioMouseClicked(evt);
            }
        });
        baraMenuSuperior.add(jMenuInicio);

        jMenuUsuario.setText("Usuario");

        jMenuUsuarioCadastro.setText("Cadastro");
        jMenuUsuarioCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUsuarioCadastroActionPerformed(evt);
            }
        });
        jMenuUsuario.add(jMenuUsuarioCadastro);

        jMenuUsuarioListar.setText("Listar");
        jMenuUsuarioListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUsuarioListarActionPerformed(evt);
            }
        });
        jMenuUsuario.add(jMenuUsuarioListar);

        jMenuUsuarioEditar.setText("Editar");
        jMenuUsuarioEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUsuarioEditarActionPerformed(evt);
            }
        });
        jMenuUsuario.add(jMenuUsuarioEditar);

        jMenuUsuarioExcluir.setText("Excluir");
        jMenuUsuarioExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUsuarioExcluirActionPerformed(evt);
            }
        });
        jMenuUsuario.add(jMenuUsuarioExcluir);

        baraMenuSuperior.add(jMenuUsuario);

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

        jMenuElementoListar.setText("Listar");
        jMenuElementoListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuElementoListarActionPerformed(evt);
            }
        });
        jMenuElemento.add(jMenuElementoListar);

        baraMenuSuperior.add(jMenuElemento);

        jMenuRelatorio.setText("Relatorios");

        jMenuRelatorioGerar.setText("Gerar");
        jMenuRelatorioGerar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuRelatorioGerarMouseClicked(evt);
            }
        });
        jMenuRelatorio.add(jMenuRelatorioGerar);

        baraMenuSuperior.add(jMenuRelatorio);

        jMenuTomadaTempo.setText("Tomada de tempo");

        jMenuTomadaTempoIniciar.setText("Iniciar");
        jMenuTomadaTempoIniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuTomadaTempoIniciarMouseClicked(evt);
            }
        });
        jMenuTomadaTempo.add(jMenuTomadaTempoIniciar);

        baraMenuSuperior.add(jMenuTomadaTempo);

        setJMenuBar(baraMenuSuperior);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelInsertCodigoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabelInsertUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelInsertData, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsuario)
                    .addComponent(jLabelInsertCodigoUsuario)
                    .addComponent(jLabelInsertUsuario)
                    .addComponent(jLabelData)
                    .addComponent(jLabelInsertData)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void autenticarPaineis() {
        this.baraMenuSuperior.setVisible(true);
        if (this.usuario.getTipCol() == 2) {//tipo dois quer dizer que o usuario não é um gestor E não possui todas as permissoes
            this.jMenuRelatorio.setVisible(false);
            this.jMenuUsuario.setVisible(false);
        }
        jLabelInsertData.setText(ManipularData.obterData("dd-MM-yyyy"));
        jLabelInsertUsuario.setText(this.usuario.getNomCol());
        jLabelInsertCodigoUsuario.setText(this.usuario.getCodCol()+"");

        jPanelPrincipal.add(jPanelPadrao, "padrao");
        this.cl.show(jPanelPrincipal, "padrao");

    }
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
        UsuarioDao col = new UsuarioDao();
        GerenciaDeDados gd = new GerenciaDeDados();

        try {
            Usuario c = col.checar(cpUsuario.getText(), cpSenha.getText());

            if (c == null) {
                JOptionPane.showMessageDialog(null, "ERRO AO AUTENTICAR");

            } else {

                this.usuario = c;
                ArrayList<Usuario> arrayUso = new ArrayList();
                int codigo = this.usuario.getCodCol();
                UsuarioDao colaborador = new UsuarioDao();

                colaborador.SetarUltimoAcesso(codigo);

                JOptionPane.showMessageDialog(null, "AUTENTICADO COM SUCESSO");

                gd.criarPastaColaborador();
                gd.salvarLog(this.usuario, false);
                this.autenticarPaineis();
                this.cl.show(jPanelPrincipal, "telaPadrao");

            }

        } catch (SQLException ex) {
            Logger.getLogger(cronoFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(cronoFrame.class.getName()).log(Level.SEVERE, null, ex);

            CardLayout cl = (CardLayout) jPanelPrincipal.getLayout();
            cl.show(jPanelPrincipal, "telaPadrao");
        }
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
        try {
            PanelCadastroElemento cadastroElemento = new PanelCadastroElemento();
            jPanelPrincipal.add(cadastroElemento, "cadastroElemento");
            this.cl.show(jPanelPrincipal, "cadastroElemento");

            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(cronoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuElementoCadastroActionPerformed

    private void jMenuUsuarioExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUsuarioExcluirActionPerformed
        PanelListaDeUsuarios listaUsuario = new PanelListaDeUsuarios(3);//Parametro que permite exclusão de usuarios
        jPanelPrincipal.add(listaUsuario, "excluirUsuario");
        this.cl.show(jPanelPrincipal, "excluirUsuario");
    }//GEN-LAST:event_jMenuUsuarioExcluirActionPerformed

    private void jMenuInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuInicioMouseClicked
        jPanelPrincipal.add(jPanelPadrao, "padrao");
        this.cl.show(jPanelPrincipal, "padrao");

    }//GEN-LAST:event_jMenuInicioMouseClicked

    private void jMenuElementoListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuElementoListarActionPerformed
        try {
            PanelListaDeElemento listar = new PanelListaDeElemento();
            jPanelPrincipal.add(listar, "listaElemento");
            this.cl.show(jPanelPrincipal, "listaElemento");
        } catch (SQLException ex) {
            Logger.getLogger(cronoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuElementoListarActionPerformed

    private void jButtonLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLoginMouseClicked
        jPanelPrincipal.add(jPanelLogin, "login");
        this.cl.show(jPanelPrincipal, "login");
        jButtonLogin.setVisible(false);
    }//GEN-LAST:event_jButtonLoginMouseClicked

    private void jMenuTomadaTempoIniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuTomadaTempoIniciarMouseClicked
        try {
            PanelTomadaDeTempo tomada = new PanelTomadaDeTempo(this.usuario.getCodCol());
            jPanelPrincipal.add(tomada, "tomada");
            this.cl.show(jPanelPrincipal, "tomada");
        } catch (SQLException ex) {
            Logger.getLogger(cronoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jMenuTomadaTempoIniciarMouseClicked

    private void jMenuRelatorioGerarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuRelatorioGerarMouseClicked
        try {
            PanelRelatorio relatorio = new PanelRelatorio(this.usuario.getCodCol());
            jPanelPrincipal.add(relatorio, "relatorio");
            this.cl.show(jPanelPrincipal, "relatorio");
        } catch (SQLException ex) {
            Logger.getLogger(cronoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuRelatorioGerarMouseClicked

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
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelInsertCodigoUsuario;
    private javax.swing.JLabel jLabelInsertData;
    private javax.swing.JLabel jLabelInsertUsuario;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLabel jLabelnome;
    private javax.swing.JMenu jMenuElemento;
    private javax.swing.JMenuItem jMenuElementoCadastro;
    private javax.swing.JMenuItem jMenuElementoListar;
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
    private javax.swing.JMenu jMenuRelatorioGerar;
    private javax.swing.JMenu jMenuTomadaTempo;
    private javax.swing.JMenu jMenuTomadaTempoIniciar;
    private javax.swing.JMenu jMenuUsuario;
    private javax.swing.JMenuItem jMenuUsuarioCadastro;
    private javax.swing.JMenuItem jMenuUsuarioEditar;
    private javax.swing.JMenuItem jMenuUsuarioExcluir;
    private javax.swing.JMenuItem jMenuUsuarioListar;
    private javax.swing.JPanel jPanelLogin;
    private javax.swing.JPanel jPanelPadrao;
    private javax.swing.JPanel jPanelPrincipal;
    // End of variables declaration//GEN-END:variables

}
