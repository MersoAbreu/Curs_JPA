package br.com.algawork.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.algawork.jpa.modelo.Cliente;

public class Remover {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();
		
		Cliente cliente = em.find(Cliente.class, 4L);
		em.getTransaction().begin();
		em.remove(cliente);
		em.getTransaction().commit();

		System.out.println("Objeto removido");
	}

}
