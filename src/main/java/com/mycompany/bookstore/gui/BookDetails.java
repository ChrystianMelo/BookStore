/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.bookstore.gui;

import com.mycompany.bookstore.Book;
import com.mycompany.bookstore.BookStore;
import com.mycompany.bookstore.Customer;
import com.mycompany.bookstore.User;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class BookDetails extends javax.swing.JPanel {

    /**
     *
     */
    private final BookStore store;

    /**
     *
     */
    private final Book book;

    /**
     * Creates new form BookDetails
     */
    public BookDetails(BookStore store, Map.Entry<Book, Integer> entry) {
        this.store = store;
        this.book = entry.getKey();

        initComponents();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point p = e.getPoint();

                // Reaja com base no componente clicado
                if (starLabel.getBounds().contains(p)) {
                    for (MouseListener l : starLabel.getMouseListeners()) {
                        l.mouseClicked(e);
                    }
                } else if (cartLabel.getBounds().contains(new Point(p.x - jPanel1.getWidth(), p.y))) {
                    for (MouseListener l : cartLabel.getMouseListeners()) {
                        l.mouseClicked(e);
                    }
                } else {
                    System.out.println("Book detail clicked");
                }

            }
        });

        titleLabel.setText(book.getName());
        quantityLabel.setText(String.valueOf(entry.getValue()));
        supplierLabel.setText("By Amazon");
        valueLabel1.setText(String.valueOf(book.getValue()));

        starLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Customer customer = (Customer) store.getUser();

                ArrayList<Book> favorites = customer.getFavorites();
                if (favorites.contains(book)) {
                    favorites.remove(book);
                } else {
                    favorites.add(book);
                }

                revalidate();
                repaint();
            }
        });

        cartLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Customer customer = (Customer) store.getUser();

                try {
                    customer.addBook(book, 1);
                } catch (Exception ex) {
                    Logger.getLogger(BookDetails.class.getName()).log(Level.SEVERE, null, ex);
                }

                revalidate();
                repaint();
            }
        });

        revalidate();
        repaint();
    }

    @Override

    public void repaint() {
        if (store != null) { //BUG Fixes
            User user = store.getUser();
            if (user instanceof Customer) {
                starLabel.setVisible(true);
                cartLabel.setVisible(true);

                boolean isStarred = ((Customer) user).getFavorites().contains(book);
                starLabel.setEnabled(isStarred);
            } else {
                starLabel.setVisible(false);
                cartLabel.setVisible(false);
            }
        }
        super.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        coverImgLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        starLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        quantityLabel = new javax.swing.JLabel();
        valueLabel1 = new javax.swing.JLabel();
        supplierLabel = new javax.swing.JLabel();
        cartLabel = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(500, 50));
        setMinimumSize(new java.awt.Dimension(500, 50));
        setPreferredSize(new java.awt.Dimension(500, 50));
        setLayout(new java.awt.GridBagLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(250, 50));
        jPanel1.setMinimumSize(new java.awt.Dimension(250, 50));
        jPanel1.setPreferredSize(new java.awt.Dimension(250, 50));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        coverImgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon50x50.png"))); // NOI18N
        jPanel1.add(coverImgLabel);

        titleLabel.setText("Title");
        jPanel1.add(titleLabel);

        starLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/starFilled24x24.png"))); // NOI18N
        starLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        starLabel.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/star24x24.png"))); // NOI18N
        starLabel.setEnabled(false);
        jPanel1.add(starLabel);

        add(jPanel1, new java.awt.GridBagConstraints());

        jPanel2.setMaximumSize(new java.awt.Dimension(250, 50));
        jPanel2.setMinimumSize(new java.awt.Dimension(250, 50));
        jPanel2.setPreferredSize(new java.awt.Dimension(250, 50));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        quantityLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quantityLabel.setText("1");
        quantityLabel.setToolTipText("");
        quantityLabel.setMaximumSize(new java.awt.Dimension(20, 50));
        quantityLabel.setMinimumSize(new java.awt.Dimension(20, 50));
        quantityLabel.setOpaque(true);
        quantityLabel.setPreferredSize(new java.awt.Dimension(20, 50));
        jPanel2.add(quantityLabel);

        valueLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valueLabel1.setText("RS 1.00");
        valueLabel1.setMaximumSize(new java.awt.Dimension(50, 50));
        valueLabel1.setMinimumSize(new java.awt.Dimension(50, 50));
        valueLabel1.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel2.add(valueLabel1);

        supplierLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        supplierLabel.setText("by Amazon");
        supplierLabel.setMaximumSize(new java.awt.Dimension(100, 50));
        supplierLabel.setMinimumSize(new java.awt.Dimension(100, 50));
        supplierLabel.setPreferredSize(new java.awt.Dimension(100, 50));
        jPanel2.add(supplierLabel);

        cartLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cartLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addToCart24x24.png"))); // NOI18N
        cartLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cartLabel.setMaximumSize(new java.awt.Dimension(30, 50));
        cartLabel.setMinimumSize(new java.awt.Dimension(30, 50));
        cartLabel.setPreferredSize(new java.awt.Dimension(30, 50));
        jPanel2.add(cartLabel);

        add(jPanel2, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cartLabel;
    private javax.swing.JLabel coverImgLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JLabel starLabel;
    private javax.swing.JLabel supplierLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel valueLabel1;
    // End of variables declaration//GEN-END:variables
}
