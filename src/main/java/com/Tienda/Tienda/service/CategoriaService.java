/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda.Tienda.service;

import com.Tienda.Tienda.domain.Categoria;
import java.util.List;

/**
 *
 * @author jason
 */
public interface CategoriaService{
    
    // Metodo que retorna la lista de categorias
    public List<Categoria> getCategorias(boolean activos);
    
}
