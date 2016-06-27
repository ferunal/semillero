/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.edu.web;

import com.uniminuto.edu.ejb.usr.SegusrSFBean;
import com.uniminuto.edu.modelo.SysFuncionario;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author luz
 */
@SessionScoped //Las instancias de esa clase van a estar en la sesion web
@Named // La clase puede ser visible por los controles del JSF, puedo identificar la clase por nombre
public class AdministracionJSFBean extends BaseJSFBean implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="Variables">
    @EJB
    SegusrSFBean ssfb;
    SysFuncionario funcActual = new SysFuncionario();

    private String strClave1;
    private String strClave2;
    private TablaUsuario tablaUsuarioSel = new TablaUsuario();
    private List<TablaUsuario> lstTablaUsuarios = new ArrayList<>();

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Funciones de bean">
    public void registrarUsuario_AE() {
        SysFuncionario sfXId = ssfb.getFuncionarioXId(tablaUsuarioSel.getSysFuncionario().getFrnId());
        if (strClave1.equals(strClave2)) {
            if (sfXId == null) {
                if (ssfb.getFuncionarioXUsuario(tablaUsuarioSel.getSysFuncionario().getFrnUsuario()) == null) {
                    tablaUsuarioSel.getSysFuncionario().setFrnClave(strClave1);
                    tablaUsuarioSel.getSysFuncionario().setFrnEstado(Boolean.TRUE);
                    tablaUsuarioSel.setSysFuncionario(ssfb.grabarFuncionario(tablaUsuarioSel.getSysFuncionario()));
                    mostrarMensaje("Usuario grabado correctamente", "Info:", 3);
                    tablaUsuarioSel = new TablaUsuario();
                    strClave1 = "";
                    strClave2 = "";
                }
                mostrarMensaje("Usuario ya existe", "Error:", 1);
            } else {
                mostrarMensaje("Usuario por número de documento ya existe", "Error:", 1);
            }
        } else {
            mostrarMensaje("Claves no coinciden", "Error:", 1);
        }

    }

    public String validarUsuario_A() {
        return navegacion;
    }

    public void validarUsuario_AE() {
        tablaUsuarioSel.getSysFuncionario().setFrnClave(strClave1);
        funcActual = ssfb.validaringreso(tablaUsuarioSel.getSysFuncionario());
        if (funcActual != null) {
            try {
                HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                session.setAttribute("funcionario", funcActual);
                FacesContext.getCurrentInstance().getExternalContext().redirect("CargarImagen.jsp");
                navegacion = "ingresar";
            } catch (IOException ex) {
                Logger.getLogger(AdministracionJSFBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
             mostrarMensaje("Usuario o clave incorrecto ", "Error:", 1);
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Funciones heredadas">
    @Override
    public void init() {
    }

    @Override
    public void limpiarVariables() {
    }

    @Override
    public void navegacionLateral_ActionEvent(ActionEvent ae) {
    }

    @Override
    public boolean validarFormulario() {
        return true;
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Propiedades">
    public TablaUsuario getTablaUsuarioSel() {
        return tablaUsuarioSel;
    }

    public void setTablaUsuarioSel(TablaUsuario tablaUsuarioSel) {
        this.tablaUsuarioSel = tablaUsuarioSel;
    }

    public List<TablaUsuario> getLstTablaUsuarios() {
        return lstTablaUsuarios;
    }

    public void setLstTablaUsuarios(List<TablaUsuario> lstTablaUsuarios) {
        this.lstTablaUsuarios = lstTablaUsuarios;
    }
//</editor-fold>

    /**
     * @return the strClave1
     */
    public String getStrClave1() {
        return strClave1;
    }

    /**
     * @param strClave1 the strClave1 to set
     */
    public void setStrClave1(String strClave1) {
        this.strClave1 = strClave1;
    }

    /**
     * @return the strClave2
     */
    public String getStrClave2() {
        return strClave2;
    }

    /**
     * @param strClave2 the strClave2 to set
     */
    public void setStrClave2(String strClave2) {
        this.strClave2 = strClave2;
    }
}
