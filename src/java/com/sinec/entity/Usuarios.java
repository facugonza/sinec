/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinec.entity;

import com.sinec.entity.viaticos.RDetalleUsuarios;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fgonzalez
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({ 
      @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findEnabled", query = "SELECT u FROM Usuarios u where u.habilitado = TRUE ")  
    , @NamedQuery(name = "Usuarios.findByIdUsuario", query = "SELECT u FROM Usuarios u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuarios.findBySuperAdmin", query = "SELECT u FROM Usuarios u WHERE u.superAdmin = :superAdmin")
    , @NamedQuery(name = "Usuarios.findByUsuario", query = "SELECT u FROM Usuarios u WHERE u.usuario = :usuario")
    , @NamedQuery(name = "Usuarios.findByEmail", query = "SELECT u FROM Usuarios u WHERE u.email = :email")
        
    , @NamedQuery(name = "Usuarios.findByUserAndEmail", query = "SELECT u FROM Usuarios u WHERE u.email = :email AND u.usuario = :usuario")
        
    , @NamedQuery(name = "Usuarios.findByClave", query = "SELECT u FROM Usuarios u WHERE u.clave = :clave")
    , @NamedQuery(name = "Usuarios.findByHabilitado", query = "SELECT u FROM Usuarios u WHERE u.habilitado = :habilitado")
    , @NamedQuery(name = "Usuarios.findByIdEmpleado", query = "SELECT u FROM Usuarios u WHERE u.idEmpleado = :idEmpleado")
    , @NamedQuery(name = "Usuarios.findByIdUsuarioLog", query = "SELECT u FROM Usuarios u WHERE u.idUsuarioLog = :idUsuarioLog")
    , @NamedQuery(name = "Usuarios.findByFechaLog", query = "SELECT u FROM Usuarios u WHERE u.fechaLog = :fechaLog")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id    
    @Basic(optional = false)
    @Column(name = "idUsuario")
    private Integer idUsuario;
    
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "superAdmin")
    private boolean superAdmin;
    
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "usuario")
    private String usuario;
    
    
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "email")
    private String email;
    
    @Size(max = 32)    
    @Column(name = "clave")
    private String clave;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "habilitado")
    private boolean habilitado;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEmpleado")
    private int idEmpleado;
    @Basic(optional = false)
    
    @NotNull
    @Column(name = "idUsuarioLog")
    private int idUsuarioLog;
    
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaLog")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaLog;
    
    
    @OneToMany(mappedBy = "usuario",cascade={CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    private List<RDetalleUsuarios> listEgresosUsuarios;    

    public Usuarios() {
    }

    public Usuarios(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuarios(Integer idUsuario, boolean superAdmin, String usuario, String email, boolean habilitado, int idEmpleado, int idUsuarioLog, Date fechaLog) {
        this.idUsuario = idUsuario;
        this.superAdmin = superAdmin;
        this.usuario = usuario;
        this.email = email;
        this.habilitado = habilitado;
        this.idEmpleado = idEmpleado;
        this.idUsuarioLog = idUsuarioLog;
        this.fechaLog = fechaLog;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public boolean getSuperAdmin() {
        return superAdmin;
    }

    public void setSuperAdmin(boolean superAdmin) {
        this.superAdmin = superAdmin;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdUsuarioLog() {
        return idUsuarioLog;
    }

    public void setIdUsuarioLog(int idUsuarioLog) {
        this.idUsuarioLog = idUsuarioLog;
    }

    public Date getFechaLog() {
        return fechaLog;
    }

    public void setFechaLog(Date fechaLog) {
        this.fechaLog = fechaLog;
    }

    public List<RDetalleUsuarios> getListEgresosUsuarios() {
        return listEgresosUsuarios;
    }

    public void setListEgresosUsuarios(List<RDetalleUsuarios> listEgresosUsuarios) {
        this.listEgresosUsuarios = listEgresosUsuarios;
    }
    
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sinec.entity.Usuarios[ idUsuario=" + idUsuario + " ]";
    }
    
}
