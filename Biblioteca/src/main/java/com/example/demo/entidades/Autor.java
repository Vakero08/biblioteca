package com.example.demo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "autor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autor.findAll", query = "SELECT a FROM Autor a")})
public class Autor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_autor")
    private Integer codAutor;
    @Column(name = "a_nombre")
    private String aNombre;
    @Column(name = "a_apellido")
    private String aApellido;
    @Column(name = "a_pais")
    private String aPais;
    @Column(name = "a_ciudad")
    private String aCiudad;
    @Column(name = "a_telefono")
    private Integer aTelefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codAutor")
    private List<LibroAutor> libroAutorList;

    public Autor() {
    }

    public Autor(Integer codAutor) {
        this.codAutor = codAutor;
    }

    public Integer getCodAutor() {
        return codAutor;
    }

    public void setCodAutor(Integer codAutor) {
        this.codAutor = codAutor;
    }

    public String getANombre() {
        return aNombre;
    }

    public void setANombre(String aNombre) {
        this.aNombre = aNombre;
    }

    public String getAApellido() {
        return aApellido;
    }

    public void setAApellido(String aApellido) {
        this.aApellido = aApellido;
    }

    public String getAPais() {
        return aPais;
    }

    public void setAPais(String aPais) {
        this.aPais = aPais;
    }

    public String getACiudad() {
        return aCiudad;
    }

    public void setACiudad(String aCiudad) {
        this.aCiudad = aCiudad;
    }

    public Integer getATelefono() {
        return aTelefono;
    }

    public void setATelefono(Integer aTelefono) {
        this.aTelefono = aTelefono;
    }

    @XmlTransient
    public List<LibroAutor> getLibroAutorList() {
        return libroAutorList;
    }

    public void setLibroAutorList(List<LibroAutor> libroAutorList) {
        this.libroAutorList = libroAutorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAutor != null ? codAutor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autor)) {
            return false;
        }
        Autor other = (Autor) object;
        if ((this.codAutor == null && other.codAutor != null) || (this.codAutor != null && !this.codAutor.equals(other.codAutor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sj.Autor[ codAutor=" + codAutor + " ]";
    }
    
}
