package com.example.processo_zup.repository;

import com.example.processo_zup.model.Cliente;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ClienteCustomRepository {

    private final EntityManager em;


    public ClienteCustomRepository(EntityManager em) {
        this.em = em;
    }

    public List<Cliente> find(Long id, String nome, String cpf, String email, String dataNascimento){
        String query = "select C frm Clente as C";
        String condicao = "where";

        if (id != null){
            query += condicao + " C.id = :id";
            condicao = " and ";
        }

        if (nome != null){
            query += condicao + " C.nome = :nome";
            condicao = " and ";
        }

        if (cpf != null){
            query += condicao + " C.cpf = :cpf";
            condicao = " and ";
        }

        if (email != null){
            query += condicao + " C.email = :email";
            condicao = " and ";
        }

        if (dataNascimento != null){
            query += condicao + " C.dataNascimento = :dataNascimento";
        }

        TypedQuery<Cliente> q = em.createQuery(query, Cliente.class);

        if (id != null){
            q.setParameter("id", id);
        }

        if (nome != null){
            q.setParameter("nome", nome);
        }

        if (cpf != null){
            q.setParameter("cpf", cpf);
        }

        if (email != null){
            q.setParameter("email", email);
        }

        if (dataNascimento != null){
            q.setParameter("dataNascimento", dataNascimento);
        }

        return q.getResultList();

    }
}
