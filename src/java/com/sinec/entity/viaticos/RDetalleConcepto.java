/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinec.entity.viaticos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyNamingStrategy;
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
@Table(name = "MIG_RDETALLECONCEPTO")
public class RDetalleConcepto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDCONCEPTO")
    private Long idConcepto;
  
    @Column(name = "DESCRIPCION")
    private String descripcion;
   
    @Column(name = "HABILITADO")
    private Boolean habilitado= Boolean.TRUE;
    

    @OneToMany(mappedBy = "concepto",cascade={CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    private List<RendicionDetalle> listRendicionDetalle;

    public Long getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(Long idConcepto) {
        this.idConcepto = idConcepto;
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

    public List<RendicionDetalle> getListRendicionDetalle() {
        return listRendicionDetalle;
    }

    public void setListRendicionDetalle(List<RendicionDetalle> listRendicionDetalle) {
        this.listRendicionDetalle = listRendicionDetalle;
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
