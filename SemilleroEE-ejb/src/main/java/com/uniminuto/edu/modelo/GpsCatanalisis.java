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
@Table(name = "gps_catanalisis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GpsCatanalisis.findAll", query = "SELECT g FROM GpsCatanalisis g"),
    @NamedQuery(name = "GpsCatanalisis.findByCataId", query = "SELECT g FROM GpsCatanalisis g WHERE g.cataId = :cataId"),
    @NamedQuery(name = "GpsCatanalisis.findByCataNombre", query = "SELECT g FROM GpsCatanalisis g WHERE g.cataNombre = :cataNombre"),
    @NamedQuery(name = "GpsCatanalisis.findByCataDesc", query = "SELECT g FROM GpsCatanalisis g WHERE g.cataDesc = :cataDesc"),
    @NamedQuery(name = "GpsCatanalisis.findByCataEst", query = "SELECT g FROM GpsCatanalisis g WHERE g.cataEst = :cataEst")})
public class GpsCatanalisis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cata_id")
    private Integer cataId;
    @Size(max = 50)
    @Column(name = "cata_nombre")
    private String cataNombre;
    @Size(max = 2147483647)
    @Column(name = "cata_desc")
    private String cataDesc;
    @Column(name = "cata_est")
    private Boolean cataEst;
    @OneToMany(mappedBy = "cataId")
    private List<GpsPercepcion> gpsPercepcionList;

    public GpsCatanalisis() {
    }

    public GpsCatanalisis(Integer cataId) {
        this.cataId = cataId;
    }

    public Integer getCataId() {
        return cataId;
    }

    public void setCataId(Integer cataId) {
        this.cataId = cataId;
    }

    public String getCataNombre() {
        return cataNombre;
    }

    public void setCataNombre(String cataNombre) {
        this.cataNombre = cataNombre;
    }

    public String getCataDesc() {
        return cataDesc;
    }

    public void setCataDesc(String cataDesc) {
        this.cataDesc = cataDesc;
    }

    public Boolean getCataEst() {
        return cataEst;
    }

    public void setCataEst(Boolean cataEst) {
        this.cataEst = cataEst;
    }

    @XmlTransient
    public List<GpsPercepcion> getGpsPercepcionList() {
        return gpsPercepcionList;
    }

    public void setGpsPercepcionList(List<GpsPercepcion> gpsPercepcionList) {
        this.gpsPercepcionList = gpsPercepcionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cataId != null ? cataId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GpsCatanalisis)) {
            return false;
        }
        GpsCatanalisis other = (GpsCatanalisis) object;
        if ((this.cataId == null && other.cataId != null) || (this.cataId != null && !this.cataId.equals(other.cataId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.edu.modelo.GpsCatanalisis[ cataId=" + cataId + " ]";
    }
    
}
