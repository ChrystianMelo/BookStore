/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.bookstore.gui;

import com.mycompany.bookstore.Book;

/**
 *
 */
public class BookDetails extends javax.swing.JPanel {

    /**
     * Creates new form BookDetails
     */
    public BookDetails(Book book) {
        initComponents();
        titleLabel.setText(book.getName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        coverImgLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(500, 50));
        setMinimumSize(new java.awt.Dimension(500, 50));
        setPreferredSize(new java.awt.Dimension(500, 50));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEADING, 10, 0);
        flowLayout1.setAlignOnBaseline(true);
        setLayout(flowLayout1);

        coverImgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon50x50.png"))); // NOI18N
        add(coverImgLabel);

        titleLabel.setText("TitleTitleTitleTitleTitleTitleTitleTitleTitleTitleTitleTitleTitleTitleTitleTitleTitle");
        add(titleLabel);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel coverImgLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
