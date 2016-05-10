/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.edu.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fercris
 */
@Entity
@Table(name = "gps_recorrido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GpsRecorrido.findAll", query = "SELECT g FROM GpsRecorrido g"),
    @NamedQuery(name = "GpsRecorrido.findByRecId", query = "SELECT g FROM GpsRecorrido g WHERE g.recId = :recId"),
    @NamedQuery(name = "GpsRecorrido.findByRecFechacre", query = "SELECT g FROM GpsRecorrido g WHERE g.recFechacre = :recFechacre"),
    @NamedQuery(name = "GpsRecorrido.findByFnrId", query = "SELECT g FROM GpsRecorrido g WHERE g.fnrId = :fnrId"),
    @NamedQuery(name = "GpsRecorrido.findByRecEst", query = "SELECT g FROM GpsRecorrido g WHERE g.recEst = :recEst")})
public class GpsRecorrido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rec_id")
    private Long recId;
    @Column(name = "rec_fechacre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recFechacre;
    @Size(max = 50)
    @Column(name = "fnr_id")
    private String fnrId;
    @Column(name = "rec_est")
    private Boolean recEst;
    @OneToMany(mappedBy = "recId")
    private List<GpsLugxrecxfnr> gpsLugxrecxfnrList;

    public GpsRecorrido() {
    }

    public GpsRecorrido(Long recId) {
        this.recId = recId;
    }

    public Long getRecId() {
        return recId;
    }

    public void setRecId(Long recId) {
        this.recId = recId;
    }

    public Date getRecFechacre() {
        return recFechacre;
    }

    public void setRecFechacre(Date recFechacre) {
        this.recFechacre = recFechacre;
    }

    public String getFnrId() {
        return fnrId;
    }

    public void setFnrId(String fnrId) {
        this.fnrId = fnrId;
    }

    public Boolean getRecEst() {
        return recEst;
    }

    public void setRecEst(Boolean recEst) {
        this.recEst = recEst;
    }

    @XmlTransient
    public List<GpsLugxrecxfnr> getGpsLugxrecxfnrList() {
        return gpsLugxrecxfnrList;
    }

    public void setGpsLugxrecxfnrList(List<GpsLugxrecxfnr> gpsLugxrecxfnrList) {
        this.gpsLugxrecxfnrList = gpsLugxrecxfnrList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recId != null ? recId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GpsRecorrido)) {
            return false;
        }
        GpsRecorrido other = (GpsRecorrido) object;
        if ((this.recId == null && other.recId != null) || (this.recId != null && !this.recId.equals(other.recId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.edu.modelo.GpsRecorrido[ recId=" + recId + " ]";
    }
    
}
