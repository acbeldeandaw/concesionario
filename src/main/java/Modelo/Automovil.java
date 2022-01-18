/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

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
 * @author DAW-A
 */
@Entity
@Table(name = "automovil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Automovil.findAll", query = "SELECT a FROM Automovil a"),
    @NamedQuery(name = "Automovil.findById", query = "SELECT a FROM Automovil a WHERE a.id = :id"),
    @NamedQuery(name = "Automovil.findByCategoria", query = "SELECT a FROM Automovil a WHERE a.categoria = :categoria"),
    @NamedQuery(name = "Automovil.findByPrecio", query = "SELECT a FROM Automovil a WHERE a.precio = :precio"),
    @NamedQuery(name = "Automovil.findByMarca", query = "SELECT a FROM Automovil a WHERE a.marca = :marca"),
    @NamedQuery(name = "Automovil.findByModelo", query = "SELECT a FROM Automovil a WHERE a.modelo = :modelo"),
    @NamedQuery(name = "Automovil.findByFab", query = "SELECT a FROM Automovil a WHERE a.fab = :fab"),
    @NamedQuery(name = "Automovil.findByFoto", query = "SELECT a FROM Automovil a WHERE a.foto = :foto")})
public class Automovil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "categoria")
    private String categoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private int precio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fab")
    private int fab;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "foto")
    private String foto;

    public Automovil() {
    }

    public Automovil(Integer id) {
        this.id = id;
    }
    
    public Automovil(String categoria, int precio, String marca, String modelo, int fab, String foto) {
        this.categoria = categoria;
        this.precio = precio;
        this.marca = marca;
        this.modelo = modelo;
        this.fab = fab;
        this.foto = foto;
    }
    
    public Automovil(Integer id, String categoria, int precio, String marca, String modelo, int fab, String foto) {
        this.id = id;
        this.categoria = categoria;
        this.precio = precio;
        this.marca = marca;
        this.modelo = modelo;
        this.fab = fab;
        this.foto = foto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getFab() {
        return fab;
    }

    public void setFab(int fab) {
        this.fab = fab;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Automovil)) {
            return false;
        }
        Automovil other = (Automovil) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Automovil[ id=" + id + " ]";
    }
    
}
