/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinec.entity.viaticos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fgonzalez
 */
@Entity
@Table(name = "MIG_IMPUESTO")
@XmlRootElement
public class Impuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id    
    @Column(name  = "IDIMPUESTO")
    private Long idImpuesto;    
    
    @Column(name  = "DESCRIPCION")
    private String descripcion;    
    
    @Column(name  = "COEFICIENTE")
    private BigDecimal coeficiente;    
    
    @Column(name  = "HABILITADO")
    private Boolean habilitado = Boolean.TRUE ;
    
    
    @Column(name  = "ISLIBROIVA")
    private Boolean isLibroIVA = Boolean.FALSE ;
    
    @OneToMany(mappedBy = "impuesto",cascade={CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    private List<RDetalleEgresoImpuesto> listEgresoImpuesto;

    public Long getIdImpuesto() {
        return idImpuesto;
    }

    public void setIdImpuesto(Long idImpuesto) {
        this.idImpuesto = idImpuesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getCoeficiente() {
        return coeficiente;
    }

    public void setCoeficiente(BigDecimal coeficiente) {
        this.coeficiente = coeficiente;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Boolean getIsLibroIVA() {
        return isLibroIVA;
    }

    public void setIsLibroIVA(Boolean isLibroIVA) {
        this.isLibroIVA = isLibroIVA;
    }

    public List<RDetalleEgresoImpuesto> getListEgresoImpuesto() {
        return listEgresoImpuesto;
    }

    public void setListEgresoImpuesto(List<RDetalleEgresoImpuesto> listEgresoImpuesto) {
        this.listEgresoImpuesto = listEgresoImpuesto;
    }
    
    
    
    

    
    
}
