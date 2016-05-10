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
@Table(name = "gps_tipolug")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GpsTipolug.findAll", query = "SELECT g FROM GpsTipolug g"),
    @NamedQuery(name = "GpsTipolug.findByTlugId", query = "SELECT g FROM GpsTipolug g WHERE g.tlugId = :tlugId"),
    @NamedQuery(name = "GpsTipolug.findByTlugNombre", query = "SELECT g FROM GpsTipolug g WHERE g.tlugNombre = :tlugNombre"),
    @NamedQuery(name = "GpsTipolug.findByTlugDesc", query = "SELECT g FROM GpsTipolug g WHERE g.tlugDesc = :tlugDesc"),
    @NamedQuery(name = "GpsTipolug.findByTlugEst", query = "SELECT g FROM GpsTipolug g WHERE g.tlugEst = :tlugEst")})
public class GpsTipolug implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tlug_id")
    private Integer tlugId;
    @Size(max = 100)
    @Column(name = "tlug_nombre")
    private String tlugNombre;
    @Size(max = 500)
    @Column(name = "tlug_desc")
    private String tlugDesc;
    @Column(name = "tlug_est")
    private Boolean tlugEst;
    @OneToMany(mappedBy = "tlugId")
    private List<GpsLugar> gpsLugarList;

    public GpsTipolug() {
    }

    public GpsTipolug(Integer tlugId) {
        this.tlugId = tlugId;
    }

    public Integer getTlugId() {
        return tlugId;
    }

    public void setTlugId(Integer tlugId) {
        this.tlugId = tlugId;
    }

    public String getTlugNombre() {
        return tlugNombre;
    }

    public void setTlugNombre(String tlugNombre) {
        this.tlugNombre = tlugNombre;
    }

    public String getTlugDesc() {
        return tlugDesc;
    }

    public void setTlugDesc(String tlugDesc) {
        this.tlugDesc = tlugDesc;
    }

    public Boolean getTlugEst() {
        return tlugEst;
    }

    public void setTlugEst(Boolean tlugEst) {
        this.tlugEst = tlugEst;
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
        hash += (tlugId != null ? tlugId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GpsTipolug)) {
            return false;
        }
        GpsTipolug other = (GpsTipolug) object;
        if ((this.tlugId == null && other.tlugId != null) || (this.tlugId != null && !this.tlugId.equals(other.tlugId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.edu.modelo.GpsTipolug[ tlugId=" + tlugId + " ]";
    }
    
}
