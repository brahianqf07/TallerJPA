/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.controllers;

import co.edu.sena.persa.model.Permission;
import co.edu.sena.persa.persistence.DAOFactory;
import co.edu.sena.persa.persistence.EntityManagerHelper;
import java.util.List;

/**
 *
 * @author Nicol
 */
public class PermissionControllers implements IPermissionControllers {

    @Override
    public void insert(Permission permission) throws Exception {
        
        if(permission == null)
        {
            throw new Exception("El permiso es nulo");
        }
        
        if( permission.getPermissionDate() == null )
        {
            throw new Exception("La fecha de permiso es obligatoria");
        }
        
        if( permission.getDepartureTime()== null )
        {
            throw new Exception("La fecha de salida es obligatoria");
        }
        
        if( permission.getStartTime()== null )
        {
            throw new Exception("La fecha de permiso es obligatoria");
        }
        
        if("".equals(permission.getReasons()))
        {            
            throw new Exception("La excusa es obligatoria");
        }
        
        if("".equals(permission.getStatus()))
        {            
            throw new Exception("El estado es obligatorio");
        }
        
        //FK
        if( permission.getInstructorId()== null )
        {
            throw new Exception("El ID de el instructor es obligatorio");
        }
        
        if( permission.getGuardId()== null )
        {
            throw new Exception("El ID de el guarda es obligatorio");
        }
        
        if( permission.getLocationId()== null )
        {
            throw new Exception("La ubicación es obligatoria");
        }
        
        if( permission.getPermissionTypeId()== null )
        {
            throw new Exception("El tipo de permiso es obligatorio");
        }
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPermissionDAO().insert(permission);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Permission permission) throws Exception {
        
        if(permission == null)
        {
            throw new Exception("El permiso es nulo");
        }
        
        if( permission.getPermissionDate() == null )
        {
            throw new Exception("La fecha de permiso es obligatoria");
        }
        
        if( permission.getDepartureTime()== null )
        {
            throw new Exception("La fecha de salida es obligatoria");
        }
        
        if( permission.getStartTime()== null )
        {
            throw new Exception("La fecha de permiso es obligatoria");
        }
        
        if("".equals(permission.getReasons()))
        {            
            throw new Exception("La excusa es obligatoria");
        }
        
        if("".equals(permission.getStatus()))
        {            
            throw new Exception("El estado es obligatorio");
        }
        
        //FK
        if( permission.getInstructorId()== null )
        {
            throw new Exception("El ID de el instructor es obligatorio");
        }
        
        if( permission.getGuardId()== null )
        {
            throw new Exception("El ID de el guarda es obligatorio");
        }
        
        if( permission.getLocationId()== null )
        {
            throw new Exception("La ubicación es obligatoria");
        }
        
        if( permission.getPermissionTypeId()== null )
        {
            throw new Exception("El tipo de permiso es obligatorio");
        }
        
        //La PK es auto incremental
        Permission permissionExists = DAOFactory.getPermissionDAO().findById(permission.getId());
        if(permissionExists == null)
        {
            throw new Exception("La ID no existe");
        }
        
        permissionExists.setPermissionDate(permission.getPermissionDate());
        permissionExists.setDepartureTime(permission.getDepartureTime());
        permissionExists.setEndTime(permission.getEndTime());
        permissionExists.setStartTime(permission.getStartTime());
        permissionExists.setReasons(permission.getReasons());
        permissionExists.setStatus(permission.getStatus());
        permissionExists.setInstructorId(permission.getInstructorId());
        permissionExists.setGuardId(permission.getGuardId());
        permissionExists.setLocationId(permission.getLocationId());
        permissionExists.setPermissionTypeId(permission.getPermissionTypeId());
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPermissionDAO().update(permission);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El Id es obligatorio");
        }
        
        Permission permissionExists = DAOFactory.getPermissionDAO().findById(id);
        if(permissionExists == null)
        {
            throw new Exception("No existe el permiso");
        }
               
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPermissionDAO().delete(permissionExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public Permission findById(Long id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El Id es obligatorio");
        }
        
        return DAOFactory.getPermissionDAO().findById(id);
    }

    @Override
    public List<Permission> findAll() throws Exception {
        return DAOFactory.getPermissionDAO().findAll();
    }
    
}
