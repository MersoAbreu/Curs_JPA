package com.banco.algawork;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.banco.algawork.modelo.Conta;



public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bancoTabajaraPU");
		EntityManager em = emf.createEntityManager();
		
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		Conta conta1 = em.find(Conta.class, 1L);
		if(conta1== null) {
			System.out.println("Digite o saldo inicial da conta 1:");
			Double saldoInicialConta1 = entrada.nextDouble();
			conta1 = new Conta();
			conta1.setSaldo(saldoInicialConta1);
		}
		
		Conta conta2 = em.find(Conta.class, 2L);
		if(conta2 == null) {
			System.out.println("Digite o saldo inicial da conta 2:");
			Double saldoInicialConta2 = entrada.nextDouble();
			conta2 = new Conta();
			conta2.setSaldo(saldoInicialConta2 );
		}
		em.getTransaction().begin();
		em.persist(conta1);
		em.persist(conta2);
		em.getTransaction().commit();
		
		System.out.println("Saldo conta 1: "+conta1.getSaldo());
		System.out.println("Saldo conta 2: "+conta2.getSaldo());

		
		System.out.println("-------------------------------------------------------------");
		System.out.println("Digite o valor a retirar da conta 1 e depositar na conta 2");
		Double valorTransferencia = entrada.nextDouble();
		
		em.getTransaction().begin();
		conta1.setSaldo(conta1.getSaldo()-valorTransferencia);
		conta2.setSaldo(conta2.getSaldo()+valorTransferencia);
		
		if(conta1.getSaldo()>0) {
			em.getTransaction().commit();
			System.out.println("Transferencia realizada com sucesso");
		}else {
			em.getTransaction().rollback();
			System.err.println("Transferencia não realizada, saldo insuficiente!");
		}
	}

}