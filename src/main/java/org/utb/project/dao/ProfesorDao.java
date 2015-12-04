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
import org.utb.project.entities.Profesor;

/**
 *
 * @author JAIR Y BRANCES
 */
@Component
public class ProfesorDao {
    @PersistenceContext
    EntityManager entityManager;

   
    
   @Transactional
    public void agregar(Profesor notas) {
        entityManager.persist(notas);
        entityManager.flush();
    }
    
    @Transactional
    public void editar(Profesor notas) {
        entityManager.merge(notas);
        entityManager.flush();
    }
    
    @Transactional
    public void borrar(Long id) {
       Profesor notas = entityManager.find(Profesor.class, id);
       entityManager.remove(notas); 
        entityManager.flush();
    }
    
    @Transactional
    public Profesor obtener(Long id) {
        Profesor notas = entityManager.find(Profesor.class, id);
        return notas;
        
    }

    @Transactional
    public List<Profesor> listar() {
        List<Profesor> notas = entityManager.createQuery("SELECT a FROM Profesor a").getResultList();
        return notas;
    }

    
   
}
