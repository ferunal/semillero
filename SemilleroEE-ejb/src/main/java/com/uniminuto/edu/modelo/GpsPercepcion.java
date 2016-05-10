/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.edu.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fercris
 */
@Entity
@Table(name = "gps_percepcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GpsPercepcion.findAll", query = "SELECT g FROM GpsPercepcion g"),
    @NamedQuery(name = "GpsPercepcion.findByPerId", query = "SELECT g FROM GpsPercepcion g WHERE g.perId = :perId"),
    @NamedQuery(name = "GpsPercepcion.findByPerObsr", query = "SELECT g FROM GpsPercepcion g WHERE g.perObsr = :perObsr"),
    @NamedQuery(name = "GpsPercepcion.findByPerNivel", query = "SELECT g FROM GpsPercepcion g WHERE g.perNivel = :perNivel"),
    @NamedQuery(name = "GpsPercepcion.findByPerFechacre", query = "SELECT g FROM GpsPercepcion g WHERE g.perFechacre = :perFechacre")})
public class GpsPercepcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "per_id")
    private Long perId;
    @Size(max = 2147483647)
    @Column(name = "per_obsr")
    private String perObsr;
    @Column(name = "per_nivel")
    private Integer perNivel;
    @Column(name = "per_fechacre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perFechacre;
    @JoinColumn(name = "cata_id", referencedColumnName = "cata_id")
    @ManyToOne
    private GpsCatanalisis cataId;
    @JoinColumn(name = "lxrxf_id", referencedColumnName = "lxrxf_id")
    @ManyToOne
    private GpsLugxrecxfnr lxrxfId;

    public GpsPercepcion() {
    }

    public GpsPercepcion(Long perId) {
        this.perId = perId;
    }

    public Long getPerId() {
        return perId;
    }

    public void setPerId(Long perId) {
        this.perId = perId;
    }

    public String getPerObsr() {
        return perObsr;
    }

    public void setPerObsr(String perObsr) {
        this.perObsr = perObsr;
    }

    public Integer getPerNivel() {
        return perNivel;
    }

    public void setPerNivel(Integer perNivel) {
        this.perNivel = perNivel;
    }

    public Date getPerFechacre() {
        return perFechacre;
    }

    public void setPerFechacre(Date perFechacre) {
        this.perFechacre = perFechacre;
    }

    public GpsCatanalisis getCataId() {
        return cataId;
    }

    public void setCataId(GpsCatanalisis cataId) {
        this.cataId = cataId;
    }

    public GpsLugxrecxfnr getLxrxfId() {
        return lxrxfId;
    }

    public void setLxrxfId(GpsLugxrecxfnr lxrxfId) {
        this.lxrxfId = lxrxfId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perId != null ? perId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GpsPercepcion)) {
            return false;
        }
        GpsPercepcion other = (GpsPercepcion) object;
        if ((this.perId == null && other.perId != null) || (this.perId != null && !this.perId.equals(other.perId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.edu.modelo.GpsPercepcion[ perId=" + perId + " ]";
    }
    
}
