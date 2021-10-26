package br.com.seteideias.loja.dao;

import br.com.seteideias.loja.modelo.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDao {

    private EntityManager em;

    public CategoriaDao(EntityManager em) {
        this.em = em;
    }
    public void cadastrar(Categoria categoria){
        this.em.persist(categoria);
    }

}
