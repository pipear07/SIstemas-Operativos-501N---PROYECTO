/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pipear07
 */
@Entity
@Table(name = "razasvacas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Razasvacas.findAll", query = "SELECT r FROM Razasvacas r")
    , @NamedQuery(name = "Razasvacas.findByIdRaza", query = "SELECT r FROM Razasvacas r WHERE r.idRaza = :idRaza")
    , @NamedQuery(name = "Razasvacas.findByNombreRaza", query = "SELECT r FROM Razasvacas r WHERE r.nombreRaza = :nombreRaza")
    , @NamedQuery(name = "Razasvacas.findByDescripcion", query = "SELECT r FROM Razasvacas r WHERE r.descripcion = :descripcion")})
public class Razasvacas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_raza")
    private Integer idRaza;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_raza")
    private String nombreRaza;
    @Size(max = 300)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRaza")
    private Collection<Vacas> vacasCollection;

    public Razasvacas() {
    }

    public Razasvacas(Integer idRaza) {
        this.idRaza = idRaza;
    }

    public Razasvacas(Integer idRaza, String nombreRaza) {
        this.idRaza = idRaza;
        this.nombreRaza = nombreRaza;
    }

    public Integer getIdRaza() {
        return idRaza;
    }

    public void setIdRaza(Integer idRaza) {
        this.idRaza = idRaza;
    }

    public String getNombreRaza() {
        return nombreRaza;
    }

    public void setNombreRaza(String nombreRaza) {
        this.nombreRaza = nombreRaza;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Vacas> getVacasCollection() {
        return vacasCollection;
    }

    public void setVacasCollection(Collection<Vacas> vacasCollection) {
        this.vacasCollection = vacasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRaza != null ? idRaza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Razasvacas)) {
            return false;
        }
        Razasvacas other = (Razasvacas) object;
        if ((this.idRaza == null && other.idRaza != null) || (this.idRaza != null && !this.idRaza.equals(other.idRaza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Razasvacas[ idRaza=" + idRaza + " ]";
    }
    
}
