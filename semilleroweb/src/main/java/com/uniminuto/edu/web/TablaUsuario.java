/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.edu.web;

import com.uniminuto.edu.modelo.SysFuncionario;
import java.util.Objects;

/**
 *
 * @author fercris
 */
public class TablaUsuario extends TablaBaseFrm {

    private SysFuncionario sysFuncionario = new SysFuncionario();

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.sysFuncionario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TablaUsuario other = (TablaUsuario) obj;
        return Objects.equals(this.sysFuncionario, other.sysFuncionario);
    }

    public TablaUsuario() {
    }

    public TablaUsuario(SysFuncionario pSysFuncionario) {
        this.sysFuncionario = pSysFuncionario;
    }

    /**
     * @return the sysFuncionario
     */
    public SysFuncionario getSysFuncionario() {
        return sysFuncionario;
    }

    /**
     * @param sysFuncionario the sysFuncionario to set
     */
    public void setSysFuncionario(SysFuncionario sysFuncionario) {
        this.sysFuncionario = sysFuncionario;
    }

}
