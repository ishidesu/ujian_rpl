/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ujian_rpl.view;

/**
 *
 * @author Ishi
 */
import com.mycompany.ujian_rpl.controller.BukuController;
import com.mycompany.ujian_rpl.model.ModelBuku;
import com.mycompany.ujian_rpl.model.ModelTabelBuku;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GradientPaint;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.awt.EventQueue;

@Component
public class BukuView extends javax.swing.JFrame {

    private BukuController controller;

    // --- 1. DEKLARASI VARIABEL ---
    private javax.swing.JButton buangButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton simpanButton;
    private javax.swing.JTable dataTable;
    
    private javax.swing.JTextField isbnField;
    private javax.swing.JTextField judulField;
    private javax.swing.JTextField penulisField;
    private javax.swing.JTextField genreField;
    private javax.swing.JComboBox<String> statusCombo;
    private javax.swing.JComboBox<String> jenisCombo;

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelForm;
    private javax.swing.JPanel panelTombol;
    private javax.swing.JPanel panelTabel;

    // --- 2. KONTRAKTOR DAN LOGIKA PEMUATAN DATA ---
    
    @Autowired
    public BukuView(BukuController controller) {
        this.controller = controller;
        initCustomComponents();
        loadBukuTable();

        setTitle("Ujian RPL - Pengelolaan Koleksi Buku");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

    private BukuView() {
        throw new UnsupportedOperationException("Gunakan constructor dengan autowired controller.");
    }

    public void loadBukuTable() {
        List<ModelBuku> listBuku = controller.getAllBuku();

        ModelTabelBuku tableModel = new ModelTabelBuku(listBuku);

        dataTable.setModel(tableModel);
    }
    
    private void initCustomComponents() {
        
        // Font standar untuk tampilan profesional
        Font labelFont = new Font("Segoe UI", Font.BOLD, 14);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 14);
        Font buttonFont = new Font("Segoe UI", Font.BOLD, 12);
        
        // Warna
        Color labelColor = new Color(50, 50, 70);
        Color buttonColor = new Color(0, 123, 255); // Biru
        Color buttonColorHover = new Color(0, 105, 217);
        Color deleteColor = new Color(220, 53, 69); // Merah
        Color deleteColorHover = new Color(200, 35, 51);
        Color refreshColor = new Color(23, 162, 184); // Cyan
        Color refreshColorHover = new Color(19, 132, 150);

        // Panel Utama dengan Gradasi
        class GradientPanel extends JPanel {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int w = getWidth();
                int h = getHeight();
                Color color1 = new Color(230, 240, 255);
                Color color2 = Color.WHITE;
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        }
        
        JPanel mainPanel = new GradientPanel();
        mainPanel.setLayout(new BorderLayout(15, 15)); 
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 
        this.setContentPane(mainPanel);

        // === Panel Form (Kiri/Atas) ===
        panelForm = new JPanel(new GridBagLayout());
        panelForm.setOpaque(false); 
        panelForm.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Input Data Koleksi Buku",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new Font("Segoe UI", Font.BOLD, 16), labelColor));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8); 
        gbc.anchor = GridBagConstraints.LINE_START; 

        // 1. Label & Field ISBN
        jLabel1 = new JLabel("ISBN");
        jLabel1.setFont(labelFont);
        jLabel1.setForeground(labelColor);
        gbc.gridx = 0; gbc.gridy = 0;
        panelForm.add(jLabel1, gbc);

        isbnField = new JTextField(20);
        isbnField.setFont(fieldFont);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        panelForm.add(isbnField, gbc);

        // 2. Label & Field JUDUL
        jLabel2 = new JLabel("JUDUL");
        jLabel2.setFont(labelFont);
        jLabel2.setForeground(labelColor);
        gbc.gridx = 0; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        panelForm.add(jLabel2, gbc);

        judulField = new JTextField(20);
        judulField.setFont(fieldFont);
        gbc.gridx = 1; gbc.gridy = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        panelForm.add(judulField, gbc);

        // 3. Label & Field PENULIS
        jLabel3 = new JLabel("PENULIS");
        jLabel3.setFont(labelFont);
        jLabel3.setForeground(labelColor);
        gbc.gridx = 0; gbc.gridy = 2; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        panelForm.add(jLabel3, gbc);

        penulisField = new JTextField(20);
        penulisField.setFont(fieldFont);
        gbc.gridx = 1; gbc.gridy = 2; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        panelForm.add(penulisField, gbc);

        // 4. Label & Field GENRE
        jLabel4 = new JLabel("GENRE");
        jLabel4.setFont(labelFont);
        jLabel4.setForeground(labelColor);
        gbc.gridx = 0; gbc.gridy = 3; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        panelForm.add(jLabel4, gbc);

        genreField = new JTextField(20);
        genreField.setFont(fieldFont);
        gbc.gridx = 1; gbc.gridy = 3; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        panelForm.add(genreField, gbc);

        // 5. Label & Combo JENIS BUKU
        JLabel labelJenis = new JLabel("JENIS BUKU");
        labelJenis.setFont(labelFont);
        labelJenis.setForeground(labelColor);
        gbc.gridx = 0; gbc.gridy = 4; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        panelForm.add(labelJenis, gbc);

        jenisCombo = new JComboBox<>(new String[]{"Komik", "Novel"});
        jenisCombo.setFont(fieldFont);
        gbc.gridx = 1; gbc.gridy = 4; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        panelForm.add(jenisCombo, gbc);

        // 6. Label & Field STOK
        JLabel labelStok = new JLabel("STATUS");
        labelStok.setFont(labelFont);
        labelStok.setForeground(labelColor);
        gbc.gridx = 0; gbc.gridy = 5; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        panelForm.add(labelStok, gbc);

        statusCombo = new JComboBox<>(new String[]{"Membaca", "Selesai Membaca"});
        statusCombo.setFont(fieldFont);
        gbc.gridx = 1; gbc.gridy = 5; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        panelForm.add(statusCombo, gbc);

        // === Panel Tombol ===
        panelTombol = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        panelTombol.setOpaque(false);
        gbc.gridx = 1; gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.LINE_START;
        panelForm.add(panelTombol, gbc);

        simpanButton = new JButton("Simpan");
        styleButton(simpanButton, buttonFont, buttonColor, buttonColorHover);
        
        refreshButton = new JButton("Refresh");
        styleButton(refreshButton, buttonFont, refreshColor, refreshColorHover);

        buangButton = new JButton("Buang");
        styleButton(buangButton, buttonFont, deleteColor, deleteColorHover);

        panelTombol.add(simpanButton);
        panelTombol.add(refreshButton);
        panelTombol.add(buangButton);
        
        mainPanel.add(panelForm, BorderLayout.NORTH);

        // === Panel Tabel ===
        panelTabel = new JPanel(new BorderLayout());
        panelTabel.setOpaque(false);
        panelTabel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Data Koleksi Buku",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new Font("Segoe UI", Font.BOLD, 16), labelColor));
        
        jScrollPane1 = new JScrollPane();
        dataTable = new JTable();
        
        // Styling Tabel
        dataTable.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        dataTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        dataTable.getTableHeader().setBackground(new Color(230, 230, 230));
        dataTable.setRowHeight(25);
        dataTable.setGridColor(new Color(220, 220, 220));
        dataTable.setSelectionBackground(new Color(0, 123, 255));
        dataTable.setSelectionForeground(Color.WHITE);
        
        jScrollPane1.setViewportView(dataTable);
        jScrollPane1.setPreferredSize(new Dimension(800, 300)); 
        
        panelTabel.add(jScrollPane1, BorderLayout.CENTER);
        mainPanel.add(panelTabel, BorderLayout.CENTER);

        // --- 3. KODE EVENT LISTENER TOMBOL ---
        
        simpanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    String isbn = getIsbnField().getText();
                    String judul = getJudulField().getText();
                    String penulis = getPenulisField().getText();
                    String genre = getGenreField().getText();
                    String jenis = jenisCombo.getSelectedItem().toString();
                    String status = statusCombo.getSelectedItem().toString();


                    ModelBuku buku = new ModelBuku(isbn, judul, penulis, genre, jenis, status);
                    
                    // Console logging seperti kode awal
                    System.out.println("Judul: " + buku.getJudul());
                    System.out.println("ISBN: " + buku.getIsbn());
                    System.out.println("Jenis: " + buku.getJenisBuku());
                    System.out.println("Stok: " + buku.getStatus());

                    controller.addBuku(buku);
                    loadBukuTable();
                    
                    // Bersihkan form
                    getIsbnField().setText("");
                    getJudulField().setText("");
                    getPenulisField().setText("");
                    getGenreField().setText("");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(BukuView.this, "Stok harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                loadBukuTable();
            }
        });

        buangButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                JTextField idField = new JTextField(10);
                idField.setFont(fieldFont);

                JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                JLabel promptLabel = new JLabel("Masukkan ID Buku yang ingin dihapus:");
                promptLabel.setFont(labelFont);
                panel.add(promptLabel);
                panel.add(idField);

                int result = JOptionPane.showConfirmDialog(BukuView.this, panel,
                        "Hapus Buku", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (result == JOptionPane.OK_OPTION) {
                    try {
                        int id = Integer.parseInt(idField.getText());
                        controller.deleteBuku(id);
                        JOptionPane.showMessageDialog(BukuView.this, "Data berhasil dihapus.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                        loadBukuTable();
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(BukuView.this, "ID harus berupa angka.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    private void styleButton(JButton button, Font font, Color background, Color hover) {
        button.setFont(font);
        button.setBackground(background);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(hover);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(background);
            }
        });
    }
    
    public JTextField getIsbnField() {
        return isbnField;
    }

    public JTextField getJudulField() {
        return judulField;
    }

    public JTextField getPenulisField() {
        return penulisField;
    }

    public JTextField getGenreField() {
        return genreField;
    }

}
