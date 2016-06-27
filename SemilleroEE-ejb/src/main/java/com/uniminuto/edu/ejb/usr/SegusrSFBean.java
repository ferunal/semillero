/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.edu.ejb.usr;

import com.uniminuto.edu.modelo.SysFuncionario;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author luz
 */
@Stateless
@LocalBean
public class SegusrSFBean {

    @PersistenceContext
    EntityManager em;

    public SysFuncionario validaringreso(SysFuncionario pSysFuncionario) {

        try {

            return (SysFuncionario) em.createNamedQuery("SysFuncionario.validarUsr").
                    setParameter("frnUsuario", pSysFuncionario.getFrnUsuario()).
                    setParameter("frnClave", pSysFuncionario.getFrnClave()).
                    setParameter("frnEstado", Boolean.TRUE).getSingleResult();

        } catch (NoResultException | NonUniqueResultException e) {

            return null;
        }
    }

    public SysFuncionario grabarFuncionario(SysFuncionario pFuncionario) {
        pFuncionario = em.merge(pFuncionario);
        return pFuncionario;
    }

    public List<SysFuncionario> getLstFuncionarios() {
        return em.createNamedQuery("SysFuncionario.findAll").getResultList();
    }

    public SysFuncionario getFuncionarioXId(String pFrnId) {
        try {
            return (SysFuncionario) em.createNamedQuery("SysFuncionario.findByFrnId").setParameter("frnId", pFrnId).getSingleResult();
        } catch (NoResultException | NonUniqueResultException e) {
            return null;
        }

    }

    public SysFuncionario getFuncionarioXUsuario(String pFrnUsuario) {
        try {
            return (SysFuncionario) em.createNamedQuery("SysFuncionario.findByFrnUsuario").setParameter("frnUsuario", pFrnUsuario).getSingleResult();
        } catch (NoResultException | NonUniqueResultException e) {
            return null;
        }

    }

}
