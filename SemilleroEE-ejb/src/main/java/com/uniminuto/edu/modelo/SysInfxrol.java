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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fercris
 */
@Entity
@Table(name = "sys_infxrol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysInfxrol.findAll", query = "SELECT s FROM SysInfxrol s"),
    @NamedQuery(name = "SysInfxrol.findByInrId", query = "SELECT s FROM SysInfxrol s WHERE s.inrId = :inrId"),
    @NamedQuery(name = "SysInfxrol.findByInrEst", query = "SELECT s FROM SysInfxrol s WHERE s.inrEst = :inrEst"),
    @NamedQuery(name = "SysInfxrol.findByIndversion", query = "SELECT s FROM SysInfxrol s WHERE s.indversion = :indversion")})
public class SysInfxrol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inr_id")
    private Integer inrId;
    @Column(name = "inr_est")
    private Boolean inrEst;
    @Column(name = "indversion")
    private Integer indversion;
    @JoinColumn(name = "inf_id", referencedColumnName = "inf_id")
    @ManyToOne(optional = false)
    private SysInforme infId;
    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
    @ManyToOne(optional = false)
    private SysRol rolId;

    public SysInfxrol() {
    }

    public SysInfxrol(Integer inrId) {
        this.inrId = inrId;
    }

    public Integer getInrId() {
        return inrId;
    }

    public void setInrId(Integer inrId) {
        this.inrId = inrId;
    }

    public Boolean getInrEst() {
        return inrEst;
    }

    public void setInrEst(Boolean inrEst) {
        this.inrEst = inrEst;
    }

    public Integer getIndversion() {
        return indversion;
    }

    public void setIndversion(Integer indversion) {
        this.indversion = indversion;
    }

    public SysInforme getInfId() {
        return infId;
    }

    public void setInfId(SysInforme infId) {
        this.infId = infId;
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
        hash += (inrId != null ? inrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysInfxrol)) {
            return false;
        }
        SysInfxrol other = (SysInfxrol) object;
        if ((this.inrId == null && other.inrId != null) || (this.inrId != null && !this.inrId.equals(other.inrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.edu.modelo.SysInfxrol[ inrId=" + inrId + " ]";
    }
    
}
