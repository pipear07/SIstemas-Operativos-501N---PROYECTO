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
@Table(name = "insumoleche")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Insumoleche.findAll", query = "SELECT i FROM Insumoleche i")
    , @NamedQuery(name = "Insumoleche.findByIdInsumo", query = "SELECT i FROM Insumoleche i WHERE i.idInsumo = :idInsumo")
    , @NamedQuery(name = "Insumoleche.findByDescripcion", query = "SELECT i FROM Insumoleche i WHERE i.descripcion = :descripcion")
    , @NamedQuery(name = "Insumoleche.findByNombreInsumo", query = "SELECT i FROM Insumoleche i WHERE i.nombreInsumo = :nombreInsumo")
    , @NamedQuery(name = "Insumoleche.findByFechaSuministro", query = "SELECT i FROM Insumoleche i WHERE i.fechaSuministro = :fechaSuministro")
    , @NamedQuery(name = "Insumoleche.findByCantidadtotal", query = "SELECT i FROM Insumoleche i WHERE i.cantidadtotal = :cantidadtotal")
    , @NamedQuery(name = "Insumoleche.findByCantidaddisponible", query = "SELECT i FROM Insumoleche i WHERE i.cantidaddisponible = :cantidaddisponible")})
public class Insumoleche implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_insumo")
    private Integer idInsumo;
    @Size(max = 250)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "NombreInsumo")
    private String nombreInsumo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_suministro")
    @Temporal(TemporalType.DATE)
    private Date fechaSuministro;
    @Column(name = "cantidadtotal")
    private Integer cantidadtotal;
    @Column(name = "cantidaddisponible")
    private Integer cantidaddisponible;
    @OneToMany(mappedBy = "idInsumo")
    private Collection<Detallesproduccion> detallesproduccionCollection;

    public Insumoleche() {
    }

    public Insumoleche(Integer idInsumo) {
        this.idInsumo = idInsumo;
    }

    public Insumoleche(Integer idInsumo, String nombreInsumo, Date fechaSuministro) {
        this.idInsumo = idInsumo;
        this.nombreInsumo = nombreInsumo;
        this.fechaSuministro = fechaSuministro;
    }

    public Integer getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(Integer idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }

    public Date getFechaSuministro() {
        return fechaSuministro;
    }

    public void setFechaSuministro(Date fechaSuministro) {
        this.fechaSuministro = fechaSuministro;
    }

    public Integer getCantidadtotal() {
        return cantidadtotal;
    }

    public void setCantidadtotal(Integer cantidadtotal) {
        this.cantidadtotal = cantidadtotal;
    }

    public Integer getCantidaddisponible() {
        return cantidaddisponible;
    }

    public void setCantidaddisponible(Integer cantidaddisponible) {
        this.cantidaddisponible = cantidaddisponible;
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
        hash += (idInsumo != null ? idInsumo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Insumoleche)) {
            return false;
        }
        Insumoleche other = (Insumoleche) object;
        if ((this.idInsumo == null && other.idInsumo != null) || (this.idInsumo != null && !this.idInsumo.equals(other.idInsumo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Insumoleche[ idInsumo=" + idInsumo + " ]";
    }
    
}
