/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda.Tienda.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


/**
 *
 * @author jason
 */
@Data
@Entity
@Table(name="producto")
public class Producto {
    
     private static final long serialVersionUID = 1L;
     @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    @Column(name="id_producto")
     private long idProducto;

     private String descripcion;
     private String detalle;
     private double precio;
     private int existencias;
     private String rutaImagen;
     private boolean activo;
     
     @ManyToOne
     @JoinColumn(name="id_categoria")
     private Categoria categoria;

    public Producto() {
    }

    public Producto(String descripcion, String detalle, double precio, int existencias, String rutaImagen, boolean activo, Categoria categoria) {
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.existencias = existencias;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
        this.categoria = categoria;
    }
    


     
     
     
     
     
}
