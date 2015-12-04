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
import org.utb.project.dao.EstudianteDao;
import org.utb.project.dao.Ingresar_EstudianteDao;
import org.utb.project.entities.Estudiante;
import org.utb.project.entities.Ingresar_Estudiante;

/**
 *
 * @author JAIR Y BRANCES
 */
@Controller
public class EstudianteController {
    @Autowired
    EstudianteDao listadoEstudianteDao;
    @Autowired
    Ingresar_EstudianteDao EstudianteDao;
    
    @RequestMapping(value = "/Estudiante/listado", method = RequestMethod.GET)
    public String listado(){
        return "listaEstu/listado";
    }
    
    @RequestMapping(path = "/api/Estudiante", method = RequestMethod.POST)
    @ResponseBody
    public void guardar(@ModelAttribute Estudiante estudiante, @ModelAttribute("estudiante_id") Long estudianteId) {
        Ingresar_Estudiante estudiantes = EstudianteDao.obtener(estudianteId);
        estudiante.setEstudiante(estudiantes);
        listadoEstudianteDao.agregar(estudiante);
    }
    
    @RequestMapping(path = "/api/Estudiante/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void editar(@PathVariable Long id, @ModelAttribute Estudiante estudiante, @ModelAttribute("estudiante_id") Long estudianteId) {
        Ingresar_Estudiante estudiantes = EstudianteDao.obtener(estudianteId);
        estudiante.setEstudiante(estudiantes);
        estudiante.setId(id);
        listadoEstudianteDao.editar(estudiante);
    }
    
    @RequestMapping(path = "/api/Estudiante/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void borrar(@PathVariable Long id) {
        listadoEstudianteDao.borrar(id);
    }
    
    @RequestMapping(path = "/api/Estudiante", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Estudiante> listar() {
        return listadoEstudianteDao.listar();
    }
    
    @RequestMapping(path = "/api/Estudiante/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Estudiante obtener(@PathVariable("id") Long id) {
        return listadoEstudianteDao.obtener(id);
    }
}
