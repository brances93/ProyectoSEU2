/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utb.project.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.utb.project.entities.Ingresar_Estudiante;

/**
 *
 * @author JAIR Y BRANCES
 */
@Component
public class Ingresar_EstudianteDao {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void agregar(Ingresar_Estudiante estudiante) {
        entityManager.persist(estudiante);
        entityManager.flush();
    }
    
    @Transactional
    public void editar(Ingresar_Estudiante estudiante) {
        entityManager.merge(estudiante);
        entityManager.flush();
    }
    
    @Transactional
    public void borrar(Long id) {
       Ingresar_Estudiante estudiante = entityManager.find(Ingresar_Estudiante.class, id);
        entityManager.remove(estudiante);
        entityManager.flush();
    }
    
    @Transactional
    public Ingresar_Estudiante obtener(Long id) {
        Ingresar_Estudiante estudiante = entityManager.find(Ingresar_Estudiante.class, id);
        return estudiante;
    }

    @Transactional
    public List<Ingresar_Estudiante> listar() {
        List<Ingresar_Estudiante> estudiantes = entityManager.createQuery("SELECT a FROM Ingresar_Estudiante a").getResultList();
        return estudiantes;
    }
}

