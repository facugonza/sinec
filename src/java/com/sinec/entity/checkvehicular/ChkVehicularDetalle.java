/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinec.entity.checkvehicular;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author fgonzalez
 */
@Entity
@Table(name = "MIG_CHKVEHICULARDETALLE")
public class ChkVehicularDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id    
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name  = "IDDETALLE")
    private Long idDetalle;
    
    @Column(name  = "HABILITADO")
    private Boolean habilitado = Boolean.TRUE ;    
    
    @Column(name  = "OBSERVACION",length = 255)
    private String observacion;    
    
    @Column(name  = "CHKSI",precision = 1)
    private Boolean chkSI= Boolean.FALSE;
    
    @Column(name  = "CHKNO",precision = 1)
    private Boolean chkNO = Boolean.FALSE;
    
    @Column(name  = "CHKNA",precision = 1)
    private Boolean chkNA= Boolean.FALSE;

    

    @JoinColumn(name = "IDITEM", referencedColumnName = "IDITEM",nullable=false,insertable = false,updatable = false)        
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = ChkVehicularItem.class)
    private ChkVehicularItem item;    
    
    
    @JoinColumn(name = "IDCHKVEHICULAR", referencedColumnName = "IDCHKVEHICULAR",nullable=false,insertable = false,updatable = false)        
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = ChkVehicular.class)
    private ChkVehicular chkVehicular;

    public Long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public ChkVehicularItem getItem() {
        return item;
    }

    public void setItem(ChkVehicularItem item) {
        this.item = item;
    }

    public ChkVehicular getChkVehicular() {
        return chkVehicular;
    }

    public void setChkVehicular(ChkVehicular chkVehicular) {
        this.chkVehicular = chkVehicular;
    }

    public Boolean getChkSI() {
        return chkSI;
    }

    public void setChkSI(Boolean chkSI) {
        this.chkSI = chkSI;
    }

    public Boolean getChkNO() {
        return chkNO;
    }

    public void setChkNO(Boolean chkNO) {
        this.chkNO = chkNO;
    }

    public Boolean getChkNA() {
        return chkNA;
    }

    public void setChkNA(Boolean chkNA) {
        this.chkNA = chkNA;
    }
    
    
    
}
