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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "libro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l")})
public class Libro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_libro")
    private Integer codLibro;
    @Basic(optional = false)
    @Column(name = "isbn")
    private int isbn;
    @Column(name = "l_titulo")
    private String lTitulo;
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codLibro")
    private List<LibroAutor> libroAutorList;
    @JoinColumn(name = "cod_editorial", referencedColumnName = "cod_editorial")
    @ManyToOne
    private Editorial codEditorial;

    public Libro() {
    }

    public Libro(Integer codLibro) {
        this.codLibro = codLibro;
    }

    public Libro(Integer codLibro, int isbn) {
        this.codLibro = codLibro;
        this.isbn = isbn;
    }

    public Integer getCodLibro() {
        return codLibro;
    }

    public void setCodLibro(Integer codLibro) {
        this.codLibro = codLibro;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getLTitulo() {
        return lTitulo;
    }

    public void setLTitulo(String lTitulo) {
        this.lTitulo = lTitulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<LibroAutor> getLibroAutorList() {
        return libroAutorList;
    }

    public void setLibroAutorList(List<LibroAutor> libroAutorList) {
        this.libroAutorList = libroAutorList;
    }

    public Editorial getCodEditorial() {
        return codEditorial;
    }

    public void setCodEditorial(Editorial codEditorial) {
        this.codEditorial = codEditorial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codLibro != null ? codLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.codLibro == null && other.codLibro != null) || (this.codLibro != null && !this.codLibro.equals(other.codLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sj.Libro[ codLibro=" + codLibro + " ]";
    }
    
}
