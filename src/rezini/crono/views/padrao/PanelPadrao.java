/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rezini.crono.views.padrao;

import java.awt.CardLayout;

/**
 *
 * @author ivan rezini
 */
public class PanelPadrao extends javax.swing.JPanel {

    private CardLayout cl;

    /**
     * Creates new form PanelPadrao
     */
    public PanelPadrao() {
        initComponents();
        this.cl = (CardLayout) this.getLayout();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 255, 0));
        setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 0)));
        setForeground(new java.awt.Color(51, 51, 255));
        setPreferredSize(new java.awt.Dimension(750, 500));
        setLayout(new java.awt.CardLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tela Padrão");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setMaximumSize(new java.awt.Dimension(216, 44));
        jLabel1.setMinimumSize(new java.awt.Dimension(216, 44));
        jLabel1.setPreferredSize(new java.awt.Dimension(750, 44));
        jLabel1.setRequestFocusEnabled(false);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        add(jLabel1, "card2");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
