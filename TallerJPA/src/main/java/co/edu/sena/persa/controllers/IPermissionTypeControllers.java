/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.persa.controllers;

import co.edu.sena.persa.model.PermissionType;
import java.util.List;

/**
 *
 * @author Nicol
 */
public interface IPermissionTypeControllers {
    public void insert(PermissionType permissionType) throws Exception;
    public void update(PermissionType permissionType) throws Exception;
    public void delete(Long id) throws Exception;
    public PermissionType findById(Long id) throws Exception;
    public List<PermissionType> findAll() throws Exception;
}