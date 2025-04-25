/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.controllers;

import co.edu.sena.persa.model.Roles;
import co.edu.sena.persa.model.Users;
import co.edu.sena.persa.persistence.DAOFactory;
import co.edu.sena.persa.persistence.EntityManagerHelper;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public class UsersControllers implements IUsersControllers{

    @Override
    public void insert(Users users) throws Exception {
        if(users == null)
    {
        throw new Exception("El usuario es nulo");
    }
        if("".equals(users.getFullname()))  
    {
        throw new Exception("El nombre completo es obligatorio");
    }
        
       if("".equals(users.getEmail()))  
    {
        throw new Exception("El correo es obligatorio");
    }
       
       if("".equals(users.getPassword()))  
    {
        throw new Exception("La contraseña es obligatoria");
    }
       
       if("".equals(users.getStatus()))  
    {
        throw new Exception("El estado es obligatorio");
    }
       
       if("".equals(users.getRoleId()))  
    {
        throw new Exception("El id del rol es obligatorio");
    }
       
       //insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getUsersDAO().insert(users);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Users users) throws Exception {
        if(users == null)
    {
        throw new Exception("El usuario es nulo");       
    }
        
        if(users.getId()== 0)
    {
        throw new Exception("El Id es obligatorio");
    }
        if("".equals(users.getFullname()))  
    {
        throw new Exception("El nombre completo es obligatorio");
    }
        
       if("".equals(users.getEmail()))  
    {
        throw new Exception("El correo es obligatorio");
    }
       
       if("".equals(users.getPassword()))  
    {
        throw new Exception("La contraseña es obligatoria");
    }
       
       if("".equals(users.getStatus()))  
    {
        throw new Exception("El estado es obligatorio");
    }
       
       //FK
       if(users.getRoleId()== null)
       {
           throw new Exception("El id del rol es obligatorio"); 
       }
       
       
       //consultar si el users exista en la bd
     Users usersExists = DAOFactory.getUsersDAO().findById(users.getId());
        if(usersExists == null){
            throw new Exception("El tipo de empleado no existe");
    }
        //merge
    usersExists.setFullname(users.getFullname());
    usersExists.setEmail(users.getEmail());
    usersExists.setPassword(users.getPassword());
    usersExists.setStatus(users.getStatus());
    usersExists.setRoleId(users.getRoleId());
    usersExists.setId(users.getId());
        
    EntityManagerHelper.beginTransaction();
    DAOFactory.getUsersDAO().update(usersExists);
    EntityManagerHelper.commit();
    EntityManagerHelper.closeEntityManager();
    }
    
        

    @Override
    public void delete(Long id) throws Exception {
         if (id == 0) {
            throw new Exception("El id es obligatorio");
        }
        //consultar si el users existe en la bd
        Users usersExist = DAOFactory.getUsersDAO().findById(id);
        if (usersExist == null) {
            throw new Exception("El tipo de usuario no existe");
        }
        
        //Eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getUsersDAO().delete(usersExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        }
    

    @Override
    public Users findById(Long id) throws Exception {
         if (id == 0) {
            throw new Exception("El id es obligatorio");
        }
        return DAOFactory.getUsersDAO().findById(id);
    }

    @Override
    public List<Users> findAll() throws Exception {
        return DAOFactory.getUsersDAO().findAll();
    }
    
}
