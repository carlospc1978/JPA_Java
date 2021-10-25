package br.com.seteideias.loja.testes;

import br.com.seteideias.loja.modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroDeProduto {

    public static void main(String[] args) {
        Produto celular = new Produto();
        celular.setNome("Xiomi");
        celular.setDescricao("celular A");
        celular.setPreco(new BigDecimal("1005.00"));

        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("loja");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(celular);
        em.getTransaction().commit();
        em.close();
    }

}
