/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.controllers;

import co.edu.sena.persa.model.Roles;
import co.edu.sena.persa.persistence.DAOFactory;
import co.edu.sena.persa.persistence.EntityManagerHelper;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public class RolesControllers implements IRolesControllers{

    @Override
    public void insert(Roles roles) throws Exception {
        if(roles == null)
    {
        throw new Exception("El rol es nulo");
    }
                
    if("".equals(roles.getName()))  
    {
        throw new Exception("El nombre es obligatorio");
    }
    
     //insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getRolesDAO().insert(roles);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Roles roles) throws Exception {
        if(roles == null)
    {
        throw new Exception("El rol es nulo");
    }
        
    if(roles.getId()== 0)
    {
        throw new Exception("El Id es obligatorio");
    }
    
     if("".equals(roles.getName())){
        throw new Exception("El nombre es obligatorio");
    }
    
    //consultar si el roles exista en la bd
     Roles rolesExists = DAOFactory.getRolesDAO().findById(roles.getId());
        if(rolesExists == null){
            throw new Exception("El tipo de empleado no existe");
 }
     
        
    //merge
    rolesExists.setName(roles.getName());
    rolesExists.setId(roles.getId());
        
    EntityManagerHelper.beginTransaction();
    DAOFactory.getRolesDAO().update(rolesExists);
    EntityManagerHelper.commit();
    EntityManagerHelper.closeEntityManager();
    }
    

    

    @Override
    public void delete(Long id) throws Exception {
        if (id == 0) {
            throw new Exception("El id es obligatorio");
        }
        //consultar si el roles existe en la bd
        Roles rolesExists = DAOFactory.getRolesDAO().findById(id);
        if (rolesExists == null) {
            throw new Exception("El tipo de llave no existe");
        }
        
        //Eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getRolesDAO().delete(rolesExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        }
    

    @Override
    public Roles findById(Long id) throws Exception {
        if (id == 0) {
            throw new Exception("El id es obligatorio");
        }
        return DAOFactory.getRolesDAO().findById(id);
    }
    

    @Override
    public List<Roles> findAll() throws Exception {
        return DAOFactory.getRolesDAO().findAll();
    }
    
}
