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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "sys_municipio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysMunicipio.findAll", query = "SELECT s FROM SysMunicipio s"),
    @NamedQuery(name = "SysMunicipio.findByMunId", query = "SELECT s FROM SysMunicipio s WHERE s.munId = :munId"),
    @NamedQuery(name = "SysMunicipio.findByMunNombre", query = "SELECT s FROM SysMunicipio s WHERE s.munNombre = :munNombre"),
    @NamedQuery(name = "SysMunicipio.findByMunDesc", query = "SELECT s FROM SysMunicipio s WHERE s.munDesc = :munDesc"),
    @NamedQuery(name = "SysMunicipio.findByMunCapital", query = "SELECT s FROM SysMunicipio s WHERE s.munCapital = :munCapital"),
    @NamedQuery(name = "SysMunicipio.findByMunEst", query = "SELECT s FROM SysMunicipio s WHERE s.munEst = :munEst")})
public class SysMunicipio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "mun_id")
    private Long munId;
    @Size(max = 50)
    @Column(name = "mun_nombre")
    private String munNombre;
    @Size(max = 2147483647)
    @Column(name = "mun_desc")
    private String munDesc;
    @Column(name = "mun_capital")
    private Boolean munCapital;
    @Column(name = "mun_est")
    private Boolean munEst;
    @JoinColumn(name = "dep_id", referencedColumnName = "dep_id")
    @ManyToOne
    private SysDepartamento depId;
    @OneToMany(mappedBy = "munId")
    private List<GpsLugar> gpsLugarList;

    public SysMunicipio() {
    }

    public SysMunicipio(Long munId) {
        this.munId = munId;
    }

    public Long getMunId() {
        return munId;
    }

    public void setMunId(Long munId) {
        this.munId = munId;
    }

    public String getMunNombre() {
        return munNombre;
    }

    public void setMunNombre(String munNombre) {
        this.munNombre = munNombre;
    }

    public String getMunDesc() {
        return munDesc;
    }

    public void setMunDesc(String munDesc) {
        this.munDesc = munDesc;
    }

    public Boolean getMunCapital() {
        return munCapital;
    }

    public void setMunCapital(Boolean munCapital) {
        this.munCapital = munCapital;
    }

    public Boolean getMunEst() {
        return munEst;
    }

    public void setMunEst(Boolean munEst) {
        this.munEst = munEst;
    }

    public SysDepartamento getDepId() {
        return depId;
    }

    public void setDepId(SysDepartamento depId) {
        this.depId = depId;
    }

    @XmlTransient
    public List<GpsLugar> getGpsLugarList() {
        return gpsLugarList;
    }

    public void setGpsLugarList(List<GpsLugar> gpsLugarList) {
        this.gpsLugarList = gpsLugarList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (munId != null ? munId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysMunicipio)) {
            return false;
        }
        SysMunicipio other = (SysMunicipio) object;
        if ((this.munId == null && other.munId != null) || (this.munId != null && !this.munId.equals(other.munId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.edu.modelo.SysMunicipio[ munId=" + munId + " ]";
    }
    
}
