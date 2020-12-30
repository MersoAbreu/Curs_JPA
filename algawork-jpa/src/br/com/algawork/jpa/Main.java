package br.com.algawork.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.algawork.jpa.modelo.Cliente;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();
		
		
		Cliente cliente = new Cliente();
		cliente.setIdade(63);
		cliente.setNome("Alan Pereira da Silva");
		cliente.setProfissao("Operador de motobomba");
		cliente.setSexo("M");
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		
		System.out.println("Cliente criado com sucesso");
		//em.close();

	}

}
