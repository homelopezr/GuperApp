/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guperapp;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Adrianlrx <adrianlrx@gmail.com>
 */
@Entity
@Table(name = "funcionarios", catalog = "guper", schema = "")
@NamedQueries({
    @NamedQuery(name = "Funcionarios.findAll", query = "SELECT f FROM Funcionarios f"),
    @NamedQuery(name = "Funcionarios.findByFunCodigo", query = "SELECT f FROM Funcionarios f WHERE f.funCodigo = :funCodigo"),
    @NamedQuery(name = "Funcionarios.findByFunCedula", query = "SELECT f FROM Funcionarios f WHERE f.funCedula = :funCedula"),
    @NamedQuery(name = "Funcionarios.findByFunNombre", query = "SELECT f FROM Funcionarios f WHERE f.funNombre = :funNombre"),
    @NamedQuery(name = "Funcionarios.findByFunDireccion", query = "SELECT f FROM Funcionarios f WHERE f.funDireccion = :funDireccion"),
    @NamedQuery(name = "Funcionarios.findByFunTelefono", query = "SELECT f FROM Funcionarios f WHERE f.funTelefono = :funTelefono"),
    @NamedQuery(name = "Funcionarios.findByFunIngreso", query = "SELECT f FROM Funcionarios f WHERE f.funIngreso = :funIngreso"),
    @NamedQuery(name = "Funcionarios.findByFunSituacion", query = "SELECT f FROM Funcionarios f WHERE f.funSituacion = :funSituacion")})
public class Funcionarios implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "fun_codigo")
    private Integer funCodigo;
    @Basic(optional = false)
    @Column(name = "fun_cedula")
    private String funCedula;
    @Basic(optional = false)
    @Column(name = "fun_nombre")
    private String funNombre;
    @Basic(optional = false)
    @Column(name = "fun_direccion")
    private String funDireccion;
    @Basic(optional = false)
    @Column(name = "fun_telefono")
    private String funTelefono;
    @Basic(optional = false)
    @Column(name = "fun_ingreso")
    @Temporal(TemporalType.DATE)
    private Date funIngreso;
    @Basic(optional = false)
    @Column(name = "fun_situacion")
    private String funSituacion;

    public Funcionarios() {
    }

    public Funcionarios(Integer funCodigo) {
        this.funCodigo = funCodigo;
    }

    public Funcionarios(Integer funCodigo, String funCedula, String funNombre, String funDireccion, String funTelefono, Date funIngreso, String funSituacion) {
        this.funCodigo = funCodigo;
        this.funCedula = funCedula;
        this.funNombre = funNombre;
        this.funDireccion = funDireccion;
        this.funTelefono = funTelefono;
        this.funIngreso = funIngreso;
        this.funSituacion = funSituacion;
    }

    public Integer getFunCodigo() {
        return funCodigo;
    }

    public void setFunCodigo(Integer funCodigo) {
        Integer oldFunCodigo = this.funCodigo;
        this.funCodigo = funCodigo;
        changeSupport.firePropertyChange("funCodigo", oldFunCodigo, funCodigo);
    }

    public String getFunCedula() {
        return funCedula;
    }

    public void setFunCedula(String funCedula) {
        String oldFunCedula = this.funCedula;
        this.funCedula = funCedula;
        changeSupport.firePropertyChange("funCedula", oldFunCedula, funCedula);
    }

    public String getFunNombre() {
        return funNombre;
    }

    public void setFunNombre(String funNombre) {
        String oldFunNombre = this.funNombre;
        this.funNombre = funNombre;
        changeSupport.firePropertyChange("funNombre", oldFunNombre, funNombre);
    }

    public String getFunDireccion() {
        return funDireccion;
    }

    public void setFunDireccion(String funDireccion) {
        String oldFunDireccion = this.funDireccion;
        this.funDireccion = funDireccion;
        changeSupport.firePropertyChange("funDireccion", oldFunDireccion, funDireccion);
    }

    public String getFunTelefono() {
        return funTelefono;
    }

    public void setFunTelefono(String funTelefono) {
        String oldFunTelefono = this.funTelefono;
        this.funTelefono = funTelefono;
        changeSupport.firePropertyChange("funTelefono", oldFunTelefono, funTelefono);
    }

    public Date getFunIngreso() {
        return funIngreso;
    }

    public void setFunIngreso(Date funIngreso) {
        Date oldFunIngreso = this.funIngreso;
        this.funIngreso = funIngreso;
        changeSupport.firePropertyChange("funIngreso", oldFunIngreso, funIngreso);
    }

    public String getFunSituacion() {
        return funSituacion;
    }

    public void setFunSituacion(String funSituacion) {
        String oldFunSituacion = this.funSituacion;
        this.funSituacion = funSituacion;
        changeSupport.firePropertyChange("funSituacion", oldFunSituacion, funSituacion);
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
        if (!(object instanceof Funcionarios)) {
            return false;
        }
        Funcionarios other = (Funcionarios) object;
        if ((this.funCodigo == null && other.funCodigo != null) || (this.funCodigo != null && !this.funCodigo.equals(other.funCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "guperapp.Funcionarios[ funCodigo=" + funCodigo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
