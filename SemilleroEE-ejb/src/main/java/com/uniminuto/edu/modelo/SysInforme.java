/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.edu.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fercris
 */
@Entity
@Table(name = "sys_informe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysInforme.findAll", query = "SELECT s FROM SysInforme s"),
    @NamedQuery(name = "SysInforme.findByInfId", query = "SELECT s FROM SysInforme s WHERE s.infId = :infId"),
    @NamedQuery(name = "SysInforme.findByInfNombre", query = "SELECT s FROM SysInforme s WHERE s.infNombre = :infNombre"),
    @NamedQuery(name = "SysInforme.findByInfDetalle", query = "SELECT s FROM SysInforme s WHERE s.infDetalle = :infDetalle"),
    @NamedQuery(name = "SysInforme.findByInfJasper", query = "SELECT s FROM SysInforme s WHERE s.infJasper = :infJasper"),
    @NamedQuery(name = "SysInforme.findByInfJasperruta", query = "SELECT s FROM SysInforme s WHERE s.infJasperruta = :infJasperruta"),
    @NamedQuery(name = "SysInforme.findByInfEst", query = "SELECT s FROM SysInforme s WHERE s.infEst = :infEst"),
    @NamedQuery(name = "SysInforme.findByIndversion", query = "SELECT s FROM SysInforme s WHERE s.indversion = :indversion"),
    @NamedQuery(name = "SysInforme.findByNumpanel", query = "SELECT s FROM SysInforme s WHERE s.numpanel = :numpanel")})
public class SysInforme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inf_id")
    private Integer infId;
    @Size(max = 100)
    @Column(name = "inf_nombre")
    private String infNombre;
    @Size(max = 2147483647)
    @Column(name = "inf_detalle")
    private String infDetalle;
    @Size(max = 150)
    @Column(name = "inf_jasper")
    private String infJasper;
    @Size(max = 500)
    @Column(name = "inf_jasperruta")
    private String infJasperruta;
    @Column(name = "inf_est")
    private Boolean infEst;
    @Column(name = "indversion")
    private Integer indversion;
    @Column(name = "numpanel")
    private Integer numpanel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infId")
    private List<SysInfxfrn> sysInfxfrnList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infId")
    private List<SysInfxrol> sysInfxrolList;

    public SysInforme() {
    }

    public SysInforme(Integer infId) {
        this.infId = infId;
    }

    public Integer getInfId() {
        return infId;
    }

    public void setInfId(Integer infId) {
        this.infId = infId;
    }

    public String getInfNombre() {
        return infNombre;
    }

    public void setInfNombre(String infNombre) {
        this.infNombre = infNombre;
    }

    public String getInfDetalle() {
        return infDetalle;
    }

    public void setInfDetalle(String infDetalle) {
        this.infDetalle = infDetalle;
    }

    public String getInfJasper() {
        return infJasper;
    }

    public void setInfJasper(String infJasper) {
        this.infJasper = infJasper;
    }

    public String getInfJasperruta() {
        return infJasperruta;
    }

    public void setInfJasperruta(String infJasperruta) {
        this.infJasperruta = infJasperruta;
    }

    public Boolean getInfEst() {
        return infEst;
    }

    public void setInfEst(Boolean infEst) {
        this.infEst = infEst;
    }

    public Integer getIndversion() {
        return indversion;
    }

    public void setIndversion(Integer indversion) {
        this.indversion = indversion;
    }

    public Integer getNumpanel() {
        return numpanel;
    }

    public void setNumpanel(Integer numpanel) {
        this.numpanel = numpanel;
    }

    @XmlTransient
    public List<SysInfxfrn> getSysInfxfrnList() {
        return sysInfxfrnList;
    }

    public void setSysInfxfrnList(List<SysInfxfrn> sysInfxfrnList) {
        this.sysInfxfrnList = sysInfxfrnList;
    }

    @XmlTransient
    public List<SysInfxrol> getSysInfxrolList() {
        return sysInfxrolList;
    }

    public void setSysInfxrolList(List<SysInfxrol> sysInfxrolList) {
        this.sysInfxrolList = sysInfxrolList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (infId != null ? infId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysInforme)) {
            return false;
        }
        SysInforme other = (SysInforme) object;
        if ((this.infId == null && other.infId != null) || (this.infId != null && !this.infId.equals(other.infId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.edu.modelo.SysInforme[ infId=" + infId + " ]";
    }
    
}
