/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinec.entity.viaticos;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author fgonzalez
 */
@Entity
@Table(name = "MIG_RDETALLEEGRESOIMPUESTO")
public class RDetalleEgresoImpuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id    
    @Column(name = "IDDETALLEIMPUESTO")
    private Long idDetalleImpuesto;
    
    @Column(name = "PORCENTAJE")
    private BigDecimal porcentaje=BigDecimal.ZERO;    
    
    @Column(name = "IMPORTE",precision = 10,scale = 2)
    private BigDecimal importe=BigDecimal.ZERO;        
    
    
    @Column(name  = "HABILITADO")
    private Boolean habilitado = Boolean.TRUE;
    
    @JoinColumn(name = "IDIMPUESTO", referencedColumnName = "IDIMPUESTO",nullable=false,insertable = false, updatable = false)
    @ManyToOne(fetch=FetchType.LAZY,targetEntity = Impuesto.class,cascade = CascadeType.ALL)
    private Impuesto impuesto;       
    

    @JoinColumn(name = "IDDETALLE", referencedColumnName = "IDDETALLE",nullable=false,insertable = false,updatable = false)
    @ManyToOne(fetch=FetchType.LAZY,targetEntity = RDetalleEgreso.class,cascade = CascadeType.ALL)
    private RDetalleEgreso detalleEgreso;    

    public Long getIdDetalleImpuesto() {
        return idDetalleImpuesto;
    }

    public void setIdDetalleImpuesto(Long idDetalle) {
        this.idDetalleImpuesto = idDetalle;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Impuesto getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Impuesto impuesto) {
        this.impuesto = impuesto;
    }

    public RDetalleEgreso getDetalleEgreso() {
        return detalleEgreso;
    }

    public void setDetalleEgreso(RDetalleEgreso detalleEgreso) {
        this.detalleEgreso = detalleEgreso;
    }
    
    
    
        
   
    
}
