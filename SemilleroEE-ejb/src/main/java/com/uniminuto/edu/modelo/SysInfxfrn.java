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
@Table(name = "sys_infxfrn")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysInfxfrn.findAll", query = "SELECT s FROM SysInfxfrn s"),
    @NamedQuery(name = "SysInfxfrn.findByIfrId", query = "SELECT s FROM SysInfxfrn s WHERE s.ifrId = :ifrId"),
    @NamedQuery(name = "SysInfxfrn.findByIfrEst", query = "SELECT s FROM SysInfxfrn s WHERE s.ifrEst = :ifrEst"),
    @NamedQuery(name = "SysInfxfrn.findByIndversion", query = "SELECT s FROM SysInfxfrn s WHERE s.indversion = :indversion")})
public class SysInfxfrn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ifr_id")
    private Integer ifrId;
    @Column(name = "ifr_est")
    private Boolean ifrEst;
    @Column(name = "indversion")
    private Integer indversion;
    @JoinColumn(name = "frn_id", referencedColumnName = "frn_id")
    @ManyToOne(optional = false)
    private SysFuncionario frnId;
    @JoinColumn(name = "inf_id", referencedColumnName = "inf_id")
    @ManyToOne(optional = false)
    private SysInforme infId;

    public SysInfxfrn() {
    }

    public SysInfxfrn(Integer ifrId) {
        this.ifrId = ifrId;
    }

    public Integer getIfrId() {
        return ifrId;
    }

    public void setIfrId(Integer ifrId) {
        this.ifrId = ifrId;
    }

    public Boolean getIfrEst() {
        return ifrEst;
    }

    public void setIfrEst(Boolean ifrEst) {
        this.ifrEst = ifrEst;
    }

    public Integer getIndversion() {
        return indversion;
    }

    public void setIndversion(Integer indversion) {
        this.indversion = indversion;
    }

    public SysFuncionario getFrnId() {
        return frnId;
    }

    public void setFrnId(SysFuncionario frnId) {
        this.frnId = frnId;
    }

    public SysInforme getInfId() {
        return infId;
    }

    public void setInfId(SysInforme infId) {
        this.infId = infId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ifrId != null ? ifrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysInfxfrn)) {
            return false;
        }
        SysInfxfrn other = (SysInfxfrn) object;
        if ((this.ifrId == null && other.ifrId != null) || (this.ifrId != null && !this.ifrId.equals(other.ifrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.edu.modelo.SysInfxfrn[ ifrId=" + ifrId + " ]";
    }
    
}
