/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.controllers;

import co.edu.sena.persa.model.Location;
import co.edu.sena.persa.persistence.DAOFactory;
import co.edu.sena.persa.persistence.EntityManagerHelper;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public class LocationControllers implements ILocationControllers {

    @Override
    public void insert(Location location) throws Exception {
        if (location == null) {
            throw new Exception("La ubicación es nula");
        }
        if (location.getId() == null)
        {
            throw new Exception("El id es obligatorio");
        }
        if(location.getName() == null)
        {
            throw new Exception("El nombre es obligatorio");
        }
        if(location.getAddress() == null)
        {
            throw new Exception("La dirección es obligatoria");
        }
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getLocationDAO().insert(location);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Location location) throws Exception {
        if (location == null) {
            throw new Exception("La ubicación es nula");
        }
        if (location.getId() == null)
        {
            throw new Exception("El id es obligatorio");
        }
        if(location.getName() == null)
        {
            throw new Exception("El nombre es obligatorio");
        }
        if(location.getAddress() == null)
        {
            throw new Exception("La dirección es obligatoria");
        }
        
        //Consultar si location existe en la bd
        Location locationExist = DAOFactory.getLocationDAO().findById(location.getId());
        if (locationExist == null) 
        {
            throw new Exception("La ubicación no existe");
        }
        
        locationExist.setName(location.getName());
        locationExist.setAddress(location.getAddress());
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getLocationDAO().update(location);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        
        //Consultar si location existe en la bd
        Location locationExist = DAOFactory.getLocationDAO().findById(id);
        if (locationExist == null) 
        {
            throw new Exception("La ubicación no existe");
        }
    }

    @Override
    public List<Location> findAll() throws Exception {
        return DAOFactory.getLocationDAO().findAll();
    }

    @Override
    public Location findById(Long id) throws Exception {
        if (id == 0) {
            throw new Exception("El id es obligatorio");
        }
        return DAOFactory.getLocationDAO().findById(id);
    }
    
}