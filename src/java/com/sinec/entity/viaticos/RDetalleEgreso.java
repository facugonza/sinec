/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinec.entity.viaticos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author fgonzalez
 */
@Entity
@Table(name = "MIG_RDETALLEEGRESO")
public class RDetalleEgreso extends RendicionDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
        
    @JoinColumn(name = "IDTIPOCOMPROBANTE", referencedColumnName = "IDTIPOCOMPROBANTE",nullable=false,insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = TipoComprobante.class)
    private TipoComprobante tipoComprobante;            
   

    @OneToMany(mappedBy = "detalleEgreso",cascade={CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    private List<RDetalleEgresoImpuesto> listImpuestos;

    public TipoComprobante getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(TipoComprobante tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public List<RDetalleEgresoImpuesto> getListImpuestos() {
        return listImpuestos;
    }

    public void setListImpuestos(List<RDetalleEgresoImpuesto> listImpuestos) {
        this.listImpuestos = listImpuestos;
    }
       
    
    
    
    
    
    
    
}
