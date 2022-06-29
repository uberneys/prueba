/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Family
 */
@Entity
@Table(name = "detalle_pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallePedido.findAll", query = "SELECT d FROM DetallePedido d")
    , @NamedQuery(name = "DetallePedido.findByIdDetalle", query = "SELECT d FROM DetallePedido d WHERE d.idDetalle = :idDetalle")
    , @NamedQuery(name = "DetallePedido.findByIdProducto", query = "SELECT d FROM DetallePedido d WHERE d.idProducto = :idProducto")
    , @NamedQuery(name = "DetallePedido.findByIdPedido", query = "SELECT d FROM DetallePedido d WHERE d.idPedido = :idPedido")
    , @NamedQuery(name = "DetallePedido.findByCantProducto", query = "SELECT d FROM DetallePedido d WHERE d.cantProducto = :cantProducto")
    , @NamedQuery(name = "DetallePedido.findByEstado", query = "SELECT d FROM DetallePedido d WHERE d.estado = :estado")})
public class DetallePedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDetalle")
    private Integer idDetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProducto")
    private int idProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPedido")
    private int idPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantProducto")
    private int cantProducto;
    @Column(name = "estado")
    private Integer estado;

    public DetallePedido() {
    }

    public DetallePedido(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public DetallePedido(Integer idDetalle, int idProducto, int idPedido, int cantProducto) {
        this.idDetalle = idDetalle;
        this.idProducto = idProducto;
        this.idPedido = idPedido;
        this.cantProducto = cantProducto;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getCantProducto() {
        return cantProducto;
    }

    public void setCantProducto(int cantProducto) {
        this.cantProducto = cantProducto;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalle != null ? idDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePedido)) {
            return false;
        }
        DetallePedido other = (DetallePedido) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DetallePedido[ idDetalle=" + idDetalle + " ]";
    }
    
}
