/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda.Tienda.service;

import com.Tienda.Tienda.domain.Producto;
import java.util.List;

/**
 *
 * @author jason
 */
public interface ProductoService{
    
    // Metodo que retorna la lista de categorias
    public List<Producto> getProductos(boolean activos);
    
     // Se obtiene un Producto, a partir del id de un categoria
    public Producto getProducto(Producto producto);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Producto categoria);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Producto categoria);
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);

    
}
