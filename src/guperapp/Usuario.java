/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guperapp;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Adrianlrx <adrianlrx@gmail.com>
 */
@Entity
@Table(name = "usuario", catalog = "guper", schema = "")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUsuCodigo", query = "SELECT u FROM Usuario u WHERE u.usuCodigo = :usuCodigo"),
    @NamedQuery(name = "Usuario.findByUsuNombre", query = "SELECT u FROM Usuario u WHERE u.usuNombre = :usuNombre"),
    @NamedQuery(name = "Usuario.findByUsuClave", query = "SELECT u FROM Usuario u WHERE u.usuClave = :usuClave"),
    @NamedQuery(name = "Usuario.findByUsuNivel", query = "SELECT u FROM Usuario u WHERE u.usuNivel = :usuNivel")})
public class Usuario implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "usu_codigo")
    private Integer usuCodigo;
    @Basic(optional = false)
    @Column(name = "usu_nombre")
    private String usuNombre;
    @Basic(optional = false)
    @Column(name = "usu_clave")
    private String usuClave;
    @Basic(optional = false)
    @Column(name = "usu_nivel")
    private String usuNivel;

    public Usuario() {
    }

    public Usuario(Integer usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

    public Usuario(Integer usuCodigo, String usuNombre, String usuClave, String usuNivel) {
        this.usuCodigo = usuCodigo;
        this.usuNombre = usuNombre;
        this.usuClave = usuClave;
        this.usuNivel = usuNivel;
    }

    public Integer getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(Integer usuCodigo) {
        Integer oldUsuCodigo = this.usuCodigo;
        this.usuCodigo = usuCodigo;
        changeSupport.firePropertyChange("usuCodigo", oldUsuCodigo, usuCodigo);
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        String oldUsuNombre = this.usuNombre;
        this.usuNombre = usuNombre;
        changeSupport.firePropertyChange("usuNombre", oldUsuNombre, usuNombre);
    }

    public String getUsuClave() {
        return usuClave;
    }

    public void setUsuClave(String usuClave) {
        String oldUsuClave = this.usuClave;
        this.usuClave = usuClave;
        changeSupport.firePropertyChange("usuClave", oldUsuClave, usuClave);
    }

    public String getUsuNivel() {
        return usuNivel;
    }

    public void setUsuNivel(String usuNivel) {
        String oldUsuNivel = this.usuNivel;
        this.usuNivel = usuNivel;
        changeSupport.firePropertyChange("usuNivel", oldUsuNivel, usuNivel);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuCodigo != null ? usuCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuCodigo == null && other.usuCodigo != null) || (this.usuCodigo != null && !this.usuCodigo.equals(other.usuCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "guperapp.Usuario[ usuCodigo=" + usuCodigo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
