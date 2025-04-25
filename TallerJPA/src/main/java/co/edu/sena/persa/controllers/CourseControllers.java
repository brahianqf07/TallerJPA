/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.controllers;
import co.edu.sena.persa.model.Course;
import co.edu.sena.persa.persistence.DAOFactory;
import co.edu.sena.persa.persistence.EntityManagerHelper;
import java.util.List;

/**
 *
 * @author Aprendiz
 */

public class CourseControllers  implements ICourseControllers{

    @Override
    public void insert(Course course) throws Exception {
        if (course == null)
        {
            throw new Exception("El curso es nulo");
        }
        
        if(course.getId()== 0)
        {
            throw new Exception("El id es obligatorio");
        }
        
        if("".equals(course.getShift()))
        {
        throw new Exception("El Shift es obligatorio");
        }
        
        if("".equals(course.getTrimester()))
        {
        throw new Exception("El trimestre es obligatorio");
        }
        
        if("".equals(course.getYear()))
        {
        throw new Exception("El año es obligatorio");
        }
        
        if("".equals(course.getStatus()))
        {
        throw new Exception("El estado es obligatorio");
        }
        
        //FK
        if(course.getCareerId() == null)
        {
            throw new Exception("El id de curso es obligatorio");
        }
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCourseDAO().insert(course);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Course course) throws Exception {
        if (course == null)
        {
            throw new Exception("El curso es nulo");
        }
        
        if(course.getId()== 0)
        {
            throw new Exception("El id es obligatorio");
        }
        
        if("".equals(course.getShift()))
        {
        throw new Exception("El Shift es obligatorio");
        }
        
        if("".equals(course.getTrimester()))
        {
        throw new Exception("El trimestre es obligatorio");
        }
        
        if("".equals(course.getYear()))
        {
        throw new Exception("El año es obligatorio");
        }
        
        if("".equals(course.getStatus()))
        {
        throw new Exception("El estado es obligatorio");
        }
        
        //FK
        if(course.getCareerId()== null)
        {
            throw new Exception("El id de curso es obligatorio");
        }
        //consultar si el Course existe en la bd
        Course courseExist = DAOFactory.getCourseDAO().findById(course.getId());
        if(courseExist == null)
        {
            throw new Exception("El curso no existe");
        }
        
        courseExist.setShift(course.getShift());
        courseExist.setTrimester(course.getTrimester());
        courseExist.setYear(course.getYear());
        courseExist.setStatus(course.getStatus());
        courseExist.setCareerId(course.getCareerId());
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCourseDAO().update(course);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        
    }

    @Override
    public void delete(Long id) throws Exception {
        if (id == 0) {
            throw new Exception("El id es obligatorio");
        }
        Course courseExist = DAOFactory.getCourseDAO().findById(id);
        if (courseExist == null) 
        {
            throw new Exception("El curso no existe");
        }
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCourseDAO().delete(courseExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<Course> findAll() throws Exception {
        return DAOFactory.getCourseDAO().findAll();
    }

    @Override
    public Course findById(Long id) throws Exception {
        if (id == 0) {
            throw new Exception("El id es obligatorio");
        }
        return DAOFactory.getCourseDAO().findById(id);
    }
    
}