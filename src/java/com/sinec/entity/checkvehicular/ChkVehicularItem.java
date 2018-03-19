/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinec.entity.checkvehicular;

import java.io.Serializable;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fgonzalez
 */
@Entity
@Table(name = "MIG_CHKVEHICULARITEM")
@XmlRootElement
@NamedQueries({ 
      @NamedQuery(name = "ChkVehicularItem.findAllenabled", query =  "SELECT c "
                                                            + " FROM ChkVehicularItem c"
                                                            + " WHERE c.habilitado = TRUE")        
})        

public class ChkVehicularItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id    
    @Column(name  = "IDITEM")
    private Integer idItem;
    
    @Column(name  = "DESCRIPCION",length = 255)
    private String descripcion;    
    
    
    @Column(name  = "HABILITADO")
    private Boolean habilitado = Boolean.TRUE ;
    

    @JsonbTransient
    @JoinColumn(name = "IDCATEGORIA", referencedColumnName = "IDCATEGORIA",nullable=false,insertable = false,updatable = false)        
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = ChkVehicularItemCategoria.class)
    private ChkVehicularItemCategoria categoria;

    @JsonbTransient
    @OneToMany(mappedBy = "item",cascade={CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    private List<ChkVehicularDetalle> listDetalleChkVehicukar;    

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
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

    public ChkVehicularItemCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(ChkVehicularItemCategoria categoria) {
        this.categoria = categoria;
    }

    public List<ChkVehicularDetalle> getListDetalleChkVehicukar() {
        return listDetalleChkVehicukar;
    }

    public void setListDetalleChkVehicukar(List<ChkVehicularDetalle> listDetalleChkVehicukar) {
        this.listDetalleChkVehicukar = listDetalleChkVehicukar;
    }
    
    
    
    
    
    
    
    

}
