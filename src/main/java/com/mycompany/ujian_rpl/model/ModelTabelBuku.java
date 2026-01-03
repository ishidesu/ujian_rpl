/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ujian_rpl.model;

/**
 *
 * @author Ishi
 */
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ModelTabelBuku extends AbstractTableModel {
    private List<ModelBuku> bukuList;
    private String[] columnNames = {"ID", "ISBN", "Judul", "Penulis", "Genre", "Jenis", "Status"};

    public ModelTabelBuku(List<ModelBuku> bukuList) {
        this.bukuList = bukuList;
    }

    @Override
    public int getRowCount() {
        return bukuList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModelBuku buku = bukuList.get(rowIndex);
        switch (columnIndex) {
            case 0: return buku.getId();
            case 1: return buku.getIsbn();
            case 2: return buku.getJudul();
            case 3: return buku.getPenulis();
            case 4: return buku.getGenre();
            case 5: return buku.getJenisBuku();
            case 6: return buku.getStatus();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void setBukuList(List<ModelBuku> bukuList) {
        this.bukuList = bukuList;
        fireTableDataChanged();
    }
}
