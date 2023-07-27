/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda.Tienda.service;

import com.Tienda.Tienda.domain.User;
import jakarta.mail.MessagingException;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author jason
 */
public interface RegistroService {
   
    public Model activar(Model model, String usuario, String clave);

    public Model crearUsuario(Model model, User usuario) throws MessagingException;
    
    public void activar(User usuario, MultipartFile imagenFile);
    
    public Model recordarUsuario(Model model, User usuario) throws MessagingException; 
}
