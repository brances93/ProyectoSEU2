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
import org.utb.project.entities.Materias;

/**
 *
 * @author JAIR Y BRANCES
 */
@Component
public class MateriasDao {
     @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void agregar(Materias materia) {
        entityManager.persist(materia);
        entityManager.flush();
    }
    
    @Transactional
    public void editar(Materias materia) {
        entityManager.merge(materia);
        entityManager.flush();
    }
    
    @Transactional
    public void borrar(Long id) {
       Materias materia = entityManager.find(Materias.class, id);
        entityManager.remove(materia);
        entityManager.flush();
    }
    
    @Transactional
    public Materias obtener(Long id) {
        Materias materia = entityManager.find(Materias.class, id);
        return materia;
    }

    @Transactional
    public List<Materias> listar() {
        List<Materias> materias = entityManager.createQuery("SELECT a FROM Articulo a").getResultList();
        return materias;
    }

}
