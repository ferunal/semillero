/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.edu.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fercris
 */
@Entity
@Table(name = "sys_departamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysDepartamento.findAll", query = "SELECT s FROM SysDepartamento s"),
    @NamedQuery(name = "SysDepartamento.findByDepId", query = "SELECT s FROM SysDepartamento s WHERE s.depId = :depId"),
    @NamedQuery(name = "SysDepartamento.findByDepNombre", query = "SELECT s FROM SysDepartamento s WHERE s.depNombre = :depNombre"),
    @NamedQuery(name = "SysDepartamento.findByDepDesc", query = "SELECT s FROM SysDepartamento s WHERE s.depDesc = :depDesc"),
    @NamedQuery(name = "SysDepartamento.findByDepEst", query = "SELECT s FROM SysDepartamento s WHERE s.depEst = :depEst")})
public class SysDepartamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "dep_id")
    private Long depId;
    @Size(max = 50)
    @Column(name = "dep_nombre")
    private String depNombre;
    @Size(max = 2147483647)
    @Column(name = "dep_desc")
    private String depDesc;
    @Column(name = "dep_est")
    private Boolean depEst;
    @OneToMany(mappedBy = "depId")
    private List<SysMunicipio> sysMunicipioList;

    public SysDepartamento() {
    }

    public SysDepartamento(Long depId) {
        this.depId = depId;
    }

    public Long getDepId() {
        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
    }

    public String getDepNombre() {
        return depNombre;
    }

    public void setDepNombre(String depNombre) {
        this.depNombre = depNombre;
    }

    public String getDepDesc() {
        return depDesc;
    }

    public void setDepDesc(String depDesc) {
        this.depDesc = depDesc;
    }

    public Boolean getDepEst() {
        return depEst;
    }

    public void setDepEst(Boolean depEst) {
        this.depEst = depEst;
    }

    @XmlTransient
    public List<SysMunicipio> getSysMunicipioList() {
        return sysMunicipioList;
    }

    public void setSysMunicipioList(List<SysMunicipio> sysMunicipioList) {
        this.sysMunicipioList = sysMunicipioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (depId != null ? depId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysDepartamento)) {
            return false;
        }
        SysDepartamento other = (SysDepartamento) object;
        if ((this.depId == null && other.depId != null) || (this.depId != null && !this.depId.equals(other.depId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.edu.modelo.SysDepartamento[ depId=" + depId + " ]";
    }
    
}
