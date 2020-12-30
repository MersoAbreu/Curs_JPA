package br.com.algawork.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.algawork.jpa.modelo.Cliente;

public class ConsultaJPQL {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();
		
		List<Cliente> clientes = em.createQuery("from Cliente order by nome ", Cliente.class)
				.getResultList();
		for(Cliente cliente : clientes) {
			System.out.println("Codigo: "+cliente.getCodigo());
			System.out.println("Nome: "+cliente.getNome());
			System.out.println("Idade: "+cliente.getIdade());
			System.out.println("Profissão: "+cliente.getProfissao());
			System.out.println("-----------------------------------------------------------------------------------");
		}

	}

}
