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
@Table(name = "proveedor", catalog = "guper", schema = "")
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p"),
    @NamedQuery(name = "Proveedor.findByProveCodigo", query = "SELECT p FROM Proveedor p WHERE p.proveCodigo = :proveCodigo"),
    @NamedQuery(name = "Proveedor.findByProveRuc", query = "SELECT p FROM Proveedor p WHERE p.proveRuc = :proveRuc"),
    @NamedQuery(name = "Proveedor.findByProveNombre", query = "SELECT p FROM Proveedor p WHERE p.proveNombre = :proveNombre"),
    @NamedQuery(name = "Proveedor.findByProveDireccion", query = "SELECT p FROM Proveedor p WHERE p.proveDireccion = :proveDireccion"),
    @NamedQuery(name = "Proveedor.findByProveTelefono", query = "SELECT p FROM Proveedor p WHERE p.proveTelefono = :proveTelefono")})
public class Proveedor implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "prove_codigo")
    private Integer proveCodigo;
    @Basic(optional = false)
    @Column(name = "prove_ruc")
    private String proveRuc;
    @Basic(optional = false)
    @Column(name = "prove_nombre")
    private String proveNombre;
    @Basic(optional = false)
    @Column(name = "prove_direccion")
    private String proveDireccion;
    @Basic(optional = false)
    @Column(name = "prove_telefono")
    private String proveTelefono;

    public Proveedor() {
    }

    public Proveedor(Integer proveCodigo) {
        this.proveCodigo = proveCodigo;
    }

    public Proveedor(Integer proveCodigo, String proveRuc, String proveNombre, String proveDireccion, String proveTelefono) {
        this.proveCodigo = proveCodigo;
        this.proveRuc = proveRuc;
        this.proveNombre = proveNombre;
        this.proveDireccion = proveDireccion;
        this.proveTelefono = proveTelefono;
    }

    public Integer getProveCodigo() {
        return proveCodigo;
    }

    public void setProveCodigo(Integer proveCodigo) {
        Integer oldProveCodigo = this.proveCodigo;
        this.proveCodigo = proveCodigo;
        changeSupport.firePropertyChange("proveCodigo", oldProveCodigo, proveCodigo);
    }

    public String getProveRuc() {
        return proveRuc;
    }

    public void setProveRuc(String proveRuc) {
        String oldProveRuc = this.proveRuc;
        this.proveRuc = proveRuc;
        changeSupport.firePropertyChange("proveRuc", oldProveRuc, proveRuc);
    }

    public String getProveNombre() {
        return proveNombre;
    }

    public void setProveNombre(String proveNombre) {
        String oldProveNombre = this.proveNombre;
        this.proveNombre = proveNombre;
        changeSupport.firePropertyChange("proveNombre", oldProveNombre, proveNombre);
    }

    public String getProveDireccion() {
        return proveDireccion;
    }

    public void setProveDireccion(String proveDireccion) {
        String oldProveDireccion = this.proveDireccion;
        this.proveDireccion = proveDireccion;
        changeSupport.firePropertyChange("proveDireccion", oldProveDireccion, proveDireccion);
    }

    public String getProveTelefono() {
        return proveTelefono;
    }

    public void setProveTelefono(String proveTelefono) {
        String oldProveTelefono = this.proveTelefono;
        this.proveTelefono = proveTelefono;
        changeSupport.firePropertyChange("proveTelefono", oldProveTelefono, proveTelefono);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proveCodigo != null ? proveCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.proveCodigo == null && other.proveCodigo != null) || (this.proveCodigo != null && !this.proveCodigo.equals(other.proveCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "guperapp.Proveedor[ proveCodigo=" + proveCodigo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
