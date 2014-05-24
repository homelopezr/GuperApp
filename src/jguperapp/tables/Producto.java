/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jguperapp.tables;

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
@Table(name = "producto", catalog = "guper", schema = "")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByProCodigo", query = "SELECT p FROM Producto p WHERE p.proCodigo = :proCodigo"),
    @NamedQuery(name = "Producto.findByProDescripcion", query = "SELECT p FROM Producto p WHERE p.proDescripcion = :proDescripcion"),
    @NamedQuery(name = "Producto.findByProPrecioCompra", query = "SELECT p FROM Producto p WHERE p.proPrecioCompra = :proPrecioCompra"),
    @NamedQuery(name = "Producto.findByProPrecioVenta", query = "SELECT p FROM Producto p WHERE p.proPrecioVenta = :proPrecioVenta"),
    @NamedQuery(name = "Producto.findByProveCodigo", query = "SELECT p FROM Producto p WHERE p.proveCodigo = :proveCodigo"),
    @NamedQuery(name = "Producto.findByProCantidad", query = "SELECT p FROM Producto p WHERE p.proCantidad = :proCantidad")})
public class Producto implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pro_codigo")
    private Integer proCodigo;
    @Basic(optional = false)
    @Column(name = "pro_descripcion")
    private String proDescripcion;
    @Basic(optional = false)
    @Column(name = "pro_precio_compra")
    private int proPrecioCompra;
    @Basic(optional = false)
    @Column(name = "pro_precio_venta")
    private int proPrecioVenta;
    @Basic(optional = false)
    @Column(name = "prove_codigo")
    private int proveCodigo;
    @Basic(optional = false)
    @Column(name = "pro_cantidad")
    private int proCantidad;

    public Producto() {
    }

    public Producto(Integer proCodigo) {
        this.proCodigo = proCodigo;
    }

    public Producto(Integer proCodigo, String proDescripcion, int proPrecioCompra, int proPrecioVenta, int proveCodigo, int proCantidad) {
        this.proCodigo = proCodigo;
        this.proDescripcion = proDescripcion;
        this.proPrecioCompra = proPrecioCompra;
        this.proPrecioVenta = proPrecioVenta;
        this.proveCodigo = proveCodigo;
        this.proCantidad = proCantidad;
    }

    public Integer getProCodigo() {
        return proCodigo;
    }

    public void setProCodigo(Integer proCodigo) {
        Integer oldProCodigo = this.proCodigo;
        this.proCodigo = proCodigo;
        changeSupport.firePropertyChange("proCodigo", oldProCodigo, proCodigo);
    }

    public String getProDescripcion() {
        return proDescripcion;
    }

    public void setProDescripcion(String proDescripcion) {
        String oldProDescripcion = this.proDescripcion;
        this.proDescripcion = proDescripcion;
        changeSupport.firePropertyChange("proDescripcion", oldProDescripcion, proDescripcion);
    }

    public int getProPrecioCompra() {
        return proPrecioCompra;
    }

    public void setProPrecioCompra(int proPrecioCompra) {
        int oldProPrecioCompra = this.proPrecioCompra;
        this.proPrecioCompra = proPrecioCompra;
        changeSupport.firePropertyChange("proPrecioCompra", oldProPrecioCompra, proPrecioCompra);
    }

    public int getProPrecioVenta() {
        return proPrecioVenta;
    }

    public void setProPrecioVenta(int proPrecioVenta) {
        int oldProPrecioVenta = this.proPrecioVenta;
        this.proPrecioVenta = proPrecioVenta;
        changeSupport.firePropertyChange("proPrecioVenta", oldProPrecioVenta, proPrecioVenta);
    }

    public int getProveCodigo() {
        return proveCodigo;
    }

    public void setProveCodigo(int proveCodigo) {
        int oldProveCodigo = this.proveCodigo;
        this.proveCodigo = proveCodigo;
        changeSupport.firePropertyChange("proveCodigo", oldProveCodigo, proveCodigo);
    }

    public int getProCantidad() {
        return proCantidad;
    }

    public void setProCantidad(int proCantidad) {
        int oldProCantidad = this.proCantidad;
        this.proCantidad = proCantidad;
        changeSupport.firePropertyChange("proCantidad", oldProCantidad, proCantidad);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proCodigo != null ? proCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.proCodigo == null && other.proCodigo != null) || (this.proCodigo != null && !this.proCodigo.equals(other.proCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jguperapp.Producto[ proCodigo=" + proCodigo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
