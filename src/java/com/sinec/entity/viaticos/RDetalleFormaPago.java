/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinec.entity.viaticos;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author fgonzalez
 */
@Entity
@Table(name = "MIG_RDETALLEFORMAPAGO")
@Inheritance( strategy = InheritanceType.JOINED )
@DiscriminatorColumn( name="DISC",discriminatorType = DiscriminatorType.STRING )
public class RDetalleFormaPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id    
    @Column(name = "IDDETALLEFORMAPAGO")
    private Long idDetalle;    
    
    
    @Column(name  = "HABILITADO")
    private Boolean habilitado = Boolean.TRUE;        
    
    @JoinColumn(name = "IDDETALLE", referencedColumnName = "IDDETALLE",nullable=false,insertable = false,updatable = false)
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = RendicionDetalle.class)
    private RendicionDetalle rendicionDetalle;    
    
 
    @JoinColumn(name = "IDTIPOFORMAPAGO", referencedColumnName = "IDTIPOFORMAPAGO",nullable=false,insertable = false,updatable = false)
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = TipoFormaPago.class)
    private TipoFormaPago tipoFormaPago;        

    
    
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

    public RendicionDetalle getRendicionDetalle() {
        return rendicionDetalle;
    }

    public void setRendicionDetalle(RendicionDetalle rendicionDetalle) {
        this.rendicionDetalle = rendicionDetalle;
    }

    public TipoFormaPago getTipoFormaPago() {
        return tipoFormaPago;
    }

    public void setTipoFormaPago(TipoFormaPago tipoFormaPago) {
        this.tipoFormaPago = tipoFormaPago;
    }
    
    
    
    
    
    
    
    
    
}
