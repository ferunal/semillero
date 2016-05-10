/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.edu.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fercris
 */
@Entity
@Table(name = "sys_rolxfrn")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysRolxfrn.findAll", query = "SELECT s FROM SysRolxfrn s"),
    @NamedQuery(name = "SysRolxfrn.findByRlfrId", query = "SELECT s FROM SysRolxfrn s WHERE s.rlfrId = :rlfrId"),
    @NamedQuery(name = "SysRolxfrn.findByRlfrEstado", query = "SELECT s FROM SysRolxfrn s WHERE s.rlfrEstado = :rlfrEstado")})
public class SysRolxfrn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "rlfr_id")
    private Integer rlfrId;
    @Column(name = "rlfr_estado")
    private Boolean rlfrEstado;
    @JoinColumn(name = "frn_id", referencedColumnName = "frn_id")
    @ManyToOne
    private SysFuncionario frnId;
    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
    @ManyToOne
    private SysRol rolId;

    public SysRolxfrn() {
    }

    public SysRolxfrn(Integer rlfrId) {
        this.rlfrId = rlfrId;
    }

    public Integer getRlfrId() {
        return rlfrId;
    }

    public void setRlfrId(Integer rlfrId) {
        this.rlfrId = rlfrId;
    }

    public Boolean getRlfrEstado() {
        return rlfrEstado;
    }

    public void setRlfrEstado(Boolean rlfrEstado) {
        this.rlfrEstado = rlfrEstado;
    }

    public SysFuncionario getFrnId() {
        return frnId;
    }

    public void setFrnId(SysFuncionario frnId) {
        this.frnId = frnId;
    }

    public SysRol getRolId() {
        return rolId;
    }

    public void setRolId(SysRol rolId) {
        this.rolId = rolId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rlfrId != null ? rlfrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysRolxfrn)) {
            return false;
        }
        SysRolxfrn other = (SysRolxfrn) object;
        if ((this.rlfrId == null && other.rlfrId != null) || (this.rlfrId != null && !this.rlfrId.equals(other.rlfrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.edu.modelo.SysRolxfrn[ rlfrId=" + rlfrId + " ]";
    }
    
}
