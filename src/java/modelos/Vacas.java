/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pipear07
 */
@Entity
@Table(name = "vacas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacas.findAll", query = "SELECT v FROM Vacas v")
    , @NamedQuery(name = "Vacas.findByIdVaca", query = "SELECT v FROM Vacas v WHERE v.idVaca = :idVaca")
    , @NamedQuery(name = "Vacas.findByCodigoVaca", query = "SELECT v FROM Vacas v WHERE v.codigoVaca = :codigoVaca")
    , @NamedQuery(name = "Vacas.findByFechaRegistro", query = "SELECT v FROM Vacas v WHERE v.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "Vacas.findByFechaNacimiento", query = "SELECT v FROM Vacas v WHERE v.fechaNacimiento = :fechaNacimiento")})
public class Vacas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vaca")
    private Integer idVaca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "codigo_vaca")
    private String codigoVaca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @JoinColumn(name = "id_raza", referencedColumnName = "id_raza")
    @ManyToOne(optional = false)
    private Razasvacas idRaza;
    @OneToMany(mappedBy = "idVaca")
    private Collection<Detallesproduccion> detallesproduccionCollection;

    public Vacas() {
    }

    public Vacas(Integer idVaca) {
        this.idVaca = idVaca;
    }

    public Vacas(Integer idVaca, String codigoVaca, Date fechaRegistro, Date fechaNacimiento) {
        this.idVaca = idVaca;
        this.codigoVaca = codigoVaca;
        this.fechaRegistro = fechaRegistro;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getIdVaca() {
        return idVaca;
    }

    public void setIdVaca(Integer idVaca) {
        this.idVaca = idVaca;
    }

    public String getCodigoVaca() {
        return codigoVaca;
    }

    public void setCodigoVaca(String codigoVaca) {
        this.codigoVaca = codigoVaca;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Razasvacas getIdRaza() {
        return idRaza;
    }

    public void setIdRaza(Razasvacas idRaza) {
        this.idRaza = idRaza;
    }

    @XmlTransient
    public Collection<Detallesproduccion> getDetallesproduccionCollection() {
        return detallesproduccionCollection;
    }

    public void setDetallesproduccionCollection(Collection<Detallesproduccion> detallesproduccionCollection) {
        this.detallesproduccionCollection = detallesproduccionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVaca != null ? idVaca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacas)) {
            return false;
        }
        Vacas other = (Vacas) object;
        if ((this.idVaca == null && other.idVaca != null) || (this.idVaca != null && !this.idVaca.equals(other.idVaca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Vacas[ idVaca=" + idVaca + " ]";
    }
    
}
