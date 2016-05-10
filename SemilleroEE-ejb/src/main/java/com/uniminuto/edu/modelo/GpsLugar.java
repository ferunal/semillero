/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.edu.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fercris
 */
@Entity
@Table(name = "gps_lugar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GpsLugar.findAll", query = "SELECT g FROM GpsLugar g"),
    @NamedQuery(name = "GpsLugar.findByLugId", query = "SELECT g FROM GpsLugar g WHERE g.lugId = :lugId"),
    @NamedQuery(name = "GpsLugar.findByLugNombre", query = "SELECT g FROM GpsLugar g WHERE g.lugNombre = :lugNombre"),
    @NamedQuery(name = "GpsLugar.findByLugDesc", query = "SELECT g FROM GpsLugar g WHERE g.lugDesc = :lugDesc"),
    @NamedQuery(name = "GpsLugar.findByLugLogitud", query = "SELECT g FROM GpsLugar g WHERE g.lugLogitud = :lugLogitud"),
    @NamedQuery(name = "GpsLugar.findByLugLatitud", query = "SELECT g FROM GpsLugar g WHERE g.lugLatitud = :lugLatitud"),
    @NamedQuery(name = "GpsLugar.findByLugEst", query = "SELECT g FROM GpsLugar g WHERE g.lugEst = :lugEst"),
    @NamedQuery(name = "GpsLugar.findByIndversion", query = "SELECT g FROM GpsLugar g WHERE g.indversion = :indversion"),
    @NamedQuery(name = "GpsLugar.findByLugFoto", query = "SELECT g FROM GpsLugar g WHERE g.lugFoto = :lugFoto")})
public class GpsLugar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lug_id")
    private Long lugId;
    @Size(max = 500)
    @Column(name = "lug_nombre")
    private String lugNombre;
    @Size(max = 2147483647)
    @Column(name = "lug_desc")
    private String lugDesc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "lug_logitud")
    private BigDecimal lugLogitud;
    @Column(name = "lug_latitud")
    private BigDecimal lugLatitud;
    @Column(name = "lug_est")
    private Boolean lugEst;
    @Column(name = "indversion")
    private Integer indversion;
    @Size(max = 1500)
    @Column(name = "lug_foto")
    private String lugFoto;
    @JoinColumn(name = "tlug_id", referencedColumnName = "tlug_id")
    @ManyToOne
    private GpsTipolug tlugId;
    @JoinColumn(name = "mun_id", referencedColumnName = "mun_id")
    @ManyToOne
    private SysMunicipio munId;
    @OneToMany(mappedBy = "lugId")
    private List<GpsLugxrecxfnr> gpsLugxrecxfnrList;

    public GpsLugar() {
    }

    public GpsLugar(Long lugId) {
        this.lugId = lugId;
    }

    public Long getLugId() {
        return lugId;
    }

    public void setLugId(Long lugId) {
        this.lugId = lugId;
    }

    public String getLugNombre() {
        return lugNombre;
    }

    public void setLugNombre(String lugNombre) {
        this.lugNombre = lugNombre;
    }

    public String getLugDesc() {
        return lugDesc;
    }

    public void setLugDesc(String lugDesc) {
        this.lugDesc = lugDesc;
    }

    public BigDecimal getLugLogitud() {
        return lugLogitud;
    }

    public void setLugLogitud(BigDecimal lugLogitud) {
        this.lugLogitud = lugLogitud;
    }

    public BigDecimal getLugLatitud() {
        return lugLatitud;
    }

    public void setLugLatitud(BigDecimal lugLatitud) {
        this.lugLatitud = lugLatitud;
    }

    public Boolean getLugEst() {
        return lugEst;
    }

    public void setLugEst(Boolean lugEst) {
        this.lugEst = lugEst;
    }

    public Integer getIndversion() {
        return indversion;
    }

    public void setIndversion(Integer indversion) {
        this.indversion = indversion;
    }

    public String getLugFoto() {
        return lugFoto;
    }

    public void setLugFoto(String lugFoto) {
        this.lugFoto = lugFoto;
    }

    public GpsTipolug getTlugId() {
        return tlugId;
    }

    public void setTlugId(GpsTipolug tlugId) {
        this.tlugId = tlugId;
    }

    public SysMunicipio getMunId() {
        return munId;
    }

    public void setMunId(SysMunicipio munId) {
        this.munId = munId;
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
        hash += (lugId != null ? lugId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GpsLugar)) {
            return false;
        }
        GpsLugar other = (GpsLugar) object;
        if ((this.lugId == null && other.lugId != null) || (this.lugId != null && !this.lugId.equals(other.lugId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.edu.modelo.GpsLugar[ lugId=" + lugId + " ]";
    }
    
}
