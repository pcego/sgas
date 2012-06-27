/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgascliente.web;

import br.com.ademoc.sgas.DomainModel.IRepositorioCategoria;
import br.com.ademoc.sgas.DomainModel.Categoria;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author www
 */
@Named(value = "categoriaBean")
@RequestScoped
public class CategoriaBean implements Serializable {

    @EJB
    IRepositorioCategoria repo;
    private String codigo;
    private String descricao;
    List<Categoria> listagem;

    public List<Categoria> getListagem() {
        if (listagem == null) {
            listagem = repo.listaTodas();
        }
        return listagem;
    }

    public void setListagem(List<Categoria> listagem) {
        this.listagem = listagem;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void salvar() {
        Categoria categoria = new Categoria();

        categoria.setDescricao(descricao);

        boolean confirme;
        confirme = repo.salvar(categoria);

        if (confirme == true) {
            FacesMessage message = new FacesMessage("Salvo com Sucesso");

            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage message = new FacesMessage("ERRO so Salvar, verifique os campos, ou tente novamente mais tarde");

            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void apagar() {
        Categoria categoria = new Categoria();
        Long id = Long.parseLong(codigo);
        categoria.setId(id);

        boolean confirme;

        confirme = repo.apagar(categoria);


        if (confirme == true) {
            FacesMessage message = new FacesMessage("Excluido com Sucesso");

            FacesContext.getCurrentInstance().addMessage(null, message);
        } else if (confirme == false) {
            FacesMessage message = new FacesMessage("ERRO ao Excluir, verifique os campos, ou tente novamente mais tarde");

            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public CategoriaBean() {
    }
}
