/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rezini.crono.views.tomadatempo;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import rezini.crono.dao.OperacaoDao;
import rezini.crono.model.Operacao;
import rezini.crono.Utilidades.ObterData;
import rezini.crono.dao.ElementosDao;
import rezini.crono.dao.LeituraDao;
import rezini.crono.model.TomadaDeTempo;
import rezini.crono.dao.TomadaDeTempoDao;
import rezini.crono.model.Elementos;
import rezini.crono.model.Leitura;

/**
 *
 * @author ivan rezini
 */
public class PanelTomadaDeTempo extends javax.swing.JPanel {

    private int codigoTomada;
    private int tomada = 0;
    private int elemento = 0;
    private int contadorElemento = 1;
    private int codigoUsuario;
    private Timer timer;
    private int currentMilessimo = 0;
    private int currentSegundo = 0;
    private int currentMinuto = 0;
    private int currentHora = 0;
    private final int velocidade = 0;
    private final CardLayout cl;
    private String dataCronometragem;
    private final List<Object> listaTempos = new ArrayList<>();

    /**
     * Creates new form PanelTomadaDeTempo
     *
     * @param cod
     * @throws java.sql.SQLException
     */
    public PanelTomadaDeTempo(int cod) throws SQLException {
        this.codigoUsuario = cod;
        initComponents();
        iniciarCronometro();
        stopTime();
        this.cl = (CardLayout) this.getLayout();
        popularTabela();
        jButtonFim.setVisible(false);
        jButtonProximaTomada.setVisible(false);
        jButtonProximoElemento.setVisible(false);
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

    private void addLinha() {
        /**
         * Adiciona uma linha a tabela de cronometragem e zera o contador de
         * elementos.
         */
        this.tomada++;
        DefaultTableModel model = (DefaultTableModel) jTableElementos.getModel();
        String[] toma = {(this.tomada + 1) + "° Tomada", ""};
        model.addRow(toma);
    }

    private void salvarLeitura() {
        Leitura le = new Leitura();
        le.setCodLeitura(this.codigoTomada);
        le.setSequencia(this.tomada + 1);
        le.setLeitura(jLabelCronometro.getText());
        this.listaTempos.add(le);
    }

    private void limparTabela() {
        ((DefaultTableModel) jTableElementos.getModel()).setNumRows(0);
        jTableElementos.updateUI();
    }

    private void excluirTomada() {
        TomadaDeTempoDao excluir = new TomadaDeTempoDao();
        try {
            excluir.eliminar(this.codigoTomada);
        } catch (SQLException ex) {
            Logger.getLogger(PanelTomadaDeTempo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void limparCampo() {
        this.codigoTomada = 0;
        this.tomada = 0;
        this.jLabelInsertCodigo.setText("");
        this.jLabelInsertData.setText("");
        this.jLabelInsertDescricao.setText("");
        this.jLabelInsertHora.setText("");
        this.jLabelInsertNome.setText("");
        this.jLabelInsertProduto.setText("");
        this.jTextFieldNome.setText("");
        this.jTextAreaDescricao.setText("");
        ///limpa o modelo da tabela
        javax.swing.table.TableModel dataModel
                = new javax.swing.table.DefaultTableModel(0, 0);
        jTableElementos.setModel(dataModel);
    }

    private void criarTabela(int codOperacao) throws SQLException {
        /**
         * Cria a Tabela de elementos a serem cronometrados apartir dos
         * elementos cadastrados no banco de dados;
         */
        List eleme = new ArrayList();
        eleme.clear();
        eleme.add("Tomada");
        ElementosDao lista = new ElementosDao();
        List<Elementos> listaElementos;
        listaElementos = lista.listarElementos(codOperacao);
        for (int i = 0; i < listaElementos.size(); i++) {
            Elementos p = listaElementos.get(i);
            eleme.add(p.getNomeElemento());
        }
        //total de elementos da tabela
        this.elemento = eleme.size();

        DefaultTableModel model = (DefaultTableModel) jTableElementos.getModel();
        for (int i = 0; i < eleme.size(); i++) {
            model.addColumn(eleme.get(i));
        }
        String[] toma = {(this.tomada + 1) + " Tomada", ""};
        model.addRow(toma);

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
        jPanelCadastroTomada = new javax.swing.JPanel();
        jLabelCodigo = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jLabelInsertCodigo = new javax.swing.JLabel();
        jLabelInsertNome = new javax.swing.JLabel();
        jLabelProduto = new javax.swing.JLabel();
        jLabelInsertProduto = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelDescricao = new javax.swing.JLabel();
        jLabelInsertDescricao = new javax.swing.JLabel();
        jLabelNomeCronometrista = new javax.swing.JLabel();
        jLabelDescricaoTomada = new javax.swing.JLabel();
        jLabelData = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDescricao = new javax.swing.JTextArea();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelHora = new javax.swing.JLabel();
        jButtonCancelarCadastroTomada = new javax.swing.JButton();
        jButtonIniciarTomada = new javax.swing.JButton();
        jLabelInsertData = new javax.swing.JLabel();
        jLabelInsertHora = new javax.swing.JLabel();
        jPanelTomadaDeTempo = new javax.swing.JPanel();
        jButtonInicio = new javax.swing.JButton();
        jButtonFim = new javax.swing.JButton();
        jLabelCronometro = new javax.swing.JLabel();
        jLabelTituloTomada = new javax.swing.JLabel();
        jButtonProximoElemento = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableElementos = new javax.swing.JTable();
        jButtonCancelarTomada = new javax.swing.JButton();
        jButtonProximaTomada = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        jPanelListaOperacao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

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
            .addComponent(jLabelTitulo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanelListaOperacaoLayout.setVerticalGroup(
            jPanelListaOperacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListaOperacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE))
        );

        add(jPanelListaOperacao, "card3");

        jPanelCadastroTomada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

        jLabelCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCodigo.setText("Codigo:");

        jLabelNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNome.setText("Nome:");

        jLabelInsertCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelInsertCodigo.setText("xxx");

        jLabelInsertNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelInsertNome.setText("xxx");

        jLabelProduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelProduto.setText("Produto:");

        jLabelInsertProduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelInsertProduto.setText("xxx");

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Cadastro Tomada de Tempo");

        jLabelDescricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDescricao.setText("Descrição:");

        jLabelInsertDescricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelInsertDescricao.setText("xxx");

        jLabelNomeCronometrista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNomeCronometrista.setText("Nome cronometrista:");

        jLabelDescricaoTomada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDescricaoTomada.setText("Descrição da tomada de tempo:");

        jLabelData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelData.setText("Data:");

        jTextAreaDescricao.setColumns(20);
        jTextAreaDescricao.setRows(5);
        jScrollPane2.setViewportView(jTextAreaDescricao);

        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });

        jLabelHora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelHora.setText("Hora:");

        jButtonCancelarCadastroTomada.setBackground(new java.awt.Color(255, 153, 51));
        jButtonCancelarCadastroTomada.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jButtonCancelarCadastroTomada.setText("Cancelar");
        jButtonCancelarCadastroTomada.setPreferredSize(new java.awt.Dimension(70, 23));
        jButtonCancelarCadastroTomada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarCadastroTomadaActionPerformed(evt);
            }
        });

        jButtonIniciarTomada.setBackground(new java.awt.Color(0, 255, 0));
        jButtonIniciarTomada.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jButtonIniciarTomada.setText("Iniciar");
        jButtonIniciarTomada.setPreferredSize(new java.awt.Dimension(70, 23));
        jButtonIniciarTomada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonIniciarTomadaMouseClicked(evt);
            }
        });
        jButtonIniciarTomada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarTomadaActionPerformed(evt);
            }
        });

        jLabelInsertData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelInsertData.setText("xxx");

        jLabelInsertHora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelInsertHora.setText("xxx");

        javax.swing.GroupLayout jPanelCadastroTomadaLayout = new javax.swing.GroupLayout(jPanelCadastroTomada);
        jPanelCadastroTomada.setLayout(jPanelCadastroTomadaLayout);
        jPanelCadastroTomadaLayout.setHorizontalGroup(
            jPanelCadastroTomadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelCadastroTomadaLayout.createSequentialGroup()
                .addComponent(jLabelDescricaoTomada)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2))
            .addGroup(jPanelCadastroTomadaLayout.createSequentialGroup()
                .addComponent(jLabelDescricao)
                .addGap(0, 0, 0)
                .addComponent(jLabelInsertDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelCadastroTomadaLayout.createSequentialGroup()
                .addComponent(jLabelCodigo)
                .addGap(0, 0, 0)
                .addComponent(jLabelInsertCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabelNome)
                .addGap(0, 0, 0)
                .addComponent(jLabelInsertNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jLabelProduto)
                .addGap(0, 0, 0)
                .addComponent(jLabelInsertProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelCadastroTomadaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonCancelarCadastroTomada, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonIniciarTomada, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanelCadastroTomadaLayout.createSequentialGroup()
                .addComponent(jLabelNomeCronometrista)
                .addGap(0, 0, 0)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabelData)
                .addGap(1, 1, 1)
                .addComponent(jLabelInsertData, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabelHora)
                .addGap(1, 1, 1)
                .addComponent(jLabelInsertHora, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
        );
        jPanelCadastroTomadaLayout.setVerticalGroup(
            jPanelCadastroTomadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroTomadaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addGap(22, 22, 22)
                .addGroup(jPanelCadastroTomadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelInsertProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelCadastroTomadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelCodigo)
                        .addComponent(jLabelNome)
                        .addComponent(jLabelInsertCodigo)
                        .addComponent(jLabelInsertNome)
                        .addComponent(jLabelProduto)))
                .addGap(22, 22, 22)
                .addGroup(jPanelCadastroTomadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDescricao)
                    .addComponent(jLabelInsertDescricao))
                .addGap(22, 22, 22)
                .addGroup(jPanelCadastroTomadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomeCronometrista)
                    .addComponent(jLabelData)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHora)
                    .addComponent(jLabelInsertData)
                    .addComponent(jLabelInsertHora))
                .addGap(20, 20, 20)
                .addGroup(jPanelCadastroTomadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDescricaoTomada)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                .addGroup(jPanelCadastroTomadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonIniciarTomada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelarCadastroTomada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        add(jPanelCadastroTomada, "card3");

        jPanelTomadaDeTempo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jButtonInicio.setBackground(new java.awt.Color(51, 255, 51));
        jButtonInicio.setText("Iniciar");
        jButtonInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonInicioMouseClicked(evt);
            }
        });

        jButtonFim.setBackground(new java.awt.Color(255, 51, 51));
        jButtonFim.setText("Fim");
        jButtonFim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonFimMouseClicked(evt);
            }
        });

        jLabelCronometro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabelTituloTomada.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelTituloTomada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTituloTomada.setText("Tomada De tempo");

        jButtonProximoElemento.setBackground(new java.awt.Color(51, 51, 255));
        jButtonProximoElemento.setText("Proximo Elemento");
        jButtonProximoElemento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonProximoElementoMouseClicked(evt);
            }
        });
        jButtonProximoElemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProximoElementoActionPerformed(evt);
            }
        });

        jTableElementos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableElementos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTableElementos);

        jButtonCancelarTomada.setBackground(new java.awt.Color(255, 153, 51));
        jButtonCancelarTomada.setText("Cancelar");
        jButtonCancelarTomada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCancelarTomadaMouseClicked(evt);
            }
        });

        jButtonProximaTomada.setBackground(new java.awt.Color(0, 255, 51));
        jButtonProximaTomada.setText("Proxima tomada");
        jButtonProximaTomada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonProximaTomadaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelTomadaDeTempoLayout = new javax.swing.GroupLayout(jPanelTomadaDeTempo);
        jPanelTomadaDeTempo.setLayout(jPanelTomadaDeTempoLayout);
        jPanelTomadaDeTempoLayout.setHorizontalGroup(
            jPanelTomadaDeTempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTomadaDeTempoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTomadaDeTempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonCancelarTomada, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(jButtonInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(55, 55, 55)
                .addGroup(jPanelTomadaDeTempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelTomadaDeTempoLayout.createSequentialGroup()
                        .addComponent(jButtonProximoElemento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonProximaTomada, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonFim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jLabelCronometro, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174))
            .addComponent(jLabelTituloTomada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3)
        );
        jPanelTomadaDeTempoLayout.setVerticalGroup(
            jPanelTomadaDeTempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTomadaDeTempoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTituloTomada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTomadaDeTempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCronometro, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelTomadaDeTempoLayout.createSequentialGroup()
                        .addGroup(jPanelTomadaDeTempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonInicio)
                            .addComponent(jButtonProximoElemento)
                            .addComponent(jButtonProximaTomada))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelTomadaDeTempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonFim)
                            .addComponent(jButtonCancelarTomada))))
                .addGap(10, 10, 10))
        );

        add(jPanelTomadaDeTempo, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonInicioMouseClicked
        jButtonInicio.setVisible(false);
        jButtonProximoElemento.setVisible(true);
        iniciarCronometro();
    }//GEN-LAST:event_jButtonInicioMouseClicked

    private void jButtonFimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonFimMouseClicked
        this.stopTime();
        Object[] options = {"Sim", "Não"};
        int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Salvar Tempos?", "Atenção!",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        if (opcaoSelecionada == 0) {
            for (int i = 0; i < this.listaTempos.size(); i++) {
                try {
                    Leitura leituras = (Leitura) this.listaTempos.get(i);
                    LeituraDao lei = new LeituraDao();
                    lei.inserir(leituras);
                } catch (SQLException ex) {
                    Logger.getLogger(PanelTomadaDeTempo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            this.limparTabela();
            this.limparCampo();
            jButtonProximaTomada.setVisible(false);
            jButtonProximoElemento.setVisible(false);
            jButtonFim.setVisible(false);
            jButtonInicio.setVisible(true);
            this.add(jPanelListaOperacao, "lista");
            this.cl.show(this, "lista");

        } else {
            int opcao = JOptionPane.showOptionDialog(null, "Descartar leituras?", "Atenção!",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            if (opcao == 0) {
                this.limparTabela();
                this.excluirTomada();
                this.limparCampo();
                jButtonProximaTomada.setVisible(false);
                jButtonProximoElemento.setVisible(false);
                jButtonFim.setVisible(false);
                jButtonInicio.setVisible(true);
                this.add(jPanelListaOperacao, "lista");
                this.cl.show(this, "lista");
            }
        }

    }//GEN-LAST:event_jButtonFimMouseClicked

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jButtonCancelarCadastroTomadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarCadastroTomadaActionPerformed
        this.add(jPanelListaOperacao, "lista");
        this.cl.show(this, "lista");
        this.limparCampo();
    }//GEN-LAST:event_jButtonCancelarCadastroTomadaActionPerformed

    private void jTableListaOperacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListaOperacaoMouseClicked
        int linha = jTableListaOperacao.getSelectedRow();
        ///Problema a ser resolvido ele indica que o array esta fora do tamanho pegando um numero negativo no primeiro clic.
        if (linha >= 0) {
            String codigo = jTableListaOperacao.getValueAt(linha, 0).toString();
            String nome = jTableListaOperacao.getValueAt(linha, 1).toString();
            String produto = jTableListaOperacao.getValueAt(linha, 2).toString();
            String descricao = jTableListaOperacao.getValueAt(linha, 3).toString();
            this.dataCronometragem = ObterData.obterData("yyyy-MM-dd HH:mm:ss");
            jLabelInsertData.setText(ObterData.obterData("dd/MM/yyyy"));
            jLabelInsertHora.setText(ObterData.obterData("HH:mm:ss"));
            jLabelInsertDescricao.setText(descricao);
            jLabelInsertNome.setText(nome);
            jLabelInsertCodigo.setText(codigo);
            jLabelInsertProduto.setText(produto);
            this.add(jPanelCadastroTomada, "cadastro");
            this.cl.show(this, "cadastro");

        }
    }//GEN-LAST:event_jTableListaOperacaoMouseClicked

    private void jButtonIniciarTomadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarTomadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonIniciarTomadaActionPerformed

    private void jButtonIniciarTomadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonIniciarTomadaMouseClicked
        if (validarCampos()) {

            try {
                int codigo = Integer.parseInt(jLabelInsertCodigo.getText());
                TomadaDeTempo tom = new TomadaDeTempo();
                tom.setNomeCronometrista(jTextFieldNome.getText());
                tom.setCodOperacao(Integer.parseInt(jLabelInsertCodigo.getText()));
                tom.setDataTomadaTempo(this.dataCronometragem);
                tom.setDescTomadaTempo(jTextAreaDescricao.getText());
                tom.setCodUsuario(this.codigoUsuario);
                TomadaDeTempoDao cadastro = new TomadaDeTempoDao();
                cadastro.inserir(tom);
                //busca o codigo da tomada de tempo salva no banco
                this.criarTabela(codigo);
                this.add(jPanelTomadaDeTempo, "tomada");
                this.cl.show(this, "tomada");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Falha no cadastro.");
                Logger.getLogger(PanelTomadaDeTempo.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                TomadaDeTempoDao ultimo = new TomadaDeTempoDao();
                this.codigoTomada = ultimo.ultimaTomada(this.dataCronometragem);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Falha au obter codigo da tomada.");
                Logger.getLogger(PanelTomadaDeTempo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonIniciarTomadaMouseClicked

    private void jButtonProximoElementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProximoElementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonProximoElementoActionPerformed

    private void jButtonCancelarTomadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCancelarTomadaMouseClicked
        Object[] options = {"Sim", "Não"};
        int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Cancelar a tomada?\nAo cancelar vc ira perder todo o cadastro!!", "Atenção!",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        if (opcaoSelecionada == 0) {
            this.limparTabela();
            this.excluirTomada();
            this.limparCampo();
            this.add(jPanelListaOperacao, "lista");
            this.cl.show(this, "lista");
        }
    }//GEN-LAST:event_jButtonCancelarTomadaMouseClicked

    private void jButtonProximoElementoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonProximoElementoMouseClicked
        this.salvarLeitura();
        String tempo = jLabelCronometro.getText();
        jTableElementos.setValueAt(tempo, this.tomada, this.contadorElemento);
        this.contadorElemento++;
        this.stopTime();
        this.iniciarCronometro();
        if (this.contadorElemento == this.elemento) {
            this.stopTime();
            jButtonProximaTomada.setVisible(true);
            jButtonProximoElemento.setVisible(false);
            jButtonFim.setVisible(true);
            this.contadorElemento = 1;
        }

    }//GEN-LAST:event_jButtonProximoElementoMouseClicked

    private void jButtonProximaTomadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonProximaTomadaMouseClicked
        jButtonProximaTomada.setVisible(false);
        jButtonFim.setVisible(false);
        jButtonInicio.setVisible(true);
        this.stopTime();
        this.addLinha();
    }//GEN-LAST:event_jButtonProximaTomadaMouseClicked

    private boolean validarCampos() {
        String descricao = jTextAreaDescricao.getText();
        String nome = jTextFieldNome.getText();

        if (nome.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe um nome do  cronometrista.");
            return false;
        }
        if (descricao.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe uma descricao");
            return false;

        } else {
            return true;
        }

    }

//metodo que recebe o tempo q o microondas vai aquecer o alimento
    private void iniciarCronometro() {
        ActionListener action = (ActionEvent e) -> {
            currentMilessimo++;
            if (currentMilessimo == 1000) {
                currentSegundo++;
                currentMilessimo = 0;
            }
            if (currentSegundo == 60) {
                currentMinuto++;
                currentSegundo = 0;
            }

            if (currentMinuto == 60) {
                currentHora++;
                currentMinuto = 0;
            }

            String hr = currentHora <= 9 ? "0" + currentHora : currentHora + "";
            String min = currentMinuto <= 9 ? "0" + currentMinuto : currentMinuto + "";
            String seg = currentSegundo <= 9 ? "0" + currentSegundo : currentSegundo + "";
            String mil = currentMilessimo <= 9 ? "00" + currentMilessimo : currentMilessimo + "";
            jLabelCronometro.setText(hr + ":" + min + ":" + seg + ":" + mil);
        };
        this.timer = new Timer(velocidade, action);
        this.timer.start();
    }

    private void stopTime() {
        timer.stop();
        currentHora = 0;
        currentMinuto = 0;
        currentSegundo = 0;
        currentMilessimo = 0;
        jLabelCronometro.setText("00:00:00:000");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelarCadastroTomada;
    private javax.swing.JButton jButtonCancelarTomada;
    private javax.swing.JButton jButtonFim;
    private javax.swing.JButton jButtonIniciarTomada;
    private javax.swing.JButton jButtonInicio;
    private javax.swing.JButton jButtonProximaTomada;
    private javax.swing.JButton jButtonProximoElemento;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelCronometro;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelDescricaoTomada;
    private javax.swing.JLabel jLabelHora;
    private javax.swing.JLabel jLabelInsertCodigo;
    private javax.swing.JLabel jLabelInsertData;
    private javax.swing.JLabel jLabelInsertDescricao;
    private javax.swing.JLabel jLabelInsertHora;
    private javax.swing.JLabel jLabelInsertNome;
    private javax.swing.JLabel jLabelInsertProduto;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNomeCronometrista;
    private javax.swing.JLabel jLabelProduto;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTitulo1;
    private javax.swing.JLabel jLabelTituloTomada;
    private javax.swing.JPanel jPanelCadastroTomada;
    private javax.swing.JPanel jPanelListaOperacao;
    private javax.swing.JPanel jPanelTomadaDeTempo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableElementos;
    private javax.swing.JTable jTableListaOperacao;
    private javax.swing.JTextArea jTextAreaDescricao;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
///site onde busquei modelo de Cronometro
//http://procode-java.blogspot.com/2014/07/fato-criando-um-cronometro-em-java.html
