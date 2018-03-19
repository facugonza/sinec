/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinec.entity.parser;

import java.io.Serializable;

/**
 *
 * @author fgonzalez
 */

public class ChkVehicularItemParser implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer idItem;   
    private String descripcion;        
    private Boolean habilitado = Boolean.TRUE ;
    
    
    private boolean check=false;    
    private boolean checkNo=false;    
    private boolean noaplica=false;
    private String observacion="";    
    
    

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public boolean isCheckNo() {
        return checkNo;
    }

    public void setCheckNo(boolean checkNo) {
        this.checkNo = checkNo;
    }

    public boolean isNoaplica() {
        return noaplica;
    }

    public void setNoaplica(boolean noaplica) {
        this.noaplica = noaplica;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    
    
    
    

}
