/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda.Tienda.service.impl;

import com.Tienda.Tienda.dao.CategoriaDao;
import com.Tienda.Tienda.domain.Categoria;
import com.Tienda.Tienda.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jason
 */
@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaDao categoriaDao ;
    
    
    @Override
    @Transactional(readOnly=true)
    public List<Categoria> getCategorias(boolean activos) {
        List<Categoria> lista =  categoriaDao.findAll();
        if(activos){
            lista.removeIf(x -> x.isActivo());
        }
       return lista;
    }
   
    
    
}
