/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.bookstore.gui;

import com.mycompany.bookstore.*;
import java.awt.Component;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 */
public class BookList extends javax.swing.JPanel {

    /**
     * Creates new form BookList
     */
    public BookList(ArrayList<Book> books) {
        initComponents();

        DefaultListModel<BookDetails> listModel = new DefaultListModel<>();
        for (Book b : books) {
            listModel.addElement(new BookDetails(b));
        }

        FlowLayout layoyt = new FlowLayout();
        layoyt.setAlignment(FlowLayout.LEADING);
        jList2.setLayout(layoyt);

        jList2.setModel(listModel);
        jList2.setCellRenderer(new ListCellRenderer<BookDetails>() {
            @Override
            public Component getListCellRendererComponent(JList<? extends BookDetails> list, BookDetails bookDetails, int index, boolean isSelected, boolean cellHasFocus) {
                return bookDetails;
            }
        });

        jList2.revalidate();
        jList2.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();

        setMaximumSize(new java.awt.Dimension(500, 315));
        setMinimumSize(new java.awt.Dimension(500, 315));
        setPreferredSize(new java.awt.Dimension(500, 315));

        jList2.setMaximumSize(new java.awt.Dimension(500, 315));
        jList2.setMinimumSize(new java.awt.Dimension(500, 315));
        jList2.setPreferredSize(new java.awt.Dimension(500, 315));
        jScrollPane2.setViewportView(jList2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 315, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<BookDetails> jList2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
