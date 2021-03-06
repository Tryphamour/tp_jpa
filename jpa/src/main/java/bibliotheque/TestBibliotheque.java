package bibliotheque;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entites.Client;
import entites.Emprunt;
import entites.Livre;

public class TestBibliotheque {

	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		Emprunt emprunt = em.find(Emprunt.class, 1);
		Client client = em.find(Client.class, 3);
		em.getTransaction().begin();
		em.getTransaction().commit();
		for (Livre livre : emprunt.getLivres()) {
			System.err.println(livre.toString());
		}
		for (Emprunt emp : client.getEmprunts()) {
			System.err.println(emp.toString());
		}
		em.close();
		emf.close();
	}

}