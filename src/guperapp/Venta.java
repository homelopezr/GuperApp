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
@Table(name = "venta", catalog = "guper", schema = "")
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v"),
    @NamedQuery(name = "Venta.findByVenCodigo", query = "SELECT v FROM Venta v WHERE v.venCodigo = :venCodigo"),
    @NamedQuery(name = "Venta.findByCliCodigo", query = "SELECT v FROM Venta v WHERE v.cliCodigo = :cliCodigo"),
    @NamedQuery(name = "Venta.findByProCodigo", query = "SELECT v FROM Venta v WHERE v.proCodigo = :proCodigo"),
    @NamedQuery(name = "Venta.findByProCantidad", query = "SELECT v FROM Venta v WHERE v.proCantidad = :proCantidad"),
    @NamedQuery(name = "Venta.findByProPrecioVenta", query = "SELECT v FROM Venta v WHERE v.proPrecioVenta = :proPrecioVenta"),
    @NamedQuery(name = "Venta.findByVenTotal", query = "SELECT v FROM Venta v WHERE v.venTotal = :venTotal"),
    @NamedQuery(name = "Venta.findByFunCodigo", query = "SELECT v FROM Venta v WHERE v.funCodigo = :funCodigo")})
public class Venta implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ven_codigo")
    private Integer venCodigo;
    @Basic(optional = false)
    @Column(name = "cli_codigo")
    private int cliCodigo;
    @Basic(optional = false)
    @Column(name = "pro_codigo")
    private int proCodigo;
    @Basic(optional = false)
    @Column(name = "pro_cantidad")
    private int proCantidad;
    @Basic(optional = false)
    @Column(name = "pro_precio_venta")
    private int proPrecioVenta;
    @Basic(optional = false)
    @Column(name = "ven_total")
    private int venTotal;
    @Basic(optional = false)
    @Column(name = "fun_codigo")
    private int funCodigo;

    public Venta() {
    }

    public Venta(Integer venCodigo) {
        this.venCodigo = venCodigo;
    }

    public Venta(Integer venCodigo, int cliCodigo, int proCodigo, int proCantidad, int proPrecioVenta, int venTotal, int funCodigo) {
        this.venCodigo = venCodigo;
        this.cliCodigo = cliCodigo;
        this.proCodigo = proCodigo;
        this.proCantidad = proCantidad;
        this.proPrecioVenta = proPrecioVenta;
        this.venTotal = venTotal;
        this.funCodigo = funCodigo;
    }

    public Integer getVenCodigo() {
        return venCodigo;
    }

    public void setVenCodigo(Integer venCodigo) {
        Integer oldVenCodigo = this.venCodigo;
        this.venCodigo = venCodigo;
        changeSupport.firePropertyChange("venCodigo", oldVenCodigo, venCodigo);
    }

    public int getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(int cliCodigo) {
        int oldCliCodigo = this.cliCodigo;
        this.cliCodigo = cliCodigo;
        changeSupport.firePropertyChange("cliCodigo", oldCliCodigo, cliCodigo);
    }

    public int getProCodigo() {
        return proCodigo;
    }

    public void setProCodigo(int proCodigo) {
        int oldProCodigo = this.proCodigo;
        this.proCodigo = proCodigo;
        changeSupport.firePropertyChange("proCodigo", oldProCodigo, proCodigo);
    }

    public int getProCantidad() {
        return proCantidad;
    }

    public void setProCantidad(int proCantidad) {
        int oldProCantidad = this.proCantidad;
        this.proCantidad = proCantidad;
        changeSupport.firePropertyChange("proCantidad", oldProCantidad, proCantidad);
    }

    public int getProPrecioVenta() {
        return proPrecioVenta;
    }

    public void setProPrecioVenta(int proPrecioVenta) {
        int oldProPrecioVenta = this.proPrecioVenta;
        this.proPrecioVenta = proPrecioVenta;
        changeSupport.firePropertyChange("proPrecioVenta", oldProPrecioVenta, proPrecioVenta);
    }

    public int getVenTotal() {
        return venTotal;
    }

    public void setVenTotal(int venTotal) {
        int oldVenTotal = this.venTotal;
        this.venTotal = venTotal;
        changeSupport.firePropertyChange("venTotal", oldVenTotal, venTotal);
    }

    public int getFunCodigo() {
        return funCodigo;
    }

    public void setFunCodigo(int funCodigo) {
        int oldFunCodigo = this.funCodigo;
        this.funCodigo = funCodigo;
        changeSupport.firePropertyChange("funCodigo", oldFunCodigo, funCodigo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (venCodigo != null ? venCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.venCodigo == null && other.venCodigo != null) || (this.venCodigo != null && !this.venCodigo.equals(other.venCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "guperapp.Venta[ venCodigo=" + venCodigo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
