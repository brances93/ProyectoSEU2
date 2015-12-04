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
import org.utb.project.dao.Ingresar_ProfesorDao;
import org.utb.project.entities.Ingresar_Profesor;

/**
 *
 * @author JAIR Y BRANCES
 */
@Controller
public class Ingresar_ProfesorController{

   @Autowired

    Ingresar_ProfesorDao profesorDao;
    
    @RequestMapping(value = "/IngresarProfesor/listado", method = RequestMethod.GET)
    public String listado(){
        return "profesor/listado";
    }
    
    @RequestMapping(path = "/api/IngresarProfesor", method = RequestMethod.POST)
    @ResponseBody
    public void guardar(@ModelAttribute Ingresar_Profesor profesor) {
        profesorDao.agregar(profesor);
    }
    
    @RequestMapping(path = "/api/IngresarProfesor/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void editar(@PathVariable Long id, @ModelAttribute Ingresar_Profesor profesor) {
        profesor.setId(id);
        profesorDao.editar(profesor);
    }
    
    @RequestMapping(path = "/api/IngresarProfesor/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void borrar(@PathVariable Long id) {
        profesorDao.borrar(id);
    }
    
    @RequestMapping(path = "/api/IngresarProfesor", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Ingresar_Profesor> listar() {
        return profesorDao.listar();
    }
    
    @RequestMapping(path = "/api/IngresarProfesor/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Ingresar_Profesor obtener(@PathVariable("id") Long id) {
        return profesorDao.obtener(id);
    }

    public Ingresar_ProfesorDao getProfesorDao() {
        return profesorDao;
    }

    public void setProfesorDao(Ingresar_ProfesorDao profesorDao) {
        this.profesorDao = profesorDao;
    }
}
