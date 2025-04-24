/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.persa.persistence;

import co.edu.sena.persa.model.Career;
import java.util.List;

/**
 *
 * @author Nicol
 */
public interface ICareerDAO {
    public void insert(Career career) throws Exception;
    public void update(Career career) throws Exception;
    public void delete(Career career) throws Exception;
    public Career findById(Long document) throws Exception;
    public List<Career> findAll() throws Exception;
}
