/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinec.entity.viaticos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author fgonzalez
 */
@Entity
@Table(name = "MIG_RENDICION")
public class Rendicion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id    
    @Column(name="IDRENDICION")
    private Long idRendicion;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaLog= new Date();
    
    @Column(name = "IDUSUARIO")
    private Integer idUsuario;
    
    @Column(name = "IDCOMISION")
    private Long idComision;    
       
    @Column(name = "OBSERVACION")
    private String observacion;
    
    @Column(name = "HABILITADO")
    private Boolean habilitado=Boolean.TRUE;    
    
    @Column(name = "ISFINISH")
    private Boolean isFinish;
        
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaRecepion= new Date();
    
    @OneToMany(mappedBy = "rendicion",cascade={CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    private List<RendicionDetalle> listRendicionDetalle;

    public Long getIdRendicion() {
        return idRendicion;
    }

    public void setIdRendicion(Long idRendicion) {
        this.idRendicion = idRendicion;
    }

    public Date getFechaLog() {
        return fechaLog;
    }

    public void setFechaLog(Date fechaLog) {
        this.fechaLog = fechaLog;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdComision() {
        return idComision;
    }

    public void setIdComision(Long idComision) {
        this.idComision = idComision;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Boolean getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(Boolean isFinish) {
        this.isFinish = isFinish;
    }

    public Date getFechaRecepion() {
        return fechaRecepion;
    }

    public void setFechaRecepion(Date fechaRecepion) {
        this.fechaRecepion = fechaRecepion;
    }

    public List<RendicionDetalle> getListRendicionDetalle() {
        return listRendicionDetalle;
    }

    public void setListRendicionDetalle(List<RendicionDetalle> listRendicionDetalle) {
        this.listRendicionDetalle = listRendicionDetalle;
    }
    
    
    
    
    

  
    
}
