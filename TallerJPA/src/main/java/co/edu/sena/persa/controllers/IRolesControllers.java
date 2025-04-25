/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.persa.controllers;

import co.edu.sena.persa.model.Roles;
import java.util.List;

/**
 *
 * @author Danna
 */
public interface IRolesControllers {  
    public void insert(Roles roles) throws Exception;
    public void update(Roles roles) throws Exception;
    public void delete(Long id) throws Exception;
    public Roles findById(Long id) throws Exception;
    public List<Roles> findAll() throws Exception;

    }

