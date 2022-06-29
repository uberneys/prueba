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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "credito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Credito.findAll", query = "SELECT c FROM Credito c")
    , @NamedQuery(name = "Credito.findByNumCredito", query = "SELECT c FROM Credito c WHERE c.numCredito = :numCredito")
    , @NamedQuery(name = "Credito.findByCupoCredito", query = "SELECT c FROM Credito c WHERE c.cupoCredito = :cupoCredito")
    , @NamedQuery(name = "Credito.findByFechaInicio", query = "SELECT c FROM Credito c WHERE c.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Credito.findByFechaLimite", query = "SELECT c FROM Credito c WHERE c.fechaLimite = :fechaLimite")
    , @NamedQuery(name = "Credito.findByIdUsuario", query = "SELECT c FROM Credito c WHERE c.idUsuario = :idUsuario")
    , @NamedQuery(name = "Credito.findByIdVenta", query = "SELECT c FROM Credito c WHERE c.idVenta = :idVenta")
    , @NamedQuery(name = "Credito.findByEstado", query = "SELECT c FROM Credito c WHERE c.estado = :estado")})
public class Credito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numCredito")
    private Integer numCredito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cupoCredito")
    private int cupoCredito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "fechaInicio")
    private String fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "fechaLimite")
    private String fechaLimite;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuario")
    private int idUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idVenta")
    private int idVenta;
    @Column(name = "estado")
    private Integer estado;

    public Credito() {
    }

    public Credito(Integer numCredito) {
        this.numCredito = numCredito;
    }

    public Credito(Integer numCredito, int cupoCredito, String fechaInicio, String fechaLimite, int idUsuario, int idVenta) {
        this.numCredito = numCredito;
        this.cupoCredito = cupoCredito;
        this.fechaInicio = fechaInicio;
        this.fechaLimite = fechaLimite;
        this.idUsuario = idUsuario;
        this.idVenta = idVenta;
    }

    public Integer getNumCredito() {
        return numCredito;
    }

    public void setNumCredito(Integer numCredito) {
        this.numCredito = numCredito;
    }

    public int getCupoCredito() {
        return cupoCredito;
    }

    public void setCupoCredito(int cupoCredito) {
        this.cupoCredito = cupoCredito;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
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
        hash += (numCredito != null ? numCredito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Credito)) {
            return false;
        }
        Credito other = (Credito) object;
        if ((this.numCredito == null && other.numCredito != null) || (this.numCredito != null && !this.numCredito.equals(other.numCredito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Credito[ numCredito=" + numCredito + " ]";
    }
    
}
