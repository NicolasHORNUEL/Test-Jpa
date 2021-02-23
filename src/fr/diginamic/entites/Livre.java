package fr.diginamic.entites;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="LIVRE")
public class Livre {
	
	@Id
	private int id;
	
	@Column(name="TITRE", length = 255, nullable = false)
	private String titre;
	
	@Column(name="AUTEUR", length = 50, nullable = false)
	private String auteur;
	
	@ManyToMany
	@JoinTable(name="COMPO",
		joinColumns= @JoinColumn(name="ID_LIV", referencedColumnName="ID"),
		inverseJoinColumns= @JoinColumn(name="ID_EMP", referencedColumnName="ID")
	)
	private Set<Emprunt> emprunts;
	
	/**
	 * Constructeur sans argument
	 */
	public Livre() {
	}

	@Override
	public String toString() {
		return "Livre " + id + " : " + titre + ", " + auteur + ".";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public Set<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(Set<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}
	

}
