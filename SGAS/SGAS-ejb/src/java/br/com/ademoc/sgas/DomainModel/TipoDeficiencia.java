/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgas.DomainModel;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @version 1.0
 * @since 1.0 06/06/2012
 * @author Kennedi Paulo S. Malheiros
 */
@Entity(name = "tiposdeficiencias")
public class TipoDeficiencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo")
    private Long id;
    //Duvida em utilizar CascadeType.Qual?
    @ManyToOne
    TipoAparelho tipoAparelho;
    @ManyToOne
    Categoria categoria;
    @Column(name = "descricao", length = 255, nullable = false)
    private String descricao;

    //Construtor da Classe
    public void TipoDeficiencia() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoAparelho getTipoAparelho() {
        return tipoAparelho;
    }

    public void setTipoAparelho(TipoAparelho tipoAparelho) {
        this.tipoAparelho = tipoAparelho;
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
        if (!(object instanceof TipoDeficiencia)) {
            return false;
        }
        TipoDeficiencia other = (TipoDeficiencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ademoc.sgas.DomainModel.TipoDeficiencia[ id=" + id + " ]";
    }
}
