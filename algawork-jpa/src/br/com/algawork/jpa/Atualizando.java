package br.com.algawork.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.algawork.jpa.modelo.Cliente;

public class Atualizando {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();
		
		Cliente cliente = em.find(Cliente.class, 3L);
		
		em.getTransaction().begin();
		cliente.setNome("Paula Geraldinni");
		em.getTransaction().commit();
		
		System.out.println("Cliente alterado");

	}

}
