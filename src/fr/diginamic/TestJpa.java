package fr.diginamic;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.diginamic.entites.Client;
import fr.diginamic.entites.Emprunt;
import fr.diginamic.entites.Livre;

public class TestJpa {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mySQL");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Livre livre = em.find(Livre.class, 1);
		if (livre != null) {
			System.out.println(livre);
		}
		
		Emprunt emprunt = em.find(Emprunt.class, 1);
		if (emprunt != null) {
			Set<Livre> livres = emprunt.getLivres();
			for (Livre elt : livres) {
				System.out.println(elt);
			}
		}
		
		Client client = em.find(Client.class, 1);
		if (client != null) {
			Set<Emprunt> emprunts = client.getEmprunts();
			for (Emprunt elt : emprunts) {
				System.out.println(elt);
			}
		}
		
		
		
	}

}
