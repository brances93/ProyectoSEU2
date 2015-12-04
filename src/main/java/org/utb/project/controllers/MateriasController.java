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
import org.utb.project.dao.Ingresar_ProfesorDao;
import org.utb.project.dao.ProfesorDao;
import org.utb.project.entities.Estudiante;
import org.utb.project.entities.Ingresar_Estudiante;
import org.utb.project.entities.Ingresar_Profesor;
import org.utb.project.entities.Profesor;


/**
 *
 * @author JAIR Y BRANCES
 */
@Controller
public class MateriasController {

    @Autowired
    ProfesorDao materiaDao;
    @Autowired
    EstudianteDao materia1Dao;
    @Autowired
    Ingresar_ProfesorDao profesorDao;
    @Autowired
    Ingresar_EstudianteDao EstudianteDao;

    @RequestMapping(value = "/Materias/listado", method = RequestMethod.GET)
    public String listado() {
        return "Materias/listado";
    }

    @RequestMapping(path = "/api/Materias", method = RequestMethod.POST)
    @ResponseBody
    public void guardar(@ModelAttribute Profesor notas,Estudiante notas1, @ModelAttribute("profesor_id") Long profesorId,@ModelAttribute("estudiante_id") Long estudianteId) {
        Ingresar_Profesor profesor = profesorDao.obtener(profesorId);
        Ingresar_Estudiante estudiante = EstudianteDao.obtener(estudianteId);
        notas.setProfesor(profesor);
        notas1.setEstudiante(estudiante);
    
       materiaDao.agregar(notas);
       materia1Dao.agregar(notas1);

    }

    @RequestMapping(path = "/api/Materias/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void editar(@PathVariable Long id, @ModelAttribute Profesor notas,Estudiante notas1, @ModelAttribute("profesor_id") Long profesorId,@ModelAttribute("estudiante_id") Long estudianteId) {
        Ingresar_Profesor profesor = profesorDao.obtener(profesorId);
        Ingresar_Estudiante estudiante = EstudianteDao.obtener(estudianteId);
        notas.setProfesor(profesor);
         notas1.setEstudiante(estudiante);
        notas.setId(id);
        materiaDao.editar(notas);
        materia1Dao.editar(notas1);
    }

    @RequestMapping(path = "/api/Materias/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void borrar(@PathVariable Long id) {
        materiaDao.borrar(id);
        materia1Dao.borrar(id);
    }

    @RequestMapping(path = "/api/Materias", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Profesor> listar() {
        return materiaDao.listar();
    }

    @RequestMapping(path = "/api/Materias/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Profesor obtener(@PathVariable("id") Long id) {
        return materiaDao.obtener(id);
    }
}
