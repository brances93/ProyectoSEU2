/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utb.project.entities;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author JAIR Y BRANCES
 */

public class Materias implements Serializable{
     @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    
   private Long id;
   private String codigo;
   private String materia;
   @ManyToOne
   private Ingresar_Profesor profesor;
   private Ingresar_Estudiante estudiante;
   private Ingresar_Profesor notas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Ingresar_Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Ingresar_Profesor profesor) {
        this.profesor = profesor;
    }

    public Ingresar_Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Ingresar_Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Ingresar_Profesor getNotas() {
        return notas;
    }

    public void setNotas(Ingresar_Profesor notas) {
        this.notas = notas;
    }

   
}
