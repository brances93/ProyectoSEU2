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
import org.utb.project.entities.Estudiante;

/**
 *
 * @author JAIR Y BRANCES
 */
@Component
public class EstudianteDao {
     @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void agregar(Estudiante estudiante) {
        entityManager.persist(estudiante);
        entityManager.flush();
    }
    
    @Transactional
    public void editar(Estudiante estudiante) {
        entityManager.merge(estudiante);
        entityManager.flush();
    }
    
    @Transactional
    public void borrar(Long id) {
       Estudiante estudiante = entityManager.find(Estudiante.class, id);
        entityManager.remove(estudiante);
        entityManager.flush();
    }
    
    @Transactional
    public Estudiante obtener(Long id) {
        Estudiante estudiante = entityManager.find(Estudiante.class, id);
        return estudiante;
    }

    @Transactional
    public List<Estudiante> listar() {
        List<Estudiante> estudiantes = entityManager.createQuery("SELECT a FROM Estudiante a").getResultList();
        return estudiantes;
    }
}
