/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ujian_rpl.service;

/**
 *
 * @author Ishi
 */
import com.mycompany.ujian_rpl.model.ModelBuku;
import com.mycompany.ujian_rpl.repository.BukuRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BukuService {

    @Autowired
    private BukuRepository repository;

    public void addBuku(ModelBuku buku) {
        repository.save(buku);
    }

    public ModelBuku getBuku(int id) {
        return repository.findById(id).orElse(null);
    }

    public void updateBuku(ModelBuku buku) {
        repository.save(buku);
    }

    public void deleteBuku(int id) {
        repository.deleteById(id);
    }

    public List<ModelBuku> getAllBuku() {
        return repository.findAll();
    }
}
