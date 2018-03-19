/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinec.entity.viaticos;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyNamingStrategy;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author fgonzalez
 */
@Entity
@Table(name = "MIG_TIPOCOMPROBANTE")
public class TipoComprobante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "IDTIPOCOMPROBANTE")
    private Integer idTipoComprobante;

    @Column(name = "DESCRIPCION",length = 50)
    private String descripcion; 
    
    @Column(name = "HABILITADO", precision = 1)
    private Boolean habilitado = Boolean.TRUE ;       

    @OneToMany(mappedBy = "tipoComprobante",cascade={CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    private List<RDetalleEgreso> listEgresos;

    public Integer getIdTipoComprobante() {
        return idTipoComprobante;
    }

    public void setIdTipoComprobante(Integer idTipoComprobante) {
        this.idTipoComprobante = idTipoComprobante;
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

    public List<RDetalleEgreso> getListEgresos() {
        return listEgresos;
    }

    public void setListEgresos(List<RDetalleEgreso> listEgresos) {
        this.listEgresos = listEgresos;
    }
    
    
    public String toJsonString(){
        JsonbConfig config = new JsonbConfig()                                                     
                            .withFormatting(Boolean.TRUE)    //salidas con formato
                            .withDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault()) //como manejar las fechas                                                    
                            .withPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE_WITH_DASHES); //otra forma de manipular las propiedades                                
        Jsonb jsonb = JsonbBuilder.create(config);    
        return jsonb.toJson(this);        
    }    
    
    
    
}
