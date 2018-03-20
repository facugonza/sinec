/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinec.entity.parser;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.json.bind.annotation.JsonbDateFormat;

/**
 *
 * @author fgonzalez
 */
public class ChkVehicularParser implements Serializable{
    
    
    private static final long serialVersionUID = 1L;

    private Long idchkvehicular;
    private Integer idusuario;
    private Long kilometraje;  

    private BigDecimal nivelcombustible=BigDecimal.ZERO;    
    private String patente;   
    
    @JsonbDateFormat(value = "dd/MM/yyyy HH:mm:ss")
    private Date fechaproceso;
    
    @JsonbDateFormat(value = "dd/MM/yyyy HH:mm:ss")
    private Date fechalog= new Date();
    
    
    private Boolean habilitado = Boolean.TRUE ;
    private String observacion;       
    

    private List<ChkVehicularDetalleParser> listdetalleitems;
    
    

    public Long getIdchkvehicular() {
        return idchkvehicular;
    }

    public void setIdchkvehicular(Long idchkvehicular) {
        this.idchkvehicular = idchkvehicular;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Long getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(Long kilometraje) {
        this.kilometraje = kilometraje;
    }

    public BigDecimal getNivelcombustible() {
        return nivelcombustible;
    }

    public void setNivelcombustible(BigDecimal nivelcombustible) {
        this.nivelcombustible = nivelcombustible;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Date getFechaproceso() {
        return fechaproceso;
    }

    public void setFechaproceso(Date fechaproceso) {
        this.fechaproceso = fechaproceso;
    }

    public Date getFechalog() {
        return fechalog;
    }

    public void setFechalog(Date fechalog) {
        this.fechalog = fechalog;
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

    public List<ChkVehicularDetalleParser> getListdetalleitems() {
        return listdetalleitems;
    }

    public void setListdetalleitems(List<ChkVehicularDetalleParser> listdetalleitems) {
        this.listdetalleitems = listdetalleitems;
    }

    
    
}
