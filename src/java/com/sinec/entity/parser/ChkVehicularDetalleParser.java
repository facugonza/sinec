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
public class ChkVehicularDetalleParser implements Serializable{
    
    
    private static final long serialVersionUID = 1L;
    
    private Integer item;    
    private String observacion;    
    private Boolean chksi;
    private Boolean chkno;
    private Boolean chkna;
    

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Boolean getChksi() {
        return chksi;
    }

    public void setChksi(Boolean chksi) {
        this.chksi = chksi;
    }

    public Boolean getChkno() {
        return chkno;
    }

    public void setChkno(Boolean chkno) {
        this.chkno = chkno;
    }

    public Boolean getChkna() {
        return chkna;
    }

    public void setChkna(Boolean chkna) {
        this.chkna = chkna;
    }

    
    


    
    
    
    
}
