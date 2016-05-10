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
@Table(name = "sys_submodproc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysSubmodproc.findAll", query = "SELECT s FROM SysSubmodproc s"),
    @NamedQuery(name = "SysSubmodproc.findBySubId", query = "SELECT s FROM SysSubmodproc s WHERE s.subId = :subId"),
    @NamedQuery(name = "SysSubmodproc.findBySubNombre", query = "SELECT s FROM SysSubmodproc s WHERE s.subNombre = :subNombre"),
    @NamedQuery(name = "SysSubmodproc.findBySubDesc", query = "SELECT s FROM SysSubmodproc s WHERE s.subDesc = :subDesc"),
    @NamedQuery(name = "SysSubmodproc.findBySubReglanav", query = "SELECT s FROM SysSubmodproc s WHERE s.subReglanav = :subReglanav"),
    @NamedQuery(name = "SysSubmodproc.findBySubJsfbean", query = "SELECT s FROM SysSubmodproc s WHERE s.subJsfbean = :subJsfbean")})
public class SysSubmodproc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "sub_id")
    private Integer subId;
    @Size(max = 250)
    @Column(name = "sub_nombre")
    private String subNombre;
    @Size(max = 2147483647)
    @Column(name = "sub_desc")
    private String subDesc;
    @Size(max = 150)
    @Column(name = "sub_reglanav")
    private String subReglanav;
    @Size(max = 150)
    @Column(name = "sub_jsfbean")
    private String subJsfbean;
    @OneToMany(mappedBy = "subId")
    private List<SysSubmodxfrn> sysSubmodxfrnList;
    @JoinColumn(name = "proc_id", referencedColumnName = "proc_id")
    @ManyToOne
    private SysModulos procId;
    @OneToMany(mappedBy = "subId")
    private List<SysSubmodxrol> sysSubmodxrolList;

    public SysSubmodproc() {
    }

    public SysSubmodproc(Integer subId) {
        this.subId = subId;
    }

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public String getSubNombre() {
        return subNombre;
    }

    public void setSubNombre(String subNombre) {
        this.subNombre = subNombre;
    }

    public String getSubDesc() {
        return subDesc;
    }

    public void setSubDesc(String subDesc) {
        this.subDesc = subDesc;
    }

    public String getSubReglanav() {
        return subReglanav;
    }

    public void setSubReglanav(String subReglanav) {
        this.subReglanav = subReglanav;
    }

    public String getSubJsfbean() {
        return subJsfbean;
    }

    public void setSubJsfbean(String subJsfbean) {
        this.subJsfbean = subJsfbean;
    }

    @XmlTransient
    public List<SysSubmodxfrn> getSysSubmodxfrnList() {
        return sysSubmodxfrnList;
    }

    public void setSysSubmodxfrnList(List<SysSubmodxfrn> sysSubmodxfrnList) {
        this.sysSubmodxfrnList = sysSubmodxfrnList;
    }

    public SysModulos getProcId() {
        return procId;
    }

    public void setProcId(SysModulos procId) {
        this.procId = procId;
    }

    @XmlTransient
    public List<SysSubmodxrol> getSysSubmodxrolList() {
        return sysSubmodxrolList;
    }

    public void setSysSubmodxrolList(List<SysSubmodxrol> sysSubmodxrolList) {
        this.sysSubmodxrolList = sysSubmodxrolList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subId != null ? subId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysSubmodproc)) {
            return false;
        }
        SysSubmodproc other = (SysSubmodproc) object;
        if ((this.subId == null && other.subId != null) || (this.subId != null && !this.subId.equals(other.subId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.edu.modelo.SysSubmodproc[ subId=" + subId + " ]";
    }
    
}
