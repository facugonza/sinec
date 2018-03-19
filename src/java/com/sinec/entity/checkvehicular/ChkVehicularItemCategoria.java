/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinec.entity.checkvehicular;

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
@Table(name = "MIG_CHKVEHICULARITEMCATEGORIA")
public class ChkVehicularItemCategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name  = "IDCATEGORIA")
    private Long idCategoria;
    
    
    @Column(name  = "DESCRIPCION",length = 255)
    private String descripcion;    


    @Column(name  = "HABILITADO")
    private Boolean habilitado = Boolean.TRUE ;

    
    @OneToMany(mappedBy = "categoria",cascade={CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    private List<ChkVehicularItem> listItems;    

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
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

    public List<ChkVehicularItem> getListItems() {
        return listItems;
    }

    public void setListItems(List<ChkVehicularItem> listItems) {
        this.listItems = listItems;
    }
    
    
    
    
    
    


    
}
