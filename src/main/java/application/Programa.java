package application;

import javax.persistence.*;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {

		Pessoa p1 = new Pessoa(null, "João Emboaba", "jemboaba17@gmail.com");
		Pessoa p2 = new Pessoa(null, "Amanda Amorim", "Amanda_amorim@gmail.com");
		Pessoa p3 = new Pessoa(null, "Eduardo martins", "edu0404ed@gmail.com");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		em.find(Pessoa.class, 2);

		em.getTransaction().begin();

		em.persist(p1);
		em.persist(p2);
		em.persist(p3);

		Pessoa p = new Pessoa(2, null, null);

		em.remove(p);

		em.getTransaction().commit();

		System.out.println("\nPronto");
		em.close();
		emf.close();

	}
}
