package com.example.demo.entidades;

import java.io.Serializable;
import java.util.List;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "editorial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Editorial.findAll", query = "SELECT e FROM Editorial e")})
public class Editorial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_editorial")
    private Integer codEditorial;
    @Column(name = "e_nombre")
    private String eNombre;
    @Column(name = "e_direccion")
    private String eDireccion;
    @Column(name = "e_telefono")
    private Integer eTelefono;
    @Column(name = "e_ciudad")
    private String eCiudad;
    @OneToMany(mappedBy = "codEditorial")
    private List<Libro> libroList;

    public Editorial() {
    }

    public Editorial(Integer codEditorial) {
        this.codEditorial = codEditorial;
    }

    public Integer getCodEditorial() {
        return codEditorial;
    }

    public void setCodEditorial(Integer codEditorial) {
        this.codEditorial = codEditorial;
    }

    public String getENombre() {
        return eNombre;
    }

    public void setENombre(String eNombre) {
        this.eNombre = eNombre;
    }

    public String getEDireccion() {
        return eDireccion;
    }

    public void setEDireccion(String eDireccion) {
        this.eDireccion = eDireccion;
    }

    public Integer getETelefono() {
        return eTelefono;
    }

    public void setETelefono(Integer eTelefono) {
        this.eTelefono = eTelefono;
    }

    public String getECiudad() {
        return eCiudad;
    }

    public void setECiudad(String eCiudad) {
        this.eCiudad = eCiudad;
    }

    @XmlTransient
    public List<Libro> getLibroList() {
        return libroList;
    }

    public void setLibroList(List<Libro> libroList) {
        this.libroList = libroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEditorial != null ? codEditorial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Editorial)) {
            return false;
        }
        Editorial other = (Editorial) object;
        if ((this.codEditorial == null && other.codEditorial != null) || (this.codEditorial != null && !this.codEditorial.equals(other.codEditorial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sj.Editorial[ codEditorial=" + codEditorial + " ]";
    }
    
}
