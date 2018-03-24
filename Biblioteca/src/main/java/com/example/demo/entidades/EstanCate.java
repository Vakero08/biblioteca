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
@Table(name = "Estan-Cate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstanCate.findAll", query = "SELECT e FROM EstanCate e")})
public class EstanCate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_esta_cate")
    private Integer codEstaCate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEstaCate")
    private List<LibroAutor> libroAutorList;
    @JoinColumn(name = "cod_estanteria", referencedColumnName = "cod_estanteria")
    @ManyToOne
    private Estanteria codEstanteria;
    @JoinColumn(name = "cod_categoria", referencedColumnName = "cod_categoria")
    @ManyToOne
    private Categoria codCategoria;

    public EstanCate() {
    }

    public EstanCate(Integer codEstaCate) {
        this.codEstaCate = codEstaCate;
    }

    public Integer getCodEstaCate() {
        return codEstaCate;
    }

    public void setCodEstaCate(Integer codEstaCate) {
        this.codEstaCate = codEstaCate;
    }

    @XmlTransient
    public List<LibroAutor> getLibroAutorList() {
        return libroAutorList;
    }

    public void setLibroAutorList(List<LibroAutor> libroAutorList) {
        this.libroAutorList = libroAutorList;
    }

    public Estanteria getCodEstanteria() {
        return codEstanteria;
    }

    public void setCodEstanteria(Estanteria codEstanteria) {
        this.codEstanteria = codEstanteria;
    }

    public Categoria getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(Categoria codCategoria) {
        this.codCategoria = codCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEstaCate != null ? codEstaCate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstanCate)) {
            return false;
        }
        EstanCate other = (EstanCate) object;
        if ((this.codEstaCate == null && other.codEstaCate != null) || (this.codEstaCate != null && !this.codEstaCate.equals(other.codEstaCate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sj.EstanCate[ codEstaCate=" + codEstaCate + " ]";
    }
    
}
