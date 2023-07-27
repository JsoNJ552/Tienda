/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.Tienda.Tienda.controller;

import com.Tienda.Tienda.domain.User;
import com.Tienda.Tienda.service.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author jason
 */
@Controller
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    private UserService usuarioService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var usuarios = usuarioService.getUsers();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("totalUsers", usuarios.size());
        return "/usuario/listado";
    }

    @GetMapping("/nuevo")
    public String usuarioNuevo(User usuario) {
        return "/usuario/modifica";
    }

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @PostMapping("/guardar")
    public String usuarioGuardar(User usuario,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        usuario.setPassword(encoder.encode(usuario.getPassword));
        if (!imagenFile.isEmpty()) {
            usuarioService.save(usuario,false);
            usuario.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "usuario",
                            usuario.getIdUser()));
        }
        usuarioService.save(usuario,true);
        return "redirect:/usuario/listado";
    }

    @GetMapping("/eliminar/{idUser}")
    public String usuarioEliminar(User usuario) {
        usuarioService.delete(usuario);
        return "redirect:/usuario/listado";
    }

    @GetMapping("/modificar/{idUser}")
    public String usuarioModificar(User usuario, Model model) {
        usuario = usuarioService.getUser(usuario);
        model.addAttribute("usuario", usuario);
        return "/usuario/modifica";
    }
}