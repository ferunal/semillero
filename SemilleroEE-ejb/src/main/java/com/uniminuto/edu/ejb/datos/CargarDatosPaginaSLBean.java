/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.edu.ejb.datos;

import com.uniminuto.edu.modelo.GpsTipolug;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fercris
 */
@Stateless
@LocalBean
public class CargarDatosPaginaSLBean {

    @PersistenceContext
    EntityManager em;

    public List<GpsTipolug> getLstGpsTipolugs() {
        return em.createNamedQuery("GpsTipolug.findAll").getResultList();
    }

}
