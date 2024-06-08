/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.bookstore.gui;

import java.awt.FlowLayout;

/**
 *
 */
public class CustomerPanel extends javax.swing.JPanel {

    /**
     * Creates new form CostumerPanel
     */
    public CustomerPanel() {
        initComponents();

        allBooksPane.setLayout(new FlowLayout());
        allBooksPane.add(new BookList(null));

        starredBooksPane.setLayout(new FlowLayout());
        starredBooksPane.add(new BookList(null));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        allBooksPane = new javax.swing.JPanel();
        starredBooksPane = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(500, 350));
        setMinimumSize(new java.awt.Dimension(500, 350));
        setPreferredSize(new java.awt.Dimension(500, 350));

        tabbedPane.setMaximumSize(new java.awt.Dimension(500, 350));
        tabbedPane.setMinimumSize(new java.awt.Dimension(500, 350));
        tabbedPane.setPreferredSize(new java.awt.Dimension(500, 350));

        javax.swing.GroupLayout allBooksPaneLayout = new javax.swing.GroupLayout(allBooksPane);
        allBooksPane.setLayout(allBooksPaneLayout);
        allBooksPaneLayout.setHorizontalGroup(
            allBooksPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        allBooksPaneLayout.setVerticalGroup(
            allBooksPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 315, Short.MAX_VALUE)
        );

        tabbedPane.addTab("All", allBooksPane);

        javax.swing.GroupLayout starredBooksPaneLayout = new javax.swing.GroupLayout(starredBooksPane);
        starredBooksPane.setLayout(starredBooksPaneLayout);
        starredBooksPaneLayout.setHorizontalGroup(
            starredBooksPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        starredBooksPaneLayout.setVerticalGroup(
            starredBooksPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 315, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Starred", starredBooksPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel allBooksPane;
    private javax.swing.JPanel starredBooksPane;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
}
