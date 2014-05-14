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
@Table(name = "servicio", catalog = "guper", schema = "")
@NamedQueries({
    @NamedQuery(name = "Servicio.findAll", query = "SELECT s FROM Servicio s"),
    @NamedQuery(name = "Servicio.findBySerCodigo", query = "SELECT s FROM Servicio s WHERE s.serCodigo = :serCodigo"),
    @NamedQuery(name = "Servicio.findByCliCodigo", query = "SELECT s FROM Servicio s WHERE s.cliCodigo = :cliCodigo"),
    @NamedQuery(name = "Servicio.findByEqCodigo", query = "SELECT s FROM Servicio s WHERE s.eqCodigo = :eqCodigo"),
    @NamedQuery(name = "Servicio.findByFunCodigo", query = "SELECT s FROM Servicio s WHERE s.funCodigo = :funCodigo"),
    @NamedQuery(name = "Servicio.findBySerEstado", query = "SELECT s FROM Servicio s WHERE s.serEstado = :serEstado"),
    @NamedQuery(name = "Servicio.findBySerMonto", query = "SELECT s FROM Servicio s WHERE s.serMonto = :serMonto")})
public class Servicio implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ser_codigo")
    private Integer serCodigo;
    @Column(name = "cli_codigo")
    private Integer cliCodigo;
    @Basic(optional = false)
    @Column(name = "eq_codigo")
    private String eqCodigo;
    @Basic(optional = false)
    @Column(name = "fun_codigo")
    private int funCodigo;
    @Basic(optional = false)
    @Column(name = "ser_estado")
    private String serEstado;
    @Basic(optional = false)
    @Column(name = "ser_monto")
    private int serMonto;

    public Servicio() {
    }

    public Servicio(Integer serCodigo) {
        this.serCodigo = serCodigo;
    }

    public Servicio(Integer serCodigo, String eqCodigo, int funCodigo, String serEstado, int serMonto) {
        this.serCodigo = serCodigo;
        this.eqCodigo = eqCodigo;
        this.funCodigo = funCodigo;
        this.serEstado = serEstado;
        this.serMonto = serMonto;
    }

    public Integer getSerCodigo() {
        return serCodigo;
    }

    public void setSerCodigo(Integer serCodigo) {
        Integer oldSerCodigo = this.serCodigo;
        this.serCodigo = serCodigo;
        changeSupport.firePropertyChange("serCodigo", oldSerCodigo, serCodigo);
    }

    public Integer getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(Integer cliCodigo) {
        Integer oldCliCodigo = this.cliCodigo;
        this.cliCodigo = cliCodigo;
        changeSupport.firePropertyChange("cliCodigo", oldCliCodigo, cliCodigo);
    }

    public String getEqCodigo() {
        return eqCodigo;
    }

    public void setEqCodigo(String eqCodigo) {
        String oldEqCodigo = this.eqCodigo;
        this.eqCodigo = eqCodigo;
        changeSupport.firePropertyChange("eqCodigo", oldEqCodigo, eqCodigo);
    }

    public int getFunCodigo() {
        return funCodigo;
    }

    public void setFunCodigo(int funCodigo) {
        int oldFunCodigo = this.funCodigo;
        this.funCodigo = funCodigo;
        changeSupport.firePropertyChange("funCodigo", oldFunCodigo, funCodigo);
    }

    public String getSerEstado() {
        return serEstado;
    }

    public void setSerEstado(String serEstado) {
        String oldSerEstado = this.serEstado;
        this.serEstado = serEstado;
        changeSupport.firePropertyChange("serEstado", oldSerEstado, serEstado);
    }

    public int getSerMonto() {
        return serMonto;
    }

    public void setSerMonto(int serMonto) {
        int oldSerMonto = this.serMonto;
        this.serMonto = serMonto;
        changeSupport.firePropertyChange("serMonto", oldSerMonto, serMonto);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serCodigo != null ? serCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicio)) {
            return false;
        }
        Servicio other = (Servicio) object;
        if ((this.serCodigo == null && other.serCodigo != null) || (this.serCodigo != null && !this.serCodigo.equals(other.serCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "guperapp.Servicio[ serCodigo=" + serCodigo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
