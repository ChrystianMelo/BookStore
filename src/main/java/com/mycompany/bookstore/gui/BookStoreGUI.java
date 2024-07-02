/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.bookstore.gui;

import com.mycompany.bookstore.*;
import com.mycompany.bookstore.db.BookStoreDatabaseUtils;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 */
public class BookStoreGUI extends javax.swing.JFrame {

    /**
     * Livraria.
     */
    private final BookStore store;

    /**
     * Painel central do usuário.
     */
    private JPanel userPanel;

    /**
     * Creates new form BookStore
     */
    public BookStoreGUI(BookStore store) {
        initComponents();
        addListeners();
        try {
            setIconImage(ImageIO.read(BookStoreGUI.class.getResourceAsStream("/icon50x50.png")));
        } catch (IOException ex) {
            Logger.getLogger(BookStoreGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.store = store;

        revalidate();
        repaint();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    BookStoreDatabaseUtils.writeCustomers(store.getCostumers());
                    BookStoreDatabaseUtils.writeSuppliers(store.getSuppliers());
                } catch (URISyntaxException ex) {
                    System.out.println("ERROR");
                }
            }
        });
    }

    @Override
    public void repaint() {
        if (store.getUser() instanceof Customer) {
            userPanel = new CustomerPanel(store);

            stockBtnLabel.setVisible(false);
            cartIBtnLabel.setVisible(true);
        } else {
            userPanel = new SupplierPanel(store);

            stockBtnLabel.setVisible(true);
            cartIBtnLabel.setVisible(false);
        }

        contentPane.removeAll();
        contentPane.add(userPanel);
        contentPane.revalidate();
        contentPane.repaint();

        super.repaint();
    }

    /**
     *
     */
    private void addListeners() {
        searchTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    for (MouseListener l : searchBtnLabel.getMouseListeners()) {
                        l.mouseClicked(null);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        userBtnLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LoginDialog login = new LoginDialog(BookStoreGUI.this, true);
                login.setLocationRelativeTo(BookStoreGUI.this);
                login.setVisible(true);

                User user = login.getUser();
                if (user != null) {
                    store.setUser(user);

                    try {
                        if (user instanceof Customer) {
                            store.addCostumer((Customer) user);
                        } else {
                            store.addSupplier((Supplier) user);
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(BookStoreGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    revalidate();
                    repaint();
                }

            }
        });

        cartIBtnLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                User user = store.getUser();
                assert (user instanceof Customer);

                Customer customer = (Customer) user;

                JDialog dialog = new JDialog(BookStoreGUI.this, "Cart", true);
                dialog.setLocationRelativeTo(BookStoreGUI.this);
                dialog.setLayout(new FlowLayout());
                dialog.setSize(500, 400);
                dialog.add(new BookList(store, customer.getCart().getBooks()));

                dialog.setVisible(true);
            }
        });

        stockBtnLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                User user = store.getUser();
                assert (user instanceof Supplier);

                Supplier supplier = (Supplier) user;

                BookRegisterDialog login = new BookRegisterDialog(BookStoreGUI.this, true);
                login.setLocationRelativeTo(BookStoreGUI.this);
                login.setVisible(true);

                Map.Entry<Book, Integer> book = login.getBook();
                if (book != null) {
                    try {
                        supplier.registerBook(book.getKey(), book.getValue());
                    } catch (Exception ex) {
                        Logger.getLogger(BookStoreGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                revalidate();
                repaint();
            }
        });

        searchBtnLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JDialog dialog = new JDialog(BookStoreGUI.this, "ERROR", true);
                dialog.setLocationRelativeTo(BookStoreGUI.this);
                dialog.setLayout(new FlowLayout());
                dialog.setSize(400, 100);
                dialog.add(new JLabel("Por enquanto não é possivel fazer pesquisa."));

                dialog.setVisible(true);
                //userPanel.setFilter(null);
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
        jPanel2 = new javax.swing.JPanel();
        stockBtnLabel = new javax.swing.JLabel();
        cartIBtnLabel = new javax.swing.JLabel();
        userBtnLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bodyPane = new javax.swing.JPanel();
        searchPane = new javax.swing.JPanel();
        searchTextField = new javax.swing.JTextField();
        searchBtnLabel = new javax.swing.JLabel();
        contentPane = new javax.swing.JPanel();
        footerPane = new javax.swing.JPanel();
        footer = new javax.swing.JLabel();
        githubBtnLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Book Store - Library Management System");
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

        jPanel2.setMaximumSize(new java.awt.Dimension(250, 50));
        jPanel2.setMinimumSize(new java.awt.Dimension(250, 50));
        jPanel2.setPreferredSize(new java.awt.Dimension(250, 50));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.TRAILING, 0, 0);
        flowLayout1.setAlignOnBaseline(true);
        jPanel2.setLayout(flowLayout1);

        stockBtnLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cloud30x30.png"))); // NOI18N
        stockBtnLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stockBtnLabel.setOpaque(true);
        jPanel2.add(stockBtnLabel);

        cartIBtnLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cartIBtnLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cart30x30.png"))); // NOI18N
        cartIBtnLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cartIBtnLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cartIBtnLabel.setMaximumSize(new java.awt.Dimension(50, 50));
        cartIBtnLabel.setMinimumSize(new java.awt.Dimension(50, 50));
        cartIBtnLabel.setOpaque(true);
        cartIBtnLabel.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel2.add(cartIBtnLabel);

        userBtnLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userBtnLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user30x30.png"))); // NOI18N
        userBtnLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        userBtnLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        userBtnLabel.setMaximumSize(new java.awt.Dimension(50, 50));
        userBtnLabel.setMinimumSize(new java.awt.Dimension(50, 50));
        userBtnLabel.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel2.add(userBtnLabel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        headerPane.add(jPanel2, gridBagConstraints);

        jPanel1.setAutoscrolls(true);
        jPanel1.setMaximumSize(new java.awt.Dimension(250, 50));
        jPanel1.setMinimumSize(new java.awt.Dimension(250, 50));
        jPanel1.setPreferredSize(new java.awt.Dimension(250, 50));
        java.awt.FlowLayout flowLayout2 = new java.awt.FlowLayout(java.awt.FlowLayout.LEADING, 0, 0);
        flowLayout2.setAlignOnBaseline(true);
        jPanel1.setLayout(flowLayout2);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon50x50.png"))); // NOI18N
        jPanel1.add(jLabel2);

        jLabel3.setText(" Book Store");
        jPanel1.add(jLabel3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        headerPane.add(jPanel1, gridBagConstraints);

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
        searchPane.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING, 0, 0));

        searchTextField.setMargin(new java.awt.Insets(0, 0, 0, 0));
        searchTextField.setMaximumSize(new java.awt.Dimension(480, 20));
        searchTextField.setMinimumSize(new java.awt.Dimension(480, 20));
        searchTextField.setName(""); // NOI18N
        searchTextField.setPreferredSize(new java.awt.Dimension(480, 20));
        searchPane.add(searchTextField);

        searchBtnLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search20x20.png"))); // NOI18N
        searchBtnLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchBtnLabel.setMaximumSize(new java.awt.Dimension(20, 20));
        searchBtnLabel.setMinimumSize(new java.awt.Dimension(20, 20));
        searchBtnLabel.setPreferredSize(new java.awt.Dimension(20, 20));
        searchPane.add(searchBtnLabel);

        bodyPane.add(searchPane, new java.awt.GridBagConstraints());

        contentPane.setToolTipText("");
        contentPane.setMaximumSize(new java.awt.Dimension(500, 350));
        contentPane.setMinimumSize(new java.awt.Dimension(500, 350));
        contentPane.setPreferredSize(new java.awt.Dimension(500, 350));
        contentPane.setLayout(new java.awt.GridBagLayout());
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyPane;
    private javax.swing.JLabel cartIBtnLabel;
    private javax.swing.JPanel contentPane;
    private javax.swing.JLabel footer;
    private javax.swing.JPanel footerPane;
    private javax.swing.JLabel githubBtnLabel;
    private javax.swing.JPanel headerPane;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel searchBtnLabel;
    private javax.swing.JPanel searchPane;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JLabel stockBtnLabel;
    private javax.swing.JLabel userBtnLabel;
    // End of variables declaration//GEN-END:variables
}
