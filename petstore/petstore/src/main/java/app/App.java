package app;

import java.sql.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entites.Adress;
import entites.Animal;
import entites.Cat;
import entites.Fish;
import entites.FishLivEnv;
import entites.PetStore;
import entites.ProdType;
import entites.Product;

public class App {

	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore");
		EntityManager em = emf.createEntityManager();
		// Produits
		Product product1 = new Product("aa", "la", 10, ProdType.FOOD);
		Product product2 = new Product("bb", "lb", 20, ProdType.ACCESSORY);
		Product product3 = new Product("cc", "lc", 30, ProdType.CLEANING);

		// PetStore
		PetStore petstore1 = new PetStore("le a", "A a", new Adress("1", "rue a", "10000", "Aaaa"));
		PetStore petstore2 = new PetStore("le b", "B b", new Adress("2", "rue b", "20000", "Bbbb"));
		PetStore petstore3 = new PetStore("le c", "C c", new Adress("3", "rue c", "30000", "Cccc"));

		// Animaux
		@SuppressWarnings("deprecation")
		Animal chat = new Cat(new Date(121, 10, 20), "kalinko", "a1AA");
		@SuppressWarnings("deprecation")
		Animal poisson1 = new Fish(new Date(121, 11, 21), "rouge", FishLivEnv.FRESH_WATER);
		@SuppressWarnings("deprecation")
		Animal poisson2 = new Fish(new Date(121, 12, 22), "jaune", FishLivEnv.SEA_WATER);

		em.getTransaction().begin();
		em.persist(product1);
		em.persist(product2);
		em.persist(product3);

		em.persist(petstore1);
		em.persist(petstore2);
		em.persist(petstore3);

		petstore1.addAnimal(chat);
		petstore1.addAnimal(poisson1);
		petstore1.addAnimal(poisson2);

		product1.addPetStore(petstore2);

		em.getTransaction().commit();

		em.close();
		emf.close();
	}

}