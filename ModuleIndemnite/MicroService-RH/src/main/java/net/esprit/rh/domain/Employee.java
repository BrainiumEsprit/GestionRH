package net.esprit.rh.domain;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matricule", nullable = false, updatable = false)
    private Long matricule;

    // Username with unique constraint
    @Column(name = "nom", nullable = false, unique = true)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "salaire", nullable = false)
    private int  salaire;
       

    public Long getMatricule() {
		return matricule;
	}


	public void setMatricule(Long matricule) {
		this.matricule = matricule;
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


	public int getSalaire() {
		return salaire;
	}


	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}


	public Employee(Long matricule, String nom, String prenom, int salaire) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.salaire = salaire;
	}


	public Employee() {
    }


	
}