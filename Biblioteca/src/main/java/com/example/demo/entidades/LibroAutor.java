package com.example.demo.entidades;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "Libro-Autor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LibroAutor.findAll", query = "SELECT l FROM LibroAutor l")})
public class LibroAutor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "num_paginas")
    private Integer numPaginas;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_lib_aut")
    private Integer codLibAut;
    @JoinColumn(name = "cod_libro", referencedColumnName = "cod_libro")
    @ManyToOne(optional = false)
    private Libro codLibro;
    @JoinColumn(name = "cod_autor", referencedColumnName = "cod_autor")
    @ManyToOne(optional = false)
    private Autor codAutor;
    @JoinColumn(name = "cod_esta_cate", referencedColumnName = "cod_esta_cate")
    @ManyToOne(optional = false)
    private EstanCate codEstaCate;

    public LibroAutor() {
    }

    public LibroAutor(Integer codLibAut) {
        this.codLibAut = codLibAut;
    }

    public Integer getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(Integer numPaginas) {
        this.numPaginas = numPaginas;
    }

    public Integer getCodLibAut() {
        return codLibAut;
    }

    public void setCodLibAut(Integer codLibAut) {
        this.codLibAut = codLibAut;
    }

    public Libro getCodLibro() {
        return codLibro;
    }

    public void setCodLibro(Libro codLibro) {
        this.codLibro = codLibro;
    }

    public Autor getCodAutor() {
        return codAutor;
    }

    public void setCodAutor(Autor codAutor) {
        this.codAutor = codAutor;
    }

    public EstanCate getCodEstaCate() {
        return codEstaCate;
    }

    public void setCodEstaCate(EstanCate codEstaCate) {
        this.codEstaCate = codEstaCate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codLibAut != null ? codLibAut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibroAutor)) {
            return false;
        }
        LibroAutor other = (LibroAutor) object;
        if ((this.codLibAut == null && other.codLibAut != null) || (this.codLibAut != null && !this.codLibAut.equals(other.codLibAut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sj.LibroAutor[ codLibAut=" + codLibAut + " ]";
    }
    
}
