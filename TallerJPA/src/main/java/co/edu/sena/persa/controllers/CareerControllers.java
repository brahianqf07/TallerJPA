/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.controllers;
import co.edu.sena.persa.model.Career;
import co.edu.sena.persa.persistence.DAOFactory;
import co.edu.sena.persa.persistence.EntityManagerHelper;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public class CareerControllers implements ICareerControllers{

    @Override
    public void insert(Career career) throws Exception {
        if (career == null)
        {
            throw new Exception("La carrera es nula");
        }
        
        if(career.getId()== 0)
        {
            throw new Exception("El id es obligatorio");
        }
        
        if("".equals(career.getName()))
        {
        throw new Exception("El nombre es obligatorio");
        }
        
        if("".equals(career.getType()))
        {
        throw new Exception("El tipo es obligatoria");
        }
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCareerDAO().insert(career);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Career career) throws Exception {
        if(career == null)
        {
        throw new Exception("La carrera es nula");
        }

        if(career.getId() == 0)
        {
        throw new Exception("El Id es obligatorio");
        }
        
        if("".equals(career.getName()))
        {
        throw new Exception("El nombre es obligatoria");
        }
        
        if("".equals(career.getType()))
        {
        throw new Exception("el tipo es obligatorio");
        }
        
        //consultar si la carrera existe en la bd
        Career careerExist = DAOFactory.getCareerDAO().findById(career.getId());
        if(careerExist == null)
        {
            throw new Exception("El tipo de empleado no existe");
        }
        
        //merge: todos los campos menos la PK
        careerExist.setId(career.getId());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCareerDAO().update(careerExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El Id es obligatorio");
        }
        
        //consultar si el employeeType existe en la bd
        Career careerExist = DAOFactory.getCareerDAO().findById(id);
        if(careerExist == null)
        {
            throw new Exception("El tipo de empleado no existe");
        }
        
        //eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCareerDAO().delete(careerExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<Career> findAll() throws Exception {
        return DAOFactory.getCareerDAO().findAll();
    }

    @Override
    public Career findById(Long id) throws Exception {
        if(id == 0)
        {
            throw new Exception ("El id es obligatorio");
        }
        
        return DAOFactory.getCareerDAO().findById(id);
    }
    
}
