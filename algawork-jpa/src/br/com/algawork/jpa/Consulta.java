package br.com.algawork.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.algawork.jpa.modelo.Cliente;

public class Consulta {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");

		EntityManager em = emf.createEntityManager();

		Cliente cliente = em.find(Cliente.class, 5L);
		if (cliente != null) {
			System.out.println("Nome: " + cliente.getNome());
			System.out.println("Idade " + cliente.getIdade());
			System.out.println("Profissão " + cliente.getProfissao());
		}else {
			System.out.println("Cliente não encontrado");
		}
	}

}
