/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utb.project.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.utb.project.dao.Ingresar_EstudianteDao;
import org.utb.project.entities.Ingresar_Estudiante;

/**
 *
 * @author JAIR Y BRANCES
 */
@Controller
public class Ingresar_EstudianteController {
    
     @Autowired

    Ingresar_EstudianteDao alumDao;
    
    @RequestMapping(value = "/IngresarEstudiante/listado", method = RequestMethod.GET)
    public String listado(){
        return "alumnos/listado";
    }
    
    @RequestMapping(path = "/api/IngresarEstudiante", method = RequestMethod.POST)
    @ResponseBody
    public void guardar(@ModelAttribute Ingresar_Estudiante alumn) {
        alumDao.agregar(alumn);
    }
    
    @RequestMapping(path = "/api/IngresarEstudiante/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void editar(@PathVariable Long id, @ModelAttribute Ingresar_Estudiante alumn) {
        alumn.setId(id);
        alumDao.editar(alumn);
    }
    
    @RequestMapping(path = "/api/IngresarEstudiante/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void borrar(@PathVariable Long id) {
        alumDao.borrar(id);
    }
    
    @RequestMapping(path = "/api/IngresarEstudiante", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Ingresar_Estudiante> listar() {
        return alumDao.listar();
    }
    
    @RequestMapping(path = "/api/IngresarEstudiante/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Ingresar_Estudiante obtener(@PathVariable("id") Long id) {
        return alumDao.obtener(id);
    }

    public Ingresar_EstudianteDao getProfesorDao() {
        return alumDao;
    }

    public void setProfesorDao(Ingresar_EstudianteDao alumnDao) {
        this.alumDao = alumnDao;
    }
}
