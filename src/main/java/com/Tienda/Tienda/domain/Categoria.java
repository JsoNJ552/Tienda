/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda.Tienda.domain;
//usar nada mas de vez en cuando, porq si no se hace muy pesada en el compilado
import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;
//seria permite transformar objetos complejos, poder enviar un pdf a una base de datos


/**
 *
 * @author jason
 */
@Entity
@Table(name="categoria")
public class Categoria implements Serializable {
    //version de serializacion
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private static final long serialVersionUID =1L;
    private Long idCategoria;//se transforma en id_categoria
    private String descripcion;
    private String rutaImagen;
    private Boolean activo;

    public Categoria() {
    }

    public Categoria(String descripcion, String rutaImagen, Boolean activo) {
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
    }

  
    
    
    
}
