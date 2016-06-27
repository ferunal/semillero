/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.edu.web;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipOutputStream;
import javax.annotation.Resource;
import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.sql.DataSource;
import org.icefaces.util.JavaScriptRunner;

/**
 *
 * @author fer
 */
public abstract class BaseJSFBean implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="Variables">
    @Resource(name = "jdbcVeeduria")
    protected DataSource jdbcVeeduria;
    protected String ruta_recursos = "/WEB-INF/classes/reportes/";

    protected SelectItem itemSeleccioneStr = new SelectItem("-1", "Seleccione>>");
    protected SelectItem itemSeleccioneInt = new SelectItem(-1, "Seleccione>>");
    protected SelectItem itemSeleccioneLng = new SelectItem(-1l, "Seleccione>>");
    protected FacesContext fc = FacesContext.getCurrentInstance();
    protected ELContext elc;
    protected Integer numPanel = 1;
    protected String strPagId = "";
    protected boolean blnImgError = false;
    protected String strDetalleIncons = "";
    protected String navegacion;

    public Integer getNumPanel() {
        return numPanel;
    }

    public void setNumPanel(Integer numPanel) {
        this.numPanel = numPanel;
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Funciones Comunes">
    protected boolean esNumero(String string) {
        if (string == null || string.isEmpty()) {
            return false;
        }
        int i = 0;
        if (string.charAt(0) == '-') {
            if (string.length() > 1) {
                i++;
            } else {
                return false;
            }
        }
        for (; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Mostrar error
     *
     * @param pDetalle
     * @param pResumen
     * @param tipo 1 para error, 2 para advertencia, 3 para info
     */
    public void mostrarMensaje(String pDetalle, String pResumen, int tipo) {
        blnImgError = true;

        FacesMessage message = new FacesMessage();
        message.setDetail(pDetalle);
        message.setSummary(pResumen);
        switch (tipo) {
            case 1:
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                break;
            case 2:
                message.setSeverity(FacesMessage.SEVERITY_WARN);
                break;
            case 3:
                message.setSeverity(FacesMessage.SEVERITY_INFO);
                break;
        }

        FacesContext.getCurrentInstance().addMessage(null, message);

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Funciones Abstractas">
    public abstract void init();

    public abstract void limpiarVariables();

    public abstract void navegacionLateral_ActionEvent(ActionEvent ae);

    public abstract boolean validarFormulario();
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="manejo zip">
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="manejo listas">
    public Long cantElemSelLista(List<? extends TablaBaseFrm> lst) {
        //return lst.stream().filter(p -> p.isSeleccionado()).reduce(Collections.c null, null)
//        Long cantSel = 0L;
//        long count;
        return lst.stream().filter(p -> p.isSeleccionado()).count();
//        for (TablaBaseFrm tablaBaseFrm : lst) {
//            if (tablaBaseFrm.isSeleccionado()) {
//                cantSel = cantSel + 1;
//            }
//        }
//        return cantSel;
    }

    /**
     * Eliminar los elementos seleccionados de una tabla
     *
     * @param lst
     * @return Lista de elementos eliminados para hacer las operaciones
     * correspondientes
     */
    protected List retirarElemTabla(List<? extends TablaBaseFrm> lst) {
        List lstRerirar = new ArrayList();
        lst.stream().filter(p -> p.isSeleccionado()).forEach(p -> lstRerirar.add(p));
        lst.removeAll(lstRerirar);
//        for (Object object : lst) {
//            try {
//                Class claseObjLst = object.getClass();
//                Method metodo = claseObjLst.getMethod("isSeleccionado", new Class<?>[0]);
//                Object objResultSel = metodo.invoke(object, new Object[0]);
//                Boolean blnSel = (Boolean) objResultSel;
//                if (blnSel.booleanValue()) {
//                    lstRerirar.add(object);
//                }
//
//            } catch (SecurityException | NoSuchMethodException | IllegalAccessException |
//                    IllegalArgumentException | InvocationTargetException ex) {
//                Logger.getLogger(BaseJSFBean.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        }

        return lstRerirar;
    }

    /**
     * Resaltar la fila seleccionada de una tabla, la lista debe ser de objetos
     * que hereden de la clase TablaBaseGrid
     *
     * @param lst
     * @param objSel
     */
    public void resaltarFilaTabla(List<? extends TablaBaseFrm> lst, TablaBaseFrm objSel) {
        lst.stream().forEach(p -> {
            if (p.equals(objSel)) {
                p.setSeleccionado(true);
                p.setClaseSel("seleccione");
            } else {
                p.setSeleccionado(false);
                p.setClaseSel("");
            }
        });

//        for (Object object : lst) {
//            if (object.equals(objSel)) {
//                try {
//                    Class claseObjLst = object.getClass();
//                    Class[] argSetSel = {Boolean.TYPE};
//
//                    Method metodo = claseObjLst.getMethod("setSeleccionado", argSetSel);
//                    Object[] objParam = {Boolean.TRUE};
//                    metodo.invoke(object, objParam);
//
//                    Class[] argSetClaseSel = {String.class};
//                    Method setClaseSel = claseObjLst.getMethod("setClaseSel", argSetClaseSel);
//
//                    Object[] objParamClase = {"seleccione"};
//                    setClaseSel.invoke(object, objParamClase);
//
//                } catch (IllegalAccessException | NoSuchMethodException | SecurityException |
//                        IllegalArgumentException | InvocationTargetException ex) {
//                    Logger.getLogger(BaseJSFBean.class.getName()).log(Level.WARNING, null, ex);
//                }
//
//            } else {
//                try {
//                    Class claseObjLst = object.getClass();
//                    Class[] argSetSel = {Boolean.TYPE};
//
//                    Method metodo = claseObjLst.getMethod("setSeleccionado", argSetSel);
//                    Object[] objParam = {Boolean.FALSE};
//                    metodo.invoke(object, objParam);
//
//                    Class[] argSetClaseSel = {String.class};
//                    Method setClaseSel = claseObjLst.getMethod("setClaseSel", argSetClaseSel);
//
//                    Object[] objParamClase = {""};
//                    setClaseSel.invoke(object, objParamClase);
//
//                } catch (IllegalAccessException | IllegalArgumentException |
//                        InvocationTargetException | NoSuchMethodException | SecurityException ex) {
//                    Logger.getLogger(BaseJSFBean.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//            }
//        }
    }

    /**
     * Cambiar el estado del campo seleccionado de una lista tipo tabla
     *
     * @param lst Lista
     * @param sel estado del campo
     */
    protected void selTodoLst(List<? extends TablaBaseFrm> lst, boolean sel) {
        lst.stream().forEach(p -> p.setSeleccionado(sel));

//        for (Object object : lst) {
//
//            Class claseObjLst = object.getClass();
//            try {
//                Class[] argSetSel = {Boolean.TYPE};
//
//                Method metodo = claseObjLst.getMethod("setSeleccionado", argSetSel);
//                Object[] objParam = {sel};
//
//                metodo.invoke(object, objParam);
//
//            } catch (IllegalAccessException | NoSuchMethodException | SecurityException |
//                    IllegalArgumentException | InvocationTargetException ex) {
//                Logger.getLogger(BaseJSFBean.class.getName()).log(Level.WARNING, null, ex);
//            }
//
//        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="referencia a otros jsf">
    public AdministracionJSFBean getAdministracionJSFBean() {

        fc = FacesContext.getCurrentInstance();
        elc = fc.getELContext();
        return (AdministracionJSFBean) elc.getELResolver().getValue(elc, null, "administracionJSFBean");
    }
    //</editor-fold>
}
