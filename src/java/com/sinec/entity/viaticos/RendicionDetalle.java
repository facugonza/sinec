/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinec.entity.viaticos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author fgonzalez
 */
@Entity
@Table(name = "MIG_RENDICIONDETALLE")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="DISC",discriminatorType=DiscriminatorType.STRING)
public class RendicionDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="IDDETALLE")
    private Long idDetalle;    
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaLog= new Date();

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    
    @Column(name="NROCOMPROBANTE",length = 25)
    private String nroComprobante;    
    
    @Column(name="IMPORTE")
    private BigDecimal importe=BigDecimal.ZERO;
    
    @Column(name="OBSERVACION")
    private String observacion;
        
    @Column(name="HABILITADO")
    private Boolean habilitado=Boolean.TRUE;
        

    @JoinColumn(name = "IDRENDICION", referencedColumnName = "IDRENDICION",nullable=false,insertable = false,updatable = false)        
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Rendicion.class)
    private Rendicion rendicion;
    
    @JoinColumn(name = "IDCONCEPTO", referencedColumnName = "IDCONCEPTO",nullable=false,insertable = false,updatable = false)        
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = RDetalleConcepto.class)
    private RDetalleConcepto concepto;
    
    @JoinColumn(name = "IDSIGNO", referencedColumnName = "IDSIGNO",nullable=false,insertable = false,updatable = false)        
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = RendicionDetalleSigno.class)
    private RendicionDetalleSigno rendicionDetalleSigno;    
    
    @OneToMany(mappedBy = "rendicionDetalle",cascade={CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    private List<RDetalleFormaPago> listFormaPago;    
    
    @OneToMany(mappedBy = "rendicionDetalle",cascade={CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    private List<RDetalleUsuarios> listUsuarios;        

    public Long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Date getFechaLog() {
        return fechaLog;
    }

    public void setFechaLog(Date fechaLog) {
        this.fechaLog = fechaLog;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNroComprobante() {
        return nroComprobante;
    }

    public void setNroComprobante(String nroComprobante) {
        this.nroComprobante = nroComprobante;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
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

    public Rendicion getRendicion() {
        return rendicion;
    }

    public void setRendicion(Rendicion rendicion) {
        this.rendicion = rendicion;
    }

    public RDetalleConcepto getConcepto() {
        return concepto;
    }

    public void setConcepto(RDetalleConcepto concepto) {
        this.concepto = concepto;
    }

    public RendicionDetalleSigno getRendicionDetalleSigno() {
        return rendicionDetalleSigno;
    }

    public void setRendicionDetalleSigno(RendicionDetalleSigno rendicionDetalleSigno) {
        this.rendicionDetalleSigno = rendicionDetalleSigno;
    }

    public List<RDetalleFormaPago> getListFormaPago() {
        return listFormaPago;
    }

    public void setListFormaPago(List<RDetalleFormaPago> listFormaPago) {
        this.listFormaPago = listFormaPago;
    }
    
    
    
    
    
    
    
    

    
}
