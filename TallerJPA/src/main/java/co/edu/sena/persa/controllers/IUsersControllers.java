/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.persa.controllers;

import co.edu.sena.persa.model.Users;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public interface IUsersControllers {
     public void insert(Users users) throws Exception;
    public void update(Users users) throws Exception;
    public void delete(Long id) throws Exception;
    public Users findById(Long id) throws Exception;
    public List<Users> findAll() throws Exception;
    
}
