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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Family
 */
@Entity
@Table(name = "detalle_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleCompra.findAll", query = "SELECT d FROM DetalleCompra d")
    , @NamedQuery(name = "DetalleCompra.findByNRegistro", query = "SELECT d FROM DetalleCompra d WHERE d.nRegistro = :nRegistro")
    , @NamedQuery(name = "DetalleCompra.findByNombreProducto", query = "SELECT d FROM DetalleCompra d WHERE d.nombreProducto = :nombreProducto")
    , @NamedQuery(name = "DetalleCompra.findByPrecio", query = "SELECT d FROM DetalleCompra d WHERE d.precio = :precio")
    , @NamedQuery(name = "DetalleCompra.findByCantProducto", query = "SELECT d FROM DetalleCompra d WHERE d.cantProducto = :cantProducto")
    , @NamedQuery(name = "DetalleCompra.findByTotal", query = "SELECT d FROM DetalleCompra d WHERE d.total = :total")
    , @NamedQuery(name = "DetalleCompra.findByIdCompra", query = "SELECT d FROM DetalleCompra d WHERE d.idCompra = :idCompra")
    , @NamedQuery(name = "DetalleCompra.findByEstado", query = "SELECT d FROM DetalleCompra d WHERE d.estado = :estado")})
public class DetalleCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NRegistro")
    private Integer nRegistro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreProducto")
    private String nombreProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "precio")
    private String precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantProducto")
    private int cantProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private int total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCompra")
    private int idCompra;
    @Column(name = "estado")
    private Integer estado;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto idProducto;

    public DetalleCompra() {
    }

    public DetalleCompra(Integer nRegistro) {
        this.nRegistro = nRegistro;
    }

    public DetalleCompra(Integer nRegistro, String nombreProducto, String precio, int cantProducto, int total, int idCompra) {
        this.nRegistro = nRegistro;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.cantProducto = cantProducto;
        this.total = total;
        this.idCompra = idCompra;
    }

    public Integer getNRegistro() {
        return nRegistro;
    }

    public void setNRegistro(Integer nRegistro) {
        this.nRegistro = nRegistro;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getCantProducto() {
        return cantProducto;
    }

    public void setCantProducto(int cantProducto) {
        this.cantProducto = cantProducto;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nRegistro != null ? nRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCompra)) {
            return false;
        }
        DetalleCompra other = (DetalleCompra) object;
        if ((this.nRegistro == null && other.nRegistro != null) || (this.nRegistro != null && !this.nRegistro.equals(other.nRegistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DetalleCompra[ nRegistro=" + nRegistro + " ]";
    }
    
}
