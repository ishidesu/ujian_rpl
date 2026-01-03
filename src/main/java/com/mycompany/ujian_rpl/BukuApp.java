/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ujian_rpl;

/**
 *
 * @author Ishi
 */
import com.mycompany.ujian_rpl.controller.BukuController;
import com.mycompany.ujian_rpl.view.BukuView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BukuApp {

    public static void main(String[] args) {
        System.setProperty("java.awt.headless", "false");
        
        ApplicationContext context = SpringApplication.run(BukuApp.class, args);
        
        BukuController controller = context.getBean(BukuController.class);
        BukuView view = new BukuView(controller);
        view.setVisible(true);
    }
}
