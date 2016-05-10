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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fercris
 */
@Entity
@Table(name = "sys_detfuncionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysDetfuncionario.findAll", query = "SELECT s FROM SysDetfuncionario s"),
    @NamedQuery(name = "SysDetfuncionario.findByFnrId", query = "SELECT s FROM SysDetfuncionario s WHERE s.fnrId = :fnrId"),
    @NamedQuery(name = "SysDetfuncionario.findByFnrDireccion1", query = "SELECT s FROM SysDetfuncionario s WHERE s.fnrDireccion1 = :fnrDireccion1"),
    @NamedQuery(name = "SysDetfuncionario.findByFnrDireccion2", query = "SELECT s FROM SysDetfuncionario s WHERE s.fnrDireccion2 = :fnrDireccion2"),
    @NamedQuery(name = "SysDetfuncionario.findByFnrTelefono", query = "SELECT s FROM SysDetfuncionario s WHERE s.fnrTelefono = :fnrTelefono"),
    @NamedQuery(name = "SysDetfuncionario.findByFnrCedular", query = "SELECT s FROM SysDetfuncionario s WHERE s.fnrCedular = :fnrCedular"),
    @NamedQuery(name = "SysDetfuncionario.findByFnrCorreoe", query = "SELECT s FROM SysDetfuncionario s WHERE s.fnrCorreoe = :fnrCorreoe"),
    @NamedQuery(name = "SysDetfuncionario.findByFnrCorreoealt", query = "SELECT s FROM SysDetfuncionario s WHERE s.fnrCorreoealt = :fnrCorreoealt"),
    @NamedQuery(name = "SysDetfuncionario.findByFnrFealta", query = "SELECT s FROM SysDetfuncionario s WHERE s.fnrFealta = :fnrFealta")})
public class SysDetfuncionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "fnr_id")
    private String fnrId;
    @Size(max = 2147483647)
    @Column(name = "fnr_direccion1")
    private String fnrDireccion1;
    @Size(max = 2147483647)
    @Column(name = "fnr_direccion2")
    private String fnrDireccion2;
    @Size(max = 50)
    @Column(name = "fnr_telefono")
    private String fnrTelefono;
    @Size(max = 50)
    @Column(name = "fnr_cedular")
    private String fnrCedular;
    @Size(max = 50)
    @Column(name = "fnr_correoe")
    private String fnrCorreoe;
    @Size(max = 50)
    @Column(name = "fnr_correoealt")
    private String fnrCorreoealt;
    @Column(name = "fnr_fealta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fnrFealta;
    @JoinColumn(name = "fnr_id", referencedColumnName = "frn_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private SysFuncionario sysFuncionario;

    public SysDetfuncionario() {
    }

    public SysDetfuncionario(String fnrId) {
        this.fnrId = fnrId;
    }

    public String getFnrId() {
        return fnrId;
    }

    public void setFnrId(String fnrId) {
        this.fnrId = fnrId;
    }

    public String getFnrDireccion1() {
        return fnrDireccion1;
    }

    public void setFnrDireccion1(String fnrDireccion1) {
        this.fnrDireccion1 = fnrDireccion1;
    }

    public String getFnrDireccion2() {
        return fnrDireccion2;
    }

    public void setFnrDireccion2(String fnrDireccion2) {
        this.fnrDireccion2 = fnrDireccion2;
    }

    public String getFnrTelefono() {
        return fnrTelefono;
    }

    public void setFnrTelefono(String fnrTelefono) {
        this.fnrTelefono = fnrTelefono;
    }

    public String getFnrCedular() {
        return fnrCedular;
    }

    public void setFnrCedular(String fnrCedular) {
        this.fnrCedular = fnrCedular;
    }

    public String getFnrCorreoe() {
        return fnrCorreoe;
    }

    public void setFnrCorreoe(String fnrCorreoe) {
        this.fnrCorreoe = fnrCorreoe;
    }

    public String getFnrCorreoealt() {
        return fnrCorreoealt;
    }

    public void setFnrCorreoealt(String fnrCorreoealt) {
        this.fnrCorreoealt = fnrCorreoealt;
    }

    public Date getFnrFealta() {
        return fnrFealta;
    }

    public void setFnrFealta(Date fnrFealta) {
        this.fnrFealta = fnrFealta;
    }

    public SysFuncionario getSysFuncionario() {
        return sysFuncionario;
    }

    public void setSysFuncionario(SysFuncionario sysFuncionario) {
        this.sysFuncionario = sysFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fnrId != null ? fnrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysDetfuncionario)) {
            return false;
        }
        SysDetfuncionario other = (SysDetfuncionario) object;
        if ((this.fnrId == null && other.fnrId != null) || (this.fnrId != null && !this.fnrId.equals(other.fnrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.edu.modelo.SysDetfuncionario[ fnrId=" + fnrId + " ]";
    }
    
}
