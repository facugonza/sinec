/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinec.entity.checkvehicular;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author fgonzalez
 */
@Entity
@Table(name = "MIG_CHKVEHICULAR")
public class ChkVehicular implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    @Id    
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name  = "IDCHKVEHICULAR")
    private Long idChkVehicular;

    
    @Column(name  = "IDUSUARIO")
    private Integer idUsuario;    
    
    
    @Column(name  = "KILOMETRAJE")
    private Long kilometraje;    

    
    @Column(name  = "NIVELCOMBUSTIBLE")
    private BigDecimal nivelCombustible=BigDecimal.ZERO;    
    
    
    @Column(name  = "PATENTE",length = 30)
    private String patente;        
    
    
    @Column(name  = "FECHAPROCESO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaProceso;
    
    @Column(name  = "FECHALOG")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaLog= new Date();
    

    @Column(name  = "HABILITADO")
    private Boolean habilitado = Boolean.TRUE ;
    
    
    @Column(name  = "OBSERVACION",length = 255)
    private String observacion;    
    
    
    @OneToMany(mappedBy = "chkVehicular",cascade={CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    private List<ChkVehicularDetalle> listDetalleItems;

    public Long getIdChkVehicular() {
        return idChkVehicular;
    }

    public void setIdChkVehicular(Long idChkVehicular) {
        this.idChkVehicular = idChkVehicular;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(Long kilometraje) {
        this.kilometraje = kilometraje;
    }

    public BigDecimal getNivelCombustible() {
        return nivelCombustible;
    }

    public void setNivelCombustible(BigDecimal nivelCombustible) {
        this.nivelCombustible = nivelCombustible;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Date getFechaProceso() {
        return fechaProceso;
    }

    public void setFechaProceso(Date fechaProceso) {
        this.fechaProceso = fechaProceso;
    }

    public Date getFechaLog() {
        return fechaLog;
    }

    public void setFechaLog(Date fechaLog) {
        this.fechaLog = fechaLog;
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

    public List<ChkVehicularDetalle> getListDetalleItems() {
        return listDetalleItems;
    }

    public void setListDetalleItems(List<ChkVehicularDetalle> listDetalleItems) {
        this.listDetalleItems = listDetalleItems;
    }

    
    
    
    
    
    
}
