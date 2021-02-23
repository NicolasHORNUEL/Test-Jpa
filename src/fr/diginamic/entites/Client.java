package fr.diginamic.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="CLIENT")
public class Client {
	
	@Id
	private int id;
	
	@Column(name="NOM", length = 50, nullable = false)
	private String nom;
	
	@Column(name="PRENOM", length = 50, nullable = false)
	private String prenom;
	
	@OneToMany(mappedBy="client")
	private Set<Emprunt> emprunts;
	
	/**
	 * Constructeur sans argument
	 */
	public Client() {
		emprunts = new HashSet<Emprunt>();
	}

	@Override
	public String toString() {
		return "Client " + id + " : " + nom.toUpperCase() + " " + prenom + ".";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Set<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(Set<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}
	
	

}
