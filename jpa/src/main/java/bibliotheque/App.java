package bibliotheque;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entites.Livre;

public class App {

	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		System.out.println(em);

//		Find Livre in DB with ID
		Livre find = em.find(Livre.class, 2);
		if (find != null) {
		}

//		Insert new Livre into DB
		EntityTransaction et = em.getTransaction();
		et.begin();
//		Livre insert = new Livre();
//		insert.setTitre("Demon Slayer");
//		insert.setAuteur("Koyoharu Gotouge"); 
//		em.persist(insert);
//		et.commit();

//		Edit Livre in DB
		Livre edit = em.find(Livre.class, 5);
		if (edit != null) {
			edit.setTitre("Du plaisir dans la cuisine");
		}
//		et.commit();

//		Show Livre from DB with Titre
		TypedQuery<Livre> query1 = em.createQuery("select edit from Livre edit where edit.titre='Demon Slayer'",
				Livre.class);
		Livre l1 = query1.getResultList().get(0);
		System.out.println(l1);

// 		Show Livre frome DB with Auteur
		TypedQuery<Livre> query2 = em.createQuery("select edit from Livre edit where edit.auteur='Gaston Pouet'",
				Livre.class);
		Livre l2 = query2.getResultList().get(0);
		System.out.println(l2);

//		Remove Livre from DB with ID
		Livre remove = em.find(Livre.class, 1);
		if (remove != null) {
			em.remove(remove);
		}
//		et.commit();

		TypedQuery<Livre> query3 = em.createQuery("select edit from Livre edit", Livre.class);
		List<Livre> listeLivres = new ArrayList<>();
		listeLivres = query3.getResultList();
		
		for(Livre livre1 : listeLivres) {
			System.out.println(livre1.toString());
		}

		em.close();
		emf.close();
		LOGGER.info("Hello, world!!");
	}
}