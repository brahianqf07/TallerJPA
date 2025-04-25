/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.persa.controllers;
import co.edu.sena.persa.model.Career;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public interface ICareerControllers {
    public void insert(Career career) throws Exception;
    public void update (Career career) throws Exception;
    public void delete(Long id) throws Exception;
    public List<Career> findAll() throws Exception;
    public Career findById (Long id) throws Exception;
}