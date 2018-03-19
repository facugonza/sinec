/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinec.entity.viaticos;

import com.sinec.entity.Usuarios;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author fgonzalez
 */
@Entity
@Table(name = "MIG_RDETALLEUSUARIOS")
public class RDetalleUsuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id    
    @Column(name = "IDDETALLEUSUARIO")
    private Long idDetalleUsuario;
    
    @Column(name = "IMPORTE",precision = 10,scale = 2)
    private BigDecimal importe=BigDecimal.ZERO;        
    
    
    @Column(name  = "HABILITADO")
    private Boolean habilitado = Boolean.TRUE;
    
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO",nullable=false,insertable = false, updatable = false)
    @ManyToOne(fetch=FetchType.LAZY,targetEntity = Usuarios.class,cascade = CascadeType.ALL)
    private Usuarios usuario;       
    

    @JoinColumn(name = "IDDETALLE", referencedColumnName = "IDDETALLE",nullable=false,insertable = false,updatable = false)
    @ManyToOne(fetch=FetchType.LAZY,targetEntity = RendicionDetalle.class,cascade = CascadeType.ALL)
    private RendicionDetalle rendicionDetalle;    
    



}
