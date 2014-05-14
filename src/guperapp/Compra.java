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
@Table(name = "compra", catalog = "guper", schema = "")
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c"),
    @NamedQuery(name = "Compra.findByComNumero", query = "SELECT c FROM Compra c WHERE c.comNumero = :comNumero"),
    @NamedQuery(name = "Compra.findByComComprobante", query = "SELECT c FROM Compra c WHERE c.comComprobante = :comComprobante"),
    @NamedQuery(name = "Compra.findByProveCodigo", query = "SELECT c FROM Compra c WHERE c.proveCodigo = :proveCodigo"),
    @NamedQuery(name = "Compra.findByComObservacion", query = "SELECT c FROM Compra c WHERE c.comObservacion = :comObservacion"),
    @NamedQuery(name = "Compra.findByProCodigo", query = "SELECT c FROM Compra c WHERE c.proCodigo = :proCodigo"),
    @NamedQuery(name = "Compra.findByProCantidad", query = "SELECT c FROM Compra c WHERE c.proCantidad = :proCantidad"),
    @NamedQuery(name = "Compra.findByComTotal", query = "SELECT c FROM Compra c WHERE c.comTotal = :comTotal")})
public class Compra implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "com_numero")
    private Integer comNumero;
    @Basic(optional = false)
    @Column(name = "com_comprobante")
    private int comComprobante;
    @Basic(optional = false)
    @Column(name = "prove_codigo")
    private int proveCodigo;
    @Basic(optional = false)
    @Column(name = "com_observacion")
    private String comObservacion;
    @Basic(optional = false)
    @Column(name = "pro_codigo")
    private int proCodigo;
    @Basic(optional = false)
    @Column(name = "pro_cantidad")
    private int proCantidad;
    @Basic(optional = false)
    @Column(name = "com_total")
    private int comTotal;

    public Compra() {
    }

    public Compra(Integer comNumero) {
        this.comNumero = comNumero;
    }

    public Compra(Integer comNumero, int comComprobante, int proveCodigo, String comObservacion, int proCodigo, int proCantidad, int comTotal) {
        this.comNumero = comNumero;
        this.comComprobante = comComprobante;
        this.proveCodigo = proveCodigo;
        this.comObservacion = comObservacion;
        this.proCodigo = proCodigo;
        this.proCantidad = proCantidad;
        this.comTotal = comTotal;
    }

    public Integer getComNumero() {
        return comNumero;
    }

    public void setComNumero(Integer comNumero) {
        Integer oldComNumero = this.comNumero;
        this.comNumero = comNumero;
        changeSupport.firePropertyChange("comNumero", oldComNumero, comNumero);
    }

    public int getComComprobante() {
        return comComprobante;
    }

    public void setComComprobante(int comComprobante) {
        int oldComComprobante = this.comComprobante;
        this.comComprobante = comComprobante;
        changeSupport.firePropertyChange("comComprobante", oldComComprobante, comComprobante);
    }

    public int getProveCodigo() {
        return proveCodigo;
    }

    public void setProveCodigo(int proveCodigo) {
        int oldProveCodigo = this.proveCodigo;
        this.proveCodigo = proveCodigo;
        changeSupport.firePropertyChange("proveCodigo", oldProveCodigo, proveCodigo);
    }

    public String getComObservacion() {
        return comObservacion;
    }

    public void setComObservacion(String comObservacion) {
        String oldComObservacion = this.comObservacion;
        this.comObservacion = comObservacion;
        changeSupport.firePropertyChange("comObservacion", oldComObservacion, comObservacion);
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

    public int getComTotal() {
        return comTotal;
    }

    public void setComTotal(int comTotal) {
        int oldComTotal = this.comTotal;
        this.comTotal = comTotal;
        changeSupport.firePropertyChange("comTotal", oldComTotal, comTotal);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comNumero != null ? comNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.comNumero == null && other.comNumero != null) || (this.comNumero != null && !this.comNumero.equals(other.comNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "guperapp.Compra[ comNumero=" + comNumero + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
