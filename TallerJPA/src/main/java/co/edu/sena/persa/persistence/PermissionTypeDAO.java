/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.persistence;

import co.edu.sena.persa.model.PermissionType;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Nicol
 */
public class PermissionTypeDAO implements IPermissionTypeDAO{

    @Override
    public void insert(PermissionType permissionType) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(permissionType);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(PermissionType permissionType) throws Exception {
        try 
        {
            EntityManagerHelper.getEntityManager().remove(permissionType);
        } 
        catch (RuntimeException e) 
        {
            throw e;
        }
    }

    @Override
    public void delete(PermissionType permissionType) throws Exception {
        try 
        {
            EntityManagerHelper.getEntityManager().remove(permissionType);
        } 
        catch (RuntimeException e) 
        {
            throw e;
        }
    }

    @Override
    public PermissionType findById(Long id) throws Exception {
        try 
        {
            return EntityManagerHelper.getEntityManager().find(PermissionType.class, id);
        } 
        catch (RuntimeException e) 
        {
            throw e;
        }
    }

    @Override
    public List<PermissionType> findAll() throws Exception {
        try {
            Query query = EntityManagerHelper.getEntityManager()
                    .createNamedQuery("Permission.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
}
