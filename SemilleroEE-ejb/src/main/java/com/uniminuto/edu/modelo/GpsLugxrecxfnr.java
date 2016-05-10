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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fercris
 */
@Entity
@Table(name = "gps_lugxrecxfnr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GpsLugxrecxfnr.findAll", query = "SELECT g FROM GpsLugxrecxfnr g"),
    @NamedQuery(name = "GpsLugxrecxfnr.findByLxrxfId", query = "SELECT g FROM GpsLugxrecxfnr g WHERE g.lxrxfId = :lxrxfId"),
    @NamedQuery(name = "GpsLugxrecxfnr.findByLxrxfEst", query = "SELECT g FROM GpsLugxrecxfnr g WHERE g.lxrxfEst = :lxrxfEst"),
    @NamedQuery(name = "GpsLugxrecxfnr.findByLxrxfFechacre", query = "SELECT g FROM GpsLugxrecxfnr g WHERE g.lxrxfFechacre = :lxrxfFechacre"),
    @NamedQuery(name = "GpsLugxrecxfnr.findByIndversion", query = "SELECT g FROM GpsLugxrecxfnr g WHERE g.indversion = :indversion")})
public class GpsLugxrecxfnr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lxrxf_id")
    private Long lxrxfId;
    @Column(name = "lxrxf_est")
    private Boolean lxrxfEst;
    @Column(name = "lxrxf_fechacre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lxrxfFechacre;
    @Column(name = "indversion")
    private Integer indversion;
    @JoinColumn(name = "lug_id", referencedColumnName = "lug_id")
    @ManyToOne
    private GpsLugar lugId;
    @JoinColumn(name = "rec_id", referencedColumnName = "rec_id")
    @ManyToOne
    private GpsRecorrido recId;
    @JoinColumn(name = "fnr_id", referencedColumnName = "frn_id")
    @ManyToOne
    private SysFuncionario fnrId;
    @OneToMany(mappedBy = "lxrxfId")
    private List<GpsPercepcion> gpsPercepcionList;

    public GpsLugxrecxfnr() {
    }

    public GpsLugxrecxfnr(Long lxrxfId) {
        this.lxrxfId = lxrxfId;
    }

    public Long getLxrxfId() {
        return lxrxfId;
    }

    public void setLxrxfId(Long lxrxfId) {
        this.lxrxfId = lxrxfId;
    }

    public Boolean getLxrxfEst() {
        return lxrxfEst;
    }

    public void setLxrxfEst(Boolean lxrxfEst) {
        this.lxrxfEst = lxrxfEst;
    }

    public Date getLxrxfFechacre() {
        return lxrxfFechacre;
    }

    public void setLxrxfFechacre(Date lxrxfFechacre) {
        this.lxrxfFechacre = lxrxfFechacre;
    }

    public Integer getIndversion() {
        return indversion;
    }

    public void setIndversion(Integer indversion) {
        this.indversion = indversion;
    }

    public GpsLugar getLugId() {
        return lugId;
    }

    public void setLugId(GpsLugar lugId) {
        this.lugId = lugId;
    }

    public GpsRecorrido getRecId() {
        return recId;
    }

    public void setRecId(GpsRecorrido recId) {
        this.recId = recId;
    }

    public SysFuncionario getFnrId() {
        return fnrId;
    }

    public void setFnrId(SysFuncionario fnrId) {
        this.fnrId = fnrId;
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
        hash += (lxrxfId != null ? lxrxfId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GpsLugxrecxfnr)) {
            return false;
        }
        GpsLugxrecxfnr other = (GpsLugxrecxfnr) object;
        if ((this.lxrxfId == null && other.lxrxfId != null) || (this.lxrxfId != null && !this.lxrxfId.equals(other.lxrxfId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.edu.modelo.GpsLugxrecxfnr[ lxrxfId=" + lxrxfId + " ]";
    }
    
}
