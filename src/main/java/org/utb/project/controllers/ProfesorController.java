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
import org.utb.project.dao.ProfesorDao;
import org.utb.project.dao.Ingresar_ProfesorDao;
import org.utb.project.entities.Profesor;
import org.utb.project.entities.Ingresar_Profesor;

/**
 *
 * @author JAIR Y BRANCES
 */
@Controller
public class ProfesorController {
    @Autowired
    ProfesorDao datosDao;
    @Autowired
    Ingresar_ProfesorDao profesorDao;
    
    @RequestMapping(value = "/Profesor/listado", method = RequestMethod.GET)
    public String listado(){
        return "listaMateria/listado";
    }
    
    @RequestMapping(path = "/api/Profesor", method = RequestMethod.POST)
    @ResponseBody
    public void guardar(@ModelAttribute Profesor notas, @ModelAttribute("profesor_id") Long profesorId) {
        Ingresar_Profesor profesor = profesorDao.obtener(profesorId);
         notas.setProfesor(profesor);
     
       datosDao.agregar(notas);
    }
    
    @RequestMapping(path = "/api/Profesor/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void editar(@PathVariable Long id, @ModelAttribute Profesor notas, @ModelAttribute("profesor_id") Long profesorId) {
        Ingresar_Profesor profesor = profesorDao.obtener(profesorId);
        notas.setProfesor(profesor);
        notas.setId(id);
        datosDao.editar(notas);
    }
    
    @RequestMapping(path = "/api/Profesor/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void borrar(@PathVariable Long id) {
        datosDao.borrar(id);
    }
    
    @RequestMapping(path = "/api/Profesor", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Profesor> listar() {
        return datosDao.listar();
    }
    
    @RequestMapping(path = "/api/Profesor/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Profesor obtener(@PathVariable("id") Long id) {
        return datosDao.obtener(id);
    }
}
