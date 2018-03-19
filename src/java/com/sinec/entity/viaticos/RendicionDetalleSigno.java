/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinec.entity.viaticos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author fgonzalez
 */
@Entity
@Table(name = "MIG_RENDICIONDETALLESIGNO")
public class RendicionDetalleSigno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id    
    @Column(name =  "IDSIGNO")
    private Integer idSigno;
    
    @Column(name =  "DESCRIPCION")
    private String descripcion;
    
    @Column(name = "HABILITADO", precision = 1)
    private Boolean habilitado = Boolean.TRUE ;          

    @OneToMany(mappedBy = "rendicionDetalleSigno",cascade={CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    private List<RendicionDetalle> listDetalleRendicion;    

    public Integer getIdSigno() {
        return idSigno;
    }

    public void setIdSigno(Integer idSigno) {
        this.idSigno = idSigno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public List<RendicionDetalle> getListDetalleRendicion() {
        return listDetalleRendicion;
    }

    public void setListDetalleRendicion(List<RendicionDetalle> listDetalleRendicion) {
        this.listDetalleRendicion = listDetalleRendicion;
    }
    
    
    
    

    
}
