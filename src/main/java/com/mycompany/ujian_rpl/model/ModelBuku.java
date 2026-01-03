/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ujian_rpl.model;

/**
 *
 * @author Ishi
 */
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity 
public class ModelBuku {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String isbn;      
    private String judul;     
    private String penulis;   
    private String genre;     
    private String jenisBuku;
    private String status; 

    public ModelBuku(String isbn, String judul, String penulis, String genre, String jenisBuku, String status) {
        this.isbn = isbn;
        this.judul = judul;
        this.penulis = penulis;
        this.genre = genre;
        this.jenisBuku = jenisBuku;
        this.status = status;
    }
}
