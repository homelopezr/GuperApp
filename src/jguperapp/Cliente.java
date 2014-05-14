/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jguperapp;

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
@Table(name = "cliente", catalog = "guper", schema = "")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByCliCodigo", query = "SELECT c FROM Cliente c WHERE c.cliCodigo = :cliCodigo"),
    @NamedQuery(name = "Cliente.findByCliRuc", query = "SELECT c FROM Cliente c WHERE c.cliRuc = :cliRuc"),
    @NamedQuery(name = "Cliente.findByCliNombre", query = "SELECT c FROM Cliente c WHERE c.cliNombre = :cliNombre"),
    @NamedQuery(name = "Cliente.findByCliDireccion", query = "SELECT c FROM Cliente c WHERE c.cliDireccion = :cliDireccion"),
    @NamedQuery(name = "Cliente.findByCliTelefono", query = "SELECT c FROM Cliente c WHERE c.cliTelefono = :cliTelefono")})
public class Cliente implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cli_codigo")
    private Integer cliCodigo;
    @Basic(optional = false)
    @Column(name = "cli_ruc")
    private String cliRuc;
    @Basic(optional = false)
    @Column(name = "cli_nombre")
    private String cliNombre;
    @Basic(optional = false)
    @Column(name = "cli_direccion")
    private String cliDireccion;
    @Basic(optional = false)
    @Column(name = "cli_telefono")
    private String cliTelefono;

    public Cliente() {
    }

    public Cliente(Integer cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    public Cliente(Integer cliCodigo, String cliRuc, String cliNombre, String cliDireccion, String cliTelefono) {
        this.cliCodigo = cliCodigo;
        this.cliRuc = cliRuc;
        this.cliNombre = cliNombre;
        this.cliDireccion = cliDireccion;
        this.cliTelefono = cliTelefono;
    }

    public Integer getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(Integer cliCodigo) {
        Integer oldCliCodigo = this.cliCodigo;
        this.cliCodigo = cliCodigo;
        changeSupport.firePropertyChange("cliCodigo", oldCliCodigo, cliCodigo);
    }

    public String getCliRuc() {
        return cliRuc;
    }

    public void setCliRuc(String cliRuc) {
        String oldCliRuc = this.cliRuc;
        this.cliRuc = cliRuc;
        changeSupport.firePropertyChange("cliRuc", oldCliRuc, cliRuc);
    }

    public String getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        String oldCliNombre = this.cliNombre;
        this.cliNombre = cliNombre;
        changeSupport.firePropertyChange("cliNombre", oldCliNombre, cliNombre);
    }

    public String getCliDireccion() {
        return cliDireccion;
    }

    public void setCliDireccion(String cliDireccion) {
        String oldCliDireccion = this.cliDireccion;
        this.cliDireccion = cliDireccion;
        changeSupport.firePropertyChange("cliDireccion", oldCliDireccion, cliDireccion);
    }

    public String getCliTelefono() {
        return cliTelefono;
    }

    public void setCliTelefono(String cliTelefono) {
        String oldCliTelefono = this.cliTelefono;
        this.cliTelefono = cliTelefono;
        changeSupport.firePropertyChange("cliTelefono", oldCliTelefono, cliTelefono);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cliCodigo != null ? cliCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.cliCodigo == null && other.cliCodigo != null) || (this.cliCodigo != null && !this.cliCodigo.equals(other.cliCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jguperapp.Cliente[ cliCodigo=" + cliCodigo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
