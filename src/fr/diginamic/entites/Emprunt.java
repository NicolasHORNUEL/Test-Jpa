package fr.diginamic.entites;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="EMPRUNT")
public class Emprunt {
	
	@Id
	private int id;
	
	@Column(name="DATE_DEBUT", nullable = false)
	private Date date_debut;
	
	@Column(name="DATE_FIN", nullable = true)
	private Date date_fin;
	
	@Column(name="DELAI", length = 10, nullable = true)
	private Integer delai;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;
	
	@ManyToMany
	@JoinTable(name="COMPO",
		joinColumns= @JoinColumn(name="ID_EMP", referencedColumnName="ID"),
		inverseJoinColumns= @JoinColumn(name="ID_LIV", referencedColumnName="ID")
	)
	private Set<Livre> livres;
	
	/**
	 * Constructeur sans argument
	 */
	public Emprunt() {
	}

	@Override
	public String toString() {
		return "Emprunt " + id + " : de " + date_debut + " à " + date_fin + " - " + delai.toString() + " jours maxi pour le client " + client.getId() + ".";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public Integer getDelai() {
		return delai;
	}

	public void setDelai(Integer delai) {
		this.delai = delai;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<Livre> getLivres() {
		return livres;
	}

	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}

}
