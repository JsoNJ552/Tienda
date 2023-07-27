/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda.Tienda.dao;

import com.Tienda.Tienda.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jason
 */
public interface UserDao extends JpaRepository<User, Long> {
      User findByUsername(String username);
    
    User findByUsernameAndPassword(String username, String Password);

    User findByUsernameOrCorreo(String username, String correo);

    boolean existsByUsernameOrCorreo(String username, String correo);
}
