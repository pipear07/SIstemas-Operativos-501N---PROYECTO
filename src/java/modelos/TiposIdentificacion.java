/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "tipos_identificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposIdentificacion.findAll", query = "SELECT t FROM TiposIdentificacion t")
    , @NamedQuery(name = "TiposIdentificacion.findByIdTipoIdentificacion", query = "SELECT t FROM TiposIdentificacion t WHERE t.idTipoIdentificacion = :idTipoIdentificacion")
    , @NamedQuery(name = "TiposIdentificacion.findByNombreTipoIdentificacion", query = "SELECT t FROM TiposIdentificacion t WHERE t.nombreTipoIdentificacion = :nombreTipoIdentificacion")})
public class TiposIdentificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_identificacion")
    private Integer idTipoIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_tipo_identificacion")
    private String nombreTipoIdentificacion;
    @OneToMany(mappedBy = "idTipoIdentificacion")
    private Collection<Empleados> empleadosCollection;

    public TiposIdentificacion() {
    }

    public TiposIdentificacion(Integer idTipoIdentificacion) {
        this.idTipoIdentificacion = idTipoIdentificacion;
    }

    public TiposIdentificacion(Integer idTipoIdentificacion, String nombreTipoIdentificacion) {
        this.idTipoIdentificacion = idTipoIdentificacion;
        this.nombreTipoIdentificacion = nombreTipoIdentificacion;
    }

    public Integer getIdTipoIdentificacion() {
        return idTipoIdentificacion;
    }

    public void setIdTipoIdentificacion(Integer idTipoIdentificacion) {
        this.idTipoIdentificacion = idTipoIdentificacion;
    }

    public String getNombreTipoIdentificacion() {
        return nombreTipoIdentificacion;
    }

    public void setNombreTipoIdentificacion(String nombreTipoIdentificacion) {
        this.nombreTipoIdentificacion = nombreTipoIdentificacion;
    }

    @XmlTransient
    public Collection<Empleados> getEmpleadosCollection() {
        return empleadosCollection;
    }

    public void setEmpleadosCollection(Collection<Empleados> empleadosCollection) {
        this.empleadosCollection = empleadosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoIdentificacion != null ? idTipoIdentificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposIdentificacion)) {
            return false;
        }
        TiposIdentificacion other = (TiposIdentificacion) object;
        if ((this.idTipoIdentificacion == null && other.idTipoIdentificacion != null) || (this.idTipoIdentificacion != null && !this.idTipoIdentificacion.equals(other.idTipoIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.TiposIdentificacion[ idTipoIdentificacion=" + idTipoIdentificacion + " ]";
    }
    
}
