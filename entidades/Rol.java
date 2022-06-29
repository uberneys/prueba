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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Family
 */
@Entity
@Table(name = "rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r")
    , @NamedQuery(name = "Rol.findByIdRrol", query = "SELECT r FROM Rol r WHERE r.idRrol = :idRrol")
    , @NamedQuery(name = "Rol.findByTipodeRol", query = "SELECT r FROM Rol r WHERE r.tipodeRol = :tipodeRol")})
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idRrol")
    private Integer idRrol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipodeRol")
    private String tipodeRol;

    public Rol() {
    }

    public Rol(Integer idRrol) {
        this.idRrol = idRrol;
    }

    public Rol(Integer idRrol, String tipodeRol) {
        this.idRrol = idRrol;
        this.tipodeRol = tipodeRol;
    }

    public Integer getIdRrol() {
        return idRrol;
    }

    public void setIdRrol(Integer idRrol) {
        this.idRrol = idRrol;
    }

    public String getTipodeRol() {
        return tipodeRol;
    }

    public void setTipodeRol(String tipodeRol) {
        this.tipodeRol = tipodeRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRrol != null ? idRrol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.idRrol == null && other.idRrol != null) || (this.idRrol != null && !this.idRrol.equals(other.idRrol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Rol[ idRrol=" + idRrol + " ]";
    }
    
}
