package br.com.seteideias.loja.testes;

import br.com.seteideias.loja.dao.CategoriaDao;
import br.com.seteideias.loja.dao.ProdutoDao;
import br.com.seteideias.loja.modelo.Categoria;
import br.com.seteideias.loja.modelo.Produto;
import br.com.seteideias.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroDeProduto {

    public static void main(String[] args) {

        Categoria celulares = new Categoria("celulares");

        Produto celular = new Produto("Xiome","Celular A",new BigDecimal("1005.00"),
                celulares);

//        EntityManagerFactory factory = Persistence. createEntityManagerFactory("loja");
//        EntityManager em = factory.createEntityManager();

        EntityManager em = JPAUtil.getEntityManager();

        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();
//        em.persist(celular); já nao preciso mais disso
        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
    }

}
