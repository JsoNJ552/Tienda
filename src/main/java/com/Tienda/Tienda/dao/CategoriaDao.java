/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda.Tienda.dao;

import com.Tienda.Tienda.domain.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *Z
 * @author jason
 */
public interface CategoriaDao extends JpaRepository<Categoria,Long> {
    List<Categoria>findByDescripcion(String descripcion);
    
}
