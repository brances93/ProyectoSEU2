/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utb.project.entities;

import java.io.Serializable;
import java.util.Currency;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author JAIR Y BRANCES
 */
@Entity
public class Profesor implements Serializable {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    private String codigo;
    private Double creditos;
    private Currency horario;
    
    
    @ManyToOne
   private Ingresar_Profesor profesor;
   

    public double getCreditos() {
        return creditos;
    }

    public void setCreditos(double creditos) {
        this.creditos = creditos;
    }

    public Currency getHorario() {
        return horario;
    }

    public void setHorario(Currency horario) {
        this.horario = horario;
    }

   public Long getId() {
        return id;
    }

    public Ingresar_Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Ingresar_Profesor profesor) {
        this.profesor = profesor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
