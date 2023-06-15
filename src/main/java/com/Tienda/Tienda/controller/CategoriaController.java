/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.Tienda.Tienda.controller;

import com.Tienda.Tienda.domain.Categoria;
import com.Tienda.Tienda.service.CategoriaService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jason
 */
@Controller
@Slf4j
@RequestMapping("/categoria")
public class CategoriaController {
    
    @Autowired
    CategoriaService categoriaService;
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        log.info("Consumiendo el recurso /categoria/listado");
        List<Categoria> categorias= categoriaService.getCategorias(false);
        model.addAttribute("attribute", "value");
        model.addAttribute("totalCategorias", categorias.size());
        
        model.addAttribute("categorias", categorias);
        return "/categoria/listado";
    }
    
}
