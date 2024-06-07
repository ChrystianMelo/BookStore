/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.bookstore.gui;

import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chrystian Melo
 */
public class BookStoreGUI extends javax.swing.JFrame {

    /**
     * Creates new form BookStore
     */
    public BookStoreGUI() {
        initComponents();
        addListeners();
    }

    private void addListeners() {
        cartIBtnLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        userBtnLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        searchBtnLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        githubBtnLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/ChrystianMelo/BookStore?tab=readme-ov-file#bookstore"));
                } catch (MalformedURLException ex) {
                    Logger.getLogger(BookStoreGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (URISyntaxException ex) {
                    Logger.getLogger(BookStoreGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(BookStoreGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        headerPane = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cartIBtnLabel = new javax.swing.JLabel();
        userBtnLabel = new javax.swing.JLabel();
        bodyPane = new javax.swing.JPanel();
        searchPane = new javax.swing.JPanel();
        searchTextField = new javax.swing.JTextField();
        searchBtnLabel = new javax.swing.JLabel();
        contentPane = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        footerPane = new javax.swing.JPanel();
        footer = new javax.swing.JLabel();
        githubBtnLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(550, 550));
        setMinimumSize(new java.awt.Dimension(550, 550));
        setPreferredSize(new java.awt.Dimension(550, 550));
        setResizable(false);
        setSize(new java.awt.Dimension(550, 550));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        headerPane.setMaximumSize(new java.awt.Dimension(500, 50));
        headerPane.setMinimumSize(new java.awt.Dimension(500, 50));
        headerPane.setPreferredSize(new java.awt.Dimension(500, 50));
        headerPane.setLayout(new java.awt.GridBagLayout());

        titleLabel.setText("Book Store (v1.0)");
        titleLabel.setMaximumSize(new java.awt.Dimension(250, 50));
        titleLabel.setMinimumSize(new java.awt.Dimension(250, 50));
        titleLabel.setPreferredSize(new java.awt.Dimension(250, 50));
        headerPane.add(titleLabel, new java.awt.GridBagConstraints());

        jPanel2.setMaximumSize(new java.awt.Dimension(250, 50));
        jPanel2.setMinimumSize(new java.awt.Dimension(250, 50));
        jPanel2.setPreferredSize(new java.awt.Dimension(250, 50));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.TRAILING, 20, 0);
        flowLayout1.setAlignOnBaseline(true);
        jPanel2.setLayout(flowLayout1);

        cartIBtnLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cartIBtnLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cart50x50.png"))); // NOI18N
        cartIBtnLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cartIBtnLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cartIBtnLabel.setMaximumSize(new java.awt.Dimension(50, 50));
        cartIBtnLabel.setMinimumSize(new java.awt.Dimension(50, 50));
        cartIBtnLabel.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel2.add(cartIBtnLabel);

        userBtnLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userBtnLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user50x50.png"))); // NOI18N
        userBtnLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        userBtnLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        userBtnLabel.setMaximumSize(new java.awt.Dimension(50, 50));
        userBtnLabel.setMinimumSize(new java.awt.Dimension(50, 50));
        userBtnLabel.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel2.add(userBtnLabel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        headerPane.add(jPanel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(headerPane, gridBagConstraints);
        headerPane.getAccessibleContext().setAccessibleName("headerPane");

        bodyPane.setMaximumSize(new java.awt.Dimension(500, 400));
        bodyPane.setMinimumSize(new java.awt.Dimension(500, 400));
        bodyPane.setPreferredSize(new java.awt.Dimension(500, 400));
        bodyPane.setLayout(new java.awt.GridBagLayout());

        searchPane.setMaximumSize(new java.awt.Dimension(500, 20));
        searchPane.setMinimumSize(new java.awt.Dimension(500, 20));
        searchPane.setPreferredSize(new java.awt.Dimension(500, 20));
        searchPane.setLayout(new java.awt.GridBagLayout());

        searchTextField.setText("Search...");
        searchTextField.setAutoscrolls(false);
        searchTextField.setInheritsPopupMenu(true);
        searchTextField.setKeymap(null);
        searchTextField.setMargin(new java.awt.Insets(0, 0, 0, 0));
        searchTextField.setMaximumSize(new java.awt.Dimension(480, 20));
        searchTextField.setMinimumSize(new java.awt.Dimension(480, 20));
        searchTextField.setPreferredSize(new java.awt.Dimension(480, 20));
        searchTextField.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        searchPane.add(searchTextField, gridBagConstraints);

        searchBtnLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search20x20.png"))); // NOI18N
        searchBtnLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchBtnLabel.setMaximumSize(new java.awt.Dimension(20, 20));
        searchBtnLabel.setMinimumSize(new java.awt.Dimension(20, 20));
        searchBtnLabel.setPreferredSize(new java.awt.Dimension(20, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        searchPane.add(searchBtnLabel, gridBagConstraints);

        bodyPane.add(searchPane, new java.awt.GridBagConstraints());

        contentPane.setMaximumSize(new java.awt.Dimension(500, 350));
        contentPane.setMinimumSize(new java.awt.Dimension(500, 350));
        contentPane.setPreferredSize(new java.awt.Dimension(500, 350));
        contentPane.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Conteudo");
        contentPane.add(jLabel1, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        bodyPane.add(contentPane, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        getContentPane().add(bodyPane, gridBagConstraints);
        bodyPane.getAccessibleContext().setAccessibleName("bodyPane");

        footerPane.setMaximumSize(new java.awt.Dimension(500, 50));
        footerPane.setMinimumSize(new java.awt.Dimension(500, 50));
        footerPane.setPreferredSize(new java.awt.Dimension(500, 50));
        footerPane.setLayout(new java.awt.GridBagLayout());

        footer.setText("Developed for a Software Testing project");
        footer.setMaximumSize(new java.awt.Dimension(450, 50));
        footer.setMinimumSize(new java.awt.Dimension(450, 50));
        footer.setPreferredSize(new java.awt.Dimension(450, 50));
        footerPane.add(footer, new java.awt.GridBagConstraints());

        githubBtnLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/github50x50.png"))); // NOI18N
        githubBtnLabel.setToolTipText("");
        githubBtnLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        githubBtnLabel.setMaximumSize(new java.awt.Dimension(50, 50));
        githubBtnLabel.setMinimumSize(new java.awt.Dimension(50, 50));
        githubBtnLabel.setPreferredSize(new java.awt.Dimension(50, 50));
        footerPane.add(githubBtnLabel, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        getContentPane().add(footerPane, gridBagConstraints);
        footerPane.getAccessibleContext().setAccessibleName("footerPane");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(BookStoreGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookStoreGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookStoreGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookStoreGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookStoreGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyPane;
    private javax.swing.JLabel cartIBtnLabel;
    private javax.swing.JPanel contentPane;
    private javax.swing.JLabel footer;
    private javax.swing.JPanel footerPane;
    private javax.swing.JLabel githubBtnLabel;
    private javax.swing.JPanel headerPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel searchBtnLabel;
    private javax.swing.JPanel searchPane;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel userBtnLabel;
    // End of variables declaration//GEN-END:variables
}
