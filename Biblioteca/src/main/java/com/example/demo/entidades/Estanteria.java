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
@Table(name = "estanteria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estanteria.findAll", query = "SELECT e FROM Estanteria e")})
public class Estanteria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_estanteria")
    private Integer codEstanteria;
    @Column(name = "e_descripcion")
    private String eDescripcion;
    @OneToMany(mappedBy = "codEstanteria")
    private List<EstanCate> estanCateList;

    public Estanteria() {
    }

    public Estanteria(Integer codEstanteria) {
        this.codEstanteria = codEstanteria;
    }

    public Integer getCodEstanteria() {
        return codEstanteria;
    }

    public void setCodEstanteria(Integer codEstanteria) {
        this.codEstanteria = codEstanteria;
    }

    public String getEDescripcion() {
        return eDescripcion;
    }

    public void setEDescripcion(String eDescripcion) {
        this.eDescripcion = eDescripcion;
    }

    @XmlTransient
    public List<EstanCate> getEstanCateList() {
        return estanCateList;
    }

    public void setEstanCateList(List<EstanCate> estanCateList) {
        this.estanCateList = estanCateList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEstanteria != null ? codEstanteria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estanteria)) {
            return false;
        }
        Estanteria other = (Estanteria) object;
        if ((this.codEstanteria == null && other.codEstanteria != null) || (this.codEstanteria != null && !this.codEstanteria.equals(other.codEstanteria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sj.Estanteria[ codEstanteria=" + codEstanteria + " ]";
    }
    
}
