/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.controllers;

import co.edu.sena.persa.model.PermissionType;
import co.edu.sena.persa.persistence.DAOFactory;
import co.edu.sena.persa.persistence.EntityManagerHelper;
import java.util.List;

/**
 *
 * @author Nicol
 */
public class PermissionTypeControllers implements IPermissionTypeControllers {

    @Override
    public void insert(PermissionType permissionType) throws Exception {
        
        if(permissionType == null)
        {
            throw new Exception("El tipo de permiso es nulo");
        }
        
        if("".equals(permissionType.getName()))
        {            
            throw new Exception("El nombre es obligatorio");
        }
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPermissionTypeDAO().insert(permissionType);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(PermissionType permissionType) throws Exception {
        
        if(permissionType == null)
        {
            throw new Exception("El tipo de permiso es nulo");
        }
        
        if(permissionType.getId() == null)
        {
            throw new Exception("El ID es obligatorio");
        }
        
        if("".equals(permissionType.getName()))
        {            
            throw new Exception("El nombre es obligatorio");
        }
        
        PermissionType typeExists = DAOFactory.getPermissionTypeDAO().findById(permissionType.getId());
        if(typeExists == null)
        {
            throw new Exception("No existe el tipo de permiso");
        }
        
        typeExists.setName(permissionType.getName());
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPermissionTypeDAO().update(typeExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long id) throws Exception {
        if(id == null || id <= 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        
        PermissionType typeExists = DAOFactory.getPermissionTypeDAO().findById(id);
        if(typeExists == null)
        {
            throw new Exception("No existe el tipo de permiso");
        }
               
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPermissionTypeDAO().delete(typeExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public PermissionType findById(Long id) throws Exception {
        if(id == null || id <= 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        
        return DAOFactory.getPermissionTypeDAO().findById(id);
    }

    @Override
    public List<PermissionType> findAll() throws Exception {
        return DAOFactory.getPermissionTypeDAO().findAll();
    }
}