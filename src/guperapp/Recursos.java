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
@Table(name = "recursos", catalog = "guper", schema = "")
@NamedQueries({
    @NamedQuery(name = "Recursos.findAll", query = "SELECT r FROM Recursos r"),
    @NamedQuery(name = "Recursos.findByFunCodigo", query = "SELECT r FROM Recursos r WHERE r.funCodigo = :funCodigo"),
    @NamedQuery(name = "Recursos.findBySalarioReal", query = "SELECT r FROM Recursos r WHERE r.salarioReal = :salarioReal"),
    @NamedQuery(name = "Recursos.findByIps", query = "SELECT r FROM Recursos r WHERE r.ips = :ips"),
    @NamedQuery(name = "Recursos.findByVacaciones", query = "SELECT r FROM Recursos r WHERE r.vacaciones = :vacaciones"),
    @NamedQuery(name = "Recursos.findByIndemnizacion", query = "SELECT r FROM Recursos r WHERE r.indemnizacion = :indemnizacion")})
public class Recursos implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "fun_codigo")
    private Integer funCodigo;
    @Basic(optional = false)
    @Column(name = "salario_real")
    private int salarioReal;
    @Basic(optional = false)
    @Column(name = "ips")
    private int ips;
    @Basic(optional = false)
    @Column(name = "vacaciones")
    private int vacaciones;
    @Basic(optional = false)
    @Column(name = "indemnizacion")
    private int indemnizacion;

    public Recursos() {
    }

    public Recursos(Integer funCodigo) {
        this.funCodigo = funCodigo;
    }

    public Recursos(Integer funCodigo, int salarioReal, int ips, int vacaciones, int indemnizacion) {
        this.funCodigo = funCodigo;
        this.salarioReal = salarioReal;
        this.ips = ips;
        this.vacaciones = vacaciones;
        this.indemnizacion = indemnizacion;
    }

    public Integer getFunCodigo() {
        return funCodigo;
    }

    public void setFunCodigo(Integer funCodigo) {
        Integer oldFunCodigo = this.funCodigo;
        this.funCodigo = funCodigo;
        changeSupport.firePropertyChange("funCodigo", oldFunCodigo, funCodigo);
    }

    public int getSalarioReal() {
        return salarioReal;
    }

    public void setSalarioReal(int salarioReal) {
        int oldSalarioReal = this.salarioReal;
        this.salarioReal = salarioReal;
        changeSupport.firePropertyChange("salarioReal", oldSalarioReal, salarioReal);
    }

    public int getIps() {
        return ips;
    }

    public void setIps(int ips) {
        int oldIps = this.ips;
        this.ips = ips;
        changeSupport.firePropertyChange("ips", oldIps, ips);
    }

    public int getVacaciones() {
        return vacaciones;
    }

    public void setVacaciones(int vacaciones) {
        int oldVacaciones = this.vacaciones;
        this.vacaciones = vacaciones;
        changeSupport.firePropertyChange("vacaciones", oldVacaciones, vacaciones);
    }

    public int getIndemnizacion() {
        return indemnizacion;
    }

    public void setIndemnizacion(int indemnizacion) {
        int oldIndemnizacion = this.indemnizacion;
        this.indemnizacion = indemnizacion;
        changeSupport.firePropertyChange("indemnizacion", oldIndemnizacion, indemnizacion);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (funCodigo != null ? funCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recursos)) {
            return false;
        }
        Recursos other = (Recursos) object;
        if ((this.funCodigo == null && other.funCodigo != null) || (this.funCodigo != null && !this.funCodigo.equals(other.funCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "guperapp.Recursos[ funCodigo=" + funCodigo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
