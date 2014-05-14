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
@Table(name = "equipo", catalog = "guper", schema = "")
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e"),
    @NamedQuery(name = "Equipo.findByEqCodigo", query = "SELECT e FROM Equipo e WHERE e.eqCodigo = :eqCodigo"),
    @NamedQuery(name = "Equipo.findByEqDescripcion", query = "SELECT e FROM Equipo e WHERE e.eqDescripcion = :eqDescripcion")})
public class Equipo implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "eq_codigo")
    private Integer eqCodigo;
    @Basic(optional = false)
    @Column(name = "eq_descripcion")
    private String eqDescripcion;

    public Equipo() {
    }

    public Equipo(Integer eqCodigo) {
        this.eqCodigo = eqCodigo;
    }

    public Equipo(Integer eqCodigo, String eqDescripcion) {
        this.eqCodigo = eqCodigo;
        this.eqDescripcion = eqDescripcion;
    }

    public Integer getEqCodigo() {
        return eqCodigo;
    }

    public void setEqCodigo(Integer eqCodigo) {
        Integer oldEqCodigo = this.eqCodigo;
        this.eqCodigo = eqCodigo;
        changeSupport.firePropertyChange("eqCodigo", oldEqCodigo, eqCodigo);
    }

    public String getEqDescripcion() {
        return eqDescripcion;
    }

    public void setEqDescripcion(String eqDescripcion) {
        String oldEqDescripcion = this.eqDescripcion;
        this.eqDescripcion = eqDescripcion;
        changeSupport.firePropertyChange("eqDescripcion", oldEqDescripcion, eqDescripcion);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eqCodigo != null ? eqCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.eqCodigo == null && other.eqCodigo != null) || (this.eqCodigo != null && !this.eqCodigo.equals(other.eqCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "guperapp.Equipo[ eqCodigo=" + eqCodigo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
