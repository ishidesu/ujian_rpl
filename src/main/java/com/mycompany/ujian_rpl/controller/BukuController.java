/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ujian_rpl.controller;

/**
 *
 * @author Ishi
 */
import com.mycompany.ujian_rpl.model.ModelBuku;
import com.mycompany.ujian_rpl.service.BukuService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BukuController {

    @Autowired
    private BukuService bukuService;

    public void addBuku(ModelBuku buku) {
        bukuService.addBuku(buku);
    }

    public void deleteBuku(int id) {
        bukuService.deleteBuku(id);
    }

    public List<ModelBuku> getAllBuku() {
        return bukuService.getAllBuku();
    }
}
