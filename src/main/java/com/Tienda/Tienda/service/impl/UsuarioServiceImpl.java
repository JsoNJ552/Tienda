/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda.Tienda.service.impl;

import com.Tienda.Tienda.dao.RolDao;
import com.Tienda.Tienda.dao.UserDao;
import com.Tienda.Tienda.domain.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jason
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao usuarioDao;
    @Autowired
    private RolDao rolDao;

    @Override
    @Transactional(readOnly = true)
    public List<User> getUsers() {
        return usuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(User usuario) {
        return usuarioDao.findById(usuario.getIdUser()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserPorUsername(String username) {
        return usuarioDao.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserPorUsernameYPassword(String username, String password) {
        return usuarioDao.findByUsernameAndPassword(username, password);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserPorUsernameOCorreo(String username, String correo) {
        return usuarioDao.findByUsernameOrCorreo(username, correo);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeUserPorUsernameOCorreo(String username, String correo) {
        return usuarioDao.existsByUsernameOrCorreo(username, correo);
    }

    @Override
    @Transactional
    public void save(User usuario, boolean crearRolUser) {
        usuario = usuarioDao.save(usuario);
        if (crearRolUser) {  //Si se está creando el usuario, se crea el rol por defecto "USER"
            Rol rol = new Rol();
            rol.setNombre("ROLE_USER");
            rol.setIdUser(usuario.getIdUser());
            rolDao.save(rol);
        }
    }

    @Override
    @Transactional
    public void delete(User usuario) {
        usuarioDao.delete(usuario);
    }
}
}
