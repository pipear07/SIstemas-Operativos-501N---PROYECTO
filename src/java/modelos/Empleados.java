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
@Table(name = "empleados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e")
    , @NamedQuery(name = "Empleados.findByIdEmpleado", query = "SELECT e FROM Empleados e WHERE e.idEmpleado = :idEmpleado")
    , @NamedQuery(name = "Empleados.findByPrimerNombre", query = "SELECT e FROM Empleados e WHERE e.primerNombre = :primerNombre")
    , @NamedQuery(name = "Empleados.findBySegundoNombre", query = "SELECT e FROM Empleados e WHERE e.segundoNombre = :segundoNombre")
    , @NamedQuery(name = "Empleados.findByPrimerApellido", query = "SELECT e FROM Empleados e WHERE e.primerApellido = :primerApellido")
    , @NamedQuery(name = "Empleados.findBySegundoApellido", query = "SELECT e FROM Empleados e WHERE e.segundoApellido = :segundoApellido")
    , @NamedQuery(name = "Empleados.findByNumIdentificacion", query = "SELECT e FROM Empleados e WHERE e.numIdentificacion = :numIdentificacion")
    , @NamedQuery(name = "Empleados.findByCorreoElectronico", query = "SELECT e FROM Empleados e WHERE e.correoElectronico = :correoElectronico")
    , @NamedQuery(name = "Empleados.findByActivo", query = "SELECT e FROM Empleados e WHERE e.activo = :activo")
    , @NamedQuery(name = "Empleados.findByFechaRegistro", query = "SELECT e FROM Empleados e WHERE e.fechaRegistro = :fechaRegistro")})
public class Empleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empleado")
    private Integer idEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "primer_nombre")
    private String primerNombre;
    @Size(max = 70)
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Size(max = 70)
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "num_identificacion")
    private String numIdentificacion;
    @Size(max = 300)
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @OneToMany(mappedBy = "idEmpleado")
    private Collection<Detallesproduccion> detallesproduccionCollection;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @ManyToOne
    private Roles idRol;
    @JoinColumn(name = "id_tipo_identificacion", referencedColumnName = "id_tipo_identificacion")
    @ManyToOne
    private TiposIdentificacion idTipoIdentificacion;

    public Empleados() {
    }

    public Empleados(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleados(Integer idEmpleado, String primerNombre, String primerApellido, String numIdentificacion, boolean activo, Date fechaRegistro) {
        this.idEmpleado = idEmpleado;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.numIdentificacion = numIdentificacion;
        this.activo = activo;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setNumIdentificacion(String numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @XmlTransient
    public Collection<Detallesproduccion> getDetallesproduccionCollection() {
        return detallesproduccionCollection;
    }

    public void setDetallesproduccionCollection(Collection<Detallesproduccion> detallesproduccionCollection) {
        this.detallesproduccionCollection = detallesproduccionCollection;
    }

    public Roles getIdRol() {
        return idRol;
    }

    public void setIdRol(Roles idRol) {
        this.idRol = idRol;
    }

    public TiposIdentificacion getIdTipoIdentificacion() {
        return idTipoIdentificacion;
    }

    public void setIdTipoIdentificacion(TiposIdentificacion idTipoIdentificacion) {
        this.idTipoIdentificacion = idTipoIdentificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Empleados[ idEmpleado=" + idEmpleado + " ]";
    }
    
}
