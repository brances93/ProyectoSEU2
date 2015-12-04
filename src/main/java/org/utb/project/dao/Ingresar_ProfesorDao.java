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
import org.utb.project.entities.Ingresar_Profesor;

/**
 *
 * @author JAIR Y BRANCES
 */
@Component
public class Ingresar_ProfesorDao {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void agregar(Ingresar_Profesor profesor) {
        entityManager.persist(profesor);
        entityManager.flush();
    }
    
    @Transactional
    public void editar(Ingresar_Profesor profesor) {
        entityManager.merge(profesor);
        entityManager.flush();
    }
    
    @Transactional
    public void borrar(Long id) {
        Ingresar_Profesor profesor = entityManager.find(Ingresar_Profesor.class, id);
        entityManager.remove(profesor);
        entityManager.flush();
    }
    
    @Transactional
    public Ingresar_Profesor obtener(Long id) {
        Ingresar_Profesor profesor = entityManager.find(Ingresar_Profesor.class, id);
        return profesor;
    }

    @Transactional
    public List<Ingresar_Profesor> listar() {
        List<Ingresar_Profesor> profesores = entityManager.createQuery("SELECT c FROM Ingresar_Profesor c").getResultList();
        return profesores;
    }
}
