/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pipear07
 */
@Entity
@Table(name = "detallesproduccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallesproduccion.findAll", query = "SELECT d FROM Detallesproduccion d")
    , @NamedQuery(name = "Detallesproduccion.findByIdDetallesproduccion", query = "SELECT d FROM Detallesproduccion d WHERE d.idDetallesproduccion = :idDetallesproduccion")
    , @NamedQuery(name = "Detallesproduccion.findByManodeObra", query = "SELECT d FROM Detallesproduccion d WHERE d.manodeObra = :manodeObra")
    , @NamedQuery(name = "Detallesproduccion.findByFertilizantes", query = "SELECT d FROM Detallesproduccion d WHERE d.fertilizantes = :fertilizantes")
    , @NamedQuery(name = "Detallesproduccion.findByArreglopraderas", query = "SELECT d FROM Detallesproduccion d WHERE d.arreglopraderas = :arreglopraderas")
    , @NamedQuery(name = "Detallesproduccion.findByMantenimientoMaquinas", query = "SELECT d FROM Detallesproduccion d WHERE d.mantenimientoMaquinas = :mantenimientoMaquinas")
    , @NamedQuery(name = "Detallesproduccion.findByReparacionCercas", query = "SELECT d FROM Detallesproduccion d WHERE d.reparacionCercas = :reparacionCercas")
    , @NamedQuery(name = "Detallesproduccion.findByServicios", query = "SELECT d FROM Detallesproduccion d WHERE d.servicios = :servicios")
    , @NamedQuery(name = "Detallesproduccion.findByCostoTotal", query = "SELECT d FROM Detallesproduccion d WHERE d.costoTotal = :costoTotal")
    , @NamedQuery(name = "Detallesproduccion.findByFechaRegistro", query = "SELECT d FROM Detallesproduccion d WHERE d.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "Detallesproduccion.findByLitrosLeche", query = "SELECT d FROM Detallesproduccion d WHERE d.litrosLeche = :litrosLeche")})
public class Detallesproduccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detallesproduccion")
    private Integer idDetallesproduccion;
    @Column(name = "ManodeObra")
    private Integer manodeObra;
    @Column(name = "Fertilizantes")
    private Integer fertilizantes;
    @Column(name = "Arreglopraderas")
    private Integer arreglopraderas;
    @Column(name = "MantenimientoMaquinas")
    private Integer mantenimientoMaquinas;
    @Column(name = "ReparacionCercas")
    private Integer reparacionCercas;
    @Column(name = "Servicios")
    private Integer servicios;
    @Column(name = "CostoTotal")
    private Integer costoTotal;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "litros_leche")
    private int litrosLeche;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne
    private Empleados idEmpleado;
    @JoinColumn(name = "id_insumo", referencedColumnName = "id_insumo")
    @ManyToOne
    private Insumoleche idInsumo;
    @JoinColumn(name = "id_vaca", referencedColumnName = "id_vaca")
    @ManyToOne
    private Vacas idVaca;

    public Detallesproduccion() {
    }

    public Detallesproduccion(Integer idDetallesproduccion) {
        this.idDetallesproduccion = idDetallesproduccion;
    }

    public Detallesproduccion(Integer idDetallesproduccion, int litrosLeche) {
        this.idDetallesproduccion = idDetallesproduccion;
        this.litrosLeche = litrosLeche;
    }

    public Integer getIdDetallesproduccion() {
        return idDetallesproduccion;
    }

    public void setIdDetallesproduccion(Integer idDetallesproduccion) {
        this.idDetallesproduccion = idDetallesproduccion;
    }

    public Integer getManodeObra() {
        return manodeObra;
    }

    public void setManodeObra(Integer manodeObra) {
        this.manodeObra = manodeObra;
    }

    public Integer getFertilizantes() {
        return fertilizantes;
    }

    public void setFertilizantes(Integer fertilizantes) {
        this.fertilizantes = fertilizantes;
    }

    public Integer getArreglopraderas() {
        return arreglopraderas;
    }

    public void setArreglopraderas(Integer arreglopraderas) {
        this.arreglopraderas = arreglopraderas;
    }

    public Integer getMantenimientoMaquinas() {
        return mantenimientoMaquinas;
    }

    public void setMantenimientoMaquinas(Integer mantenimientoMaquinas) {
        this.mantenimientoMaquinas = mantenimientoMaquinas;
    }

    public Integer getReparacionCercas() {
        return reparacionCercas;
    }

    public void setReparacionCercas(Integer reparacionCercas) {
        this.reparacionCercas = reparacionCercas;
    }

    public Integer getServicios() {
        return servicios;
    }

    public void setServicios(Integer servicios) {
        this.servicios = servicios;
    }

    public Integer getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Integer costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getLitrosLeche() {
        return litrosLeche;
    }

    public void setLitrosLeche(int litrosLeche) {
        this.litrosLeche = litrosLeche;
    }

    public Empleados getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleados idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Insumoleche getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(Insumoleche idInsumo) {
        this.idInsumo = idInsumo;
    }

    public Vacas getIdVaca() {
        return idVaca;
    }

    public void setIdVaca(Vacas idVaca) {
        this.idVaca = idVaca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetallesproduccion != null ? idDetallesproduccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallesproduccion)) {
            return false;
        }
        Detallesproduccion other = (Detallesproduccion) object;
        if ((this.idDetallesproduccion == null && other.idDetallesproduccion != null) || (this.idDetallesproduccion != null && !this.idDetallesproduccion.equals(other.idDetallesproduccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Detallesproduccion[ idDetallesproduccion=" + idDetallesproduccion + " ]";
    }
    
}
